import java.util.*;
import java.io.*;

public class Main{
    public static int[] parents;
 public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());
     int pointCnt = Integer.parseInt(st.nextToken());
     int cycle = Integer.parseInt(st.nextToken());
     parents = new int[pointCnt];
     int[][] nodes = new int[cycle][];
     int result =0;
     
     for(int i=0; i<pointCnt;i++){
       parents[i]=i;
     }
     for(int i=1; i<=cycle; i++){
         st = new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());       
       int b = Integer.parseInt(st.nextToken());
       if(!union(a, b)){
           result = i;
           break;
       }
     }
     
     System.out.print(result);
 }
    public static boolean union(int a, int b){
      int parentA = find(a);
      int parentB = find(b);
        if(parentA != parentB){
            
          parents[Math.max(parentA, parentB)] = Math.min(parentA, parentB);
            return true;
        } else {
         return false;
        }
    }
    
    public static int find(int a){
      if(parents[a]==a) return a;
       
        else return parents[a] = find(parents[a]);
    }
}