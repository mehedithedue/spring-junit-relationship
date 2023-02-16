package com.mehedi.jpa.jpql;

import com.mehedi.jpa.JpaApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaApplication.class)
public class CourseTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void courseGetAllNamedQuery(){
        Query query = em.createNamedQuery("get_all_courses");
        List result = query.getResultList();
        assertNotEquals(Collections.EMPTY_LIST, result);
    }

}
