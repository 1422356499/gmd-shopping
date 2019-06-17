package com.springcloud.dao;

import com.springcloud.entity.Goods;

import java.util.List;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer goodsId);

	int insert(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);

	List<Goods> selectAll();

	int updateByPrimaryKey(Goods record);

	/**
	 * ��ѯGoods����������ӵ���Ʒ��Ϣ
	 * 
	 * @param goods ��ѯ���
	 * @return �ɹ�����java.util.List���͵�ʵ��,���򷵻�null
	 */
	public abstract List<Goods> select(Goods goods);
	
	
	/**	
	 * ���������޸�GOODS����ָ��Goods_ID����Ϣ
	 * @param goods	�޸ĵ���Ʒ��Ϣ
	 * @return	�ɹ����ش���0������,���򷵻�С��0������
	 */
	public abstract Integer updateGoodsById(Goods goods);
	
	/**
	 * ��ѯ����ǰʮ����Ʒ���ƺ���������
	 * @return �ɹ�����java.util.List����,ʧ�ܷ���null
	 */
	public abstract List<Goods> goodsGroup();
}