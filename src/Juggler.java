import java.util.*;

public class Juggler {
	private int id;
	private int H;
	private int E;
	private int P;
	private Set<Integer> preference = new HashSet<Integer>();
	
	public Juggler(String str){
		String[] strJuggler = str.split(" ");

    	String temp = strJuggler[1].substring(1);
		this.id = Integer.parseInt(temp);

    	temp = strJuggler[2].split(":")[1];
    	this.H = Integer.parseInt(temp);

    	temp = strJuggler[3].split(":")[1];
    	this.E = Integer.parseInt(temp);

    	temp = strJuggler[4].split(":")[1];
    	this.P = Integer.parseInt(temp);
    	
    	String[] strCircuits = strJuggler[5].split(",");
        for (String strCircuit : strCircuits) {
        	int circuitId = Integer.parseInt(strCircuit.substring(1));
        	this.preference.add(circuitId);
         }
	}
	
    public int getId() {
        return this.id;
    }

	public int getH() {
		return H;
	}

	public int getE() {
		return E;
	}

	public int getP() {
		return P;
}
	
	public void print(){
    	System.out.print("id:" + this.id);
    	System.out.print(" H:" + this.H);
    	System.out.print(" E:" + this.E);
    	System.out.print(" P:" + this.P + " ");
    	
        for (int id : this.set) {
        	System.out.print(id + ",");
         }
    	System.out.println();
	}
	
    public static Hashtable<Integer, Juggler> string2JugglersHash(String str) {
    	
    	Hashtable<Integer, Juggler> Jugglers = new Hashtable<Integer, Juggler>();
    	String[] strJugglers = str.split("\r");
    	
        for (String line  : strJugglers) {
        	Juggler currentJuggler = new Juggler(line);
        	Jugglers.put(currentJuggler.getId(), currentJuggler);
         }
    	
    	return Jugglers;
    }
}
