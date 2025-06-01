import java.util.*;

/**
 * 퍼즐 게임 해결 알고리즘 - 최적화 버전
 * 핵심 최적화: 백트래킹 대신 그리디 매칭 + 이분 매칭 사용
 */
class Solution {
    
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        // 1. 빈 공간과 퍼즐 조각 찾기
        List<List<int[]>> emptySpaces = findShapes(game_board, 0);
        List<List<int[]>> puzzles = findShapes(table, 1);
        
        // 2. 모든 빈 공간과 퍼즐의 정규화된 형태 미리 계산
        List<String> spaceSignatures = new ArrayList<>();
        List<Integer> spaceSizes = new ArrayList<>();
        
        for(List<int[]> space : emptySpaces) {
            spaceSignatures.add(normalizeShape(space));
            spaceSizes.add(space.size());
        }
        
        // 3. 각 퍼즐의 모든 회전 형태 계산
        List<Set<String>> puzzleSignatures = new ArrayList<>();
        List<Integer> puzzleSizes = new ArrayList<>();
        
        for(List<int[]> puzzle : puzzles) {
            Set<String> rotations = getAllRotations(puzzle);
            puzzleSignatures.add(rotations);
            puzzleSizes.add(puzzle.size());
        }
        
        // 4. 크기별로 사전 필터링하여 불가능한 매칭 제거
        List<List<Integer>> possibleMatches = new ArrayList<>();
        for(int i = 0; i < emptySpaces.size(); i++) {
            List<Integer> matches = new ArrayList<>();
            for(int j = 0; j < puzzles.size(); j++) {
                // 크기가 같고 형태가 일치하는지 확인
                if(spaceSizes.get(i).equals(puzzleSizes.get(j)) && 
                   puzzleSignatures.get(j).contains(spaceSignatures.get(i))) {
                    matches.add(j);
                }
            }
            possibleMatches.add(matches);
        }
        
        // 5. 최대 매칭 찾기 (그리디 방식)
        return findMaxMatching(possibleMatches, spaceSizes, puzzles.size());
    }
    
    /**
     * 그리디 방식으로 최대 매칭 찾기
     * 매칭 가능한 퍼즐이 적은 빈 공간부터 우선 처리
     */
    private int findMaxMatching(List<List<Integer>> possibleMatches, 
                               List<Integer> spaceSizes, int puzzleCount) {
        
        boolean[] usedPuzzles = new boolean[puzzleCount];
        int totalScore = 0;
        
        // 매칭 가능한 퍼즐 수가 적은 순으로 정렬된 인덱스 생성
        List<Integer> spaceOrder = new ArrayList<>();
        for(int i = 0; i < possibleMatches.size(); i++) {
            spaceOrder.add(i);
        }
        spaceOrder.sort((a, b) -> possibleMatches.get(a).size() - possibleMatches.get(b).size());
        
        // 제약이 많은 공간부터 매칭 시도
        for(int spaceIdx : spaceOrder) {
            List<Integer> candidates = possibleMatches.get(spaceIdx);
            
            // 사용되지 않은 퍼즐 중에서 첫 번째로 매칭되는 것 선택
            for(int puzzleIdx : candidates) {
                if(!usedPuzzles[puzzleIdx]) {
                    usedPuzzles[puzzleIdx] = true;
                    totalScore += spaceSizes.get(spaceIdx);
                    break;
                }
            }
        }
        
        return totalScore;
    }
    
    /**
     * BFS로 연결된 영역 찾기 (기존과 동일하지만 주석 간소화)
     */
    private List<List<int[]>> findShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == target && !visited[i][j]) {
                    List<int[]> shape = bfs(board, visited, i, j, target);
                    shapes.add(shape);
                }
            }
        }
        return shapes;
    }
    
    /**
     * BFS 구현부 분리
     */
    private List<int[]> bfs(int[][] board, boolean[][] visited, int startX, int startY, int target) {
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            shape.add(curr);
            
            for(int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                
                if(isValid(board, nx, ny) && !visited[nx][ny] && board[nx][ny] == target) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return shape;
    }
    
    /**
     * 경계 체크 함수
     */
    private boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
    
    /**
     * 도형의 모든 회전 형태를 문자열 Set으로 반환
     */
    private Set<String> getAllRotations(List<int[]> shape) {
        Set<String> rotations = new HashSet<>();
        List<int[]> current = deepCopy(shape);
        
        for(int i = 0; i < 4; i++) {
            rotations.add(normalizeShape(current));
            current = rotate90(current);
        }
        
        return rotations;
    }
    
    /**
     * 최적화된 정규화 함수
     * 불필요한 ArrayList 생성을 줄이고 직접 StringBuilder 사용
     */
    private String normalizeShape(List<int[]> shape) {
        if(shape.isEmpty()) return "";
        
        // 최소 좌표 찾기
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] pos : shape) {
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }
        
        // 정규화된 좌표들을 TreeSet에 저장하여 자동 정렬
        Set<String> normalizedCoords = new TreeSet<>();
        for(int[] pos : shape) {
            int x = pos[0] - minX;
            int y = pos[1] - minY;
            normalizedCoords.add(x + "," + y);
        }
        
        // 정렬된 좌표들을 문자열로 결합
        return String.join(";", normalizedCoords);
    }
    
    /**
     * 90도 회전 (기존과 동일)
     */
    private List<int[]> rotate90(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for(int[] pos : shape) {
            rotated.add(new int[]{pos[1], -pos[0]});
        }
        return rotated;
    }
    
    /**
     * 깊은 복사 (기존과 동일)
     */
    private List<int[]> deepCopy(List<int[]> shape) {
        List<int[]> copy = new ArrayList<>();
        for(int[] pos : shape) {
            copy.add(new int[]{pos[0], pos[1]});
        }
        return copy;
    }
}