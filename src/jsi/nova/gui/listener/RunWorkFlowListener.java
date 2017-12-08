/**
 * 
 */
package jsi.nova.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.python.util.PythonInterpreter;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import jsi.nova.jgraphx.CommandsCell;
import jsi.nova.util.ConstantsRepository;

/**
 * @ClassName:     RunWorkFlowListener.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         xulu
 * @version        V1.0  
 * @Date           2017年12月7日 下午3:34:24 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class RunWorkFlowListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    private FileWriter fileWriter = null ;      //生成的xml文件
    private Map<String, ArrayList<String>> edge = null ;
    private ArrayList<String> edge_child = null ;
    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        mxGraphComponent graphComponent = ConstantsRepository.graphComponent;
        edge = new HashMap<String, ArrayList<String>>();
        edge_child = new ArrayList<String>();

        try {
            //fileWriter = new FileWriter("C:/Users/Shaohan/Desktop/phase_test/workflow.xml");
            fileWriter = new FileWriter(System.getProperty("user.dir") + File.separatorChar + "workflow.xml");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
            bufferedWriter.append("<workflow>\n");
            bufferedWriter.append("\t<phase>\n");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        for (Object cell : graphComponent.getCells(graphComponent.getBounds())) {
            mxCell c = (mxCell) cell;

            if (c.isEdge()) {
//                System.out.println("bian" + c.getAttributes());
//                System.out.println("bian" + c.getAttributes().get("partent"));
//                System.out.println("bian" + c.getAttributes().get("child"));

                String parent = c.getSource().getValue().toString();
                String child =  c.getTarget().getValue().toString();
                edge_child = edge.get(parent);
                if (edge_child == null) {
                    edge_child = new ArrayList<String>();
                    edge_child.add(child);
                    edge.put(parent, edge_child);
                } else {
                    edge_child.add(child);
                    edge.put(parent, edge_child);
                }
            } else if(c instanceof CommandsCell){
//                System.out.println("dian" + c.getAttributes());
                try {
                    bufferedWriter.append("\t\t<node id = \'" + c.getValue().toString() + "\'>\n");
                    bufferedWriter.append("\t\t\t<input_file>input_data_1</input_file>\n");
                    bufferedWriter.append("\t\t\t<output_file>output_data_2</output_file>\n");
                    bufferedWriter.append("\t\t\t<arguments>input_data_1 input_data_2</arguments>\n");
                    bufferedWriter.append("\t\t\t<executable>" + c.getValue().toString() + ".bat</executable>\n");
                    bufferedWriter.append("\t\t\t<other>\n");
                    bufferedWriter.append("\t\t\t\t<should_transfer_files>YES</should_transfer_files>\n");
                    bufferedWriter.append("\t\t\t\t<when_to_transfer_output>ON_EXIT</when_to_transfer_output>\n");
                    bufferedWriter.append("\t\t\t\t<Universe>vanilla</Universe>\n");
                    bufferedWriter.append("\t\t\t\t<Log>log/" + c.getValue().toString() + ".log</Log>\n");
                    bufferedWriter.append("\t\t\t\t<error>log/" + c.getValue().toString() + ".error</error>\n");
                    bufferedWriter.append("\t\t\t\t<output>log/" + c.getValue().toString() + "out</output>\n");
                    bufferedWriter.append("\t\t\t\t<a>Queue</a>\n");
                    bufferedWriter.append("\t\t\t</other>\n");
                    bufferedWriter.append("\t\t</node>\n");

                    String commands = ((CommandsCell) cell).getCommands();
                    FileWriter bat_file = new FileWriter(
                            System.getProperty("user.dir") + File.separatorChar + c.getValue().toString() + ".bat");
                    BufferedWriter bat_Writer = new BufferedWriter(bat_file);
                    bat_Writer.write(commands);
                    bat_Writer.flush();
                    bat_Writer.close();
                    bat_file.close();

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        }
        for (String key : edge.keySet()) {
            try {
                bufferedWriter.append("\t\t<parent ref = \'" + key + "\'>\n");
                List<String> child = new ArrayList();
                child = edge.get(key);
                Iterator<String> it = child.iterator();
                while (it.hasNext()) {
                    bufferedWriter.append("\t\t\t<child ref = \'" + it.next() + "\'/>\n");
                }
                bufferedWriter.append("\t\t</parent>\n");

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

        try {
            bufferedWriter.append("\t\t<loop></loop>\n");
            bufferedWriter.append("\t\t<script>\n");
            bufferedWriter.append("\t\t\t<pre>pre.py</pre>\n");
            bufferedWriter.append("\t\t\t<post>post.py</post>\n");
            bufferedWriter.append("\t\t</script>\n");
            bufferedWriter.append("\t</phase>\n");
            bufferedWriter.append("</workflow>\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        File file1 = new File("log");
        file1.mkdir();//首先创建file1对应的文件夹
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(System.getProperty("user.dir") + File.separatorChar + "workflow dev.py");

    }
}
