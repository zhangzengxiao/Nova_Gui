/**
 * 
 */
package jsi.nova.gui.projecttree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.util.Constants;

/**
 * @ClassName:     ProjectPopMenu.java
 * @Description:   右键project弹出的菜单 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月8日 下午3:24:11 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectPopMenu extends JPopupMenu{
    
    private JMenuItem newGraph;
    private JMenuItem deleteProject;
    private ProjectTreeNode node;

    public ProjectPopMenu(ProjectTreeNode node) {
        // TODO Auto-generated constructor stub
        this.node = node;
        newGraph = new JMenuItem("新建流程图");
        deleteProject = new JMenuItem("删除项目");
        //
        newGraph.addActionListener(new ProjectPopMenuActions.addGraphListener(node));
        //
        deleteProject.addActionListener(new ProjectPopMenuActions.deleteProjectListener(node));
        //
        this.add(newGraph);
        this.addSeparator();
        this.add(deleteProject);
    }
}
