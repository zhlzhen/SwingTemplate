/**
 * 
 */
package jtree.customNodeResource;

/**
 * @author zha
 *
 */
public class FileTreeNode extends LazyMutableTreeNode {

	
	private static final long serialVersionUID = 6747134617526252722L;

	@Override
	protected void loadChildren() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLeaf() {

		if (!isLoaded()) {
			return false;

		} else {
			return super.isLeaf();
		}

	}

	private boolean isLoaded() {
		return false;
	}

}
