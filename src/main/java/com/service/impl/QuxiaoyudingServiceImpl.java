package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QuxiaoyudingDao;
import com.entity.QuxiaoyudingEntity;
import com.service.QuxiaoyudingService;
import com.entity.vo.QuxiaoyudingVO;
import com.entity.view.QuxiaoyudingView;

@Service("quxiaoyudingService")
public class QuxiaoyudingServiceImpl extends ServiceImpl<QuxiaoyudingDao, QuxiaoyudingEntity> implements QuxiaoyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuxiaoyudingEntity> page = this.selectPage(
                new Query<QuxiaoyudingEntity>(params).getPage(),
                new EntityWrapper<QuxiaoyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuxiaoyudingEntity> wrapper) {
		  Page<QuxiaoyudingView> page =new Query<QuxiaoyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QuxiaoyudingVO> selectListVO(Wrapper<QuxiaoyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuxiaoyudingVO selectVO(Wrapper<QuxiaoyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuxiaoyudingView> selectListView(Wrapper<QuxiaoyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuxiaoyudingView selectView(Wrapper<QuxiaoyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
