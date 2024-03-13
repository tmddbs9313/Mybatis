package com.ohgiraffers.section03.remix;

//@NoArgsConstructor  // 기본생성자
//@AllArgsConstructor  // 모든필드를 초기화하는 생성자
//@Getter
//@Setter
//@ToString

//@Data -위에 다섯가지 요소를 한번에 포함하는 어노테이션. 혹시모를 에러때문에 잘 사용하지 않는다.

public class MenuDTO {
    public MenuDTO() {

    }

    public MenuDTO(int code, String name, int price, int cateforyCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = cateforyCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int cateforyCode) {
        this.categoryCode = cateforyCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cateforyCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

}
