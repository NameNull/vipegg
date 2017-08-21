package vip.vipegg.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "security")
public class Security implements java.io.Serializable {
	private Integer id;
	private Security security;
	private String description;
	private String name;
	private Integer priority;
	private String url;
	private Set<Security> securities = new HashSet(0);
	private Set<RoleSecurity> roleSecurities = new HashSet(0);

	@GenericGenerator(name = "generator", strategy = "native")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer fid) {
		this.id = fid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Security getSecurity() {
		return this.security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	@Column()
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column()
	public Integer getpriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "security")
	@OrderBy("priority ASC")
	public Set<Security> getSecurities() {
		return this.securities;
	}

	public void setSecurities(Set<Security> securities) {
		this.securities = securities;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "security")
	public Set<RoleSecurity> getRoleSecurities() {
		return this.roleSecurities;
	}

	public void setRoleSecurities(Set<RoleSecurity> roleSecurities) {
		this.roleSecurities = roleSecurities;
	}
	
	@Column()
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}