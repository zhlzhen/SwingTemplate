/**
 * 
 */
package jtree.test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jtree.checkBoxTree.CheckBoxTreeNodeListender;
import jtree.checkBoxTree.ZTreeCheckBox;

/**
 * @author zhailzh
 *
 */
public class TestCheckBoxTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZTreeCheckBox tree = new ZTreeCheckBox();
		JScrollPane scroll = new JScrollPane(tree);
		scroll.setPreferredSize(new Dimension(300, 330));
		//²âÊÔµÄ»·¾³
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scroll,BorderLayout.WEST);
		
		JPanel buttonPanel = new JPanel();
		JButton all = new JButton("Select All");
		all.setPreferredSize(new Dimension(130, 25));
		all.setActionCommand("SelectAll");
		all.addMouseListener(new CheckBoxTreeNodeListender(tree));
		buttonPanel.add(all);

		JButton deselect = new JButton("Deselect All");
		deselect.setPreferredSize(new Dimension(130, 25));
		deselect.setActionCommand("DeselectAll");
		deselect.addMouseListener(new CheckBoxTreeNodeListender(tree));
		buttonPanel.add(deselect);
		
		JButton selectSub = new JButton("Select SubTree");
		selectSub.setPreferredSize(new Dimension(130, 25));
		selectSub.setActionCommand("SelectSubTree");
		selectSub.addMouseListener(new CheckBoxTreeNodeListender(tree));
		buttonPanel.add(selectSub);
		
		JButton deselectSub = new JButton("Deselect SubTree");
		deselectSub.setPreferredSize(new Dimension(130, 25));
		deselectSub.setActionCommand("DeselectSubTree");
		deselectSub.addMouseListener(new CheckBoxTreeNodeListender(tree));
		buttonPanel.add(deselectSub);
		
		buttonPanel.setPreferredSize(new Dimension(160, 330));
		panel.add(buttonPanel,BorderLayout.EAST);
		
		JFrame test = new JFrame();
		test.setSize(460, 330);
		test.setLocation((test.getToolkit().getScreenSize().width - 450) / 2,
				(test.getToolkit().getScreenSize().height - 330) / 2);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.add(panel);
		test.setVisible(true);

	}

}
