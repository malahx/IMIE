package tp9plus;

import java.util.ArrayList;
import java.util.List;

import tp9plus.entities.armor.Armor;
import tp9plus.entities.armor.MagicalArmor;
import tp9plus.entities.armor.MixedArmor;
import tp9plus.entities.armor.PhysicalArmor;
import tp9plus.entities.person.Elementalist;
import tp9plus.entities.person.Warrior;
import tp9plus.entities.weapon.MagicalWeapon;
import tp9plus.entities.weapon.PhysicalWeapon;
import tp9plus.entities.weapon.Weapon;
import tp9plus.entities.Charact;
import tp9plus.entities.Donjon;
import tp9plus.entities.Fighter;
import tp9plus.entities.Mob;
import tp9plus.managers.Manager;

public class MainApplication {

	private static List<Weapon> initWeapon() {
		List<Weapon> w = new ArrayList<>();
		Weapon w1 = new PhysicalWeapon("Sword", 40, 4);
		Weapon w2 = new MagicalWeapon("Staff", 55, 6);
		Weapon w3 = new PhysicalWeapon("Hammer", 45, 10);
		w.add(w1);
		w.add(w2);
		w.add(w3);
		return w;
	}

	private static List<Armor> initArmor() {
		List<Armor> a = new ArrayList<>();
		Armor a1 = new PhysicalArmor("Krytan Armor", 35);
		Armor a2 = new MagicalArmor("Canthan Cuirass", 30);
		Armor a3 = new MixedArmor("Monster Hide", 25);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		return a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Weapon> weapons = initWeapon();
		List<Armor> armors = initArmor();

		Charact p1 = new Warrior("Koss", (PhysicalWeapon) weapons.get(0), (PhysicalArmor) armors.get(0), 100, 20);
		Charact p2 = new Elementalist("Zhed Shadowhoof", (MagicalWeapon) weapons.get(1), (MagicalArmor) armors.get(1),
				100, 20);

		Charact m1 = new Mob("Grawl", weapons.get(2), armors.get(2), 100, 20, new Fighter() {
			
			@Override
			public int attack(Charact c) {
				return c.attack(c);
			}
		});
		Charact m2 = new Mob("Charr", weapons.get(2), armors.get(2), 100, 20);
		Charact m3 = new Mob("Ettin", weapons.get(2), armors.get(2), 100, 20);

		Donjon donjon = new Donjon("Catacombs of Kathandrax");

		Manager manager = new Manager();

		manager.enterDonjon(donjon, p1);
		manager.enterDonjon(donjon, p2);
		manager.enterDonjon(donjon, m1);
		manager.enterDonjon(donjon, m2);
		manager.enterDonjon(donjon, m3);

		manager.donjonFight(donjon);

	}

}
