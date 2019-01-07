/*
* 文件名: com.dundunmonster.springbootjdbc.cus.service.impl
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 11:08
* 修改人:
* 修改时间: 2019年01月07日 11:08
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootjdbc.cus.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dundunmonster.springbootjdbc.cus.domain.CusBaseInfo;
import com.dundunmonster.springbootjdbc.cus.service.CusBaseInfoService;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoServiceImpl
 * @Description
 * @date 2019年01月07日 11:08
 * @since V1.0
 */
@Service
public class CusBaseInfoServiceImpl implements CusBaseInfoService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CusBaseInfo> getAllCusBaseInfo() {
        //查询客户信息
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from cus_base_info");
        List<CusBaseInfo> cusBaseInfoList = new ArrayList<>();
        for (Map<String, Object> map : list ) {
            CusBaseInfo cusBaseInfo = new CusBaseInfo();
            //客户ID
            cusBaseInfo.setCusId(map.get("CUS_ID").toString());
            //客户编码
            cusBaseInfo.setCusCode(map.get("CUS_CODE").toString());
            //客户名称
            cusBaseInfo.setCusName(map.get("CUS_NAME").toString());
            //客户简称
            cusBaseInfo.setCusAbbr(null == map.get("CUS_ABBR") ? "" : map.get("CUS_ABBR").toString());
            //客户地址
            cusBaseInfo.setAddress(null == map.get("ADDRESS") ? "" : map.get("ADDRESS").toString());
            cusBaseInfoList.add(cusBaseInfo);
        }
        return cusBaseInfoList;
    }

    @Override
    public CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo) {
        String sql = "insert into cus_base_info(cus_id, cus_code,cus_name,cus_abbr, address) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{cusBaseInfo.getCusId(), cusBaseInfo.getCusCode(),
                cusBaseInfo.getCusName(), cusBaseInfo.getCusAbbr(), cusBaseInfo.getAddress()},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
        //获取客户信息
        return getCusBaseInfoById(cusBaseInfo.getCusId());
    }

    @Override
    public CusBaseInfo getCusBaseInfoById(String cusId) {
        Map<String,Object> map = jdbcTemplate.queryForMap("select * from cus_base_info where cus_id = ?", cusId);
        if(null != map && map.size() > 0) {
            CusBaseInfo cusBaseInfo = new CusBaseInfo();
            //客户ID
            cusBaseInfo.setCusId(map.get("CUS_ID").toString());
            //客户编码
            cusBaseInfo.setCusCode(map.get("CUS_CODE").toString());
            //客户名称
            cusBaseInfo.setCusName(map.get("CUS_NAME").toString());
            //客户简称
            cusBaseInfo.setCusAbbr(null == map.get("CUS_ABBR") ? "" : map.get("CUS_ABBR").toString());
            //客户地址
            cusBaseInfo.setAddress(null == map.get("ADDRESS") ? "" : map.get("ADDRESS").toString());
            return cusBaseInfo;
        }
        return null;
    }

    @Override
    public CusBaseInfo updateCusBaseInfo(CusBaseInfo cusBaseInfo) {
        //更新语句
        String sql = "update cus_base_info set cus_code = ?,cus_name = ?,cus_abbr = ?,address = ? where cus_id = ?";
        jdbcTemplate.update(sql,new Object[]{cusBaseInfo.getCusCode(), cusBaseInfo.getCusName(),
                cusBaseInfo.getCusAbbr(), cusBaseInfo.getAddress(), cusBaseInfo.getCusId()});
        return getCusBaseInfoById(cusBaseInfo.getCusId());
    }

    @Override
    public int deleteCusBaseInfo(String cusId) {
        //删除语句
        String sql = "delete from cus_base_info where cus_id = ?";
        return jdbcTemplate.update(sql, new Object[]{cusId});
    }
}
