package quiz;

import java.util.*;

public class s_1223 {
	public static int get_prior(char c) {
		if(c == '*')
			return 1;
		else if(c == '+')
			return 3;
		else
			return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String s = sc.next();
			Stack <Character> op = new Stack();
			String r = "";
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c - '0' >= 0 && c - '0' <= 9) {
					r += String.valueOf(c);
				}
				else {
					if(op.isEmpty()) {
						op.push(c);
					}
					else {
						if(get_prior(op.peek()) <= get_prior(c)) {
							r += String.valueOf(op.pop());
							op.push(c);
						}
						else {
							op.push(c);
						}
					}
				}
			}
			while(!op.isEmpty()) {
				r += String.valueOf(op.pop());
			}
			
			Stack <Integer> nums = new Stack();
			for(int i = 0; i < r.length(); i++) {
				char c = r.charAt(i);
				if(c - '0' >= 0 && c -'9' <= 0) nums.push(c - '0');
				else {
					int tmp1 = nums.pop();
					int tmp2 = nums.pop();
					if(c == '*') nums.push(tmp1 * tmp2);
					else if(c == '+') nums.push(tmp1 + tmp2);
				}
			}
			System.out.println("#" + t + " " + nums.pop());
		}
	}
}