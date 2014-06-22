package lib.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import lib.data.HistoryItem;
import lib.data.Item;


//Czytaj wiêcej na: http://javastart.pl/zaawansowane-programowanie/bazy-danych-sqlite-w-javie/#ixzz359vp8BPZ

public class BazaDanych {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:bazadanych.db";

	private Connection conn;
	private Connection connection;
	private Statement  statement;
	private Statement  stmt;
	
	public BazaDanych(){
		  try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			statement = connection.createStatement();
		    statement.setQueryTimeout(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createTables();
	}
	

	
	public boolean createTables(){
		String createItems = "CREATE TABLE IF NOT EXISTS items "
				+ "(id_item INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nazwa VARCHAR2(100), "
				+ "kategoria VARCHAR2(100), "
				+ "firma  VARCHAR2(100), "				
				+ "sklep  VARCHAR2(200), "
				+ "jakosc NUMBER(3),"
				+ "cena   FLOAT(10)) ";
		String createHist = "CREATE TABLE IF NOT EXISTS history "
				+ "(id_item INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "data   DATE, "
				+ "items VARCHAR2(300), "
				+ "cena  float(10)) ";				
		
		try {
			statement.executeUpdate(createItems);
			statement.executeUpdate(createHist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

		
	}
	
	
	public int insertItem(Item item){

			String[] data = item.getDataAsStrings();
			String query = "INSERT INTO items VALUES(NULL,'"+data[1]+"', '"+data[2]+"', '"+data[3]+"', '"+data[4]+"', "+data[5]+", "+data[6]+")";
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getMaxId();//return getMaxId();
		
	}
	
	
	
	public int insertItemHistory(HistoryItem item){
		try{
			String command =
			"INSERT INTO history VALUES(NULL,'"+item.getDate().toString()+"','"+
			item.getItems()+"',"+item.getCena().toString()+")";
			statement.executeUpdate(command);
		}
		catch(SQLException e){
			System.err.println("Blad przy wstawianiu ItemuHistory");
			e.printStackTrace();
			return -1;
		}
		return getMaxId();
	}
	
	
	
	public List<Item> GetAllItems(){
		List<Item> items = new ArrayList<Item>();
		try{
			// prepStmt = conn.prepareStatement("SELECT * FROM items");
			ResultSet result = statement.executeQuery("SELECT * FROM items");
			while(result.next()){	
				items.add(new Item( result.getInt("id_item"),
						result.getString("nazwa"),
						result.getString("kategoria"),
						result.getString("firma"),
						result.getString("sklep"),
						result.getInt("jakosc"),
						result.getFloat("cena")
						));
			}
			result.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return items;
	}
	
	
	public List<HistoryItem> GetAllItemsHistory(){
		
		List<HistoryItem> items = new ArrayList<HistoryItem>();
		try{
			ResultSet result = statement.executeQuery("SELECT * FROM history");
			//ResultSet result = getStat("").executeQuery("SELECT * FROM history");
			while(result.next()){
				String tmp  = result.getString("data");
				items.add(new HistoryItem( result.getInt("id_item"),
						//result.getDate("data"),
						tmp,
						result.getString("items"),
						result.getFloat("cena")
						));
			}
			result.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return items;
	}
	
	public Item GetItem(Integer itemid){
		
		try{
			ResultSet result = statement.executeQuery("SELECT * FROM items WHERE id_item="+itemid.toString());
			while(result.next()){

				return (new Item( result.getInt("id_item"),
									result.getString("nazwa"),
									result.getString("kategoria"),
									result.getString("firma"),
									result.getString("sklep"),
									result.getInt("jakosc"),
									result.getFloat("cena")
						));
			}
			result.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return null;
	}
		
		
	
	
	
	public boolean deleteItem(int iditem){
		System.out.println(iditem);
		try{
			String q=
					"DELETE FROM items WHERE id_item = "+Integer.toString(iditem);
			statement.executeUpdate(q);
			
		}
		catch(SQLException e){
			System.err.println("Blad przy usuwaniu Itemu");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public void closeConnection(){
		try{
			conn.close();
		}
		catch(SQLException e){
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}
	
	public int getMaxId(){
		try{
			ResultSet result = statement.executeQuery("SELECT MAX(id_item) FROM items");	
			if(result.next())
				return result.getInt("MAX(id_item)");
			result.close();
			
		}
		catch(SQLException e){
			System.err.println("Problem ze znaleziemien max ID");
			e.printStackTrace();
		}
		return -1;
	}
	
	/*public int getCountRow(){
		int count = 0;
		try{
			PreparedStatement prepStmt = conn.prepareStatement("SELECT COUNT(id_item) FROM items");
			ResultSet result = prepStmt.executeQuery();
			if(result.next())
				count = result.getInt("COUNT(id_item)");	
			else
				count = -1;
		}
		catch(SQLException e){
			System.err.println("Problem z pobraniem ilosci wierszy");
			e.printStackTrace();
		}
		return count;
	}*/	
}
