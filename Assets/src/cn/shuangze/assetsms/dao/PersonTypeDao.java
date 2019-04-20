package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
/**
 * 人员信息的DAO设计模式
 */
public interface PersonTypeDao {
    
    /**
     * 保存人员信息。
     * @param personType 人员信息
     * @return 
     * @throws java.lang.Exception 
     */
     int add(PersonType personType) throws Exception;
     
    /**
     * 删除人员信息。
     * @param id 人员信息编号
     * @return 
     * @throws java.lang.Exception 
     */
     int delete(int id) throws Exception;
     
    /**
     * 更新人员信息。
     * @param assetsType 人员信息
     * @return 
     * @throws java.lang.Exception 
     */
    int modify(PersonType personType)throws Exception;
     
    /**
     * 获取指定编号的人员信息列表
     * @param id 编号
     * @return 人员信息列表
     * @throws java.lang.Exception
     */
    String[][] findAssetsID(int id) throws Exception;
    PersonType findAssetsItem(int id) throws Exception;

    /**
     * 获取所有的人员信息列表。   
     * @return 人员信息列表
     * @throws java.lang.Exception
     */
    String [][] findAll() throws Exception;
    
    /**
     * 获取所有的人员信息编号。   
     * @return 人员信息编号数组
     * @throws java.lang.Exception
     */
    int [] findID() throws Exception;
}
