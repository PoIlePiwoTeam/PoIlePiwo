package lib.windows;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public abstract class Okno_wzor extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Okno_wzor last_Form;

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("IM HERE");
		lib.main.Init.backForm(this);
		
	}
	
	public void setLastForm(Okno_wzor form){
		last_Form = form;
	}
	
	public JFrame getLastForm(){
		return last_Form;
	}
	
}
