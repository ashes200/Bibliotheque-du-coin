/*
 * Fichier : Volume.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

/**
 * Volume: Description de la classe Auteur : 201974751
 */
public class Volume extends Document {

	private static final long serialVersionUID = 1L;
	// les attributs
	protected String auteur;

	/**
	 * constructeur sans parametre qui initialise le journal avec des valeur par
	 * default
	 */
	public Volume() {
		this("xxxx", null, "xxxx");
	}

	/**
	 * constructeur avec parametre
	 *
	 * @param titre  : le nom du volume
	 * @param cat    : la categorie du volume : ici null
	 * @param annee  : l'année d'edition du volume
	 * @param auteur : l'auteur du volume
	 */
	public Volume(String titre, Categorie cat, String auteur) {
		super(titre, cat);
		setAuteur(auteur);
	}

	/**
	 * affiche les information de la class Volume
	 */
	@Override
	public String toString() {
		return super.toString() + "\tAuteur : " + auteur;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
