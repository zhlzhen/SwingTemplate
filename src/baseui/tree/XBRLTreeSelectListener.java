package baseui.tree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;

import model.InstanceModelData;

public class XBRLTreeSelectListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		//增加限制，点击某张表的表头的时候，才会出现绘表的情况
		Object newselect = e.getNewLeadSelectionPath().getLastPathComponent();
		if(newselect instanceof DefaultMutableTreeNode){
			DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) newselect;
			if(selectNode.getUserObject() instanceof String){
				InstanceModelData.getInstance().firePropertyChange("UpdateTable", null, selectNode);
			}
		}
	}

}
