/**
 * 
 */
package jsi.nova.gui.ToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;

import jsi.nova.gui.monitor.MonitorThread;
import jsi.nova.util.Constants;

/**
 * @ClassName:     TestPrintListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月5日 上午10:31:15 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class TestPrintListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //        mxGraphComponent mg = FinalGraphComponent.getGraphComponent();
        //        for(Object cell : mg.getCells(mg.getBounds())){
        //            System.out.println(cell);
        ////            if(cell instanceof CommandsCell){
        ////                //System.out.println(cell);
        ////            }
        ////            else{
        ////                mxCell c = (mxCell) cell;
        ////                System.out.println(c.getSource());
        ////                System.out.println(c.getTarget());
        ////            }
//        GraphAndCellsPanel.getPanel().setDividerLocation(0.85);
//        MainFrame.getMainFrame().validate();
//        System.out.println("ss");
  //      new Thread(new MonitorThread()).start();
//        Map<String, Object> edge = new HashMap<String, Object>();
////        edge.put(mxConstants.STYLE_ROUNDED, true);
////        edge.put(mxConstants.STYLE_ORTHOGONAL, false);
//        edge.put(mxConstants.STYLE_EDGE, "");
////        edge.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
////        edge.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
////        edge.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
////        edge.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
////        edge.put(mxConstants.STYLE_STROKECOLOR, "#6482B9"); // default is #6482B9
////        edge.put(mxConstants.STYLE_FONTCOLOR, "#446299");
//
//        mxStylesheet edgeStyle = new mxStylesheet();
//        edgeStyle.setDefaultEdgeStyle(edge);
//        Constants.CURRENTWORKINGGRAPH.setStylesheet(edgeStyle);
    }

}
