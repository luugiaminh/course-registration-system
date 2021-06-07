/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author DongDong
 */
public class SinhVien {

    public SinhVien(int id, String maSV, String matKhau, String tenSV, String phai, String maLop) {
        this.id = id;
        this.maSV = maSV;
        this.matKhau = matKhau;
        this.tenSV = tenSV;
        this.phai = phai;
        this.maLop = maLop;
    }
    
    public SinhVien(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    private int id;
    private String maSV;
    private String matKhau;
    private String tenSV;
    private String phai;
    private String maLop;
}
