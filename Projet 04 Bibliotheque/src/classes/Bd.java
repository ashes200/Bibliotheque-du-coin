/*
 * Fichier : Bd.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import utilitaires.CodeGenerator;

/**
 * Bd: Description de la classe Auteur : 201974751
 */
public class Bd extends Volume {

	private static final long serialVersionUID = 1L;
	// les attributs
	private int numEdition;

	/**
	 * constructeur sans parametre qui initialise le journal avec des valeur par
	 * default
	 */
	public Bd() {
		this("xxxx", Categorie.BD, "xxxx", 100);
	}

	/**
	 * constructeur avec parametre
	 *
	 * @param titre     : le titre de la BD
	 * @param cat       : la categorie de la bd : ici BD
	 * @param annee     : l'année d'edition de la Bd
	 * @param auteur    : l'auteur de la BD
	 * @param nbEdition : le nombre d'édition de la BD
	 */
	public Bd(String titre, Categorie cat, String auteur, int numEdition) {
		super(titre, cat, auteur);
		setNumEdition(numEdition);
		setCode(CodeGenerator.generateCode(titre, auteur, numEdition, 5, 2));
	}

	/**
	 * affiche les information de la class Bd
	 */
	@Override
	public String toString() {
		return super.toString() + "\tNombre d'édition : " + numEdition;
	}

	/**
	 * @return the nbEdition
	 */
	public int getNumEdition() {
		return numEdition;
	}

	/**
	 * @param nbEdition the nbEdition to set
	 */
	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

}
