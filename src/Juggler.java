import java.util.*;
import java.util.stream.Collectors;

public class Juggler {
	private int id;
	private int H;
	private int E;
	private int P;
	private ArrayList<Circuit> preference = new ArrayList<Circuit>();
	
	public Juggler(String str, Hashtable<Integer, Circuit> circuits){
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
        	Circuit targetCircuit = circuits.get(circuitId);
        	this.preference.add(targetCircuit);
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
	
	public ArrayList<Circuit> getPreference(){
		return this.preference;
	}
	
	public String getScore(){
		return 	"J" + this.id + " " +
				this.preference.stream()
				.map( circuit ->
					"C" + circuit.getId() + ":" + circuit.scoreJuggler(this))
				.collect(Collectors.joining(" "));
	}
	
	public void print2(){
		System.out.print(
				"J" + this.id + " " + this.getScore()
				);
	}
	
	public void print(){
//		for(Circuit circuit : this.preference){
//			System.out.print(
//					"C"+ circuit.getId() + ":" + circuit.scoreJuggler(this)
//					);
//		}
    	System.out.println("J" + this.id);
	}
	
    public static Hashtable<Integer, Juggler> string2JugglersHash(
    		String str, 
    		Hashtable<Integer, Circuit> circuits) {
    	
    	Hashtable<Integer, Juggler> Jugglers = new Hashtable<Integer, Juggler>();
    	String[] strJugglers = str.split("\r");
    	
        for (String line  : strJugglers) {
        	Juggler currentJuggler = new Juggler(line, circuits);
        	Jugglers.put(currentJuggler.getId(), currentJuggler);
         }
    	
    	return Jugglers;
    }
}
