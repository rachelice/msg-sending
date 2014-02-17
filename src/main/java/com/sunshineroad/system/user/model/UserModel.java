package com.sunshineroad.system.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;

import com.sunshineroad.framework.support.entity.BaseEntity;
import com.sunshineroad.system.nxbranch.entity.Nxbranch;
import com.sunshineroad.system.role.entity.Role;


/**
 * user:users
 * Date: 
 * Version: 1.0
 */

@Entity 
@Table(name = "SYS_USER")
public class UserModel extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	@ManyToMany(targetEntity=Role.class,fetch=FetchType.LAZY)
	@JoinTable(name="SYS_USER_ROLE",joinColumns=@JoinColumn(name = "USER_ID"),inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@Fetch(FetchMode.SUBSELECT)
	private List<Role> roles;

/*	@ManyToMany(targetEntity=Dept.class,fetch=FetchType.LAZY)
	@JoinTable(name="SYS_USER_DEPT",joinColumns=@JoinColumn(name = "USER_ID"),inverseJoinColumns = @JoinColumn(name = "DEPT_ID"))
	@Fetch(FetchMode.SUBSELECT)
	private List<Dept> depts;*/
	
    @Id
	//@SequenceGenerator(name = "generator",sequenceName="TLM_USER_ITEM_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "user_id", nullable = false)
    private int id;
    
	@Column(name="USER_NAME")
    private String username;
    
/*    @NotEmpty(message = "{email.illegal}")*/
    @Email(message = "{email.illegal}") //错误消息会自动到MessageSource中查找
	@Column(name="email")
    private String email;
    
	@Column(name="PASS_WORD")
    @Pattern(regexp = "[A-Za-z0-9]{0,50}", message = "{password.illegal}") 
    private String password;

	@Column(name="LOGIN_NAME")
    @Pattern(regexp = "[A-Za-z0-9]{3,20}", message = "{loginName.illegal}") //java validator验证（用户名字母数字组成，长度为3-20）
	private String loginName;  
	 
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY )
	@JoinColumn(name="BRCCODE", referencedColumnName="BRCCODE")
	private Nxbranch nxbranch;
 
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
  /*  @DateFormat( message="{register.date.error}")//自定义的验证器
    @Column(name = "last_Login_Time", nullable = false)
    private Date lastLoginTime;
    
    


	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
*/

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
/*    public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}*/

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	public Nxbranch getNxbranch() {
		return nxbranch;
	}

	public void setNxbranch(Nxbranch nxbranch) {
		this.nxbranch = nxbranch;
	}
    
    
    
}
