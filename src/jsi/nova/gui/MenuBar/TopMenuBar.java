/**
 * 
 */
package jsi.nova.gui.MenuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * @ClassName:     TopMenuBar.java
 * @Description:   the Main Menu
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:34:32 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class TopMenuBar extends JMenuBar{
    private JMenu file;
    private JMenu help;  
    public TopMenuBar() {
        // TODO Auto-generated constructor stub
        file = new JMenu("文件");
        JMenuItem newproject = new JMenuItem("新建项目");
        file.add(newproject);
        newproject.addActionListener(new MenuBarActions.NewProjectListener());
        //
        help = new JMenu("帮助");
        //
        this.add(file);
        this.add(help);
    }
}
