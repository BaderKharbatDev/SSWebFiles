/**
 * 
 */
package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bader
 *
 */
@SpringBootApplication
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.getProperties().put( "server.port", 80 );
		SpringApplication.run(App.class, args);
	}

}
