package com.roytuts.servlet.nocache.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class NoCacheFilter implements Filter {

	public NoCacheFilter() {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpServletResp = (HttpServletResponse) response;
		// set cache directives
		httpServletResp.setHeader(HTTPCacheHeader.CACHE_CONTROL.getName(), "no-cache, no-store, must-revalidate"); // HTTP
																													// 1.1
		httpServletResp.setHeader(HTTPCacheHeader.PRAGMA.getName(), "no-cache"); // HTTP 1.0
		httpServletResp.setDateHeader(HTTPCacheHeader.EXPIRES.getName(), 0L); // Proxies

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
