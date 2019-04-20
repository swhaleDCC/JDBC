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
 * 按编号查找人员信息界面
 */
public class PersonSelectAssets extends JFrame implements ActionListener, ListSelectionListener {
    PersonTypeDao personTypeDao;
    Container contentPane;
    //定义所用的面板
    JPanel jPanel = new JPanel();
    
    //框架的大小
    Dimension faceSize = new Dimension(400,400);

    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;
    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public PersonSelectAssets() {
        personTypeDao = new PersonTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "人员信息查找错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {       
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("人员信息汇总");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        //面板的布局
        String[][] colValue = personTypeDao.findAll();
        if (colValue == null) {
            colValue = new String[1][6];
        }
        String[] colName = {"人员编号", "姓名", "性别","部门", "职位","其他"};
        tableModel = new DefaultTableModel(colValue, colName);
        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this);
        jScrollPane1 = new JScrollPane(jTable);
        jScrollPane1.setPreferredSize(new Dimension(600,300));
        
        jPanel.add(jScrollPane1);
        contentPane.add(jPanel,BorderLayout.NORTH);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
    }

    //当表格被选中时的操作
    public void valueChanged(ListSelectionEvent lse) {
        JOptionPane.showMessageDialog(null, "无法选中！", "人员信息增加", JOptionPane.INFORMATION_MESSAGE);
    }
}
