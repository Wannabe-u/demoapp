package test;


import dao.IAccountdao;
import domain.Account;
import org.apache.ibatis.exceptions.PersistenceException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMybatis {
    @Resource(name="sqlSessionFactory")
    private  SqlSessionFactory sqlSessionFactory;


    @Test
    public void run1() throws IOException {
        Account account = new Account();
        try {
            account.setUser("Test4");
            account.setPasswd("testtest4");
            IAccountdao dao = sqlSessionFactory.openSession().getMapper(IAccountdao.class);
            dao.saveAccount(account);
        }
        catch (PersistenceException e){
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void run2() throws Exception {
        IAccountdao dao = sqlSessionFactory.openSession().getMapper(IAccountdao.class);
        List<Account> list = dao.findAll();
        for (Account account: list ) {
            System.out.println(account);
        }
    }

}
