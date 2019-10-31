package com.realestate.demo.bl.service;

import com.realestate.demo.model.Customer;
import com.realestate.demo.model.CustomerModel;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerRepository extends SimpleJpaRepository<CustomerModel, Long> {

    private final EntityManager entityManager;

    public CustomerRepository(EntityManager em) {
        super(CustomerModel.class, em);
        this.entityManager = em;
    }

    //to do  generate CustomerModel_


//     <dependency>
//            <groupId>org.hibernate</groupId>
//            <artifactId>hibernate-core</artifactId>
//        </dependency>


//<plugin>
//        <artifactId>maven-compiler-plugin</artifactId>
//        <configuration>
//          <source>1.7</source>
//          <target>1.7</target>
//          <compilerArguments>
//            <processor>org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor</processor>
//          </compilerArguments>
//        </configuration>
//      </plugin>


//    public List<CustomerModel> getRequired(String keyword, String text) {
//        Long id;
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<CustomerModel> cr = cb.createQuery(CustomerModel.class);
//        Root<CustomerModel> root = cr.from(CustomerModel.class);
//        cr.select(root);
//        if (keyword.equals("File Name")) {
//            cr.select(root).where(cb.like(root.get(CustomerModel_.IMAGE_NAME), "%" + text.toLowerCase() + "%"));
//        } else if (keyword.equals("Type")) {
//            cr.select(root).where(cb.like(root.get(ImageEntity_.IMAGE_TYPE), "%" + text.toLowerCase() + "%"));
//        } else if (keyword.equals("Size")) {
//            cr.select(root).where(cb.like(root.get(ImageEntity_.IMAGE_SIZE), "%" + text.toLowerCase() + "%"));
//        } else if (keyword.equals("ID")) {
//            try {
//                id = Long.valueOf(text);
//            } catch (NumberFormatException e) {
//                id = 0L;
//            }
//            cr.select(root).where(cb.equal(root.get(ImageEntity_.IMAGE_ID), id));
//        }
//        return entityManager.createQuery(cr).getResultList();
//    }

}
