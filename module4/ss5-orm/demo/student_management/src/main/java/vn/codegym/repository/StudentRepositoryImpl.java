package vn.codegym.repository;

import vn.codegym.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        // Cách 1: DÙng hibernate chuẩn
//        Session session = null;
//        List<Student> students = null;
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            students = session.createQuery("FROM Student").getResultList();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return students;
        TypedQuery<Student> query = ConnectionUtil.entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
