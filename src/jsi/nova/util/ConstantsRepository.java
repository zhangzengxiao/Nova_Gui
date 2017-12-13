/**
 * 
 */
package jsi.nova.util;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import jsi.nova.gui.frame.MainFrame;

/**
 * @ClassName:     ConstantsRepository.java
 * @Description:   ConstantsRepository，保存全局变量
 * @author         ConstantsRepository
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:53:35 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ConstantsRepository {
    public static mxGraph graph = new mxGraph();
    public static mxGraphComponent graphComponent = new mxGraphComponent(graph);
    public static MainFrame mainFrame =null;
    
    //projectTree
    public static DefaultMutableTreeNode projectTreeTop = new DefaultMutableTreeNode("项目总览");
    //public static JTree projectTree = new JTree(projectTreeTop);
    public static JTree projectTree = null;
    //
    public static Map<String,mxGraph> OPENDGRAPH = new HashMap<String,mxGraph>();
    public static String CURRENTWORKINGFILE;
    public static mxGraph CURRENTWORKINGGRAPH;
    public static mxGraph OLDGRAPH;
}
