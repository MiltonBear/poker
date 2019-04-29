/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author administrateur
 *
 */
public class DiscardPlayerStrategy implements DiscardStrategy {
	@Override
	/*
	 * public void DiscafrdACard(HandAbstract p_HandPlayer) { int compteur = 4;
	 * 
	 * while (compteur > 0) { System.out.println("quel carte #?"); Scanner
	 * scanCardNum = new Scanner(System.in); String scan = scanCardNum.nextLine();
	 * int index = Integer.parseInt(scan);
	 * 
	 * p_HandPlayer.discardACard(index - 1); compteur--; }
	 * 
	 * }
	 */

	public void DiscardACard(HandAbstract p_HandPlayer) {
		int index = 0;
		boolean bool = true;
		while (bool) {
			System.out.println("quel carte voulez vous changer #?");
			System.out.println("0 pour changer les cartes discarte(sortir)");
			System.out.println("6 pour voir les cartes gardes");
			System.out.print("7 pour main complete");
			Scanner scanCardNum = new Scanner(System.in);
			String scan = scanCardNum.nextLine();
			index = Integer.parseInt(scan);

			switch (index) {
			case 0:
				bool=false;
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				p_HandPlayer.getCardFromHand().get(index - 1).toggleDiscardedStatut();
				break;
			case 6:
				AfficherCarteGarde(p_HandPlayer);
				break;
			case 7:
				System.out.println(p_HandPlayer.toString());
				break;
			}

		}
	}

	private void AfficherCarteGarde(HandAbstract p_HandPlayer) {
		ArrayList<Carte> cardLeft = new ArrayList<Carte>();

		for (int i = 0; i < 5; i++) {
			if (p_HandPlayer.getCardFromHand().get(i).getDiscardedStatut() == false) {

				cardLeft.add(p_HandPlayer.getCardFromHand().get(i));
			}

		}
		System.out.print(cardLeft);
	}
}
