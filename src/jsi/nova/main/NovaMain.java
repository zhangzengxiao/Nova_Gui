/**
 * 
 */
package jsi.nova.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jsi.nova.gui.frame.MainFrame;

/**
 * @ClassName:     NovaMain.java
 * @Description:   Entrance of this app
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午2:47:15 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class NovaMain {
    public static void main(String[] args) {
        // set the theme style
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //
        MainFrame.getMainFrame();
    }
}
