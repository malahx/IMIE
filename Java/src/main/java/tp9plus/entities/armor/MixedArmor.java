package tp9plus.entities.armor;

import tp9plus.entities.TypeDamage;

public class MixedArmor extends Armor {

	public MixedArmor(String name, int defense) {
		super(name, defense, TypeDamage.MIXED);
	}

}
