import java.util.ArrayList;
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
	
	public void assignJuggler(Juggler juggler){
		
		ArrayList<Circuit> preferences = juggler.getPreference();
		
		for(Circuit circuit : preferences){
			
			Juggler outRanked = circuit.assignJuggler(juggler, this.circuitMaxSize); 

//			break from method is assigned
			if(outRanked == null) return;
			
			if(outRanked != juggler){
				this.assignJuggler(outRanked);
				return;
			}

		}
	}
	
	public void assignJugglerOld(Juggler juggler, Circuit circuit){
			
		Juggler outRanked = circuit.assignJuggler(juggler, this.circuitMaxSize); 

		if(outRanked == null) return;
		
		int circuitIdx = outRanked.getPreference().indexOf(circuit);
		this.assignJuggler(
				outRanked
//				,outRanked.getPreference().get(circuitIdx + 1)
				);
	}
	
	
	public void assignJugglers(){
		for(Juggler juggler : jugglers.values()){
			this.assignJuggler(juggler);
		}
	}
	
	public void print(){
		for(Circuit circuit : circuits.values()){
//			circuit.print();
			circuit.output();
		}
	}

}


