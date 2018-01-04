/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mxgraph.swing.mxGraphComponent;

import jsi.nova.jgraphx.FinalGraphComponent;
import jsi.nova.jgraphx.LeftMouseButtonListener;
import jsi.nova.util.Constants;

/**
 * @ClassName:     GraphPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         contain the graph
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:09:20 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphPanel extends JPanel{
    //private mxGraphComponent mxGraphComponent = Constants.graphComponent;
    private ImageIcon icon;  
    private Image img;
    private static GraphPanel Panel = new GraphPanel();
    
    private GraphPanel() {
        // TODO Auto-generated constructor stub
        this.setLayout(new GridLayout(1, 1));
        icon=new ImageIcon(GraphPanel.class.getResource("/img/background.png"));  
        img=icon.getImage();
        
//        mxGraphComponent.getGraphControl().addMouseListener(new LeftMouseButtonListener());
//        mxGraphComponent.setVisible(false);
        //this.add(mxGraphComponent);
        this.add(FinalGraphComponent.getGraphComponent());
    }
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小  
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
    }
    public static GraphPanel getPanel() {
        return Panel;
    }
}
