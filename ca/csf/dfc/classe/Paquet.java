/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author administrateur
 *
 */
public class Paquet {
	private int m_NbCartesTotal;
	private int m_NbPaquets;
	private List<Carte> m_CardListCardDeck;

	public int getNbCarte() {
		this.m_NbCartesTotal*=getNbPaquets();
		return this.m_NbCartesTotal;
	}

	public int getNbPaquets() {
		return this.m_NbPaquets;
	}

	public List<Carte> getCardListFromDeck() {
		return this.m_CardListCardDeck;
	}

	public Paquet(int p_NbPaquets) {
		// this.m_PaquetDeCarte=new ArrayList<Carte>();
		this.m_NbPaquets = p_NbPaquets;
		this.m_CardListCardDeck = new ArrayList<Carte>();
		int compteur = 0;
		while (compteur < p_NbPaquets) {
			int compteurAtout = 0;
			while (compteurAtout < Carte.CHOIX_ATOUT.length) {

				int compteurFace = 0;
				while (compteurFace < Carte.CHOIX_FACE.length) {
					int valeur = compteurFace + 2;
					Carte c = new Carte(Carte.CHOIX_FACE[compteurFace], Carte.CHOIX_ATOUT[compteurAtout], valeur);
					this.m_CardListCardDeck.add(c);
					compteurFace++;
				}
				compteurAtout++;

			}
			compteur++;
		}
	}

	public void brasserCartes() {
		for (int i = 0; i < this.m_CardListCardDeck.size(); i++) {
			Random rand = new Random();
			int random = rand.nextInt(this.m_CardListCardDeck.size());
			Carte carteTemporaire = this.m_CardListCardDeck.get(random);
			this.m_CardListCardDeck.remove(random);
			this.m_CardListCardDeck.add(i, carteTemporaire);
			
		}

	}



}
