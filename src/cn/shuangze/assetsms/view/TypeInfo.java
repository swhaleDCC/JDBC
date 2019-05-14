package cn.shuangze.assetsms.view;

import cn.shuangze.assetsms.dao.AssetsTypeDao;
import cn.shuangze.assetsms.dao.impl.AssetsTypeDaoJDBCImpl;
import cn.shuangze.assetsms.entity.AssetsType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
/**
 * 信息管理界面
 */
public class TypeInfo extends JFrame implements ActionListener, ListSelectionListener {
    AssetsTypeDao assetsTypeDao;
    Container contentPane;
    //定义所用的面板
    JPanel upPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel centerPanel1 = new JPanel();
    JPanel centerPanel2 = new JPanel();
    JPanel downPanel = new JPanel();
    //框架的大小
    Dimension faceSize = new Dimension(800, 600);
    //定义图形界面元素
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JTextField jTextField1 = new JTextField(15);
    JTextField jTextField2 = new JTextField(15);
    JTextField jTextField3 = new JTextField(15);
    JTextField jTextField4 = new JTextField(15);
    JTextField jTextField5 = new JTextField(15);
    JTextField jTextField6 = new JTextField(15);
    JTextField jTextField7 = new JTextField(15);
    JTextField jTextField8 = new JTextField(15);
    JButton addInfo = new JButton(new ImageIcon("images\\save.png"));
    JButton modifyInfo = new JButton(new ImageIcon("images\\save.png"));
    JButton deleteInfo = new JButton(new ImageIcon("images\\delete.png"));
    JButton clearInfo = new JButton(new ImageIcon("images\\delete.png"));
    JButton saveInfo = new JButton(new ImageIcon("images\\delete.png"));
    JButton eixtInfo = new JButton(new ImageIcon("images\\preview.png"));

    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;
    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public TypeInfo() {
        assetsTypeDao = new AssetsTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("基本信息管理");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        //上部面板的布局
        String[][] colValue = assetsTypeDao.findAll();
        if (colValue == null) {
            colValue = new String[1][8];
        }
        String[] colName = {"生物编号", "中文学名", "拉丁名","分类信息", "生物学特征", "生态分布","文献信息","备注"};
        tableModel = new DefaultTableModel(colValue, colName);
        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(600, 300));
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this);
        jScrollPane1 = new JScrollPane(jTable);
        jScrollPane1.setPreferredSize(new Dimension(600, 300));

        upPanel.add(jScrollPane1);
        contentPane.add(upPanel, BorderLayout.NORTH);

        //中部面板的布局
        jLabel1.setText("生物编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        centerPanel1.add(jLabel1);
        centerPanel1.add(jTextField1);

        jLabel2.setText("中文学名");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        centerPanel1.add(jLabel2);
        centerPanel1.add(jTextField2);

        jLabel3.setText("拉 丁 名");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        centerPanel1.add(jLabel3);
        centerPanel1.add(jTextField3);
        
        jLabel4.setText("分类信息");
        jLabel4.setFont(new Font("Dialog", 0, 12));
        centerPanel1.add(jLabel4);
        centerPanel1.add(jTextField4);
        
        jLabel5.setText("生物学特征");
        jLabel5.setFont(new Font("Dialog", 0, 12));
        centerPanel2.add(jLabel5);
        centerPanel2.add(jTextField5);

        jLabel6.setText("生态分布");
        jLabel6.setFont(new Font("Dialog", 0, 12));
        centerPanel2.add(jLabel6);
        centerPanel2.add(jTextField6);

        jLabel7.setText("文献信息");
        jLabel7.setFont(new Font("Dialog", 0, 12));
        centerPanel2.add(jLabel7);
        centerPanel2.add(jTextField7);

        jLabel8.setText("备   注");
        jLabel8.setFont(new Font("Dialog", 0, 12));
        centerPanel2.add(jLabel8);
        centerPanel2.add(jTextField8);
        
        centerPanel.add(centerPanel1,BorderLayout.NORTH);
        centerPanel.add(centerPanel2,BorderLayout.SOUTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);
        
        //下部面板的布局
        addInfo.setText("增加");
        addInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(addInfo);
        
        modifyInfo.setText("修改");
        modifyInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(modifyInfo);
        
        deleteInfo.setText("删除");
        deleteInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(deleteInfo);
        
        clearInfo.setText("重置");
        clearInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(clearInfo);
        
        eixtInfo.setText("退出");
        eixtInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(eixtInfo);

        contentPane.add(downPanel, BorderLayout.SOUTH);

        //添加事件侦听
        addInfo.addActionListener(this);
        modifyInfo.addActionListener(this);
        deleteInfo.addActionListener(this);
        clearInfo.addActionListener(this);
        eixtInfo.addActionListener(this);

        addInfo.setEnabled(true);
        modifyInfo.setEnabled(false);
        deleteInfo.setEnabled(false);
        clearInfo.setEnabled(true);
    }
    
    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == addInfo) {
            try {
                //增加
                if(jTextField2.getText()==null || jTextField3.getText()==null || jTextField4.getText()==null || jTextField5.getText()==null || jTextField6.getText()==null ||jTextField2.getText().equals(" ") || jTextField3.getText().equals(" ") || jTextField4.getText().equals(" ") || jTextField5.getText().equals(" ") || jTextField6.getText().equals(" "))
                    JOptionPane.showMessageDialog(null, "请填写完整！", "警告", JOptionPane.INFORMATION_MESSAGE);
                else{
                    assetsTypeDao.add(new AssetsType(jTextField2.getText(), jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField7.getText(),jTextField8.getText()));
                    JOptionPane.showMessageDialog(null, "添加成功！", "添加", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            TypeInfo typeMan = new TypeInfo();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == modifyInfo) {
            try {
                //修改
                assetsTypeDao.modify(new AssetsType(Integer.parseInt(jTextField1.getText()), jTextField2.getText(), jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField7.getText(),jTextField8.getText()));
                JOptionPane.showMessageDialog(null, "修改成功！", "修改", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            TypeInfo typeMan = new TypeInfo();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == deleteInfo) {
            int rowcount = tableModel.getRowCount() - 1;//getRowCount返回行数，rowcount<0代表已经没有任何行了。 
            if (rowcount >= 0) {
                try {
                    //删除
                    int i = JOptionPane.showConfirmDialog(null, "确定要删除吗?", null, JOptionPane.YES_NO_CANCEL_OPTION);//单击"确定"按钮,则返回值为0.
                    if (i == 0) {
                        //tableModel.removeRow(jTable.getSelectedRow());
                        //tableModel.setRowCount(rowcount);//删除行比较简单，只要用DefaultTableModel的removeRow()方法即可。删除行完毕后必须重新设置行数，也就是使用DefaultTableModel的setRowCount()方法来设置当前行。
                        assetsTypeDao.delete(Integer.parseInt(jTextField1.getText()));
                    }
                    JOptionPane.showMessageDialog(null, "资产类别删除成功！", "资产类别删除", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                this.dispose();
                TypeInfo typeMan = new TypeInfo();
                typeMan.pack();
                typeMan.setVisible(true);
            }
        } else if (obj == clearInfo) { //清空
            setNull();
        } else if (obj == eixtInfo) { //退出
            this.dispose();
        }
        jTable.revalidate();
    }
    
    //将文本框清空
    void setNull() {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);
        addInfo.setEnabled(true);
        modifyInfo.setEnabled(false);
        deleteInfo.setEnabled(false);
        clearInfo.setEnabled(true);
    }

    //当表格被选中时的操作
    public void valueChanged(ListSelectionEvent lse) {
        int selectedRow = jTable.getSelectedRow();
        jTextField1.setText((String) jTable.getValueAt(selectedRow, 0));
        jTextField2.setText((String) jTable.getValueAt(selectedRow, 1));
        jTextField3.setText((String) jTable.getValueAt(selectedRow, 2));
        jTextField4.setText((String) jTable.getValueAt(selectedRow, 3));
        jTextField5.setText((String) jTable.getValueAt(selectedRow, 4));
        jTextField6.setText((String) jTable.getValueAt(selectedRow, 5));
        jTextField7.setText((String) jTable.getValueAt(selectedRow, 6));
        jTextField8.setText((String) jTable.getValueAt(selectedRow, 7));
        
        //设置是否可操作
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);

        addInfo.setEnabled(false);
        modifyInfo.setEnabled(true);
        deleteInfo.setEnabled(true);
        clearInfo.setEnabled(true);
    }
}
