/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.SinhVien;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien(){
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select sv from SINHVIEN sv";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static SinhVien layThongTinSinhVien(int id){
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        sv = (SinhVien) session.get(SinhVien.class, id);
        return sv;
    }
    public static boolean themSinhVien(SinhVien sv){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (SinhVienDAO.layThongTinSinhVien(sv.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(sv);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinSinhVien (SinhVien sv){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(SinhVienDAO.layThongTinSinhVien(sv.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(sv);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaSinhVien(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(id);
        if (sv == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(sv);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
}
