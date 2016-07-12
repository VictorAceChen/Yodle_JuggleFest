import java.util.*;
import java.util.stream.Collectors;

public class Circuit {
	private int id;
	private int H;
	private int E;
	private int P;
	private ArrayList<Juggler> jugglers = new ArrayList<Juggler>();
	
	public Circuit(String str){
		String[] strCircuit = str.split(" ");

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
    
	public int getH() {
		return H;
	}

	public int getE() {
		return E;
	}

	public int getP() {
		return P;
	}

	public ArrayList<Juggler> getJugglers() {
		return jugglers;
	}
	
	public int scoreJuggler(Juggler juggler){
		return this.getH() * juggler.getH() +
			this.getE() * juggler.getE() +
			this.getP() * juggler.getP();
	}
	
	public Juggler assignJuggler(Juggler juggler, int circuitMaxSize){

//		insert Juggler to circuit by score rank
		for( int i = 0; i < jugglers.size(); i++){
			
			Juggler idxJuggler = jugglers.get(i);
			
			if(this.scoreJuggler(juggler) > this.scoreJuggler(idxJuggler)){
				this.jugglers.add(i, juggler);
				
				if(jugglers.size() > circuitMaxSize){
					return jugglers.remove(jugglers.size() - 1);
				}else{
					return null;
				}
			}
		}
		
//		join circuit if there is space
		if(jugglers.size() < circuitMaxSize){
			jugglers.add(juggler);
			return null;
		}
//		never had a chance
		return juggler;
	}
	
	public String getScore(){
		return 	"C" + this.id + " " +
				this.jugglers.stream()
				.map( juggler -> juggler.getScore())
				.collect(Collectors.joining(", "));
	}
	
	public void output(){
    	System.out.println(this.getScore());
	}
	
	public void print(){
    	System.out.print("C"+ this.id);
    	System.out.print(" H:" + this.H);
    	System.out.print(" E:" + this.E);
    	System.out.println(" P:" + this.P);
		for(Juggler juggler : jugglers){
			System.out.print("|");
			juggler.print();
		}
    	System.out.println();
	}
	
    public static Hashtable<Integer, Circuit> string2CircuitsHash(String str) {
    	
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
