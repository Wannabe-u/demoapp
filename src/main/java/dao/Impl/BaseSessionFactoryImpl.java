package dao.Impl;

import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration("classpath:applicationContext.xml")
public class BaseSessionFactoryImpl {
    private  SqlSessionFactory sqlSessionFactory;

    @Resource(name = "sqlSessionFactory")
    public SqlSession getSessionFactory() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}