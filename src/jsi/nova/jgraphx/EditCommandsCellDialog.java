/**
 * 
 */
package jsi.nova.jgraphx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jsi.nova.util.Constants;

/**
 * @ClassName:     EditVertexDialog.java
 * @Description:   Edit CommandsCEll dialog
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月5日 下午4:31:11 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class EditCommandsCellDialog extends JDialog {
    private JButton button1;
    private JButton button2;
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_commands;
    private JTextArea text_commands;
    private CommandsCell cell;

    public EditCommandsCellDialog(CommandsCell cell) {
        // TODO Auto-generated constructor stub
        this.cell = cell;
        //
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
        button2 = new JButton("取消");
        button2.setBounds(556, 387, 79, 23);
        //
        button1.addActionListener(new ConfirmListener());
        button2.addActionListener(new CancelListener());
        //
        this.add(label_name);
        this.add(text_name);
        this.add(label_commands);
        this.add(text_commands);
        this.add(button1);
        this.add(button2);
        //
        this.setSize(661, 459);
        this.setLayout(null);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            cell.setValue(text_name.getText().toString());
            //
            cell.setCommands(text_commands.getText().toString());
            Constants.CURRENTWORKINGGRAPH.refresh();
            dispose();
        }

    }
    public class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            dispose();
        }
        
    }
}
