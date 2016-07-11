
public class Score {
	
	private Circuit circuit;
	private Juggler juggler;

	public Score(Circuit circuit, Juggler juggler){
		this.circuit = circuit;
		this.juggler = juggler;
	}
	
	public int getH() {
		return circuit.getH() * juggler.getH();
	}

	public int getE() {
		return circuit.getE() * juggler.getE();
	}

	public int getP() {
		return circuit.getP() * juggler.getP();
	}

	public int score() {
		return this.getH() + this.getE() + this.getP();
	}
}
