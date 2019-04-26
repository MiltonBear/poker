/**
 * 
 */
package ca.csf.dfc.classe;

import ca.csf.dfc.classe.*;

/**
 * @author administrateur
 *
 */
public class Table {

	public Paquet m_Paquet;
	public HandPlayer m_HandPlayer;
	public HandCasino m_Casino;

	public Table() {
		m_Paquet = new Paquet(1);
		m_HandPlayer = new HandPlayer();
		m_Casino = new HandCasino();
		m_Paquet.brasserCartes();

		System.out.println(m_Paquet.getCardListFromDeck());
		for (int i = 0; i < 5; i++) {
			m_HandPlayer.getCardFromHand().add(m_Paquet.distribuerCarte());
			m_Casino.getCardFromHand().add(m_Paquet.distribuerCarte());
		}
		System.out.println(m_HandPlayer.toString());
		System.out.println(m_Casino.toString());
	
		// System.out.println(m_H);
		//m_HandPlayer.sortHand();
		//m_HandPlayer.checkHand();
		// System.out.println(m_HandPlayer.getCardFromHand());

	}

}
