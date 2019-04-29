
/**
 * 
 */
package ca.csf.dfc.classe;

/**
 * @author administrateur
 *
 */
public class Carte {

	public static String[] CHOIX_ATOUT = { "pique", "trefle", "carreau", "coeur" };
	public static String[] CHOIX_FACE = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	private String m_Face;
	private String m_Atout;
	private int m_Valeur;
	private Boolean m_Discarded;

	public Carte(String p_Face, String p_Atout, int p_Valeur) {
		this.m_Face = p_Face;
		this.m_Atout = p_Atout;
		this.m_Valeur = p_Valeur;
		this.m_Discarded=false;
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

	/**
	 * @return the m_Discarded
	 */
	public Boolean getDiscardedStatut() {
		return m_Discarded;
	}

	/**
	 * @param m_Discarded the m_Discarded to set
	 */
	public void toggleDiscardedStatut() {
		
		if (this.m_Discarded==true)
		this.m_Discarded = false;
		else
			this.m_Discarded=true;
	}
}
