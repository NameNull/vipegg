package vip.vipegg.model;

import vip.vipegg.Enum.ProductStatusEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yujie on 2017/8/17.
 * 招股金服
 */
@Entity
@Table(name = "admin")
public class Admin {
    private Integer id;
    private Integer telephone;
    private String password;
    private Date createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name="telephone")
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
