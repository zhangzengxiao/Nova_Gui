/**
 * 
 */
package jsi.nova.gui.frame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JTree;

import jsi.nova.gui.panel.ProjectTreePanel;
import jsi.nova.gui.projecttree.ProjectTreeMouseListener;
import jsi.nova.util.Constants;

/**
 * @ClassName:     FrameWindowListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
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

    public void saveProjectTree() throws FileNotFoundException {
        File treeConfig = new File("./config/ProjectTree.con");
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(treeConfig)));
        Constants.projectTree.removeMouseListener(Constants.projectTree.getMouseListeners()[0]);
        Constants.projectTree.setSelectionPath(null);
        xmlEncoder.writeObject(Constants.projectTree);
        xmlEncoder.close();
    }

    public void openProjectTree() throws FileNotFoundException {
        File treeConfig = new File("./config/ProjectTree.con");
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(treeConfig)));
        Constants.projectTree = (JTree) xmlDecoder.readObject();
        Constants.projectTree.addMouseListener(new ProjectTreeMouseListener());
        xmlDecoder.close();
    }

}
