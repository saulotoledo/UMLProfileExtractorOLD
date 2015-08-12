package br.edu.ufcg.reuml.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.RollbackException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Abstract Data Acess Object.
 * Idea from http://websystique.com/springmvc/spring-4-mvc-and-hibernate4-integration-example-using-annotations/
 * and http://blog.stchedroff.com/2012/12/09/a-generic-dao-using-jpa-and-hibernate-4/
 * Created by gustavo on 11/08/15.
 */
public abstract class AbstractDAO<PK extends Serializable, T> {
    private final Class<T> persistentClass;
    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public AbstractDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public T getByKey(PK key) {

        startOperation();
        T result = (T) session.get(persistentClass, key);
        transaction.commit();

        session.close();
        return result;
    }

    public List<T> getAll() {
        startOperation();
        List<T> list = (List<T>) session.createCriteria(persistentClass).list();
        transaction.commit();

        session.close();
        return list;
    }

    public void persist(T entity) {
        try {
            startOperation();
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RollbackException();
        } finally {
            session.close();
        }
    }

    public void delete(T entity) {
        try {
            startOperation();
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RollbackException();
        } finally {
            session.close();
        }
    }

    private void startOperation() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }

        transaction = session.beginTransaction();
    }
}
