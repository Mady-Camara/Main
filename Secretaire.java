package gdsm;
public class Secretaire {
	private String login;
	private String motDePasse;
	
	//CONSTRUCTEUR
	public Secretaire(){}
	
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
	public void creeSecretaire() {
		Secretaire S = new Secretaire();
		System.out.println("============CREATION DU COMPTE SECRETAIRE=========");
		S.setLogin(Validation.validationLogin());
		S.setMotDePasse(Validation.validationMotDePasse());
		Connections.InsererSecretaire(S.getLogin(), S.getMotDePasse());
	}
}
