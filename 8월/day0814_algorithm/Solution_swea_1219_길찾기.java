import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_swea_1219_길찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=10;
		
		for(int tc=1;tc<=T;tc++) {
			int n;
			sc.nextInt();
			n=sc.nextInt();
			
			int arr[][] = new int[100][2];
			
			for(int i=0;i<n;i++) {
				int start,end;
				start=sc.nextInt();
				end=sc.nextInt();
				if(arr[start][0]==0) {
					arr[start][0]=end;
				}else {
					arr[start][1]=end;
				}
			}
			
			boolean visit[] = new boolean[100];
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(0);
			visit[0]=true;
			int result=0;
			while(!q.isEmpty()) {
				int x = q.poll();
				if(x==99) {
					result=1;
					break;
				}
				for(int i=0;i<2;i++) {
					if(arr[x][i]==0) break;
					q.offer(arr[x][i]);
					visit[arr[x][i]]=true;
				}
				
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
