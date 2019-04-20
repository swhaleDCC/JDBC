package cn.shuangze.assetsms.dao;

import cn.shuangze.assetsms.entity.*;
import java.util.List;
/**
 * 用户信息的DAO设计模式
 */
public interface UsersDao {
    
    /**
     * 保存用户信息。
     * @param user 用户
     * @return 
     * @throws java.lang.Exception 
     */
    int add(Users user) throws Exception;
    int modify(Users user)throws Exception;
    List findAllName() throws Exception;
     /**
     * 获取指定用户名的用户
     * @param name 用户名
     * @return 用户
     * @throws java.lang.Exception
     */
    Users findNameUser(String name) throws Exception;
    
    /**
     * 获取指定名称的用户信息列表
     * @param name 用户名
     * @return 用户信息列表
     * @throws java.lang.Exception
     */
    String[][] findName(String name) throws Exception;

    /**
     * 获取所有的用户信息列表。   
     * @return 用户信息列表
     * @throws java.lang.Exception
     */
    String [][] findAll() throws Exception;

}
