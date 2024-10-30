import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.print(collab(n, m));
    }
    
    public static BigInteger collab(int n, int m) {
    	BigInteger x = new BigInteger("1");
    	BigInteger x2 = new BigInteger(n+"");
    	BigInteger y = new BigInteger("1");
    	BigInteger y2 = new BigInteger(m+"");
        if(n == m || m == 0) {
        	return new BigInteger("1");
        }
        for(int i=0; i<m; i++) {
        	x = x.multiply(x2);
        	x2 = x2.subtract(new BigInteger("1"));
        	y = y.multiply(y2);
        	y2 = y2.subtract(new BigInteger("1"));;
        }
        BigInteger result = x.divide(y);
    	return result;
    }
}