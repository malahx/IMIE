/**
 * 
 */
package tpfichier;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author malah
 *
 */
public class TpL1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String currentFile = "fichier";

		int nb = ThreadLocalRandom.current().nextInt(41, 43);
		System.out.println("nb " + nb);
		String string = String.valueOf(nb);

		FileCreate.write(currentFile, string);
		
	}

}
