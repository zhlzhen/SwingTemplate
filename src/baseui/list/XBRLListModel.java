package baseui.list;

import java.util.Vector;

import javax.swing.DefaultListModel;

public class XBRLListModel extends DefaultListModel{

	private static final long serialVersionUID = -5199573149613895706L;

	private Vector<Object> dataVector = null;

	public XBRLListModel() {
		this.dataVector = new Vector<Object>();
	}

	public void setData(Vector<? extends Object> dataVector) {
		this.getDataVector().clear();
		if (dataVector == null || dataVector.size() == 0) {
			return;
		}
		for (Object data : dataVector) {
			this.getDataVector().add(data);
		}
	}

	public void setData(Object[] datas) {
		this.getDataVector().clear();
		if (datas == null || datas.length == 0) {
			return;
		}
		for (Object data : datas) {
			this.getDataVector().add(data);
		}
	}

	public void addData(Object data) {
		this.getDataVector().add(data);
	}

	public void removeData(int index) {
		if (index < 0 || index >= this.getSize()) {
			throw new IllegalArgumentException();
		}
		this.getDataVector().remove(index);
	}

	@Override
	public int getSize() {
		return this.getDataVector().size();
	}

	@Override
	public Object getElementAt(int index) {
		if (index >= this.getSize()) {
			throw new IndexOutOfBoundsException();
		}
		return this.getDataVector().elementAt(index);
	}

	private Vector<Object> getDataVector() {
		return this.dataVector;
	}
}

