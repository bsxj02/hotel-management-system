package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QuxiaoyudingEntity;
import com.entity.view.QuxiaoyudingView;

import com.service.QuxiaoyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 取消预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 07:50:43
 */
@RestController
@RequestMapping("/quxiaoyuding")
public class QuxiaoyudingController {
    @Autowired
    private QuxiaoyudingService quxiaoyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaoyudingEntity quxiaoyuding,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			quxiaoyuding.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuxiaoyudingEntity> ew = new EntityWrapper<QuxiaoyudingEntity>();
                if(quxiaoshijianstart!=null) ew.ge("quxiaoshijian", quxiaoshijianstart);
                if(quxiaoshijianend!=null) ew.le("quxiaoshijian", quxiaoshijianend);

		PageUtils page = quxiaoyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoyuding), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuxiaoyudingEntity quxiaoyuding, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date quxiaoshijianend,
		HttpServletRequest request){
        EntityWrapper<QuxiaoyudingEntity> ew = new EntityWrapper<QuxiaoyudingEntity>();
                if(quxiaoshijianstart!=null) ew.ge("quxiaoshijian", quxiaoshijianstart);
                if(quxiaoshijianend!=null) ew.le("quxiaoshijian", quxiaoshijianend);

		PageUtils page = quxiaoyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoyuding), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaoyudingEntity quxiaoyuding){
       	EntityWrapper<QuxiaoyudingEntity> ew = new EntityWrapper<QuxiaoyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaoyuding, "quxiaoyuding")); 
        return R.ok().put("data", quxiaoyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaoyudingEntity quxiaoyuding){
        EntityWrapper< QuxiaoyudingEntity> ew = new EntityWrapper< QuxiaoyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaoyuding, "quxiaoyuding")); 
		QuxiaoyudingView quxiaoyudingView =  quxiaoyudingService.selectView(ew);
		return R.ok("查询取消预订成功").put("data", quxiaoyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaoyudingEntity quxiaoyuding = quxiaoyudingService.selectById(id);
        return R.ok().put("data", quxiaoyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaoyudingEntity quxiaoyuding = quxiaoyudingService.selectById(id);
        return R.ok().put("data", quxiaoyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuxiaoyudingEntity quxiaoyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quxiaoyuding);
        quxiaoyudingService.insert(quxiaoyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaoyudingEntity quxiaoyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quxiaoyuding);
        quxiaoyudingService.insert(quxiaoyuding);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuxiaoyudingEntity quxiaoyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaoyuding);
        quxiaoyudingService.updateById(quxiaoyuding);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QuxiaoyudingEntity> list = new ArrayList<QuxiaoyudingEntity>();
        for(Long id : ids) {
            QuxiaoyudingEntity quxiaoyuding = quxiaoyudingService.selectById(id);
            quxiaoyuding.setSfsh(sfsh);
            quxiaoyuding.setShhf(shhf);
            list.add(quxiaoyuding);
        }
        quxiaoyudingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quxiaoyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
