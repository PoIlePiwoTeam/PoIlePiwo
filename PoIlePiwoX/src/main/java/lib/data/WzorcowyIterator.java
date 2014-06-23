package lib.data;

import java.util.ArrayList;
import java.util.List;

public class WzorcowyIterator {
	private List<Item> lista;
	private Integer	   count;
	private Integer	   wsk;
	
	public WzorcowyIterator(){
		count =0;
		wsk   =0;
		lista =new ArrayList<Item>();
	}
	
	public Boolean hasItem(){
		return wsk < count;
	}
	
	public Integer AddItem(Item it){
		lista.add(it);
		count++;
		return count;
	}
	
	public Item getNext(){
		Item it = lista.get(wsk);
		wsk++;
		return it;
	}
	
	public void toBegin(){
		wsk = 0;
	}
	
	public boolean deleteItem(Integer id){
		if (id > count){
			return false;
		}else{
			lista.remove(id);
			count--;
			return true;
		}
	}
	
}
