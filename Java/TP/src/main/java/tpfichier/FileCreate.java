/**
 * 
 */
package tpfichier;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author malah
 *
 */
public class FileCreate {

	static void write(String currentFile, String content) {
		File file = new File(currentFile);
		Path path = Paths.get(file.getAbsolutePath());
		byte data[] = content.getBytes();
		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, CREATE, TRUNCATE_EXISTING))) {
			out.write(data, 0, data.length);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

	}

	static List<String> read(String currentFile) {
		List<String> result = new ArrayList<>();
		File file = new File(currentFile);
		Path path = Paths.get(file.getAbsolutePath());
		try (InputStream in = Files.newInputStream(path);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			if ((line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		return result;
	}

}
