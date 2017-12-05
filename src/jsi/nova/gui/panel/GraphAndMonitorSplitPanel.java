/**
 * 
 */
package jsi.nova.gui.panel;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * @ClassName:     GraphAndMonitorSplitPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:07:50 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphAndMonitorSplitPanel extends JSplitPane{
    private GraphPanel graphPanel = null;
    private MonitorPanel monitorPanel = null;
    public GraphAndMonitorSplitPanel(int newOrientation) {
        // TODO Auto-generated constructor stub
        super(newOrientation);
        graphPanel = new GraphPanel();
        monitorPanel = new MonitorPanel();
        //
        this.setLeftComponent(graphPanel);
        this.setRightComponent(monitorPanel);
    }

}
