/**
 * 
 */
package jsi.nova.gui.frame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImageFilter;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

import javax.swing.JTree;

import jsi.nova.gui.panel.ProjectTreePanel;
import jsi.nova.gui.projecttree.ProjectTreeMouseListener;
import jsi.nova.util.Constants;

/**
 * @ClassName:     FrameWindowListener.java
 * @Description:   窗口打开和关闭时的一些操作 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月12日 上午10:05:49 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class FrameWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        try {
            openProjectTree();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ProjectTreePanel.getPanel().add(Constants.projectTree);
        ProjectTreePanel.getPanel().updateUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        //判断图是否改变过
        //保存项目结构树
        try {
            saveProjectTree();
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
    public void saveProjectTree() throws FileNotFoundException {
        File treeconfig = new File(this.getClass().getResource("/config/ProjectTree.con").getFile());
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(treeconfig)));
        Constants.projectTree.removeMouseListener(Constants.projectTree.getMouseListeners()[0]);
        Constants.projectTree.setSelectionPath(null);
        xmlEncoder.writeObject(Constants.projectTree);
        xmlEncoder.close();
    }
    //打开项目树的配置文件
    public void openProjectTree() throws FileNotFoundException {
        BufferedInputStream inputStream = (BufferedInputStream) this.getClass().getResourceAsStream("/config/ProjectTree.con");
        //System.out.println(treeConfig.getAbsolutePath());
        XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
        Constants.projectTree = (JTree) xmlDecoder.readObject();
        Constants.projectTree.addMouseListener(new ProjectTreeMouseListener());
        xmlDecoder.close();
    }

}
