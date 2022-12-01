import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


public class test{
    public static void main(String[] args){
        BufferedReader reader;
       
		try {
           
			reader = new BufferedReader(new FileReader("check.txt"));
			String line = reader.readLine();

			while (line != null) {
               
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
	}
    }
