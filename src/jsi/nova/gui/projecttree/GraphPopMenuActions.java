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

import com.mxgraph.view.mxGraph;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     GraphPopMenuActions.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月13日 下午8:17:47 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphPopMenuActions {
    public static class openGraphListener implements ActionListener{
        private GraphTreeNode node;

        public openGraphListener(GraphTreeNode node) {
            // TODO Auto-generated constructor stub
            this.node = node;
        }
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                openGraphFile(node);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    public static class saveGraphListener implements ActionListener{
        private GraphTreeNode node;
        
        public saveGraphListener(GraphTreeNode node) {
            // TODO Auto-generated constructor stub
            this.node = node;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                saveGraphFile(node);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    public static void openGraphFile(GraphTreeNode node) throws FileNotFoundException{
        //IfChangedGraph graph = new IfChangedGraph();
        mxGraph graph = new mxGraph();
        File graphFile = new File(node.getGraphFile());
        //ConstantsRepository.OPENDGRAPH.put(graphFile.getAbsolutePath(), graph);
        ConstantsRepository.CURRENTWORKINGFILE = graphFile.getAbsolutePath();
        ConstantsRepository.CURRENTWORKINGGRAPH = graph;
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(graphFile)));
        //System.out.println(xmlDecoder.readObject().toString());
        Object[] cells = (Object[]) xmlDecoder.readObject();
        for(Object cell:cells){
            graph.addCell(cell);
        }
        xmlDecoder.close();
        ConstantsRepository.graphComponent.setGridVisible(true);
        ConstantsRepository.graphComponent.setGraph(graph);
        ConstantsRepository.graphComponent.updateUI();
    }
    public static void saveGraphFile(GraphTreeNode node) throws FileNotFoundException{
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(node.getGraphFile()))));
        Object[] cells = ConstantsRepository.graphComponent.getCells(ConstantsRepository.graphComponent.getBounds());
        xmlEncoder.writeObject(cells);
        xmlEncoder.close();
    }
}
