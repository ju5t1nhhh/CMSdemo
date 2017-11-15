package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.StudentService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ServerResponse addStudent(Student student, HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try{
            studentService.addStudent(student,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/updateStudent")
    public ServerResponse updateStudent(Student student,HttpSession session,String walkingDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try{
            student.setWalkinDate(sdf.parse(walkingDate));
            studentService.updateStudent(student,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/delStudent")
    public ServerResponse delStudent(Long stuId,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try{
            studentService.delStudents(stuId,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/getStudent")
    public ServerResponse getStudent(Long stuId,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try{
            serverResponse=ServerResponse.createSuccessResponse(studentService.getStudent(stuId,userSessionId));
        }catch (Exception e){
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/searchStudent")
    public ServerResponse searchStudent(HttpSession session,String name,String startDate,String endDate,String classification,String source){
        String userSessionId= (String) session.getAttribute("userSessionId");
        Map<String,Object> map=new HashMap<>();
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
        return ServerResponse.createSuccessResponse(studentService.findConditions(map,userSessionId));
    }

    @PostMapping("/searchCount")
    public ServerResponse searchCount(String userId,String startDate,String endDate,String classification,String source){
        Map<String,Object> map=new HashMap<>();
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
        return ServerResponse.createSuccessResponse(studentService.searchCount(map,userId));
    }
}
