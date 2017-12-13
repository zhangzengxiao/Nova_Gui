/**
 * 
 */
package jsi.nova.gui.dialog;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.plaf.FileChooserUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import jsi.nova.gui.component.ProjectTreeNode;
import jsi.nova.util.ConstantsRepository;
import jsi.nova.util.GuiUtil;

/**
 * @ClassName:     NewprojectDialog.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月7日 下午4:22:58 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class NewprojectDialog extends JDialog{
    private JLabel lprojectName = null;
    private JLabel lprojectLocation = null;
    private TextField tprojectname = null;
    private TextField tprojectLocatiuon = null;
    private JButton bbrowse = null;
    private JButton bconfirm = null;
    private JButton bcancel = null;
    private String path = null;
    public NewprojectDialog() {
        // TODO Auto-generated constructor stub
        lprojectName = new JLabel("项目名称:");
        lprojectName.setBounds(10, 18, 65, 15);
        
        lprojectLocation = new JLabel("项目位置:");
        lprojectLocation.setBounds(10, 49, 65, 15);
        
        tprojectname = new TextField();
        tprojectname.setBounds(75, 15, 253, 21);
        
        tprojectLocatiuon = new TextField();
        tprojectLocatiuon.setBounds(75, 46, 253, 21);
        
        bbrowse = new JButton("浏览...");
        bbrowse.setBounds(338, 44, 93, 23);
        
        bconfirm = new JButton("确认");
        bconfirm.setBounds(235, 79, 93, 23);
        
        bcancel = new JButton("取消");
        bcancel.setBounds(338, 76, 93, 23);
        //
        bbrowse.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                path = file.getAbsolutePath();
                tprojectLocatiuon.setText(path);
            }
        });
        
        bconfirm.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(GuiUtil.checkEmpty(tprojectname.getText().toString(), "项目名称") && GuiUtil.checkEmpty(tprojectLocatiuon.getText().toString(), "项目位置")){
                    ProjectTreeNode ptn = new ProjectTreeNode(tprojectname.getText().toString());
                    String windowspath = tprojectLocatiuon.getText().toString()+"\\"+tprojectname.getText().toString();
                    String javapath = windowspath.replace("\\", "/");
                    File filedir = new File(javapath);
                    if(!filedir.exists()){
                        filedir.mkdirs();
                    }
                    ptn.setProjectPath(javapath);
                    DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) ConstantsRepository.projectTree.getModel().getRoot();
                    dmt.add(ptn);
                    ConstantsRepository.projectTree.updateUI();
                    dispose();
                }

            }
        });
        //
        this.add(lprojectName);
        this.add(lprojectLocation);
        this.add(tprojectLocatiuon);
        this.add(tprojectname);
        this.add(bbrowse);
        this.add(bconfirm);
        this.add(bcancel);
        //
        this.setLayout(null);
        this.setSize(451, 150);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }
}
