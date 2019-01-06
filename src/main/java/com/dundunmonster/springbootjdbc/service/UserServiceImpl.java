    /*
     * 文件名: com.dundunmonster.springbootjdbc.service
     * 文件编号:
     * 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
     * 描述:
     * 创建人: ghaoxiang
     * 创建时间: 2019年01月06日 21:34
     * 修改人:
     * 修改时间: 2019年01月06日 21:34
     * 修改变更号:
     * 修改内容:
     */
    package com.dundunmonster.springbootjdbc.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Service;

    /**
     * @author ghaoxiang
     * @version V1.0
     * @Title UserServiceImpl
     * @Description
     * @date 2019年01月06日 21:34
     * @since V1.0
     */
    @Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public void create(String name, Integer age) {
            jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
        }

        @Override
        public void deleteByName(String name) {
            jdbcTemplate.update("delete from USER where NAME = ?", name);

        }

        @Override
        public Integer getAllUsers() {
            return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
        }

        @Override
        public void deleteAllUsers() {
            jdbcTemplate.update("delete from USER");
        }
    }
