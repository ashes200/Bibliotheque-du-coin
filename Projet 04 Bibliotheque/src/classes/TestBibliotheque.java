/*
 * Fichier : TestBibliotheque.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

/**
 * TestBibliotheque: Description de la classe Auteur : 201974751
 */
public class TestBibliotheque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// les different path pour les sauvegarde
		String path = "./ressources/sauvegarde.bin";
		String path2 = "./ressources/sauvegarde.Gson";

		// initialisation des bibliotheque
		Bibliotheque blb = new Bibliotheque("Ahuntsic");
		Bibliotheque blb2 = null;
		Bibliotheque blb3 = new Bibliotheque("Calix");

		// initialisation des documents
		Journal leDevoir = null;
		Bd tintin = new Bd("Tintin au Congo", Categorie.BD, "Hergé", 2000);
		Livre rinoceros = null;
		try {
			// ajout des documents a la bibliotheque
			leDevoir = new Journal("Le Devoir", Categorie.JOURNAL, "2020-03-12");
			rinoceros = new Livre("Rinoceros", Categorie.LIVRE, "Ionesco", 1987, 10, 7, Genre.ROMAN);
			Journal leMonde = new Journal("Le Monde", Categorie.JOURNAL, "2022-02-07");
			Bd batman = new Bd("Batman", Categorie.BD, "moi", 569);
			blb.ajouter(leDevoir);
			blb.ajouter(tintin);
			blb.ajouter(leMonde);
			blb.ajouter(batman);
			blb.ajouter(rinoceros);

			// affichage des documents de la bibliotheque
			System.out.println(blb.toString());

			// emprunt de livre de la bibliotheque
			System.out.println(blb.pret(rinoceros.getCode()));
			System.out.println(blb.pret(rinoceros.getCode()));
			System.out.println(blb.pret(rinoceros.getCode()));

			// trie et affichage des documents de la bibliotheque
			blb.trier();
			System.out.println(blb.toString());

			// test des different retour de document
			System.out.println("\nLe second document est : " + blb.obtention(1));
			System.out.println(blb.retour(rinoceros.getCode()));

			// affichage des documents de la bibliotheque
			System.out.println(blb.toString());
			// affichage des livres de la bibliotheque
			System.out.println("La liste des livre\n" + blb.listeLivre());

			// sauvegarde de la bibliotheque dans des fichier binaire et Gson
			blb.objectToBin(path);
			blb.objectToGson(path2);

			// suppression et affichage des documents de la bibliotheque
			blb.supprimerDocument(leDevoir.getCode());
			System.out.println(blb.toString());

			// recherche de document
			System.out.println("Recherche code : " + blb.rechercherCode(batman.getCode()));
			System.out.println("Recherche titre : " + blb.rechercherTitre(batman.getTitre()));

			System.out.println("n\n");
			System.out.println("n\n");
			System.out.println("n\n");
			System.out.println("n\n");

			// recuperation de bibliotheque via les fichier sauvegarde
			blb2 = blb.BinToObject(path);
			blb3.setCollection(blb.GsonToObject(path2).getCollections());

			// affichage de bibliotheque initier avec les fichier sauvegarde
			System.out.println("n\n");
			System.out.println("n\n");
			System.out.println(blb2.toString());
			System.out.println("n\n");
			System.out.println("n\n");
			System.out.println(blb3.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
