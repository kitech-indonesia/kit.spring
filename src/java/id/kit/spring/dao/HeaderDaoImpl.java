/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.dao;

import java.util.Date;
import java.util.List;
import id.kit.spring.model.Header;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kit
 */
@Repository(value = "headerDao")
public class HeaderDaoImpl implements HeaderDao{

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;
    
    @Override
    public Header save(Header header) {
        sessionFactory.getCurrentSession().save(header);
        return header;
    }

    @Override
    public List<Header> getByDate(Date start, Date end) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Header.class, "header");
        criteria.add(Restrictions.between("tgl", start, end));
        return (List<Header>) criteria.list();
    }
}
