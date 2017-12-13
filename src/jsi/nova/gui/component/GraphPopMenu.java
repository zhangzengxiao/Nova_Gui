/**
 * 
 */
package jsi.nova.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.view.mxGraph;

import jsi.nova.jgraphx.IfChangedGraph;
import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     GraphPopMenu.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月13日 上午9:53:16 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphPopMenu extends JPopupMenu{
    
    private JMenuItem openGraph;
    private JMenuItem saveGraph;
    private JMenuItem runGraph;
    private JMenuItem deleteGraph;
    private GraphTreeNode node;
    public GraphPopMenu(GraphTreeNode node) {
        // TODO Auto-generated constructor stub
        this.node = node;
        openGraph = new JMenuItem("打开");
        saveGraph = new JMenuItem("保存");
        runGraph = new JMenuItem("运行");
        deleteGraph = new JMenuItem("删除");
        //
        openGraph.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    openGraphFile();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        //
        this.add(openGraph);
        this.addSeparator();
        this.add(saveGraph);
        this.addSeparator();
        this.add(runGraph);
        this.addSeparator();
        this.add(deleteGraph);
    }
    public void openGraphFile() throws FileNotFoundException{
        IfChangedGraph graph = new IfChangedGraph();
        File graphFile = new File(node.getGraphFile());
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
}
