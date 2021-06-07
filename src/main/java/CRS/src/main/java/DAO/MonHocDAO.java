/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.MonHoc;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MonHocDAO {
    public static List<MonHoc> layDanhSachMonHoc(){
        List<MonHoc> ds;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select mh from MONHOC mh";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static MonHoc layThongTinMonHoc(String maMH){
        MonHoc mh = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        mh = (MonHoc) session.get(MonHoc.class, maMH);
        return mh;
    }
    public static boolean themMonHoc(MonHoc mh){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (MonHocDAO.layThongTinMonHoc(mh.getMaMH()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(mh);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinMonHoc (MonHoc mh){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(MonHocDAO.layThongTinMonHoc(mh.getMaMH())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(mh);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaMonHoc(String maMH){
        Session session = HibernateUtil.getSessionFactory().openSession();
        MonHoc mh = MonHocDAO.layThongTinMonHoc(maMH);
        if (mh == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(mh);
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
