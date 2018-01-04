/**
 * 
 */
package jsi.nova.gui.panel;

import javax.swing.JSplitPane;

/**
 * @ClassName:     GraphAndMonitorSplitPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         contain graph panel and monitor panel
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:07:50 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphAndMonitorSplitPanel extends JSplitPane{
    private static GraphAndMonitorSplitPanel splitPanel = new GraphAndMonitorSplitPanel(JSplitPane.VERTICAL_SPLIT);
    
    private GraphAndMonitorSplitPanel(int newOrientation) {
        // TODO Auto-generated constructor stub
        super(newOrientation);
        //
        this.setLeftComponent(GraphAndCellsPanel.getPanel());
        this.setRightComponent(MonitorPanel.getPanel());
    }

    public static GraphAndMonitorSplitPanel getSplitPanel() {
        return splitPanel;
    }

}
