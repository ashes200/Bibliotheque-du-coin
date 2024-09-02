/*
 * Fichier : Bibliotheque.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package classes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import utilitaires.BaseDeDonnee;
import utilitaires.Rechercher;

/**
 * Bibliotheque: Description de la classe Auteur : 201974751
 */
public class Bibliotheque implements Serializable {

	// Les attributs de class
	private static final long serialVersionUID = 1L;
	private final static int MAX = 500;

	// Les attributs
	private String nom;
	// la liste/tableau de document de la bibliotheque
	private ArrayList<Document> collection;

	/**
	 * constructeur sans parametre
	 */
	public Bibliotheque() {
		this("xxxx");
	}

	/**
	 * constructeur avec parametre
	 *
	 * @param nom : le nom de la bibliotheque
	 */
	public Bibliotheque(String nom) {
		setNom(nom);
		collection = new ArrayList<Document>();
	}

	/**
	 * C'est une methode qui supprime un document par le code recu en parametre J'ai
	 * pas fait if(iterator != null), parce que le for le fait avec le
	 * iterator.hasNext(); Apres l'avoir supprimer il va update la liste de
	 * collection.
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public void supprimerDocument(String code) throws Exception {

		Document autre = Rechercher.rechercheParCode(this, code);
		if (autre != null) {
			int indice = collection.indexOf(autre);
			collection.remove(indice);
		}

	}

	/**
	 * Cette methode sert à chercher le code d'un document dans la liste des
	 * documents apres l'avoir trouver il va l'afficher.
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */

	public Document rechercherCode(String code) throws Exception {
		if (Rechercher.rechercheParCode(this, code) != null)
			return Rechercher.rechercheParCode(this, code);
		else
			throw new Exception("Document non disponible dans la collection");
	}

	/**
	 * Cette methode sert a chercher le titre d'un document dans la liste des
	 * documents. apres l'avoir trouver il va l'afficher.
	 *
	 * @param titre
	 * @return
	 * @throws Exception
	 */
	public Document rechercherTitre(String titre) throws Exception {
		if (Rechercher.rechercheParTitre(this, titre) != null)
			return Rechercher.rechercheParTitre(this, titre);
		else
			throw new Exception("Document non disponible dans la collection");
	}

	/**
	 * ajoute un document a la collection
	 *
	 * @param doc : le document ajouter a la collection. il peut etre soit : une Bd,
	 *            un Livre ou un Journal
	 * @throws Exception : la collection de la bibliotheque est limité a 500. si ce
	 *                   nombre est depasse, cette exeption est renvoyer.
	 */
	public void ajouter(Document doc) throws Exception {
		if (collection.size() < MAX) {
			collection.add(doc);
		} else
			throw new Exception(
					"La bibliotheque a ateint sa capacité maximal. Impossible de rajouter de nouveau document");
	}

	/**
	 * retourne le document ayant l"indice demander
	 *
	 * @param indice : Lindice du document demander
	 * @return
	 */
	public Document obtention(int indice) {
		return collection.get(indice);
	}

	/**
	 * trie la collection de document selon sa methode compareTo, soit : sa
	 * categorie et son code
	 */
	public void trier() {
		Collections.sort(collection);
	}

	/**
	 * prete un document de type livre.
	 *
	 * @param code : le code du document de type livre a emprunter
	 * @return
	 * @throws Exception : le document a emprunter doit etre un livre.
	 */
	public String pret(String code) throws Exception {
		String retour = "";
		int indice = collection.indexOf(Rechercher.rechercheParCode(this, code));
		if (collection.get(indice).getClass() == Livre.class) {
			Livre lvr = (Livre) collection.get(indice);
			lvr.setNbCopiesDisponible(lvr.getNbCopiesDisponible() - 1);
			retour = "pret pour " + lvr.getTitre() + " effectuer avec succes";
		} else {
			retour = "pret non possible";
		}
		return retour;
	}

	/**
	 * retourne un document de type livre
	 *
	 * @param code : le code du document de type livre a emprunter
	 * @return
	 * @throws Exception : le document a emprunter doit etre un livre.
	 */
	public String retour(String code) throws Exception {
		String retour = "";
		int indice = collection.indexOf(Rechercher.rechercheParCode(this, code));
		if (collection.get(indice).getClass() == Livre.class) {
			Livre lvr = (Livre) collection.get(indice);
			lvr.setNbCopiesDisponible(lvr.getNbCopiesDisponible() + 1);
			retour = "retour pour " + lvr.getTitre() + " effectuer avec succes";
		} else {
			retour = "retour non possible";
		}
		return retour;
	}

	/**
	 * affiche les information de la class Bibliotheque
	 */
	@Override
	public String toString() {
		String retour = "";
		retour += this.getNom() + "\n";

		for (Document doc : collection) {
			retour += doc.toString() + "\n";
		}
		retour += "Capacité " + collection.size() + " documents";
		return retour;
	}

	/**
	 * affiche la liste des livre de la collection
	 *
	 * @return
	 */
	public String listeLivre() {
		String retour = "";
		retour += this.getNom() + "\n";

		for (Document doc : collection) {
			if (doc.getClass() == Livre.class) {
				retour += doc.toString() + "\n";
			}
		}
		return retour;
	}

	/**
	 * Enregistre l'objet Bibliotheque dans un fichier binaire.
	 *
	 * @param path : le chemin vers le ficher binaire ou stocker l'objet
	 *             Bibliotheque
	 * @throws IOException
	 */
	public void objectToBin(String path) throws IOException {
		BaseDeDonnee.objetToBinaire(this, path);
	}

	/**
	 * Creer et retourne un objet Bibliotheque initialiser avec les valeurs inscrite
	 * dans le fichier binaire.
	 *
	 * @param path : fichier binaire d'ou sont stocker les information a utiliser
	 *             pour instancier l'objet Bibliotheque retourner
	 * @return : un objet Bibliotheque initialiser avec les infomations du fichier
	 *         binaire entrer dans le path
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Bibliotheque BinToObject(String path) throws ClassNotFoundException, IOException {
		return BaseDeDonnee.binaireToObjet(path);
	}

	/**
	 * Enregistre l'objet Bibliotheque dans un fichier Gson.
	 *
	 * @param path : le chemin vers le ficher Gson ou stocker l'objet Bibliotheque
	 * @throws IOException
	 */
	public void objectToGson(String path) throws IOException {
		BaseDeDonnee.objectToGson(this, path);
	}

	/**
	 * Creer et retourne un objet Bibliotheque initialiser avec les valeurs inscrite
	 * dans le fichier Gson.
	 *
	 * @param path : fichier Gson d'ou sont stocker les information a utiliser pour
	 *             instancier l'objet Bibliotheque retourner
	 * @return : un objet Bibliotheque initialiser avec les infomations du fichier
	 *         Gson entrer dans le path
	 * @throws IOException
	 */
	public Bibliotheque GsonToObject(String path) throws ClassNotFoundException, IOException {
		return BaseDeDonnee.jsonToObjet(path);
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the max
	 */
	public static int getMax() {
		return MAX;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the collection
	 */
	public Document getCollection(int indice) {
		return collection.get(indice);
	}

	/**
	 * @return the collection
	 */
	public ArrayList<Document> getCollections() {
		return collection;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(ArrayList<Document> collection) {
		this.collection = collection;
	}
}
