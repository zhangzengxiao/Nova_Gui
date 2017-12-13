/**
 * 
 */
package jsi.nova.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jsi.nova.gui.dialog.NewprojectDialog;

/**
 * @ClassName:     TopMenuBar.java
 * @Description:   the Main Menu
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月4日 下午3:34:32 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class TopMenuBar extends JMenuBar{
    private JMenu file = null;
    private JMenu run = null;
    private JMenu help = null;
    public TopMenuBar() {
        // TODO Auto-generated constructor stub
        file = new JMenu("文件");
        JMenuItem newproject = new JMenuItem("新建");
        newproject.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new NewprojectDialog();
            }
        });
        file.add(newproject);
        file.add(new JMenuItem("另存为"));
        //
        run = new JMenu("运行");
        //
        help = new JMenu("帮助");
        //
        this.add(file);
        this.add(run);
        this.add(help);
    }
}
