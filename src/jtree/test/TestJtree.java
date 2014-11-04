/**
 * 
 */
package jtree.test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import jtree.ZJtree;

/**
 * @author zhailzh
 *
 */
public class TestJtree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JTree tree = new ZJtree();
		JScrollPane scroll = new JScrollPane(tree);
		//²âÊÔµÄ»·¾³
		JFrame test = new JFrame();
		test.setSize(450, 330);
		test.setLocation((test.getToolkit().getScreenSize().width - 450) / 2,
				(test.getToolkit().getScreenSize().height - 330) / 2);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.add(scroll);
		test.setVisible(true);

	}

}
