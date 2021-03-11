/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author MyPC
 */
public class Student {
    private String fullname;
    private float age;
    private String phone;
    private float dtb;
    private String hocluc;

    public Student() {
    }

    public Student(String fullname, float age, String phone, float dtb,String hocluc) {
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.dtb = dtb;
        this.hocluc = hocluc;
        
    }

    public String getHocluc() {
        return hocluc;
    }

    public void setHocluc(String hocluc) {
        this.hocluc = hocluc;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    public String getFullname() {
        return fullname;
    }

    public float getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" + "fullname=" + fullname + ", age=" + age + ", phone=" + phone + ", dtb=" + dtb + ", hocluc=" + hocluc + '}';
    }

    
    
    
    
}
