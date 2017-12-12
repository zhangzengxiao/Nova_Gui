/**
 * 
 */
package jsi.nova.gui.panel;

import javax.swing.JSplitPane;

/**
 * @ClassName:     MainSplitPanel.java
 * @Description:   this panel contain all of other panel
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:05:08 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MainSplitPanel extends JSplitPane {
    private ProjectTreePanel projectTreePanel = null;
    private GraphAndMonitorSplitPanel graphAndMonitorSplitPanel = null;
    
    public MainSplitPanel() {
        // TODO Auto-generated constructor stub
        projectTreePanel = new ProjectTreePanel();
        graphAndMonitorSplitPanel = new GraphAndMonitorSplitPanel(JSplitPane.VERTICAL_SPLIT);
        
        this.setLeftComponent(projectTreePanel);
        this.setRightComponent(graphAndMonitorSplitPanel);
    }

    public ProjectTreePanel getProjectTreePanel() {
        return projectTreePanel;
    }

    public void setProjectTreePanel(ProjectTreePanel projectTreePanel) {
        this.projectTreePanel = projectTreePanel;
    }

    public GraphAndMonitorSplitPanel getGraphAndMonitorSplitPanel() {
        return graphAndMonitorSplitPanel;
    }

    public void setGraphAndMonitorSplitPanel(GraphAndMonitorSplitPanel graphAndMonitorSplitPanel) {
        this.graphAndMonitorSplitPanel = graphAndMonitorSplitPanel;
    }
}
