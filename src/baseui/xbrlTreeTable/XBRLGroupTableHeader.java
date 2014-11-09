package baseui.xbrlTreeTable;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


//表头的样式
public class XBRLGroupTableHeader extends JTableHeader {

	
	private static final long serialVersionUID = -4264562203906196418L;

	 protected Vector<ColumnGroup> columnGroups = null;
	 
	public XBRLGroupTableHeader(TableColumnModel columnModel) {
		    super(columnModel);
	        setUI(new XBRLTableHeaderUI());
	        setReorderingAllowed(false);
	}


	public void addColumnGroup(ColumnGroup group) {
		if (columnGroups == null) {
	          columnGroups = new Vector<ColumnGroup>();
	        }
	        columnGroups.addElement(group);
	}


	public void setColumnMargin() {
		if (columnGroups == null) return;
        int columnMargin = getColumnModel().getColumnMargin();
        Enumeration<ColumnGroup> enumeration = columnGroups.elements();
        while (enumeration.hasMoreElements()) {
          ColumnGroup cGroup = (ColumnGroup)enumeration.nextElement();
          cGroup.setColumnMargin(columnMargin);
        }
		
	}


	//根据某列的数据，确定该列所在哪一组中
	public Enumeration<ColumnGroup> getColumnGroups(TableColumn tableColumn) {
		 if (columnGroups == null){
			 return null;
		 }
	     Enumeration<ColumnGroup> enumeration = columnGroups.elements();
	     while (enumeration.hasMoreElements()) {
	    	 ColumnGroup cGroup = (ColumnGroup)enumeration.nextElement();
	    	 Vector<ColumnGroup> v_ret = (Vector<ColumnGroup>)cGroup.getColumnGroups(tableColumn,new Vector<ColumnGroup>());
	    	 if (v_ret != null) {
		            return v_ret.elements();
		      }
	     }
		return null;
	}

}
