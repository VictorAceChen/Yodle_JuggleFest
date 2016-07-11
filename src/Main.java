import java.io.*;
import java.util.*;
import java.io.FileInputStream;
public class Main {

	public static void main(String[] args) {

    	String fileName = "input";
    	String fileOutPut[] = file2String(fileName).split("\n\r");;
//        System.out.println(fileOutPut[0]);
    	
    	Hashtable<Integer, Circuit> Circuits = Circuit.string2CircuitHash(fileOutPut[0]);
       
    	Circuits.get(2).print();
	}

    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                getAllFiles(f);
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }
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
