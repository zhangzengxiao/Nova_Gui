/**
 * 
 */
package jsi.nova.jgraphx;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;

/**
 * @ClassName:     CellPopMenu.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         this menu poped when a leftbutton clicked
 * @version        V1.0  
 * @Date           2017年11月22日 下午3:34:18 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class CellPopMenu extends JPopupMenu {
    JMenuItem edit;
    JMenuItem remove;
    public CellPopMenu(mxCell cell) {
        // TODO Auto-generated constructor stub
        edit = new JMenuItem("编辑");
        remove = new JMenuItem("删除");
        //
        edit.addActionListener(new CellPopMenuActions.EditCellListener(cell));
        remove.addActionListener(new CellPopMenuActions.RemoveCellListener(cell));
        //
        this.add(edit);
        this.add(remove);
    }
}
