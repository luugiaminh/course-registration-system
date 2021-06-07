/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Lop;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LopDAO {
    public static List<Lop> layDanhSachLop(){
        List<Lop> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select l from LOP l";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static Lop layThongTinLop(int id){
        Lop l = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        l = (Lop) session.get(Lop.class, id);
        return l;
    }
    public static boolean themLop(Lop l){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (LopDAO.layThongTinLop(l.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(l);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinLop (Lop l){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(LopDAO.layThongTinLop(l.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(l);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaLop(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Lop l = LopDAO.layThongTinLop(id);
        if (l == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(l);
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
