package com.atguigu.dao.impl;

import com.atguigu.dao.DoctorDao;
import com.atguigu.pojo.Doctor;

import java.util.List;

public class DoctorDaoImpl extends BaseDao implements DoctorDao {
    @Override
    public int addBook(Doctor doctor) {

        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql, doctor.getName(), doctor.getAuthor(), doctor.getPrice(), doctor.getSales(), doctor.getStock(), doctor.getImgPath());

    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Doctor doctor) {

        System.out.println(" DoctorDaoImpl 程序在[" +Thread.currentThread().getName() + "]中");

        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, doctor.getName(), doctor.getAuthor(), doctor.getPrice(), doctor.getSales(), doctor.getStock(), doctor.getImgPath(), doctor.getId());
    }

    @Override
    public Doctor queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryForOne(Doctor.class, sql,id);
    }

    @Override
    public List<Doctor> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryForList(Doctor.class, sql);
    }


    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Doctor> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return queryForList(Doctor.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Doctor> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath " +
                "from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Doctor.class,sql,min,max,begin,pageSize);
    }
}
