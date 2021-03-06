package com.ecommerce.shoppingwebsite.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
	@Table(name ="roles")
	public class Role {
	@Id
	
		@GeneratedValue(strategy =GenerationType.AUTO)
		private Integer id;
		
		@Column(nullable=false,unique =true)
		//@NotEmpty
		private String name;
		
		@ManyToMany(mappedBy="roles")
		private List<User>user;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<User> getUser() {
			return user;
		}

		public void setUser(List<User> user) {
			this.user = user;
		}
		
	}

	

	
	
 

