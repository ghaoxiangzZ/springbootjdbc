/*
* 文件名: com.dundunmonster.springbootjdbc.user.controller
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 10:08
* 修改人:
* 修改时间: 2019年01月07日 10:08
* 修改变更号:
* 修改内容:
*/
package com.dundunmonster.springbootjdbc.cus.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dundunmonster.springbootjdbc.cus.domain.CusBaseInfo;
import com.dundunmonster.springbootjdbc.cus.service.CusBaseInfoService;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusController
 * @Description
 * @date 2019年01月07日 10:08
 * @since V1.0
 */
@RestController
@RequestMapping(value = "/cus")
@Api(value = "客户信息控制接口", description = "客户信息控制接口")
public class CusBaseInfoController {

    @Autowired
    private CusBaseInfoService cusBaseInfoService;

    /**
     * 获取所有客户信息
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有客户信息", notes = "获取所有有效的客户信息")
    public List<CusBaseInfo> getAllCusBaseInfo(){
        return cusBaseInfoService.getAllCusBaseInfo();
    }

    /**
     * 保存客户信息
     * @param cusBaseInfo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存客户信息", notes = "保存客户信息")
    public CusBaseInfo saveCusBaseInfo(@ApiParam(value = "客户信息",name = "cusBaseInfo",required = true)  CusBaseInfo cusBaseInfo){
        return cusBaseInfoService.saveCusBaseInfo(cusBaseInfo);
    }

    /**
     * 根据客户ID查询客户信息
     * @param cusId
     * @return
     */
    @RequestMapping(value = "/get/{cusId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据客户ID查询客户信息", notes = "根据客户ID查询客户信息")
    @ApiImplicitParam(paramType = "path", name = "cusId", value = "客户ID", required = true)
    public CusBaseInfo getCusBaseInfoById(@PathVariable  String cusId){
        return cusBaseInfoService.getCusBaseInfoById(cusId);
    }

    /**
     * 更新客户信息
     * @param cusBaseInfo 客户信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "更新客户信息", notes = "更新客户信息")
    public CusBaseInfo updateCusBaseInfo(@ApiParam(value = "客户信息", name = "cusBaseInfo", required = true) CusBaseInfo cusBaseInfo){
        return cusBaseInfoService.updateCusBaseInfo(cusBaseInfo);
    }

    /**
     * 删除客户信息
     * @param cusId 客户ID
     * @return
     */
    @RequestMapping(value = "/delete/{cusId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除客户信息", notes = "根据客户ID删除客户信息")
    @ApiImplicitParam(paramType = "path", value = "客户ID", name = "cusId", required = true)
    public String deleteCusBaseInfo(@PathVariable("cusId") String cusId){
        int result = cusBaseInfoService.deleteCusBaseInfo(cusId);
        if(result > 0){
            return "删除成功！";
        }
        return "删除失败！";
    }
}