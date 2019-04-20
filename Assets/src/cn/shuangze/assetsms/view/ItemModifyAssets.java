package cn.shuangze.assetsms.view;

import cn.shuangze.assetsms.dao.*;
import cn.shuangze.assetsms.dao.impl.*;
import cn.shuangze.assetsms.entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
/**
 * 资产信息修改界面
 */
public class ItemModifyAssets extends JFrame implements ActionListener, ListSelectionListener {
    ItemTypeDao itemTypeDao;
    Container contentPane;
    //定义所用的面板
    JPanel onePanel = new JPanel();
    JPanel twoPanel = new JPanel();
    JPanel threePanel = new JPanel();
    
    //框架的大小
    Dimension faceSize = new Dimension(400, 400);
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
    JButton modifyAssets = new JButton(new ImageIcon("images\\preview.png"));

    DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
    DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
    
    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;
    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public ItemModifyAssets() {
        itemTypeDao = new ItemTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "资产信息修改错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {       
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产信息修改");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        //第一个面板的布局
        String[][] colValue = itemTypeDao.findAll();
        if (colValue == null) {
            colValue = new String[1][8];
        }
        String[] colName = {"资产编号", "资产名称", "所属类型","型号", "价格", "购买日期","状态", "备注"};
        tableModel = new DefaultTableModel(colValue, colName);
        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this);
        jScrollPane1 = new JScrollPane(jTable);
        jScrollPane1.setPreferredSize(new Dimension(600, 300));
        
        onePanel.add(jScrollPane1);
        modifyAssets.setText("修改");
        modifyAssets.setFont(new Font("Dialog", 0, 12));
        onePanel.add(modifyAssets);
        modifyAssets.addActionListener(this);
        modifyAssets.setEnabled(true);
        contentPane.add(onePanel,BorderLayout.NORTH);

        //第二个面板的布局
        jLabel1.setText("编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel1);
        twoPanel.add(jTextField1);

        jLabel2.setText("名称");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel2);
        twoPanel.add(jTextField2);

        jLabel3.setText("类型");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel3);
        twoPanel.add(jTextField3);
        
        jLabel4.setText("型号");
        jLabel4.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel4);
        twoPanel.add(jTextField4);
        
        contentPane.add(twoPanel,BorderLayout.CENTER);
        
        //第三个面板的布局
        jLabel5.setText("价格");
        jLabel5.setFont(new Font("Dialog", 0, 12));
        threePanel.add(jLabel5);
        threePanel.add(jTextField5);
        
        jLabel6.setText("日期");
        jLabel6.setFont(new Font("Dialog", 0, 12));
        dateChooser1.register(jTextField6);
        dateChooser2.register(jLabel6);
        threePanel.add(jLabel6);
        threePanel.add(jTextField6);
        jLabel6.setForeground(Color.BLACK);//设置文字的颜色（即前景色）
        jTextField6.setForeground(Color.BLACK);//设置文字的颜色（即前景色）
        
        jLabel7.setText("状态");
        jLabel7.setFont(new Font("Dialog", 0, 12));
        threePanel.add(jLabel7);
        threePanel.add(jTextField7);
        
        jLabel8.setText("备注");
        jLabel8.setFont(new Font("Dialog", 0, 12));
        threePanel.add(jLabel8);
        threePanel.add(jTextField8);
        
        contentPane.add(threePanel,BorderLayout.SOUTH);

        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == modifyAssets) {
            try {
                //修改
                itemTypeDao.modify(new ItemType(Integer.parseInt(jTextField1.getText()),jTextField2.getText(),Integer.parseInt(jTextField3.getText()),jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField7.getText(),jTextField8.getText()));
                JOptionPane.showMessageDialog(null, "资产信息修改成功！", "资产信息修改", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            ItemModifyAssets itemAdd = new ItemModifyAssets();
            itemAdd.pack();
            itemAdd.setVisible(true);
        } 
        jTable.revalidate();
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
        modifyAssets.setEnabled(true);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);
    }
}
