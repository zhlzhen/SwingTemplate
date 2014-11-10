package baseui.tree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class XBRLTreeSelectListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		//澧炲姞闄愬埗锛岀偣鍑绘煇寮犺〃鐨勮〃澶寸殑鏃跺�锛屾墠浼氬嚭鐜扮粯琛ㄧ殑鎯呭喌
		Object newselect = e.getNewLeadSelectionPath().getLastPathComponent();
		if(newselect instanceof DefaultMutableTreeNode){
			DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) newselect;
			if(selectNode.getUserObject() instanceof String){
				InstanceModelData.getInstance().firePropertyChange("UpdateTable", null, selectNode);
			}
		}
	}

}
