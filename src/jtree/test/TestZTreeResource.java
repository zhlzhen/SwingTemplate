/**
 * 
 */
package jtree.test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import jtree.customNode.ZTreeCusNode;
import jtree.customNodeResource.ZTreeResource;

/**
 * @author zha
 *
 */
public class TestZTreeResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZTreeResource tree = new ZTreeResource();
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
