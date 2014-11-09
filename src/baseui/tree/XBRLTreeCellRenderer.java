package baseui.tree;

import javax.swing.Icon;
import javax.swing.tree.DefaultTreeCellRenderer;

import util.ImageManager;

public class XBRLTreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 6954191854582692051L;

	@Override
	 public Icon getLeafIcon() {
		return ImageManager.getImageIconByShortName("69.PNG");
	}
	
	 public Icon getDefaultClosedIcon() {
		 return ImageManager.getImageIconByShortName("69.PNG");
	 }
	 
	 public Icon getDefaultLeafIcon() {
		 return ImageManager.getImageIconByShortName("69.PNG");
	 }
}
