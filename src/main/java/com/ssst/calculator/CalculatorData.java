package com.ssst.calculator;

public class CalculatorData {

	private float fund;
    private float equipmentCost;
    
    public String indirect_fees;
    public String direct_fees;
    public String school_management_fees;
    public String college_management_fees;
    public String group_management_fees;
    
    public float getFund() {
        return this.fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public float getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(int equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
    

}