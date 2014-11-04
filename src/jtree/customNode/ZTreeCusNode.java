package jtree.customNode;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import util.ImageManager;
import jtree.checkBoxTree.CheckBoxTreeNodeListender;

public class ZTreeCusNode extends JTree {

	private static final long serialVersionUID = -581164150235777786L;
	private static final String ROOT_NAME = "ÎÒµÄµçÄÔ";
	private static final int levelUp = 3;
	
	 public ZTreeCusNode() {
		this.setModel(new DefaultTreeModel(createRootNode()));
		this.setCellRenderer(new CusNodeTreeCellRender());
		this.addCheckSelectListender();
	}

	 private void addCheckSelectListender() {
		 this.addMouseListener(new CheckBoxTreeNodeListender(this));
	}

	public  CusTreeNode createRootNode(){ 
		CusTreeNode treeNode = null;
		CusTreeNode rootNode = new CusTreeNode(ROOT_NAME,ImageManager.getImageIconByShortName("home.png")); 
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

	private CusTreeNode creatDefaultMutableTreeNode(String nodePath,int level) {
		CusTreeNode node = null;
		if(level == 0){
			node = new CusTreeNode(nodePath,ImageManager.getImageIconByShortName("pan.png"));
		}else if(level == 1){
			node = new CusTreeNode(nodePath,ImageManager.getImageIconByShortName("ff.png"));
		}else{
			node = new CusTreeNode(nodePath);
		}
		CusTreeNode treeNode = null;
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
