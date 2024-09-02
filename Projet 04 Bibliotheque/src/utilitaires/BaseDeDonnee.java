/*
 * Fichier : BaseDeDonneeBinaire.java
 * Auteur : Nom Prénom : 201974751
 * Date de création : {date}
 */
package utilitaires;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import classes.Bibliotheque;

/**
 * BaseDeDonneeBinaire: Description de la classe Auteur : 201974751
 */
public class BaseDeDonnee {

	/**
	 * Enregistre l'objet Bibliotheque dans un fichier binaire.
	 *
	 * @param blb  : objet Bibliotheque qu'on souhaite enregistrer dans le fichier
	 *             binaire
	 * @param path : le chemin vers le ficher binaire ou stocker l'objet
	 *             Bibliotheque
	 * @throws IOException
	 */
	public static void objetToBinaire(Bibliotheque blb, String path) throws IOException {

		try ( // Ouvre le fichier en ecriture
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream serialiseur = new ObjectOutputStream(fos)) {
			// sérialiser l'objet(s)
			serialiseur.writeObject(blb);

		}

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
	public static Bibliotheque binaireToObjet(String path) throws IOException, ClassNotFoundException {
		try ( // Ouvre le fichier en lecture
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream deserialiseur = new ObjectInputStream(fis)) {
			// Désérialiser le flux en objet
			Bibliotheque temp = (Bibliotheque) deserialiseur.readObject();
			return temp;
		}
	}

	/**
	 * Enregistre l'objet Bibliotheque dans un fichier Gson.
	 *
	 * @param blb  : objet Bibliotheque qu'on souhaite enregistrer dans le fichier
	 *             Gson
	 * @param path : le chemin vers le ficher Gson ou stocker l'objet Bibliotheque
	 * @throws IOException
	 */
	public static void objectToGson(Bibliotheque blb, String path) throws IOException {

		// Créer une instance Gson
		Gson js = new GsonBuilder().setPrettyPrinting().create();
		try (Writer out = new FileWriter(path);) {
			// OBJET JAVA --> FICHIER Json
			js.toJson(blb, out);
		}

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
	public static Bibliotheque jsonToObjet(String path) throws IOException {
		Bibliotheque b = null;
		// Créer une instance Gson
		Gson js = new Gson();
		try (Reader in = new FileReader(path);) {
			// FICHIER Json --> OBJET JAVA
			b = js.fromJson(in, Bibliotheque.class);
		}
		return b; // retourne l’objet deserialise
	}
}
