/**
 * 
 */
package tp;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AsciiArt {

	private final static int ASCII_MIN = 32;
	private final static int ASCII_MAX = 126;
	
	private final static String[] PATTERN = { "Bulbhead", "Rectangles", "Rand" };

	private final static int[] WIDTH_1 = { 8, 6, 6, 7, 6, 6, 6, 7, 6, 7, 6, 6, 8, 6, 7, 6, 7, 6, 5, 6, 8, 6, 8, 6, 6,
			6, 5 };
	private final static String[] PATTERN_1 = {
			"   __    ____   ___  ____   ____  ____   ___  _   _  ____   ____  _  _  __    __  __  _  _  _____  ____  _____  ____  ___  ____  __  __  _  _  _    _  _  _  _  _  ____  ___ ",
			"  /__\\  (  _ \\ / __)(  _ \\ ( ___)( ___) / __)( )_( )(_  _) (_  _)( )/ )(  )  (  \\/  )( \\( )(  _  )(  _ \\(  _  )(  _ \\/ __)(_  _)(  )(  )( \\/ )( \\/\\/ )( \\/ )( \\/ )(_   )(__ )",
			" /(__)\\  ) _ <( (__  )(_) ) )__)  )__) ( (_-. ) _ (  _)(_ .-_)(   )  (  )(__  )    (  )  (  )(_)(  )___/ )(_)(  )   /\\__ \\  )(   )(__)(  \\  /  )    (  )  (  \\  /  / /_  (_/ ",
			"(__)(__)(____/ \\___)(____/ (____)(__)   \\___/(_) (_)(____)\\____) (_)\\_)(____)(_/\\/\\_)(_)\\_)(_____)(__)  (___/\\\\(_)\\_)(___/ (__) (______)  \\/  (__/\\__)(_/\\_) (__) (____) (_) " };

	private final static int[] WIDTH_2 = { 7 };
	private final static String[] PATTERN_2 = {
			" _____  _____  _____  ____   _____  _____  _____  _____  _____     __  _____  __     _____  _____  _____  _____  _____  _____  _____  _____  _____  _____  _ _ _  __ __  __ __  _____  _____ ",
			"|  _  || __  ||     ||    \\ |   __||   __||   __||  |  ||     | __|  ||  |  ||  |   |     ||   | ||     ||  _  ||     || __  ||   __||_   _||  |  ||  |  || | | ||  |  ||  |  ||__   ||___  |",
			"|     || __ -||   --||  |  ||   __||   __||  |  ||     ||-   -||  |  ||    -||  |__ | | | || | | ||  |  ||   __||  |  ||    -||__   |  | |  |  |  ||  |  || | | ||-   -||_   _||   __|  |  _|",
			"|__|__||_____||_____||____/ |_____||__|   |_____||__|__||_____||_____||__|__||_____||_|_|_||_|___||_____||__|   |__  _||__|__||_____|  |_|  |_____| \\___/ |_____||__|__|  |_|  |_____|  |_|  ",
			"                                                                                                                   |__|                                                                 |_|  " };

	public static Scanner lire;

	/**
	 * 
	 * @param msg
	 *            message à afficher
	 * @param min
	 *            nombre minimal
	 * @param max
	 *            nombre maximal
	 * @return l'entier saisit
	 */
	public static int select(String msg, int min, int max) {
		System.out.println(msg);
		int n;
		do {
			n = select();
		} while (n < min || n > max);
		return n;
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
			System.out.println("Sélectionnez un chiffre de " + 1 +  " à " + tab.length + " :");
			n = select();
		} while (n < 1 || n > tab.length);
		return n;
	}

	/**
	 * 
	 * @param msg
	 *            message à afficher
	 * @return l'entier saisit
	 */
	public static int select(String msg) {
		System.out.println(msg);
		return select();
	}

	/**
	 * 
	 * @return l'entier saisit
	 */
	public static int select() {
		while (!lire.hasNextInt()) {
			System.out.println("Veuillez saisir un nombre !");
			lire.next();
		}
		int n = lire.nextInt();
		return n;
	}

	/**
	 * 
	 * @param pattern
	 *            le pattern à utiliser
	 * @param width
	 *            la largeur des lettres
	 * @param msg
	 *            le message à dessiner
	 * @return le message dessiné
	 */
	private static String[] usePatern(String[] pattern, int[] width, String msg) {
		String[] result = new String[pattern.length];
		char[] chars = msg.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				int n = (int) chars[i] - 65;
				int begin = 0;
				int end = 0;
				int k;
				if (n < 0 || n > 26) {
					begin = pattern[j].length() - (width.length == 1 ? width[0] : width[width.length -1]);
					end = pattern[j].length();
				} else {
					for (k = 0; k < n; k++) {
						begin += (width.length == 1 ? width[0] : width[k]);
					}
					end = begin + (width.length == 1 ? width[0] : width[k]);
				}
				if (result[j] != null) {
					result[j] += pattern[j].substring(begin, end);
				} else {
					result[j] = pattern[j].substring(begin, end);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param l largeur
	 * @param h hauteur
	 * @return le pattern généré
	 */
	private static String[] generatePattern(int l, int h) {
		String[] pattern = new String[h];
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < h; j++) {
				if (pattern[j] == null) {
					pattern[j] = "";
				}
				for (int k = 0; k < l; k++) {
					int rand = ThreadLocalRandom.current().nextInt(ASCII_MIN, ASCII_MAX +1);
					pattern[j] += (char) rand;
				}
			}			
		}
		return pattern;
	}

	/**
	 * 
	 * @param val
	 *            le tableau à afficher
	 */
	private static void draw(String[] val) {
		System.out.println("Résultat :");
		for (int i = 0; i < val.length; i++) {
			System.out.println(val[i] + "");
		}
	}
	
	/**
	 * 
	 * @param pattern le pattern à afficher
	 * @param width la largeur de lettre
	 * @param height la hauteur de lettre
	 */
	private static void drawPattern(String[] pattern, int[] width, int height) {
		System.out.println("Le pattern :");
		for (int j = 0; j < 26; j++) {
			String s = "" + (char)(j +65);
			for (int k = 0; k < (width.length == 1 ? width[0] : width[j]); k++) {
				System.out.print(s);
			}
		}
		for (int i = 0; i < width[width.length -1]; i++) {
			System.out.print("?");
		}
		System.out.println("");
		for (int i = 0; i < height; i++) {
			System.out.println(pattern[i]);
		}	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		lire = new Scanner(System.in);
		System.out.println("Saisir le message à dessiner :");
		String msg = lire.nextLine().toUpperCase();
		int n = select("Quel pattern voulez vous utiliser ?", PATTERN);
		String[] pattern;
		int[] width = new int[1];
		switch (n) {
		case 1:
			width = WIDTH_1;
			pattern = PATTERN_1;
			break;
		case 2:
			width = WIDTH_2;
			pattern = PATTERN_2;
			break;
		default:
			width[0] = select("Saisir la largeur de lettre", 1, 10) ;
			int height = select("Saisir la hauteur de lettre", 1, 10);
			pattern = generatePattern(width[0], height);
			break;
		}
		lire.close();
		
		drawPattern(pattern, width, pattern.length);
		System.out.println();
		draw(usePatern(pattern, width, msg));
	}

}
