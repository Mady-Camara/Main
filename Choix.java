package gdsm;
import java.util.Scanner;
public class Choix {
	public static int choix() { 
		int ch = 0;
		System.out.println("1 Creer un compte Patient ");
		System.out.println("2 Acceder au compte Patient (Medecin only) ");
		System.out.println("3 Fixer un rendez vous ?");
		System.out.println("4 Consulter les rendez vous ?");
		System.out.println("5 se deconnecter ?");
		System.out.println("Donner votre choix : ");
		ch=Validation.validationChoix();
		return ch;
	}	//FIN choix
	
	public static int choix0() { 
		int ch = 0;
		System.out.println("1 Pour creer un compte medecin");
		System.out.println("2 Pour creer un compte secretaire");
		System.out.println("3 Pour vous connecter (medecin , secretaire)");
		System.out.println("Donner votre choix : ");
		ch=Validation.validationChoix0();
		return ch;
	}
	
	public static int choix1() { 
		int ch = 0;
		System.out.println("1 Se connecter en tant que medecin");
		System.out.println("2 Se connecter en tant que secretaire");
		System.out.println("3 Pour retouner");
		System.out.println("Donner votre choix : ");
		ch=Validation.validationChoix0();
		return ch;
	}
	
	public static void testChoix(int droit){
		Patient P = new Patient();
		Scanner sc = new Scanner(System.in);
		boolean ok=true;
		do
		{
			int choix = Choix.choix();
			switch(choix)
			{
				case 1 :
					do {
						P.creePatient();
						System.out.println("Voulez vous cree un autre patient : OUI ou NON");
						String vok=sc.nextLine();
						if(vok.equals("O") || vok.equals("o") || vok.equals("oui") || vok.equals("OUI") || vok.equals("Oui")) {
							ok=true;
						}	
						else {
							ok=false;
						}
					}
					while(ok);
					break;	
					
				case 2 :
					String vok;
					if(droit==0) {
						System.out.println("Vous n'avez pas le droit (Seulement le medecin)");
						ok = false;
					}
					else {
						P.setNumeroTelephone(Validation.validationTelephone());
						P.afficherPatient(P.getNumeroTelephone());
						System.out.println("Appuyer sur une ENTREE pour retourner :");
						vok = sc.nextLine();
						if(!vok.equals("YaKouNaMaTaTa")) {
							ok=false;
						}	
					}
					break;
					
				case 3 :
					P.setPrenom(Validation.validationNomPrenom("nom"));
					P.setNom(Validation.validationNomPrenom("prenom"));
					String date = P.dateRdv();
					Connections.InsererRdv(P.getPrenom(), P.getNom(), date);
					ok=false;
					break;
				
				case 4 :
					P.afficherRdv();
					System.out.println("Appuyer sur ENTREE pour retourner :");
					vok = sc.nextLine();
					if(!vok.equals("YaKouNaMaTaTa")) {
						ok=false;
					}	
					break;
				case 5 :
					ok = true;
					System.out.println("Bye bye");
					break;
				default :
					System.out.println("Saisie incorrect");
					ok=false;
					break;
			}//FIN switch
		}//FIN do
		while(!ok);
	}
}
