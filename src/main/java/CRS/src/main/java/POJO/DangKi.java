/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

public class DangKi {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgDK() {
        return ngDK;
    }

    public void setNgDK(Date ngDK) {
        this.ngDK = ngDK;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }
    private int id;
    private Date ngDK;
    private String maSV;
    private String maHP;
    DangKi(){}
    DangKi(int id,Date ngDK, String maSV, String maHP){
        this.id=id;
        this.ngDK=ngDK;
        this.maSV=maSV;
        this.maHP=maHP;
    }
}
