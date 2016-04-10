
package com.mygym.service;

import com.mygym.app.domain.Training;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ivana
 */
@Stateless
@EJB(beanName = "TrainingServiceBean", name = "java:app/TrainingService",
        beanInterface = TrainingService.class)
public class TrainingServiceBean implements TrainingService {

    @PersistenceContext(unitName = "helloworld")
    private EntityManager entityManager;

    public String selectAll() {

        // read the existing entries
        Query q = entityManager.createQuery("SELECT t FROM Training t");
        List<Training> trainingList = q.getResultList();
        for (Training todo : trainingList) {
            System.out.println(todo);
        }
        return "sucess";
    }
}
