/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import jsi.nova.gui.listener.ProjectTreeMouseListener;
import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     ProjectTreePanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         show the structures of project
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:53:58 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectTreePanel extends JPanel{

    public ProjectTreePanel() {
        // TODO Auto-generated constructor stub
        this.setLayout(new GridLayout(1, 1));
//        DefaultMutableTreeNode top = new DefaultMutableTreeNode("项目总览");
//        DefaultMutableTreeNode project1 = new DefaultMutableTreeNode("project1");
//        DefaultMutableTreeNode project2 = new DefaultMutableTreeNode("project2");
//        project1.add(new DefaultMutableTreeNode("graph1"));
//        project1.add(new DefaultMutableTreeNode("graph2"));
//        project2.add(new DefaultMutableTreeNode("graph3"));
//        project2.add(new DefaultMutableTreeNode("graph4"));
//        top.add(new DefaultMutableTreeNode("test"));
//        top.add(project1);
//        top.add(project2);
//        JTree j = ConstantsRepository.projectTree;
//        JTree j = new JTree(top);

//        ConstantsRepository.projectTree = j;
//        j.expandRow(0);
//        j.addMouseListener(new ProjectTreeMouseListener());
//        this.add(j);
    }

}
