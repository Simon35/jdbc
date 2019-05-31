package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:8889/ja_demo1?useUnicode=true\n" + 
				"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&\n" + 
				"serverTimezone=UTC";
		String utilisateur = "root";

        String motDePasse = "root";

        Connection connexion = null;
        String erreur = null;

        try {

            Class.forName( "com.mysql.cj.jdbc.Driver" );

        } catch ( ClassNotFoundException e ) {

            erreur="driver";

        }

        try {

            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            Statement statement = connexion.createStatement();

            ResultSet resultat = statement.executeQuery( "SELECT firstname  FROM employees" );

            while ( resultat.next() ) {

                String firstname = resultat.getString( "firstname" );

            }

        } catch (SQLException e ) {

            erreur = e.getMessage();

        } finally {

            if ( connexion != null )

                try {

                    connexion.close();

                } catch ( SQLException ignore ) {

                }

        }	}

}
