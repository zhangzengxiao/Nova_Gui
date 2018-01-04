/**
 * 
 */
package jsi.nova.gui.projecttree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.gui.panel.ProjectTreePanel;
import jsi.nova.util.Constants;

/**
 * @ClassName:     ProjectPopMenuActions.java
 * @Description:   右键project弹出的菜单所对应的各种操作
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月13日 下午7:58:06 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectPopMenuActions {
    
    private static JTree tree = ProjectTreePanel.getProject_tree();
    
    public static class addGraphListener implements ActionListener {
        private ProjectTreeNode node;

        public addGraphListener(ProjectTreeNode node) {
            this.node = node;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                addGraphTreeNode(node);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static class deleteProjectListener implements ActionListener {
        private ProjectTreeNode node;

        public deleteProjectListener(ProjectTreeNode node) {
            this.node = node;
        }

        public void actionPerformed(ActionEvent e) {
            deleteProject(node);
        }
    }
    //新建一个GraphTreeNode和其对应的文件
    public static void addGraphTreeNode(ProjectTreeNode node) throws IOException {
        //新建GraphTreeNode
        GraphTreeNode graphnode = new GraphTreeNode("graph" + node.getGraphNumber());
        //设置GraphTreeNode对应的文件名并新建文件
        String path = node.getProjectPath();
        File graphFile = new File(path, "graph" + node.getGraphNumber() + ".jg");
        node.setGraphNumber(node.getGraphNumber() + 1);
        graphnode.setGraphFile(graphFile.getAbsolutePath());
        try {
            graphFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //给文件写入内容，新建一张空白图
        FileWriter fw = new FileWriter(graphFile);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<java version=\"1.8.0_144\" class=\"java.beans.XMLDecoder\">\n");
        sb.append(" <array class=\"java.lang.Object\" length=\"0\"/>\n");
        sb.append("</java>\n");
        fw.write(sb.toString());
        fw.close();
        node.add(graphnode);
        //刷新tree
        tree.updateUI();
    }
    //删除一个项目，并不从硬盘中删除
    public static void deleteProject(ProjectTreeNode node) {
        int resutlt = JOptionPane.showConfirmDialog(null, "确定删除该项目?");
        switch (resutlt) {
        case 0:
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
            root.remove(node);
            tree.updateUI();            
            break;
        default:
            break;

        }
    }

}
