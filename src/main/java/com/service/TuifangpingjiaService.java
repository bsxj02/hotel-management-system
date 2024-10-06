package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuifangpingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuifangpingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuifangpingjiaView;


/**
 * 退房评价
 *
 * @author 
 * @email 
 * @date 2024-04-17 07:50:43
 */
public interface TuifangpingjiaService extends IService<TuifangpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuifangpingjiaVO> selectListVO(Wrapper<TuifangpingjiaEntity> wrapper);
   	
   	TuifangpingjiaVO selectVO(@Param("ew") Wrapper<TuifangpingjiaEntity> wrapper);
   	
   	List<TuifangpingjiaView> selectListView(Wrapper<TuifangpingjiaEntity> wrapper);
   	
   	TuifangpingjiaView selectView(@Param("ew") Wrapper<TuifangpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuifangpingjiaEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<TuifangpingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<TuifangpingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<TuifangpingjiaEntity> wrapper);



}

