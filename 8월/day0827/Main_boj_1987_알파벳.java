import java.io.IOException;
import java.util.Scanner;

public class Main_boj_1987_알파벳 {
	private static int result;
	private static boolean visit[];
	private static int R,C;
	private static int dr[] = {-1,1,0,0};
	private static int dc[] = {0,0,-1,1};
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		result=0;
        R=sc.nextInt();
        C=sc.nextInt();
        map = new char[R][C];
        visit = new boolean[26];
        for(int i=0;i<R;i++){
            String str = sc.next();
            for(int j=0;j<C;j++){
                map[i][j]=str.charAt(j);
            }
        }
        
        visit[map[0][0]-'A']=true;
        dfs(0,0,1);
        
        System.out.println(result);
	}

	private static void dfs(int x, int y,int cnt) {
		if(result>=26) return;
		if(cnt>result) {
			result=cnt;
//			for(int i=0;i<26;i++) {
//				if(visit[i]) {
//					char c = 'A';
//					c+=i;
//					System.out.print(c);
//				}
//			}
//			System.out.println(" "+cnt);
		}
		
		if(x+1<R && !visit[map[x+1][y]-'A']) {
			visit[map[x+1][y]-'A']=true;
			dfs(x+1,y,cnt+1);
			visit[map[x+1][y]-'A']=false;
		}
		if(y+1<C && !visit[map[x][y+1]-'A']) {
			visit[map[x][y+1]-'A']=true;
			dfs(x,y+1,cnt+1);
			visit[map[x][y+1]-'A']=false;
		}
		if(x-1>=0 && !visit[map[x-1][y]-'A']) {
			visit[map[x-1][y]-'A']=true;
			dfs(x-1,y,cnt+1);
			visit[map[x-1][y]-'A']=false;
		}
		if(y-1>=0 && !visit[map[x][y-1]-'A']) {
			visit[map[x][y-1]-'A']=true;
			dfs(x,y-1,cnt+1);
			visit[map[x][y-1]-'A']=false;
		}
	}
	
}
