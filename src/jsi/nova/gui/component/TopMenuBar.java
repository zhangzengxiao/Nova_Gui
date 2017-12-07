/**
 * 
 */
package jsi.nova.gui.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * @ClassName:     TopMenuBar.java
 * @Description:   the Main Menu
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:34:32 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class TopMenuBar extends JMenuBar{

    public TopMenuBar() {
        // TODO Auto-generated constructor stub
        this.add(new JMenu("保存"));
        this.add(new JMenu("运行"));
        this.add(new JMenu("帮助 "));
    }
}
