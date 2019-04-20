package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
import java.util.List;
/**
 * 资产信息的DAO设计模式
 */
public interface ItemTypeDao {
    
    /**
     * 保存资产信息。
     * @param itemType 资产信息
     * @return 
     * @throws java.lang.Exception 
     */
     int add(ItemType itemType) throws Exception;
     
    /**
     * 删除资产信息。
     * @param id 资产信息编号
     * @return 
     * @throws java.lang.Exception 
     */
     int delete(int id) throws Exception;
     
    /**
     * 更新资产信息。
     * @return 
     * @throws java.lang.Exception 
     */
    int modify(ItemType itemType)throws Exception;
     
    /**
     * 获取指定编号的资产信息列表
     * @param id 编号
     * @return 资产信息列表
     * @throws java.lang.Exception
     */
    String[][] findAssetsID(int id) throws Exception;
    ItemType findAssetsItem(int id) throws Exception;

    /**
     * 获取所有的资产信息列表。   
     * @return 资产信息列表
     * @throws java.lang.Exception
     */
    String [][] findAll() throws Exception;
    
    /**
     * 获取所有的资产信息编号列表。   
     * @return 资产信息编号列表
     * @throws java.lang.Exception
     */
    List findAllID() throws Exception;
    int[] findAllIDs() throws Exception;
    
    /**
     * 获取可用资产信息编号。   
     * @return 可用资产编号数组
     * @throws java.lang.Exception
     */
    int [] findNoUsingID() throws Exception;
    
    /**
     * 获取可用资产信息列表。   
     * @return 可用资产信息列表
     * @throws java.lang.Exception
     */
    String [][] findNoUsingItem() throws Exception;
    
    /**
     * 获取已领用资产信息列表。   
     * @return 可用资产信息列表
     * @throws java.lang.Exception
     */
    String [][] findUsingItem() throws Exception;
    String[][] findUsing() throws Exception;
    int[] findBackID() throws Exception;
    String[][] findBack() throws Exception;
}
