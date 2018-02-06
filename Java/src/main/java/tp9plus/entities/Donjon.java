/**
 * 
 */
package tp9plus.entities;

import java.util.ArrayList;
import java.util.List;

import tp9plus.utils.Utils;

public class Donjon {
	private String name;
	private List<Charact> persons;
	private List<Charact> monsters;
	private List<Loot> loots;

	/**
	 * @return the name
	 */
	public String getName() {
		return Utils.getInstance().bolder(name);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the persons
	 */
	public List<Charact> getPersons() {
		return persons;
	}

	/**
	 * @param persons
	 *            the persons to set
	 */
	public void setPersons(List<Charact> persons) {
		this.persons = persons;
	}

	/**
	 * @return the monsters
	 */
	public List<Charact> getMonsters() {
		return monsters;
	}

	/**
	 * @param monsters
	 *            the monsters to set
	 */
	public void setMonsters(List<Charact> monsters) {
		this.monsters = monsters;
	}

	/**
	 * @return the loots
	 */
	public List<Loot> getLoots() {
		return loots;
	}

	/**
	 * @param loots
	 *            the loots to set
	 */
	public void setLoots(List<Loot> loots) {
		this.loots = loots;
	}

	/**
	 * @param name
	 */
	public Donjon(String name) {
		super();
		this.name = name;
		this.persons = new ArrayList<>();
		this.monsters = new ArrayList<>();
		this.loots = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Donjon [name=" + name + "]\n  persons=[" + persons + "]\n  monsters=[" + monsters + "]";
	}

}
