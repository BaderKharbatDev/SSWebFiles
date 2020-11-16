package trickinggenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrickForm {
	@JsonProperty("n")
	public int n;
	@JsonProperty("tricks")
	public Trick[] tricks;
	
	public TrickForm(int n, Trick[] tricks) {
		super();
		this.n = n;
		this.tricks = tricks;
	}
	
	public TrickForm() {
		
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Trick[] getTricks() {
		return tricks;
	}
	public void setTricks(Trick[] tricks) {
		this.tricks = tricks;
	}

	
	
}
