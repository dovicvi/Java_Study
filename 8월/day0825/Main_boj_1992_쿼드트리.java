import java.util.Scanner;

//문제가 안풀려서 교수님 풀이를 보고 따라함
//그래서 코드에 내가 이해한 것을 주석으로 모두 달음

public class Main_boj_1992_쿼드트리 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		//공백없는 숫자 입력이라서 입력받기 쉽게 char로 입력받음
		char map[][] = new char[n][n];
		
		for(int i=0;i<n;i++) {
			//각 줄 자체를 String으로 입력받아서 toCharArray함수를 통해 한글자씩
			//map에다가 char로 입력
			map[i]=sc.next().toCharArray();
		}
		
		//전역변수 안쓰려고 관련된 변수들을 다 집어넣음
		solve(0,0,n,map);
		//scanner종료
		sc.close();
	}

	private static void solve(int x, int y, int n, char[][] map) {
		if(isSame(x,y,n,map)) {//z형식으로 읽어서 모두 같은 숫자이면 그 숫자 출력
			System.out.print(map[x][y]);
			return;
		}
		
		//if문에서 안걸러졌으니 다른 숫자들이므로 괄호 열기
		System.out.print("(");
		int s= n/2;//n을 절반으로 나눠서 기준값으로 만듬
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				//왼쪽위,오른쪽위,왼쪽아래,오른쪽아래순으로 탐색
				solve(x+s*i, y+s*j, s, map);
			}
		}
		//괄호 닫기
		System.out.print(")");
	}

	private static boolean isSame(int x, int y, int n, char[][] map) {
		//지정된 범위내의 숫자가 모두 같은지 판단
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(map[x][y] != map[i][j]) {
					//하나라도 다르면 false
					return false;
				}
			}
		}
		//모두 같으면 true;
		return true;
	}
}
