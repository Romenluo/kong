package com.li.kong.dao;

import com.li.kong.exception.DaoException;

import java.util.List;

/**
 * Dao 层次的最顶层接口
 * @param <E> 实体类类型
 * @param <K> 对象标识符的类型(对应的是数据库中的主键)
 */
public interface Dao<E,K> {
    /** 保存一个对象 到数据库中去 */
    K save(E o) throws DaoException;

    /** 根据 主键 ( 对象标识符 ) 删除一条记录 */
    boolean delete(K id) throws DaoException ;

    /** 根据对象标识符(对应数据库主键)修改一条记录( 通过 参数传入的对象的属性值来指定数据库中各个列的值 )*/
    boolean update(E e) throws DaoException ;

    /** 根据主键返回一条记录并包装成 E 类型的对象*/
    E find(K id) throws DaoException ;

    /** 根据条件返回一条记录并包装成 E 类型的对象*/
    E load(E e) throws DaoException ;


    /** 根据字符串返回一条记录并包装成 E 类型的对象*/
    List<E> loadList(E e) throws DaoException ;

    /** 查询数据库中的所有记录并将返回的结果集包装成 List 集合*/
    List<E> findAll() throws DaoException ;

}
