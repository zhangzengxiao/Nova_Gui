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
import java.io.IOException;

import javax.swing.JTree;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.python.antlr.PythonParser.return_stmt_return;

import com.mxgraph.view.mxGraph;

import jsi.nova.gui.listener.ProjectTreeMouseListener;
import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     FrameWindowListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月12日 上午10:05:49 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class FrameWindowListener implements WindowListener {

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
     */
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        try {
            openProjectTree();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ConstantsRepository.mainFrame.getMainSplitPanel().getProjectTreePanel().add(ConstantsRepository.projectTree);
        ConstantsRepository.mainFrame.getMainSplitPanel().getProjectTreePanel().updateUI();
    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        //判断图是否改变过
        try {
            if(ConstantsRepository.CURRENTWORKINGFILE!=null && ConstantsRepository.CURRENTWORKINGGRAPH!=null){
            graphChanged(ConstantsRepository.CURRENTWORKINGFILE, ConstantsRepository.CURRENTWORKINGGRAPH);
            }
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        //保存项目结构树
        try {
            saveProjectTree();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
     */
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
     */
    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
     */
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
     */
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    public void saveProjectTree() throws FileNotFoundException {
        File treeConfig = new File("./config/ProjectTree.con");
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(treeConfig)));
        ConstantsRepository.projectTree.removeMouseListener(ConstantsRepository.projectTree.getMouseListeners()[0]);
        ConstantsRepository.projectTree.setSelectionPath(null);
        xmlEncoder.writeObject(ConstantsRepository.projectTree);
        xmlEncoder.close();
    }

    public void openProjectTree() throws FileNotFoundException {
        File treeConfig = new File("./config/ProjectTree.con");
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(treeConfig)));
        ConstantsRepository.projectTree = (JTree) xmlDecoder.readObject();
        ConstantsRepository.projectTree.addMouseListener(new ProjectTreeMouseListener());
        xmlDecoder.close();
    }

    public Boolean graphChanged(String path, mxGraph graph) throws IOException {
        File tmp = new File(path + ".tmp");
        tmp.createNewFile();
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(tmp)));
        Object[] cells = ConstantsRepository.graphComponent.getCells(ConstantsRepository.graphComponent.getBounds());
        xmlEncoder.writeObject(cells);
        xmlEncoder.close();
        File old = new File(path);
        String oldFileMD5 = new String(Hex.encodeHex(DigestUtils.md5(new FileInputStream(old))));
        String tmpFileMD5 = new String(Hex.encodeHex(DigestUtils.md5(new FileInputStream(tmp))));
        System.out.println(oldFileMD5);
        System.out.println(tmpFileMD5);
        if (oldFileMD5 == null || tmpFileMD5 == null) {
            return false;
        }
        return (!oldFileMD5.equals(tmpFileMD5));

    }

}
