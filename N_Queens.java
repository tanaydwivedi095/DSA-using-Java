import java.util.Scanner;

public class N_Queens {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE VALUE OF N: ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
    }
    public static void nQueens(char[][] board, int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '.';
            }
        }
    }
    public static void printBoard(char[][] board){
        System.out.println("CHESS BOARD");
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(char[][] board, int row, int col){
        // for same column
        for(int i=0; i<board.length; i++){
            if(i==row){
                continue;
            }
            else{
                if(board[i][col]=='Q'){
                    return false;
                }
            }
        }
        // for same row
        for(int i=0; i<board.length; i++){
            if(i==col){
                continue;
            }
            else{
                if(board[row][i]=='Q'){
                    return false;
                }
            }
        }
        // for diagonals
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row+1, j=col+1; i< board.length && j< board.length; i++, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row+1, j=col-1; i<board.length && j>=0; i++, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
