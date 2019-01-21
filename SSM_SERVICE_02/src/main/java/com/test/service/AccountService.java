package com.test.service;

import com.test.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public interface AccountService {
    public void tranfer(@Param("name") String outName,
                        @Param("name") String inName,
                        @Param("money") double money);

    public List<Account> findAll();
}
