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
 * 资产类别管理界面
 */
public class TypeInfo extends JFrame implements ActionListener, ListSelectionListener {
    AssetsTypeDao assetsTypeDao;
    Container contentPane;
    //定义所用的面板
    JPanel upPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel downPanel = new JPanel();
    //框架的大小
    Dimension faceSize = new Dimension(400, 400);
    //定义图形界面元素
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField(15);
    JTextField jTextField2 = new JTextField(15);
    JTextField jTextField3 = new JTextField(15);
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
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产类别管理");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        //中部面板的布局
        String[][] colValue = assetsTypeDao.findAll();
        if (colValue == null) {
            colValue = new String[1][3];
        }
        String[] colName = {"资产类别编号", "资产大类", "资产小类"};
        tableModel = new DefaultTableModel(colValue, colName);
        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(400, 300));
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this);
        jScrollPane1 = new JScrollPane(jTable);
        jScrollPane1.setPreferredSize(new Dimension(400, 300));

        upPanel.add(jScrollPane1);
        contentPane.add(upPanel, BorderLayout.NORTH);

        jLabel1.setText("编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        centerPanel.add(jLabel1);
        centerPanel.add(jTextField1);

        jLabel2.setText("大类");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        centerPanel.add(jLabel2);
        centerPanel.add(jTextField2);

        jLabel3.setText("小类");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        centerPanel.add(jLabel3);
        centerPanel.add(jTextField3);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
    }

    //下部面板的布局
    public void downInit() {
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
                assetsTypeDao.add(new AssetsType(jTextField2.getText(), jTextField3.getText()));
                JOptionPane.showMessageDialog(null, "资产类别添加成功！", "资产类别添加", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            TypeInfo typeMan = new TypeInfo();
            typeMan.downInit();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == modifyInfo) {
            try {
                //修改
                assetsTypeDao.modify(new AssetsType(Integer.parseInt(jTextField1.getText()), jTextField2.getText(), jTextField3.getText()));
                JOptionPane.showMessageDialog(null, "资产类别修改成功！", "资产类别修改", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            TypeInfo typeMan = new TypeInfo();
            typeMan.downInit();
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
                typeMan.downInit();
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
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
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
        //设置是否可操作
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);

        addInfo.setEnabled(false);
        modifyInfo.setEnabled(true);
        deleteInfo.setEnabled(true);
        clearInfo.setEnabled(true);
    }
}
