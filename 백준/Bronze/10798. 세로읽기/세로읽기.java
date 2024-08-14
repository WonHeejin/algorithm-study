import java.util.*;

public class Main {
    public static void main(String[] args) {
        int col = 5;
        int row = 15;
        char[][] chars = new char[col][row];
        Scanner sc = new Scanner(System.in);
         
        
        for(int i=0; i<col; i++) {
        	String line = sc.nextLine();
            for(int j=0; j<line.length(); j++) {
                chars[i][j] = line.charAt(j);
            }
        }
        
        System.out.print(solution(col, row, chars));
    }
    
    public static String solution(int col, int row, char[][] chars) {
    	StringBuffer sb = new StringBuffer();
    	for(int l=0; l<row; l++) {
    		for(int k=0; k<col; k++) {
    			if(chars[k][l] != '\0') {
    				sb.append(chars[k][l]);
    			} else {
    				continue;
    			}
    		}
    	}
    	
    	return sb.toString();
    }
}