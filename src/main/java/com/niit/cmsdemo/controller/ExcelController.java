package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {

    @Autowired
    private AdvertiseService advertiseService;

    @PostMapping("/studentExcel")
    public void studentExcel(HttpServletResponse response){

    }

    @PostMapping("/taskExcel")
    public void taskExcel(HttpSession session, HttpServletResponse response,String startDate,String endDate){
        //获取list
        Map<String,Object> map=new HashMap<>();
        if(startDate!=null&&endDate!=null){
            map.put("startDate", StringUtils.trimAllWhitespace(startDate));
            map.put("endDate",StringUtils.trimAllWhitespace(endDate));
        }
        String userSessionId= (String) session.getAttribute("userSessionId");
        List<Advertise> advertises=advertiseService.findConditions(map,userSessionId);
        //excel
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();
        //header
        String[] headers={"UserID","URL"};
        HSSFRow row=sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell=row.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rows=1;
        for(Advertise advertise:advertises){
            HSSFRow dataRow=sheet.createRow(rows++);

            newCell(0,dataRow).setCellValue(advertise.getUserId());

            newCell(1,dataRow).setCellValue(advertise.getUrl());
        }

        String filename=startDate==null||endDate==null?userSessionId:userSessionId+"("+startDate+"to"+endDate+")";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename="+filename+".xls");
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HSSFCell newCell(Integer location,HSSFRow row){
        return row.createCell(location);
    }

}
