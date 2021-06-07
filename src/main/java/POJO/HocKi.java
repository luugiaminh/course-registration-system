/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

public class HocKi {
    public HocKi() {}

    public HocKi(int id, String tenHK, String nam, Date ngayBD, Date ngayKT) {
        this.id = id;
        this.tenHK = tenHK;
        this.nam = nam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHK() {
        return tenHK;
    }

    public void setTenHK(String tenHK) {
        this.tenHK = tenHK;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
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
    private int id;
    private String tenHK;
    private String nam;
    private Date ngayBD;
    private Date ngayKT;
}
