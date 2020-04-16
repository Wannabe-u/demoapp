package test;

import com.mysql.cj.xdevapi.Session;
import dao.IAccountdao;
import dao.Impl.BaseSessionFactoryImpl;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestMybatis extends BaseSessionFactoryImpl{
    @Test
    public void run1() throws IOException {
        SqlSession  ac = getSessionFactory();
        Account account = new Account();
        account.setUser("Test3");
        account.setPasswd("testtest3");
        IAccountdao dao = ac.getMapper(IAccountdao.class);
        dao.saveAccount(account);
    }

    @Test
    public void run2() throws Exception {
        SqlSession  ac = getSessionFactory();
        IAccountdao dao = ac.getMapper(IAccountdao.class);
        List<Account> list = dao.findAll();
        for (Account account: list ) {
            System.out.println(account);
        }
    }

}
