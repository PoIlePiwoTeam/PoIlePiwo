package lib.main;


import lib.data.Koszyk;
import lib.windows.*;

public class Init {

	private static BazaDanych 		itemsDB;
	private static Koszyk 			koszyk;
	private static Okno_main 		okno_main;
	private static Okno_szukaj 		okno_szukaj;
	private static Okno_dodaj 		okno_dodaj;
	private static Okno_koszyk 		okno_koszyk;
	private static Okno_historia	okno_historia;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		itemsDB 	= new BazaDanych();
		koszyk		= new Koszyk();
		
		
		okno_main		= new Okno_main();
		okno_szukaj 	= new Okno_szukaj();
		okno_dodaj		= new Okno_dodaj();
		okno_koszyk 	= new Okno_koszyk();
		okno_historia 	= new Okno_historia();
		
		okno_main.setVisible(true);
	}
	
	public static Koszyk getKoszyk(){
		return koszyk;
	}
	
	public static Okno_wzor getOkno(String name){
		if(name == "Main"){
			return (Okno_wzor)okno_main;
		}
		if(name == "Szukaj"){
			return (Okno_wzor)okno_szukaj;
		}
		if(name == "Dodaj"){
			return (Okno_wzor)okno_dodaj;
		}
		if(name == "Koszyk"){
			return (Okno_wzor)okno_koszyk;
		}
		if(name == "Historia"){
			return (Okno_wzor)okno_historia;
		}
		return null;
	}
	
	public static BazaDanych getItemsDb(){
		return itemsDB; 	
	}
	
	public static void showForm(String Name,Okno_wzor executor){
		executor.setVisible(false);
		Okno_wzor pointer = getOkno(Name);
		pointer.setLastForm(executor);
		pointer.setVisible(true);
	}
	
	public static void backForm(Okno_wzor executor){
		executor.setVisible(false);
		System.out.println(executor.getLastForm());
		executor.getLastForm().setVisible(true);
	}

}
