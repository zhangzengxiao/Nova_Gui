/**
 * 
 */
package jsi.nova.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     ProjectPopMenu.java
 * @Description:   TODO(用一句话描述该文件做什么) 
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
        newGraph.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    addGraphTreeNode();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        this.add(newGraph);
        this.addSeparator();
        this.add(deleteProject);
    }

    public void addGraphTreeNode() throws IOException{
        GraphTreeNode graph = new GraphTreeNode("graph");
        String path = node.getProjectPath();
        File graphFile = new File(path, "graph.jg");
        graph.setGraphFile(graphFile.getAbsolutePath());
        try {
            graphFile.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        FileWriter fw = new FileWriter(graphFile);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<java version=\"1.8.0_144\" class=\"java.beans.XMLDecoder\">");
        sb.append("<array class=\"java.lang.Object\" length=\"0\"/>");
        sb.append("</java>");
        fw.write(sb.toString());
        fw.close();
        node.add(graph);
        ConstantsRepository.projectTree.updateUI();
    }
}
