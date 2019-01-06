    /*
     * 文件名: com.dundunmonster.springbootjdbc.service
     * 文件编号:
     * 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
     * 描述:
     * 创建人: ghaoxiang
     * 创建时间: 2019年01月06日 21:32
     * 修改人:
     * 修改时间: 2019年01月06日 21:32
     * 修改变更号:
     * 修改内容:
     */
    package com.dundunmonster.springbootjdbc.service;

    /**
     * @author ghaoxiang
     * @version V1.0
     * @Title UserService
     * @Description
     * @date 2019年01月06日 21:32
     * @since V1.0
     */
    public interface UserService {

        /**
         * 新增一个用户
         * @param name
         * @param age
         */
        void create(String name, Integer age);

        /**
         * 根据name删除一个用户高
         * @param name
         */
        void deleteByName(String name);

        /**
         * 获取用户总量
         */
        Integer getAllUsers();

        /**
         * 删除所有用户
         */
        void deleteAllUsers();
    }
