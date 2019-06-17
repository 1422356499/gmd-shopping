package com.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * USERS锟斤拷锟接︼拷锟绞碉拷锟斤拷锟�,锟斤拷锟节凤拷装USERS锟斤拷锟斤拷一锟斤拷锟矫伙拷锟斤拷息
 * @author 锟斤拷锟斤拷锟斤拷
 *
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users implements java.io.Serializable {

	
	private static final long serialVersionUID = 2504015899170623862L;

	/**
	 * 	锟矫伙拷Id
	 */
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	/**
	 * 	锟矫伙拷锟斤拷锟斤拷
	 */
	@Column(name="user_name")
	private String userName;

	/**
	 * 	锟矫伙拷锟斤拷锟斤拷
	 */
	@Column(name="user_psw")
	private String userPsw;

	/**
	 * 	锟矫伙拷锟皆憋拷0锟斤拷 1女
	 */
	@Column(name="user_sex")
	private Integer userSex;

	/**
	 * 	锟斤拷锟街わ拷锟�
	 */
	@Column(name="user_idnum")
	private String userIdnum;

	/**
	 * 	锟斤拷系锟界话
	 */
	@Column(name="user_tel")
	private String userTel;

	/**
	 * 	锟斤拷锟斤拷锟斤拷锟斤拷
	 */
	@Column(name="user_birthday")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBirthday;

	/**
	 * 	锟矫伙拷锟斤拷锟斤拷
	 */
	@Column(name="user_email")
	private String userEmail;

	/**
	 * 	锟矫伙拷头锟斤拷
	 */
	@Column(name="user_image")
	private String userImage;

	/**
	 * 	权锟睫憋拷锟�
	 */
	@Column(name="permission_id")
	private Integer permissionId;

	/**
	 *	 锟秸伙拷锟斤拷址
	 */
	@Column(name="user_addr")
	private String userAddr;

	/**
	 * 	状态锟斤拷0锟斤拷锟斤拷 1锟斤拷锟斤拷
	 */
	@Column(name="user_status")
	private Integer userStatus;

}
