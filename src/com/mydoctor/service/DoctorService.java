package com.atguigu.service;

import com.atguigu.pojo.Doctor;
import com.atguigu.pojo.Page;

import java.util.List;

public interface DoctorService {

    public void addBook(Doctor doctor);

    public void deleteBookById(Integer id);

    public void updateBook(Doctor doctor);

    public Doctor queryBookById(Integer id);

    public List<Doctor> queryBooks();

    Page<Doctor> page(int pageNo, int pageSize);

    Page<Doctor> pageByPrice(int pageNo, int pageSize, int min, int max);
}
