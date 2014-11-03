package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

class DTableModel extends AbstractTableModel{
	private List<CellData>[] listData;
	private int column;
	public DTableModel(List<CellData>[] listData,int column){
		this.listData=listData;
		this.column=column;
	}
	public int getColumnCount() {		
		return column;
	}

	public int getRowCount() {
		return listData.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		CellData cellData=listData[rowIndex].get(columnIndex);
		return cellData==null?null:cellData.getValue();
	}
}
