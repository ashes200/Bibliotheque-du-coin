/*
 * Fichier : InterfaceAuthentification.java
 * Auteur : Nom Prénom : debra
 * Date de création : {date}
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utilitaires.Authentification;

/**
 * InterfaceAuthentification: Description de la classe Auteur : debra
 */
public class InterfaceAuthentification extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblMotDePasse;
	private JTextField textPseudo;
	private JPasswordField textPassw;
	private JButton btnConnexion;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfaceAuthentification frame = new InterfaceAuthentification();
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
	public InterfaceAuthentification() {
		initialize();
	}

	private void initialize() {
		setTitle("Authentification ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 381);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Utilisateur\r\n");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 48, 127, 35);
		contentPane.add(lblNewLabel);

		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMotDePasse.setBounds(28, 122, 164, 35);
		contentPane.add(lblMotDePasse);

		textPseudo = new JTextField();
		textPseudo.setText("debraise");
		textPseudo.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPseudo.setBounds(176, 48, 229, 40);
		contentPane.add(textPseudo);
		textPseudo.setColumns(10);

		textPassw = new JPasswordField();
		textPassw.setText("2braise");
		textPassw.setEchoChar('*');
		textPassw.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPassw.setBounds(176, 126, 229, 35);
		contentPane.add(textPassw);

		btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new BtnNewButtonActionListener());
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConnexion.setBounds(28, 245, 127, 41);
		contentPane.add(btnConnexion);

		lblError = new JLabel("");
		lblError.setBounds(171, 247, 234, 40);
		contentPane.add(lblError);
	}

	// creation d'un objet authentification
	Authentification auth = new Authentification();

	/**
	 * BtnNewButtonActionListener: Description de la classe Auteur : debra
	 */
	private class BtnNewButtonActionListener implements ActionListener {
		@Override
		/**
		 * verifie le pseudo et password. si ceux-ci sont conforme a ceux enregistrer,
		 * donne acces la la fenetre de gestion
		 */
		public void actionPerformed(ActionEvent e) {
			String pseudo = textPseudo.getText();
			String password = String.valueOf(textPassw.getPassword());
			System.out.println(pseudo + "\t" + password);
			boolean verif = auth.verification(pseudo, password);
			if (verif) {
				InterfaceGestion interf = new InterfaceGestion();
				interf.setTitle("fenetre gestion");
				interf.setVisible(true);
				dispose();
			} else {
				lblError.setText("Essayer a nouveau");
			}
		}
	}
}
