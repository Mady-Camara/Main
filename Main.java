package gdsm;
public class Main {

	public static void main(String [] args) {
		Medecin M = new Medecin();
		Secretaire S = new Secretaire();
		System.out.println("****************Bienvenu sur****************");
		System.out.println("*********************GDSM*******************");
		int choice = 0;
		boolean ok=true;
		do {
			choice = Choix.choix0();
			
			if(choice==1) 
			{
				M.creeMedecin();
			}
			else if(choice==2) 
			{
				S.creeSecretaire();
			}
			else if(choice==3) {
				int choice2;
				boolean testConnection;
				choice2 = Choix.choix1();
					if(choice2==1) {
						M.setLogin(Validation.validationLogin());
						M.setMotDePasse(Validation.validationMotDePasse());
						testConnection = Connections.connectionMedecin(M.getLogin(), M.getMotDePasse());
						if(testConnection) {
							System.out.println("==============Bienvenue "+M.getLogin()+"===========");
							Choix.testChoix(1);
						}
						else {
							System.out.println("Compte inexistant");
						}
					}
					else if(choice2==2) {
						S.setLogin(Validation.validationLogin());
						S.setMotDePasse(Validation.validationMotDePasse());
						testConnection = Connections.connectionSecretaire(S.getLogin(), S.getMotDePasse());
						if(testConnection) {
							System.out.println("==============Bienvenue "+S.getLogin()+"===========");
							Choix.testChoix(0);
						}
						else {
							System.out.println("Compte inexistant");
						}
					}
			}
		}
		while(ok);
	}	//fin main
}
