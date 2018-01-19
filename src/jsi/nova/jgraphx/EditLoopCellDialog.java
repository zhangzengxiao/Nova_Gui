/**
 * 
 */
package jsi.nova.jgraphx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.LookupOp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jsi.nova.jgraphx.EditCommandsCellDialog.CancelListener;
import jsi.nova.jgraphx.EditCommandsCellDialog.ConfirmListener;
import jsi.nova.util.Constants;

/**
 * @ClassName:     EditLoopCellDialog.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2018年1月19日 下午1:08:23 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class EditLoopCellDialog extends JDialog{
    private JButton button1;
    private JButton button2;
    private JLabel label_name;
    private JTextField text_name;
    private JLabel label_commands;
    private JTextArea text_commands;
    private LoopCell cell;
    public EditLoopCellDialog(LoopCell cell) {
        this.cell = cell;
        // TODO Auto-generated constructor stub
        //
        label_name = new JLabel("Name:");
        label_name.setBounds(10, 10, 68, 27);
        text_name = new JTextField(cell.getValue().toString());
        text_name.setBounds(96, 11, 508, 27);
        label_commands = new JLabel("次数");
        label_commands.setBounds(10, 61, 87, 27);
        text_commands = new JTextArea(String.valueOf(cell.getLooptimes()));
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
            cell.setLooptimes(Integer.valueOf(text_commands.getText()));
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
