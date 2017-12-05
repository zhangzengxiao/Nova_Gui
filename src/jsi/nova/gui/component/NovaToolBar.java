/**
 * 
 */
package jsi.nova.gui.component;

import javax.swing.JButton;
import javax.swing.JToolBar;

import jsi.nova.gui.listener.AddNodeListener;
import jsi.nova.gui.listener.OpenGraphListener;
import jsi.nova.gui.listener.SaveGraphListener;
import jsi.nova.gui.listener.TestPrintListener;
import jsi.nova.util.GuiUtil;

/**
 * @ClassName:     NovaToolBar.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:36:59 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class NovaToolBar extends JToolBar {

    private JButton runWorkflow = null;
    private JButton saveGraph = null;
    private JButton openGraph = null;
    private JButton addNode = null;
    private JButton addEdge = null;
    private JButton testButton = null;

    public NovaToolBar() {
        // TODO Auto-generated constructor stub
        runWorkflow = new JButton();
        GuiUtil.setImageIcon(runWorkflow, "video_play_64.png", "运行工作流");
        saveGraph = new JButton();
        GuiUtil.setImageIcon(saveGraph, "inbox_64.png", "保存图片");
        openGraph = new JButton();
        GuiUtil.setImageIcon(openGraph, "outbox_64.png", "打开图片");
        addNode = new JButton();
        GuiUtil.setImageIcon(addNode, "frame_64.png", "添加节点");
        addEdge = new JButton();
        GuiUtil.setImageIcon(addEdge, "arrow_64.png", "添加连线");
        
        testButton = new JButton("测试");
        //
        addNode.addActionListener(new AddNodeListener());
        saveGraph.addActionListener(new SaveGraphListener());
        openGraph.addActionListener(new OpenGraphListener());
        testButton.addActionListener(new TestPrintListener());
        //
        this.add(runWorkflow);
        this.add(saveGraph);
        this.add(openGraph);
        this.add(addNode);
        this.add(addEdge);
        this.add(testButton);
        this.setFloatable(false);
    }

}
