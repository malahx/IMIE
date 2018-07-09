/**
 * 
 */
package spaceexplo;

import spaceexplo.businesscode.Manager;
import spaceexplo.entities.Cosmonaut;
import spaceexplo.entities.Planet;
import spaceexplo.entities.Vessel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Init
		
		Planet p1 = new Planet("Kerbin");
		Planet p2 = new Planet("Duna");
		Planet p3 = new Planet("Moon");
		
		Cosmonaut c1 = new Cosmonaut("Kerman", "Jebediah", p1);
		Cosmonaut c2 = new Cosmonaut("Kerman", "Bill", p1);
		Cosmonaut c3 = new Cosmonaut("Kerman", "Bob", p1);
		Cosmonaut c4 = new Cosmonaut("Kerman", "Valentina", p1);
		
		Vessel v1 = new Vessel("Ariane 3", "Rocket", p1);
		Vessel v2 = new Vessel("Ariane 4", "Rocket", p1);
		
		Manager m = new Manager();
		
		// Play
		
		System.out.println("EMBARKMENTS");
		m.embarkTo(v1, c1);
		m.embarkTo(v1, c2);
		m.embarkTo(v1, c3);
		m.embarkTo(v2, c4);
		
		System.out.println("TRIPS");
		m.goToPlanet(p2, v1);
		m.launchToOrbit(v1);
		m.goToPlanet(p2, v1);
		m.landFromOrbit(v1);
		m.disembarkFrom(v1, c1);
		m.launchToOrbit(v1);
		m.goToPlanet(p3, v1);
		m.landFromOrbit(v1);
		m.disembarkFrom(v1, c2);
		
		System.out.println("WHERE ARE YOU?");
		m.draw(p1);
		m.draw(p2);
		m.draw(p3);
		
	}

}
