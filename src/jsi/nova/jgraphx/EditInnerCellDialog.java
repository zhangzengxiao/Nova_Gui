/**
 * 
 */
package jsi.nova.jgraphx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jsi.nova.util.Constants;

/**
 * @ClassName:     EditInnerCellDialog.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月27日 下午12:59:36 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class EditInnerCellDialog extends JDialog {
    private JLabel label_name;
    private JLabel label_graph;
    private JComboBox select_graph;
    private JTextField text_name;
    private JButton confirm;
    private JButton cancel;
    private File Currentpath;

    public EditInnerCellDialog(InnerGraphCell cell) {
        // TODO Auto-generated constructor stub
        label_name = new JLabel("name:");
        label_name.setBounds(40, 52, 54, 15);
        label_graph = new JLabel("graph:");
        label_graph.setBounds(40, 120, 54, 15);
        select_graph = new JComboBox();
        select_graph.setBounds(133, 116, 220, 30);
        text_name = new JTextField();
        text_name.setBounds(133, 49, 220, 30);
        confirm = new JButton("确定");
        confirm.setBounds(154, 200, 93, 23);
        cancel = new JButton("取消");
        cancel.setBounds(267, 200, 93, 23);
        //
        Currentpath = new File(Constants.CURRENTWORKINGFILE);
        File files[] = new File(Currentpath.getParent()).listFiles();
        for (File a : files) {
            if (a.getAbsolutePath().endsWith(".jg")) {
                select_graph.addItem(a.getName().replaceAll(".jg", ""));
            }
        }
        //
        confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cell.setValue(text_name.getText().toString());
                //
                if (select_graph.getSelectedItem() != null) {
                    cell.setInnerGraph(
                            Currentpath.getParent() + "\\" + select_graph.getSelectedItem().toString() + ".jg");
                }
                Constants.CURRENTWORKINGGRAPH.refresh();
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        //
        //
        this.add(label_name);
        this.add(label_graph);
        this.add(select_graph);
        this.add(text_name);
        this.add(confirm);
        this.add(cancel);
        //

        this.setSize(400, 300);
        this.setLayout(null);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
