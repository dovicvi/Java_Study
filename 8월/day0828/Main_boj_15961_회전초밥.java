import java.util.Scanner;

public class Main_boj_15961_회전초밥 {
	
	private static int n,d,k,c,arr[], visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n =sc.nextInt();
		d=sc.nextInt();
		k=sc.nextInt();
		c=sc.nextInt();
		
		visit = new int [d+1];
		arr =new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(slide());
	}

	private static int slide() {
		int total=0,max=0;
		for(int i=0;i<k;i++) {
			if(visit[arr[i]]==0) total++;
			visit[arr[i]]++;
		}
		
		max=total;
		
		for(int i=1;i<n;i++) {
			if(max<=total) {
				if(visit[c]==0)
					max=total+1;
				else
					max=total;
			}
			visit[arr[i-1]]--;
			if(visit[arr[i-1]]==0) total--;
			
			if(visit[arr[(i+k-1)%n]]==0) total++;
			visit[arr[(i+k-1)%n]]++;
			
		}
		
		return max;
	}
}
