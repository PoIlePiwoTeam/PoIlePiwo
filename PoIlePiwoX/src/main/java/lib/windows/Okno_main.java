package lib.windows;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import lib.data.Item;
import lib.main.Library;




public class Okno_main extends Okno_wzor implements ActionListener, WindowListener{

	JButton bt_tmp;
	JLabel 	lab_ilosc;
	JLabel	lab_cena;
	JButton bt_rdy;
	
	public Okno_main(){
		super();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds((screenSize.width / 2) - (235/2),
				(screenSize.height / 2) - (230/2)
				, 235, 230);
		
		
		System.out.println(lib.main.Init.getKoszyk());
		addWindowListener(this);
		setTitle("PoIlePiwo");
		setLayout(null);
		this.setResizable(false);
		//setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar (menuBar);
		JMenu menu = new JMenu("Plik");
		menuBar.add(menu);
		
		JMenuItem m = new JMenuItem("Zakoñcz");
		m.addActionListener(this);
		menu.add(m);
		//System.out.print();
		
		
		
		lab_ilosc = new JLabel();
		//lab_ilosc = 
	
		
		bt_tmp = new JButton("Szukaj");
		this.add(bt_tmp);
		bt_tmp.addActionListener(this);
		bt_tmp.setBounds(10, 10, 200, 30);
		
		bt_tmp = new JButton("Koszyk");
		this.add(bt_tmp);
		bt_tmp.addActionListener(this);
		bt_tmp.setBounds(10, 50, 200, 30);
		
		bt_tmp = new JButton("Historia");
		this.add(bt_tmp);
		bt_tmp.addActionListener(this);
		bt_tmp.setBounds(10, 90, 200, 30);
		
		bt_rdy = new JButton("Zrobione");
		this.add(bt_rdy);
		bt_rdy.addActionListener(this);
		bt_rdy.setBounds(10, 130, 200, 30);
		bt_rdy.setEnabled(false);
		
		
	}
	
	public void setReady(boolean status){
		bt_rdy.setEnabled(status);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		System.out.print("ha");
		if(e.getActionCommand().equals("Zamknij")){
			System.exit(0);
		}
		
		if(e.getActionCommand().equals("Szukaj")){
			lib.main.Init.showForm("Szukaj", this);
		}
		
		if(e.getActionCommand().equals("Koszyk")){
			lib.main.Init.showForm("Koszyk", this);
		}
		
		if(e.getActionCommand().equals("Historia")){
			((Okno_historia)lib.main.Init.getOkno("Historia")).updateList();
			lib.main.Init.showForm("Historia", this);
		}
		
		
		if(e.getActionCommand().equals("Zrobione")){
			lib.main.Init.getKoszyk().finalizujKoszyk();
			
		}
					
	}




	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
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

}
