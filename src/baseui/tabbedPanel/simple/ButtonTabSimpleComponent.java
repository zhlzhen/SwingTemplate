package baseui.tabbedPanel.simple;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ButtonTabSimpleComponent  extends JPanel {
	private static final long serialVersionUID = 1L;
	public ButtonTabSimpleComponent(final JTabbedPane pane) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		if (pane == null) {
			throw new NullPointerException("TabbedPane is null");
		}
		setOpaque(false);

		// make JLabel read titles from JTabbedPane
		JLabel label = new JLabel() {
			private static final long serialVersionUID = 1L;

			public String getText() {
				int i = pane.indexOfTabComponent(ButtonTabSimpleComponent.this);
				if (i != -1) {
					return pane.getTitleAt(i);
				}
				return null;
			}
		};
		label.setBackground(Color.white);
		add(label);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
	}
}
