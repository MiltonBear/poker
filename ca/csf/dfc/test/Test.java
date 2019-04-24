package ca.csf.dfc.test;

import static org.junit.jupiter.api.Assertions.*;

import ca.csf.dfc.classe.Carte;
import ca.csf.dfc.classe.Hand;

class Test {

	Carte Deux = new Carte("2", "coeur", 2);
	Carte trois = new Carte("3", "coeur", 3);
	Carte quatre = new Carte("4", "coeur", 4);
	Carte cinq = new Carte("5", "coeur", 5);
	Carte six = new Carte("6", "coeur", 6);
	Carte sept = new Carte("7", "coeur", 7);
	Carte huit = new Carte("8", "coeur", 8);
	Carte neuf = new Carte("9", "coeur", 9);
	Carte dix = new Carte("10", "coeur", 10);
	Carte onze = new Carte("11", "coeur", 11);
	Carte douze = new Carte("12", "coeur", 12);
	Carte treize = new Carte("13", "coeur", 13);
	Carte quatorze = new Carte("14", "coeur", 14);

	@org.junit.jupiter.api.Test
	void testStraightFourToEight() {

		Hand h = new Hand();

		h.addCardToHand(six);
		h.addCardToHand(cinq);
		h.addCardToHand(quatre);
		h.addCardToHand(sept);
		h.addCardToHand(huit);
		h.sortHand();
		h.checkIfStraight();

		// assertEquals(true, h.checkIfStraight());
		assertTrue(h.isStraight);

	}

	@org.junit.jupiter.api.Test
	void testStraightTrue2() {
		Hand h = new Hand();

		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixPique);
		h.addCardToHand(onze);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(quatorze);
		h.sortHand();
		h.checkIfStraight();
		assertTrue(h.isStraight);

	}

	@org.junit.jupiter.api.Test
	void testFalseStraight() {
		Hand h = new Hand();

		h.addCardToHand(quatre);
		h.addCardToHand(cinq);
		h.addCardToHand(dix);
		h.addCardToHand(sept);
		h.addCardToHand(huit);
		h.sortHand();
		h.checkIfStraight();
		assertFalse(h.isStraight);
	}

	@org.junit.jupiter.api.Test
	void testFlushTrue() {
		Hand h = new Hand();
		h.addCardToHand(dix);
		h.addCardToHand(cinq);
		h.addCardToHand(douze);
		h.addCardToHand(sept);
		h.addCardToHand(trois);
		h.checkIfFlush();
		assertTrue(h.isFlush);

	}

	@org.junit.jupiter.api.Test
	void testFlushFalse() {
		Hand h = new Hand();
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.addCardToHand(douze);
		h.addCardToHand(sept);
		h.addCardToHand(trois);
		h.checkIfFlush();
		assertFalse(h.isFlush);

	}

	@org.junit.jupiter.api.Test
	void testStraightFlush() {
		Hand h = new Hand();
		h.addCardToHand(six);
		h.addCardToHand(cinq);
		h.addCardToHand(quatre);
		h.addCardToHand(sept);
		h.addCardToHand(trois);
		h.sortHand();
		h.checkIfFlush();
		h.checkIfStraight();
		h.checkIfStraightFlush();
		assertTrue(h.isStraightFlush);

	}

	@org.junit.jupiter.api.Test
	void testStraightFlushFalse() {
		Hand h = new Hand();
		h.addCardToHand(quatre);
		h.addCardToHand(cinq);
		h.addCardToHand(dix);
		h.addCardToHand(sept);
		h.addCardToHand(huit);
		h.sortHand();
		h.checkIfFlush();
		h.checkIfStraight();
		h.checkIfStraightFlush();
		assertFalse(h.isStraightFlush);

	}

	@org.junit.jupiter.api.Test
	void testStraightFlushFalse2() {
		Hand h = new Hand();
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixPique);
		h.addCardToHand(onze);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(quatorze);
		h.checkIfStraightFlush();
		assertFalse(h.isStraightFlush);
	}

	@org.junit.jupiter.api.Test
	void testFourOfAKind() {
		Hand h = new Hand();
		Carte dixcoeur = new Carte("10", "coeur", 10);
		Carte dixtriangle = new Carte("10", "triangle", 10);
		Carte dixrond = new Carte("10", "rond", 10);
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixcoeur);
		h.addCardToHand(dixtriangle);
		h.addCardToHand(dixrond);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.checkForAnythingElse();
		assertTrue(h.isFourOfAKind);

	}

	@org.junit.jupiter.api.Test
	void testFourOfAKindFalse() {
		Hand h = new Hand();
		Carte dixcoeur = new Carte("11", "coeur", 11);
		Carte dixtriangle = new Carte("10", "triangle", 10);
		Carte dixrond = new Carte("10", "rond", 10);
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixcoeur);
		h.addCardToHand(dixtriangle);
		h.addCardToHand(dixrond);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.checkForAnythingElse();
		assertFalse(h.isFourOfAKind);

	}

	@org.junit.jupiter.api.Test
	void testThreeOfAKind() {
		Hand h = new Hand();
		Carte dixcoeur = new Carte("11", "coeur", 11);
		Carte dixtriangle = new Carte("10", "triangle", 10);
		Carte dixrond = new Carte("10", "rond", 10);
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixcoeur);
		h.addCardToHand(dixtriangle);
		h.addCardToHand(dixrond);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.checkForAnythingElse();
		assertTrue(h.isTriple);
	}

	@org.junit.jupiter.api.Test
	void testThreeOfAKindFalse() {
		Hand h = new Hand();
		Carte dixcoeur = new Carte("11", "coeur", 11);
		Carte dixtriangle = new Carte("1", "triangle", 1);
		Carte dixrond = new Carte("10", "rond", 10);
		Carte dixPique = new Carte("10", "pique", 10);
		h.addCardToHand(dixcoeur);
		h.addCardToHand(dixtriangle);
		h.addCardToHand(dixrond);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.checkForAnythingElse();
		assertFalse(h.isTriple);

	}
	@org.junit.jupiter.api.Test
	void testTwoPair()
	{
		Hand h=new Hand();

		Carte dixrond = new Carte("10", "rond", 13);
		Carte dixPique = new Carte("10", "pique", 12);
		h.addCardToHand(trois);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(dixPique);
		h.addCardToHand(dixrond);
		h.checkForAnythingElse();
		assertTrue(h.isTwoPairs);
		
	}
	@org.junit.jupiter.api.Test
	void testTwoPairFalse()
	{
		Hand h=new Hand();

		Carte dixrond = new Carte("10", "rond", 1);
		Carte dixPique = new Carte("10", "pique", 12);
		h.addCardToHand(trois);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(dixPique);
		h.addCardToHand(dixrond);
		h.checkForAnythingElse();
		assertFalse(h.isTwoPairs);
		
	}
	@org.junit.jupiter.api.Test
	void testPairTrue()
	{
		Hand h=new Hand();

		Carte dixrond = new Carte("10", "rond", 1);
		Carte dixPique = new Carte("10", "pique", 12);
		h.addCardToHand(trois);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(dixPique);
		h.addCardToHand(dixrond);
		h.checkForAnythingElse();
		assertTrue(h.isPair);
		
	}
	@org.junit.jupiter.api.Test
	void testPairFalse()
	{
		Hand h=new Hand();

        h.addCardToHand(quatre);
		h.addCardToHand(trois);
		h.addCardToHand(douze);
		h.addCardToHand(treize);
		h.addCardToHand(dix);
		h.checkForAnythingElse();
		assertFalse(h.isPair);
		 
	}
	@org.junit.jupiter.api.Test
	void testFullHouse()
	{
		Hand h = new Hand();
		Carte dixcoeur = new Carte("11", "coeur", 11);
		Carte dixtriangle = new Carte("1", "triangle", 11);
		Carte dixrond = new Carte("10", "rond", 5);
		Carte dixPique = new Carte("10", "pique",5);
		h.addCardToHand(dixcoeur);
		h.addCardToHand(dixtriangle);
		h.addCardToHand(dixrond);
		h.addCardToHand(dixPique);
		h.addCardToHand(cinq);
		h.checkForAnythingElse();
		assertTrue(h.isFullHouse);
	}

}
