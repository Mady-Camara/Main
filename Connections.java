package gdsm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connections {
	public static Connection ConnectionBD() 
	{
		try 
		{
			String urlPilote = "com.mysql.jdbc.Driver";
			Class.forName(urlPilote);
			String urlBdd = "jdbc:mysql://localhost:3306/Inscription";
			String user="root";
			String passwd="Iloveinformatique";
			Connection con = DriverManager.getConnection(urlBdd, user, passwd);
			return con;
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
			return null;
		}
	}
	
	public static void InsererPatient(String prenom, String nom, String telephone, String adresse, int age) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Patient(prenom, nom, telephone, adresse, age) VALUES ('"+prenom+"','"+nom+"', '"+telephone+"', '"+adresse+"', '"+age+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Compte creer avec succes");
        }
	}
	
	public static void InsererMedecin(String login, String mot_de_passe){
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Medecin(login, mot_de_passe) VALUES ('"+login+"', '"+mot_de_passe+"')");
           
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Compte creer avec succes");
        }
    }
	
	public static void InsererSecretaire(String ch1, String ch2) {
		try{
            Connection con = ConnectionBD();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Secretaire(login, mot_de_passe) VALUES ('"+ch1+"', '"+ch2+"')");
           
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
	 
	public static boolean connectionMedecin(String login, String motDePasse) {
		boolean ok = false;
		String log = null;
		String pass = null;
		try{
	            Connection con = ConnectionBD();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM Medecin where login='"+login+"' && mot_de_passe='"+motDePasse+"'");
	           
	            ResultSet result = statement.executeQuery();
	            while(result.next()){
	            	log = result.getString("login");
	                pass = result.getString("mot_de_passe");
	            }
	            if(login.equals(log) && motDePasse.equals(pass)) {
	            	ok = true;
	            }
	            //System.out.println("Tout les enregistrement ont ete selectionne !");   
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        	}
		return ok;
	}
	public static boolean connectionSecretaire(String login, String motDePasse) {
		boolean ok = false;
		String log = null;
		String pass = null;
		try{
	            Connection con = ConnectionBD();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM Secretaire where login='"+login+"' && mot_de_passe='"+motDePasse+"'");
	           
	            ResultSet result = statement.executeQuery();
	            while(result.next()){
	            	log = result.getString("login");
	                pass = result.getString("mot_de_passe");
	            }
	            if(login.equals(log) && motDePasse.equals(pass)) {
	            	ok = true;
	            }
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        	}
		return ok;
	}
}
