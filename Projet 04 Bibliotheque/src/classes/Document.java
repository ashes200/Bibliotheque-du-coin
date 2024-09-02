/*
 * Fichier : Document.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import java.io.Serializable;

/**
 * Document: Description de la classe Auteur : 201974751
 */
public class Document implements Serializable, Comparable<Document> {

	// les attributs de class
	protected static int nbDocument;
	private static final long serialVersionUID = 1L;

	// les attributs
	protected String code;
	protected String titre;
	protected Categorie categorie;

	/**
	 * constructeur sans parametre qui initialise le journal avec des valeur par
	 * default
	 */
	public Document() {
		this("xxxx", null);
	}

	/**
	 * c'est un constructeur avec parametre
	 *
	 * @param titre : le titre du document
	 * @param cat   : la categorie du document : ici null
	 */
	public Document(String titre, Categorie cat) {
		nbDocument++;
		setTitre(titre);
		setCategorie(cat);
	}

	/**
	 * Cette methode sert à comparer les documents selon leur categorie puis leur
	 * codes si ils ont la meme categorie leurs codes.
	 */
	@Override
	public int compareTo(Document autre) {
		int retour;
		int compareCategorie = categorie.compareTo(autre.categorie);
		if (compareCategorie == 0) {
			retour = code.compareTo(autre.code);
		} else {
			retour = compareCategorie;
		}
		return retour;
	}

	/**
	 * Cette methode sert a afficher les informations de la class
	 */
	@Override
	public String toString() {
		String retour = "";
		retour = "Code : " + code + "\t" + "Titre : " + titre + "\t\t" + "Categorie :" + categorie;
		return retour;
	}

	/**
	 * @return la categorie de la class
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public String setTitre(String titre) {
		return this.titre = titre;
	}

	/**
	 * @return the nbDocument
	 */
	public static int getNbDocument() {
		return nbDocument;
	}

	/**
	 * @param nbDocument the nbDocument to set
	 */
	public static void setNbDocument(int nbDocument) {
		Document.nbDocument = nbDocument;
	}
}
