package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

/**	
 * ��Ʒģ�Ͳ�:���ڶ��ڶ���Ʒģ����в����ķ��� 
 * @author ������
 *
 */
public interface GoodsService {
	/**
	 * ����µ���Ʒ��Ϣ
	 * 
	 * @param goods ����Ʒ��Ϣ
	 * @return �ɹ����ش���0,���򷵻�0
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * ��ѯ��Ʒ��ϸ��Ϣ
	 * 
	 * @param goods
	 * @param pageNumber ��ҳ��Ϣ
	 * @return �ɹ�����com.github.pagehelper.PageInfo,ʧ�ܷ���null
	 */
	public PageInfo<Goods> select(Goods goods, Integer pageNumber);

	/**
	 * ��������޸���Ʒ��Ϣ
	 * 
	 * @param goods �޸���Ʒ����Ϣ
	 * @return �ɹ����ش���0������,���򷵻�С��0������
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * ��������޸���Ʒ��Ϣ
	 * 
	 * @param goods �޸���Ʒ����Ϣ
	 * @return �ɹ����ش���0������,���򷵻�С��0������
	 */
	public abstract Integer update(Goods goods);
	
	
	/**
	 * ��ѯ����ǰʮ����Ʒ���ƺ���������
	 * @return �ɹ�����java.util.List����,ʧ�ܷ���null
	 */
	public abstract List<Goods> goodsGroup();
}
