/**
 * 
 */
package jsi.nova.gui.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName:     MenuBarActions.java
 * @Description:   MeunBar所对应的响应函数们
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2018年1月3日 下午3:51:29 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class MenuBarActions {
    
    public static class NewProjectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            NewprojectDialog.getNewprojectDialog();
        }
        
    }

}
