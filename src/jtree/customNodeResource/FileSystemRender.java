package jtree.customNodeResource;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.TreeCellRenderer;

import jtree.checkBoxTree.CheckBoxTreeLabel;

public class FileSystemRender extends JPanel implements TreeCellRenderer {

	private static final long serialVersionUID = 4676667399191240255L;

	protected CheckBoxTreeLabel label;

	// protected JLabel label;
	public FileSystemRender() {
		setLayout(new BorderLayout());
		add(label = new CheckBoxTreeLabel());
		// add(label = new JLabel());
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		this.setPreferredSize(new Dimension(100, 20));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.tree.TreeCellRenderer#getTreeCellRendererComponent(javax.
	 * swing.JTree, java.lang.Object, boolean, boolean, boolean, int, boolean)
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		String stringValue = tree.convertValueToText(value, selected, expanded,
				leaf, row, hasFocus);
	    boolean nodeIsEnabled = ((TreeFileNode) value).isEnabled();
	    setEnabled(nodeIsEnabled);
	   
		label.setFont(tree.getFont());
		label.setText(stringValue);
		label.setSelected(selected);
		label.setFocus(hasFocus);
		File f = new File(stringValue);
		label.setIcon(new JFileChooser().getFileSystemView().getSystemIcon(f ));

		return this;
	}

	@Override
	public void setBackground(Color color) {
		if (color instanceof ColorUIResource)
			color = null;
		super.setBackground(color);
	}
	
}

