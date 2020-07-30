package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top_2493 {
	public static void main(String[] args) throws Exception, IOException {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(stt.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek() >= v) {
					System.out.print(index.peek() + " ");
					break;
				}
				stack.pop();
                index.pop();
			}
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(v);
            index.push(i);
		}
	}
}