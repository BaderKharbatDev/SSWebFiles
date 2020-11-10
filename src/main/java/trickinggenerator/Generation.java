package trickinggenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generation {
	
	public static class TrickWeight {
		public Trick trick;
		public int weight;
		
		public TrickWeight(Trick t) {
			trick = t;
			weight = 0;
		}
		
		public void inc(int val) {
			weight += val;
		}
	}

	public static List<Trick> creativeGeneration(int n, List<Trick> list) {
		List<Trick> rv = new ArrayList<Trick>();
		Random rand = new Random();
		
		//Get Random move from list
		Trick curr = list.get(rand.nextInt(list.size()));
		rv.add(curr);
		
		for(int i = 0; i < n - 1; i++) {
			curr = getNextCreativeMoveHelper(curr, list);
			rv.add(curr);
		}
		
		//for n-1 times get a following move and add it to return value
		return rv;
	}
		
	public void structuredGeneration(int n, int difficulty, List<Trick> list) {
		//TO-DO
	}
	
	//pos is either 1,2, or 3 for beg, mid, end
	public static List<Trick> creativeSpecificGeneration(int n, String name, int pos, List<Trick> list) {
		List<Trick> rv = new ArrayList<Trick>();
		
		n = n - 1;
		Trick curr = null;
		for(Trick t:Trick.getAllMoves()) {
			if(t.name.equalsIgnoreCase(name)) {
				curr = t;
				break;
			}
		}
		
		//checks for valid trick
		if(curr == null) {
			throw new IllegalArgumentException("No Such Trick Exists");
		}
		
		rv.add(curr);
		
		switch(pos) {
			case 1:
				//generates creative move after the specific move
				for(int i = 0; i < n; i++) {
					curr = getNextCreativeMoveHelper(curr, list);
					rv.add(curr);
				}
				break;
			case 2:
				//alternates between generation the beg and last move
				Boolean generatingFirst = true;
				for(int i = 0; i < n; i++) {
					if(generatingFirst) {
						curr = getLastCreativeMoveHelper(rv.get(0), list);
						rv.add(0, curr);
					} else {
						curr = getNextCreativeMoveHelper(rv.get(rv.size() - 1), list);
						rv.add(rv.size(), curr);
					}
					generatingFirst = !generatingFirst;
				}
				break;
			case 3:
				//generates move before the specific move
				for(int i = 0; i < n; i++) {
					curr = getLastCreativeMoveHelper(rv.get(0), list);
					rv.add(0, curr);
				}
				break;
		}
		
		return rv;
		
	}
	
	private static Trick getNextCreativeMoveHelper(Trick prev, List<Trick> list) {
		List<TrickWeight> t_list = new ArrayList<TrickWeight>();
		int max_weight = 0;
		
		//add all tricks that are active and who's endings match the prev's ending stance
		TrickWeight weight;
		for(Trick after : list) {
			
			//checks if move is active
			if(after.isActive) {
				
				//inits weight to 0
				weight = new TrickWeight(after);
				
				//compute whether any stances match
				Boolean compatable = false;
				for(Stance t1 : prev.landing_stances) {
					for(Stance t2 : after.take_off_stances) {
						if(t1 == t2) {
							compatable = true;
						}
					}
				}
				if(compatable) {
					weight.inc(1);
				}
				
				//computes swinging
				if(prev.canSwingOnLanding && after.doesSwing) {
					weight.inc(1);
				} else if (prev.canSwingOnLanding && !after.doesSwing) {
					weight.inc(1);
				}
				
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
		return t_list.get(r.nextInt(t_list.size())).trick;
	}
	
	private static Trick getLastCreativeMoveHelper(Trick after, List<Trick> list) {
		List<TrickWeight> t_list = new ArrayList<TrickWeight>();
		int max_weight = 0;
		
		//add all tricks that are active and who's endings match the prev's ending stance
		TrickWeight weight;
		for(Trick prev : list) {
			
			//checks if move is active
			if(prev.isActive) {
				
				//inits weight to 0
				weight = new TrickWeight(prev);
				
				//compute whether any stances match
				Boolean compatable = false;
				for(Stance t1 : prev.landing_stances) {
					for(Stance t2 : after.take_off_stances) {
						if(t1 == t2) {
							compatable = true;
						}
					}
				}
				if(compatable) {
					weight.inc(1);
				}
				
				//computes swinging
				if(prev.canSwingOnLanding && after.doesSwing) {
					weight.inc(1);
				} else if (prev.canSwingOnLanding && !after.doesSwing) {
					weight.inc(1);
				}
				
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
		return t_list.get(r.nextInt(t_list.size())).trick;
	}

}
