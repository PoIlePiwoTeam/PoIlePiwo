package lib.data;

import java.util.Date;

public class HistoryItem {
	
	private Integer id;	
	private String data;
	private String items;
	private Float	cena;
	
	public HistoryItem(Integer _id,String _data,String _items,float _cena){
		id = _id;
		data = _data;
		items = _items;
		cena = _cena;
	}
	
	public String getItems(){
		return items;
	}
	
	public String getDate(){
		return data;
	}
	
	public Float getCena(){
		return cena;
	}
	
}
