package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
import java.util.*;
/**
 * 资产管理的DAO设计模式
 */
public interface AssetsTypeDao {

     int add(AssetsType assetsType) throws Exception;
 
     int delete(int id) throws Exception;

    int modify(AssetsType assetsType)throws Exception;

    String [][] findAll() throws Exception;

    int [] findAllID() throws Exception;
    
    AssetsType findById(int id) throws Exception;
}
