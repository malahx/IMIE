/**
 * 
 */
package tp;

import java.util.Scanner;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public class Ex2 {

	private static Scanner lire;

	/**
	 * 
	 * @param s
	 *            la chaîne à chiffrer
	 * @param key
	 *            la clé de chiffrement
	 * @return la tableau chiffrée
	 */
	public static int[] secure(String s, int key) {
		int[] val = new int[s.length()];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int a = (int) chars[i];
			val[i] = a*(a  - 1) + key;
		}
		return val;
	}

	/**
	 * 
	 * @param b
	 *            le code ASCII chiffré
	 * @return la valeur ASCII
	 */
	public static int result(int b) {
		for (int i = 1; i <= 127; i++) {
			if (b == i*(i - 1)) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param val
	 *            le tableau chiffré
	 * @param key
	 *            la clé
	 * @return la chaîne déchiffré
	 */
	public static String unsecure(int[] val, int key) {
		String s = "";
		for (int i = 0; i < val.length; i++) {
			int a = val[i] - key;
			s += (char) result(a);
			val[i] = (a * a - a + key);
		}
		return s;
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
	 * @param val
	 *            le tableau à afficher
	 */
	private static void draw(int[] val) {
		System.out.print("[");
		for (int i = 0; i < val.length; i++) {
			System.out.print(val[i]);
			if (i < val.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lire = new Scanner(System.in);
		System.out.println("Saisir le message à chiffrer :");
		String val = lire.nextLine();
		System.out.println("Saisir la clé de chiffrement :");
		int key = select();
		lire.close();
		int[] secure = secure(val, key);
		draw(secure);
		String unsecure = unsecure(secure, key);
		if (val.equals(unsecure)) {
			System.out.println("Le déchiffrage est bon !");
			System.out.println("Saisie : \"" + val + "\"");
			System.out.println("Déchiffrage : \"" + unsecure + "\"");
		} else {
			System.out.println("Le déchiffrage est mauvais :'(");
		}
	}

}
