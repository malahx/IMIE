package tp9plus.entities.armor;

import tp9plus.entities.TypeDamage;

public class PhysicalArmor extends Armor {

	public PhysicalArmor(String name, int defense) {
		super(name, defense, TypeDamage.PHYSICAL);
	}
}
