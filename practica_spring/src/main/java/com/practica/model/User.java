package com.practica.model;

import javax.persistence.Table;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.practica.model.Authority;

@Entity
@Table(name="users")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column
private String username;

@Column
private String password;

@Column
private boolean enabled;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name="authorities_users",
joinColumns=@JoinColumn(name="usuario_id"),
inverseJoinColumns=@JoinColumn(name="authority_id"))
private Set<Authority> authority;




	/**
	* Returns value of id
	* @return
	*/
	public Long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Long id) {
		this.id = id;
	}

	/**
	* Returns value of username
	* @return
	*/
	public String getUsername() {
		return username;
	}

	/**
	* Sets new value of username
	* @param
	*/
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	* Returns value of password
	* @return
	*/
	public String getPassword() {
		return password;
	}

	/**
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	* Returns value of enabled
	* @return
	*/
	public boolean isEnabled() {
		return enabled;
	}

	/**
	* Sets new value of enabled
	* @param
	*/
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	* Returns value of authority
	* @return
	*/
	public Set<Authority> getAuthority() {
		return authority;
	}

	/**
	* Sets new value of authority
	* @param
	*/
	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", username=" + username + ",password=" + password + " ]" ;
	}
}
