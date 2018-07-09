/**
 * 
 */
package tpfichier;

import java.util.List;

/**
 * @author malah
 *
 */
public class TpL2 {
	public static void main(String[] args) {

		String currentFile = "fichier";
		List<String> data = FileCreate.read(currentFile);
		for (String string : data) {
			System.out.println(string);
		}
	}
}
