package kickboticgenerator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import trickinggenerator.Trick;

public class Strike {
	@JsonProperty("name")
	public String name;
	@JsonProperty("type")
	public StrikeCategory type;
	@JsonProperty("difficulty")
	public StrikeDifficulty difficulty;
	@JsonProperty("distance")
	public StrikeDistance distance;
	@JsonProperty("rotation")
	public StrikeRotation rotation;
	@JsonProperty("isActive")
	public Boolean isActive;
	@JsonProperty("canRepeat")
	public Boolean canRepeat;
	
	public Strike() {
	}
	
	public Strike(String name, StrikeCategory type, StrikeDifficulty difficulty, StrikeDistance distance,
			StrikeRotation rotation, Boolean isActive, Boolean canRepeat) {
		super();
		this.name = name;
		this.type = type;
		this.difficulty = difficulty;
		this.distance = distance;
		this.rotation = rotation;
		this.isActive = isActive;
		this.canRepeat = canRepeat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StrikeCategory getType() {
		return type;
	}
	public void setType(StrikeCategory type) {
		this.type = type;
	}
	public StrikeDifficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(StrikeDifficulty difficulty) {
		this.difficulty = difficulty;
	}
	public StrikeDistance getDistance() {
		return distance;
	}
	public void setDistance(StrikeDistance distance) {
		this.distance = distance;
	}
	public StrikeRotation getRotation() {
		return rotation;
	}
	public void setRotation(StrikeRotation rotation) {
		this.rotation = rotation;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getCanRepeat() {
		return canRepeat;
	}
	public void setCanRepeat(Boolean canRepeat) {
		this.canRepeat = canRepeat;
	}
	
	public static List<Strike> getAllMoves() {
		List<Strike> rv = new ArrayList<Strike>();
		//kicks
		rv.add(new Strike("Knee", StrikeCategory.Kicks, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Teep", StrikeCategory.Kicks, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Front Kick", StrikeCategory.Kicks, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Round Kick", StrikeCategory.Kicks, StrikeDifficulty.Normal, StrikeDistance.Inbetween, StrikeRotation.Counter_Clockwise, true, true));
		rv.add(new Strike("Side Kick", StrikeCategory.Kicks, StrikeDifficulty.Hard, StrikeDistance.Far, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Turning Side Kick", StrikeCategory.Kicks, StrikeDifficulty.Hard, StrikeDistance.Far, StrikeRotation.Clockwise, true, false));
		//punches
		rv.add(new Strike("Jab", StrikeCategory.Punches, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Linear, true, true));
		rv.add(new Strike("Cross", StrikeCategory.Punches, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Counter_Clockwise, true, true));
		rv.add(new Strike("Lead Hook", StrikeCategory.Punches, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Clockwise, true, false));
		rv.add(new Strike("Rear Hook", StrikeCategory.Punches, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Counter_Clockwise, true, false));
		rv.add(new Strike("Lead Uppercut", StrikeCategory.Punches, StrikeDifficulty.Normal, StrikeDistance.Close, StrikeRotation.Clockwise, true, false));
		rv.add(new Strike("Rear Uppercut", StrikeCategory.Punches, StrikeDifficulty.Normal, StrikeDistance.Close, StrikeRotation.Counter_Clockwise, true, false));
		rv.add(new Strike("Left Elbow", StrikeCategory.Punches, StrikeDifficulty.Normal, StrikeDistance.Close, StrikeRotation.Clockwise, true, false));
		rv.add(new Strike("Right Elbow", StrikeCategory.Punches, StrikeDifficulty.Normal, StrikeDistance.Close, StrikeRotation.Counter_Clockwise, true, false));
		rv.add(new Strike("Turning Backfist", StrikeCategory.Punches, StrikeDifficulty.Hard, StrikeDistance.Inbetween, StrikeRotation.Clockwise, true, false));
		//Head Movement
		rv.add(new Strike("Slip", StrikeCategory.Head_Movement, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Roll", StrikeCategory.Head_Movement, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Lean Back", StrikeCategory.Head_Movement, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Linear, true, false));
		//Foot Movement
		rv.add(new Strike("Slide In", StrikeCategory.Foot_Movement, StrikeDifficulty.Easy, StrikeDistance.Far, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Slide Out", StrikeCategory.Foot_Movement, StrikeDifficulty.Easy, StrikeDistance.Close, StrikeRotation.Linear, true, false));
		rv.add(new Strike("Slide Left", StrikeCategory.Foot_Movement, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Clockwise, true, false));
		rv.add(new Strike("Slide Right", StrikeCategory.Foot_Movement, StrikeDifficulty.Easy, StrikeDistance.Inbetween, StrikeRotation.Counter_Clockwise, true, false));
		return rv;
	}
	
}
