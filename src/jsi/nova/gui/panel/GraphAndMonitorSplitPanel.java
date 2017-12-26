/**
 * 
 */
package jsi.nova.gui.panel;

import javax.swing.JSplitPane;

import jsi.nova.util.Constants;

/**
 * @ClassName:     GraphAndMonitorSplitPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         contain graph panel and monitor panel
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:07:50 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphAndMonitorSplitPanel extends JSplitPane{

    private MonitorPanel monitorPanel;
    
    public GraphAndMonitorSplitPanel(int newOrientation) {
        // TODO Auto-generated constructor stub
        super(newOrientation);
        Constants.graphAndCellsPanel = new GraphAndCellsPanel(JSplitPane.HORIZONTAL_SPLIT);
        monitorPanel = new MonitorPanel();
        //
        this.setLeftComponent(Constants.graphAndCellsPanel);
        this.setRightComponent(monitorPanel);
    }

}
