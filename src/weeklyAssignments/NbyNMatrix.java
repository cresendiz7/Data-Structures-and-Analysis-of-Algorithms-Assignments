package weeklyAssignments;
public class NbyNMatrix{
	private static final int N =4;
	public static boolean Exists(int[][] matrix, int X){
	int row =0;
	int col = matrix.length - 1;
	while(row < N && col >= 0){
		if(matrix[row][col] == X){
			return true;
		}
		else if(matrix[row][col] > X){
			col--;
		}
		else{
			row++;
		}
	}
	return false;
	}
}