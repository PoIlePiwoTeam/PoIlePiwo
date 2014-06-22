package lib.windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;




import lib.data.Item;
import lib.main.Init;

public class Okno_szukaj  extends Okno_wzor implements ActionListener, WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String>   cb_kategoria ;
	private JTextField   		tf_fraza;
	private JTable		 		ta_produkty;
	private DefaultTableModel  	model;
	
	public Okno_szukaj(){
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width / 2) - (880/2),
				(screenSize.height / 2) - (600/2)
				, 880, 600);
		addWindowListener(this);
		setTitle("PoIlePiwo - Szukaj");
		setLayout(null);
		this.setResizable(false);
		cb_kategoria = new JComboBox<String>() ;
		cb_kategoria.setBounds(10, 10, 210, 20);
		add(cb_kategoria);
		
		tf_fraza = new JTextField();
		tf_fraza.setBounds(230,10,210,20);
		add(tf_fraza);
		
		JButton bt_szukaj = new JButton("Szukaj");
		bt_szukaj.setBounds(450,10,100,20);
		bt_szukaj.addActionListener(this);
		add(bt_szukaj);
		
		JButton bt_dodaj = new JButton("Dodaj");
		bt_dodaj.setBounds(560,10,100,20);
		bt_dodaj.addActionListener(this);
		
		add(bt_dodaj);
		
		JButton bt_usun = new JButton("Usuñ");
		bt_usun.setBounds(660,10,100,20);
		bt_usun.addActionListener(this);
		add(bt_usun);
		
		JButton bt_dokoszyka = new JButton("Do koszyka");
		bt_dokoszyka.setBounds(760,10,100,20);
		bt_dokoszyka.addActionListener(this);
		add(bt_dokoszyka);
		
		
		String[] columnNames = {"ID",
                "Nazwa produktu",
                "Kategoria",
                "Firma",
                "Sklep",
                "Jakoœæ",
                "Cena"};
		
		Object[][] data ={ };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 840, 525);
		model = new DefaultTableModel(data, columnNames);
		ta_produkty = new JTable(model);
		scrollPane.setViewportView(ta_produkty);
		add(scrollPane);
		
		List<Item> products = lib.main.Init.getItemsDb().GetAllItems();
		for(int i=0;i<products.size();i++){
			addItem(products.get(i).getDataAsVector());
		}
		updateKategorie();
	}
	
	
	public void updateKategorie(){
		List<String>  lista= new ArrayList<String>();
		cb_kategoria.removeAllItems();
		cb_kategoria.addItem("Wszystkie");
		for(int i=0;i<ta_produkty.getRowCount();i++){
			String kat = (String)ta_produkty.getValueAt(i, 2);
			System.out.println("=SZUKAM="+kat);
			Boolean find = false;
			for(int j=0;j<lista.size();j++){
				System.out.println("=POWORNUJE="+lista.get(j));
				if(	lista.get(j).equals(kat)){
					System.out.println("ZNALAZLEM");
					find = true;
					break;
				}
			}
			if(! find){
				lista.add(kat);
				cb_kategoria.addItem(kat);
			}
		}
	}
	
	public void addItem(Vector data){
		//DefaultTableModel model = (DefaultTableModel) ta_produkty.getModel();
		data.setElementAt(data.elementAt(5).toString()+" / 100",5);
		data.setElementAt(data.elementAt(6).toString()+" PLN",6);
		model.addRow(data);
	}


	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Dodaj")){
			lib.main.Init.showForm("Dodaj", this);
		}
		if(e.getActionCommand().equals("Usuñ")){
			int[] indexy = ta_produkty.getSelectedRows();
			for(int i=0;i<indexy.length;i++){
				lib.main.Init.getItemsDb().deleteItem(Integer.parseInt(ta_produkty.getValueAt(indexy[i]-i, 0).toString()));
				model.removeRow(indexy[i]-i);
			}
		}
		if(e.getActionCommand().equals("Do koszyka")){
			int[] indexy = ta_produkty.getSelectedRows();
			for(int i=0;i<indexy.length;i++){
				Item it = Init.getItemsDb().GetItem((Integer.parseInt(ta_produkty.getValueAt(indexy[i], 0).toString())));
				Init.getKoszyk().addItem(it);
				((Okno_koszyk) Init.getOkno("Koszyk")).addItem(it.getDataAsVector());
			}
		}
		
		if(e.getActionCommand().equals("Szukaj")){
			String kat = ((String)cb_kategoria.getSelectedItem());
			String fra = tf_fraza.getText().trim();
			model.setRowCount(0);
			
			List<Item> lista = Init.getItemsDb().GetAllItems();
			for(int i=0;i<lista.size();i++){
				if((kat.equals("Wszystkie") || kat.equals(lista.get(i).getKategoria()))
					&&
				  ( (fra.equals("")) || ( lista.get(i).getNazwa().toLowerCase().indexOf(fra.toLowerCase()) != -1 )))
				{
					addItem(lista.get(i).getDataAsVector());
				}
			}
			
		}
	
	}

}
