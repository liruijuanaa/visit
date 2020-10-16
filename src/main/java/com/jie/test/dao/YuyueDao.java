package com.jie.test.dao;

import java.util.List;
import com.jie.test.entity.Yuyue;
/**
 * (Yuyue)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 14:24:23
 */

public interface YuyueDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    Yuyue queryByName();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
//    List<Yuyue> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yuyue 实例对象
     * @return 对象列表
     */
    List<Yuyue> queryAll(Yuyue yuyue);

    /**
     * 新增数据
     *
     * @param yuyue 实例对象
     * @return 影响行数
     */
    int insert(Yuyue yuyue);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Yuyue> 实例对象列表
     * @return 影响行数
     */
//    int insertBatch(@Param("entities") List<Yuyue> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Yuyue> 实例对象列表
     * @return 影响行数
     */
//    int insertOrUpdateBatch(@Param("entities") List<Yuyue> entities);

    /**
     * 修改数据
     *
     * @param yuyue 实例对象
     * @return 影响行数
     */
//    int update(Yuyue yuyue);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
//    int deleteById();

}