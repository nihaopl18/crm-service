package com.yusys.streaminghub.app.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MultiReadHttpServletRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!(servletRequest instanceof HttpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        MultiReadeHttpServletRequest request = new MultiReadeHttpServletRequest(httpServletRequest);
        filterChain.doFilter(request,servletResponse);
    }
}
