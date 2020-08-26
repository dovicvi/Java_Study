import java.util.Scanner;

public class Main_jungol_1733_오목 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//위에서부터 오른쪽으로 훑으니 8방 검색을 안해도 된다.
		//대각선왼쪽아래,아래,대각선오른쪽아래,오른쪽 4가지만 검색하면 됨
		
		//6개이상이 연속이면 이긴게 아님!!
		//이 조건 때문에 처음에 틀린듯
		int dx[] = {1,1,1,0};
		int dy[] = {-1,0,1,1};
		int x=-1,y=-1;
		
		int map[][] = new int[21][21];
		int ans=0;
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1;i<=19;i++) {
			if(ans!=0) break;
			for(int j=1;j<=19;j++) {
				if(map[i][j]!=0) {//빈 공간이 아니면
					int t=map[i][j];//바둑돌이 무슨색인지 확인
					for(int k=0;k<4;k++) {//8방 검색 ==> (위 참고) 4방검색으로 가능
						int cnt=1;//같은 색이 몇개인지 판단
						int mx=i+dx[k];
						int my=j+dy[k];
						if(map[i-dx[k]][j-dy[k]]==t) continue;
						while(map[mx][my]==t) {
							cnt++;
							mx+=dx[k];
							my+=dy[k];
						}
						if(cnt==5) {
							ans=t;
							if(k==0) {
								x=mx-dx[k];
								y=my-dy[k];
							}else {
								x=i;
								y=j;
							}
							break;
						}
					}
				}
			}
		}
		if(ans==0) System.out.println(0); 
		else {
			System.out.println(ans);
			System.out.println(x+" "+y);
		}
	}
}
