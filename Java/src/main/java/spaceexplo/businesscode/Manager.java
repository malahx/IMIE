/**
 * 
 */
package spaceexplo.businesscode;

import spaceexplo.entities.Cosmonaut;
import spaceexplo.entities.Planet;
import spaceexplo.entities.Vessel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Manager {

	public void embarkTo(Vessel v, Cosmonaut c) {
		if (v.getCosmonauts().contains(c)) {
			System.out.println(c + " is already on the vessel " + v);
			return;
		}
		Planet p = v.getPlanet();
		if (!p.getCosmonauts().contains(c)) {
			System.out.println(c + "is not on the same planet as the vessel " + v);
			return;
		}
		p.getCosmonauts().remove(p.getCosmonauts().indexOf(c));
		v.getCosmonauts().add(c);
		System.out.println(c + " embark to " + v);
	}

	public void disembarkFrom(Vessel v, Cosmonaut c) {
		if (!v.getCosmonauts().contains(c)) {
			System.out.println(c + " is not on the vessel " + v);
			return;
		}
		if (v.isOrbited()) {
			System.out.println(v + "isn't landed!");
			return;
		}
		v.getCosmonauts().remove(v.getCosmonauts().indexOf(c));
		v.getPlanet().getCosmonauts().add(c);
		System.out.println(c + " disembark from " + v);
	}

	public void launchToOrbit(Vessel v) {
		if (v.isOrbited()) {
			System.out.println(v + " is already in orbit!");
			return;
		}
		v.setOrbited(true);
		System.out.println(v + " goes to orbit");
	}

	public void landFromOrbit(Vessel v) {
		if (!v.isOrbited()) {
			System.out.println(v + " is already in landed!");
			return;
		}
		v.setOrbited(false);
		System.out.println(v + " landed");

	}

	public void goToPlanet(Planet p, Vessel v) {
		if (!v.isOrbited()) {
			System.out.println(v + " is landed on a planet, you need to launch!");
			return;
		}
		if (p.getVessels().contains(v)) {
			System.out.println(v + " is already arround the planet " + p);
			return;
		}
		p.getVessels().add(v);
		Planet oldP = v.getPlanet();
		oldP.getVessels().remove(oldP.getVessels().indexOf(v));
		v.setPlanet(p);
		System.out.println(v + " go to the planet " + p);
	}

	public void draw(Vessel v) {
		System.out.println("The vessel " + v + (v.isOrbited() ? " is in orbit arround " : " is landed on ") + v.getPlanet() + " and has:");
		for (Cosmonaut c : v.getCosmonauts()) {
			System.out.println("vv " + c);
		}
	}
	
	public void draw(Planet p) {
		System.out.println("The planet " + p + " has:");
		System.out.println("pp Cosmonauts:");
		for (Cosmonaut c : p.getCosmonauts()) {
			System.out.println("pp cc " + c);
		}
		System.out.println("pp Vessels:");
		for (Vessel v : p.getVessels()) {
			System.out.println("pp vv " + v);
			draw(v);
		}
	}
	
}
