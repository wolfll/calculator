package com.ssst.calculator;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorsecondController {
    private final AtomicLong counter=new AtomicLong();
    private static Logger logger = Logger.getLogger(CalculatorController.class);
    @RequestMapping("/demo")
    private CalculatorDataSecond CalculatorDatasecond(@RequestParam(value = "total_cost1",defaultValue = "1000000") float total_cost1,
                                                      @RequestParam(value = "facility_cost1",defaultValue = "300000") float facility_cost1){

        logger.info("总经费:"+total_cost1+"  设备使用费:"+facility_cost1);
        Z1Calculator z1c = new Z1Calculator();
        CalculatorResult cr = z1c.FirstType(total_cost1, facility_cost1);
//        String s="间接费总额："+cr.getIndirect_fees()+"  直接费用："+cr.getDirect_fees()+"  学校管理费："+cr.getSchool_management_fees()+"  学院管理费"+cr.getCollege_management_fees()+"  项目管理费"+cr.getGroup_management_fees();
        return new CalculatorDataSecond(counter.incrementAndGet(),cr.getIndirect_fees(),cr.getDirect_fees(),cr.getSchool_management_fees(),cr.getCollege_management_fees(),cr.getGroup_management_fees());
    }
}
