/**
 * 
 */
package pendu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pendu.entity.Response;
import pendu.service.WordFinder;

/**
 * @author malah
 *
 */
@RestController
public class PenduController {

	@Autowired
	WordFinder wordFinder;

	@RequestMapping("/wordhas")
	public Response wordhas(@RequestParam(value = "letter") char letter) {
		return wordFinder.hasIt(letter);
	}

	@RequestMapping("/is")
	public String is(@RequestParam(value = "word") String word) {
		return wordFinder.isSolution(word);
	}
}
