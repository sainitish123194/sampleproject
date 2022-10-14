package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task {
	public static void main(String[] args) {
	  File f=new File("C:/Users/ASUS/Desktop/ss.txt");
	  BufferedReader br=null;
	  try{
br=new BufferedReader(new FileReader(f));
	    
	  String line=br.readLine();
	  System.out.println(line);
	  int n=Integer.parseInt(line);
	  System.out.println(n);
	  }catch(FileNotFoundException e){
		System.out.println("file not found exception");  
	  }catch (NumberFormatException e) {
		  System.out.println("number formate exception");
		  
		// TODO: handle exception
	}catch(IOException e){
		System.out.println("IO exception");
	}catch(Exception e){
			
	
	}finally{
		System.out.println("finally");
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
}