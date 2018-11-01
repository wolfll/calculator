package com.ssst.calculator;

import org.apache.log4j.Logger;

import java.text.NumberFormat;

public class Z1Calculator {
    private static Logger logger = Logger.getLogger(CalculatorController.class);
	public CalculatorResult FirstType( float total_cost1, float facility_cost1){
        // float a1=Float.parseFloat(direct_cost1);        //将String格式转换为Float格式
       //float facility=Float.parseFloat(facility_cost1);
       //float total=Float.parseFloat(total_cost1);
       final float stage_one=0.2f;//超额累进比
       final float stage_two=0.15f;
       final float stage_three=0.13f;
       final float ten_thousand=10000;
       final float school_management_ratio=0.06f;//学校管理费比例
       final float college_management_ratio=0.02f;//学院管理费比例
       float stage=total_cost1-facility_cost1;//总费-设备费

       float indirect_fees = -1;
       float direct_fees=-1;
       float school_management_fees = -1;
       float college_management_fees = -1;
       float group_management_fees = -1;

        NumberFormat nf=NumberFormat.getInstance();//格式化
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

       logger.info("总经费："+nf.format(total_cost1)+"\t 设备费："+nf.format(facility_cost1)+"\n");
       if(stage>0&&stage<=500*ten_thousand){                           //500万元及以下部分为20%
       	indirect_fees = (((stage) * stage_one)/(1+stage_one));
       	direct_fees=total_cost1-indirect_fees;
       	school_management_fees =  (total_cost1 * school_management_ratio);
       	college_management_fees =  (total_cost1 * college_management_ratio);
       	group_management_fees = indirect_fees - (school_management_fees + college_management_ratio);
       }else if(stage>500*ten_thousand&&stage<=1000*ten_thousand){
           indirect_fees = (((500*ten_thousand) * stage_one)/(1+stage_one))+(((stage-500*ten_thousand) * stage_two)/(1+stage_two));
           direct_fees=total_cost1-indirect_fees;
           school_management_fees =  (total_cost1 * school_management_ratio);
           college_management_fees =  (total_cost1 * college_management_ratio);
           group_management_fees = indirect_fees - (school_management_fees + college_management_ratio);
       }else if(stage>1000*ten_thousand){
           indirect_fees = (((500*ten_thousand) * stage_one)/(1+stage_one))+(((500*ten_thousand) * stage_two)/(1+stage_two))+(((stage-1000*ten_thousand) * stage_three)/(1+stage_three));
           direct_fees=total_cost1-indirect_fees;
           school_management_fees =  (total_cost1 * school_management_ratio);
           college_management_fees =  (total_cost1 * college_management_ratio);
           group_management_fees = indirect_fees - (school_management_fees + college_management_ratio);
       }

       /*
       if(a>5000000&&a<=10000000){                   //超过500万元至1000万元的部分为15%
           indirect_cost1=1000000+(a-5000000)*0.15f;
       }
       if(a>10000000){                              //超过1000万元以上的部分为13%
           indirect_cost1=1750000+(a-10000000)*0.13f;
       }
       float schoolmanage_cost1=a4*0.06f;
       float academymanage_cost1=a4*0.02f;
       float projectmanage_cost1=indirect_cost1-(schoolmanage_cost1+academymanage_cost1);
       String s1="<间接费总额>"+indirect_cost1+"</间接费总额>";
       String s2="<学校管理费>"+schoolmanage_cost1+"</学校管理费>";
       String s3= "<学院管理费>"+academymanage_cost1+"</学院管理费>";
       String s4= "<项目管理费>"+projectmanage_cost1+"</项目管理费>";
       return"<?xml version=\"2.0\" encoding=\"UTF-8\">"+s1+s2+s3+s4;
       */




       CalculatorResult cr = new CalculatorResult();
       cr.setIndirect_fees(nf.format(indirect_fees));
       cr.setDirect_fees(nf.format(direct_fees));
       cr.setSchool_management_fees(nf.format(school_management_fees));
       cr.setCollege_management_fees(nf.format(college_management_fees));
       cr.setGroup_management_fees(nf.format(group_management_fees));
       return cr;
   }

}
