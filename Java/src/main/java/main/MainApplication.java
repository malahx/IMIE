/**
 * 
 */
package main;

import main.entities.Role;
import main.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setFirstname("Jean-Louis");
		user.getRoles().add(new Role(1, "ROLE_ADMIN"));
		user.getRoles().add(new Role(2, "ROLE_USER"));
		System.out.println(user.toString());
		System.out.println(user.getRoles());
	}

}
