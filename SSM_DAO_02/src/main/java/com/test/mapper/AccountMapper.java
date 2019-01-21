package com.test.mapper;

import com.test.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/9
 */
public interface AccountMapper {
    public void out(@Param("name") String outName, @Param("money") double money);

    public void in(@Param("name") String inName, @Param("money") double money);

    public List<Account> findAll();
}
