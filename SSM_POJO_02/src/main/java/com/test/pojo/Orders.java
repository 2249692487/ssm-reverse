package com.test.pojo;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */
public class Orders {
    private Long id;
    private String orderNum;
    private String orderTime;
    private String peopleCount;
    private String orderDesc;
    private String payType; // 支付方式: 0 支付宝 ; 1 微信; 2 其他
    private String orderStatus; // 支付状态: 0 未支付 1 已支付
    private Product product; // 因为一个订单 只能 对应一个商品

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", peopleCount='" + peopleCount + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType='" + payType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", product=" + product +
                '}';
    }
}
