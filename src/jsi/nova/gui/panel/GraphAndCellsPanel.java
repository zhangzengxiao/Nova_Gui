/**
 * 
 */
package jsi.nova.gui.panel;

import javax.swing.JSplitPane;

/**
 * @ClassName:     GraphAndCellsPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月26日 下午2:04:46 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphAndCellsPanel extends JSplitPane{
    private GraphPanel graphPanel;
    private CellsPanel cellsPanel;
    public GraphAndCellsPanel(int newOrientation) {
        // TODO Auto-generated constructor stub
        super(newOrientation);
        graphPanel = new GraphPanel();
        cellsPanel = new CellsPanel();
        //
        this.setLeftComponent(graphPanel);
        this.setRightComponent(cellsPanel);
    }

}
