/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.*;

/**
 * @author administrateur
 *
 */
public abstract class HandAbstract {
	private List<Carte> m_FiveCardHandList;
	public boolean isStraightFlush;
	public boolean isFourOfAKind;
	public boolean isFullHouse;
	public boolean isFlush;
	public boolean isStraight;
	public boolean isTriple;
	public boolean isTwoPairs;
	public boolean isPair;
	public boolean isOnlyHighCard;
	public int m_HandValue = 0;
	public int m_HandValueSupp1;
	public int m_HandValueSupp2;

	public void getHandResult() {
		this.checkIfFullHouse();
		this.checkIfFlush();
		this.checkIfStraightFlush();
		this.checkForAnythingElse();
		this.checkIfStraight();
		System.out.println(m_HandValue);
		System.out.println(m_HandValueSupp1);
	}

	public void getHandStrength() {
	}

	public HandAbstract() {
		this.m_FiveCardHandList = new ArrayList<Carte>();
	}

	public List<Integer> makeListOfFourteenIndex() {
		List<Integer> li = new ArrayList<Integer>();
		int compteurTab = 0;
		for (int i = 0; i < 15; i++) {
			compteurTab = 0;
			for (int j = 0; j < 5; j++) {
				{
					if (this.getCardFromHand().get(j).getCarteValue() == i) {
						compteurTab++;
					}
				}

			}
			li.add(i, compteurTab);
		}
		return li;
	}
	public void checkForAnythingElse() {
		boolean alreadyOnePair = false;
		List<Integer> test = makeListOfFourteenIndex();
		for (int i = 0; i < test.size(); i++) {
			if (test.get(i) == 2 && alreadyOnePair) {
				System.out.println("deuxieme pair de " + i);
				this.isTwoPairs = true;
				this.m_HandValue = 60;
				this.m_HandValueSupp2 = i;
			} else if (test.get(i) == 2) {
				System.out.println("pair de " + i);
				alreadyOnePair = true;
				this.isPair = true;
				this.m_HandValue = 40;
				this.m_HandValueSupp1 = i;
				// System.out.println(i + " " + m_HandValue + " " + m_HandValueSupp1);
			} else if (test.get(i) == 3) {
				System.out.println("triple de " + i);
				this.isTriple = true;
				this.m_HandValue = 80;
				this.m_HandValueSupp1 = i;

			} else if (test.get(i) == 4) {
				this.isFourOfAKind = true;
				this.m_HandValue = 160;
				this.m_HandValueSupp1 = i;
				System.out.println("carré de " + i);
			}

		}

	}
	public List<Carte> getCardFromHand() {
		return this.m_FiveCardHandList;
	}

	public void addCardToHand(Carte p_Carte) {
		this.m_FiveCardHandList.add(p_Carte);
	}

	public void checkIfFullHouse() {
		if (this.isPair && this.isTriple) {
			this.isFullHouse = true;
			this.m_HandValue = 140;
		}
	}

	public void checkIfFlush() {
		boolean continueLoop = true;
		int index = 0;
		while (index <= 3 && continueLoop) {
			continueLoop = false;
			if (this.getCardFromHand().get(4).getAtout() == this.getCardFromHand().get(index).getAtout()) {
				continueLoop = true;
			} else
				continueLoop = false;
			index++;

		}

		if (continueLoop) {
			this.isFlush = true;
			this.m_HandValue = 120;
			this.m_HandValueSupp1 = this.getCardFromHand().get(0).getCarteValue();

			System.out.println("vraiFLUSH");
		} else {
			this.isFlush = false;
			System.out.println("fauxFLUSH");
		}

	}

	public void checkIfStraightFlush() {
		if (this.isFlush && this.isStraight)
			this.isStraightFlush = true;

		if (this.isStraightFlush) {
			System.out.println("vraiSF");
			this.m_HandValue = 180;
			this.m_HandValueSupp1 = this.getCardFromHand().get(0).getCarteValue();
		}

		else
			System.out.println("fauxSF");
	}

	public void checkIfStraight() {
		boolean continueLoop = true;
		int index = 1;
		while (index < 5 && continueLoop == true) {
			continueLoop = false;
			// verifie si ex.:65432 la carte suivante == la carte-1
			if (this.getCardFromHand().get(index - 1)
					.getCarteValue() == this.getCardFromHand().get(index).getCarteValue() + 1) {
				continueLoop = true;
			}
			////// pour debug
			// System.out.println(index);
			index++;
			///////////////
		}
		if (continueLoop) {
			this.isStraight = true;
			/////// debug
			System.out.println("vraiSTRAIGHT");
			this.m_HandValue = 100;
			this.m_HandValueSupp1 = this.getCardFromHand().get(0).getCarteValue();
		} else {
			this.isStraight = false;
			//////// debug
			System.out.println("fauxSTRAIGHT");
		}
	}

	public String toString() {
		return m_FiveCardHandList.get(0).toString() + " " + m_FiveCardHandList.get(1).toString() + " "
				+ m_FiveCardHandList.get(2).toString() + " " + m_FiveCardHandList.get(3).toString() + " "
				+ m_FiveCardHandList.get(4).toString();
	}

	public void sortHand() {
		boolean sorted = false;
		Carte temp = new Carte();
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < 5; i++) {
				if (this.m_FiveCardHandList.get(i - 1).getCarteValue() < this.m_FiveCardHandList.get(i)
						.getCarteValue()) {
					temp = this.m_FiveCardHandList.get(i - 1);
					this.m_FiveCardHandList.remove(i - 1);
					this.m_FiveCardHandList.add(i, this.m_FiveCardHandList.get(i - 1));
					this.m_FiveCardHandList.remove(i);
					this.m_FiveCardHandList.add(i, temp);
					sorted = false;
				}

			}

		}

	}

}
