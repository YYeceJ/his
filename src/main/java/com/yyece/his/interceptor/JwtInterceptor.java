package com.yyece.his.interceptor;

import com.yyece.his.entity.ResultCode;
import com.yyece.his.exception.CommonException;
import com.yyece.his.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * 继承HandlerInterceptorAdapter
 * <p>
 * preHandle:进入到控制器方法之前执行的内容
 * boolean：
 * true：可以继续执行控制器方法
 * false：拦截
 * posthandler：执行控制器方法之后执行的内容
 * afterCompletion：响应结束之前执行的内容
 * <p>
 * 1.简化获取token数据的代码编写
 * 统一的用户权限校验（是否登录）
 * 2.判断用户是否具有当前访问接口的权限
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    /**
     * 简化获取token数据的代码编写（判断是否登录）
     * 1.通过request获取请求token信息
     * 2.从token中解析获取claims
     * 3.将claims绑定到request域中
     */
    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.通过request获取请求token信息
        String authorization = request.getHeader("Authorization");
        //判断请求头信息是否为空，或者是否已Bearer开头
        if (!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
            //获取token数据
            String token = authorization.replace("Bearer ", "");
            log.info("====token====="+token);
            //解析token获取claims
            Claims claims = jwtUtils.parseJwt(token);
            //通过handler
            HandlerMethod h = (HandlerMethod) handler;
            //获取接口上的reqeustmapping注解
            RequestMapping annotation = h.getMethodAnnotation(RequestMapping.class);
            //获取当前请求接口中的name属性
            if (claims != null) {
                request.setAttribute("user_claims", claims);
            } else {
                throw new CommonException(ResultCode.UNAUTHORISE);
            }
        }
        return true;
    }
}
