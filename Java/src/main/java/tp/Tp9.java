/**
 * 
 */
package tp;

import java.util.Scanner;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public class Tp9 {

	// Constantes
	public final static int PLAYER_WEAPON = 0;
	public final static int PLAYER_ARMOR = 1;
	public final static int PLAYER_PV = 2;
	public final static int PLAYER_PA = 3;
	public final static int WEAPON_DMG = 0;
	public final static int WEAPON_PA = 1;
	public final static String WEAPONS_NAME[] = { "Concasseur", "Pelle", "Gatling", "Batte de cricket", "Blaster" };
	public final static int WEAPONS[][] = { { 3, 4 }, { 2, 1 }, { 10, 6 }, { 1, 1 }, { 6, 3 } };
	public final static String ARMORS_NAME[] = { "Gilet bleu", "Armure de cuir", "Armure de plaque" };
	public final static int ARMORS[] = { 1, 2, 4 };
	
	// Variables
	public static Scanner lire;

	/**
	 * 
	 * @param msg message à afficher
	 * @param tab tableau à afficher
	 * @return l'entier saisit
	 */
	public static int select(String msg, String[] tab) {
		System.out.println(msg);
		for (int i = 0; i < tab.length; i++) {
			System.out.println((i + 1) + " " + tab[i]);
		}
		return select();
	}

	/**
	 * 
	 * @param msg message à afficher
	 * @return l'entier saisit
	 */
	public static int select(String msg) {
		System.out.println(msg);
		return select();
	}

	/**
	 * 
	 * @return l'entier saisit
	 */
	public static int select() {
		while (!lire.hasNextInt()) {
			System.out.println("Veuillez saisir un nombre !");
			lire.next();
		}
		int n = lire.nextInt();
		return n;
	}

	/**
	 * 
	 * @param players tableau de joueurs
	 * @param currentPlayer l'id du joueur courant
	 * @param maxPlayers le nombre de joueurs total
	 * @return l'id du joueur suivant
	 */
	public static int getNextPlayer(int[][] players, int currentPlayer, int maxPlayers) {
		int nextPlayer = currentPlayer;
		do {
			nextPlayer++;
			if (nextPlayer > maxPlayers - 1) {
				nextPlayer = 0;
			}
		} while (players[nextPlayer][PLAYER_PV] <= 0 && currentPlayer != nextPlayer);
		return nextPlayer;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("TP9");
		
		lire = new Scanner(System.in);
		
		// Saisit du nombre de joueur
		
		int maxPlayers = select("Sélectionnez le nombre de joueurs : ");
		int players[][] = new int[maxPlayers][4];

		// Saisit des joueurs
		for (int i = 0; i < maxPlayers; i++) {
			System.out.println("Saisie du joueur N°" + (i + 1));
			int n;
			do {
				n = select("Sélectionnez l'indice de votre arme", WEAPONS_NAME) - 1;
			} while (n < 0 || n >= WEAPONS.length);
			players[i][PLAYER_WEAPON] = n;
			do {
				n = select("Sélectionnez l'indice de votre armure", ARMORS_NAME) - 1;
			} while (n < 0 || n >= ARMORS.length);
			players[i][PLAYER_ARMOR] = n;
			players[i][PLAYER_PV] = select("Sélectionnez vos points de vie");
			players[i][PLAYER_PA] = select("Sélectionnez vos points d'action");
			System.out.print("arme " + WEAPONS_NAME[players[i][PLAYER_WEAPON]]);
			System.out.print(", " + ARMORS_NAME[players[i][PLAYER_ARMOR]]);
			System.out.print(", point de vie " + players[i][PLAYER_PV]);
			System.out.print(", point d'action " + players[i][PLAYER_PA]);
			System.out.println();
		}
		lire.close();
		
		// Combat entre les joueurs
		System.out.println("FIGHT !");
		int vainqueur = -1;
		int j = 0;
		while (vainqueur == -1) {
			
			// Début d'un tour
			for (int currentPlayer = 0; currentPlayer < maxPlayers; currentPlayer++) {
				int player[] = players[currentPlayer];
				int pv = player[PLAYER_PV];
				
				if (pv <= 0) {
					// Arrêt joueur mort
					continue;
				}
				
				System.out.println("Joueur N°" + (currentPlayer + 1) + " attaque");
				int weapon = player[PLAYER_WEAPON];
				int dmgWeapon = WEAPONS[weapon][WEAPON_DMG];
				int paWeapon = WEAPONS[weapon][WEAPON_PA];
				int pa = player[PLAYER_PA] -1;
				
				// Attaque tant qu'il peut
				while (pa - paWeapon >= 0) {
					int nextPlayer = getNextPlayer(players, currentPlayer, maxPlayers);
					if (currentPlayer == nextPlayer) {
						// Le joueur à gagné car il n'a plus d'enemi vivant
						vainqueur = currentPlayer;
						break;
					}
					int armorNextPlayer = players[nextPlayer][PLAYER_ARMOR];
					int dmg = dmgWeapon - ARMORS[armorNextPlayer];
					System.out.println(
							" --- le joueur N°" + (nextPlayer + 1) + " et inflige " + (dmg > 0 ? dmg : 0) + " dégat.");
					players[nextPlayer][PLAYER_PV] -= (dmg > 0 ? dmg : 0);
					if (players[nextPlayer][PLAYER_PV] <= 0) {
						System.out.println(" -------- le joueur N°" + (nextPlayer + 1) + " est mort.");
					}
					pa -= paWeapon;
				}
			}
			j++;
		}
		System.out.println("Le joueur N°" + (vainqueur + 1) + " à gagné!");
		System.out.println("et il lui reste " + players[vainqueur][PLAYER_PV] + " pv");
		System.out.println("en " + j + " tours");
	}
}
