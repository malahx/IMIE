package tp9plus.entities.armor;

import tp9plus.entities.TypeDamage;

public class MagicalArmor extends Armor {

	public MagicalArmor(String name, int defense) {
		super(name, defense, TypeDamage.MAGICAL);
	}

}
