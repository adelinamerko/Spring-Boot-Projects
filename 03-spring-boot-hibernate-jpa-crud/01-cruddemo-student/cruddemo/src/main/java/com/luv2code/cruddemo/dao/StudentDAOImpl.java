package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{

    // entity manager is the main component for saving /retriving query
private EntityManager entityManager;

// constryctor injection

@Autowired
public StudentDAOImpl(EntityManager entityManager){
    this.entityManager=entityManager;
}
    @Override
    @Transactional // begin nd end  transaction for a JPA code
    public void save(Student thestudent) {
    entityManager.persist(thestudent);         // save the student in db
    }

    @Override
    public Student findStudent(Integer Id) {
       return  entityManager.find(Student.class,3000);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery= entityManager.createQuery("From Student", Student.class);
    return theQuery.getResultList();
}

    @Override

    public List<Student> findByLastName(String thelastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student order by last_name asc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
    entityManager.merge(theStudent);
    // merge in hibernate is used to update exsiting values or creates a copy of the passed entity and return

}

    @Override
    @Transactional
    public void delete(int Id) {
       Student thestd = entityManager.find(Student.class,Id);
        entityManager.remove(thestd);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int numDeletedStd = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numDeletedStd;
    }
}
