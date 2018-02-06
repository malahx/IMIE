/**
 * 
 */
package tp;

import java.util.Scanner;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Tp7 {

	private static Scanner lire;

	private final static String[] CAFE = { 
			"Moka", "Typica Sucré", "Java", "Moka Noir", "Typica Noir", "Bourbon",
			"Java du développeur", "Maté" 
	};
	private final static int MACHINE_BAC = 0;
	private final static int MACHINE_CON = 1;
	private final static int MACHINE_VOL = 2;
	private final static int[] MACHINE = { -1, -1, -1 };
	private final static int[] VOL_BAC = { 100, 100, 100, 100 };

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
	public static int select(String msg, String[] tab) {
		System.out.println(msg);
		for (int i = 0; i < tab.length; i++) {
			System.out.println((i + 1) + ") " + tab[i]);
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
	 * @param args
	 */
	public static void main(String[] args) {
		lire = new Scanner(System.in);
		while (true) {
			if (!yesNo("Voulez vous une boisson chaude ? [o/N]")) {
				lire.close();
				return;
			}
			int n = select("Sélectionnez votre boisson :", CAFE);

			switch (n) {
			case 1:
			case 2:
			case 3:
			case 4:
				MACHINE[MACHINE_BAC] = 1;
				MACHINE[MACHINE_CON] = 1;
				break;
			case 5:
			case 6:
				MACHINE[MACHINE_BAC] = 2;
				MACHINE[MACHINE_CON] = 1;
				break;
			case 7:
				MACHINE[MACHINE_BAC] = 3;
				MACHINE[MACHINE_CON] = 2;
				break;
			case 8:
				MACHINE[MACHINE_BAC] = 4;
				break;
			default:
				break;
			}

			switch (n) {
			case 1:
			case 3:
			case 4:
			case 6:
				MACHINE[MACHINE_VOL] = 10;
				break;
			case 2:
			case 5:
			case 7:
				MACHINE[MACHINE_VOL] = 25;
				break;
			case 8:
				MACHINE[MACHINE_VOL] = 12;
				break;
			default:
				break;
			}

			System.out.println("---- Le bac " + MACHINE[MACHINE_BAC] + " a été sélectionné.");
			if (VOL_BAC[MACHINE[MACHINE_BAC]] - MACHINE[MACHINE_VOL] <= 0) {
				System.out.println("/!\\ il ne reste plus assez de café dans le bac " + MACHINE[MACHINE_BAC]);
				return;
			}
			if (MACHINE[MACHINE_CON] != -1) {
				System.out.println("---- Le concasseur " + MACHINE[MACHINE_CON] + " est démarré.");
			}
			for (int i = 0; i < MACHINE[MACHINE_VOL]; i++) {
				VOL_BAC[MACHINE[MACHINE_BAC]]--;
				System.out.println(
						"---- Verser une unité de " + 
						CAFE[n - 1] + 
						(MACHINE[MACHINE_CON] != -1 ? " moulu" : "")
				);
			}
			System.out.println("------ Volume total versé de : " + MACHINE[MACHINE_VOL] + " unités.");
			System.out.println("---- Dans le bac " + MACHINE[MACHINE_BAC] + " il reste " + VOL_BAC[MACHINE[MACHINE_BAC]]
					+ " unités.");
		}
	}

}
