import java.io.*;
import java.util.*;
class MakeLargeIsland{
	static int val = 0;
	static int getMax( int[][] grid ){
		int n = grid.length;
		int max = 0;
		boolean[][] visit;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if( grid[i][j] == 0 ){
					val = 0;
					visit = new boolean[n][n];
					grid[i][j] = 1;
					dfs(grid, i, j, n, visit);
					grid[i][j] = 0;
					max = Math.max(max, val);
				}
			}
		}
		return max;
	}
	static void dfs(int[][] grid, int i, int j, int n, boolean[][] visit){
		if( i < n && j < n && i >= 0 && j >= 0 && grid[i][j] == 1 && !visit[i][j] ){
			val++;
			visit[i][j] = true;
			dfs(grid, i+1, j, n, visit);
			dfs(grid, i-1, j, n, visit);
			dfs(grid, i, j+1, n, visit);
			dfs(grid, i, j-1, n, visit);
		}
	}
	static final Scanner sn = new Scanner(System.in);
	static final Random rn = new Random();
	public static void main(String[] args) {
		int n = sn.nextInt();
		int[][] grid = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				grid[i][j] = sn.nextInt();
				// System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(getMax(grid));
	}
	static void fill(int[] ar, int n){
		Arrays.fill(ar, n);
	}
	static void clearScreen(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	static char[] chararr(String s){
		return s.toCharArray();
	}
}
