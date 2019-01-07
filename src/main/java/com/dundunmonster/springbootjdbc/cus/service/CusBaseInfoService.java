/*
* 文件名: com.dundunmonster.springbootjdbc.cus.service
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
package com.dundunmonster.springbootjdbc.cus.service;

import java.util.List;

import com.dundunmonster.springbootjdbc.cus.domain.CusBaseInfo;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfoService
 * @Description
 * @date 2019年01月07日 11:08
 * @since V1.0
 */
public interface CusBaseInfoService {

    /**
     * 获取所有客户信息
     * @return
     */
    List<CusBaseInfo> getAllCusBaseInfo();

    /**
     * 保存客户信息
     * @param cusBaseInfo
     * @return
     */
    CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 根据客户ID获取客户信息
     * @param cusId 客户ID
     * @return
     */
    CusBaseInfo getCusBaseInfoById(String cusId);

    /**
     * 修改客户信息
     * @param cusBaseInfo 客户信息
     * @return
     */
    CusBaseInfo updateCusBaseInfo(CusBaseInfo cusBaseInfo);

    /**
     * 删除客户信息
     * @param cusId 客户ID
     * @return
     */
    int deleteCusBaseInfo(String cusId);
}
