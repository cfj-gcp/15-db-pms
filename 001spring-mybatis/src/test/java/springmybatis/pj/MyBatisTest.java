package springmybatis.pj;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class MyBatisTest {
    @Autowired
    private SqlSession sqlSession;
    @Test
    void testGetConnection(){
        Connection  conn = sqlSession.getConnection();
        System.out.println("connection="+conn);
    }
}
