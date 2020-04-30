package gdsm;
import java.sql.*;
public class TestConnection {
	
	/**
	Connection a la base de donnee
	**/
	public static Connection ConnectionBD() 
	{
		try 
		{
			String urlPilote = "com.mysql.jdbc.Driver";
			Class.forName(urlPilote);
			System.out.println("Pilote a ete bien charger");
			String urlBdd = "jdbc:mysql://localhost:3306/Inscription";
			String user="root";
			String passwd="Iloveinformatique";
			Connection con = DriverManager.getConnection(urlBdd, user, passwd);
			System.out.println("Connection a la base de donnee");
			return con;
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
			return null;
		}
	}
	
	public static void InsererPatient(String prenom, String nom, String telephone) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Patient(prenom, nom, telephone) VALUES ('"+prenom+"','"+nom+"', '"+telephone+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Le rendez a ete fixe avec succes");
        }
	}
	
	public static void InsererMedecin(String login, String mot_de_passe) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Medecin(login, mot_de_passe) VALUES ('"+login+"', '"+mot_de_passe+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insertion Complet.");
        }
    }
	
	public static void InsererSecretaire(String ch1, String ch2) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Medecin(login, mot_de_passe) VALUES ('"+ch1+"', '"+ch2+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Compte creer avec succes");
        }
	}
	
	public static void InsererRdv(String ch1, String ch2, String ch3) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO rendez_vous(nom, prenom, date) VALUES ('"+ch1+"','"+ch2+"', '"+ch3+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Le rendez a ete fixe avec succes");
        }
	}
}
