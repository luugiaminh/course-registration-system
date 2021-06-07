/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.KiDKHP;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KiDKHPDAO {
    public static List<KiDKHP> layDanhSachKiDKHP(){
        List<KiDKHP> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select kidk from KIDKHP kidk";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static KiDKHP layThongTinKiDKHP(int id){
        KiDKHP kidk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        kidk = (KiDKHP) session.get(KiDKHP.class, id);
        return kidk;
    }
    public static boolean themKiDKHP(KiDKHP kidk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (KiDKHPDAO.layThongTinKiDKHP(kidk.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(kidk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinKiDKHP (KiDKHP kidk){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(KiDKHPDAO.layThongTinKiDKHP(kidk.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(kidk);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaKiDKHP(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        KiDKHP kidk = KiDKHPDAO.layThongTinKiDKHP(id);
        if (kidk == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(kidk);
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
