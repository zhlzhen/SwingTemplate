package baseui.tabbedPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;

import util.ImageManager;

public class XBRLTabbedPanel extends JTabbedPane{

	private static final long serialVersionUID = 8476528157769155939L;
	
	private static final int number = 10 ;
	
	private static int current = 0 ;
	
	public XBRLTabbedPanel(){
	}

	public void addTabbedPanel(String text, DefaultMutableTreeNode node){
		if(current < number){
			
			JPanel panel = new XBRLRoleTypeTable();
			add(text,panel);
			setTabComponentAt(current, new ButtonTabComponent(this));
			this.setBackground(Color.WHITE);
			this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			current++;
		}
		
	}

	public static int getCurrent() {
		return current;
	}

	public static void setCurrent(int current) {
		XBRLTabbedPanel.current = current;
	}

	
}
