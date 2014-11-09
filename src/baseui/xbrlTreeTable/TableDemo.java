package baseui.xbrlTreeTable;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

 
public class TableDemo extends JFrame{
 
    
	private static final long serialVersionUID = 2526321311426507307L;
	String[] header = new String[] {"name", "age", "country", "home", "telephone"};
    String[][] content = new String[][]{{"name1","18","China", "shangHai", "111"}, 
    		{"name1","18","China", "shangHai", "111"}};
     
    public TableDemo() {
        super("test");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
         
        DefaultTableModel dm = new DefaultTableModel(content, header);
 
        XBRLTable table = new XBRLTable(dm);
        
        //建立组的概念
        TableColumnModel cm = table.getColumnModel();
        ColumnGroup uplevel = new ColumnGroup("context");
        
        ColumnGroup g_name0 = new ColumnGroup(" ");
        g_name0.add(cm.getColumn(0));
        
        ColumnGroup g_name = new ColumnGroup("Source");
        g_name.add(cm.getColumn(1));
        g_name.add(cm.getColumn(2));
        
        ColumnGroup g_name2 = new ColumnGroup("Target");
        g_name2.add(cm.getColumn(3));
        g_name2.add(cm.getColumn(4));
        
        uplevel.add (g_name0);
        uplevel.add (g_name);
        uplevel.add (g_name2);
        
        //自定义表头
        XBRLGroupTableHeader header = (XBRLGroupTableHeader) table.getTableHeader();
        header.addColumnGroup(uplevel);
        table.getTableHeader().setUI(new XBRLTableHeaderUI());
         
        JScrollPane panel = new JScrollPane(table);
        getContentPane().add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        TableDemo demo = new TableDemo();
        demo.setVisible(true);
    }
}