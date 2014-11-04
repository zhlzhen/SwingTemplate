package jtree;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ZJtree extends JTree {

	private static final long serialVersionUID = -581164150235777786L;
	private static final String ROOT_NAME = "ÎÒµÄµçÄÔ";
	private static final int levelUp = 3;
	
	 public ZJtree() {
		this.setModel(new DefaultTreeModel(createRootNode()));
	}

	 public  DefaultMutableTreeNode createRootNode(){ 
	      DefaultMutableTreeNode treeNode = null;
	      DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(ROOT_NAME); 
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

	private DefaultMutableTreeNode creatDefaultMutableTreeNode(String nodePath,int level) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodePath);
		DefaultMutableTreeNode treeNode = null;
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
