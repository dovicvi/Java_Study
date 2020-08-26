import java.util.Scanner;

public class Main_boj_17406_배열돌리기4 {
	private static int n,m,k;
	private static int map[][];
	private static int rot[][];
	private static int result;
	private static int temp[][];
	private static boolean visited[];
	private static int numbers[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		
		map=new int[n][m];
		rot=new int[k][3];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<k;i++) {
			rot[i][0]=sc.nextInt();
			rot[i][1]=sc.nextInt();
			rot[i][2]=sc.nextInt();
		}
		
		//바이너리 카운팅을 통한 부분집합
//		for(int i=0;i<(1<<k);i++) {
//			temp=map;
//			for(int j=0;j<k;j++) {
//				if((i & (1<<j)) !=0) {
//					rotation(rot[j],temp);
//				}
//				int x = cal(temp);
//				if(result>x) result=x;
//			}
//		}
		
		//순열 0부터 k까지
		int x= cal(map);
		if(result>x) result=x;
		for(int i=1;i<k;i++) {
			visited = new boolean[k];
			numbers = new int[i];
			temp=map;
			perm(0,i);
		}
		System.out.println(result);
	}

	

	private static void perm(int depth, int cnt) {
		if(depth==cnt) {
			rotate(numbers,temp);
			int x= cal(temp);
			if(result > x) result=x;
			return;
		}
		
		for(int i=0;i<k;i++) {
			if(visited[i]) continue;
			numbers[depth]=i;
			visited[i]=true;
			perm(depth+1,cnt);
			visited[i]=false;
		}
	}

	static void rotatematrix(int m, int n, int mat[][]) { 
		int row = 0, col = 0; 
		int prev, curr; 

		/* 
		row - Staring row index 
		m - ending row index 
		col - starting column index 
		n - ending column index 
		i - iterator 
		*/		
		while (row < m && col < n) 
		{ 
			
			if (row + 1 == m || col + 1 == n) 
				break; 
			
			// Store the first element of next 
			// row, this element will replace  
			// first element of current row 
			prev = mat[row + 1][col]; 

			// Move elements of first row  
			// from the remaining rows  
			for (int i = col; i < n; i++) 
			{ 
				curr = mat[row][i]; 
				mat[row][i] = prev; 
				prev = curr; 
			} 
			row++; 

			// Move elements of last column 
			// from the remaining columns  
			for (int i = row; i < m; i++) 
			{ 
				curr = mat[i][n-1]; 
				mat[i][n-1] = prev; 
				prev = curr; 
			} 
			n--; 

			// Move elements of last row  
			// from the remaining rows  
			if (row < m) { 
				for (int i = n-1; i >= col; i--) { 
					curr = mat[m-1][i]; 
					mat[m-1][i] = prev; 
					prev = curr; 
				}	 
			} 
			m--; 

			// Move elements of first column 
			// from the remaining rows  
			if (col < n) {
				for (int i = m-1; i >= row; i--) { 
					curr = mat[i][col]; 
					mat[i][col] = prev; 
					prev = curr; 
				} 
			}
			col++; 
		}
	}

	private static void rotate(int[] numbers, int[][] temp) {
		for(int i=0;i<numbers.length;i++) {
			int t=numbers[i];
			int xx,yy,nn;
			xx=rot[t][0]-1; yy=rot[t][1]-1; nn=rot[t][2];
			for(int j=1;j<=nn;j++) {
				int z=temp[xx-j+1][yy-j];
				
			}
		}
	}

	private static int cal(int[][] temp) {
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<temp.length;i++) {
			int sum=0;
			for(int j=0;j<temp[i].length;j++) {
				sum+=temp[i][j];
			}
			if(min>sum) min=sum;
		}
		
		return min;
	}
}
