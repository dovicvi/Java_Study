import java.io.IOException;
import java.util.Scanner;

//다시 풀어보기

public class Solution_swea_5607_professional조합 {

	public static int iT=0,N,R;
	public static int Q=1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan=new Scanner(System.in);
		iT=scan.nextInt();
		for (int T = 1; T <= iT; T++) {

			N=scan.nextInt();
			R=scan.nextInt();
			System.out.printf("#%d %d\n",T,nCr(N,R,Q));
		}
		scan.close();
	}
	/*
	 * 5C2%7 -> 5!/(3!*2!) %7 -> 5!* 6^5 * 2^5 %7 -> 
	 *  (5! %7)*(6^1 %7 * 6^4 %7)*(2^1 %7 * 2^4 %7)
	 */
	static long power(long x, long y, long p)  { 
		long res = 1L; 
      
        x = x % p; 
        //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
          
        return res; 
    } 
    static long modInverse(long n, long p) { 
        return power(n, p-2, p); 
    } 
    static long nCr(int n, int r, int p) { 

        if (r == 0) 
            return 1L; 

        long[] fac = new long[n+1]; 
        fac[0] = 1; 
          
        for (int i = 1 ;i <= n; i++) 
            fac[i] = fac[i-1] * i % p; 
      
        return (fac[n]* modInverse(fac[r], p) 
                % p * modInverse(fac[n-r], p) 
                                    % p) % p; 
    } 
}