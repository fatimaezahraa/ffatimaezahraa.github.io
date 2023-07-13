
package projet1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class application_inscr extends JFrame {

	private JPanel contentPane;
	private JTextField codem;
	private JTextField nom;
	private JTextField prenom;
	private JTextField date;
	private JTextField lieu;
	private JLabel lblNewLabel_3_3;
	private JComboBox tybeb;
	private JComboBox filier;
	private JButton ajouter;
	Connection con = null;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxDba;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application_inscr frame = new application_inscr();
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
	public application_inscr() {
		
		
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 100));
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con = dbConnection1.ConnexionBD();

		JLabel lblNewLabel = new JLabel("code_massar :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(87, 52, 131, 51);
		contentPane.add(lblNewLabel);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNom.setBounds(87, 114, 131, 51);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrenom.setBounds(87, 161, 131, 51);
		contentPane.add(lblPrenom);

		JLabel lblDatenai = new JLabel("Date_Naissance");
		lblDatenai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatenai.setBounds(87, 223, 155, 51);
		contentPane.add(lblDatenai);

		JLabel lblNewLabel_3_1 = new JLabel("Lieu_Naissance");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(87, 285, 131, 51);
		contentPane.add(lblNewLabel_3_1);
//////////////////////////////////////////////////////////////////////////////
		lblNewLabel_2 = new JLabel("Les modules");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(87, 347, 131, 51);
		contentPane.add(lblNewLabel_2);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "module", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(252, 340, 200, 90);
		contentPane.add(panel);

		chckbxNewCheckBox = new JCheckBox("M1");
		panel.add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("M2");
		panel.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("M3");
		chckbxNewCheckBox_2.setToolTipText("");
		panel.add(chckbxNewCheckBox_2);

		chckbxDba = new JCheckBox("M4");
		panel.add(chckbxDba);

		chckbxNewCheckBox_4 = new JCheckBox("M5");
		panel.add(chckbxNewCheckBox_4);

		chckbxNewCheckBox_3 = new JCheckBox("M6");
		panel.add(chckbxNewCheckBox_3);

		

		codem = new JTextField();
		codem.setBounds(252, 61, 176, 42);
		contentPane.add(codem);
		codem.setColumns(10);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(252, 114, 176, 42);
		contentPane.add(nom);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(252, 167, 176, 42);
		contentPane.add(prenom);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(252, 220, 176, 42);
		contentPane.add(date);

		lieu = new JTextField();
		lieu.setColumns(10);
		lieu.setBounds(252, 287, 176, 42);
		contentPane.add(lieu);

		

		lblNewLabel_3_3 = new JLabel("Filiere");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(87, 459, 131, 51);
		contentPane.add(lblNewLabel_3_3);
		
		
		String tab2[] = { " ", "SMAI", "SMP", "SVT", "SVI" };

		filier = new JComboBox(tab2);
		filier.setBounds(252, 462, 176, 44);
		contentPane.add(filier);
		
		
		// ....Ajouter........................
		ajouter = new JButton("Ajouter");
	    ajouter.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String ress = "";
				for (Component c : panel.getComponents()) {

					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox JK = (JCheckBox) c;
						if (JK.isSelected())
							ress += JK.getText() + ",";
					}
				}

				String codeM1 = codem.getText().toString();
				String Nom1 = nom.getText().toString();
				String Prenom1 = prenom.getText().toString();
				String Date_Naiss1 = date.getText().toString();
				String Lieu_Naiss1 = lieu.getText().toString();
				
				String Filier1 = filier.getSelectedItem().toString();
			

				String sql = "insert into inscription(codeM,nom,prenom,dateNaissance,lieuNaissance,lesmodules,filier) values(?,?,?,?,?,?,?) ";
				String sql1 = "Select * from  inscription ";
				
				try {
					
					if (codeM1.equals("") || Nom1.equals("") || Prenom1.equals("") || Date_Naiss1.equals("")
							|| Lieu_Naiss1.equals("") || ress.equals("") ||Filier1.equals(""))

					 {
						JOptionPane.showMessageDialog(null, "S'il vous plait Remplissez tous les champs");
					} else {

						PreparedStatement prepared = con.prepareStatement(sql);
						prepared.setString(1, codeM1);
						prepared.setString(2, Nom1);
						prepared.setString(3, Prenom1);
						prepared.setString(4, Date_Naiss1);
						prepared.setString(5, Lieu_Naiss1);
						prepared.setString(6, ress);
						prepared.setString(7, Filier1);

						prepared.execute();
						JOptionPane.showMessageDialog(null, " ajouter bien ");

					}
				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 15));
		ajouter.setBounds(477, 538, 148, 35);
		contentPane.add(ajouter);

		lblNewLabel_1 = new JLabel("application_inscription");
		lblNewLabel_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBounds(197, 11, 466, 42);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(
				new ImageIcon("C:\\Users\\lenovo\\Documents\\eclpse\\proj\\image\\espaceetudiant.png"));
		lblNewLabel_2.setBounds(499, 125, 242, 317);
		contentPane.add(lblNewLabel_2);
		
		
		// .........Imprime.......................................................
		btnNewButton = new JButton("Imprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Document document = new Document();
				String sql = "Select * from  inscription ";

				try {
					PreparedStatement prepared = con.prepareStatement(sql);
					ResultSet res = prepared.executeQuery();
					PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\lenovo\\Documents\\eclpse\\proj\\pdf\\document.pdf"));
					document.open();

					com.lowagie.text.Image image = com.lowagie.text.Image
							.getInstance("C:\\Users\\lenovo\\Documents\\eclpse\\proj\\image\\seance.jpg");
					
					image.scaleAbsoluteWidth(100);
					image.scaleAbsoluteHeight(92);
					
					document.add(image);
					document.add(new Paragraph("............"));
							
					document.add(new Paragraph("liste des etudiants"));
					document.add(new Paragraph(" "));

					PdfPTable pdfPTable = new PdfPTable(5);
					pdfPTable.setWidthPercentage(100);

					PdfPCell cell;

					cell = new PdfPCell(new Phrase("code_massar", FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
					cell.setBackgroundColor(Color.GRAY);
					pdfPTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
					cell.setBackgroundColor(Color.GRAY);
					pdfPTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Prenom", FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
					cell.setBackgroundColor(Color.GRAY);
					pdfPTable.addCell(cell);

					cell = new PdfPCell(new Phrase("les_modules", FontFactory.getFont("Comic Sans MS", 12)));
					//cell = new PdfPCell(new Phrase("taype_bac", FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
					cell.setBackgroundColor(Color.GRAY);
					pdfPTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Filiere", FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
					cell.setBackgroundColor(Color.GRAY);
					pdfPTable.addCell(cell);

					while (res.next()) {

						cell = new PdfPCell(new Phrase(res.getString("codeM").toString(),
								FontFactory.getFont("Comic Sans MS", 12)));
						cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
						cell.setBackgroundColor(Color.WHITE);
						pdfPTable.addCell(cell);

						cell = new PdfPCell(
								new Phrase(res.getString("nom").toString(), FontFactory.getFont("Comic Sans MS", 12)));
						cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
						cell.setBackgroundColor(Color.WHITE);
						pdfPTable.addCell(cell);

						cell = new PdfPCell(new Phrase(res.getString("prenom").toString(),
								FontFactory.getFont("Comic Sans MS", 12)));
						cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
						cell.setBackgroundColor(Color.WHITE);
						pdfPTable.addCell(cell);

						
						cell = new PdfPCell(new Phrase(res.getString("lesmodules").toString(),
								FontFactory.getFont("Comic Sans MS", 12)));
						
						cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
						cell.setBackgroundColor(Color.WHITE);
						pdfPTable.addCell(cell);

						cell = new PdfPCell(new Phrase(res.getString("filier").toString(),
								FontFactory.getFont("Comic Sans MS", 12)));
						cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
						cell.setBackgroundColor(Color.WHITE);
						pdfPTable.addCell(cell);

					}



					document.add(pdfPTable);
					document.close();
					Desktop.getDesktop().open(new File("C:\\\\Users\\\\lenovo\\\\Documents\\\\eclpse\\\\proj\\\\pdf\\\\document.pdf"));
				} catch (DocumentException | FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(672, 544, 110, 29);
		contentPane.add(btnNewButton);
	}

}
