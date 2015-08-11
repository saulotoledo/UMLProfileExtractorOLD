package br.edu.ufcg.reuml;

import br.edu.ufcg.reuml.dao.UMLProfileDAO;
import br.edu.ufcg.reuml.dao.HibernateUtil;
import br.edu.ufcg.reuml.profile.ClassDiagramProfile;
import br.edu.ufcg.reuml.profile.UMLProfile;
import org.hibernate.Session;

/**
 * Main to do simple tests.
 */
public class Main {
    public static void main(String[] args) {
        UMLProfile profile = new ClassDiagramProfile(0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0);
        UMLProfile profile2 = new ClassDiagramProfile(0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0);

        //Not Using DAO
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(profile);
        session.getTransaction().commit();


        //Using DAO
        UMLProfileDAO dao = new UMLProfileDAO();
        dao.save(profile2);

        //Ending Conection
        HibernateUtil.shutdown();
    }
}
