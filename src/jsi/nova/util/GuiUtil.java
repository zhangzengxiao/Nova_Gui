/**
 * 
 */
package jsi.nova.util;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @ClassName:     GuiUtil.java
 * @Description:   工具类，放了一些常用的方法
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:38:34 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GuiUtil {
    private static String imageFolder = "./img";
    
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        Image smalli = i.getImage();
        smalli = smalli.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        i.setImage(smalli);
        b.setIcon(i);
        //b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
    }

}
