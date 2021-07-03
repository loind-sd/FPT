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
public class TimeTable {
    private String date;
    private int slot;
    private String time;
    private String className;
    private String teacher;
    private String room;

    public TimeTable() {
    }

    public TimeTable(String date, int slot, String time, String className, String teacher, String room) {
        this.date = date;
        this.slot = slot;
        this.time = time;
        this.className = className;
        this.teacher = teacher;
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return date + " " + slot + " " + time + " " + className + " " + teacher + " " + room;
    }
    
    
}
