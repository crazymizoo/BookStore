package com.atguigu.web;

import com.atguigu.pojo.Doctor;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.DoctorService;
import com.atguigu.service.impl.DoctorServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    /**
     * 修改医生数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取请求的参数 医生编号 、医生数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        // 获取Cart签约信息对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            // 修改医生数量
            cart.updateCount(id,count);
            // 重定向回原来签约信息展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空签约信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 1 获取签约信息对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 清空签约信息
            cart.clear();
            // 重定向回原来签约信息展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /**
     * 删除签约信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取医生编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 获取签约信息对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            // 删除签约信息医生项
            cart.deleteItem(id);
            // 重定向回原来签约信息展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }



    /**
     * 加入签约信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 医生编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用doctorService.queryDoctorkById(id):Doctork得到图书的信息
        Doctor doctor = doctorService.queryBookById(id);
        // 把医生信息，转换成为CartItem医生项
        CartItem cartItem = new CartItem(doctor.getId(), doctor.getName(),1, doctor.getPrice(), doctor.getPrice());
        // 调用Cart.addItem(CartItem);添加医生项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        System.out.println("请求头Referer的值：" + req.getHeader("Referer"));
        // 最后一个添加的医生名称
        req.getSession().setAttribute("lastName", cartItem.getName());

        // 重定向回原来医生所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 医生编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用doctorService.queryDoctorById(id):Doctor得到图书的信息
        Doctor doctor = doctorService.queryBookById(id);
        // 把医生信息，转换成为CartItem医生项
        CartItem cartItem = new CartItem(doctor.getId(), doctor.getName(),1, doctor.getPrice(), doctor.getPrice());
        // 调用Cart.addItem(CartItem);添加医生项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        // 最后一个添加的医生名称
        req.getSession().setAttribute("lastName", cartItem.getName());

        //6、返回签约信息总的医生数量和最后一个添加的医生名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);

    }





}
