/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

public class KiDKHP {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public KiDKHP(int id, Date ngayBD, Date ngayKT, String maHK) {
        this.id = id;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.maHK = maHK;
    }

    public KiDKHP() {
    }
    private int id;
    private Date ngayBD;
    private Date ngayKT;
    private String maHK;
}
