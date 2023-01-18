package Backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2580 {
    public static int arr [][] = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0);
    }

    public static void backTracking(int row, int col){
        if(col == 9){
            backTracking(row + 1, 0);
            return;
        }

        if(row == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
            System.exit(0);
        }

        if(arr[row][col] == 0){
            for(int i = 1; i <= arr.length; i++){
                if(!chkDuplicated(row, col, i)){
                    arr[row][col] = i;
                    backTracking(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        backTracking(row, col + 1);
    }

    public static boolean chkDuplicated(int row, int col, int value){
        for(int i = 0; i < arr.length; i++){
            if(arr[row][i] == value){
                return true;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i][col] == value){
                return true;
            }
        }

        int square_row = (row / 3) * 3;
        int square_col = (col / 3) * 3;

        for(int i = square_row; i < square_row + 3; i++){
            for(int j = square_col; j < square_col + 3; j++){
                if(arr[i][j] == value){
                    return true;
                }
            }
        }

        return false;
    }

}
