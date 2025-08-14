import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 피로도 테이블
        Map<String, int[]> fatigueMap = new HashMap<>();
        fatigueMap.put("diamond", new int[]{1, 5, 25});  // 다이아몬드 곡괭이로 캘 때
        fatigueMap.put("iron", new int[]{1, 1, 5});      // 철 곡괭이로 캘 때
        fatigueMap.put("stone", new int[]{1, 1, 1});     // 돌 곡괭이로 캘 때
        
        // 총 곡괭이 개수
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 실제로 캘 수 있는 광물 개수 (곡괭이 개수 * 5)
        int maxMineable = Math.min(minerals.length, totalPicks * 5);
        
        // 광물을 5개씩 그룹으로 나누고 각 곡괭이별 피로도 계산
        List<Group> groups = new ArrayList<>();
        
        for (int i = 0; i < maxMineable; i += 5) {
            int[] costs = new int[3]; // [다이아몬드, 철, 돌]
            
            // 현재 그룹의 광물들에 대해 각 곡괭이별 피로도 계산
            for (int j = i; j < Math.min(i + 5, maxMineable); j++) {
                String mineral = minerals[j];
                costs[0] += fatigueMap.get(mineral)[0]; // 다이아몬드 곡괭이
                costs[1] += fatigueMap.get(mineral)[1]; // 철 곡괭이
                costs[2] += fatigueMap.get(mineral)[2]; // 돌 곡괭이
            }
            
            groups.add(new Group(i / 5 + 1, costs));
        }
        
        // 돌 곡괭이로 캤을 때 피로도가 높은 순으로 정렬
        // (어려운 그룹일수록 좋은 곡괭이를 먼저 사용)
        groups.sort((a, b) -> b.costs[2] - a.costs[2]);
        
        int totalFatigue = 0;
        int[] availablePicks = {picks[0], picks[1], picks[2]}; // [다이아몬드, 철, 돌]
        
        // 각 그룹에 대해 가장 좋은 곡괭이 배정
        for (Group group : groups) {
            boolean used = false;
            
            // 다이아몬드 곡괭이부터 시도
            for (int pickType = 0; pickType < 3; pickType++) {
                if (availablePicks[pickType] > 0) {
                    totalFatigue += group.costs[pickType];
                    availablePicks[pickType]--;
                    used = true;
                    break;
                }
            }
            
            if (!used) break; // 더 사용할 곡괭이가 없으면 종료
        }
        
        return totalFatigue;
    }
    
    // 그룹 정보를 담는 클래스
    static class Group {
        int groupNumber;
        int[] costs; // [다이아몬드, 철, 돌] 곡괭이별 피로도
        
        Group(int groupNumber, int[] costs) {
            this.groupNumber = groupNumber;
            this.costs = costs;
        }
    }
    
    // 테스트 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // 테스트 케이스 1
        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        
        System.out.println("=== 테스트 케이스 1 ===");
        System.out.println("picks: " + Arrays.toString(picks1));
        System.out.println("minerals: " + Arrays.toString(minerals1));
        System.out.println("결과: " + sol.solution(picks1, minerals1));
        
        // 단계별 분석
        System.out.println("\n=== 단계별 분석 ===");
        solutionWithDebug(picks1, minerals1);
    }
    
    // 디버그용 메서드
    public static void solutionWithDebug(int[] picks, String[] minerals) {
        Map<String, int[]> fatigueMap = new HashMap<>();
        fatigueMap.put("diamond", new int[]{1, 5, 25});
        fatigueMap.put("iron", new int[]{1, 1, 5});
        fatigueMap.put("stone", new int[]{1, 1, 1});
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMineable = Math.min(minerals.length, totalPicks * 5);
        
        System.out.println("1. 총 곡괭이 개수: " + totalPicks + "개");
        System.out.println("2. 실제 캘 수 있는 광물: " + maxMineable + "개");
        
        List<Group> groups = new ArrayList<>();
        
        System.out.println("\n3. 각 그룹별 피로도:");
        for (int i = 0; i < maxMineable; i += 5) {
            int[] costs = new int[3];
            List<String> groupMinerals = new ArrayList<>();
            
            for (int j = i; j < Math.min(i + 5, maxMineable); j++) {
                String mineral = minerals[j];
                groupMinerals.add(mineral);
                costs[0] += fatigueMap.get(mineral)[0];
                costs[1] += fatigueMap.get(mineral)[1];
                costs[2] += fatigueMap.get(mineral)[2];
            }
            
            Group group = new Group(i / 5 + 1, costs);
            groups.add(group);
            
            System.out.println("   그룹 " + group.groupNumber + ": " + groupMinerals);
            System.out.println("   피로도 - 다이아: " + costs[0] + ", 철: " + costs[1] + ", 돌: " + costs[2]);
        }
        
        groups.sort((a, b) -> b.costs[2] - a.costs[2]);
        
        System.out.println("\n4. 우선순위 정렬 후 (돌 곡괭이 피로도 높은 순):");
        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            System.out.println("   " + (i + 1) + "순위: 그룹 " + group.groupNumber + " (돌 곡괭이 피로도: " + group.costs[2] + ")");
        }
        
        int totalFatigue = 0;
        int[] availablePicks = {picks[0], picks[1], picks[2]};
        String[] pickNames = {"다이아몬드", "철", "돌"};
        
        System.out.println("\n5. 곡괭이 배정:");
        for (Group group : groups) {
            boolean used = false;
            
            for (int pickType = 0; pickType < 3; pickType++) {
                if (availablePicks[pickType] > 0) {
                    System.out.println("   그룹 " + group.groupNumber + "에 " + pickNames[pickType] + " 곡괭이 사용 (피로도: " + group.costs[pickType] + ")");
                    totalFatigue += group.costs[pickType];
                    availablePicks[pickType]--;
                    used = true;
                    break;
                }
            }
            
            if (!used) {
                System.out.println("   그룹 " + group.groupNumber + ": 사용할 곡괭이 없음");
                break;
            }
        }
        
        System.out.println("\n최종 결과: " + totalFatigue);
    }
}