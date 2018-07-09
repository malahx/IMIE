/**
 * 
 */
package pendu.entity;

/**
 * @author malah
 *
 */
public class Response {
	private int number;
	private String response;

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @param number
	 * @param response
	 */
	public Response(int number, String response) {
		super();
		this.number = number;
		this.response = response;
	}

}
