package com.yusys.streaminghub.app.filter;

import org.springframework.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiReadeHttpServletRequest extends HttpServletRequestWrapper {
    String body;
    String accessToken;
    @Override
    public String getParameter(String name) {
        if ("access_token".equals(name)) {
            String accessToken=super.getParameter("access_token");
            if (!StringUtils.isEmpty(accessToken)) {
                return accessToken;
            }
            return this.accessToken;
        }
        return super.getParameter(name);
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public MultiReadeHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        body = sb.toString();
    }
    public String getBody(){
        return body;
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream in = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return in.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}
