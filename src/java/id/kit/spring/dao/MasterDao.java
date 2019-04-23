/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.dao;

import id.kit.spring.model.Master;

/**
 *
 * @author kit
 */
public interface MasterDao {
    
    Master getById(String id);
    
}
