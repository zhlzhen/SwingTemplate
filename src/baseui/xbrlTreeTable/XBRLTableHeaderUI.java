package baseui.xbrlTreeTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class XBRLTableHeaderUI extends BasicTableHeaderUI {
	//重绘表头
	public void paint(Graphics g, JComponent c) {
//		首先取得旧的绘制边框:
        Rectangle oldclipBounds = g.getClipBounds();
        if (header.getColumnModel() == null) 
        	return;
        ((XBRLGroupTableHeader)header).setColumnMargin();
        int column = 0;
        Dimension size = header.getSize();
        Rectangle cellRect  = new Rectangle(0, 0, size.width, size.height);
        Hashtable<ColumnGroup, Rectangle> h = new Hashtable<ColumnGroup, Rectangle>();
        Enumeration<?> enumeration = header.getColumnModel().getColumns();
        while (enumeration.hasMoreElements()) {
          cellRect.height = size.height;
          cellRect.y   = 0;
          TableColumn aColumn = (TableColumn)enumeration.nextElement();
          Enumeration<?> cGroups = ((XBRLGroupTableHeader)header).getColumnGroups(aColumn);
          if (cGroups != null) {
            int groupHeight = 0;
            while (cGroups.hasMoreElements()) {
              ColumnGroup cGroup = (ColumnGroup)cGroups.nextElement();
              Rectangle groupRect = (Rectangle)h.get(cGroup);
              if (groupRect == null) {
                groupRect = new Rectangle(cellRect);
                Dimension d = cGroup.getSize(header.getTable());
                groupRect.width  = d.width;
                groupRect.height = d.height;
                h.put(cGroup, groupRect);
              }
              paintCell(g, groupRect, cGroup);
              groupHeight += groupRect.height;
              cellRect.height = size.height - groupHeight;
              cellRect.y      = groupHeight;
            }
          }
          cellRect.width = aColumn.getWidth();// + columnMargin;
          if (cellRect.intersects(oldclipBounds)) {
            paintCell(g, cellRect, column);
          }
          cellRect.x += cellRect.width;
          column++;
        }
  }

  private void paintCell(Graphics g, Rectangle cellRect, int columnIndex) {
        TableColumn aColumn = header.getColumnModel().getColumn(columnIndex);
        TableCellRenderer renderer = header.getDefaultRenderer();
        Component component = renderer.getTableCellRendererComponent(
          header.getTable(), aColumn.getHeaderValue(),false, false, -1, columnIndex);
        rendererPane.add(component);
            rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y,
                                    cellRect.width, cellRect.height, true);
  }

  private void paintCell(Graphics g, Rectangle cellRect,ColumnGroup cGroup) {
        TableCellRenderer renderer = cGroup.getHeaderRenderer();
        Component component = renderer.getTableCellRendererComponent(
          header.getTable(), cGroup.getHeaderValue(),false, false, -1, -1);
        rendererPane.add(component);
        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y,
                                    cellRect.width, cellRect.height, true);
  }

  //计算表头的高度，这个涉及到表头的层次
  private int getHeaderHeight() {
        int height = 0;
        TableColumnModel columnModel = header.getColumnModel();
        //首先得到每一行所对应的表头的高度
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
          TableColumn aColumn = columnModel.getColumn(column);
          //每一行的默认的高度
          TableCellRenderer renderer = header.getDefaultRenderer();
          Component comp = renderer.getTableCellRendererComponent(
              header.getTable(), aColumn.getHeaderValue(), false, false, -1,
              column);
          int cHeight = comp.getPreferredSize().height;
          //得到每一列所在组，并且计算表头的高度
          Enumeration<?> enumeration = ( (XBRLGroupTableHeader) header).getColumnGroups(
              aColumn);
          if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
              ColumnGroup cGroup = (ColumnGroup) enumeration.nextElement();
              cHeight += cGroup.getSize(header.getTable()).height;
            }
          }
          height = Math.max(height, cHeight);
        }
        return height;
  }


  private Dimension createHeaderSize(long width) {
        TableColumnModel columnModel = header.getColumnModel();
        //计算宽度的时候加上了间隙的值
        width += columnModel.getColumnMargin() * columnModel.getColumnCount();
        if (width > Integer.MAX_VALUE) {
          width = Integer.MAX_VALUE;
        }
        return new Dimension((int)width, getHeaderHeight());
  }

  
  // 返回表头的首选大小，首先大小的高度是表头中含有的组件的高度，宽度是所有的列的和
  public Dimension getPreferredSize(JComponent c) {
        long width = 0;
        //宽度比较的好计算，循环所有的列，相加即可
        Enumeration<?> enumeration = header.getColumnModel().getColumns();
        while (enumeration.hasMoreElements()) {
          TableColumn aColumn = (TableColumn)enumeration.nextElement();
          width = width + aColumn.getPreferredWidth() ;
        }
        return createHeaderSize(width);
  }
}

