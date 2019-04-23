/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.dao;

import id.kit.spring.model.Master;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kit
 */
@Repository(value = "masterDao")
public class MasterDaoImpl implements MasterDao{

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;
    
    @Override
    public Master getById(String id) {
        return (Master)sessionFactory.getCurrentSession().get(Master.class, id);
    }
    
}
