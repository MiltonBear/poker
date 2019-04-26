/**
 * 
 */
package ca.csf.dfc.vue;

import javax.swing.JLabel;

import ca.csf.dfc.classe.Table;

/**
 * @author administrateur
 *
 */
public class VueMainDuCasino extends VueMain {

	VueMainDuCasino(Table p_table) {
		super(p_table);
		JLabel labels[] = new JLabel[5];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(
					(ChargerUneCarte("/image/" + p_table.m_Casino.getCardFromHand().get(i).toString() + ".png")));
			this.add(labels[i]);
		}
	}
}