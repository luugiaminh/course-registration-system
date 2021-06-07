/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HocKi;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HocKiDAO {
    public static List<HocKi> layDanhSachHocKi(){
        List<HocKi> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select hk from HOCKI hk";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static HocKi layThongTinHocKi(int id){
        HocKi hk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        hk = (HocKi) session.get(HocKi.class, id);
        return hk;
    }
    public static boolean themHocKi(HocKi hk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (HocKiDAO.layThongTinHocKi(hk.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(hk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinHocKi (HocKi hk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(HocKiDAO.layThongTinHocKi(hk.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(hk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaHocKi(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        HocKi hk = HocKiDAO.layThongTinHocKi(id);
        if (hk == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(hk);
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
