/**
 * 
 */
package tpfichier;

import java.util.List;

/**
 * @author malah
 *
 */
public class TpL3 {
	public static void main(String[] args) {
		String currentFile = "fichier";
		String value = "";
		List<String> data = FileCreate.read(currentFile);

		if (!data.isEmpty() && data.get(0).equals("42")) {
			value = "4242";
		} else {
			value = "42";
		}
		System.out.println("value " + value);
		FileCreate.write(currentFile, value);
		System.out.println(value);
	}
}
