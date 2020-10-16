package com.jie.test.service;
import org.springframework.stereotype.Service;
import com.jie.test.entity.Yuyue;
import java.util.List;
/**
 * (Yuyue)表服务接口
 *
 * @author makejava
 * @since 2020-10-15 14:24:32
 */
@Service
public interface YuyueService {

    List<Yuyue> queryAll(Yuyue yuyue);

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    Yuyue queryByName();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
//    List<Yuyue> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param yuyue 实例对象
     * @return 实例对象
     */
   Yuyue insert(Yuyue yuyue);

    /**
     * 修改数据
     *
     * @param yuyue 实例对象
     * @return 实例对象
     */
//    Yuyue update(Yuyue yuyue);

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
//    boolean deleteById();

}