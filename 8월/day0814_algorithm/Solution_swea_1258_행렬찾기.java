//import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

class Point implements Comparable<Point>{
	int x,y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getSize() {
		return x*y;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.getSize() > p.getSize()) {
			return 1;
		}else if(this.getSize() == p.getSize()) {
			if(this.x > p.x) {
				return 1;
			}
		}
		return -1;
	}
}

//class PointComparator implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		Point p1 = (Point)o1;
//		Point p2 = (Point)o2;
//		if(p1.getSize()>p2.getSize()) {
//			return 1;
//		}else if(p1.getSize()==p2.getSize()) {
//			if(p1.x>p2.x) {
//				return 1;
//			}
//		}
//		
//		return 0;
//	}
//	
//}

public class Solution_swea_1258_행렬찾기 {
	
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			map = new int[n][n];
			visit= new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			Vector<Point> v = new Vector<Point>();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]!=0 && visit[i][j]==false) {
						int x=i,y=j;
						while(x<n) {
							if(map[x][j]==0) break;
							x++;
						}
						while(y<n) {
							if(map[i][y]==0) break;
							y++;
						}
						v.addElement(new Point(x-i,y-j));
						check(i,j,x,y);
					}
				}
			}
			Point[] points = new Point[v.size()];
			for(int i=0;i<points.length;i++) {
				points[i]=v.get(i);
			}
			Arrays.sort(points);
//			Collections.sort(v, new PointComparator());
			System.out.print("#"+tc+" "+v.size());
			for(int i=0;i<v.size();i++) {
				Point p = points[i];
				System.out.print(" "+p.x+" "+p.y);
			}
			System.out.println();
		}
	
	}

	private static void check(int a, int b, int x, int y) {
		for(int i=a;i<x;i++) {
			for(int j=b;j<y;j++) {
				visit[i][j]=true;
			}
		}
	}
}
