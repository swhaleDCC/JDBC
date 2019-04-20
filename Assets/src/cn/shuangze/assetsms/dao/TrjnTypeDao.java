package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
import java.util.List;
/**
 * 资产管理的DAO设计模式
 */
public interface TrjnTypeDao {
    
    int add(AssetsTrjn trjnType) throws Exception;
    
    //int delete(int id) throws Exception;
     
     /**
     * 获取已借用的资产信息编号。   
     * @return 已借用的资产编号数组
     * @throws java.lang.Exception
     */
    List findID() throws Exception;
    
    /**
     * 获取所有的资产领用信息列表。   
     * @return 资产领用信息列表
     * @throws java.lang.Exception
     */
    String [][] findAll() throws Exception;
    String [][] findAll2() throws Exception;
    String [][] findAll3() throws Exception;
    /**
     * 获取指定编号的资产操作列表
     * @param id 编号
     * @return 资产信息列表
     * @throws java.lang.Exception
     */
    AssetsTrjn findAssetsID(int id) throws Exception;
}
