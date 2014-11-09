package baseui.xbrlTreeTable;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
  * 组这个概念，对应一个数据结构
  */

public class ColumnGroup {
  
	//这个是合并的JTableHeader的Renderer,这里我们简单化,我们就不像前面写Renderer和Editor那样分开存储了,
  //我们假设这个JTableHeader使用同一类的Renderer,如果你想实现不一样的Renderer,你可以把它们定义成数组(PS:这样效果会比较怪异,一个合并的单元格包含了几个组件)
  protected TableCellRenderer renderer;
  //包含的列：这个是合并的单元格的各个实际的最小单元格存储结构.
  protected Vector<Object> group;
  //展现的字符串：这个是合并后单元格显示的文本信息
  protected String text;
  //空隙 ：这个是合并的单元格内部两个最小JTableHeader的间隙,其实就是去掉线后那个Border.
  protected int margin=10;

  public ColumnGroup(String text) {
        this(null,text);
  }

  public ColumnGroup(TableCellRenderer renderer,String text) {
        if (renderer == null) {
        	//默认的cellReader
          this.renderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value,
                             boolean isSelected, boolean hasFocus, int row, int column) {
              JTableHeader header = table.getTableHeader();
              if (header != null) {
                setForeground(header.getForeground());
                setBackground(header.getBackground());
                setFont(header.getFont());
              }
              setHorizontalAlignment(JLabel.CENTER);
              setText((value == null) ? "" : value.toString());
              setBorder(UIManager.getBorder("TableHeader.cellBorder"));
              return this;
            }
          };
        } else {
          this.renderer = renderer;
        }
        this.text = text;
        group = new Vector<Object>();
  }


  /**
   * 增加一列
   */
  public void add(Object obj) {
        if (obj == null) { return; }
        group.addElement(obj);
  }


  /**
   * @param c    TableColumn
   * @param group    ColumnGroups
   * 确定c 是否在这个 group 中，
   */
  public Vector<ColumnGroup> getColumnGroups(TableColumn c, Vector<ColumnGroup> g) {
        g.addElement(this);
        if (group.contains(c)) return g;
        Enumeration<Object> enumeration = group.elements();
        while (enumeration.hasMoreElements()) {
          Object obj = enumeration.nextElement();
          if (obj instanceof ColumnGroup) {
            Vector<ColumnGroup> groups =
              (Vector<ColumnGroup>)((ColumnGroup)obj).getColumnGroups(c,(Vector<ColumnGroup>)g.clone());
            if (groups != null) return groups;
          }
        }
        return null;
  }

  public TableCellRenderer getHeaderRenderer() {
        return renderer;
  }

  public void setHeaderRenderer(TableCellRenderer renderer) {
        if (renderer != null) {
          this.renderer = renderer;
        }
  }

  public Object getHeaderValue() {
        return text;
  }

  //取得合并后单元格的大小
  public Dimension getSize(JTable table) {
	  //首先是取得一个没有合并的最小单元格的JTableHeader的大小,通过Renderer取得组件:
        Component comp = renderer.getTableCellRendererComponent(
            table, getHeaderValue(), false, false,-1, -1);
        int height = comp.getPreferredSize().height;
        int width  = 0;
        Enumeration<Object> enumeration = group.elements();
        while (enumeration.hasMoreElements()) {
          Object obj = enumeration.nextElement();
          if (obj instanceof TableColumn) {
            TableColumn aColumn = (TableColumn)obj;
            width += aColumn.getWidth();
            width += margin;
          } else {
            width += ((ColumnGroup)obj).getSize(table).width;
          }
        }
        return new Dimension(width, height);
  }

  public void setColumnMargin(int margin) {
        this.margin = margin;
        Enumeration<Object> enumeration = group.elements();
        while (enumeration.hasMoreElements()) {
          Object obj = enumeration.nextElement();
          if (obj instanceof ColumnGroup) {
            ((ColumnGroup)obj).setColumnMargin(margin);
          }
        }
  }


}