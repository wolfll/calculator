package com.ssst.calculator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
   @RequestMapping("/Test")
//@RequestParam(value="name", defaultValue="World")
    public Test test(@RequestParam(value="name", defaultValue="World")String name) {

    	return new Test(counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/Demo")
    public Test Demo(@RequestParam(value = "total_cost1",defaultValue = "4000000") float total_cost1,@RequestParam(value = "facility_cost1",defaultValue = "800000") float facility_cost1){
        System.out.println("总经费:"+total_cost1+"  设备使用费:"+facility_cost1);
//        float a1=Float.parseFloat(total_cost1);
//        float a2=Float.parseFloat(facility_cost1);
//        CalculatorData calculatorData=new CalculatorData();
        Z1Calculator z1c = new Z1Calculator();
        CalculatorResult cr = z1c.FirstType(total_cost1, facility_cost1);
        String s="间接费总额："+cr.getIndirect_fees()+"  直接费用："+cr.getDirect_fees()+"  学校管理费："+cr.getSchool_management_fees()+"  学院管理费"+cr.getCollege_management_fees()+"  项目管理费"+cr.getGroup_management_fees();
//        return new Test(counter.incrementAndGet(), String.format(template,nameone));
//        test(nameone);
        return new Test(counter.incrementAndGet(),s);
    }


}