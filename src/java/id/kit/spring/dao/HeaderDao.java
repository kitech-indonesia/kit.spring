/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.dao;

import java.util.Date;
import java.util.List;
import id.kit.spring.model.Header;

/**
 *
 * @author kit
 */
public interface HeaderDao {
    
    Header save(Header header);
    List<Header> getByDate(Date start , Date end);
    
}
