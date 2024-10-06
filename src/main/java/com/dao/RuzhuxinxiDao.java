package com.dao;

import com.entity.RuzhuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RuzhuxinxiVO;
import com.entity.view.RuzhuxinxiView;


/**
 * 入住信息
 * 
 * @author 
 * @email 
 * @date 2024-04-17 07:50:43
 */
public interface RuzhuxinxiDao extends BaseMapper<RuzhuxinxiEntity> {
	
	List<RuzhuxinxiVO> selectListVO(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);
	
	RuzhuxinxiVO selectVO(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);
	
	List<RuzhuxinxiView> selectListView(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);

	List<RuzhuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);

	
	RuzhuxinxiView selectView(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);



}
