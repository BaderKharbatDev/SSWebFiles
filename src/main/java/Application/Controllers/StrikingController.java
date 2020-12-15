package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kickboticgenerator.Strike;
import kickboticgenerator.StrikeCategory;
import kickboticgenerator.StrikeForm;
import kickboticgenerator.StrikeGeneration;
import trickinggenerator.Generation;
import trickinggenerator.Trick;
import trickinggenerator.TrickCategory;
import trickinggenerator.TrickForm;

@RestController
public class StrikingController {

	@GetMapping ( "/striking/OrderedStrikes" )
    public ResponseEntity getAllTricks( ) {
		List<Strike> list = Strike.getAllMoves();
        return new ResponseEntity( list, HttpStatus.OK );
    }
	
	@GetMapping ( "/striking/Categories")
	public ResponseEntity getCategories( ) {
		StrikeCategory[] list = StrikeCategory.values();
		List<String> rv = new ArrayList<String>();
		for( StrikeCategory t: list) {
			rv.add(t.toString());
		}
		
        return new ResponseEntity( rv, HttpStatus.OK );
    }
	
	@PostMapping ( "/striking/NormalGeneration" )
    public ResponseEntity generateCreative(@RequestBody StrikeForm strikeF) {
		if(strikeF.n < 1 || strikeF.n > 100) {
			String[] str = {"Number of moves must be 1-100."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		
		List<Strike> list = new ArrayList<Strike>();
		for(Strike t:strikeF.strikes) {
			list.add(t);
		}
		try {
			List<Strike> generatedList = StrikeGeneration.normalGeneration(strikeF.n, list);
			return new ResponseEntity( generatedList, HttpStatus.OK );
		} catch (IllegalArgumentException e) {
			String s = "Not Enough Moves Selected from the Filter Menu";
			String[] str = {s};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
    }

	
}
