/*
* 文件名: com.dundunmonster.springbootjdbc.user.domain
* 文件编号:
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述:
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 10:09
* 修改人:
* 修改时间: 2019年01月07日 10:09
* 修改变更号:
* 修改内容:
*/
package com.dundunmonster.springbootjdbc.cus.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title CusBaseInfo
 * @Description
 * @date 2019年01月07日 10:09
 * @since V1.0
 */
@ApiModel(value = "客户信息实体类", description = "客户信息实体类")
public class CusBaseInfo {

    @ApiModelProperty(value = "客户ID", name = "cusId", dataType = "String", required = true, readOnly = true)
    private String cusId;

    @ApiModelProperty(value = "客户编码", name = "cusCode", dataType = "String",  required = true, readOnly = true)
    private String cusCode;

    @ApiModelProperty(value = "客户名称", name = "cusName", dataType = "String", required = true, readOnly = true)
    private String cusName;

    @ApiModelProperty(value = "客户简称", name = "cusAbbr", dataType = "String")
    private String cusAbbr;

    @ApiModelProperty(value = "客户地址", name = "address", dataType = "String")
    private String address;

    public CusBaseInfo() {

    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAbbr() {
        return cusAbbr;
    }

    public void setCusAbbr(String cusAbbr) {
        this.cusAbbr = cusAbbr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
