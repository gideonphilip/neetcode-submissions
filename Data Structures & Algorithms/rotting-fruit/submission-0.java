class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else{
                    continue;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++){
                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];

                for(int[] d : directions){
                    int newX = x + d[0];
                    int newY = y + d[1];

                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        fresh--;
                    }
                } 
            }
        }
        return fresh == 0 ? time : -1;

        
    }
}
