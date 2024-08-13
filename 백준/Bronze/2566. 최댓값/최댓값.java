import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int n = 9;
        int max=0, column=0, row=0;
        int[][] met = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                met[i][j] = sc.nextInt();
                if(max<=met[i][j]) {
                    max = met[i][j];
                    column = i+1;
                    row = j+1;
                }
            }
        }
        System.out.print(max+"\n"+column+" "+row);
    }
}