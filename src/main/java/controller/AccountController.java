package controller;

import domain.Account;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "user",method = RequestMethod.GET)
    @ResponseBody
    public Map userInfo(HttpSession httpSession){
        System.out.println("Controller表现层：查询所有账户...");
        Map<Object,Object> map = new HashMap<Object, Object>();
        List<Account> list=accountService.findAll();
        //for (int i=0;i<list.size();i++) {
            try {
                map.put("message", list);
                map.put("errorCode", 200);
            } catch (Exception e) {
                map.put("errorCode", 1);
                map.put("errorMessage", "未知错误");
            }
        //}
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "user1",method = RequestMethod.GET)
    @ResponseBody
    public List userInfo1(HttpSession httpSession){
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list=accountService.findAll();
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list);
        return list;
    }

        @RequestMapping(value = "hello", method = RequestMethod.GET)
        @ResponseBody // 要返回json数据
        public Map login(HttpSession httpSession) {
            Map<String, Object> map = new HashMap<String, Object>();

            try {
                map.put("errorCode", 0);
                map.put("message", "hello");
            } catch (Exception e) {
                map.put("errorCode", 1);
                map.put("errorMessage", "未知错误");
            }
            return map;
        }

    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller表现层：保存账户...");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}