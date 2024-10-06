package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuxiaoyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuxiaoyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuxiaoyudingView;


/**
 * 取消预订
 *
 * @author 
 * @email 
 * @date 2024-04-17 07:50:43
 */
public interface QuxiaoyudingService extends IService<QuxiaoyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuxiaoyudingVO> selectListVO(Wrapper<QuxiaoyudingEntity> wrapper);
   	
   	QuxiaoyudingVO selectVO(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);
   	
   	List<QuxiaoyudingView> selectListView(Wrapper<QuxiaoyudingEntity> wrapper);
   	
   	QuxiaoyudingView selectView(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuxiaoyudingEntity> wrapper);

   	

}

