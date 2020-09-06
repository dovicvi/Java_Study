import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//출발은 0번째인 회사에서 출발해서 모든 곳을 다 돌고 다시 회사로 돌아옴
//최솟값 구하기
public class Main_jungol_1681_해밀턴순환회로 {

	private static int min;
	private static int N;
	private static boolean[] visit;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine().trim());//N입력
		
		map = new int[N+1][N+1];
		min=Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//map 입력 끝
		//map[i][j]는 i에서 j까지 가는 거리
		//map[i][j]와 map[j][i]는 다를수 있다.
		
		
//		for(int i=1;i<N;i++) {
//			 prim(i,map);
//		}
		
		visit = new boolean[N+1];
		visit[1] = true;
		dfs(1,1,0);
		
		System.out.println(min);//결과값 출력
	}

	private static void dfs(int toIdx, int cnt, int cost) {
		if(cost > min) return;
		
		if(cnt == N) {
			int lastCost = map[toIdx][1];
			if(lastCost > 0 && lastCost + cost < min) {
				min =cost+lastCost;
			}
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(map[toIdx][i] > 0 && !visit[i]) {
				visit[i] =true;
				dfs(i,cnt+1,cost+map[toIdx][i]);
				visit[i]=false;
			}
		}
	}

	private static void prim(int idx,int[][] map) {
		int[] dis = new int[N];
		int sum=0;
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0]=0;
		dis[idx]=map[0][idx];
		visit[0]=true;
		visit[1]=true;
		
		while(true) {
			
		}
		
//		sum+=map[][0];
//		if(sum<min) {
//			min=sum;
//		}
	}

}
