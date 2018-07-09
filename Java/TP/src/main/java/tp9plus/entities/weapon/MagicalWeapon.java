package tp9plus.entities.weapon;

import tp9plus.entities.TypeDamage;

public class MagicalWeapon extends Weapon {
	
	public MagicalWeapon(String name, int damage, int pa) {
		super(name, damage, pa, TypeDamage.MAGICAL);
	}
	
}
