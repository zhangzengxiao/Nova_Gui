/**
 * 
 */
package jsi.nova.jgraphx;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;

/**
 * @ClassName:     ComandsCell.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月6日 下午12:51:56 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class CommandsCell extends mxCell {
    private String commands = null;

    public CommandsCell() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CommandsCell(Object arg0, mxGeometry arg1, String arg2) {
        super(arg0, arg1, arg2);
        // TODO Auto-generated constructor stub
    }
    
    public CommandsCell(Object arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

}
