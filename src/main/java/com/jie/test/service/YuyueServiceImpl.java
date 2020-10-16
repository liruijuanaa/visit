package com.jie.test.service;

import org.springframework.stereotype.Service;
import com.jie.test.entity.Yuyue;
import javax.annotation.Resource;
import java.util.List;

import com.jie.test.dao.YuyueDao;
/**
 * (Yuyue)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 14:24:34
 */
@Service("yuyueService")
public class YuyueServiceImpl implements YuyueService {
    @Resource
    private YuyueDao yuyueDao;

    @Override
    public List<Yuyue> queryAll(Yuyue yuyue) {
       return this.yuyueDao.queryAll(yuyue);
    }

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public Yuyue queryByName() {
        return this.yuyueDao.queryByName();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
//    @Override
//    public List<Yuyue> queryAllByLimit(int offset, int limit) {
//        return this.yuyueDao.queryAllByLimit(offset, limit);
//    }

    /**
     * 新增数据
     *
     * @param yuyue 实例对象
     * @return 实例对象
     */
    @Override
    public Yuyue insert(Yuyue yuyue) {
        this.yuyueDao.insert(yuyue);
        return yuyue;
    }

    /**
     * 修改数据
     *
     * @param yuyue 实例对象
     * @return 实例对象
     */
//    @Override
//    public Yuyue update(Yuyue yuyue) {
//        this.yuyueDao.update(yuyue);
//        return this.queryById();
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById() {
//        return this.yuyueDao.deleteById() > 0;
//    }
}