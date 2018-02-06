package spaceexplo.entities;

import java.util.ArrayList;

public class Planet {

	private String name;
	private ArrayList<Cosmonaut> cosmonauts;
	private ArrayList<Vessel> vessels;

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
	 * @return the vessels
	 */
	public ArrayList<Vessel> getVessels() {
		return vessels;
	}

	/**
	 * @param vessels
	 *            the vessels to set
	 */
	public void setVessels(ArrayList<Vessel> vessels) {
		this.vessels = vessels;
	}

	/**
	 * @param name
	 */
	public Planet(String name) {
		super();
		this.name = name;
		this.cosmonauts = new ArrayList<>();
		this.vessels = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
