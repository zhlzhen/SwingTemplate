package baseui.list;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;


public class XBRLList extends JList implements KeyListener {

	private static final long serialVersionUID = 2782294650740300968L;

	/** 在JScrollPane中设定大小，当数据发生改变时List大小默认值. */
	private int minWidth = -1;

	public XBRLList() {
		super(new XBRLListModel());
		this.setCellRenderer(new XBRLListCellRenderer());
		this.setUI(new XBRLListUI());
		this.addKeyListener(this);
	}


	@Override
	public void setListData(final Object[] listData) {
		this.getModel().setData(listData);
		this.clearSelection();
		this.repaint();
	}

	//zhailzh+ 为了支持JDK1.7 <Vector(?)> ---> Vector
	public void setListData(final Vector listData) {
		this.getModel().setData(listData);
		this.clearSelection();
		this.repaint();
	}
	
	public void addData(Object data) {
		if (data == null) {
			return;
		}
		int size = this.getModel().getSize();
		this.getModel().addData(data);
		this.setSelectedIndex(size);
		this.repaint();
		this.revalidate();
	}

	public void removeData(int index) {
		this.getModel().removeData(index);
		this.repaint();
		int curIndex = index - 1 == 0 ? 0 : index - 1;
		this.setSelectedIndex(curIndex);
		this.repaint();
		this.revalidate();
	}

	@Override
	public XBRLListModel getModel() {
		return (XBRLListModel) super.getModel();
	}

	@Override
	public void updateUI() {
		this.setUI(new XBRLListUI());
	}

	@Override
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		Dimension preferredSize = super.getPreferredScrollableViewportSize();
		if (this.getMinWidth() != -1) {
			preferredSize.width = this.getMinWidth();
		}
		return preferredSize;
	}

	public int getMinWidth() {
		return this.minWidth;
	}

	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	private class XBRLListUI extends BasicListUI {

		@Override
		public void paint(Graphics g, JComponent c) {
			this.updateLayoutState();
			super.paint(g, c);
		}

		@Override
		protected void installDefaults() {
			super.installDefaults();
			this.list.setSelectionBackground(new Color(0xf9e2d0));
		}

		@Override
		protected void paintCell(Graphics g, int row, Rectangle rowBounds, ListCellRenderer cellRenderer,
				ListModel dataModel, ListSelectionModel selModel, int leadIndex) {
			rowBounds.x = 5;
			super.paintCell(g, row, rowBounds, cellRenderer, dataModel, selModel, leadIndex);
		}

		@Override
		protected void maybeUpdateLayoutState() {
			this.updateLayoutState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyChar();
		int selectedIndex = this.getSelectedIndex();
		int itemCount = this.getModel().getSize();

		if (keyCode == KeyEvent.VK_ENTER) {
			selectedIndex = selectedIndex < 0 ? 0 : selectedIndex == itemCount - 1 ? 0 : selectedIndex + 1;
			this.setSelectedIndex(selectedIndex);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("dianji");
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
