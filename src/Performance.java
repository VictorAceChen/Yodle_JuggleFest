import java.util.Hashtable;

public class Performance {
	private int circuitMaxSize;
	private Hashtable<Integer, Circuit> circuits;
	private Hashtable<Integer, Juggler> jugglers;
	
	public Performance(
			Hashtable<Integer, Circuit> circuits, 
			Hashtable<Integer, Juggler> jugglers
			){
		this.circuits = circuits;
		this.jugglers = jugglers;
		this.circuitMaxSize = jugglers.size() / circuits.size();
		
	}
	
	
	
}
