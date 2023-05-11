package com.atguigu.web;

import com.atguigu.pojo.Doctor;
import com.atguigu.pojo.Page;
import com.atguigu.service.DoctorService;
import com.atguigu.service.impl.DoctorServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DoctorServlet extends BaseServlet{

    private DoctorService doctorService = new DoctorServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Doctor> page = doctorService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/doctor_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/doctor_manager.jsp").forward(req,resp);
    }



    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //        1、获取请求的参数==封装成为Doctor对象
        Doctor doctor = WebUtils.copyParamToBean(req.getParameterMap(),new Doctor());
//        2、调用BookService.addDoctor()保存医生
        doctorService.addBook(doctor);
//        3、跳到图书列表页面
//                /manager/bookServlet?action=list
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }



    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数id，医生编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除医生
        doctorService.deleteBookById(id);
//        3、重定向回医生列表管理页面
//                /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为Doctor对象
        Doctor doctor = WebUtils.copyParamToBean(req.getParameterMap(),new Doctor());
//        2、调用DoctorService.updateDoctor( doctor );修改医生
        doctorService.updateBook(doctor);
//        3、重定向回医生列表管理页面
//        地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }



    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数医生编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2 调用bookService.queryBookById查询医生
        Doctor doctor = doctorService.queryBookById(id);
        //3 保存医生到Request域中
        req.setAttribute("book", doctor) ;
        //4 请求转发到pages/manager/doctor_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/doctor_edit.jsp").forward(req,resp);
    }



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过DoctorService查询全部医生
        List<Doctor> doctors = doctorService.queryBooks();
        //2 把全部医生保存到Request域中
        req.setAttribute("books", doctors);
        //3、请求转发到/pages/manager/doctor_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/doctor_manager.jsp").forward(req,resp);
    }




}
