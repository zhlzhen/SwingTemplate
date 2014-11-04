package jtree.checkBoxTree;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class CheckBoxTreeNode  extends DefaultMutableTreeNode{
	
	private static final long serialVersionUID = 4150273793604275093L;
	private boolean isSelect = false ;
	private int selectionMode = 0;

	public CheckBoxTreeNode(String rootName) {
		super(rootName);
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelected(boolean isSelected) {
        this.isSelect = isSelected;
        if ((selectionMode == TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION)
             && (children != null)) {
            Enumeration<?> enumTemp = children.elements();
            while (enumTemp.hasMoreElements()) {
            	CheckBoxTreeNode node = (CheckBoxTreeNode) enumTemp.nextElement();
                node.setSelected(isSelected);
            }
        }
    }

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

}
