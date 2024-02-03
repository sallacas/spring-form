package com.springform.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Random;


@Component("Timelapse")
public class TimelapseInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TimelapseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }
        if (handler instanceof HandlerMethod method) {
            logger.info("Method of controller " + method.getMethod().getName());
        }
        logger.info("Interceptor: PreHandle() joining...");
        logger.info("Interceptors " + handler);
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        int delay = new Random().nextInt(1000);
        Thread.sleep(delay);
        //response.sendRedirect(request.getContextPath().concat("/404"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (request.getMethod().equalsIgnoreCase("post")) {
            return;
        }
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long timelapse = end - start;

        if (handler instanceof HandlerMethod && Objects.nonNull(modelAndView)) {
            modelAndView.addObject("timelapse", timelapse);
        }
        logger.info("Timelapse: ".concat(String.valueOf(timelapse)).concat(" mls"));
        logger.info("Interceptor: PreHandle() joining...");
    }
}
