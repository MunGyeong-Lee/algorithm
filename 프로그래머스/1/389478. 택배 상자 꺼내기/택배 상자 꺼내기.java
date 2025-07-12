class Solution {
    public int solution(int n, int w, int num) {
        
        int layer = (num - 1) / w + 1;
        
       
        int positionInLayer = (num - 1) % w + 1;
        
        
        int actualColumn;
        if (layer % 2 == 1) {
            actualColumn = positionInLayer;
        } else {
            actualColumn = w - positionInLayer + 1;
        }
        
        int count = 1; 
        

        for (int currentLayer = layer + 1; currentLayer <= (n - 1) / w + 1; currentLayer++) {
            
            int startBoxOfLayer = (currentLayer - 1) * w + 1;
            int endBoxOfLayer = Math.min(currentLayer * w, n);
            
           
            if (startBoxOfLayer <= n) {
                int boxAtPosition;
                if (currentLayer % 2 == 1) {
                    
                    boxAtPosition = startBoxOfLayer + actualColumn - 1;
                } else {
                    
                    boxAtPosition = startBoxOfLayer + (w - actualColumn);
                }
                
               
                if (boxAtPosition <= endBoxOfLayer) {
                    count++;
                }
            }
        }
        
        return count;
    }
}