public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for (int j = 0; j < col; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
    }
}
