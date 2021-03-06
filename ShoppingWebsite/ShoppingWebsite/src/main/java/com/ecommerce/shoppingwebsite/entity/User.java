package com.ecommerce.shoppingwebsite.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@NotEmpty
	@Column(nullable = false)
	private String firstName;
	
	private String lastname;
	
	@Column(nullable =false, unique =true)
	//@NotEmpty
	//@Email(message ="{errors.invalid_email}")
	private String email;
		
		
		private String password;
	@ManyToMany(cascade =CascadeType.MERGE,fetch= FetchType.EAGER)
	
	@JoinTable(
			name="user_role",
			joinColumns= { @JoinColumn(name ="USER_ID", referencedColumnName ="ID")},
			inverseJoinColumns= @JoinColumn(name="ROLE_ID",referencedColumnName="ID"))
	
			
	private List<Role>roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(Integer id, String firstName, String lastname, String email, String password, List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + "]";
	}
	
	public User(User user )
	{
		this.firstName=user.getFirstName();
		this.lastname=user.getLastname();
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.roles=user.getRoles();
	}
    public User(){
	
}
}
