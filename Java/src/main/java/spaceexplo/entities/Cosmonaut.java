/**
 * 
 */
package spaceexplo.entities;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Cosmonaut {

	private String firstname;
	private String lastname;

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param firstname
	 * @param lastname
	 */
	public Cosmonaut(String firstname, String lastname, Planet p) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		p.getCosmonauts().add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}

}
