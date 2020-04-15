package controller;

import domain.Account;
import service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(){
        System.out.println("Controller表现层：查询所有账户...");

        List<Account> List=accountService.findAll();
        return "list";  //在视图解析器中配置了前缀后缀
    }
}