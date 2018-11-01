package com.ssst.calculator;

public class CalculatorDataSecond {

    private float id;
    private String indirect_fees;
    private String direct_fees;
    private String school_management_fees;
    private String college_management_fees;
    private String group_management_fees;
    public CalculatorDataSecond(float id,String indirect_fees,String direct_fees,
                               String school_management_fees,String college_management_fees,
                               String group_management_fees){
        this.id=id;
        this.indirect_fees=indirect_fees;
        this.direct_fees=direct_fees;
        this.school_management_fees=school_management_fees;
        this.college_management_fees=college_management_fees;
        this.group_management_fees=group_management_fees;
    }


    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getIndirect_fees() {
        return indirect_fees;
    }

    public void setIndirect_fees(String indirect_fees) {
        this.indirect_fees = indirect_fees;
    }

    public String getDirect_fees() {
        return direct_fees;
    }

    public void setDirect_fees(String direct_fees) {
        this.direct_fees = direct_fees;
    }

    public String getSchool_management_fees() {
        return school_management_fees;
    }

    public void setSchool_management_fees(String school_management_fees) {
        this.school_management_fees = school_management_fees;
    }

    public String getCollege_management_fees() {
        return college_management_fees;
    }

    public void setCollege_management_fees(String college_management_fees) {
        this.college_management_fees = college_management_fees;
    }

    public String getGroup_management_fees() {
        return group_management_fees;
    }

    public void setGroup_management_fees(String group_management_fees) {
        this.group_management_fees = group_management_fees;
    }
}
