/**
 * 
 */
package jsi.nova.jgraphx;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;

/**
 * @ClassName:     LoopCell.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2018年1月19日 下午1:00:31 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class LoopCell extends mxCell{
    private int looptimes;
    public LoopCell() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LoopCell(Object arg0, mxGeometry arg1, String arg2) {
        super(arg0, arg1, arg2);
        // TODO Auto-generated constructor stub
    }

    public LoopCell(Object arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the looptimes
     */
    public int getLooptimes() {
        return looptimes;
    }

    /**
     * @param looptimes the looptimes to set
     */
    public void setLooptimes(int looptimes) {
        this.looptimes = looptimes;
    }
   
}
