
package projet1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import database.CreeAuthentification;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection con;

	ResultSet res;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setLocationRelativeTo(null);

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
	public Authentification() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		con = dbConnection1.ConnexionBD();

		textField = new JTextField();
		textField.setBounds(476, 133, 228, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel idNom = new JLabel("Nom   :");
		idNom.setForeground(new Color(255, 255, 255));
		idNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		idNom.setBounds(341, 140, 107, 41);
		contentPane.add(idNom);

		JButton idbtn = new JButton("Se connecter");
		

		idbtn.setBackground(new Color(240, 240, 240));
		idbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		idbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nom = textField.getText().toString();
				String mote_de_passe = textField_1.getText().toString();
				
				if (nom.equals("") && !mote_de_passe.equals("")) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Remplissez le nom");
				} else if (!nom.equals("") && mote_de_passe.equals("")) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Remplissez le mote_de_passe");
				} else if (nom.equals("") && mote_de_passe.equals("")) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Remplissez le nom et  mote_de_passe ");
				} else {
					String sql = "select nom ,motepasse from user1";
					try {

						PreparedStatement prepared = con.prepareStatement(sql);
						res = prepared.executeQuery();
						while (res.next()) {
							String nom11 = res.getString("nom");
							String motPass1 = res.getString("motepasse");

							if (nom.equals(nom11) && mote_de_passe.equals(motPass1)) {
								JOptionPane.showMessageDialog(null, "connexion reussite");
								application_inscr info = new application_inscr();
								info.setVisible(true);
								dispose();

							}
						}

					} catch (SQLException e2) {
						e2.printStackTrace();

					}

				}
			}
		});
		idbtn.setBounds(528, 269, 146, 45);
		contentPane.add(idbtn);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(476, 205, 228, 45);
		contentPane.add(textField_1);

		JLabel idPrenom = new JLabel("Mot de passe");
		idPrenom.setForeground(new Color(255, 255, 255));
		idPrenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		idPrenom.setBounds(341, 209, 137, 41);
		contentPane.add(idPrenom);

		btnNewButton = new JButton("S'incrire");
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreeAuthentifi cree = new CreeAuthentifi();
				cree.setVisible(true);
				cree.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(528, 325, 146, 41);
		contentPane.add(btnNewButton);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon("C:\\Users\\lenovo\\Documents\\eclpse\\proj\\image\\téléchargement.jpg"));
		lblNewLabel_1.setBounds(0, 92, 326, 295);
		contentPane.add(lblNewLabel_1);

		JEditorPane dtrpnAuthentification = new JEditorPane();
		dtrpnAuthentification.setEditable(false);
		dtrpnAuthentification.setBackground(new Color(0, 200, 100));
		dtrpnAuthentification.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		dtrpnAuthentification.setText("             Authentification");
		dtrpnAuthentification.setBounds(0, 0, 717, 115);
		contentPane.add(dtrpnAuthentification);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	}
}
