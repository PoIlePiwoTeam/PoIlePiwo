package lib.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lib.main.*;
import lib.data.*;
import lib.windows.*;

public class Koszyk {
	
	private int itemsCount;
	private List<Item> items;
	private float cena = 0;
	
	public Koszyk(){
		items 		= new ArrayList<Item>();
		itemsCount 	= 0;
		cena	   	= 0;
	}
	
	
	public void addItem(Item item){
		items.add(item);
		cena += item.getCena();
		itemsCount++;
		if(Init.getOkno("Main") != null)
		((Okno_main)Init.getOkno("Main")).setReady(true);
	}
	
	public List<Item> getAllItems(){
		return items;
	}
	
	public void removeItem(Integer id){
		cena -= items.get(id).getCena();
		items.remove(id);
		itemsCount--;
	}
	
	public float policzCene(){
		return cena;
	}
	
	public void clearKoszyk(){
		cena = 0;
		itemsCount = 0;
		items.clear();
		if(Init.getOkno("Main") != null)
		((Okno_main)Init.getOkno("Main")).setReady(false);
	}
	
	public void finalizujKoszyk(){
		String itm = "";
		for(int i=0;i<items.size();i++){
			itm += items.get(i).getId().toString()+",";
		}
		Date date = new Date();
		HistoryItem nm = new HistoryItem(-1, date.toString(), itm, cena);
		Init.getItemsDb().insertItemHistory(nm);
		clearKoszyk();
	}


	private String Integer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
