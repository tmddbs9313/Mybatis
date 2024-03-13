package com.ohgiraffers.section01.xmlconfig;


    /*필기. servise 의 역할
    *  1. sqlsession 생성
    *  2. dao(데이터베이스 접근 객체)의 메소드 호출
    *  3. 트랜젝션 (commit, rollback)제어
    *  4. sqlsession 닫기*/


import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        this.menuDAO = new MenuDAO();

    }
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession,code);

        sqlSession.close();

        return menu;

    }

    public boolean registMenu(MenuDTO menu) {  // if 문 안써서 boolean 타입으로 설정됨.

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        //트렌젝션 제어
        if(result > 0) {
            sqlSession.commit();  //성공적으로 했으니 insert한걸 저장을 하겠다.
        }else {
            sqlSession.rollback();  //그렇지않다면 돌려놓겠다.
        }
        sqlSession.close();

        return result > 0 ?true : false;  //앞에가 트루면 앞에꺼(트루)를 반환
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        //트렌젝션 제어
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;  //앞에가 트루면 앞에꺼(트루)를 반환
    }
    public boolean deleteMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menu);

        //트렌젝션 제어
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;  //앞에가 트루면 앞에꺼(트루)를 반환
    }
}
