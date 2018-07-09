/**
 * 
 */
package tp;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public class Tp6 {

	private static Scanner lire;

	private final static String[][] CUISSONS = { 
			{ "Bleu", "tu devrais laisser cuire." },
			{ "Saignant", "tu devrais laisser cuire." }, 
			{ "A point", "tu as le droit d'être content." },
			{ "Brûlée", "t'es tristes, hein ? tu peux laisser cuire ..." } 
	};

	/**
	 * 
	 * @param msg
	 *            message à afficher
	 * @return si o a été sélectionné
	 */
	private static boolean yesNo(String msg) {
		System.out.println(msg);
		return lire.hasNext("o") && lire.next() != null;
	}

	/**
	 * 
	 * @param msg
	 *            message à afficher
	 * @param tab
	 *            tableau à afficher
	 * @return l'entier saisit
	 */
	public static int select(String msg, String[][] tab) {
		System.out.println(msg);
		for (int i = 0; i < tab.length; i++) {
			System.out.println((i + 1) + ") " + tab[i][0]);
		}
		int n;
		do {
			n = select();
		} while (n < 1 || n > tab.length);
		return n;
	}

	/**
	 * 
	 * @return l'entier saisit
	 */
	private static int select() {
		while (!lire.hasNextInt()) {
			System.out.println("Veuillez saisir un nombre !");
			lire.next();
		}
		int n = lire.nextInt();
		return n;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lire = new Scanner(System.in);
		if (!yesNo("Salut, l'étudiant, veux tu cuires tes côtes d'agneaux ? [o/N]")) {
			lire.close();
			return;
		}

		int n = select("Quelle cuisson ?", CUISSONS) - 1;
		int rand;
		int last = 0;
		do {
			rand = ThreadLocalRandom.current().nextInt(last, 3 + 1);
			System.out.print("La cuisson est " + CUISSONS[rand][0] + " ");
			if (rand == n) {
				break;
			} else if (rand > n) {
				System.out.println(CUISSONS[CUISSONS.length - 1][1]);
			} else {
				System.out.println(CUISSONS[rand][1]);
			}
			if (last < rand) {
				last = rand;
			}
		} while (yesNo("Souhaites tu laisser cuire les côtes d'agneaux ? [o/N]"));
		System.out.println("A table");
		lire.close();
	}
}
