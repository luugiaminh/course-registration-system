/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.GiaoVu;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GiaoVuDAO {
    public static List<GiaoVu> layDanhSachGiaoVu(){
        List<GiaoVu> ds;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select gv from GIAOVU gv";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static GiaoVu layThongTinGiaoVu(String taiKhoan){
        GiaoVu gv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        gv = (GiaoVu) session.get(GiaoVu.class, taiKhoan);
        return gv;
    }
    public static boolean themGiaoVu(GiaoVu gv){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (GiaoVuDAO.layThongTinGiaoVu(gv.getTaiKhoan()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(gv);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinGiaoVu (GiaoVu gv){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(GiaoVuDAO.layThongTinGiaoVu(gv.getTaiKhoan())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(gv);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaGiaoVu(String taiKhoan){
        Session session = HibernateUtil.getSessionFactory().openSession();
        GiaoVu gv = GiaoVuDAO.layThongTinGiaoVu(taiKhoan);
        if (gv == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(gv);
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
