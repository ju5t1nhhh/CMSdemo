package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.StudentService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    public ServerResponse updateStudent(Student student,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try{
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
    public ServerResponse searchStudent(HttpSession session){
        String userSessionId= (String) session.getAttribute("userSessionId");
        Map<String,Object> map=new HashMap<>();
        return ServerResponse.createSuccessResponse(studentService.findConditions(map,userSessionId));
    }
}
