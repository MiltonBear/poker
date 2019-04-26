/**
 * 
 */
package ca.csf.dfc.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.csf.dfc.classe.Carte;
import ca.csf.dfc.classe.Table;

/**
 * @author administrateur public abstract class HandAbstract
 */
public abstract class VueMain extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	VueMain(Table p_table) {
		JLabel labels[] = new JLabel[5];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(
					(ChargerUneCarte("/image/" + p_table.m_HandPlayer.getCardFromHand().get(i).toString() + ".png")));
			this.add(labels[i]);
		}
	}

	public ImageIcon ChargerUneCarte(String p_Chemin) {
		Icon ic = new ImageIcon(getClass().getResource(p_Chemin));
		Image im = ((ImageIcon) ic).getImage().getScaledInstance(100, 133, java.awt.Image.SCALE_SMOOTH);
		ImageIcon imIc = new ImageIcon(im);
		return imIc;

	}

}
