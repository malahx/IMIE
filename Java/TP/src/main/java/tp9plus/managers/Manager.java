package tp9plus.managers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import tp9plus.entities.Charact;
import tp9plus.entities.Donjon;
import tp9plus.entities.Mob;
import tp9plus.utils.Color;

public class Manager {

	public void enterDonjon(Donjon donjon, Charact character) {
		if (character instanceof Mob) {
			donjon.getMonsters().add(character);
			System.out.println(
					Color.CYAN + "The Monster " + character.getName() + " entered " + donjon.getName() + Color.RESET);
		} else {
			donjon.getPersons().add(character);
			System.out.println(
					Color.CYAN + "The Person " + character.getName() + " entered " + donjon.getName() + Color.RESET);
		}
	}

	public void donjonFight(Donjon donjon) {
		while (!teamIsDead(donjon.getPersons()) && !teamIsDead(donjon.getMonsters())) {
			fightAll(donjon, donjon.getPersons(), donjon.getMonsters());
			fightAll(donjon, donjon.getMonsters(), donjon.getPersons());
		}
		if (!teamIsDead(donjon.getPersons())) {
			System.out.println(Color.PURPLE + Color.BOLD + "Persons WIN !!!" + Color.RESET);
		} else {
			System.out.println(Color.PURPLE + Color.BOLD + "Monsters WIN !!!" + Color.RESET);
		}
	}

	private void fightAll(Donjon donjon, List<Charact> characts1, List<Charact> characts2) {
		for (Charact c : characts1) {
			if (c.isDead()) {
				System.out.println(Color.RED + c.getName() + " is dead" + Color.RESET);
				continue;
			}
			System.out.println(
					Color.YELLOW + c.getName() + " begin the fight with a " + c.getWeapon().getName() + Color.RESET);
			fight(donjon, c, characts2);
		}
	}

	private void fight(Donjon donjon, Charact currentAttack, List<Charact> characts) {
		for (int i = currentAttack.getPa(); i > 0; i -= currentAttack.getWeapon().getPa()) {
			while (!teamIsDead(characts)) {
				Charact currentEnnemi = characts.get(ThreadLocalRandom.current().nextInt(0, characts.size()));
				if (currentEnnemi.isDead()) {
					continue;
				}
				if (currentEnnemi.willEsquive(ThreadLocalRandom.current().nextInt(0, 100))) {
					System.out.println(" -- " + currentEnnemi.getName() + " have dodged");
					break;
				}
				int dmg = currentAttack.attack(currentEnnemi);
				if (currentEnnemi.isDead()) {
					System.out.println(Color.RED + " -- " + currentEnnemi.getName() + " have been killed" + Color.RESET);
					donjon.getLoots().add(currentEnnemi.getArmor());
					System.out.println(Color.YELLOW + " ---- " + currentEnnemi.getName() + " has drop a " + currentEnnemi.getArmor().getName() + Color.RESET);
					donjon.getLoots().add(currentEnnemi.getWeapon());
					System.out.println(Color.YELLOW + " ---- " + currentEnnemi.getName() + " has drop a " + currentEnnemi.getWeapon().getName() + Color.RESET);
					if (currentEnnemi instanceof Mob) {
						Mob mob = (Mob) currentEnnemi;
						donjon.getLoots().add(mob.getLoot());
						System.out.println(Color.YELLOW + " ---- " + mob.getName() + " has drop his " + mob.getLoot().getName() + Color.RESET);
					}
					currentEnnemi.setArmor(null);
					currentEnnemi.setWeapon(null);
				} else {
					System.out.println(Color.GREEN + " -- " + currentEnnemi.getName() + " received " + dmg + " degat" + Color.RESET);
				}
				break;
			}
		}
	}

	private boolean teamIsDead(List<Charact> characts) {
		for (Charact c : characts) {
			if (!c.isDead()) {
				return false;
			}
		}
		return true;
	}
}
