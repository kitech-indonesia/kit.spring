/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.service;

import java.util.List;
import id.kit.spring.vo.VoHeader;
import id.kit.spring.vo.VoInputSearchParam;

/**
 *
 * @author kit
 */
public interface KitService {
    
    VoHeader saveHeader(VoHeader voHeader);
    List<VoHeader> getHeader(VoInputSearchParam voInputSearchParam);
    
}
