package com.ohgiraffers.section01.xmlconfig;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /*필기. 우리는 아직 view 즉 사용자들이 정보를 입력할 수 있는 호마녀을 배우지 않았다.
        *  따라서 아직은 application 이 view 라고 생각하고 진행을 해보자.*/

        /*필기. 시스템 요구사항
        *  1. 메뉴 전체 조회
        *  2. 메뉴 코드로 메뉴 조회
        *  3. 신규 메뉴 추가
        *  4. 메뉴 수정
        *  5. 메뉴 삭제*/

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
            System.out.println("==========오지라퍼 메뉴 관리 시스템===========");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.print("메뉴 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectMenuByCode(inputMenuCode()); break;
                case 3 : menuController.registMenu(inputMenu()); break;
                case 4 : menuController.updateMenu(inputUpdateMenu());break;
                case 5 : menuController.deleteMenu(inputdeleteMenu()); break;
                default:
                    System.out.println("잘목된 메뉴를 입력하셨습니다."); break;
            }
        }while (true);
    }

    private static Map<String,String> inputdeleteMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제하실 메뉴코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code",code);

        return parameter;
    }

    private static Map<String, String> inputUpdateMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("업데이트 할 메뉴코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.println("메뉴이름을 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.println("카테고리를 입력해주세요 : ");
        String category = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code",code);
        parameter.put("name",name);
        parameter.put("category",category);

        return parameter;

    }

    private static Map<String,String> inputMenu() {

        /*메뉴 이름,메뉴가격,카테고리 코드를 입력받아 넘겨준다*/
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }

    private static Map <String, String> inputMenuCode() {
        Scanner sc =new Scanner(System.in);
        System.out.print("조회할 메뉴 코드를 입력해주세요 : ");
        String code = sc.nextLine();

        Map<String, String > parameter = new HashMap<>();
        parameter.put("code",code);

        return parameter;
    }
}
