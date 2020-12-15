package test;

import java.util.List;

import kickboticgenerator.Strike;
import kickboticgenerator.StrikeGeneration;

public class TestKickBoxingGeneration {

	public static void main(String[] args) {
		List<Strike> list = Strike.getAllMoves();
		List<Strike> gen = StrikeGeneration.normalGeneration(4, list);
		for(Strike t:gen) {
			System.out.println(t.name);
		}
	}
}
