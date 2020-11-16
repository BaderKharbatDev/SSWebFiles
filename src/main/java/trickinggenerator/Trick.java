package trickinggenerator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trick {
	@JsonProperty("name")
	public String name;
	@JsonProperty("take_off_stances")
	public Stance[] take_off_stances;
	@JsonProperty("landing_stances")
	public Stance[] landing_stances;
	@JsonProperty("canSwingOnLanding")
	public Boolean canSwingOnLanding;
	@JsonProperty("doesSwing")
	public Boolean doesSwing;
	@JsonProperty("isActive")
	public Boolean isActive; //only neccessary for the api call
	@JsonProperty("category")
	public TrickCategory category;
	@JsonProperty("strucWeight")
	public int strucWeight;
	
	public Trick(String name, Boolean canSwingOnLanding, Boolean doesSwing, Stance[] take_off_stances, Stance[] landing_stances, TrickCategory category, int structWeight) {
		super();
		this.name = name;
		this.take_off_stances = take_off_stances;
		this.landing_stances = landing_stances;
		this.canSwingOnLanding = canSwingOnLanding;
		this.doesSwing = doesSwing;
		this.category = category;
		this.strucWeight = structWeight;
		this.isActive = false;
	}
	
	
	//Full Constructor
	public Trick(String name, Stance[] take_off_stances, Stance[] landing_stances, Boolean canSwingOnLanding,
			Boolean doesSwing, Boolean isActive, TrickCategory category, int strucWeight) {
		super();
		this.name = name;
		this.take_off_stances = take_off_stances;
		this.landing_stances = landing_stances;
		this.canSwingOnLanding = canSwingOnLanding;
		this.doesSwing = doesSwing;
		this.isActive = isActive;
		this.category = category;
		this.strucWeight = strucWeight;
	}
	
	//dummy constructor
	public Trick() {
		
	}



	public static List<Trick> getAllMoves() {
		List<Trick> rv = new ArrayList<Trick>();
		//normal kicks
		rv.add(new Trick("Round Kick", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.normal_kicks, 0));
		rv.add(new Trick("Hook Kick", false, false, new Stance[]{Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.normal_kicks, 0));
		rv.add(new Trick("Frontsweep", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.normal_kicks, 0));
		rv.add(new Trick("Backsweep", false, false, new Stance[]{Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.normal_kicks, 0));
		rv.add(new Trick("Touch Down Round", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.backwards}, TrickCategory.normal_kicks, 0));
		//pop kicks
		rv.add(new Trick("Pop 360", false, false, new Stance[]{Stance.r_sideways, Stance.forwards}, new Stance[]{Stance.r_sideways}, TrickCategory.pop_kicks, 0));
		rv.add(new Trick("Backside 900", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.pop_kicks, 0));
		//cheat kicks
		rv.add(new Trick("Tornado", true, false, new Stance[]{Stance.r_sideways, Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.cheat_kicks, 0));
		rv.add(new Trick("540", false, false, new Stance[]{Stance.r_sideways, Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks, 1));
		rv.add(new Trick("Cheat 720", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks, 1));
		rv.add(new Trick("Jack Knife", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks, 3));
		rv.add(new Trick("Cheat 900", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.cheat_kicks, 1));
		//swing kicks
		rv.add(new Trick("Swing Over Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.swing_kicks, 0));
		//flat spins
		rv.add(new Trick("Butterfly Kick", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.flat_spins, 0));
		rv.add(new Trick("Machine", true, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.flat_spins, 0));
		rv.add(new Trick("Spider", true, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.flat_spins, 0));
		//flat twists
		rv.add(new Trick("Btwist", true, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways, Stance.backwards}, TrickCategory.flat_twists, 1));
		rv.add(new Trick("Btwist Round", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.flat_twists, 1));
		rv.add(new Trick("Btwist Hyper Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.flat_twists, 2));
		//backwards_flips
		rv.add(new Trick("Back Hand Spring", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips, 0));
		rv.add(new Trick("Back Tuck", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_flips, 1));
		rv.add(new Trick("Flash Kick", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips, 1));
		rv.add(new Trick("Arabian", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.forwards}, TrickCategory.backward_flips, 1));
		rv.add(new Trick("Cheat Gainer", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips, 1));
		rv.add(new Trick("Gainer Switch", true, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_flips, 1));
		rv.add(new Trick("Moon Kick", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.sideways}, TrickCategory.backward_flips, 1));
		//backwards_twists
		rv.add(new Trick("Cart Full", true, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists, 1));
		rv.add(new Trick("Cart Full Hyper Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.backward_twists, 2));
		rv.add(new Trick("Full", true, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists, 1));
		rv.add(new Trick("Cork", true, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists, 1));
		rv.add(new Trick("Boxcutter", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.sideways}, TrickCategory.backward_twists, 3));
		//forward_flips
		rv.add(new Trick("Dive Roll", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.forward_flips, 0));
		rv.add(new Trick("Reversao", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.r_sideways}, TrickCategory.forward_flips, 0));
		rv.add(new Trick("Front Tuck", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards}, TrickCategory.forward_flips, 1));
		rv.add(new Trick("Webster", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.forward_flips, 0));
		rv.add(new Trick("Roundoff", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.forward_flips, 0));
		//forward twists
		rv.add(new Trick("360 Dive Roll", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.r_sideways}, TrickCategory.forward_twists, 0));
		rv.add(new Trick("A-twist", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.forward_twists, 0));
		//outside flips
		rv.add(new Trick("Parafuso", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.outside_flips, 0));
		rv.add(new Trick("Dleg", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.outside_flips, 1));
		rv.add(new Trick("Gumbi", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips, 0));
		rv.add(new Trick("Raiz", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips, 0));
		rv.add(new Trick("TDR", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips, 0));
		rv.add(new Trick("Sideswipe", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.outside_flips, 1));
		//outside twists
		rv.add(new Trick("Snapu", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.outside_twists, 3));
		//inside tricks
		rv.add(new Trick("Sideflip", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks, 1));
		rv.add(new Trick("Frisbee", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks, 1));
		rv.add(new Trick("Cartwheel", false, false, new Stance[]{Stance.forwards, Stance.sideways}, new Stance[]{Stance.sideways, Stance.backwards}, TrickCategory.inside_tricks, 0));
		rv.add(new Trick("Helicoptero", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.inside_tricks, 0));
		rv.add(new Trick("Aerial", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks, 0));
		rv.add(new Trick("Scoot", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.inside_tricks, 0));
		rv.add(new Trick("Master Scoot", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.inside_tricks, 0));
		rv.add(new Trick("Grand Master Swipe", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks, 1));
		
		return rv;
	}
	
	
	public static List<Trick> setAllTricksActiveHelper(List<Trick> list) {
		for(Trick t : list) {
			t.isActive = true;
		}
		return list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stance[] getTake_off_stances() {
		return take_off_stances;
	}

	public void setTake_off_stances(Stance[] take_off_stances) {
		this.take_off_stances = take_off_stances;
	}

	public Stance[] getLanding_stances() {
		return landing_stances;
	}

	public void setLanding_stances(Stance[] landing_stances) {
		this.landing_stances = landing_stances;
	}

	public Boolean getCanSwingOnLanding() {
		return canSwingOnLanding;
	}

	public void setCanSwingOnLanding(Boolean canSwingOnLanding) {
		this.canSwingOnLanding = canSwingOnLanding;
	}

	public Boolean getDoesSwing() {
		return doesSwing;
	}

	public void setDoesSwing(Boolean doesSwing) {
		this.doesSwing = doesSwing;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TrickCategory getCategory() {
		return category;
	}

	public void setCategory(TrickCategory category) {
		this.category = category;
	}

	public int getStrucWeight() {
		return strucWeight;
	}

	public void setStrucWeight(int strucWeight) {
		this.strucWeight = strucWeight;
	}
	
	
}
