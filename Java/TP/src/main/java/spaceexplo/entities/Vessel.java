package spaceexplo.entities;

import java.util.ArrayList;

public class Vessel {

	private String name;
	private String type;
	private boolean orbited;
	private ArrayList<Cosmonaut> cosmonauts;
	private Planet planet;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cosmonauts
	 */
	public ArrayList<Cosmonaut> getCosmonauts() {
		return cosmonauts;
	}

	/**
	 * @param cosmonauts
	 *            the cosmonauts to set
	 */
	public void setCosmonauts(ArrayList<Cosmonaut> cosmonauts) {
		this.cosmonauts = cosmonauts;
	}

	/**
	 * @return the orbited
	 */
	public boolean isOrbited() {
		return orbited;
	}

	/**
	 * @param orbited
	 *            the orbited to set
	 */
	public void setOrbited(boolean orbited) {
		this.orbited = orbited;
	}

	/**
	 * @return the planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * @param planet
	 *            the planet to set
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * @param name
	 * @param type
	 */
	public Vessel(String name, String type, Planet p) {
		super();
		this.name = name;
		this.type = type;
		this.cosmonauts = new ArrayList<>();
		this.planet = p;
		p.getVessels().add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " (" + type + ")";
	}

}
