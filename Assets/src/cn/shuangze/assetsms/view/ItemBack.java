package cn.shuangze.assetsms.view;

import cn.shuangze.assetsms.dao.*;
import cn.shuangze.assetsms.dao.impl.*;
import cn.shuangze.assetsms.entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
/**
 * 资产归还界面
 */
public class ItemBack extends JFrame implements ActionListener, ListSelectionListener {
    ItemTypeDao itemTypeDao;//资产信息
    TrjnTypeDaoJDBCImpl assetsTrjn;//资产操作
    Container contentPane;
    //定义所用的面板
    JPanel onePanel = new JPanel();
    JPanel twoPanel = new JPanel();
    JPanel threePanel = new JPanel();
    DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
    DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
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
    JTextField jTextField3 = new JTextField(5);
    JTextField jTextField4 = new JTextField(5);
    JTextField jTextField5 = new JTextField(15);
    JTextField jTextField6 = new JTextField(15);
    JTextField jTextField7 = new JTextField(15);

    JButton backAssets = new JButton(new ImageIcon("images\\down.png"));

    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;
    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public ItemBack() {
        itemTypeDao = new ItemTypeDaoJDBCImpl();
        assetsTrjn=new TrjnTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "资产归还错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {  
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产归还");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        //第一个面板的布局
        jLabel8.setText("目前已领用资源：");
        jLabel8.setFont(new Font("Dialog", 0, 12));
        onePanel.add(jLabel8);
        
        String[][] colValue = itemTypeDao.findUsing();
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
        backAssets.setText("归还");
        backAssets.setFont(new Font("Dialog", 0, 12));
        onePanel.add(backAssets);
        backAssets.addActionListener(this);
        backAssets.setEnabled(true);

        contentPane.add(onePanel,BorderLayout.NORTH);

        //第二个面板的布局
        jLabel1.setText("编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel1);
        twoPanel.add(jTextField1);

        jLabel2.setText("操作类型");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel2);
        twoPanel.add(jTextField2);

        jLabel3.setText("资产编号");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel3);       
        twoPanel.add(jTextField3);
        
        jLabel4.setText("领用人");
        jLabel4.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(jLabel4);       
        twoPanel.add(jTextField4);
        
        contentPane.add(twoPanel,BorderLayout.CENTER);
        
        //第三个面板的布局
        jLabel5.setText("操作时间");
        jLabel5.setFont(new Font("Dialog", 0, 12));
        dateChooser1.register(jTextField5);
        dateChooser2.register(jLabel5);
        threePanel.add(jLabel5);
        threePanel.add(jTextField5);
        
        jLabel6.setText("用途");
        jLabel6.setFont(new Font("Dialog", 0, 12));
        threePanel.add(jLabel6);
        threePanel.add(jTextField6);
        
        jLabel7.setText("备注");
        jLabel7.setFont(new Font("Dialog", 0, 12));
        threePanel.add(jLabel7);
        threePanel.add(jTextField7);
        
        contentPane.add(threePanel,BorderLayout.SOUTH);

        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == backAssets) {
            try {
                //归还资产
                int i = JOptionPane.showConfirmDialog(null, "确定要归还吗?", "资产归还", JOptionPane.YES_NO_CANCEL_OPTION);//单击"确定"按钮,则返回值为0.
                if (i == 0) {
                    //assetsTrjn.delete(Integer.parseInt(jTextField1.getText()));
                    ItemType item=itemTypeDao.findAssetsItem(Integer.parseInt(jTextField3.getText()));
                    item.setStatus("可用");
                    itemTypeDao.modify(item);
                    assetsTrjn.add(new AssetsTrjn((String)jTextField2.getText(),Integer.parseInt(jTextField3.getText()),jTextField5.getText(),Integer.parseInt(jTextField4.getText()),jTextField6.getText(), jTextField7.getText()));
                    JOptionPane.showMessageDialog(null, "资产归还成功！", "资产归还", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "取消归还！", "资产归还", JOptionPane.INFORMATION_MESSAGE);
                }
                //assetsTrjn.add(new AssetsTrjn(jTextField2.getText(),Integer.parseInt(jTextField3.getText()),jTextField5.getText(),Integer.parseInt(jTextField4.getText()),jTextField6.getText(), jTextField7.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "资产归还", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            ItemBack itemBack = new ItemBack();
            itemBack.pack();
            itemBack.setVisible(true);
        } 
        jTable.revalidate();
    }

    //当表格被选中时的操作
    @Override
    public void valueChanged(ListSelectionEvent e){
        int selectedRow = jTable.getSelectedRow();
        try {
            AssetsTrjn back=assetsTrjn.findAssetsID(Integer.parseInt((String)jTable.getValueAt(selectedRow, 0)));
            jTextField1.setText(null);
            jTextField2.setText("归还");
            jTextField3.setText(back.getAssetsID()+"");
            jTextField4.setText(back.getPersonID()+"");
            jTextField5.setText(null);
            jTextField6.setText(null);
            jTextField7.setText(back.getOther());
            backAssets.setEnabled(true);
            jTextField1.setEditable(false);
            jTextField2.setEditable(false);
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
        } catch (Exception ex) {
            //Logger.getLogger(ItemBack.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "错误操作！", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
