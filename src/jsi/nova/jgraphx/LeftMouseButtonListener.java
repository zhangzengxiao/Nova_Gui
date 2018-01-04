/**
 * 
 */
package jsi.nova.jgraphx;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;

import jsi.nova.util.Constants;

/**
 * @ClassName:     LeftMouseButtonListener.java
 * @Description:   LeftMouseButtonListener
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月5日 下午3:57:59 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class LeftMouseButtonListener implements MouseListener {
    private CellPopMenu cmenu;

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        mxCell cell = (mxCell) FinalGraphComponent.getGraphComponent().getCellAt(e.getX(), e.getY());
        if (SwingUtilities.isRightMouseButton(e)) {
            if (cell != null) {
                cmenu = new CellPopMenu(cell);
                cmenu.show(FinalGraphComponent.getGraphComponent(), e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
