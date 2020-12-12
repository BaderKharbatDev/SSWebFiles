package kickboticgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StrikeGeneration {
	public static class StrikeWeight {
		public Strike strike;
		public int weight;
		
		public StrikeWeight(Strike t) {
			strike = t;
			weight = 0;
		}
		
		public void inc(int val) {
			weight += val;
		}
	}

	public static List<Strike> normalGeneration(int n, List<Strike> list) {
		List<Strike> rv = new ArrayList<Strike>();
		Random rand = new Random();
		
		//Get Random move from list
		List<Strike> active_list = new ArrayList<Strike>();
		for(Strike t:list) {
			if(t.isActive) {
				active_list.add(t);
			}
		}
		Strike curr = active_list.get(rand.nextInt(active_list.size()));
		rv.add(curr);
		
		for(int i = 0; i < n - 1; i++) {
			curr = getMoveHelper(curr, list);
			rv.add(curr);
		}
		
		//for n-1 times get a following move and add it to return value
		return rv;
	}
	
	private static Strike getMoveHelper(Strike prev, List<Strike> list) {
		List<StrikeWeight> t_list = new ArrayList<StrikeWeight>();
		int max_weight = 0;
		
		//add all tricks that are active and who's endings match the prev's ending stance
		StrikeWeight weight;
		for(Strike after : list) {
			
			//checks if move is active
			if(after.isActive) {
				
				//inits weight to 0
				weight = new StrikeWeight(after);
				
				//algorithm
				
				//adds to end
				if(weight.weight < max_weight) {
					//dont add
				} else if(weight.weight == max_weight) {
					t_list.add(weight);
				} else if(weight.weight > max_weight) {
					max_weight = weight.weight;
					t_list.clear();
					t_list.add(weight);
				}
			}
		}
		
		//return random move from compatable moves
		Random r = new Random();
		return t_list.get(r.nextInt(t_list.size())).strike;
	}	
}
