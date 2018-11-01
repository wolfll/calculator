package com.ssst.calculator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class CalculatorController {

	private static Logger logger = Logger.getLogger(CalculatorController.class);
	 @GetMapping("/z1n1")
	    public String greetingForm(Model model) {
	        model.addAttribute("calculatorData", new CalculatorData());
	        return "app";
	    }

	    @PostMapping("/z1n1")
	    public String greetingSubmit(@ModelAttribute CalculatorData calculatorData) {

			NumberFormat nf =NumberFormat.getInstance();
	    	System.out.print(calculatorData.getFund() + "\n");
	    	System.out.print(calculatorData.getEquipmentCost() + "\n");
			logger.info("总经费："+nf.format(calculatorData.getFund())+"\t 设备费："+nf.format(calculatorData.getEquipmentCost())+"\n");
	    	Z1Calculator z1c = new Z1Calculator();
	    	CalculatorResult cr = z1c.FirstType(calculatorData.getFund(), calculatorData.getEquipmentCost());
	    	
//	    	System.out.print(cr.getIndirect_fees() + "\n");
//			System.out.print(cr.getDirect_fees() + "\n");
//	    	System.out.print(cr.getSchool_management_fees() + "\n");
//	    	System.out.print(cr.getCollege_management_fees() + "\n");
//	    	System.out.print(cr.getGroup_management_fees() + "\n");
			logger.info("间接费："+cr.getIndirect_fees()+"\t 学校管理费："+cr.getSchool_management_fees()+"\t 学院管理费："+cr.getCollege_management_fees()+"\t 项目管理费:"+cr.getGroup_management_fees());

			calculatorData.indirect_fees = cr.getIndirect_fees();
	    	calculatorData.direct_fees=cr.getDirect_fees();
	    	calculatorData.school_management_fees = cr.getSchool_management_fees();
	    	calculatorData.college_management_fees = cr.getCollege_management_fees();
	    	calculatorData.group_management_fees = cr.getGroup_management_fees();

	        return "result2";
	        
	    }
//        private static final String template = "Hello, %s!";
//        private final AtomicLong counter = new AtomicLong();
//
//	    @RequestMapping("/Demo1")
//        public Test Demo(){
//            CalculatorResult cr=new CalculatorResult();
//            String nameone=String.valueOf(cr.getIndirect_fees());
//            String nametwo=cr.getCollege_management_fees();
//            String namethree=cr.getGroup_management_fees();
//            String namefour=cr.getDirect_fees();
//            String namefive=cr.getSchool_management_fees();
//            String s=nameone+nametwo+namethree+namefour+namefive;
//            return new Test(counter.incrementAndGet(), String.format(template,nameone));
//            test(nameone);
//            return new Test(counter.incrementAndGet(), String.format(template, s));
//        }


}
