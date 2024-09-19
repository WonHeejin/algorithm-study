import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        //배열에 값 넣기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        
        solution(N, K, arr);
        
    }
    
    public static void solution(int N, int K, int[] arr) {
        int count = 0;
        int max = 0;
        for(int i=N-1; i>0; i--) {
        	max = i; //최댓값의 인덱스 
        	//최댓값 찾기
            for(int j=i-1; j>=0; j--) {
            	if(arr[j]>arr[max]) {
            		max = j;
            	}
            }
            
            if(i!=max) {
            	int temp = arr[max];
            	arr[max] = arr[i];
            	arr[i] = temp;
            	++count;
            }
            
            if(count == K) {
            	System.out.println(arr[max]+" "+arr[i]);
            	break;
            }
        }
        if(count<K) {
            System.out.print(-1);
        }
    }
}