package com.yyece.his.controller;

/**
 * Created with IntelliJ IDEA.
 * User: wo
 * Date: 2020/3/12
 * PACKAGE_NAME:com.yyece.his.controller
 */
import com.baomidou.mybatisplus.extension.api.ApiController;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends ApiController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String doctorid;
    protected String doctorname;
    protected Claims claims;
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @ModelAttribute
    public void setResAnReq(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;

        Object obj = request.getAttribute("user_claims");
        log.info("---------------------eeeeeeeeeeeeeeeeeeee----------------------------");
        log.info((String)obj);

        if(obj != null) {
            this.claims = (Claims) obj;
            this.doctorid = (String)claims.get("doctorid");
            this.doctorname = (String)claims.get("doctorname");
        }
    }
}
