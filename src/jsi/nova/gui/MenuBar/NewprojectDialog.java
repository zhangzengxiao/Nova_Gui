/**
 * 
 */
package jsi.nova.gui.MenuBar;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import jsi.nova.gui.panel.ProjectTreePanel;
import jsi.nova.gui.projecttree.ProjectTreeNode;
import jsi.nova.util.Constants;
import jsi.nova.util.GuiUtil;

/**
 * @ClassName:     NewprojectDialog.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月7日 下午4:22:58 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class NewprojectDialog extends JDialog {
    private JLabel lprojectName;
    private JLabel lprojectLocation;
    private TextField tprojectname;
    private TextField tprojectLocatiuon ;
    private JButton bbrowse;
    private JButton bconfirm;
    private JButton bcancel;
    private String path;
    
    private static NewprojectDialog newprojectDialog = new NewprojectDialog();
    private JTree tree = ProjectTreePanel.getProject_tree();

    private NewprojectDialog() {
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
        bcancel.setBounds(338, 79, 93, 23);
        //
        bbrowse.addActionListener(new BrowseListener());
        bconfirm.addActionListener(new ConfirmListener());
        bcancel.addActionListener(new ConfirmListener());
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

    /**
     * @return the newprojectDialog
     */
    
    class BrowseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            chooseWorkingPath();
        }
        
    }
    class ConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            newProject();
        }
        
    }
    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            dispose();
        }
        
    }
    public static NewprojectDialog getNewprojectDialog() {
        return newprojectDialog;
    }
    //选择项目的位置
    public void chooseWorkingPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (!(file == null)) {
            path = file.getAbsolutePath();
            tprojectLocatiuon.setText(path);
        }
    }
    //新建项目，在项目树中添加节点，在硬盘中新建文件夹
    public void newProject(){
        //判断项目名称和项目位置不为空
        if (GuiUtil.checkEmpty(tprojectname.getText().toString(), "项目名称")
                && GuiUtil.checkEmpty(tprojectLocatiuon.getText().toString(), "项目位置")) {
            //新建项目文件夹
            String projectpath = tprojectLocatiuon.getText().toString() + File.separator
                    + tprojectname.getText().toString();
            File filedir = new File(projectpath);
            if (!filedir.exists()) {
                filedir.mkdirs();
            }
            //新建在项目树中的节点
            ProjectTreeNode ptn = new ProjectTreeNode(tprojectname.getText().toString());
            //设置其所对应的路径
            ptn.setProjectPath(projectpath);
            DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) tree.getModel().getRoot();
            dmt.add(ptn);
            tree.updateUI();
            dispose();
        }

    }
}
