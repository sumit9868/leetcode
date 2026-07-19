package interview.walmart;
/**
 * Input: board = [ ["A","B","C","E"],
 *                  ["S","F","C","S"],
 *                  ["A","D","E","E"]],
 * word = "ABCCED" , idx
 * Output: true
 *
 * Input: board = [["A","B","C","E"],
 *                  ["S","F","C","S"],
 *                  ["A","D","E","E"]],
 * word = "ABCB"Output: false
 * */
public class InBorardOrNot {
    private int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(board,i,j,word,0,new int[m][n])){
                        return true;
                    }
                }
            }
        }

        // O(m*n) -> dfs
        return false;
    }

    private boolean dfs(char[][] board,int i,int j,String word, int idx,int[][] visited){
        if(idx==word.length()){
            return true;
        }
        //map<String,Boolean> key{i|j|idx}: true;
        if(visited[i][j]!=0)return false;

        visited[i][j]++;
        for(int[] move: moves){
            int x = i + move[0];
            int y = j + move[1];

            if(x<0 || y<0 || x>=m || y>=n || (idx<word.length()-1 && word.charAt(idx+1)!=board[x][y])) continue;

            if(dfs(board,x,y,word,idx+1,visited)) return true;
        }
        visited[i][j]--;
        return false;
    }

    public static void main(String[] args) {
        InBorardOrNot obj = new InBorardOrNot();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";

        System.out.println(obj.exist(board,word));
    }

}
