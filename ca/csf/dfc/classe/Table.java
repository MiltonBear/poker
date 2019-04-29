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
	public DiscardStrategy m_Strat;

	public void dealInitial()
	{
		for (int i = 0; i < 5; i++) {
			m_HandPlayer.getCardFromHand().add(m_Paquet.distribuerCarte());
			m_Casino.getCardFromHand().add(m_Paquet.distribuerCarte());
		}
	}
	public void DealNewCards(HandAbstract p_Hand)
	{
		for (int i = 0; i < 5; i++) {
			if (p_Hand.getCardFromHand().get(i).getDiscardedStatut()==true)
			{
				p_Hand.getCardFromHand().remove(i);
				p_Hand.getCardFromHand().add(i, m_Paquet.distribuerCarte());
			}
		}
	}
	public Table() {
		m_Strat=new DiscardPlayerStrategy();
		m_Paquet = new Paquet(1);
		m_HandPlayer = new HandPlayer();
		m_Casino = new HandCasino();
		m_Paquet.brasserCartes();

		System.out.println(m_Paquet.getCardListFromDeck());
		

		dealInitial();
		m_HandPlayer.sortHand();
		System.out.println(m_HandPlayer.toString());
		m_Strat.DiscardACard(m_HandPlayer);
		DealNewCards(m_HandPlayer);
		m_HandPlayer.sortHand();
		//System.out.println(m_HandPlayer.toString());
		
		this.m_HandPlayer.getHandResult();
		
		
		System.out.println(m_HandPlayer.getCardFromHand());
	//	System.out.println(m_Casino.toString());
	
		// System.out.println(m_H);
		//m_HandPlayer.sortHand();
		//m_HandPlayer.checkHand();
	

	}

}
