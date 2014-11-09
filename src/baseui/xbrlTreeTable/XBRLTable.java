package baseui.xbrlTreeTable;

import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import uap.xbrl.xpeimpl.dimension.dimensionByDts.MemberItem;

public class XBRLTable extends JTable{

	private static final long serialVersionUID = 6465045666499848577L;
	
	public XBRLTable(DefaultTableModel dm) {
		super(dm);
	}
	
	//根据RoleType下的数据结构，来构建这张表
	public XBRLTable(String roleType, DefaultMutableTreeNode node) {
		XBRLTableModel model = new XBRLTableModel(roleType,node);
	}

	//重写table的表头
	@Override
    protected XBRLGroupTableHeader createDefaultTableHeader() {
        return new XBRLGroupTableHeader(columnModel);
    }

}
