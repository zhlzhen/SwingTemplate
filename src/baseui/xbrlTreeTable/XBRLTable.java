package baseui.xbrlTreeTable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class XBRLTable extends JTable{

	private static final long serialVersionUID = 6465045666499848577L;
	
	public XBRLTable(DefaultTableModel dm) {
		super(dm);
	}
	
	//鏍规嵁RoleType涓嬬殑鏁版嵁缁撴瀯锛屾潵鏋勫缓杩欏紶琛�
	public XBRLTable(String roleType, DefaultMutableTreeNode node) {
		XBRLTableModel model = new XBRLTableModel(roleType,node);
	}

	//閲嶅啓table鐨勮〃澶�
	@Override
    protected XBRLGroupTableHeader createDefaultTableHeader() {
        return new XBRLGroupTableHeader(columnModel);
    }

}
