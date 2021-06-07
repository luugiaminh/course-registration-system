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
public class HocPhan {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public int getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(int caHoc) {
        this.caHoc = caHoc;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getMaKiDKHP() {
        return maKiDKHP;
    }

    public void setMaKiDKHP(String maKiDKHP) {
        this.maKiDKHP = maKiDKHP;
    }

    public HocPhan(int id, String maMH, String phong, String giaoVien, String ngayHoc, int caHoc, int slots, String maKiDKHP) {
        this.id = id;
        this.maMH = maMH;
        this.phong = phong;
        this.giaoVien = giaoVien;
        this.ngayHoc = ngayHoc;
        this.caHoc = caHoc;
        this.slots = slots;
        this.maKiDKHP = maKiDKHP;
    }

    public HocPhan() {
    }
    private int id;
    private String maMH;
    private String phong;
    private String giaoVien;
    private String ngayHoc;
    private int caHoc;
    private int slots;
    private String maKiDKHP;
}
