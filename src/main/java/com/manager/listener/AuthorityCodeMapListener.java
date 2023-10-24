package com.manager.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;

@WebListener
public class AuthorityCodeMapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Map<Integer, String> authorityName = Map.of(1, "網站管理", 2, "客服管理", 3, "課程管理", 4, "商品管理", 5, "員工管理");

        servletContext.setAttribute("authorityName", authorityName);

    }
}
