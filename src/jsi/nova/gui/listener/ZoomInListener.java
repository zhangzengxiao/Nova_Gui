/**
 * 
 */
package jsi.nova.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     ZoomInListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月7日 下午2:49:06 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ZoomInListener implements ActionListener{

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ConstantsRepository.graphComponent.zoomIn();
    }

}
