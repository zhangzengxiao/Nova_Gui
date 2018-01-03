/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * @ClassName:     ProjectTreePanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         show the structures of project
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:53:58 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectTreePanel extends JPanel{
    private static ProjectTreePanel panel = new ProjectTreePanel();
    private ProjectTreePanel() {
        // TODO Auto-generated constructor stub
        this.setLayout(new GridLayout(1, 1));
    }

    public static ProjectTreePanel getPanel() {
        return panel;
    }
}
