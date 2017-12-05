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
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.util.png.mxPngTextDecoder;
import com.mxgraph.view.mxGraph;

import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     OpenGraphListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
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
        // TODO Auto-generated method stub
        try {
            openGraph();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
        //        XMLDecoder xmlDecoder = null;
        //        JFileChooser jFileChooser = new JFileChooser();
        //        jFileChooser.showOpenDialog(ConstantsRepository.mainFrame);
        //        File openfile = jFileChooser.getSelectedFile();
        //        if (openfile == null) return;
        //        try {
        //            xmlDecoder = new XMLDecoder(new  BufferedInputStream(new  FileInputStream(openfile)));
        //        } catch (FileNotFoundException e1) {
        //            // TODO Auto-generated catch block
        //            e1.printStackTrace();
        //        }
        //        graph.removeCells();
        //        Object cells =  xmlDecoder.readObject();
        //        graph.setModel((mxIGraphModel) cells);
        //        xmlDecoder.close();
    }

}
