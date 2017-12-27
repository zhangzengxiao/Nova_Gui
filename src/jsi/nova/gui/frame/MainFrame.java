/**
 * 
 */
package jsi.nova.gui.frame;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;

import javax.swing.JFrame;

import jsi.nova.gui.MenuBar.TopMenuBar;
import jsi.nova.gui.ToolBar.NovaToolBar;
import jsi.nova.gui.panel.MainSplitPanel;
import jsi.nova.gui.projecttree.GraphPopMenuActions;
import jsi.nova.util.Constants;

/**
 * @ClassName:     MainFrame.java
 * @Description:   MainFrame
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:50:13 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MainFrame extends JFrame{

    public MainFrame() {
        // TODO Auto-generated constructor stub
        Constants.mainSplitPanel = new MainSplitPanel();
        //
        Constants.mainFrame = this;
        this.setTitle("NOVA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new NovaToolBar(), BorderLayout.NORTH);
        this.add(Constants.mainSplitPanel, BorderLayout.CENTER);
        this.setJMenuBar(new TopMenuBar());
        
        this.addWindowListener(new FrameWindowListener());
        this.setResizable(true);
        this.setSize(1000,620);
        this.setVisible(true);
        Constants.graphAndCellsPanel.setDividerLocation(0.8);
        Constants.graphAndMonitorSplitPanel.setDividerLocation(0.8);
        Constants.mainSplitPanel.setDividerLocation(0.11);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    protected void processWindowEvent(WindowEvent e) {
        // TODO Auto-generated method stub
        if(e.getID() == WindowEvent.WINDOW_CLOSING){
            try {
                //判断当前图像是否更改过
                if(!GraphPopMenuActions.ifSaved()){
                    return;
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        super.processWindowEvent(e);
    }
}
