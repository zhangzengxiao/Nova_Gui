/**
 * 
 */
package jsi.nova.gui.projecttree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @ClassName:     GraphTreeNode.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月12日 上午9:58:10 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class GraphTreeNode extends DefaultMutableTreeNode{

    /**
     * 
     */
    private String graphName;
    private String graphFile;
    
    public GraphTreeNode() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param userObject
     * @param allowsChildren
     */
    public GraphTreeNode(Object userObject, boolean allowsChildren) {
        super(userObject, allowsChildren);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param userObject
     */
    public GraphTreeNode(Object userObject) {
        super(userObject);
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the graphName
     */
    public String getGraphName() {
        return graphName;
    }

    /**
     * @param graphName the graphName to set
     */
    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public String getGraphFile() {
        return graphFile;
    }

    public void setGraphFile(String graphFile) {
        this.graphFile = graphFile;
    }

}
