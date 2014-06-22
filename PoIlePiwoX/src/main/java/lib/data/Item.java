package lib.data;

import java.util.Vector;



public class Item {
	private Integer	id;
	private String 	nazwa;
	private String 	kategoria;
	private String 	firma;
	private String 	sklep;
	private Integer	jakosc;
	private Float 	cena;

	public Item(int id_, String nazwa, String kategoria, String firma, String sklep, int jakosc, float cena){
		this.id			= id_;
		this.nazwa 		= nazwa;
		this.kategoria	= kategoria;
		this.firma 		= firma;
		this.sklep 		= sklep;
		this.jakosc 	= jakosc;
		this.cena 		= cena;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public float getCena(){
		return cena;
	}
	
	
	public void setNazwa(String nazwa){
		this.nazwa = nazwa;
	}
	
	public void setFirma(String firma){
		this.firma = firma;
	}
	
	public void setKategoria(String kategoria){
		this.kategoria = kategoria;
	}
	
	public void setJakosc(int jakosc){
		this.jakosc = jakosc;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getNazwa(){
		return nazwa;
	}
	
	public String getFirma(){
		return firma;
	}
	
	public String getKategoria(){
		return kategoria;
	}
	
	public int getJakosc(){
		return jakosc;
	}
	
	public String[] getDataAsStrings(){
		String[] getData = {id.toString(), nazwa, kategoria, firma, sklep, jakosc.toString(), cena.toString()};
		return 	getData;
	}
	
	public Vector getDataAsVector(){
		Vector row = new Vector();
		row.add(id);
		row.add(nazwa);
		row.add(kategoria);
		row.add(firma);
		row.add(sklep);
		row.add(jakosc);
		row.add(cena);
		return row;
	}
	
}
