import java.util.*;
public class Main{
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);
        String input = sc.next();
        char[] alpha=new char[26];
        for(int i=0;i<input.length();i++){
                if('A'<=input.charAt(i)&&input.charAt(i)<='Z'){
                    alpha[input.charAt(i)-'A']++;
                }else{
                    alpha[input.charAt(i)-'a']++;
                }
        }
       int max=-1;
        char mun='?';
        for(int i=0;i<26;i++){
            if(alpha[i]>max){
                max=alpha[i];
                mun=(char)(i+65);
            }else if(alpha[i]==max){
                mun='?';
            }
        }
        System.out.println(mun);
    }
}