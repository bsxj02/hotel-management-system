package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 财务信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-17 07:50:43
 */
@TableName("caiwuxinxi")
public class CaiwuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwuxinxiEntity() {
		
	}
	
	public CaiwuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 登记单号
	 */
					
	private String dengjidanhao;
	
	/**
	 * 财务收入
	 */
					
	private Double caiwushouru;
	
	/**
	 * 财务支出
	 */
					
	private Double caiwuzhichu;
	
	/**
	 * 收支情况
	 */
					
	private Double shouzhiqingkuang;
	
	/**
	 * 登记内容
	 */
					
	private String dengjineirong;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：登记单号
	 */
	public void setDengjidanhao(String dengjidanhao) {
		this.dengjidanhao = dengjidanhao;
	}
	/**
	 * 获取：登记单号
	 */
	public String getDengjidanhao() {
		return dengjidanhao;
	}
	/**
	 * 设置：财务收入
	 */
	public void setCaiwushouru(Double caiwushouru) {
		this.caiwushouru = caiwushouru;
	}
	/**
	 * 获取：财务收入
	 */
	public Double getCaiwushouru() {
		return caiwushouru;
	}
	/**
	 * 设置：财务支出
	 */
	public void setCaiwuzhichu(Double caiwuzhichu) {
		this.caiwuzhichu = caiwuzhichu;
	}
	/**
	 * 获取：财务支出
	 */
	public Double getCaiwuzhichu() {
		return caiwuzhichu;
	}
	/**
	 * 设置：收支情况
	 */
	public void setShouzhiqingkuang(Double shouzhiqingkuang) {
		this.shouzhiqingkuang = shouzhiqingkuang;
	}
	/**
	 * 获取：收支情况
	 */
	public Double getShouzhiqingkuang() {
		return shouzhiqingkuang;
	}
	/**
	 * 设置：登记内容
	 */
	public void setDengjineirong(String dengjineirong) {
		this.dengjineirong = dengjineirong;
	}
	/**
	 * 获取：登记内容
	 */
	public String getDengjineirong() {
		return dengjineirong;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}

}
