/*
 * Fichier : Journal.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import java.time.LocalDate;

import utilitaires.CodeGenerator;

/**
 * Journal: Description de la classe Auteur : 201974751
 */
public class Journal extends Document {

	private static final long serialVersionUID = 1L;
	// les attributs
	private String date;

	/**
	 * constructeur sans parametre qui initialise le journal avec des valeur par
	 * default
	 *
	 * @throws Exception
	 */
	public Journal() throws Exception {
		this("xxxx", Categorie.JOURNAL, "2000-01-01");
	}

	/**
	 * constructeur avec parametre
	 *
	 * @param titre : le nom du journal
	 * @param cat   : la categorie du documen, ici Journal
	 * @param date  : la date de publication du journal
	 * @throws Exception
	 */
	public Journal(String titre, Categorie cat, String date) throws Exception {
		super(titre, cat);
		setDate(date);
		LocalDate annee = LocalDate.parse(date);
		setCode(CodeGenerator.generateCode(titre, date, annee.getYear(), 5, 2));
	}

	/**
	 * affiche les information de la class journal
	 */
	@Override
	public String toString() {
		return super.toString() + "\tDate : " + date;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 * @throws Exception
	 */
	public void setDate(String date) throws Exception {
		LocalDate annee = LocalDate.parse(date);
		if (annee.getYear() <= 2022) {
			this.date = date;
		} else
			throw new Exception("entrer une date inferieur ou egale a 2022");
	}

}
