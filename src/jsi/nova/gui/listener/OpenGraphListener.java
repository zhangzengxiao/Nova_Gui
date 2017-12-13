/**
 * 
 */
package jsi.nova.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.swing.JFileChooser;

import org.w3c.dom.Document;

import com.mxgraph.io.mxCodec;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.util.png.mxPngTextDecoder;
import com.mxgraph.view.mxGraph;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     OpenGraphListener.java
 * @Description:   open a Graph from a XML File
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月5日 下午12:29:52 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class OpenGraphListener implements ActionListener {
    mxGraph graph = ConstantsRepository.graph;
    mxGraphComponent graphComponent = ConstantsRepository.graphComponent;

    @Override
    public void actionPerformed(ActionEvent e) {
        open2();
    }

    public void openGraph() throws FileNotFoundException, UnsupportedEncodingException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(ConstantsRepository.mainFrame);
        File file = jFileChooser.getSelectedFile();
        Map<String, String> text = mxPngTextDecoder.decodeCompressedText(new FileInputStream(file));

        if (text != null) {
            String value = text.get("mxGraphModel");

            if (value != null) {
                Document document = mxXmlUtils.parseXml(URLDecoder.decode(value, "UTF-8"));
                mxCodec codec = new mxCodec(document);
                codec.decode(document.getDocumentElement(), graphComponent.getGraph().getModel());
                return;
            }
        }
    }

    public void open2() {
        XMLDecoder xmlDecoder = null;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(ConstantsRepository.mainFrame);
        File openfile = jFileChooser.getSelectedFile();
        if (openfile == null)
            return;
        try {
            xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(openfile)));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Object[] cells = (Object[]) xmlDecoder.readObject();
        for(Object cell:cells){
            graph.addCell(cell);
        }
        //graph.removeCells();
//        List open = new ArrayList();
//        open = (List) xmlDecoder.readObject();
//        graph.getModel().beginUpdate();
//
//        for (Object cell : open) {
//            CommandsCell s = null;
//            final int PORT_DIAMETER = 20;
//            final int PORT_RADIUS = PORT_DIAMETER / 2;
//            mxCell c = (mxCell) cell;
//            if (c instanceof CommandsCell) {
//                graph.addCell(c, graph.getDefaultParent());
////                mxGeometry geo1 = new mxGeometry(0, 0.5, PORT_DIAMETER, PORT_DIAMETER);
////                // Because the origin is at upper left corner, need to translate to
////                // position the center of port correctly
////                geo1.setOffset(new mxPoint(-PORT_RADIUS, -PORT_RADIUS));
////                geo1.setRelative(true);
////
////                mxCell port1 = new mxCell(null, geo1, "shape=ellipse;perimter=ellipsePerimeter");
////                port1.setValue("ttttt"); 
////                port1.setVertex(true);
////                graph.addCell(port1, c);
//            } else if (c.isEdge()) {
//                graph.addCell(c);
//            } else {
//                mxCell parent = (mxCell) c.getParent();
//                mxCell child = c;
//                System.out.println(graph.addCell(child, parent));
//            }
//        }
//        graph.getModel().endUpdate();
        xmlDecoder.close();
    }

}
