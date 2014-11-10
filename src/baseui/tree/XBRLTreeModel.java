/**
 * 
 */
package baseui.tree;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * @author zhailzh
 *
 */
public class XBRLTreeModel extends DefaultTreeModel{

	private static DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	
	private static final long serialVersionUID = 2131679661706306087L;
	
	public XBRLTreeModel(TreeNode root) {
		super(root);
	}

	public XBRLTreeModel(TreeMap<String, List<MemberItem>> listDefinitions) {
		super(root);
		for (Entry<String, List<MemberItem>> roleDef: listDefinitions.entrySet()) {
			MutableTreeNode roleNode = creatDefaultMutableTreeNode(roleDef);
			root.add(roleNode);
		}
	}

	private MutableTreeNode creatDefaultMutableTreeNode(Entry<String, List<MemberItem>> roleDef) {
		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(roleDef.getKey());
		if(roleDef.getValue() != null && !roleDef.getValue().isEmpty()){
			for (MemberItem memberItem : roleDef.getValue() ) {
				DefaultMutableTreeNode memNode = creatDefaultMutableTreeNode(memberItem);
				treeNode.add(memNode);
			}
		}
		
		return treeNode;
	}

	private DefaultMutableTreeNode creatDefaultMutableTreeNode(MemberItem memberItem) {
		DefaultMutableTreeNode memNode = new DefaultMutableTreeNode(memberItem);
		List<MemberItem> nestMembers = memberItem.getNestMemberitem();
		if(nestMembers!= null && !nestMembers.isEmpty()){
			for (MemberItem memberItem2 : nestMembers) {
				DefaultMutableTreeNode nestNode = creatDefaultMutableTreeNode(memberItem2);
				memNode.add(nestNode);
			}
		}
		return memNode;
	}

}
