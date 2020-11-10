package trickinggenerator.test;

import java.util.List;

import trickinggenerator.Generation;
import trickinggenerator.Trick;

public class TestTrickingGeneration {

	public static void main(String[] args) {
		List<Trick> list = Trick.getAllMoves();
		list = Trick.setAllTricksActiveHelper(list);
		List<Trick> gen = Generation.creativeGeneration(3, list);
//		List<Trick> gen = Generation.creativeSpecificGeneration(2, "Cork", 3, list);
		for(Trick t:gen) {
			System.out.println(t.name);
		}
	} 
}
