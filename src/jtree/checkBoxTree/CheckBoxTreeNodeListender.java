package jtree.checkBoxTree;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class CheckBoxTreeNodeListender extends MouseAdapter {

	private JTree zTreeCheckBox = null;

	public CheckBoxTreeNodeListender(JTree zTreeCheckBox) {

		this.zTreeCheckBox = zTreeCheckBox;
	}

	// 被选中事件
	@Override
	public void mousePressed(MouseEvent event) {
		Point p = event.getPoint();
		int row = zTreeCheckBox.getRowForLocation(p.x, p.y);
		TreePath path = zTreeCheckBox.getPathForRow(row);
		
		if(event.getSource() instanceof ZTreeCheckBox){
			if (path != null) {
				CheckBoxTreeNode node = (CheckBoxTreeNode) path
						.getLastPathComponent();
				if (node != null) {
					boolean isSelected = !node.isSelect();
					node.setSelected(isSelected);
					((DefaultTreeModel) zTreeCheckBox.getModel()).nodeStructureChanged(node);
				}
			}
		}
		
		else{
			String comm = ((JButton)event.getSource()).getActionCommand();
			if("SelectAll".equals(comm)){
				CheckBoxTreeNode node = (CheckBoxTreeNode) path.getLastPathComponent();
				selectAllNode(node,true);
				((DefaultTreeModel) zTreeCheckBox.getModel()).nodeStructureChanged(node);
			}else if("DeselectAll".equals(comm)){
				CheckBoxTreeNode node = (CheckBoxTreeNode) path.getLastPathComponent();
				selectAllNode(node,false);
				((DefaultTreeModel) zTreeCheckBox.getModel()).nodeStructureChanged(node);
			}
		}
//		
	}

	private void selectAllNode(CheckBoxTreeNode node,boolean select) {
		if (node != null) {
			node.setSelected(select);
			if(node.getChildCount() > 0 ){
				for (int i = 0; i < node.getChildCount(); i++) {
					CheckBoxTreeNode child = (CheckBoxTreeNode) node.getChildAt(i);
					selectAllNode(child,select);
				}
			}
			
		}
		
	}

}
