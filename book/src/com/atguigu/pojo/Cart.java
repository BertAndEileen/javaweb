package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    /**
     * 购物车中的商品信息 <br>
     *  key是商品编号 <br/>
     *  value是商品信息CartItem <br/>
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();


    /**
     * 购物车添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        // 先看看购物车中有没有添加的商品项
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 原来没添加过这个商品
            items.put(cartItem.getId(),cartItem);
        } else {
            // 修改商品数量
            item.setCount( item.getCount()+1 );
            //　修改商品项的总金额
            item.setTotalPrice( item.getPrice().multiply( new BigDecimal(item.getCount())) );
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id    商品的编号
     * @param count 新的数量
     */
    public void updateCount(Integer id,Integer count){
        // 获取出商品项
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            // 修改商品数量
            cartItem.setCount( count );
            //　修改商品项的总金额
            cartItem.setTotalPrice( cartItem.getPrice().multiply( new BigDecimal(cartItem.getCount())) );
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (CartItem cartItem : items.values()) {
            totalCount += cartItem.getCount();
        }

        return totalCount;
    }

    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = new BigDecimal(0);

        for (CartItem cartItem : items.values()) {
            totalPrice = totalPrice.add( cartItem.getTotalPrice() );
        }

        return totalPrice;

    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
