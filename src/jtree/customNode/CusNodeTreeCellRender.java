package jtree.customNode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.TreeCellRenderer;

import jtree.checkBoxTree.CheckBoxTreeLabel;

public class CusNodeTreeCellRender extends JPanel implements TreeCellRenderer {

	private static final long serialVersionUID = 4676667399191240255L;

	protected CheckBoxTreeLabel label;

	// protected JLabel label;
	public CusNodeTreeCellRender() {
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
	    boolean nodeIsEnabled = ((CusTreeNode) value).isEnabled();
	    setEnabled(nodeIsEnabled);
	   
		label.setFont(tree.getFont());
		label.setText(stringValue);
		label.setSelected(selected);
		label.setFocus(hasFocus);
		if (leaf)
			label.setIcon(UIManager.getIcon("Tree.leafIcon"));
		else if (expanded)
			label.setIcon(UIManager.getIcon("Tree.openIcon"));
		else{
			 label.setIcon(UIManager.getIcon("Tree.closedIcon"));
		}
		Icon icon = ((CusTreeNode) value).getIcon();
		if(icon != null){
			 label.setIcon(icon);
		}

		return this;
	}

	@Override
	public void setBackground(Color color) {
		if (color instanceof ColorUIResource)
			color = null;
		super.setBackground(color);
	}
}
