import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2564_경비원 {
	private static int[][] p;
	private static int row,col;//가로,세로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st =new StringTokenizer(br.readLine()," ");
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		p = new int[n+1][2];
		int dir[][] = new int[n+1][2];
		//첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다.
		//둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다. 
		//상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
		for(int i=0;i<n+1;i++) {
			int a,b;
			st =new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			dir[i][0]=a;
			dir[i][1]=b;
			insert(i,a,b);
		}//p[n][]이 동근이의 좌표
		
		int sum=0;
		for(int i=0;i<n;i++) {
			if(dir[i][0]*dir[n][0]==2) {
				sum+=Math.min(dir[i][1]+dir[n][1],row-dir[i][1]+row-dir[n][1])+col;
			}else if(dir[i][0]*dir[n][0]==12) {
				sum+=Math.min(dir[i][1]+dir[n][1],col-dir[i][1]+col-dir[n][1])+row;
			}else {
				sum+=Math.abs(p[i][0]-p[n][0])+Math.abs(p[i][1]-p[n][1]);
			}
		}
		System.out.println(sum);
	}

	private static void insert(int i, int a, int b) {
		switch (a) {
		case 1:
			p[i][0]=0;
			p[i][1]=b;
			break;
		case 2:
			p[i][0]=col;
			p[i][1]=b;
			break;
		case 3:
			p[i][0]=b;
			p[i][1]=0;
			break;
		case 4:
			p[i][0]=b;
			p[i][1]=row;
			break;
		}
	}
}
