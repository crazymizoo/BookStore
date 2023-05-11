package com.atguigu.dao;

import com.atguigu.pojo.Doctor;

import java.util.List;

public interface DoctorDao {

    public int addBook(Doctor doctor);

    public int deleteBookById(Integer id);

    public int updateBook(Doctor doctor);

    public Doctor queryBookById(Integer id);

    public List<Doctor> queryBooks();

    Integer queryForPageTotalCount();

    List<Doctor> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Doctor> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
