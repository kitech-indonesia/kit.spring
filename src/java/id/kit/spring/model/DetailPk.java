/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kit
 */
@Embeddable
public class DetailPk implements Serializable {

    @Column(name = "ID_HEADER")
    private String idHeader;

    @Column(name = "ID_MASTER")
    private String idMaster;

    public DetailPk() {
    }

    public DetailPk(String idHeader, String idMaster) {
        this.idHeader = idHeader;
        this.idMaster = idMaster;
    }

    public String getIdHeader() {
        return idHeader;
    }

    public void setIdHeader(String idHeader) {
        this.idHeader = idHeader;
    }

    public String getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(String idMaster) {
        this.idMaster = idMaster;
    }

}
