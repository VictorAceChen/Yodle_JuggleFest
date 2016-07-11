import java.util.*;

public class Circuit {
	private int id;
	private int H;
	private int E;
	private int P;
	
	public Circuit(String str){
		String[] strCircuit = str.split(" ");
//    	System.out.println(strCircuit[1].split("")[1]);

    	String temp = strCircuit[1].substring(1);
		this.id = Integer.parseInt(temp);

    	temp = strCircuit[2].split(":")[1];
    	this.H = Integer.parseInt(temp);

    	temp = strCircuit[3].split(":")[1];
    	this.E = Integer.parseInt(temp);

    	temp = strCircuit[4].split(":")[1];
    	this.P = Integer.parseInt(temp);
	}
	
    public int getId() {
        return this.id;
    }
	
	public void print(){
    	System.out.print("id:" + this.id);
    	System.out.print(" H:" + this.H);
    	System.out.print(" E:" + this.E);
    	System.out.println(" P:" + this.P);
	}
	
    public static Hashtable<Integer, Circuit> string2CircuitHash(String str) {
    	
    	Hashtable<Integer, Circuit> Circuits = new Hashtable<Integer, Circuit>();
    	String[] strCircuits = str.split("\r");
    	
        for (String line  : strCircuits) {
        	Circuit currentCircuit = new Circuit(line);
//        	System.out.println(line);
        	Circuits.put(currentCircuit.getId(), currentCircuit);
         }
    	
    	return Circuits;
    }
}
