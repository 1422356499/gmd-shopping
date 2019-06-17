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
 * 	���Ʋ�:������ͼ�������,������ģ�Ͳ����Ӧ����,�������ݷ�����ͼ��
 * @author ������
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
		rv.setMessage("��¼��Ϣ����ȷ,����������");
		return rv;
	}
	
	@RequestMapping(value="/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Users insert = this.usersService.insert(users);
			if(insert != null) {
				rv.setCode(0);
				rv.setMessage("�û�¼��ɹ�");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("¼���û�ʧ��");
		return rv;
	}
	
	
	@RequestMapping(value="/select")
	public ResultValue select(Users users,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			//��÷�ҳ������
			List<Users> list = page.getContent();
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				map.put("userList", list);
				PageUtils pageUtils = new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//����ҳ��Ϣ���Map��
				map.put("pageUtils", pageUtils);
				
				//��Map��ӵ�ResultValue������
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
		rv.setMessage("�û��޸�״̬ʧ��");
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
		rv.setMessage("����û�ʧ��");
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
		rv.setMessage("�û��޸���Ϣʧ��");
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
		rv.setMessage("�û��޸���Ϣʧ��");
		return rv;
	}
}
