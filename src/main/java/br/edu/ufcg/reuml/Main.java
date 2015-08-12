package br.edu.ufcg.reuml;

import br.edu.ufcg.reuml.dao.UMLProfileDAO;
import br.edu.ufcg.reuml.dao.HibernateUtil;
import br.edu.ufcg.reuml.profile.ClassDiagramProfile;
import br.edu.ufcg.reuml.profile.UMLProfile;
import br.edu.ufcg.reuml.service.UMLProfileService;
import br.edu.ufcg.reuml.strategy.CosineSimilarity;
import org.hibernate.Session;

/**
 * Main to do simple tests.
 */
public class Main {
    public static void main(String[] args) {
        UMLProfileService service = new UMLProfileService();
        UMLProfile profile = service.getClassDiagramProfile("/home/gustavo/Downloads/class/xBaseJ.uml");
        System.out.println(profile.toString());
    }
}
