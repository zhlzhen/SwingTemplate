package baseui.tree;

import java.util.List;
import java.util.TreeMap;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class XBRLTree extends JTree {

	private static final long serialVersionUID = 1L;
	
	private XBRLTreeModel treeModel = null;
	
	public XBRLTree(){
		super(new XBRLTreeModel(new DefaultMutableTreeNode("")));
		this.setCellRenderer(new XBRLTreeCellRenderer());
		this.addTreeSelectionListener(new XBRLTreeSelectListener());
	}

	//鐩存帴鏋勫缓涓�５鏍�
	public XBRLTree(DefaultMutableTreeNode node) {

		super(new XBRLTreeModel(node));
		this.setCellRenderer(new XBRLTreeCellRenderer());
		this.addTreeSelectionListener(new XBRLTreeSelectListener());
	}

	//鏇存柊鏁版嵁
	public void setData(TreeMap<String, List<MemberItem>> listDefinitions) {
		this.clearSelection();
		treeModel = new XBRLTreeModel(listDefinitions);
		this.setModel(treeModel);
		//鏍硅妭鐐归殣钘忔樉绀�
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
