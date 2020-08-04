package day0804;

import java.util.Arrays;
import java.util.Scanner;

public class hwalgo0804_서울_8반_김명규 {
	static int n,m;
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int rank[];
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1];
		rank = new int[n+1];
		Arrays.fill(arr, -1);
		
		for(int i=1;i<=n;i++) {
			arr[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			int a,b;
			a=sc.nextInt();
			b=sc.nextInt();
			
			union(a,b);
		}

		int cnt=0;

		for(int i=1;i<=n;i++) {
			if(i==arr[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int pa,pb;
		pa = find(a);
		pb = find(b);
//		if(pa==pb) return;
//		arr[b]=pa;
		
		if(rank[pa]<rank[pb]) {
			arr[pa]=pb;
		}else {
			arr[pb]=pa;
			if(rank[pa]==rank[pb]) {
				rank[pa]++;
			}
		}
	}

	private static int find(int a) {
		if(arr[a]==a) return a;
		return arr[a]=find(arr[a]);
	}
	
}
