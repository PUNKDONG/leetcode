import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0);
        return res;
    }
    public void backtrack(char[][] board, int row ) {
    if(row == board.length) {
        res.add(Array2List(board));
        return;
    }
    for(int i = 0; i < board.length; i++) {
        if(isValid(row,i,board.length,board)){
            board[row][i] = 'Q';
            backtrack(board,row+1);
            board[row][i] = '.';
        }

    }

    }
    public List Array2List(char[][] chessboard) {
       List<String> list = new ArrayList<>();
       for(int i = 0; i < chessboard.length; i++) {
           list.add(String.valueOf(chessboard[i]));
       }
       return list;
    }

    public boolean isValid(int row, int col, int n, char[][]  board) {
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        //
        int col45=col-1;
        for (int i = row-1; i >=0&&col45>0; i--) {

            if(board[i][col45] == 'Q') return false;
            col45--;
        }
        int col135=col+1;

        for (int i = row-1; i >=0&&col135<n; i--) {
            if(board[i][col135] == 'Q') return false;
            col135++;
        }

     return true;
    }



}
