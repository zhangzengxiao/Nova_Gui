/**
 * 
 */
package jsi.nova.gui.projecttree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.mxgraph.view.mxGraph;

import jsi.nova.util.Constants;

/**
 * @ClassName:     GraphPopMenuActions.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         GraphPopMenu 所对应的操作
 * @version        V1.0  
 * @Date           2017年12月13日 下午8:17:47 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphPopMenuActions {
    private static File tmp;
    private static File old;

    public static class OpenGraphListener implements ActionListener {
        private GraphTreeNode node;

        public OpenGraphListener(GraphTreeNode node) {
            // TODO Auto-generated constructor stub
            this.node = node;
        }

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                if (ifSaved()) {
                    openGraphFile(node);
                }
                ;
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static class SaveGraphListener implements ActionListener {
        private GraphTreeNode node;

        public SaveGraphListener(GraphTreeNode node) {
            // TODO Auto-generated constructor stub
            this.node = node;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                saveGraphFile();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
    public static class RunGraphListener implements ActionListener{
        private GraphTreeNode node;

        public RunGraphListener(GraphTreeNode node) {
            // TODO Auto-generated constructor stub
            this.node = node;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                saveGraphFile();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            RunWorkFlow.run(node);
            editMonitorArea();
        }
        
    }
    //打开文件
    public static void openGraphFile(GraphTreeNode node) throws FileNotFoundException {
        //IfChangedGraph graph = new IfChangedGraph();
        mxGraph graph = new mxGraph();
        File graphFile = new File(node.getGraphFile());
        //ConstantsRepository.OPENDGRAPH.put(graphFile.getAbsolutePath(), graph);
        //设置当前的文件和显示的图
        Constants.CURRENTWORKINGFILE = graphFile.getAbsolutePath();
        Constants.CURRENTWORKINGGRAPH = graph;
        //读取文件，新建graph
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(graphFile)));
        //System.out.println(xmlDecoder.readObject().toString());
        Object[] cells = (Object[]) xmlDecoder.readObject();
        for (Object cell : cells) {
            graph.addCell(cell);
        }
        xmlDecoder.close();
        //设置graphcomponent
        Constants.graphComponent.setVisible(true);
        Constants.graphComponent.setGridVisible(true);
        Constants.graphComponent.setGraph(graph);
        Constants.graphComponent.updateUI();
    }

    public static void saveGraphFile() throws FileNotFoundException {
        if (Constants.CURRENTWORKINGGRAPH != null && Constants.CURRENTWORKINGFILE != null) {
            XMLEncoder xmlEncoder = new XMLEncoder(
                    new BufferedOutputStream(new FileOutputStream(new File(Constants.CURRENTWORKINGFILE))));
            Object[] cells = Constants.graphComponent.getCells(Constants.graphComponent.getBounds());
            xmlEncoder.writeObject(cells);
            xmlEncoder.close();
            JOptionPane.showMessageDialog(null, "保存成功");
        }
    }

    //判断是否修改过
    public static Boolean graphChanged(String path, mxGraph graph) throws IOException {
        //新建临时文件
        tmp = new File(path + ".tmp");
        tmp.createNewFile();
        //把当前的图存到临时文件中
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(tmp)));
        Object[] cells = Constants.graphComponent.getCells(Constants.graphComponent.getBounds());
        xmlEncoder.writeObject(cells);
        xmlEncoder.close();
        old = new File(path);
        //分别读取旧文件和临时文件比较md5判断是否修改过
        FileInputStream oldfileInputStream = new FileInputStream(old);
        FileInputStream tmpfileInputStream = new FileInputStream(tmp);
        String oldFileMD5 = new String(Hex.encodeHex(DigestUtils.md5(oldfileInputStream)));
        String tmpFileMD5 = new String(Hex.encodeHex(DigestUtils.md5(tmpfileInputStream)));
        oldfileInputStream.close();
        tmpfileInputStream.close();
        if (oldFileMD5 == null || tmpFileMD5 == null) {
            return false;
        }
        return (!oldFileMD5.equals(tmpFileMD5));
    }

    // 得到是否保存
    public static Boolean ifSaved() throws IOException {
        //判断是否为空
        if (Constants.CURRENTWORKINGFILE != null && Constants.CURRENTWORKINGGRAPH != null) {
            //判断是否修改过。若修改过弹出对话框，没修改则删除临时文件
            if (graphChanged(Constants.CURRENTWORKINGFILE, Constants.CURRENTWORKINGGRAPH)) {
                int result = JOptionPane.showConfirmDialog(null, "是否保存当前工作流");
                //对选择的操作进行判断
                switch (result) {
                case 0:
                    //选择是，则删除旧文件，将临时文件重命名为原来旧文件的名字
                    old.delete();
                    tmp.renameTo(new File(tmp.getAbsolutePath().replaceAll(".tmp", "")));
                    return true;
                case 1:
                    tmp.delete();
                    return true;
                case 2:
                    return false;
                case -1:
                    return false;
                default:
                    break;
                }
            }
            if(tmp.exists()){
                tmp.delete();
            }
        }
        return true;
    }
    //给监控面板添加信息
    public static void editMonitorArea(){
        Constants.MONITORAREA.setText(" workflow is runing.");
        Constants.MONITORAREA.setText(" workflow is runing....");
    }
}
