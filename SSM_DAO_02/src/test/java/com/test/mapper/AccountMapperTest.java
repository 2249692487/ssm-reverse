package com.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext_dao.xml")
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void out() {
        accountMapper.out("aaa",100);
    }

    @Test
    public void in() {
    }

    @Test
    public void findAll() {
    }
}