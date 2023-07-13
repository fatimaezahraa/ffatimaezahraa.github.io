package projet1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.naming.ldap.PagedResultsResponseControl;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class CreeAuthentifi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Connection con;
	private JLabel lblVousAvezDj;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreeAuthentifi frame = new CreeAuthentifi();
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
	public CreeAuthentifi() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con = dbConnection1.ConnexionBD();

		JLabel lblNewLabel = new JLabel("Nom  :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 137, 109, 38);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(157, 138, 170, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 210, 170, 41);
		contentPane.add(textField_1);

		JLabel lblPrenome = new JLabel("prenom :");
		lblPrenome.setForeground(new Color(255, 255, 255));
		lblPrenome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrenome.setBounds(10, 209, 109, 38);
		contentPane.add(lblPrenome);

		JLabel lblMotDePasse = new JLabel("mot de passe\r\n");
		lblMotDePasse.setForeground(new Color(255, 255, 255));
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMotDePasse.setBounds(10, 278, 109, 38);
		contentPane.add(lblMotDePasse);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 279, 170, 41);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("S'incrire");
		// btnNewButton.setBorder(new RoundBtn(20));

		
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField.getText().toString();
				String motepasse = textField_2.getText().toString();
				String prenome = textField_1.getText().toString();

				if (nom.equals("") || motepasse.equals("") || prenome.equals("")) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Remplissez tous les chemps ");
				} else {
					String sql = "INSERT INTO user1 (nom, prenome, motepasse) VALUES (?,?,?) ";

					try {
						PreparedStatement prepared = con.prepareStatement(sql);

						prepared.setString(1, nom);
						prepared.setString(2, prenome);
						prepared.setString(3, motepasse);

						prepared.execute();
						Authentification te = new Authentification();
						te.setVisible(true);
						te.setLocationRelativeTo(null);
						dispose();

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(174, 346, 140, 38);
		contentPane.add(btnNewButton);

		lblVousAvezDj = new JLabel("Vous avez déjà un compte? ");
		lblVousAvezDj.setForeground(Color.WHITE);
		lblVousAvezDj.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVousAvezDj.setBounds(10, 410, 226, 30);
		contentPane.add(lblVousAvezDj);

		lblNewLabel_1 = new JLabel("ici!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(250, 128, 114));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authentification te = new Authentification();
				te.setVisible(true);
				te.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblNewLabel_1.setBounds(343, 418, 44, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(" Connectez-vous.");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(209, 418, 137, 14);
		contentPane.add(lblNewLabel_2);

		
	}
}
