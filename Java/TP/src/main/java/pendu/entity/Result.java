/**
 * 
 */
package pendu.entity;

/**
 * @author malah
 *
 */
public class Result {

	private final String result;
	private String alreadyDone;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @return the alreadyDone
	 */
	public String getAlreadyDone() {
		return alreadyDone;
	}

	/**
	 * @param alreadyDone
	 *            the alreadyDone to set
	 */
	public void add(char c) {
		this.alreadyDone += c;
	}

	public Response getResponse() {
		String s = result.replaceAll("[^" + alreadyDone + "]", "_");
		return new Response(alreadyDone.length(), s);
	}

	/**
	 * @param result
	 */
	public Result(String result) {
		super();
		this.result = result;
		alreadyDone = "";
	}

	/**
	 * @param word
	 * @return
	 */
	public String is(String word) {
		return result.equals(word) ? "You win!" : "No";
	}

}
