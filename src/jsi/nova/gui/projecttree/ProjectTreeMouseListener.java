/**
 * 
 */
package jsi.nova.gui.projecttree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     ProjectTreeMouseListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月8日 下午2:45:39 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectTreeMouseListener implements MouseListener{

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        DefaultMutableTreeNode dn = (DefaultMutableTreeNode) ConstantsRepository.projectTree.getLastSelectedPathComponent();
        if(e.getButton()==3){
//            TreePath dtn  = ConstantsRepository.projectTree.getPathForLocation(e.getX(),e.getY());
            if(dn instanceof ProjectTreeNode){
                new ProjectPopMenu((ProjectTreeNode) dn).show(ConstantsRepository.projectTree, e.getX(), e.getY());;
            }
            else if(dn instanceof GraphTreeNode){
                new GraphPopMenu((GraphTreeNode) dn).show(ConstantsRepository.projectTree, e.getX(), e.getY());;
            }
        }
//        if(e.getClickCount()==2 && e.getButton()==1){
//            if(dn instanceof GraphTreeNode){
//                try {
//                    GraphPopMenu.openGraphFile();
//                } catch (FileNotFoundException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//            }
//        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}