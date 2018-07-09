package tp9plus.utils;

public class Utils {
	private static Utils instance;

	public static Utils getInstance() {
		if (instance == null) {
			instance = new Utils();
		}
		return instance;
	}

	public int limit(int n) {
		return n > 100 ? 100 : n < 0 ? 0 : n;
	}
	
	public String bolder(String s) {
		return Color.BOLD + s + Color.UNBOLD;
	}

	private Utils() {

	}

}
