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
    		= Juggler.string2JugglersHash(fileOutPut[1], circuits);

    	Performance performance = new Performance(circuits, jugglers);
    	performance.assignJugglers();
    	
    	writeList(circuits);
    	
    	int sum1970 = circuits.get(1970).getJugglers().stream()
    			.mapToInt(juggler -> juggler.getId())
    			.sum();
    	
    	System.out.println(sum1970 + "@yodle.com");
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

    private static void writeList(Hashtable<Integer, Circuit> circuits) {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("output.txt"));

    		for(Circuit circuit : circuits.values())
                out.println(circuit.getScore());

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: "
                               + e.getMessage());

        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
                                     
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } 
            else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}
