/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import id.kit.spring.dao.HeaderDao;
import id.kit.spring.dao.MasterDao;
import id.kit.spring.model.Detail;
import id.kit.spring.model.DetailPk;
import id.kit.spring.model.Header;
import id.kit.spring.model.Master;
import id.kit.spring.vo.VoDetail;
import id.kit.spring.vo.VoHeader;
import id.kit.spring.vo.VoInputSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kit
 */
@Service(value = "kitService")
@Transactional(readOnly = true)
public class KitServiceImpl implements KitService {

    @Autowired
    @Qualifier(value = "headerDao")
    private HeaderDao headerDao;

    @Autowired
    @Qualifier(value = "masterDao")
    private MasterDao masterDao;
    
  

    @Override
    @Transactional(readOnly = false)
    public VoHeader saveHeader(VoHeader voHeader) {
        try {
            Header header = new Header();
            header.setId(voHeader.getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            header.setTgl(sdf.parse(voHeader.getTgl()));
            List<Detail> details = new ArrayList<Detail>();
            if (!voHeader.getDetails().isEmpty()) {
                for (VoDetail voDetail : voHeader.getDetails()) {
                    Detail detail = new Detail();
                    detail.setDetailPk(new DetailPk(voHeader.getId(), voDetail.getIdMaster()));
                    Master master = masterDao.getById(voDetail.getIdMaster());
                    detail.setJumlah(voDetail.getJumlah());
                    detail.setHarga(master.getHarga());
                    details.add(detail);
                }
                header.setDetails(details);
            }            
            headerDao.save(header);
            return voHeader;
        } catch (ParseException ex) {
            Logger.getLogger(KitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<VoHeader> getHeader(VoInputSearchParam voInputSearchParam) {
        try {
            List<VoHeader> listHeader = new ArrayList<VoHeader>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            Date start = sdf.parse(voInputSearchParam.getStart());
            Date end = sdf.parse(voInputSearchParam.getEnd());
            List<Header> list = headerDao.getByDate(start, end);
            for (Header header : list) {
                VoHeader voHeader = new VoHeader();
                voHeader.setId(header.getId());
                voHeader.setTgl(sdf.format(header.getTgl()));
                List<VoDetail> listDetail = new ArrayList<VoDetail>();
                for (Detail detail : header.getDetails()) {
                    VoDetail voDetail = new VoDetail();
                    voDetail.setHarga(detail.getHarga());
                    voDetail.setIdMaster(detail.getDetailPk().getIdMaster());
                    voDetail.setJumlah(detail.getJumlah());
                    listDetail.add(voDetail);
                }
                voHeader.setDetails(listDetail);
                listHeader.add(voHeader);
            }
            return listHeader;
        } catch (ParseException ex) {
            Logger.getLogger(KitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
