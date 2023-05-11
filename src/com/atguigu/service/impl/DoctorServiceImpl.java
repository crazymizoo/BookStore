package com.atguigu.service.impl;

import com.atguigu.dao.DoctorDao;
import com.atguigu.dao.impl.DoctorDaoImpl;
import com.atguigu.pojo.Doctor;
import com.atguigu.pojo.Page;
import com.atguigu.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDao = new DoctorDaoImpl();

    @Override
    public void addBook(Doctor doctor) {
        doctorDao.addBook(doctor);
    }

    @Override
    public void deleteBookById(Integer id) {
        doctorDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Doctor doctor) {
        doctorDao.updateBook(doctor);
    }

    @Override
    public Doctor queryBookById(Integer id) {
        return doctorDao.queryBookById(id);
    }

    @Override
    public List<Doctor> queryBooks() {
        return doctorDao.queryBooks();
    }

    @Override
    public Page<Doctor> page(int pageNo, int pageSize) {
        Page<Doctor> page = new Page<Doctor>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = doctorDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Doctor> items = doctorDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Doctor> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Doctor> page = new Page<Doctor>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = doctorDao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Doctor> items = doctorDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
