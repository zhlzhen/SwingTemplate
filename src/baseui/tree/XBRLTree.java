package baseui.tree;

import java.util.List;
import java.util.TreeMap;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uap.xbrl.xpeimpl.dimension.dimensionByDts.MemberItem;

public class XBRLTree extends JTree {

	private static final long serialVersionUID = 1L;
	
	private XBRLTreeModel treeModel = null;
	
	public XBRLTree(){
		super(new XBRLTreeModel(new DefaultMutableTreeNode("")));
		this.setCellRenderer(new XBRLTreeCellRenderer());
		this.addTreeSelectionListener(new XBRLTreeSelectListener());
	}

	//直接构建一棵树
	public XBRLTree(DefaultMutableTreeNode node) {

		super(new XBRLTreeModel(node));
		this.setCellRenderer(new XBRLTreeCellRenderer());
		this.addTreeSelectionListener(new XBRLTreeSelectListener());
	}

	//更新数据
	public void setData(TreeMap<String, List<MemberItem>> listDefinitions) {
		this.clearSelection();
		treeModel = new XBRLTreeModel(listDefinitions);
		this.setModel(treeModel);
		//根节点隐藏显示
		this.setRootVisible(false);
		this.repaint();
	}

	public XBRLTreeModel getTreeModel() {
		return treeModel;
		
	}

	public void setTreeModel(XBRLTreeModel treeModel) {
		this.treeModel = treeModel;
	}

}
