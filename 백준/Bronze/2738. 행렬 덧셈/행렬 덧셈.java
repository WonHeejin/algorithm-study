import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        solution(n,m,a,b);
    }
    
    public static void solution(int n, int m, int[][] a, int[][] b) {
        int[][] answer = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer[i][j] = a[i][j] + b[i][j];
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}