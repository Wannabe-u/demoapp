package dao.Impl;

import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseSessionFactoryImpl {

    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory=null;
    public SqlSession getSession() {
        SqlSession ac = sqlSessionFactory.openSession();
        return ac;
    }
}