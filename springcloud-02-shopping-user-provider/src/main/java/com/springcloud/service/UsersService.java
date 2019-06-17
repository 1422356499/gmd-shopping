package com.springcloud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 模型层的接口:用于定于用户模块的方法
 * 
 * @author 吴榕兴
 *
 */
public interface UsersService {
	
	
	/**
	 * 判断吗用户登录是否成功
	 * 
	 * @param userId       用户编号
	 * @param user_psw     用户密码
	 * @param permissionId 权限编号
	 * @return 成功返回登录用户 完整信息,失败返回null
	 */
	public abstract Users login(Integer userId, String userPsw, Integer permissionId);

	/**
	 * 添加新用户信息
	 * 
	 * @param users
	 * @return
	 */
	public abstract Users insert(Users users);

	/**
	 * 查询满足条件的用户信息
	 * 
	 * @param users      查询条件
	 * @param pageNumber 查询页数
	 * @return 成功返回org.springframework.data.domain.Page类型的实例,失败返回null
	 */
	public abstract Page<Users> select(Users users, Integer pageNumber);

	/**
	 * 	修改指定编号的用户状态
	 * 
	 * @param userId	用户编号
	 * @param userStatus	用户状态
	 * @return	修改成功返回大于0,否则返回0
	 */
	public abstract Integer updateStatus(Integer userId, Integer userStatus);
	
	
	/**
	 * 	查询指定编号的用户信息
	 * @param userId	用户编号
	 * @return	成功返回com.springcloud.entity.Users类型的实例,否则返回为空
	 */
	public abstract Users selectById(Integer userId);

	
	/**
	 * 	修改用户信息
	 * @param users	用户信息
	 * @return	成功返回大于0,否则返回0
	 */
	public abstract Integer update(Users users); 
	
	
	/**
	 * 修改USERS表中指定编号的用户头像或是密码或是昵称
	 * 
	 * @param users 修改用户信息
	 * @return 修改成功返回大于0的整数,否则返回0
	 */
	public abstract Integer updateMessage(@Param("users") Users users);
	
}