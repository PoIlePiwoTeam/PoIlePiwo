package lib.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import lib.data.HistoryItem;
import lib.data.Item;
import lib.main.Init;

public class Okno_historia extends Okno_wzor implements ActionListener, WindowListener {


	private JTextArea topPanel;
	
	public Okno_historia(){
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width / 2) - (880/2),
				(screenSize.height / 2) - (600/2)
				, 880, 600);
		addWindowListener(this);
		setTitle("PoIlePiwo - Historia");
		setLayout(null);
		this.setResizable(false);
		
		
		//topPanel.setLayout( new BorderLayout() );
		topPanel = new JTextArea();
		topPanel.setEditable(false);
		//topPanel.setBounds(0,0,800,600);
		//add(topPanel);
		JScrollPane sp = new JScrollPane(topPanel);
		sp.setBounds(0,0,872,576);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(sp);
		
	}
	
	public void updateList(){
		topPanel.setText("");
		int x = 0;
		int y = 0;
		List<HistoryItem> li = Init.getItemsDb().GetAllItemsHistory();
		for(int i=0;i<li.size();i++){
			topPanel.setText(topPanel.getText()+"Zakupy z : "+li.get(i).getDate().toString()+" za "+li.get(i).getCena().toString()+"PLN\n");

			String[] itl = li.get(i).getItems().split(",");
			System.out.println("ILOSC - " +li.get(i).getItems());
			for(int j=0;j<itl.length;j++){
				System.out.println("robie");
				Item nx = Init.getItemsDb().GetItem(Integer.parseInt(itl[j]));
				topPanel.setText(topPanel.getText()+"\t*"+nx.getNazwa()+"\n");
			}
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
