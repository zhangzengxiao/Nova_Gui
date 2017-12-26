/**
 * 
 */
package jsi.nova.jgraphx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;

import jsi.nova.gui.dialog.EditCommandsCellDialog;
import jsi.nova.jgraphx.CommandsCell;
import jsi.nova.util.Constants;

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
    JMenuItem delete;
    public CellPopMenu(mxCell cell) {
        // TODO Auto-generated constructor stub
        edit = new JMenuItem("编辑");
        delete = new JMenuItem("删除");
        edit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (cell instanceof CommandsCell) {
                    new EditCommandsCellDialog((CommandsCell) cell);
                }
                if (cell instanceof InnerGraphCell){
                    
                }
                else if(cell.isEdge()){
                   
                }
            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method cstub
                Object[] cells = {cell};
                Constants.graphComponent.getGraph().removeCells(cells);
            }
        });
        this.add(edit);
        this.add(delete);
    }
}
