package vip.vipegg.model;

import vip.vipegg.Enum.AdminStatusEnum;
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
    private String name;
    private AdminStatusEnum statusEnum;
    private Role role;

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

    @Column()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne()
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Enumerated
    @Column(name = "status")
    public AdminStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(AdminStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
