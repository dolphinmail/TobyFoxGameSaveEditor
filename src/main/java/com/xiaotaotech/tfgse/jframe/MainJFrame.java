package com.xiaotaotech.tfgse.jframe;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.xiaotaotech.App;
import com.xiaotaotech.tfgse.FileUtil;
import com.xiaotaotech.tfgse.Settings;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 08 16:03:04 CST 2025
 * https://blog.csdn.net/hitmengfanchao/article/details/137115617
 * https://zhuanlan.zhihu.com/p/465066522?utm_id=0
 */


/**
 * @author dolphin
 */
public class MainJFrame extends JFrame {
    String filePath;
    public MainJFrame() {
        initComponents();
        initComponents2();

    }

    private void openFile(ActionEvent e) {
        // TODO add your code here
        //System.out.println("open file");
        JFileChooser fileChooser = new JFileChooser();
        String workDir = System.getProperty("user.home") + "/AppData/Local/DELTARUNE/";
        fileChooser.setCurrentDirectory(new File(workDir));
        fileChooser.setMultiSelectionEnabled(false);//允许文件多选
        int select = fileChooser.showOpenDialog(this);//显示打开文件对话框
        if (select == JFileChooser.APPROVE_OPTION) {
            Settings.dataList= new ArrayList<String>();
            File file=fileChooser.getSelectedFile();
            filePath = file.getAbsolutePath();
            //System.out.println(filePath);
            try {
                FileUtil.readLinesFromFile(filePath, Settings.dataList);
/*                for (int i = 0; i < Settings.dataList.size(); i++) {
                    System.out.println(Settings.dataList.get(i));
                }*/
                txtName.setText(Settings.dataList.get(0));
                txtMoney.setText(Settings.dataList.get(10));
                txtHP.setText(Settings.dataList.get(70));
                txtMaxHP.setText(Settings.dataList.get(71));
                txtAT.setText(Settings.dataList.get(72));
                txtDF.setText(Settings.dataList.get(73));
                txtMagic.setText(Settings.dataList.get(74));
                setCtrEnabled(true);


            } catch (IOException ex) {
                System.out.println("open file IOException" );
                //throw new RuntimeException(ex);
            }
        }
    }

    private void saveFile(ActionEvent e) {
        // TODO add your code here
        if(null==filePath){
            System.out.println("filePath is null" );
            return;
        }
        Settings.dataList.set(0,txtName.getText());
        Settings.dataList.set(10,txtMoney.getText());
        Settings.dataList.set(1,txtName.getText());
        Settings.dataList.set(70,txtHP.getText());
        Settings.dataList.set(71,txtMaxHP.getText());
        Settings.dataList.set(72,txtAT.getText());
        Settings.dataList.set(73,txtDF.getText());
        Settings.dataList.set(74,txtMagic.getText());
        try {
            FileUtil.writeLinesToFile(filePath,Settings.dataList);
        } catch (IOException ex) {
            System.out.println("save file IOException" );
            //throw new RuntimeException(ex);
        }
    }

    private void initComponents2() {
        // 获取应用程序资源
        //ImageIcon imageIcon = new ImageIcon("D:\\dev\\code\\product\\TobyFoxGameSaveEditor\\TobyFoxGameSaveEditor\\src\\main\\resources\\images\\icon.png");
        ImageIcon imageIcon = new ImageIcon(App.class.getResource("/images/icon.png"));

        // 创建并设置窗体
        setIconImage(imageIcon.getImage());
        internalFrame1.setBorder(new TitledBorder("Kris"));
        ((BasicInternalFrameUI)internalFrame1.getUI()).setNorthPane(null);
        setCtrEnabled(false);
        setVisible(true);// 显示
        setLocationRelativeTo(null);// JFrame 窗口居中显示

    }

    private void setCtrEnabled(boolean enable) {
        lbName.setEnabled(enable);
        txtName.setEnabled(enable);
        lbMoney.setEnabled(enable);
        txtMoney.setEnabled(enable);
        btnSetGoods.setEnabled(enable);
        for(Component component:internalFrame1.getContentPane().getComponents()){
            component.setEnabled(enable);
        }
    }

    private void btnSetGoods(ActionEvent e) {
        // TODO add your code here
        int i=235;
        while (i<=283){
            Settings.dataList.set(i, "6");
            i+=4;
        }
        System.out.println("物品栏装满顶级蛋糕" );

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        file = new JMenu();
        openFile = new JMenuItem();
        saveFile = new JMenuItem();
        lbName = new JLabel();
        txtName = new JTextField();
        btnSetGoods = new JButton();
        lbMoney = new JLabel();
        txtMoney = new JTextField();
        internalFrame1 = new JInternalFrame();
        lbName2 = new JLabel();
        txtHP = new JTextField();
        lbname3 = new JLabel();
        txtMaxHP = new JTextField();
        lbname4 = new JLabel();
        txtAT = new JTextField();
        lbname5 = new JLabel();
        txtDF = new JTextField();
        lbname6 = new JLabel();
        txtMagic = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== menuBar1 ========
        {

            //======== file ========
            {
                file.setText("\u6587\u4ef6");

                //---- openFile ----
                openFile.setText("\u6253\u5f00filech1");
                openFile.addActionListener(e -> openFile(e));
                file.add(openFile);

                //---- saveFile ----
                saveFile.setText("\u4fdd\u5b58");
                saveFile.addActionListener(e -> saveFile(e));
                file.add(saveFile);
            }
            menuBar1.add(file);
        }
        setJMenuBar(menuBar1);

        //---- lbName ----
        lbName.setText("\u73a9\u5bb6\u540d");
        contentPane.add(lbName, "cell 1 1");
        contentPane.add(txtName, "cell 2 1,wmin 100,hmin 20");

        //---- btnSetGoods ----
        btnSetGoods.setText("\u7269\u54c1\u680f\u88c5\u6ee1\u9876\u7ea7\u86cb\u7cd5");
        btnSetGoods.setActionCommand("text");
        btnSetGoods.addActionListener(e -> btnSetGoods(e));
        contentPane.add(btnSetGoods, "cell 3 1");

        //---- lbMoney ----
        lbMoney.setText("\u91d1\u94b1");
        contentPane.add(lbMoney, "cell 1 2");
        contentPane.add(txtMoney, "cell 2 2");

        //======== internalFrame1 ========
        {
            internalFrame1.setBorder(new TitledBorder("text"));
            internalFrame1.setVisible(true);
            internalFrame1.setFrameIcon(null);
            Container internalFrame1ContentPane = internalFrame1.getContentPane();
            internalFrame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- lbName2 ----
            lbName2.setText("\u8840\u91cf");
            internalFrame1ContentPane.add(lbName2, "cell 1 0");
            internalFrame1ContentPane.add(txtHP, "cell 2 0,wmin 100,hmin 20");

            //---- lbname3 ----
            lbname3.setText("\u6700\u5927\u8840\u91cf");
            internalFrame1ContentPane.add(lbname3, "cell 1 1");
            internalFrame1ContentPane.add(txtMaxHP, "cell 2 1,wmin 100,hmin 20");

            //---- lbname4 ----
            lbname4.setText("\u653b\u51fb");
            internalFrame1ContentPane.add(lbname4, "cell 1 2");
            internalFrame1ContentPane.add(txtAT, "cell 2 2,wmin 100,hmin 20");

            //---- lbname5 ----
            lbname5.setText("\u9632\u5fa1");
            internalFrame1ContentPane.add(lbname5, "cell 1 3");
            internalFrame1ContentPane.add(txtDF, "cell 2 3,wmin 100,hmin 20");

            //---- lbname6 ----
            lbname6.setText("\u9b54\u529b");
            internalFrame1ContentPane.add(lbname6, "cell 1 4");
            internalFrame1ContentPane.add(txtMagic, "cell 2 4,wmin 100,hmin 20");
        }
        contentPane.add(internalFrame1, "cell 1 3 9 7");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        setSize(380, 320);
        setLocationRelativeTo(null);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu file;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JLabel lbName;
    private JTextField txtName;
    private JButton btnSetGoods;
    private JLabel lbMoney;
    private JTextField txtMoney;
    private JInternalFrame internalFrame1;
    private JLabel lbName2;
    private JTextField txtHP;
    private JLabel lbname3;
    private JTextField txtMaxHP;
    private JLabel lbname4;
    private JTextField txtAT;
    private JLabel lbname5;
    private JTextField txtDF;
    private JLabel lbname6;
    private JTextField txtMagic;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
