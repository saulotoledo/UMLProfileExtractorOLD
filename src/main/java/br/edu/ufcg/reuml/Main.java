package br.edu.ufcg.reuml;

import br.edu.ufcg.reuml.dao.ClassDiagramProfileDAO;
import br.edu.ufcg.reuml.dao.HibernateUtil;
import br.edu.ufcg.reuml.profiles.ClassDiagramProfile;
import br.edu.ufcg.reuml.profiles.UMLProfile;
import org.hibernate.Session;

/**
 * Main to do simple tests.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        UMLProfile profile = new ClassDiagramProfile(0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0);
        UMLProfile profile2 = new ClassDiagramProfile(0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0);


        session.save(profile);
        session.getTransaction().commit();

        ClassDiagramProfileDAO dao = new ClassDiagramProfileDAO();
        dao.save((ClassDiagramProfile) profile2);

        HibernateUtil.shutdown();
    }
}
