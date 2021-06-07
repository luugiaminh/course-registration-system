/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.DangKi;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DangKiDAO {
    public static List<DangKi> layDanhSachDangKi(){
        List<DangKi> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select dk from DANGKI dk";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static DangKi layThongTinDangKi(int id){
        DangKi dk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        dk = (DangKi) session.get(DangKi.class, id);
        return dk;
    }
    public static boolean themDangKi(DangKi dk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (DangKiDAO.layThongTinDangKi(dk.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(dk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinDangKi (DangKi dk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(DangKiDAO.layThongTinDangKi(dk.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(dk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaDangKi(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        DangKi dk = DangKiDAO.layThongTinDangKi(id);
        if (dk == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(dk);
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
