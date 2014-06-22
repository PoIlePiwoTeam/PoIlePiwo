package lib.windows;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lib.data.Item;
import lib.main.Init;

public class Okno_dodaj extends Okno_wzor implements ActionListener, WindowListener {

	private JTextField fb_nazwa;
	private JTextField fb_kategoria;
	private JTextField fb_firma;
	private JTextField fb_sklep;
	private JTextField fb_jakosc;
	private JTextField fb_cena;
	
	public Okno_dodaj(){
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width / 2) - (600/2),
				(screenSize.height / 2) - (300/2)
				, 600, 300);
		addWindowListener(this);
		setTitle("PoIlePiwo - Dodaj produkt");
		setLayout(null);
		this.setResizable(false);
		
		fb_nazwa = new JTextField();
		fb_kategoria = new JTextField();
		fb_firma = new JTextField();
		fb_sklep = new JTextField();
		fb_jakosc = new JTextField();
		fb_cena = new JTextField();
		
		
		fb_nazwa.setBounds(300, 50, 250, 20);
		fb_kategoria.setBounds(300, 80, 250, 20);
		fb_firma.setBounds(300, 110, 250, 20);
		fb_sklep.setBounds(300, 140, 250, 20);
		fb_jakosc.setBounds(300, 170, 250, 20);
		fb_cena.setBounds(300, 200, 250, 20);
		
		add(fb_nazwa);
		add(fb_kategoria);
		add(fb_firma);
		add(fb_sklep);
		add(fb_jakosc);
		add(fb_cena);
		//repaint();
		
		
		JLabel tekst = new JLabel("Nazwa");
		tekst.setBounds(10, 50, 250, 20);
		add(tekst);
		tekst = new JLabel("Kategoria");
		tekst.setBounds(10, 80, 250, 20);
		add(tekst);
		tekst= new JLabel("Firma");
		tekst.setBounds(10, 110, 250, 20);
		add(tekst);
		tekst= new JLabel("Sklep");
		tekst.setBounds(10, 140, 250, 20);
		add(tekst);
		tekst= new JLabel("Jakosc");
		tekst.setBounds(10, 170, 250, 20);
		add(tekst);
		tekst= new JLabel("Cena");
		tekst.setBounds(10, 200, 250, 20);
		add(tekst);
		
		JButton b_dodaj = new JButton("Dodaj");
		JButton b_anuluj = new JButton("Anuluj");
		b_dodaj.setBounds(300, 225, 100, 25);
		b_anuluj.setBounds(410, 225, 100, 25);
		add(b_dodaj);
		add(b_anuluj);
		
		b_dodaj.addActionListener(this);
		b_anuluj.addActionListener(this);
		
		
		
	}
	
	public Item getInfoFromBoxes(){
		return new Item(-1, 
				fb_nazwa.getText(), 
				fb_kategoria.getText(), 
				fb_firma.getText(), 
				fb_sklep.getText(), 
				Integer.parseInt(fb_jakosc.getText()), 
				Float.parseFloat(fb_cena.getText()));
		
		
		
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
		if(e.getActionCommand().equals("Anuluj")){
			lib.main.Init.getOkno("Dodaj").setVisible(false);
		}
		
		if(e.getActionCommand().equals("Dodaj")){
			Item it = getInfoFromBoxes();
			it.setId( lib.main.Init.getItemsDb().insertItem(it) );
			((Okno_szukaj) lib.main.Init.getOkno("Szukaj")).addItem(it.getDataAsVector());
			((Okno_szukaj) lib.main.Init.getOkno("Szukaj")).updateKategorie();
			lib.main.Init.backForm(this);
		}
		
		
	}
	

}
