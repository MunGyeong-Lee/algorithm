import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {

        // 노드 개수 하기
        int nodeCount = 0;
        for(int[] nodes : edges){
            nodeCount = Math.max(nodeCount,Math.max(nodes[0], nodes[1]));
        }

        // 각 정점 별로 [출차수, 입차수] 구하기
        int[][] inOutDegree= new int[nodeCount+1][2]; 
        for(int[] edge : edges){

            int from = edge[0];
            int to = edge[1];

            inOutDegree[from][0]++;
            inOutDegree[to][1]++;

        }

        // 생성한 정점: 출차수 - 입차수 > 1인 정점
        int newNode = 0;
        for(int i = 1; i <= nodeCount ; i++){
            if(inOutDegree[i][0] - inOutDegree[i][1] > 1){
                newNode = i;
                break;  // 생성정점은 하나뿐이므로 찾으면 바로 종료
            }
        }

        // 그래프 종류 구하기 (간선 제거 없이 원본 상태에서 판별)
        int donut = 0;
        int stick = 0;
        int eight = 0;

        // 그래프 종류 판별
        for(int i = 1; i <= nodeCount; i++){
            if(i == newNode) continue; // 생성된 정점은 제외

            int outDegree = inOutDegree[i][0];
            int inDegree = inOutDegree[i][1];

            // 8자 그래프: 입차수 >= 2, 출차수 >= 2인 정점 (중심점)
            if(inDegree >= 2 && outDegree >= 2){
                eight++;
            }
            // 막대 그래프: 출차수가 0이고 입차수 > 0인 정점 (끝점)
            else if(outDegree == 0 && inDegree > 0){
                stick++;
            }
        }

        donut = inOutDegree[newNode][0] - stick - eight;

        return new int[] {newNode, donut, stick, eight};

    }
}