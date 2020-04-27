package gdsm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Date;
import java.util.Scanner;
public class Patient {
	private String nomPatient;
	private String prenomPatient;
	private String numeroTelephonePatient;
	private String adresse;
	private int age;
	//private String groupeSanguin;
	//private ArrayList<String> maladies;
	//private String allergy;
	//private String medicament;
	//***************Constructor sans parameter*********
	public Patient(){}
	
	//***************DEBUT accesseurs*********
	public String getNumeroTelephone()
	{
		return numeroTelephonePatient;
	}
	public void setNumeroTelephone(String numeroTelephonePatient)
	{
		this.numeroTelephonePatient=numeroTelephonePatient;
	}
	public String getNom()
	{ 
		return nomPatient;
	}
	public void setNom(String nomPatient)
	{
		this.nomPatient=nomPatient;
	}
	public String getPrenom()
	{ 
		return prenomPatient;
	}
	public void setPrenom(String prenomPatient)
	{
		this.prenomPatient=prenomPatient;
	}	
	
	public String getAdresse()
	{ 
		return adresse;
	}
	public void setAdresse(String adresse)
	{
		this.adresse=adresse;
	}
	
	public int getAge()
	{ 
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	//***************FIN Accesseurs*********
	
	Scanner sc = new Scanner(System.in);
	public void creePatient() {
		Patient P = new Patient();
		System.out.println("============CREATION DU COMPTE PATIENT=========");
		P.setPrenom(Validation.validationNomPrenom("prenom"));
		P.setNom(Validation.validationNomPrenom("nom"));
		System.out.println("Donner l'adresse du patient :");
		P.setAdresse(Validation.validationChaine());;
		P.setNumeroTelephone(Validation.validationTelephone());
		P.setAge(Validation.validationAge());
		Connections.InsererPatient(P.getPrenom(), P.getNom(), P.getNumeroTelephone(), P.getAdresse(), P.getAge());
	}	//FIN creePatient
	
	public void afficherPatient(String tel){
        try{
            Connection con = Connections.ConnectionBD();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Patient where telephone='"+tel+"' ");
           
            ResultSet result = statement.executeQuery();
            while(result.next()) {
            	String num = result.getString("telephone");
            	if(tel.equals(num)) {
            		System.out.println("=============================");
            	}
            	System.out.println("prenom : "+result.getString("prenom"));
                System.out.println("nom : "+result.getString("nom"));
                System.out.println("telephone : "+result.getString("telephone"));
                System.out.println("adresse : "+result.getString("adresse"));
                System.out.println("age : "+result.getString("age"));
                System.out.println("groupe sanguin : "+result.getString("groupe_sanguin"));
                System.out.println("maladie(s) : "+result.getString("maladies"));
                System.out.println("medicament(s) : "+result.getString("medicaments"));
            }
            		System.out.println("=============================");
        }
        catch(Exception e){
        	System.out.println(e);
        }
	}//fin afficherPatient
	
	public  void afficherRdv(){
        try{
            Connection con = Connections.ConnectionBD();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM rendez_vous ORDER BY id DESC LIMIT 30");
           
            ResultSet result = statement.executeQuery();
            System.out.println("============NOS RENDEZ VOUS PATIENT=========");
            while(result.next()){
            	System.out.print(result.getString("id"));
                System.out.print(" ");
                System.out.print(result.getString("nom"));
                System.out.print(" ");
                System.out.print(result.getString("prenom"));
                System.out.print(" ");
                System.out.println(result.getString("date"));
            }
            System.out.println("============================================");
           
        }catch(Exception e){System.out.println(e);}
	}
		
	public String dateRdv() {
		int mois = Validation.validationMois();
		int jour = Validation.validationJour(mois);
		int annee = Validation.validationAnnee();
		String dt= jour+"/"+mois+"/"+annee;
		return dt;
	}	//FIN FONCTION RDV_Patient
}
