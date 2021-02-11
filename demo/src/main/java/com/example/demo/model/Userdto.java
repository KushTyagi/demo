package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.dao.User;


public class Userdto {
       
	   
		private long userid;
	    @NotBlank(message = "Name is mandatory")
		private String name;
	    @NotBlank(message = "phoneno is mandatory")
	    private String phoneno;
	    @NotBlank(message = "email is mandatory")
	    private String email;
	    @NotBlank(message = "password is mandatory")
	    private String password;
	    private List list; 
	    
		
		public long getUserid() {
			return userid;
		}
		public void setUserid(long userid) {
			this.userid = userid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
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
		
		
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
		@Override
		public String toString() {
			return "Userdto [userid=" + userid + ", name=" + name + ", phoneno=" + phoneno + ", email=" + email
					+ ", password=" + password + ", list=" + list + "]";
		}
}
