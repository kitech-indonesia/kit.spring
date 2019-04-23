/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kit
 */
@Entity
@Table(name = "DETAIL")
public class Detail implements Serializable {

    @EmbeddedId
    private DetailPk detailPk;

    @Column(name = "HARGA")
    private Double harga;

    @Column(name = "JUMLAH")
    private Integer jumlah;

    @ManyToOne(targetEntity = Master.class,
            fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "ID_MASTER",
                referencedColumnName = "ID",
                insertable = false, updatable = false)
    })
    private Master master;

    @ManyToOne(targetEntity = Header.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HEADER",
            referencedColumnName = "ID",
            insertable = false, updatable = false)
    private Header header;

    public DetailPk getDetailPk() {
        return detailPk;
    }

    public void setDetailPk(DetailPk detailPk) {
        this.detailPk = detailPk;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}
