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
import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.util.Constants;

/**
 * @ClassName:     ProjectPopMenuActions.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月13日 下午7:58:06 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectPopMenuActions {

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

    public static void addGraphTreeNode(ProjectTreeNode node) throws IOException {
        GraphTreeNode graphnode = new GraphTreeNode("graph" + node.getGraphNumber());
        String path = node.getProjectPath();
        File graphFile = new File(path, "graph" + node.getGraphNumber() + ".jg");
        node.setGraphNumber(node.getGraphNumber() + 1);
        graphnode.setGraphFile(graphFile.getAbsolutePath());
        try {
            graphFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw = new FileWriter(graphFile);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<java version=\"1.8.0_144\" class=\"java.beans.XMLDecoder\">\n");
        sb.append(" <array class=\"java.lang.Object\" length=\"0\"/>\n");
        sb.append("</java>\n");
        fw.write(sb.toString());
        fw.close();
        node.add(graphnode);
        Constants.projectTree.updateUI();
    }

    public static void deleteProject(ProjectTreeNode node) {
        int resutlt = JOptionPane.showConfirmDialog(null, "确定删除该项目?");
        switch (resutlt) {
        case 0:
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) Constants.projectTree.getModel().getRoot();
            root.remove(node);
            Constants.projectTree.updateUI();            
            break;
        default:
            break;

        }
    }

}
