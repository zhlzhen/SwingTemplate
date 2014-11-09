package baseui.list;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.border.Border;

import util.ImageManager;

public class XBRLListCellRenderer extends DefaultListCellRenderer{

	private static final long serialVersionUID = 4171795369869583663L;
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			this.setIcon(ImageManager.getImageIconByShortName("5.png"));
			this.setBackground(list.getSelectionBackground());
			this.setForeground(list.getSelectionForeground());
		}
		else {
			this.setIcon(ImageManager.getImageIconByShortName("50.png"));
			this.setBackground(list.getBackground());
			this.setForeground(list.getForeground());
		}

		this.setText(value == null ? "" : value.toString());

		this.setEnabled(list.isEnabled());
		this.setFont(list.getFont());

		this.setBorder(this.emptyBorder);

		return this;
	}

}
