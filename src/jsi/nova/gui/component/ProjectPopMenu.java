/**
 * 
 */
package jsi.nova.gui.component;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @ClassName:     ProjectPopMenu.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月8日 下午3:24:11 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectPopMenu extends JPopupMenu{
    
    private JMenuItem newGraph = null;
    private JMenuItem deleteProject = null;
    
    public ProjectPopMenu(DefaultMutableTreeNode dn) {
        // TODO Auto-generated constructor stub
        newGraph = new JMenuItem("新建流程图");
        deleteProject = new JMenuItem("删除项目");
        //
        String path = ((ProjectTreeNode)dn).getProjectPath();
        
        this.add(newGraph);
        this.addSeparator();
        this.add(deleteProject);
    }

}
