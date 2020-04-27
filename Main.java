package gdsm;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Validation {

	public static String validationChaine() {
		Scanner sc = new Scanner(System.in);
		String nom;
		do {
			nom = sc.nextLine();
			if((nom.length() <= 2) || (nom.length() > 15)) {
				System.out.println("=> Au moins 3 caractere, au plus 25 caracteres");
			}
		}while((nom.length() <= 2) || (nom.length() > 25));
		return nom;
	}
	
	public static int ErreurInputMismatchException() {
		Scanner sc = new Scanner(System.in); 
		int nb=0;
		try{
			nb=sc.nextInt();
		}
		catch(InputMismatchException ex) {
			System.out.println("=> Vous devez saisir un entier");
		}
		return nb;
	}
	public static int validationJour(int mois) {
		int jour = 0;
		boolean ok=true;
		int limit=0;
		if(mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10 || mois==12) {
			limit=31;
		}
		else if(mois==2) {
			limit=29;
		}
		else {
			limit=30;
		}
		
		System.out.println("Donnez le jour du rendez vous :");
		do{		
			jour = Validation.ErreurInputMismatchException();
			if(jour < 1 || jour > limit) {
				System.out.println("=> Le jour doit etre compris entre 1 et "+limit);
				ok=false;
			}
			else {
				ok=true;
			}
		}while(!ok);
		return jour;
	}
	
	public static int validationMois() {
		int mois = 0;
		boolean ok=true;
		System.out.println("Donnez le mois du rendez vous : ");
		do{
			mois = Validation.ErreurInputMismatchException();

			if(mois <= 12 && mois >= 1) {
				ok=true;
			}
			else {
				ok=false;
				System.out.println("=> Le mois est compris entre 1 et 12");
			}
		}while(!ok);
		return mois;
	}
	
	public static int validationAnnee() {
		int annee = 0;
		boolean ok=true;
		System.out.println("Donnez l'annee du rendez vous :");
		do{
			annee = Validation.ErreurInputMismatchException();
			if(annee <= 2090 && annee >= 2020) {
				ok=true;
			}
			else {
				ok=false;
				System.out.println("=> L'annee est comprise entre 2020 et 2099");
			}
		}while(!ok);
		return annee;
	}
	
	public static int validationChoix0() {
		int choice = 0;
		do {
			choice=Validation.ErreurInputMismatchException();
			if(choice!=1 && choice!=2 && choice!=3) {
				System.out.println("=> Choix possible : 1, 2, 3");
			}
		}
		while(choice!=1 && choice!=2 && choice!=3);
		return choice;
	}
	
	public static int validationChoix() {
		int choice = 0;
		do {
			choice=Validation.ErreurInputMismatchException();
			if(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5) {
				System.out.println("=> Choix possible : 1, 2, 3, 4, 5");
			}
		}
		while(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5);
		return choice;
	}
	
	public static String validationTelephone() {
		Scanner sc = new Scanner(System.in);
		String numero;
		boolean ok=true, ok1=true, ok2=true;
		System.out.println("Donner le numero de telephone du Patient :");
		do{
			numero=sc.nextLine();
			String ch = numero.charAt(0)+""+numero.charAt(1);
			if(numerique2(numero)) {
				ok=true;
			}
			else {
				ok=false;
				System.out.println("=> le numero est compose de chiffre");
			}

			if( numero.length() == 9) {
				ok1=true;
			}
			else {
				ok1=false;
				System.out.println("=> Le numero comprend 9 chiffres");
			}
			if(ch.equals("76") || ch.equals("77") || ch.equals("78") || ch.equals("70")) {
				ok2=true;
			}
			else {
				ok2=false;
				System.out.println("=> Les numeros commencent par 76, 77, 70 ou 78");
			}
		}while(!ok || !ok1 || !ok2);
		return numero;
	}
	
	public static String validationNomPrenom(String libelle) {
		Scanner sc = new Scanner(System.in);
		String nom;
		boolean ok=true, ok1=true;
		System.out.println("Donnez le "+libelle+" du Patient :");
		do{
			nom=sc.nextLine();
			if(numerique(nom)) {
				ok=false;
				System.out.println("=> Pas de chiffres dans le "+libelle);
			}
			else {
				ok=true;
			}
			if((nom.length() < 4) || (nom.length() > 15)) {
				System.out.println("=> Au moins 4 caractere, au plus 15 caracteres");
				ok1=false;
			}
			else {
				ok1=true;
			}
		}while(!ok || !ok1);
		return nom;
	}
	
	public static String validationLogin() {
		Scanner sc = new Scanner(System.in);
		String login;
		boolean ok=true, ok1=true;
		System.out.println("Donnez votre login :");
		do{
			login=sc.nextLine();
			if(numerique(login)) {
				ok=false;
				System.out.println("=> le login est compose de lettres");
			}
			else {
				ok=true;
			}
			if((login.length() < 4) || (login.length() > 15)) {
				System.out.println("=> Au moins 4 caractere, au plus 15 caracteres");
				ok1=false;
			}
			else {
				ok1=true;
			}
		}while(!ok || !ok1);
		return login;
	}
	
	public static String validationMotDePasse() {
		Scanner sc = new Scanner(System.in);
		String mot_de_passe = null;
		boolean ok=true, ok1=true, ok2=true, ok3=true;
		System.out.println("Donnez le mot de passe :");
		do{
			mot_de_passe=sc.nextLine();
			if(numerique(mot_de_passe)) {
				ok=true;
			}
			else {
				ok=false;
				System.out.println("=> Votre mot de passe doit contenir au moin un chiffre");
			}
			if(majuscule(mot_de_passe)) {
				ok1=true;
			}
			else {
				ok1=false;
				System.out.println("=> Votre mot de passe doit contenir au moin un majuscule");
			}
			
			if(miniscule(mot_de_passe)) {
				ok2=true;
			}
			else {
				ok2=false;
				System.out.println("=> Votre mot de passe doit contenir au moin un miniscule");
			}
			
			if((mot_de_passe.length() <= 5) || (mot_de_passe.length() > 15)) {
				System.out.println("=> Au moins 5 caractere, au plus 15 caracteres");
				ok3=false;
			}
			else {
				ok3=true;
			}
		}while(!ok || !ok1 || !ok2 || !ok3);
		return mot_de_passe;
	}
	
	public static boolean numerique(String numero) {
		boolean digit = false;
		char c;
		for(int i=0; i < numero.length(); i++) {
			c=numero.charAt(i);
			if(Character.isDigit(c)) {
				digit = true;
			}
		}
		return digit;
	}
	
	public static boolean numerique2(String numero) {
		boolean digit = true;
		char c;
		for(int i = 0; i < numero.length(); i++) {
			c=numero.charAt(i);
			if(!Character.isDigit(c)) {
				digit = false;
				break;
			}
		}
		return digit;
	}
	
	public static boolean majuscule(String numero) {
		boolean majuscule = false;
		char c;
		for(int i=0; i < numero.length(); i++) {
			c=numero.charAt(i);
			if(Character.isUpperCase(c)) {
				majuscule = true;
				break;
			}
		}
		return majuscule;
	}
	
	public static boolean miniscule(String numero) {
		boolean miniscule = false;
		char c;
		for(int i=0; i < numero.length(); i++) {
			c=numero.charAt(i);
			if(Character.isLowerCase(c)) {
				miniscule = true;
				break;
			}
		}
		return miniscule;
	}
	
	public static int validationAge() {
		int age = 0;
		System.out.println("Donner l'age du patient");
		do{
			age = Validation.ErreurInputMismatchException();
			if(age <= 0) {
				System.out.println("=> l'age ne doit pas etre negatif");
			}
		}
		while(age <= 0);
		
		return age;
	}
}
