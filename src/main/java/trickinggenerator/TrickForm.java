package trickinggenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrickForm {
	@JsonProperty("n")
	public int n;
	@JsonProperty("tricks")
	public Trick[] tricks;
	@JsonProperty("difficulty")
	public int difficulty;
	@JsonProperty
	public String specific;
	@JsonProperty
	public int pos;
	
	public TrickForm(int n, Trick[] tricks) {
		super();
		this.n = n;
		this.tricks = tricks;
	}

	public TrickForm(int n, Trick[] tricks, String specific, int pos) {
		super();
		this.n = n;
		this.tricks = tricks;
		this.specific = specific;
		this.pos = pos;
	}

	public TrickForm(int n, Trick[] tricks, int difficulty) {
		super();
		this.n = n;
		this.tricks = tricks;
		this.difficulty = difficulty;
	}

	public TrickForm(int n, Trick[] tricks, int difficulty, String specific) {
		super();
		this.n = n;
		this.tricks = tricks;
		this.difficulty = difficulty;
		this.specific = specific;
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
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
}
