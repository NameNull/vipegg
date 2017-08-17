package vip.vipegg.model;

import vip.vipegg.Enum.ProductStatusEnum;

import javax.persistence.*;

/**
 * Created by yujie on 2017/8/17.
 * 招股金服
 */
@Entity
@Table(name = "product")
public class Product {
    private Integer id;
    private String name;
    private String description;
    private String url;
    private Double price;
    private int num;
    private int buyNum;
    private ProductStatusEnum statusEnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Column(name = "buy_num")
    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    @Enumerated
    @Column(name = "status")
    public ProductStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(ProductStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
