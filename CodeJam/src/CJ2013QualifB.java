import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class CJ2013QualifB {
	
	public static String solve(int n, int m, int[][] desired){
		int[][] temp = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				temp[i][j] = 100;
			}
		}
		
		//cut each row to the max
		for(int i = 0; i < n; i++){
			int max = 0;
			for(int j = 0; j < m; j++){
				int d = desired[i][j]; 
				if(d > max) max = d;
			}
			for(int j = 0; j < m; j++){
				temp[i][j] = max;
			}
		}
		
		//cut each column to the max
		for(int i = 0; i < m; i++){
			int max = 0;
			for(int j = 0; j < n; j++){
				int d = desired[j][i]; 
				if(d > max) max = d;
			}
			for(int j = 0; j < n; j++){
				if(temp[j][i] > max) temp[j][i] = max;
			}
		}
		
		//check they are the same
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(temp[i][j] != desired[i][j]) return "NO";
			}
		}
		return "YES";
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		while(in.hasNext()){			
			String[] nm = in.nextLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int[][] desired = new int[n][m];
			for(int i = 0; i < n; i++){
				String[] ms = in.nextLine().split(" ");
				for(int j = 0; j < ms.length; j++){
					desired[i][j] = Integer.parseInt(ms[j]);
				}
			}
			writer.println("Case #"+tCase+": "+solve(n,m,desired));
			tCase++;
		}
		in.close();
		writer.close();
	}

}
