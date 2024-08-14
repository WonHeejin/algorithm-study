import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int col = 5;
        int row = 15;
        String[] line = new String[col];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        
        for(int i=0; i<col; i++) {
        	line[i] = br.readLine();
        }
        
        System.out.print(solution(col, row, line));
    }
    
    public static String solution(int col, int row, String[] line) {
    	StringBuffer sb = new StringBuffer();
    	
    	for(int l=0; l<row; l++) {
    		for(int k=0; k<col; k++) {
    			if(line[k].length() > l) {
    				sb.append(line[k].charAt(l));
    			}
    		}
    	}
    	
    	return sb.toString();
    }
}