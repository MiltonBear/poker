/**
 * 
 */
package ca.csf.dfc.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ca.csf.dfc.classe.Carte;
import ca.csf.dfc.classe.Table;
 

/**
 * @author administrateur
 *
 */
public class FenetreTableDeJeu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Table t=new Table();
//	VueMain mainJoueur =new VueMainJoueur(t);
	//VueMain mainCasino=new VueMainDuCasino(t);

	public FenetreTableDeJeu() {
		
		this.setSize(600, 500);
		this.setTitle("POKER!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.cyan);
		//this.add(mainJoueur);
		//this.add(mainCasino);
		
 
	}

	
	
}
