package cn.com.yusys.yusp.admin.web.filter;

import com.yusys.streaminghub.app.service.ISSOService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StreamingHubFilter extends OncePerRequestFilter  {
    ISSOService ssoServiceStreamingHub;

    public StreamingHubFilter(ISSOService ssoServiceStreamingHub) {
        this.ssoServiceStreamingHub = ssoServiceStreamingHub;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletRequest.setAttribute("ssoServiceStreamingHub",ssoServiceStreamingHub);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
