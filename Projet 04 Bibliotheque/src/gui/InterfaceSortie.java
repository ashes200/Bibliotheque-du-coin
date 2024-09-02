/*
 * Fichier : InterfaceSortie.java
 * Auteur : Nom Prénom : debra
 * Date de création : {date}
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * InterfaceSortie: Description de la classe Auteur : debra
 */
public class InterfaceSortie extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNon;
	private JButton btnSeDeconnecter;
	private JButton btnSortir;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfaceSortie frame = new InterfaceSortie();
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
	public InterfaceSortie() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Voulez-vous vraiment sortir ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(90, 11, 248, 52);
		contentPane.add(lblNewLabel);

		btnNon = new JButton("Non");
		btnNon.addActionListener(new BtnNonActionListener());
		btnNon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNon.setBounds(165, 58, 89, 23);
		contentPane.add(btnNon);

		btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.addActionListener(new BtnSeDeconnecterActionListener());
		btnSeDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSeDeconnecter.setBounds(90, 96, 149, 23);
		contentPane.add(btnSeDeconnecter);

		btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new BtnSortirActionListener());
		btnSortir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSortir.setBounds(249, 96, 89, 23);
		contentPane.add(btnSortir);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 140, 414, 34);
		contentPane.add(lblNewLabel_1);
	}

	private class BtnNonActionListener implements ActionListener {
		@Override
		/**
		 * permet de retourner a la fenetre de gestion
		 */
		public void actionPerformed(ActionEvent e) {
			InterfaceGestion interf = new InterfaceGestion();
			interf.setTitle("fenetre gestion");
			interf.setVisible(true);
			dispose();
		}
	}

	private class BtnSortirActionListener implements ActionListener {
		@Override
		/**
		 * permet de fermer le programme
		 */
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class BtnSeDeconnecterActionListener implements ActionListener {
		@Override
		/**
		 * permet de retourner a la fentre d'authentification
		 */
		public void actionPerformed(ActionEvent e) {
			InterfaceAuthentification interf = new InterfaceAuthentification();
			interf.setTitle("fenetre authentification");
			interf.setVisible(true);
			dispose();
		}
	}
}
