package vip.vipegg.model;

import org.hibernate.annotations.GenericGenerator;
import vip.vipegg.util.Utils;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "count_limit")
public class CountLimit implements java.io.Serializable {

	private int id;
	private String ip;
	private Timestamp createTime;
	private int count;

	public CountLimit(){}

	public CountLimit(Integer count, String ip){
		this.count = count;
		this.ip = ip;
		this.createTime = Utils.getTimestamp();
	}

	@GenericGenerator(name = "generator", strategy = "native")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 64)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column()
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column()
	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}