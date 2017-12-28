/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import jsi.nova.util.Constants;

/**
 * @ClassName:     MonitorPanel.java
 * @Description:   nothing
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:57:36 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MonitorPanel extends JPanel{
    private JTextArea monitor_area;
    public MonitorPanel() {
        // TODO Auto-generated constructor stub
        Constants.MONITORAREA = new JTextArea();
        Constants.MONITORAREA.setEditable(false);
        this.setLayout(new GridLayout(1, 1));
        this.add(Constants.MONITORAREA);
    }
}
