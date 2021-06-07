/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

public class GiaoVu {

    public GiaoVu() {}
    public GiaoVu(String taiKhoan, String matKhau, String tenGV){
        this.taiKhoan=taiKhoan;
        this.matKhau=matKhau;
        this.tenGV = tenGV;
    }
    
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    private String taiKhoan;
    private String matKhau;
    private String tenGV;
    
}
