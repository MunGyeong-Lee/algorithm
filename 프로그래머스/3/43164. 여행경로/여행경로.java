import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 인접 리스트로 그래프 구성 (알파벳 순으로 정렬하기)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // 그래프 초기화
        for(String[] ticket: tickets){
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        
        // 결과 저장할 리스트
        List<String> result = new ArrayList<>();
        
        //DFS로 경로 탐색
        dfs("ICN", graph, result);
        
        // 결과를 뒤집어서 올바른 순서로 만들기
        Collections.reverse(result);
        
        return result.toArray(new String[0]);
        
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>>graph, List<String> result){
        PriorityQueue<String> destinations = graph.get(airport);
        
        // 현재 공항에서 갈 수 있는 모든 목적지 방문
        while(destinations != null && !destinations.isEmpty()){
            String next = destinations.poll() ; // 알파벳 순으로 가장 앞선 목적지 제거
            dfs(next, graph, result);
        }
        
        // 더이상 갈 곳 없으면 현재 공항을 결과에 추가
        result.add(airport);
    }
}