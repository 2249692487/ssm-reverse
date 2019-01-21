package com.test.controller;

import com.test.pojo.Account;
import com.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer/{out}/{in}/{money}")
    public String transfer(@PathVariable("out") String outName,
                           @PathVariable("in") String inName,
                           @PathVariable("money") double money,
                           Model model) {
        accountService.tranfer(outName, inName, money);
        String str = outName + "转账给" + inName + money + "元";
        model.addAttribute("msg", str);
        return "transfer";
    }

    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<Account> all = accountService.findAll();
        model.addAttribute("all", all);
        System.out.println("all===================" + all.toString());
        return "findAll";
    }
}
