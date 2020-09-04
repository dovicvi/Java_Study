import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_swea_1767_프로세서연결하기 {

	private static ArrayList<int[]> list;
	private static int dx[] = {0,0,-1,1};
	private static int dy[] = {-1,1,0,0};
	private static int max;
	private static int min;
	private static int totalCnt;
	private static int n;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			n=Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			list = new ArrayList<int[]>();
			max =0;
			min = Integer.MAX_VALUE;
			totalCnt=0;
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					//아래 줄 가장자리 프로세서 건너 뛰는 건데 그럴거면 map[i][j]==1은 없어도 될듯
					//무조건 가장자리에서 건너뛰는 형식이 더 편할듯
					if(i==0 || j==0 || i==n-1 || j==n-1) continue;
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);//0,0에서 시작
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void go(int index, int cCnt) {
		
		if(totalCnt - index + cCnt < max) return;
		
		if(index == totalCnt) {
			int res = getLength();
			if(max<cCnt) {
				max = cCnt;
				min = res;
			}else if(max==cCnt) {
				if(min>res) min=res;
			}
			return;
		}
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		for(int d=0;d<4;d++) {
			if(isAvailable(r,c,d)) {
				setStatus(r,c,d,2);
				go(index+1,cCnt+1);
				setStatus(r,c,d,0);
			}
		}
		go(index+1,cCnt);
	}

	private static int getLength() {
		int lCnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==2) ++lCnt;
			}
		}
		return lCnt;
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr=r,nc=c;
		while(true) {
			nr+= dx[d];
			nc+= dy[d];
			if(nr<0 || nr>=n || nc<0 || nc>=n) break;
			if(map[nr][nc]>=1) return false;
		}
		return true;
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr=r,nc=c;
		while(true) {
			nr+=dx[d];
			nc+=dy[d];
			if(nr<0 || nr>=n || nc<0 || nc>=n) break;
			map[nr][nc]=s;
		}
	}

}
