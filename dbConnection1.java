package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class dbConnection1 {
	Connection con = null;

	public static Connection ConnexionBD() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data-infos2?autoReconnect=true&useSSL=false", 
					"root", "");
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

			return null;
		}
	}
}
