/**
 * 
 */
package jsi.nova.gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mxgraph.model.mxCell;

import jsi.nova.jgraphx.CommandsCell;

/**
 * @ClassName:     EditVertexDialog.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月5日 下午4:31:11 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class EditCommandsCellDialog extends JDialog {
    private JButton button1 = null;
    private JButton button2 =null;
    private JLabel label_name = null;
    private JTextField text_name = null;
    private JLabel label_commands = null;
    private JTextArea text_commands = null;
    
    public EditCommandsCellDialog(CommandsCell cell) {
        // TODO Auto-generated constructor stub
        this.setSize(661, 459);
        label_name = new JLabel("Name:");
        label_name.setBounds(10, 10, 68, 27);
        text_name = new JTextField(cell.getValue().toString());
        text_name.setBounds(96, 11, 508, 27);
        label_commands = new JLabel("Commands");
        label_commands.setBounds(10, 61, 87, 27);
        text_commands = new JTextArea(cell.getCommands());
        text_commands.setBounds(96, 64, 508, 313);
        
        button1 = new JButton("确认");
        button1.setBounds(448, 387, 79, 23);
        button1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cell.setValue(text_name.getText().toString());
               
                //
                cell.setCommands(text_commands.getText().toString());
                dispose();
            }
        });
        button2 = new JButton("取消");
        button2.setBounds(556, 387, 79, 23);
        //
        this.add(label_name);
        this.add(text_name);
        this.add(label_commands);
        this.add(text_commands);
        this.add(button1);
        this.add(button2);
        //
        this.setLayout(null);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
