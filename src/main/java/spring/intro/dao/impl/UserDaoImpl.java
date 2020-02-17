package spring.intro.dao.impl;

import java.util.List;

import spring.intro.dao.UserDao;
import spring.intro.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add user", e);
        }
    }

    @Override
    public List<User> listUsers() {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery(
                    "from User ", User.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all users", e);
        }
    }

    @Override
    public User get(Long id) {
        try {
            Session session = sessionFactory.openSession();
            return  session.get(User.class,id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get user", e);
        }
    }
}
