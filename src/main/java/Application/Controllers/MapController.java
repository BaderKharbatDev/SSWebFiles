package Application.Controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trickinggenerator.Trick;

@Controller
public class MapController implements ErrorController{
	
	private static final String PATH = "/error";

    @GetMapping(value = PATH)
    public String error(final Model model) {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
	
    @GetMapping({"", "/", "/home", "/index"})
	public String getMain() {
		return "index";
	}
	
    @GetMapping({"/tricking"})
	public String getTrickingGen() {
		return "tricking";
	}
    
    @GetMapping({"/applications"})
	public String getApplications() {
		return "applications";
	}
    
    @GetMapping({"/contact"})
	public String getContactPage() {
		return "contact";
	}
    
    @GetMapping({"/kickbotic"})
	public String getKickboticPage() {
		return "kickbotic";
	}
    
    //--------------------------
    
    @GetMapping({"/old-tricking"})
	public String getTrickingOldGen() {
		return "tricking_simple";
	}

}
