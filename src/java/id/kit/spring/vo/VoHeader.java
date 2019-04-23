/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author kit
 */
public class VoHeader {

    private String id;

    private String tgl;

    private List<VoDetail> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public List<VoDetail> getDetails() {
        return details;
    }

    public void setDetails(List<VoDetail> details) {
        this.details = details;
    }

}
