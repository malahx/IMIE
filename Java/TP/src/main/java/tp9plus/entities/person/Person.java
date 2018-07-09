/**
 * 
 */
package tp9plus.entities.person;

import tp9plus.entities.Charact;
import tp9plus.entities.armor.Armor;
import tp9plus.entities.weapon.Weapon;

public abstract class Person extends Charact {

	protected Person(String name, Weapon weapon, Armor armor, int pv, int pa) {
		super(name, weapon, armor, pv, pa);
	}

}
