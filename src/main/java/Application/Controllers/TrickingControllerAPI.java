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

import trickinggenerator.Generation;
import trickinggenerator.Trick;
import trickinggenerator.TrickCategory;
import trickinggenerator.TrickForm;

@RestController
public class TrickingControllerAPI {

	@GetMapping ( "/tricking/OrderedTricks" )
    public ResponseEntity getAllTricks( ) {
		List<Trick> list = Trick.getAllMoves();
        return new ResponseEntity( list, HttpStatus.OK );
    }
	
	@GetMapping ( "/tricking/Categories")
	public ResponseEntity getCategories( ) {
		TrickCategory[] list = TrickCategory.values();
		List<String> rv = new ArrayList<String>();
		for( TrickCategory t: list) {
			rv.add(t.toString());
		}
		
        return new ResponseEntity( rv, HttpStatus.OK );
    }
	
	@PostMapping ( "/tricking/CreativeGeneration" )
    public ResponseEntity generateCreative(@RequestBody TrickForm trickF) {
		if(trickF.n < 1 || trickF.n > 100) {
			String[] str = {"Number of moves must be 1-100."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		
		List<Trick> list = new ArrayList<Trick>();
		for(Trick t:trickF.tricks) {
			list.add(t);
		}
		try {
			List<Trick> generatedList = Generation.creativeGeneration(trickF.n, list);
			return new ResponseEntity( generatedList, HttpStatus.OK );
		} catch (IllegalArgumentException e) {
			String s = "Not Enough Moves Selected from the Filter Menu";
			String[] str = {s};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
    }
	
	@PostMapping ( "/tricking/StructuredGeneration" )
    public ResponseEntity generateStructured(@RequestBody TrickForm trickF) {
		if(trickF.n < 1 || trickF.n > 100) {
			String[] str = {"Number of moves must be 1-100."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		if(trickF.difficulty < 0 || trickF.difficulty > 3) {
			String[] str = {"Difficulty must be 0,1,2, or 3."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		
		List<Trick> list = new ArrayList<Trick>();
		for(Trick t:trickF.tricks) {
			list.add(t);
		}
		List<Trick> generatedList = Generation.structuredGeneration(trickF.n, trickF.difficulty, list);
		return new ResponseEntity( generatedList, HttpStatus.OK );
    }
	
	@PostMapping ( "/tricking/SpecificGeneration" )
    public ResponseEntity generateSpecific(@RequestBody TrickForm trickF) {
		if(trickF.n < 1 || trickF.n > 100) {
			String[] str = {"Number of moves must be 1-100."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		if(trickF.pos < 1 || trickF.pos > 3) {
			String[] str = {"Number of moves must be 1-3."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		
		List<Trick> list = new ArrayList<Trick>();
		for(Trick t:trickF.tricks) {
			list.add(t);
		}
		try {
			List<Trick> generatedList = Generation.creativeSpecificGeneration(trickF.n, trickF.specific, trickF.pos, list);
			return new ResponseEntity( generatedList, HttpStatus.OK );
		} catch (IllegalArgumentException e) {
			String s = "Not Enough Moves Selected from the Filter Menu";
			String[] str = {s};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
    }
	
}
