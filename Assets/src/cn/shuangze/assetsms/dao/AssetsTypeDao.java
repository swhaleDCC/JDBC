package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
import java.util.*;
/**
 * 资产管理的DAO设计模式
 */
public interface AssetsTypeDao {
    
    /**
     * 保存资产类型。
     * @param assetsType 资产类型
     * @return 
     * @throws java.lang.Exception 
     */
     int add(AssetsType assetsType) throws Exception;
     
    /**
     * 删除资产类型。
     * @param id 资产类型编号
     * @return 
     * @throws java.lang.Exception 
     */
     int delete(int id) throws Exception;
     
    /**
     * 更新资产类型。
     * @param assetsType 资产类型
     * @return 
     * @throws java.lang.Exception 
     */
    int modify(AssetsType assetsType)throws Exception;
     
    /**
     * 获取指定资产大类的资产类型列表。
     * @param bType 昵称
     * @return 资产类型列表
     * @throws java.lang.Exception
     */
    List<AssetsType> findByBigType(String bType) throws Exception;
    
    /**
     * 获取指定资产小类的资产类型。
     * @param sType 资产类型类型
     * @return 资产类型
     * @throws java.lang.Exception
     */
    AssetsType findBySmallType(String sType)throws Exception;
    
    /**
     * 获取所有的资产类型列表。   
     * @return 资产类型列表
     * @throws java.lang.Exception
     */
    String [][] findAll() throws Exception;
    
    /**
     * 获取所有的资产类型编号。   
     * @return 资产类型编号数组
     * @throws java.lang.Exception
     */
    int [] findAllID() throws Exception;
    
    AssetsType findById(int id) throws Exception;
}
