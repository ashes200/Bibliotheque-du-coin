/*
 * Fichier : Livre.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import utilitaires.CodeGenerator;

/**
 * Livre: Description de la classe Auteur : 201974751
 */
public class Livre extends Volume {

	private static final long serialVersionUID = 1L;
	// les attributs
	private int anEdition;
	private int nbCopies;
	private int nbCopiesDisponible;
	private Genre genre;

	/**
	 * constructeur sans parametre qui initialise le journal avec des valeur par
	 * default
	 *
	 * @throws Exception renvoi une erreur si le nb de copies disponibles est plus
	 *                   grand que le nb de copies
	 */
	public Livre() throws Exception {
		this("xxxx", Categorie.LIVRE, "xxxx", 2000, 10, 5, Genre.ROMAN);
	}

	/**
	 * constructeur avec parametre
	 *
	 * @param titre              : le titre du livre
	 * @param cat                : la categorie du document : ici Livre
	 * @param annee              : l'année d'édition du livre
	 * @param auteur             : l'auteur du livre
	 * @param nbCopies           : le nombre de copie du livre a la bibliotheque
	 * @param nbCopiesDisponible : le nombre de copie de livre disponible a
	 *                           l'emprunt
	 * @param genre              : le genre du livre
	 * @throws Exception : renvoi une erreur si le nb de copies disponibles est plus
	 *                   grand que le nb de copies
	 */
	public Livre(String titre, Categorie cat, String auteur, int anEdition, int nbCopies, int nbCopiesDisponible,
			Genre genre) throws Exception {
		super(titre, cat, auteur);
		setAnEdition(anEdition);
		setGenre(genre);
		setNbCopies(nbCopies);
		setNbCopiesDisponible(nbCopiesDisponible);
		setCode(CodeGenerator.generateCode(titre, auteur, anEdition, 5, 2));
	}

	/**
	 * affiche les information de la class Livre
	 */
	@Override
	public String toString() {
		return super.toString() + "\tGenre : " + this.getGenre() + "\tNb copies : " + nbCopies + "\tNb copies dispo : "
				+ nbCopiesDisponible;
	}

	/**
	 * @return the anEdition
	 */
	public int getAnEdition() {
		return anEdition;
	}

	/**
	 * @param anEdition the anEdition to set
	 * @throws Exception
	 */
	public void setAnEdition(int anEdition) throws Exception {
		if (anEdition <= 2022) {
			this.anEdition = anEdition;
		} else
			throw new Exception("entrer une année inferieur ou egale a 2022");
	}

	/**
	 * @return the nbCopies
	 */
	public int getNbCopies() {
		return nbCopies;
	}

	/**
	 * @return the nbCopiesDisponible
	 */
	public int getNbCopiesDisponible() {
		return nbCopiesDisponible;
	}

	/**
	 * @param nbCopies the nbCopies to set
	 * @throws Exception
	 */
	public void setNbCopies(int nbCopies) throws Exception {
		if (nbCopies >= 0) {
			this.nbCopies = nbCopies;
		} else
			throw new Exception("Le nombre de copies doit etre superieur a 0");

	}

	/**
	 * @param nbCopiesDisponible the nbCopiesDisponible to set
	 * @throws Exception
	 */
	public void setNbCopiesDisponible(int nbCopiesDisponible) throws Exception {
		if ((nbCopiesDisponible <= nbCopies) && (nbCopiesDisponible >= 0)) {
			this.nbCopiesDisponible = nbCopiesDisponible;
		} else
			throw new Exception("Le nombre de copies disponible ne doit pas depasser le nombre de copies");

	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
