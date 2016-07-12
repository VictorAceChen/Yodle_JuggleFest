import java.io.*;
import java.util.*;
import java.io.FileInputStream;
public class Main {

	public static void main(String[] args) {

//		get file input
    	String fileName = "input";
    	String fileOutPut[] = file2String(fileName).split("\n\r");
    	
//    	convert string input to circuits and jugglers
    	Hashtable<Integer, Circuit> circuits 
    		= Circuit.string2CircuitsHash(fileOutPut[0]);
    	Hashtable<Integer, Juggler> jugglers 
    		= Juggler.string2JugglersHash(fileOutPut[1]);

//    	Circuits.get(2).print();
//    	Jugglers.get(2).print();

    	Performance performance = new Performance(circuits, jugglers);
    	
    			
	}

    private static String file2String(String fileName) {
    	String result = null;

//		find file
		try{
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			
//			read file then set result
			try{
				fis.read(data);
				fis.close();
	
				result = new String(data, "UTF-8");
			}
			catch(IOException ex){
                System.out.println("failed read");
			}
			
		}
       catch(FileNotFoundException ex) {
           System.out.println(
               "Unable to open file '" + 
               fileName + "'");                
       }
       return result;
    }
}
