package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * 	控制层:接收视图层的数据,并调用模型层的相应方法,并将数据返回视图层
 * @author 吴榕兴
 *
 */
@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/login")
	public ResultValue login(@RequestParam("userId") Integer userId, @RequestParam("userPsw") String userPsw, @RequestParam("permissionId") Integer permissionId) {
		ResultValue rv = new ResultValue();
		
		try {
			Users login = this.usersService.login(userId, userPsw, permissionId);
			if(login != null) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("登录信息不正确,请重新输入");
		return rv;
	}
	
	@RequestMapping(value="/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Users insert = this.usersService.insert(users);
			if(insert != null) {
				rv.setCode(0);
				rv.setMessage("用户录入成功");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("录入用户失败");
		return rv;
	}
	
	
	@RequestMapping(value="/select")
	public ResultValue select(Users users,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			//获得分页的数据
			List<Users> list = page.getContent();
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				map.put("userList", list);
				PageUtils pageUtils = new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//将分页信息添加Map中
				map.put("pageUtils", pageUtils);
				
				//将Map添加到ResultValue对象中
				rv.setDataMap(map);
				return rv;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer updateStatus = this.usersService.updateStatus(userId, userStatus);
			if(updateStatus > 0) {
				rv.setCode(0);
				return rv;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户修改状态失败");
		return rv;
	}
	
	@RequestMapping(value="/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		
		try {
			Users user = this.usersService.selectById(userId);
			if(user != null) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("user", user);
				rv.setDataMap(map);
				return rv;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("获得用户失败");
		return rv;
	}
	
	@RequestMapping(value="/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.usersService.update(users);
			if(update > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户修改信息失败");
		return rv;
	}
	
	@RequestMapping(value="/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer update = this.usersService.updateMessage(users);
			if(update > 0) {
				rv.setCode(0);
				return rv;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户修改信息失败");
		return rv;
	}
}
