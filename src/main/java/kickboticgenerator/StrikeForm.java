package kickboticgenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import trickinggenerator.Trick;

public class StrikeForm {
	@JsonProperty("n")
	public int n;
	@JsonProperty("strikes")
	public Strike[] strikes;
	
	public StrikeForm() {
		
	}
	
	public StrikeForm(int n, Strike[] strikes) {
		super();
		this.n = n;
		this.strikes = strikes;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Strike[] getStrikes() {
		return strikes;
	}
	public void setStrikes(Strike[] strikes) {
		this.strikes = strikes;
	}
	
	
}
