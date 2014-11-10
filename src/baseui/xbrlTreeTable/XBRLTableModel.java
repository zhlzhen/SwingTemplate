package baseui.xbrlTreeTable;

import java.util.Enumeration;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import baseui.tree.MemberItem;

public class XBRLTableModel extends  DefaultTableModel {

	private static final long serialVersionUID = 4736162221982824336L;

	public XBRLTableModel(String roleType, DefaultMutableTreeNode node) {
		int rowNum = getRowCount(node);
	}

	//求得树下的节点的数量
	private int getRowCount(DefaultMutableTreeNode node) {
		int number  = 0;
		if(node.getUserObject() instanceof MemberItem){
			if(node.getChildCount() > 0 ){
				Enumeration<?> children = node.children();
				while (children.hasMoreElements()) {
					DefaultMutableTreeNode object = (DefaultMutableTreeNode) children.nextElement();
					return 1 + getRowCount(object);
					
				}
			}
		}else if(node.getUserObject() instanceof String && node.getChildCount() > 0){
			Enumeration<?> children = node.children();
			while (children.hasMoreElements()) {
				DefaultMutableTreeNode object = (DefaultMutableTreeNode) children.nextElement();
				return number + getRowCount(object);
				
			}
		}
		return number;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
}
