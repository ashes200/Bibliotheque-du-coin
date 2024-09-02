/*
 * Fichier : Rechercher.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package utilitaires;

import classes.Bibliotheque;
import classes.Document;

/**
 * Rechercher: Description de la classe Auteur : 201974751
 */
public class Rechercher {

	/**
	 * recherche la position d'un Document dans la collection grace a son code
	 *
	 * @param bl   : nom de l'objet bibliotheque
	 * @param code : le code du livre rechercher
	 * @return : retourne la position du document si le document existe. retourne -1
	 *         si le document n'existe pas
	 * @throws Exception
	 */
	public static Document rechercheParCode(Bibliotheque blb, String code) {
		Document retour = null;
		for (Document doc : blb.getCollections()) {
			if (doc.getCode().equalsIgnoreCase(code)) {
				retour = doc;
			}
		}
		return retour;
	}

	/**
	 * recherche la position du Document dans la collection grace a son titre
	 *
	 * @param bl    : nom de l'objet bibliotheque
	 * @param titre : le titre du livre rechercher
	 * @return : retourne la position du document si le document existe. retourne -1
	 *         si le document n'existe pas
	 */
	public static Document rechercheParTitre(Bibliotheque blb, String titre) {
		Document retour = null;
		for (Document doc : blb.getCollections()) {
			if (doc.getTitre().equalsIgnoreCase(titre)) {
				retour = doc;
			}
		}
		return retour;
	}
}
