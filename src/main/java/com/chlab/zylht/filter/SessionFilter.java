package com.chlab.zylht.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.chlab.zylht.entity.User;


public class SessionFilter extends OncePerRequestFilter {
	public List<String> excludes = new ArrayList<String>();
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String path = request.getServletPath();

		User user = (User) request.getSession().getAttribute("user");
		if (excludes.contains(path)) {
			filterChain.doFilter(request, response);
			return;
		} else {
			if(null == user) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
			else {
				filterChain.doFilter(request, response);
				return;
			}
		}
		
	}
}
