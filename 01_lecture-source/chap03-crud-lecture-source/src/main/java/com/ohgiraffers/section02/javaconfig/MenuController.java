package com.ohgiraffers.section02.javaconfig;


import java.util.List;
import java.util.Map;

/*필기. controller의 역할
    *  View 즉 현재는 Application에서 사용자가 입력한 파라미터 형태로 전달 받으면
    *  전달받은 값들을 검증하거나 추가적인 정보가 필요한 경우 가공을 한뒤
    *  service 쪽으로 전달하기 위한 인스턴스를 담고 서비스의 비즈니스 로직을 담당하는 method 를 호출한다.
    *  또한 호출한 수행 결과를 반환 받아 어떠한 뷰를 다시 사용자에게 보여줄 것인지를 결정하는 역할을 한다.*/
    public class MenuController {

        private final MenuService menuService;
        private final PrintResult printResult;

        public MenuController() {
            this.menuService = new MenuService();
            this.printResult = new PrintResult();
        }  //생성자를 포함한 초기화
        public void selectAllMenu() {

            List<MenuDTO> menuList = menuService.selectAllMenu();

            if (menuList != null) { // 잘 존재한다면
                printResult.printMenuList(menuList);
            } else {
                printResult.printErrorMessage("selectList");
            }
        }

        public void selectMenuByCode(Map<String,String> parameter) {
            int code = Integer.parseInt(parameter.get("code"));
            //사용자가 string 타입으로 입력한 값을 서버 측에소 int 로 파싱
            MenuDTO menu = menuService.selectMenuByCode(code);

            if(menu != null) {
                printResult.printMenu(menu);
            }else {
               printResult.printErrorMessage("selectOne");
            }

        }

    public void registMenu(Map<String, String> parameter) {

            String name = parameter.get("name");
            int price = Integer.parseInt(parameter.get("price"));
            int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

            MenuDTO menu = new MenuDTO();
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategoryCode(categoryCode);

            if(menuService.registMenu(menu)) {
                printResult.printSuccessMessage("insert");
            }else {
                printResult.printErrorMessage("insert");
            }




    }

    public void updateMenu(Map <String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int category = Integer.parseInt(parameter.get("category"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setCategoryCode(category);

        if(menuService.updateMenu(menu)) {
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }

    }

    public void deleteMenu(Map<String, String> parameter) {  //왜 파라미터로 바꿈?
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);

        if(menuService.deleteMenu(menu)) {
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
