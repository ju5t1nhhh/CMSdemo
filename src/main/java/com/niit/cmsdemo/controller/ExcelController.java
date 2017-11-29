package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.dao.FollowUpDao;
import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.domain.Feedback;
import com.niit.cmsdemo.domain.FollowUp;
import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.AdvertiseService;
import com.niit.cmsdemo.service.StudentService;
import com.niit.cmsdemo.vo.FeedbackUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {

    @Autowired
    private AdvertiseService advertiseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FollowUpDao followUpDao;

    @PostMapping("/studentExcel")
    public void studentExcel(HttpSession session, HttpServletResponse response, Feedback feedback,String userId,String name, String startDate, String endDate, String classification, String source){
        String userSessionId= (String) session.getAttribute("userSessionId");
        Map<String,Object> map=new HashMap<>();
        if(userId!=null&&userId.length()>0){
            map.put("writerId",userId);
        }
        if(name!=null&&name.length()>0){
            map.put("name",name);
        }
        if(startDate!=null&&startDate.length()>0){
            map.put("startDate",startDate);
        }
        if(endDate!=null&&endDate.length()>0) {
            map.put("endDate", endDate+" 23:59:59");
        }
        if(classification!=null&&classification.length()>0) {
            map.put("classification", classification);
        }
        if(source!=null&&source.length()>0) {
            map.put("studentSource", source);
        }
        List<Student> students=studentService.findConditions(FeedbackUtil.toArray(feedback),map,userSessionId);

        //excel
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();
        //header
        String[] headers={"USERID/录入人ID","ID/学生ID","NAME/姓名","GENDER/性别","AGE/年龄",
                "PHONE/电话","QQWECHAT/QQ或微信","EMAIL/邮箱","COLLEGE/大学","MAJAR/专业",
                "WALKINDATE/上门咨询日期","INTERVIEWNOTE/面试记录","MARKS/笔试成绩","INTENTION/学习意愿",
                "STUDENTSOURCE/生源来自","CLASSIFICATION/参加实训可能性","CREATETIME/录入时间",
                "FOLLOWUP1/跟进","CLASSIFICATION/参与可能性","FOLLOWUP2/跟进","CLASSIFICATION/参与可能性","FOLLOWUP3/跟进","CLASSIFICATION/参与可能性","FOLLOWUP4/跟进","CLASSIFICATION/参与可能性","FOLLOWUP5/跟进","CLASSIFICATION/参与可能性"};
        HSSFRow row=sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell=row.createCell(i);
            cell.setCellValue(headers[i]);
        }

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        int rows=1;
        for(Student student:students){
            HSSFRow dataRow=sheet.createRow(rows++);

            Date walkDate=student.getWalkinDate();
            String walkinDate=walkDate==null?"":simpleDateFormat.format(walkDate);
            newCell(0,dataRow).setCellValue(student.getWriterId());
            newCell(1,dataRow).setCellValue(student.getId());
            newCell(2,dataRow).setCellValue(objectToString(student.getName()));
            newCell(3,dataRow).setCellValue(""+student.getGender());
            newCell(4,dataRow).setCellValue(student.getAge()==null?0:student.getAge());
            newCell(5,dataRow).setCellValue(objectToString(student.getPhone()));
            newCell(6,dataRow).setCellValue(objectToString(student.getQqWechat()));
            newCell(7,dataRow).setCellValue(objectToString(student.getEmail()));
            newCell(8,dataRow).setCellValue(objectToString(student.getCollege()));
            newCell(9,dataRow).setCellValue(objectToString(student.getMajor()));
            newCell(10,dataRow).setCellValue(walkinDate);
            newCell(11,dataRow).setCellValue(objectToString(student.getInterviewNote()));
            newCell(12,dataRow).setCellValue(student.getMarks()==null?0:student.getMarks());
            newCell(13,dataRow).setCellValue(objectToString(student.getIntention()));
            newCell(14,dataRow).setCellValue(objectToString(student.getStudentSource()));
            String classifi=student.getClassification()==null?"":""+student.getClassification();
            newCell(15,dataRow).setCellValue(classifi);
            newCell(16,dataRow).setCellValue(simpleDateFormat.format(student.getCreateTime()));

            Map<String,Object> fuMap=new HashMap<>();
            fuMap.put("stuId",student.getId());
            List<FollowUp> followUps=followUpDao.selectConditions(fuMap);

            int fu=17;
            for(FollowUp followUp:followUps){
                newCell(fu++,dataRow).setCellValue(objectToString(followUp.getNote()));
                String classi=student.getClassification()==null?"":""+student.getClassification();
                newCell(fu++,dataRow).setCellValue(classi);
            }
        }

        String filename=startDate==null||endDate==null?userSessionId:userSessionId+"("+startDate+"to"+endDate+")";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename="+filename+"-studentExcel.xls");
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            newCell(0,dataRow).setCellValue(objectToString(advertise.getUserId()));

            newCell(1,dataRow).setCellValue(objectToString(advertise.getUrl()));
        }

        String filename=startDate==null||endDate==null?userSessionId:userSessionId+"("+startDate+"to"+endDate+")";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename="+filename+"-taskExcel.xls");
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

    private String objectToString(Object object){
        return object!=null?(String)object:"";
    }
}
