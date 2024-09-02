/*
 * Fichier : TestDocumentsVolumes.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TestDocumentsVolumes: Description de la classe Auteur : 201974751
 */
public class TestDocumentsVolumes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Journal leDevoir = new Journal("Le Devoir", Categorie.JOURNAL, "2020-03-12");

			Bd tintin = new Bd("Tintin au Congo", Categorie.BD, "Hergé", 2000);

			Livre rinoceros = null;
			rinoceros = new Livre("Rinoceros", Categorie.LIVRE, "Ionesco", 1987, 10, 7, Genre.ROMAN);

			Journal leMonde = new Journal("Le Monde", Categorie.JOURNAL, "2022-02-07");
			Bd Batman = new Bd("Batman", Categorie.BD, "moi", 569);

			ArrayList<Document> bibliotheque = new ArrayList<Document>();
			bibliotheque.add(leDevoir);
			bibliotheque.add(tintin);
			bibliotheque.add(leMonde);
			bibliotheque.add(Batman);
			bibliotheque.add(rinoceros);

			for (Document doc : bibliotheque) {
				System.out.println(doc.toString());
			}

			Collections.sort(bibliotheque);
			System.out.println("\n\n");
			for (Document doc : bibliotheque) {
				System.out.println(doc.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
