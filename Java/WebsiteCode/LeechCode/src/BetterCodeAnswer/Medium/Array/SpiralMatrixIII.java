package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int[][] tests = {
            {1,4,0,0}
        };

        for (int[] test : tests) {
            int rows = test[0],
                cols = test[1],
                rStart = test[2],
                cStart = test[3];

            System.out.println(Arrays.deepToString(
                new SpiralMatrixIII_Solution().spiralMatrixIII(rows, cols, rStart, cStart)
            ));
        }
    }
}

// 1ms 44.82MB
class SpiralMatrixIII_Solution {
    int minX, minY, maxX, maxY, index;
    
        int[][] result;
    
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            
            int n = cols * rows;
            result = new int[n][];
    
            minX = cStart;
            maxX = cStart + 1;
            minY = rStart;
            maxY = rStart;
            index = 0;
            result[index++] = new int[]{rStart, cStart};
    
            while (true) {
                if (minY >= 0){
                    right(Math.max(0, minX + 1), Math.min(cols - 1, maxX));
                } 
                maxY++;
                if (index >= n) break;
    
                if (maxX < cols) down(Math.max(0, minY + 1), Math.min(rows - 1, maxY));
                minX--;
                if (index >= n) break;
    
                if (maxY < rows) left(Math.min(cols - 1, maxX - 1), Math.max(0, minX));
                minY--;
                if (index >= n) break;
    
                if (minX >= 0) up(Math.min(rows - 1, maxY - 1), Math.max(0, minY));
                maxX++;
                if (index >= n) break;
            }
            return result;
        }
    
        public void right(int start, int end) {
            for (int i = start; i <= end; i++) 
                result[index++] = new int[]{minY, i};
        }
    
        public void left(int start, int end) {
            for (int i = start; i >= end; i--) 
               result[index++] = new int[]{maxY, i};
        }
    
        public void down(int start, int end) {
            for (int i = start; i <= end; i++) 
                result[index++] = new int[]{i, maxX};
        }
    
        public void up(int start, int end) {
            for (int i = start; i >= end; i--) 
               result[index++] = new int[]{i, minX};
        }
    }