package com.zzjee.yongyoubase.openapi4j.service;

import com.alibaba.fastjson.JSONObject;
import com.zzjee.yongyoubase.openapi4j.commons.TokenManager;
import com.zzjee.yongyoubase.openapi4j.exception.OpenAPIException;
import com.zzjee.yongyoubase.openapi4j.model.Record;
import com.zzjee.yongyoubase.openapi4j.platform.TradeService;
import com.zzjee.yongyoubase.openapi4j.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright(c) 2015-2015 by yonyouup. All Rights Reserved 自由项信息
 * 
 * @author liujl
 * @version <类版本> , 2015年12月20日
 * @see <相关类/方法>
 * @since <产品/模块版本>
 */
public class FreearchService extends BaseService{
	final static Logger logger = LogManager.getLogger(FreearchService.class);
	
	public FreearchService() {
		this.access_token = TokenManager.getToKenId();
	}

	public FreearchService(String token) {
		this.access_token = token;
	}
	
	/**
	 * 获取某个自由项信息 
	 * @param id 自由项编码
	 * @param to_account 提供方id
	 * @return
	 * @throws OpenAPIException
	 */
	public JSONObject get(String id, String to_account) throws OpenAPIException {
		JSONObject record;
		try {
			Map<String, String> paramMap = new HashMap();
			paramMap.put("to_account", to_account);
			paramMap.put("id", id);
			String url = this.createURL("freearch/get", paramMap);
			logger.info(url);
			record = JSONObject.parseObject(HttpUtil.get(url));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new OpenAPIException(e.getMessage(), e);
		}
		return record;
	}
	/**
	 * 批量获取自由项信息
	 * @param paramMap
	 * @return
	 * @throws OpenAPIException
	 */
	public JSONObject batchGet(Map<String, String> paramMap) throws OpenAPIException {
		JSONObject record;
		try {
			String url = this.createURL("freearch/batch_get", paramMap);
			logger.debug(url);
			record = JSONObject.parseObject(HttpUtil.get(url));
		} catch (Exception e) {
			
			throw new OpenAPIException(e.getMessage(), e);
		}
		return record;
	}
}
