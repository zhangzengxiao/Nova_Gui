/**
 * 
 */
package jsi.nova.gui.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import jsi.nova.gui.component.NovaToolBar;
import jsi.nova.gui.component.TopMenuBar;
import jsi.nova.gui.panel.MainSplitPanel;

/**
 * @ClassName:     MainFrame.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:50:13 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MainFrame extends JFrame{
    private MainSplitPanel mainSplitPanel = null;
    public MainFrame() {
        // TODO Auto-generated constructor stub
        mainSplitPanel = new MainSplitPanel();
        //
        this.setTitle("NOVA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new NovaToolBar(), BorderLayout.NORTH);
        this.add(mainSplitPanel, BorderLayout.CENTER);
        this.setJMenuBar(new TopMenuBar());
        
        this.setResizable(true);
        this.setSize(1000,620);
        this.setVisible(true);
        mainSplitPanel.setDividerLocation(0.1);
        mainSplitPanel.getGraphAndMonitorSplitPanel().setDividerLocation(0.8);
        this.setLocationRelativeTo(null);
    }
}
