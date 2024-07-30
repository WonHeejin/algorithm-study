import java.util.Scanner;
public class Main{
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String[] word=new String[n];
        int result=0;
        for(int i=0;i<n;i++){
            word[i]=sc.next();
            result+=count(word[i]);
        }
        System.out.println(result);
    }
    public static int count(String word){
        boolean[] alpha = new boolean[26];
        int prev=0;
        boolean check=true;
        for(int i=0; i<word.length();i++){
            int now=word.charAt(i);
            if(prev!=now){
                if(alpha[now-'a']==false){
                    alpha[now-'a']=true;
                    prev=now;
                }else{
                    check=false;
                }
            }
        }
        return (check)?1:0;
    }
}