package jtree.customNodeResource;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class TreeFileNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 3311434895405929201L;

	private boolean isSelected = false;

	private boolean enabled = false;

	private boolean isVisible = false;

	private Icon icon = null;

	private String iconName = null;
	
	private int selectionMode = 0;

	public TreeFileNode(Object userObject,Icon icon) {
		this(userObject, true, false, true, true, icon);
	}

	public TreeFileNode(String nodePath) {
		this(nodePath, true, false, true, true, null);
	}

	public TreeFileNode(Object userObject, boolean allowsChildren,

		    boolean isSelected, boolean enabled, boolean isVisible, Icon icon) {

		    super(userObject, allowsChildren);

		    this.isSelected = isSelected;

		    this.enabled = enabled;

		    this.isVisible = isVisible;

		    this.icon = icon;

		    setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);

		}

	
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public int getSelectionMode() {
		return selectionMode;
	}

	public void setSelectionMode(int selectionMode) {
		this.selectionMode = selectionMode;
	}

	
}
