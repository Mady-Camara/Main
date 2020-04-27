package gdsm;
public class Medecin {
	private String login;
	private String motDePasse;
	
	//CONSTRUCTEUR
	public Medecin(){}
	//ACCESSEURS
	public String getLogin()
	{ 
		return login;
	}
	public void setLogin(String login)
	{
		this.login=login;
	}
	public String getMotDePasse()
	{ 
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse=motDePasse;
	}	
	
	
	public void creeMedecin() {
		Medecin M = new Medecin();
		System.out.println("============CREATION DU COMPTE MEDECIN=========");
		M.setLogin(Validation.validationLogin());
		M.setMotDePasse(Validation.validationMotDePasse());
		Connections.InsererMedecin(M.getLogin(), M.getMotDePasse());
	}
}
