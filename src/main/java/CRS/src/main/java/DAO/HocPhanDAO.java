/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HocPhan;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HocPhanDAO {
    public static List<HocPhan> layDanhSachHocPhan(){
        List<HocPhan> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select hp from HOCPHAN hp";
        Query query = session.createQuery(hql);
        ds = query.list();
        return ds; 
    }
    public static HocPhan layThongTinHocPhan(int id){
        HocPhan hp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        hp = (HocPhan) session.get(HocPhan.class, id);
        return hp;
    }
    public static boolean themHocPhan(HocPhan hp){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if (HocPhanDAO.layThongTinHocPhan(hp.getId()) != null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.save(hp);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean capNhatThongTinHocPhan (HocPhan hp){
         Session session = HibernateUtil.getSessionFactory().openSession();
         if(HocPhanDAO.layThongTinHocPhan(hp.getId())!=null){
             return false;
         }
         Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.update(hp);
         transaction.commit();
         } catch (HibernateException ex){
             transaction.rollback();
             System.err.println(ex);
         } finally {
             session.close();
         }
         return true;
    }
    public static boolean xoaHocPhan(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        HocPhan hp = HocPhanDAO.layThongTinHocPhan(id);
        if (hp == null) return false;
        Transaction transaction = null;
         try{
         transaction = session.beginTransaction();
         session.delete(hp);
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
