/**
 * 
 */
package jsi.nova.util;

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

}
