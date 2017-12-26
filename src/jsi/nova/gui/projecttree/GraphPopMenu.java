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

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.view.mxGraph;

import jsi.nova.util.Constants;

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
        openGraph.addActionListener(new GraphPopMenuActions.openGraphListener(node));     
        saveGraph.addActionListener(new GraphPopMenuActions.saveGraphListener(node));
        //
        this.add(openGraph);
        this.addSeparator();
        this.add(saveGraph);
        this.addSeparator();
        this.add(runGraph);
        this.addSeparator();
        this.add(deleteGraph);
    }
}
