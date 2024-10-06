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

import com.entity.KefangyudingEntity;
import com.entity.view.KefangyudingView;

import com.service.KefangyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 客房预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 07:50:42
 */
@RestController
@RequestMapping("/kefangyuding")
public class KefangyudingController {
    @Autowired
    private KefangyudingService kefangyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KefangyudingEntity kefangyuding,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			kefangyuding.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KefangyudingEntity> ew = new EntityWrapper<KefangyudingEntity>();

		PageUtils page = kefangyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangyuding), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KefangyudingEntity kefangyuding, 
		HttpServletRequest request){
        EntityWrapper<KefangyudingEntity> ew = new EntityWrapper<KefangyudingEntity>();

		PageUtils page = kefangyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangyuding), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KefangyudingEntity kefangyuding){
       	EntityWrapper<KefangyudingEntity> ew = new EntityWrapper<KefangyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kefangyuding, "kefangyuding")); 
        return R.ok().put("data", kefangyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KefangyudingEntity kefangyuding){
        EntityWrapper< KefangyudingEntity> ew = new EntityWrapper< KefangyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kefangyuding, "kefangyuding")); 
		KefangyudingView kefangyudingView =  kefangyudingService.selectView(ew);
		return R.ok("查询客房预订成功").put("data", kefangyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KefangyudingEntity kefangyuding = kefangyudingService.selectById(id);
        return R.ok().put("data", kefangyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KefangyudingEntity kefangyuding = kefangyudingService.selectById(id);
        return R.ok().put("data", kefangyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KefangyudingEntity kefangyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kefangyuding);
        kefangyudingService.insert(kefangyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KefangyudingEntity kefangyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kefangyuding);
        kefangyudingService.insert(kefangyuding);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KefangyudingEntity kefangyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kefangyuding);
        kefangyudingService.updateById(kefangyuding);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kefangyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
