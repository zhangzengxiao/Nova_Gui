/**
 * 
 */
package jsi.nova.jgraphx;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;

/**
 * @ClassName:     InnerGraphCell.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         InnerGraphCell extends mxCell
 * @version        V1.0  
 * @Date           2017年12月26日 下午3:33:59 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class InnerGraphCell extends mxCell{
    private String innerGraph = null;

    public InnerGraphCell() {
        super();
        // TODO Auto-generated constructor stub
    }

    public InnerGraphCell(Object arg0, mxGeometry arg1, String arg2) {
        super(arg0, arg1, arg2);
        // TODO Auto-generated constructor stub
    }

    public InnerGraphCell(Object arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public String getInnerGraph() {
        return innerGraph;
    }

    public void setInnerGraph(String innerGraph) {
        this.innerGraph = innerGraph;
    }
    

}
