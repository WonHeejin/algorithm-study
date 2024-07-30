import java.util.*;
public class Main{
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);
        String[] word=sc.nextLine().split(" ");
        int count=0;
        for(int i=0;i<word.length;i++){
            if(!word[i].equals("")){
                count++;
            }
        }
        System.out.print(count);
    }
}