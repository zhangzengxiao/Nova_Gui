/**
 * 
 */
package jsi.nova.gui.projecttree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @ClassName:     ProjectTreeNode.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月8日 下午1:45:32 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class ProjectTreeNode extends DefaultMutableTreeNode{

    /**
     * 
     */
    private String projectPath = null;
    public ProjectTreeNode() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param userObject
     * @param allowsChildren
     */
    public ProjectTreeNode(Object userObject, boolean allowsChildren) {
        super(userObject, allowsChildren);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param userObject
     */
    public ProjectTreeNode(Object userObject) {
        super(userObject);
        // TODO Auto-generated constructor stub
        this.add(new DefaultMutableTreeNode());
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
    

}
