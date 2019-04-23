/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.rest;

import java.util.List;
import id.kit.spring.vo.VoHeader;
import id.kit.spring.vo.VoInputSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import id.kit.spring.service.KitService;

/**
 *
 * @author kit
 */
@Controller
@RequestMapping("/kit")
public class KitRest {
    
    @Autowired
    @Qualifier(value = "kitService")
    private KitService kitService;
    
    @RequestMapping(value = "save-header"
            , method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    VoHeader saveHeader(
            @RequestBody VoHeader voHeader) {        
        return kitService.saveHeader(voHeader);
    }
    
    @RequestMapping(value = "get-header"
            , method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<VoHeader> getHeader(
            @RequestBody VoInputSearchParam voInputSearchParam) {        
        return kitService.getHeader(voInputSearchParam);
    }
    
//    @RequestMapping(value = "get-header"
//            , method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//   String getHeader(@RequestBody VoInputSearchParam voInputSearchParam) {
//        return "Hai";
//    }
    
    
    @RequestMapping(value = "test"
            , method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveHeader() {        
        return "Hai";
    }
    
}
