import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
//         classic:1450 , pop: 3100, 
//         장르별 재생 수 합 맵으로 정리
        Map<String, Integer> count = new HashMap<>();
       for(int i = 0 ; i < genres.length ; i ++){
           String key = genres[i];
           count.put(key,count.getOrDefault(key, 0)+plays[i]);
       }
        
//         classic: 3, 0 pop: 4, 1
//         장르별로 재생된 노래 내림차순으로 정렬 단, 2개만 넣기, 만약 같은 횟수면 인덱스가 작은 값을 먼저
        Map<String, List<int[]>> order = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            order.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new int[]{i, plays[i]}); // [인덱스, 재생홧수]
        }
        
        for(String genre: order.keySet()){
            List<int[]> songs = order.get(genre);
            
            // 정렬
            songs.sort((a,b)->{
                if(a[1] != b[1]) return b[1] - a[1]; // 재생횟수 내림차순
                return a[0] - b[0]; // 인덱스 오름차순
            });
            
            if(songs.size() > 2){
                order.put(genre, songs.subList(0, 2));
            }
        }
        
//         [pop, classic]
//         순서를 먼저 만듦
        List<String> orderByTotal = new ArrayList<>(count.keySet());
        orderByTotal.sort((a,b) -> count.get(b) - count.get(a));
        
//             [4,1,3,0]
//         그다음 배열을 돌아서 pop 의 밸류들 넣기
        List<Integer>result = new ArrayList<>();
        for(String genre : orderByTotal){        
            List<int[]> songs = order.get(genre); 
                for(int[] song : songs){
                    result.add(song[0]);        
            }
        }
        
        return  result.stream().mapToInt(i -> i).toArray();
            
    }
}