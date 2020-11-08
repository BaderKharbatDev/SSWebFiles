package trickinggenerator;

import java.util.ArrayList;
import java.util.List;

public class Trick {
	
	public String name;
	public Stance[] take_off_stances;
	public Stance[] landing_stances;
	public Boolean canSwingOnLanding;
	public Boolean doesSwing;
	public Boolean isActive; //only neccessary for the api call
	public TrickCategory category;
	
	public Trick(String name, Boolean canSwingOnLanding, Boolean doesSwing, Stance[] take_off_stances, Stance[] landing_stances, TrickCategory category) {
		super();
		this.name = name;
		this.take_off_stances = take_off_stances;
		this.landing_stances = landing_stances;
		this.canSwingOnLanding = canSwingOnLanding;
		this.doesSwing = doesSwing;
		this.category = category;
	}
	
	public List<Trick> getAllMoves() {
		List<Trick> rv = new ArrayList<Trick>();
		//normal kicks
		rv.add(new Trick("Round Kick", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.normal_kicks));
		rv.add(new Trick("Hook Kick", false, false, new Stance[]{Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.normal_kicks));
		rv.add(new Trick("Frontsweep", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.normal_kicks));
		rv.add(new Trick("Backsweep", false, false, new Stance[]{Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.normal_kicks));
		rv.add(new Trick("Touch Down Round", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.normal_kicks));
		//pop kicks
		rv.add(new Trick("Pop 360", false, false, new Stance[]{Stance.r_sideways, Stance.forwards}, new Stance[]{Stance.r_sideways}, TrickCategory.pop_kicks));
		rv.add(new Trick("Backside 900", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.pop_kicks));
		//cheat kicks
		rv.add(new Trick("Tornado", true, false, new Stance[]{Stance.r_sideways, Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.cheat_kicks));
		rv.add(new Trick("Cheat 720", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks));
		rv.add(new Trick("Jack Knife", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks));
		rv.add(new Trick("Cheat 900", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.cheat_kicks));
		//swing kicks
		rv.add(new Trick("Swing Over Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.cheat_kicks));
		//flat spins
		rv.add(new Trick("Butterfly Kick", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.flat_spins));
		rv.add(new Trick("Machine", true, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.sideways, Stance.backwards}, TrickCategory.flat_spins));
		rv.add(new Trick("Spider", true, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.flat_spins));
		//flat twists
		rv.add(new Trick("Btwist", true, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways, Stance.backwards}, TrickCategory.flat_twists));
		rv.add(new Trick("Btwist Round", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.flat_twists));
		rv.add(new Trick("Btwist Hyper Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.flat_twists));
		//backwards_flips
		rv.add(new Trick("Back Hand Spring", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips));
		rv.add(new Trick("Back Tuck", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_flips));
		rv.add(new Trick("Flash Kick", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips));
		rv.add(new Trick("Arabian", false, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.forwards}, TrickCategory.backward_flips));
		rv.add(new Trick("Cheat Gainer", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.backward_flips));
		rv.add(new Trick("Gainer Switch", true, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_flips));
		rv.add(new Trick("Moon Kick", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.sideways}, TrickCategory.backward_flips));
		//backwards_twists
		rv.add(new Trick("Cart Full", true, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists));
		rv.add(new Trick("Cart Full Hyper Hook", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.backward_twists));
		rv.add(new Trick("Full", true, false, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists));
		rv.add(new Trick("Cork", true, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.backwards}, TrickCategory.backward_twists));
		rv.add(new Trick("Boxcutter", false, true, new Stance[]{Stance.backwards}, new Stance[]{Stance.sideways}, TrickCategory.backward_twists));
		//forward_flips
		rv.add(new Trick("Dive Roll", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards, Stance.sideways, Stance.r_sideways}, TrickCategory.forward_flips));
		rv.add(new Trick("Reversao", false, false, new Stance[]{Stance.forwards, Stance.sideways}, new Stance[]{Stance.r_sideways}, TrickCategory.forward_flips));
		rv.add(new Trick("Front Tuck", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards}, TrickCategory.forward_flips));
		rv.add(new Trick("Webster", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.forward_flips));
		rv.add(new Trick("Roundoff", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.forward_flips));
		//forward twists
		rv.add(new Trick("360 Dive Roll", false, false, new Stance[]{Stance.forwards}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.forward_twists));
		rv.add(new Trick("A-twist", false, false, new Stance[]{Stance.forwards, Stance.sideways}, new Stance[]{Stance.backwards}, TrickCategory.forward_twists));
		//outside flips
		rv.add(new Trick("Parafuso", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.outside_flips));
		rv.add(new Trick("Dleg", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.backwards, Stance.sideways}, TrickCategory.outside_flips));
		rv.add(new Trick("Gumbi", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips));
		rv.add(new Trick("Raiz", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips));
		rv.add(new Trick("TDR", true, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.outside_flips));
		rv.add(new Trick("Sideswipe", false, false, new Stance[]{Stance.sideways, Stance.r_sideways}, new Stance[]{Stance.sideways}, TrickCategory.outside_flips));
		//outside twists
		rv.add(new Trick("Snapu", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.outside_twists));
		//inside tricks
		rv.add(new Trick("Sideflip", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks));
		rv.add(new Trick("Frisbee", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks));
		rv.add(new Trick("Cartwheel", false, false, new Stance[]{Stance.forwards, Stance.sideways}, new Stance[]{Stance.sideways, Stance.backwards}, TrickCategory.inside_tricks));
		rv.add(new Trick("Helicoptero", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.forwards, Stance.r_sideways}, TrickCategory.inside_tricks));
		rv.add(new Trick("Aerial", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks));
		rv.add(new Trick("Scoot", false, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.inside_tricks));
		rv.add(new Trick("Master Scoot", false, false, new Stance[]{Stance.sideways, Stance.forwards}, new Stance[]{Stance.backwards}, TrickCategory.inside_tricks));
		rv.add(new Trick("Grand Master Swipe", false, false, new Stance[]{Stance.sideways}, new Stance[]{Stance.sideways}, TrickCategory.inside_tricks));
		
		return rv;
	}
}
