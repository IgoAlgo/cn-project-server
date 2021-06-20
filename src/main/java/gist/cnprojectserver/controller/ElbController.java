package gist.cnprojectserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class ElbController {

    @Value("${ami-id:N/A}")
    private String amiId;

    @Value("${hostname:N/A}")
    private String hostname;

    @Value("${instance-type:N/A}")
    private String instanceType;

    @Value("${services/domain:N/A}")
    private String serviceDomain;

    @GetMapping("/hello")
    public String getPrivateIP() {
//        return "123";
        return amiId + "\n\r\n\r" + hostname + "\n\r\n\r" + instanceType + "\n\r" + serviceDomain;
    }
}