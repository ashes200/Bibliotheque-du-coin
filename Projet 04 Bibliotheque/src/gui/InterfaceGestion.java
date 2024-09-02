/*
 * Fichier : InterfaceGestion.java
 * Auteur : Nom Prénom : debra
 * Date de création : {date}
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.Bd;
import classes.Bibliotheque;
import classes.Categorie;
import classes.Document;
import classes.Genre;
import classes.Journal;
import classes.Livre;

/**
 * InterfaceGestion: Description de la classe Auteur : debra
 */
public class InterfaceGestion extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCode;
	private JLabel lblTitre;
	private JLabel lblAuteur;
	private JLabel lblAnnee;
	private JLabel lblNbCopies;
	private JComboBox<String> cbCodes;
	private JTextField textTitre;
	private JTextField textAuteur;
	private JTextField textAnnee;
	private JTextField textNbCopies;
	private JComboBox<Genre> cbGenre;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton btnRechercher;
	private JRadioButton rdbtnJournal;
	private JRadioButton rdbtnBd;
	private JRadioButton rdbtnLivre;
	private JLabel lblDate;
	private JTextField textDate;
	private JTextField textNumero;
	private JLabel lblNumero;
	private JButton btnSortir;
	private JButton btnAfficher;
	private JButton btnAfficherLivre;
	private JButton btnCharger;
	private JButton btnSupprimer;
	private JButton btnAjouter;
	private JButton btnEmprunter;
	private JButton btnRendre;
	private ButtonGroup group;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfaceGestion frame = new InterfaceGestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceGestion() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCode.setBounds(10, 11, 87, 23);
		contentPane.add(lblCode);

		lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitre.setBounds(10, 52, 87, 23);
		contentPane.add(lblTitre);

		lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuteur.setBounds(10, 127, 87, 23);
		contentPane.add(lblAuteur);

		lblAnnee = new JLabel("Annee");
		lblAnnee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnnee.setBounds(10, 165, 87, 23);
		contentPane.add(lblAnnee);

		lblNbCopies = new JLabel("Nb copies");
		lblNbCopies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNbCopies.setBounds(10, 211, 87, 23);
		contentPane.add(lblNbCopies);

		cbCodes = new JComboBox<String>();
		cbCodes.addActionListener(new CbCodesActionListener());
		cbCodes.setBounds(101, 7, 212, 35);
		contentPane.add(cbCodes);

		textTitre = new JTextField();
		textTitre.setBounds(101, 48, 212, 35);
		contentPane.add(textTitre);
		textTitre.setColumns(10);

		textAuteur = new JTextField();
		textAuteur.setColumns(10);
		textAuteur.setBounds(101, 115, 212, 35);
		contentPane.add(textAuteur);

		textAnnee = new JTextField();
		textAnnee.setColumns(10);
		textAnnee.setBounds(101, 161, 99, 35);
		contentPane.add(textAnnee);

		textNbCopies = new JTextField();
		textNbCopies.setColumns(10);
		textNbCopies.setBounds(101, 207, 99, 35);
		contentPane.add(textNbCopies);

		cbGenre = new JComboBox<Genre>();
		cbGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbGenre.setModel(new DefaultComboBoxModel<Genre>(Genre.values()));
		cbGenre.setBounds(206, 207, 107, 35);
		contentPane.add(cbGenre);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 263, 991, 176);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new BtnRechercherActionListener());
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRechercher.setBounds(322, 52, 131, 31);
		contentPane.add(btnRechercher);

		rdbtnJournal = new JRadioButton("Journal");
		rdbtnJournal.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnJournal.setBounds(319, 119, 109, 23);
		contentPane.add(rdbtnJournal);

		rdbtnBd = new JRadioButton("BD");
		rdbtnBd.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnBd.setBounds(320, 147, 109, 23);
		contentPane.add(rdbtnBd);

		rdbtnLivre = new JRadioButton("Livre");
		rdbtnLivre.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnLivre.setBounds(320, 173, 109, 23);
		contentPane.add(rdbtnLivre);

		group = new ButtonGroup();
		group.add(rdbtnJournal);
		group.add(rdbtnBd);
		group.add(rdbtnLivre);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(615, 60, 87, 23);
		contentPane.add(lblDate);

		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(712, 48, 289, 35);
		contentPane.add(textDate);

		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(712, 115, 289, 35);
		contentPane.add(textNumero);

		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero.setBounds(615, 127, 87, 23);
		contentPane.add(lblNumero);

		btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new BtnSortirActionListener());
		btnSortir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSortir.setBounds(920, 3, 81, 31);
		contentPane.add(btnSortir);

		btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new BtnAfficherActionListener());
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfficher.setBounds(811, 3, 99, 31);
		contentPane.add(btnAfficher);

		btnAfficherLivre = new JButton("Afficher Livre");
		btnAfficherLivre.addActionListener(new BtnAfficherLivreActionListener());
		btnAfficherLivre.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfficherLivre.setBounds(670, 3, 131, 31);
		contentPane.add(btnAfficherLivre);

		btnCharger = new JButton("Charger");
		btnCharger.addActionListener(new BtnChargerActionListener());
		btnCharger.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCharger.setBounds(553, 4, 107, 31);
		contentPane.add(btnCharger);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new BtnSupprimerActionListener());
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setBounds(434, 3, 109, 31);
		contentPane.add(btnSupprimer);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new BtnAjouterActionListener());
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouter.setBounds(340, 3, 88, 31);
		contentPane.add(btnAjouter);

		btnEmprunter = new JButton("Emprunter");
		btnEmprunter.addActionListener(new BtnEmprunterActionListener());
		btnEmprunter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEmprunter.setBounds(323, 211, 123, 31);
		btnEmprunter.setVisible(false);
		contentPane.add(btnEmprunter);

		btnRendre = new JButton("Rendre");
		btnRendre.addActionListener(new BtnRendreActionListener());
		btnRendre.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRendre.setBounds(456, 213, 87, 31);
		btnRendre.setVisible(false);
		contentPane.add(btnRendre);

		lblError = new JLabel("");
		lblError.setBounds(575, 211, 426, 31);
		contentPane.add(lblError);
	}

	Bibliotheque blb = new Bibliotheque("Ahuntsic");
	String path = "./ressources/sauvegarde.bin";
	String path2 = "./ressources/sauvegarde.Gson";
	String code = "";

	/**
	 * instancie le comboBox contenant les codes des documents
	 */
	public void remplirComboCodes() {
		// vide le comboBox d'ancienne valeur
		cbCodes.removeAllItems();

		// remplie le comboBox de nouvelle valeur
		for (Document doc : blb.getCollections()) {
			cbCodes.addItem(doc.getCode());
		}
	}

	/**
	 * permet d'efface les texte de tous les textField
	 */
	public void effacfer() {
		textTitre.setText("");
		textAuteur.setText("");
		textAnnee.setText("");
		textNbCopies.setText("");
		textDate.setText("");
		textNumero.setText("");
	}

	/**
	 *
	 * BtnAjouterActionListener: Ajoute un Document a la colletion de la
	 * bibliotheque Auteur : debra
	 */
	private class BtnAjouterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * premet d'ajouter un document de type Journal a la collection
			 */
			if (rdbtnJournal.isSelected()) {
				String titre = textTitre.getText();
				String date = textDate.getText();
				try {
					Document doc = new Journal(titre, Categorie.JOURNAL, date);
					blb.ajouter(doc);
					remplirComboCodes();
					lblError.setText("");
					textArea.setText("le Journal " + doc.getTitre() + " a bien ete ajouter");
					effacfer();
				} catch (Exception e1) {
					lblError.setText("" + e1);
				}
			}
			/**
			 * premet d'ajouter un document de type volume lui meme de type BD a la
			 * collection
			 */
			else if (rdbtnBd.isSelected()) {
				String titre = textTitre.getText();
				String auteur = textAuteur.getText();
				int numero = Integer.parseInt(textNumero.getText());
				Document doc = new Bd(titre, Categorie.BD, auteur, numero);
				try {
					blb.ajouter(doc);
					remplirComboCodes();
					lblError.setText("");
					textArea.setText("la Bd " + doc.getTitre() + " a bien ete ajouter");
					effacfer();
				} catch (Exception e1) {
					lblError.setText("" + e1);
				}
			}
			/**
			 * premet d'ajouter un document de type volume lui meme de type Livre a la
			 * collection
			 */
			else if (rdbtnLivre.isSelected()) {
				String titre = textTitre.getText();
				String auteur = textAuteur.getText();
				int anneeEdit = Integer.parseInt(textAnnee.getText());
				int nbCopies = Integer.parseInt(textNbCopies.getText());
				String genre = String.valueOf(cbGenre.getSelectedItem());
				Document doc;
				try {
					doc = new Livre(titre, Categorie.BD, auteur, anneeEdit, nbCopies, nbCopies, Genre.valueOf(genre));
					blb.ajouter(doc);
					remplirComboCodes();
					lblError.setText("");
					textArea.setText("le livre " + doc.getTitre() + " a bien ete ajouter");
					effacfer();
				} catch (Exception e1) {
					lblError.setText("" + e1);
				}
			} else {
				lblError.setText("veuillez selectionner une categorie");
			}
			try {
				blb.objectToBin(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * BtnChargerActionListener: permet d'initialiser l'objet bibliotheque avec les
	 * information stocker dans le fichier sauvegarde de type binaire Auteur : debra
	 */
	private class BtnChargerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				blb = blb.BinToObject(path);
				remplirComboCodes();
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 *
	 * BtnAfficherActionListener: permet d'afficher les Documents de la bibliotheque
	 * dans le text area Auteur : debra
	 */
	private class BtnAfficherActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			effacfer();
			textArea.setText(blb.toString());
		}
	}

	/**
	 *
	 * BtnAfficherLivreActionListener: permet d'afficher les documents de type livre
	 * de la bibliotheque dans le text area Auteur : debra
	 */
	private class BtnAfficherLivreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			effacfer();
			rdbtnLivre.setSelected(true);
			textArea.setText(blb.listeLivre());
		}
	}

	/**
	 * BtnEmprunterActionListener: permet d'emprunter un Document de type Livre de
	 * la blibliotheque Auteur : debra
	 */
	private class BtnEmprunterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Livre lvl = (Livre) blb.rechercherCode(code);
				textArea.setText(blb.pret(code) + " nombre restant : " + lvl.getNbCopiesDisponible());
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 * BtnRendreActionListener: permet de rendre un Document de type Livre de la
	 * blibliotheque Auteur : debra
	 */
	private class BtnRendreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Livre lvl = (Livre) blb.rechercherCode(code);
				textArea.setText(blb.retour(code) + " nombre restant : " + lvl.getNbCopiesDisponible());
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 * BtnSortirActionListener: donner acces a la fenetre intrefaceSortie Auteur :
	 * debra
	 */
	private class BtnSortirActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// trie le la collection de livre
			blb.trier();

			// sauvegarde la collection dans un fichier binaire et Json
			try {
				blb.objectToBin(path);
				blb.objectToGson(path2);

				InterfaceSortie interf = new InterfaceSortie();
				interf.setTitle("fenetre sortie");
				interf.setVisible(true);
				dispose();
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 * BtnSupprimerActionListener: Supprime le document dont le code est donnée par
	 * une des methodes de recherche Auteur : debra
	 */
	private class BtnSupprimerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				effacfer();
				String texte = "le document " + blb.rechercherCode(code).getTitre() + " a bien été supprimer";
				blb.supprimerDocument(code);
				remplirComboCodes();
				textArea.setText(texte);
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 * BtnRechercherActionListener: recherche le document dont le titre est
	 * rechercher et l'affiche dans le textArea Auteur : debra
	 */
	private class BtnRechercherActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Document docum = null;
			try {
				docum = blb.rechercherTitre(textTitre.getText());
				code = docum.getCode();
				textArea.setText(docum.toString());
				if (docum.getClass() == Journal.class) {
					Journal journ = (Journal) docum;
					textTitre.setText(journ.getTitre());
					textDate.setText(journ.getDate());
					rdbtnJournal.setSelected(true);
					btnRendre.setVisible(false);
					btnEmprunter.setVisible(false);
					cbCodes.setSelectedItem(code);
				} else if (docum.getClass() == Bd.class) {
					Bd bd = (Bd) docum;
					textTitre.setText(bd.getTitre());
					textAuteur.setText(bd.getAuteur());
					textNumero.setText("" + bd.getNumEdition());
					rdbtnBd.setSelected(true);
					btnRendre.setVisible(false);
					btnEmprunter.setVisible(false);
					cbCodes.setSelectedItem(code);
				} else {
					Livre lvl = (Livre) docum;
					textTitre.setText(lvl.getTitre());
					textAuteur.setText(lvl.getAuteur());
					textAnnee.setText("" + lvl.getAnEdition());
					textNbCopies.setText("" + lvl.getNbCopies());
					rdbtnLivre.setSelected(true);
					btnRendre.setVisible(true);
					btnEmprunter.setVisible(true);
					cbCodes.setSelectedItem(code);
				}
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}

	/**
	 * CbCodesActionListener: recherche le document dont le code est selectionner et
	 * l'affiche dans le textArea Auteur : debra
	 */
	private class CbCodesActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			effacfer();
			code = String.valueOf(cbCodes.getSelectedItem());
			try {
				Document docum = blb.rechercherCode(code);
				textArea.setText(blb.rechercherCode(code).toString());
				if (docum.getClass() == Journal.class) {
					Journal journ = (Journal) docum;
					textTitre.setText(journ.getTitre());
					textDate.setText(journ.getDate());
					rdbtnJournal.setSelected(true);
					btnRendre.setVisible(false);
					btnEmprunter.setVisible(false);
				} else if (docum.getClass() == Bd.class) {
					Bd bd = (Bd) docum;
					textTitre.setText(bd.getTitre());
					textAuteur.setText(bd.getAuteur());
					textNumero.setText("" + bd.getNumEdition());
					rdbtnBd.setSelected(true);
					btnRendre.setVisible(false);
					btnEmprunter.setVisible(false);
				} else {
					Livre lvl = (Livre) docum;
					textTitre.setText(lvl.getTitre());
					textAuteur.setText(lvl.getAuteur());
					textAnnee.setText("" + lvl.getAnEdition());
					textNbCopies.setText("" + lvl.getNbCopies());
					rdbtnLivre.setSelected(true);
					btnRendre.setVisible(true);
					btnEmprunter.setVisible(true);
				}
			} catch (Exception e1) {
				lblError.setText("" + e1);
			}
		}
	}
}
