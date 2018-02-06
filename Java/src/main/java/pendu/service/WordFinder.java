/**
 * 
 */
package pendu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pendu.entity.Response;
import pendu.entity.Result;

/**
 * @author malah
 *
 */
@Service
@Component("wordFinderService")
public class WordFinder {

	Result theWord;

	public Response hasIt(char c) {
		theWord.add(c);
		return theWord.getResponse();
	}

	/**
	 * @param word
	 * @return
	 */
	public String isSolution(String word) {
		return theWord.is(word);
	}

	public WordFinder() {
		super();
		List<String> lines = read("fr.txt");
		theWord = new Result(lines.get(ThreadLocalRandom.current().nextInt(0, lines.size())));
	}

	private List<String> read(String currentFile) {
		List<String> result = new ArrayList<>();
		File file = new File(currentFile);
		Path path = Paths.get(file.getAbsolutePath());
		try (InputStream in = Files.newInputStream(path);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		return result;
	}

}
