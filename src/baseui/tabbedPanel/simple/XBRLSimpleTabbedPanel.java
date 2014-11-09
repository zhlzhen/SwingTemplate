package baseui.tabbedPanel.simple;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;

import mainpage.table.InstanceTablePanel;

import baseui.tabbedPanel.DimensionTablePanel;

public class XBRLSimpleTabbedPanel extends JTabbedPane {

	private static final long serialVersionUID = 3832738892903616055L;
	
	private InstanceTablePanel instanceTablepanel = null;
	
	private DimensionTablePanel  dimensionTablePanel = null;
	
	public XBRLSimpleTabbedPanel(){
		if(instanceTablepanel == null){
			instanceTablepanel = new InstanceTablePanel();
		}
		
		if(dimensionTablePanel == null){
			dimensionTablePanel = new DimensionTablePanel();
		}
		
		add("展示表",instanceTablepanel);
		setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		add("维度表" ,dimensionTablePanel);
		setTabComponentAt(0, new ButtonTabSimpleComponent(this));
		setTabComponentAt(1, new ButtonTabSimpleComponent(this));
	}

	public void addTabbedPanel(String roleType, DefaultMutableTreeNode node) {
		// 展示这张表
		System.out.println("展示这张表：" + roleType);
		this.instanceTablepanel.addInstanceTable(roleType,node);
		
		
	}

}
