/**
 * 
 */
package ca.csf.dfc.classe;

/**
 * @author administrateur
 *
 */
public class Table {
	
	public Table()
	{
		Paquet p=new Paquet(1); 
		Hand h=new Hand();
		//p.brasserCartes();
		System.out.println(p.getCardListFromDeck());
		for (int i = 0; i <5; i++) {
			h.getCardFromHand().add(p.getCardListFromDeck().get(i));
		}
		System.out.println(h.getCardFromHand());
		h.sortHand();
		h.checkHand();
		System.out.println(h.getCardFromHand());
		
	}

}
