package vn.codegym.song_management.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.song_management.model.Song;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static vn.codegym.song_management.repository.ConnectionUtil.entityManager;
import static vn.codegym.song_management.repository.ConnectionUtil.sessionFactory;

@Repository
@Transactional
public class SongRepositoryImpl implements ISongRepository{
    private static Session  session = ConnectionUtil.sessionFactory.openSession();

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = ConnectionUtil.entityManager.createQuery("select s from Song as s", Song.class);
        return query.getResultList();
    }
    @Override
    public void save(Song song) {
        //Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE Song set name = :name, singer = :singer, type = :type, url = :url WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", song.getName());
            query.setParameter("singer", song.getSinger());
            query.setParameter("type", song.getType());
            query.setParameter("url", song.getUrl());
            query.setParameter("id", song.getId());
            int result = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "delete from Song where id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public Song findById(int id) {
        Session session = null;
        Transaction transaction = null;
        Song mySong = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            mySong = session.get(Song.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return mySong;
    }
}
