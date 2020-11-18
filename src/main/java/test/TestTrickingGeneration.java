package test;

import java.util.List;

import trickinggenerator.Generation;
import trickinggenerator.Trick;

public class TestTrickingGeneration {

	public static void main(String[] args) {
		List<Trick> list = Trick.getAllMoves();
		list = Trick.setAllTricksActiveHelper(list);
//		List<Trick> gen = Generation.creativeGeneration(3, list);
//		List<Trick> gen = Generation.creativeSpecificGeneration(4, "Full", 3, list); 
		List<Trick> gen = Generation.structuredGeneration(4, 1, list);
		for(Trick t:gen) {
			System.out.println(t.name);
		}
	} 
}
