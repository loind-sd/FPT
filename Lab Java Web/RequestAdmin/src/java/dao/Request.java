/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ADMIN
 */
public class Request {
    private int id;
    private int to;
    private String requestName;
    private String studentId;
    private String studentName;
    private String dateCreated;
    private String dateClose;
    private String title;
    private String content;
    private int status;
    private int number;
    private String attach;
    private String solution;

    public Request() {
    }

    public String getDateClose() {
        return dateClose;
    }

    public Request(int id, String requestName, String studentId, String studentName, String dateCreated, String dateClose, String title, String content, int status, String attach, String solution) {
        this.id = id;
        this.requestName = requestName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateCreated = dateCreated;
        this.dateClose = dateClose;
        this.title = title;
        this.content = content;
        this.status = status;
        this.attach = attach;
        this.solution = solution;
    }

    public Request(int id, String requestName, String studentId, String studentName, String dateCreated, String dateClosed, String title, String content, String attach) {
        this.id = id;
        this.requestName = requestName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateCreated = dateCreated;
        this.dateClose = dateClosed;
        this.title = title;
        this.content = content;
        this.attach = attach;
    }
    
    

    
    public Request(int id, String requestName, String studentName, String dateCreated, String title, String content, int status, String attach, String solution) {
        this.id = id;
        this.requestName = requestName;
        this.studentName = studentName;
        this.dateCreated = dateCreated;
        this.title = title;
        this.content = content;
        this.status = status;
        this.attach = attach;
        this.solution = solution;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setDateClose(String dateClose) {
        this.dateClose = dateClose;
    }

    public Request(int id, String requestName, String dateCreated, String dateClose, String title, int status) {
        this.id = id;
        this.requestName = requestName;
        this.dateCreated = dateCreated;
        this.dateClose = dateClose;
        this.title = title;
        this.status = status;
    }
    
    

    public Request(int to, String requestName, int number) {
        this.to = to;
        this.requestName = requestName;
        this.number = number;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Request(int id, String requestName, String studentId, String studentName, String dateCreated, String dateClose, String title, String content, int status) {
        this.id = id;
        this.requestName = requestName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateCreated = dateCreated;
        this.dateClose = dateClose;
        this.title = title;
        this.content = content;
        this.status = status;
    }
    
    
    

    public Request(int id, int to, String studentId, String studentName, String dateCreated, String title, String content, int status) {
        this.id = id;
        this.to = to;
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateCreated = dateCreated;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " | " + to;
    }
    
    
}
