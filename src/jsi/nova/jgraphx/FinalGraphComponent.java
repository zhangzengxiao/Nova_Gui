/**
 * 
 */
package jsi.nova.jgraphx;

import org.w3c.dom.Document;

import com.mxgraph.io.mxCodec;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;

/**
 * @ClassName:     FinalGraphComponent.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2018年1月4日 下午1:30:57 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class FinalGraphComponent extends mxGraphComponent{
    private static FinalGraphComponent graphComponent = new FinalGraphComponent(new mxGraph());

    private FinalGraphComponent(mxGraph arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
//        mxCodec codec = new mxCodec();
//        Document doc = mxUtils.loadDocument(FinalGraphComponent.class.getResource("/resources/default-style.xml").toString());
//        codec.decode(doc.getDocumentElement(), this.getGraph().getStylesheet());
        
        this.getGraphControl().addMouseListener(new LeftMouseButtonListener());
        this.setVisible(false);
        this.setGridVisible(true);
    }

    public static FinalGraphComponent getGraphComponent() {
        return graphComponent;
    }
}
