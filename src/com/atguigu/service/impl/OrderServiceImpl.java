package com.atguigu.service.impl;

import com.atguigu.dao.DoctorDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.DoctorDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private DoctorDao doctorDao = new DoctorDaoImpl();
    //挂号费用的结算订单和订单项一定是先有订单再有订单项的，否则这个订单项保存进去时需要的订单号外键就插入不进去了

    @Override
    public String createOrder(Cart cart, Integer userId) {

        System.out.println(" OrderServiceImpl 程序在[" +Thread.currentThread().getName() + "]中");

        // 订单号===唯一性
        //这里不能认为时间戳是唯一性的，例如双十一狂点的时候就会有很大可能是同一个时间
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderDao.saveOrder(order);

//        int i = 12 / 0;

        // 遍历签约信息中每一个医生项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个签约信息中的订单项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Doctor doctor = doctorDao.queryBookById(cartItem.getId());
            doctor.setSales( doctor.getSales() + cartItem.getCount() );
            doctor.setStock( doctor.getStock() - cartItem.getCount() );
            doctorDao.updateBook(doctor);

        }
        // 清空签约信息
        cart.clear();

        return orderId;
    }

}
