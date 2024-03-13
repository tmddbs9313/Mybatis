package com.ohgiraffers.common;

public class SeatchCriteria {

    private String condition;  //검색 기준(메뉴 이름 혹은 카테고리명)
    private String value;  //검색어
    public SeatchCriteria() {}

    public SeatchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SeatchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
