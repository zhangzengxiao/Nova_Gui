/**
 * 
 */
package jsi.nova.gui.monitor;

import javax.swing.JTextArea;

import jsi.nova.gui.panel.MonitorPanel;

/**
 * @ClassName:     MonitorThread.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2018年1月11日 下午12:30:01 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MonitorThread implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        JTextArea monitor_show_area = MonitorPanel.getMonitor_area();
        while (true) {
            StringBuilder sb = new StringBuilder("workflow is runing");
            for (int i = 0; i < 10; i++) {
                monitor_show_area.setText(sb.append(".").toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
