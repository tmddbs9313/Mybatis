package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {

        /*필기. DB접속 관한 환경
        *  -------------------------
        *  JDBCTransactionFactory : 수동커밋
        *  ManagedTransactionFactory  : 자동커밋
        *  -------------------------
        *  PooledDataSource : ConnectionPool 사용
        *  UnPooledDataSource : ConnectionPool 미사용*/


        Environment environment = new Environment(
                "dev"       //환경 정보 이름(id)
                , new JdbcTransactionFactory()      // 트랜젝션 매니저 종류 결정(JDBC or MANAGED)
                , new PooledDataSource(DRIVER, URL, USER, PASSWORD) // ConnectionPool 사용 유무 (Pooled or UnPooled)
        );  //db접속에 관한환경

        /*  필기. 생성한 환경 정보로 MyBatis 설정 객체 생성 */
        Configuration configuration = new Configuration(environment);

        configuration.addMapper(Mapper.class);  //dao 역할.

        /* 필기.
         *   SqlSessionFactory : SqlSession 객체를 생성하기 위한 책토리 역할의 인터페이스
         *   SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현객체를 생성하기 위한 빌드 역할
         *   build() : 환경 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결 된 Stream
         *             을 매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
         *  */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        /*필기.
        *  openSession() :SqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 전달
        *  -false: connection 인터페이스 타입 객체로 DML(insert, update, delete) 수행후 auto commit 옵션 false(권장)*/

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /*getMapper() : Configuration 에 등록된 메퍼를 동일타입에 대해 반환하는 메소드 */
        Mapper mapper = sqlSession.getMapper(Mapper.class); // 인터페이스여서 집적 생성x, 데이터베이스를 연결할수잇는..


        java.util.Date date = mapper.selectSydate();
        System.out.println("date = " + date);
        
        sqlSession.close();
    }


}
