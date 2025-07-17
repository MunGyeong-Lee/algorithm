import java.util.*;

class Solution {
    int r, c;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int minTurn = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        r = maze.length;
        c = maze[0].length;
        
        redVisited = new boolean[r][c];
        blueVisited = new boolean[r][c];
        
        int[] redStart = new int[2];
        int[] blueStart = new int[2];
        int[] redEnd = new int[2];
        int[] blueEnd = new int[2];
        
        // 시작점과 도착점 찾기
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(maze[i][j] == 1){
                    redStart[0] = i; redStart[1] = j;
                }
                if(maze[i][j] == 2){
                    blueStart[0] = i; blueStart[1] = j;
                }
                if(maze[i][j] == 3){
                    redEnd[0] = i; redEnd[1] = j;
                }
                if(maze[i][j] == 4){
                    blueEnd[0] = i; blueEnd[1] = j;
                }
            }
        }
        
        // 시작점 방문 표시
        redVisited[redStart[0]][redStart[1]] = true;
        blueVisited[blueStart[0]][blueStart[1]] = true;
        
        dfs(maze, redStart[0], redStart[1], blueStart[0], blueStart[1], 
            redEnd[0], redEnd[1], blueEnd[0], blueEnd[1], 0);
        
        return minTurn == Integer.MAX_VALUE ? 0 : minTurn;
    }
    
    public void dfs(int[][] maze, int redR, int redC, int blueR, int blueC,
                   int redEndR, int redEndC, int blueEndR, int blueEndC, int turn) {
        
        // 가지치기: 현재 턴이 이미 찾은 최소값보다 크면 중단
        if(turn >= minTurn) return;
        
        // 목표 도달 체크
        if(redR == redEndR && redC == redEndC && blueR == blueEndR && blueC == blueEndC) {
            minTurn = Math.min(minTurn, turn);
            return;
        }
        
        // 빨간색이 도착한 경우 - 파란색만 이동
        if(redR == redEndR && redC == redEndC) {
            for(int i = 0; i < 4; i++) {
                int nextBlueR = blueR + dx[i];
                int nextBlueC = blueC + dy[i];
                
                if(isValidMove(maze, nextBlueR, nextBlueC, redR, redC, blueVisited)) {
                    blueVisited[nextBlueR][nextBlueC] = true;
                    dfs(maze, redR, redC, nextBlueR, nextBlueC, 
                        redEndR, redEndC, blueEndR, blueEndC, turn + 1);
                    blueVisited[nextBlueR][nextBlueC] = false; // 백트래킹
                }
            }
        }
        // 파란색이 도착한 경우 - 빨간색만 이동
        else if(blueR == blueEndR && blueC == blueEndC) {
            for(int i = 0; i < 4; i++) {
                int nextRedR = redR + dx[i];
                int nextRedC = redC + dy[i];
                
                if(isValidMove(maze, nextRedR, nextRedC, blueR, blueC, redVisited)) {
                    redVisited[nextRedR][nextRedC] = true;
                    dfs(maze, nextRedR, nextRedC, blueR, blueC, 
                        redEndR, redEndC, blueEndR, blueEndC, turn + 1);
                    redVisited[nextRedR][nextRedC] = false; // 백트래킹
                }
            }
        }
        // 둘 다 도착 안한 경우 - 둘 다 이동
        else {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    int nextRedR = redR + dx[i];
                    int nextRedC = redC + dy[i];
                    int nextBlueR = blueR + dx[j];
                    int nextBlueC = blueC + dy[j];
                    
                    if(isValidBothMove(maze, nextRedR, nextRedC, nextBlueR, nextBlueC,
                                     redR, redC, blueR, blueC)) {
                        
                        redVisited[nextRedR][nextRedC] = true;
                        blueVisited[nextBlueR][nextBlueC] = true;
                        
                        dfs(maze, nextRedR, nextRedC, nextBlueR, nextBlueC, 
                            redEndR, redEndC, blueEndR, blueEndC, turn + 1);
                        
                        redVisited[nextRedR][nextRedC] = false; // 백트래킹
                        blueVisited[nextBlueR][nextBlueC] = false; // 백트래킹
                    }
                }
            }
        }
    }
    
    // 단일 수레 이동 유효성 검사
    private boolean isValidMove(int[][] maze, int nextR, int nextC, 
                               int otherR, int otherC, boolean[][] visited) {
        // 경계 체크
        if(nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) return false;
        
        // 벽 체크
        if(maze[nextR][nextC] == 5) return false;
        
        // 자기 방문 체크
        if(visited[nextR][nextC]) return false;
        
        // 다른 수레와 같은 위치 체크
        if(nextR == otherR && nextC == otherC) return false;
        
        return true;
    }
    
    // 두 수레 동시 이동 유효성 검사
    private boolean isValidBothMove(int[][] maze, int nextRedR, int nextRedC, 
                                   int nextBlueR, int nextBlueC,
                                   int redR, int redC, int blueR, int blueC) {
        // 경계 체크
        if(nextRedR < 0 || nextRedR >= r || nextRedC < 0 || nextRedC >= c ||
           nextBlueR < 0 || nextBlueR >= r || nextBlueC < 0 || nextBlueC >= c) {
            return false;
        }
        
        // 벽 체크
        if(maze[nextRedR][nextRedC] == 5 || maze[nextBlueR][nextBlueC] == 5) {
            return false;
        }
        
        // 자기 방문 체크
        if(redVisited[nextRedR][nextRedC] || blueVisited[nextBlueR][nextBlueC]) {
            return false;
        }
        
        // 같은 칸으로 이동 체크
        if(nextRedR == nextBlueR && nextRedC == nextBlueC) return false;
        
        // 자리 바꿈 체크
        if(nextRedR == blueR && nextRedC == blueC && 
           nextBlueR == redR && nextBlueC == redC) {
            return false;
        }
        
        return true;
    }
}