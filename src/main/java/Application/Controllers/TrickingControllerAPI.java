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
			String[] str = {"Number of moves must be 0-100."};
			return new ResponseEntity( str, HttpStatus.BAD_REQUEST );
		}
		
		List<Trick> list = new ArrayList<Trick>();
		for(Trick t:trickF.tricks) {
			list.add(t);
		}
		List<Trick> generatedList = Generation.creativeGeneration(trickF.n, list);
		return new ResponseEntity( generatedList, HttpStatus.OK );
    }
	
	
}
