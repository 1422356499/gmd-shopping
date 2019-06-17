package com.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 持久化层: 定义对USERS表进行操作的方法
 * 
 * @author 吴榕兴
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

	/**
	 * 判断吗用户登录是否成功
	 * 
	 * @param userId       用户编号
	 * @param user_psw     用户密码
	 * @param permissionId 权限编号
	 * @return 成功返回登录用户 完整信息,失败返回null
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userPsw,u.userSex,u.userIdnum,u.userTel,u.userBirthday,u.userEmail,u.userImage,u.permissionId,u.userAddr,u.userStatus) from Users u where u.userId=:userId and u.userPsw=:userPsw and u.permissionId=:permissionId")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPsw") String user_psw,
			@Param("permissionId") Integer permissionId);

	/**
	 * 修改USERS表中指定编号的用户状态
	 * 
	 * @param userId     用户编号
	 * @param userStatus 用户状态
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

	/**
	 * 修改USERS表中指定编号的用户状态
	 * 
	 * @param users 修改用户信息状态
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	@Modifying
	@Query("update Users u set u.userIdnum=:#{#users.userIdnum},u.userSex=:#{#users.userSex},u.userTel=:#{#users.userTel},u.userBirthday=:#{#users.userBirthday},u.userEmail=:#{#users.userEmail},u.userAddr=:#{#users.userAddr} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);

	/**
	 * 修改USERS表中指定编号的用户头像
	 * 
	 * @param users 修改用户信息
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	@Modifying
	@Query("update Users u set u.userImage=:#{#users.userImage} where u.userId=:#{#users.userId}")
	public abstract Integer updateImage(@Param("users") Users users);
	
	/**
	 * 修改USERS表中指定编号的用户密码
	 * 
	 * @param users 修改用户信息
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	@Modifying
	@Query("update Users u set u.userPsw=:#{#users.userPsw} where u.userId=:#{#users.userId}")
	public abstract Integer updatepsw(@Param("users") Users users);
	
	/**	
	 * 修改USERS表中指定编号的用户昵称
	 * 
	 * @param users 修改用户信息
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);
}
