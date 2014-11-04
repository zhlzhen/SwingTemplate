/**
 * 
 */
package jtree.test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import jtree.customNode.ZTreeCusNode;

/**
 * @author zha
 *
 */
public class TestZTreeCusNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZTreeCusNode tree = new ZTreeCusNode();
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
