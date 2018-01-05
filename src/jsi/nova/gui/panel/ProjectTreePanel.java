/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.GridLayout;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JPanel;
import javax.swing.JTree;

import jsi.nova.gui.frame.FrameResizeListener;
import jsi.nova.gui.projecttree.ProjectTreeMouseListener;

/**
 * @ClassName:     ProjectTreePanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         show the structures of project
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:53:58 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectTreePanel extends JPanel{
    private static ProjectTreePanel panel = new ProjectTreePanel();
    private static JTree project_tree;
    
    private ProjectTreePanel() {
        // TODO Auto-generated constructor stub
        this.setLayout(new GridLayout(1, 1));
    }

    public static JTree getProject_tree(){
        if(project_tree == null){
        String configpath = System.getProperty("user.dir")+File.separator+"config"+File.separator+"ProjectTree.con";
        XMLDecoder xmlDecoder;
        try {
            xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(configpath))));
            project_tree = (JTree) xmlDecoder.readObject();
            project_tree.addMouseListener(new ProjectTreeMouseListener());
            xmlDecoder.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }         
        }
        return project_tree;
    }

    public static ProjectTreePanel getPanel() {
        return panel;
    }
}
