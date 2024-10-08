import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int searchCount = Integer.parseInt(br.readLine());
        int[] searchArr = new int[searchCount];
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<searchCount; j++) {
        	searchArr[j] = Integer.parseInt(st.nextToken());
        }
        
        solution(N, arr, searchArr);
    }
    
    public static void solution(int N, int[] arr, int[] searchArr) {
        //리스트 정렬
        Arrays.sort(arr);
        for(int i=0; i<searchArr.length; i++) {
            System.out.println(binarySearch(arr, searchArr[i]));
        }
    }
    
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
        	int mid = (start+end)/2;
            if(arr[mid]==target) {
                return 1;
            } else if(arr[mid]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return 0;
    }
}