package jtree.customNodeResource;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class LazyMutableTreeNode extends DefaultMutableTreeNode{
	
	
	private static final long serialVersionUID = 3917464179072160462L;
	/** is node load. */

	private boolean loaded = false;

	//�ṩһ���鷽��������ʵ��:

	protected abstract void loadChildren();



}
