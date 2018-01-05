/**
 * 
 */
package jsi.nova.gui.frame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;

import javax.swing.JTree;

import jsi.nova.gui.panel.ProjectTreePanel;

/**
 * @ClassName:     FrameWindowListener.java
 * @Description:   窗口打开和关闭时的一些操作 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月12日 上午10:05:49 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class FrameWindowListener implements WindowListener {
    private JTree tree = ProjectTreePanel.getProject_tree();

    public FrameWindowListener() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        //projectPanel加载 tree并刷新
        ProjectTreePanel.getPanel().add(tree);
        ProjectTreePanel.getPanel().updateUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        //保存项目结构树
        try {
            try {
                saveProjectTree();
            } catch (URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    //保存项目树的配置文件
    public void saveProjectTree() throws URISyntaxException, FileNotFoundException {
        File configtree = new File(System.getProperty("user.dir")+File.separator+"config"+File.separator+"ProjectTree.con");
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(configtree)));
        tree.removeMouseListener(tree.getMouseListeners()[0]);
        tree.setSelectionPath(null);
        xmlEncoder.writeObject(ProjectTreePanel.getProject_tree());
        xmlEncoder.close();
    }
}
