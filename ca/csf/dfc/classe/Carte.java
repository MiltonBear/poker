
/**
 * 
 */
package ca.csf.dfc.classe;

/**
 * @author administrateur
 *
 */
public class Carte {

	public static String[] CHOIX_ATOUT = { "pique", "trefle", "carreau", "carreau" };
	public static String[] CHOIX_FACE = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	private String m_Face;
	private String m_Atout;
	private int m_Valeur;

	public Carte(String p_Face, String p_Atout, int p_Valeur) {
		this.m_Face = p_Face;
		this.m_Atout = p_Atout;
		this.m_Valeur = p_Valeur;
	}

//	seulement pour test
	public Carte() {

	}

	public int getCarteValue() {
		return this.m_Valeur;
	}

	public String getFace() {
		return this.m_Face;
	}

	public String getAtout() {
		return this.m_Atout;
	}

	public String toString() {
		return this.m_Face + this.m_Atout;
	}
}
