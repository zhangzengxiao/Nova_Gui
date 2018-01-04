/**
 * 
 */
package jsi.nova.gui.ToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jsi.nova.jgraphx.FinalGraphComponent;
import jsi.nova.util.Constants;

/**
 * @ClassName:     ZoomOutListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zoom out the graph
 * @version        V1.0  
 * @Date           2017年12月7日 下午2:50:48 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ZoomOutListener implements ActionListener{

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        FinalGraphComponent.getGraphComponent().zoomOut();
    }

}
