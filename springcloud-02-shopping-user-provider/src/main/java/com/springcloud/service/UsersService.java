package com.springcloud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * ģ�Ͳ�Ľӿ�:���ڶ����û�ģ��ķ���
 * 
 * @author ������
 *
 */
public interface UsersService {
	
	
	/**
	 * �ж����û���¼�Ƿ�ɹ�
	 * 
	 * @param userId       �û����
	 * @param user_psw     �û�����
	 * @param permissionId Ȩ�ޱ��
	 * @return �ɹ����ص�¼�û� ������Ϣ,ʧ�ܷ���null
	 */
	public abstract Users login(Integer userId, String userPsw, Integer permissionId);

	/**
	 * ������û���Ϣ
	 * 
	 * @param users
	 * @return
	 */
	public abstract Users insert(Users users);

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @param users      ��ѯ����
	 * @param pageNumber ��ѯҳ��
	 * @return �ɹ�����org.springframework.data.domain.Page���͵�ʵ��,ʧ�ܷ���null
	 */
	public abstract Page<Users> select(Users users, Integer pageNumber);

	/**
	 * 	�޸�ָ����ŵ��û�״̬
	 * 
	 * @param userId	�û����
	 * @param userStatus	�û�״̬
	 * @return	�޸ĳɹ����ش���0,���򷵻�0
	 */
	public abstract Integer updateStatus(Integer userId, Integer userStatus);
	
	
	/**
	 * 	��ѯָ����ŵ��û���Ϣ
	 * @param userId	�û����
	 * @return	�ɹ�����com.springcloud.entity.Users���͵�ʵ��,���򷵻�Ϊ��
	 */
	public abstract Users selectById(Integer userId);

	
	/**
	 * 	�޸��û���Ϣ
	 * @param users	�û���Ϣ
	 * @return	�ɹ����ش���0,���򷵻�0
	 */
	public abstract Integer update(Users users); 
	
	
	/**
	 * �޸�USERS����ָ����ŵ��û�ͷ�������������ǳ�
	 * 
	 * @param users �޸��û���Ϣ
	 * @return �޸ĳɹ����ش���0������,���򷵻�0
	 */
	public abstract Integer updateMessage(@Param("users") Users users);
	
}