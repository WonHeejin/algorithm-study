import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int loop = sc.nextInt();
        int[] numbers = new int[loop];
        int v = 0;
        
        for(int i=0; i<loop; i++) {
        	numbers[i] = sc.nextInt();
        }
        
        v = sc.nextInt();
        
        for(int j=0; j<loop; j++) {
        	if(numbers[j] == v) count++;
        }
        
        System.out.print(count);
    }
}