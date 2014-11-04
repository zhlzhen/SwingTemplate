package jtree.checkBoxTree;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

public class ZTreeCheckBox extends JTree {

	private static final long serialVersionUID = -581164150235777786L;
	private static final String ROOT_NAME = "ÎÒµÄµçÄÔ";
	private static final int levelUp = 3;
	
	 public ZTreeCheckBox() {
		this.setModel(new DefaultTreeModel(createRootNode()));
		this.setCellRenderer(new ChectBoxTreeCellRender());
		this.addCheckSelectListender();
	}

	 private void addCheckSelectListender() {
		 this.addMouseListener(new CheckBoxTreeNodeListender(this));
	}

	public  CheckBoxTreeNode createRootNode(){ 
		 CheckBoxTreeNode treeNode = null;
		 CheckBoxTreeNode rootNode = new CheckBoxTreeNode(ROOT_NAME); 
	      for(int i = 0; i < File.listRoots().length ; i++){ 
	          if(File.listRoots()[i].isDirectory()){ 
	              String rootPath = File.listRoots()[i].getPath(); 
	              treeNode  = creatDefaultMutableTreeNode(rootPath,0); 
	              rootNode.add(treeNode); 
	              treeNode = null;
	          } 
	      } 

	        return rootNode; 
	    }

	private CheckBoxTreeNode creatDefaultMutableTreeNode(String nodePath,int level) {
		CheckBoxTreeNode node = new CheckBoxTreeNode(nodePath);
		CheckBoxTreeNode treeNode = null;
		level = level+1;
		File file = new File(nodePath);
		if(file.isDirectory() && file.listFiles() != null){
			 for(int i = 0; i < file.listFiles().length && level < levelUp; i++){ 
		          if(file.listFiles()[i].isDirectory()){ 
		              String rootPath = file.listFiles()[i].getPath();
		              treeNode  = creatDefaultMutableTreeNode(rootPath,level); 
		              node.add(treeNode); 
		              treeNode = null; 
		          } 
		      }
		}
		 
		return node;
	}
}
