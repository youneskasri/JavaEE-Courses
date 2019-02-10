@WebFilter(filterName = "authentication", 
	urlPatterns = "/admins/*",
	servletNames = "AdminRequestHandler")
public class AuthenticationFilter implements Filter {
	@Override
	doFilter(ServletRequest req, ServletResponse res, FilterChain 
chain) {
		HttpServletRequest httpRequest = (HttpServletRequest) 
req;
		if 
(httpRequest.getSession().getAttribute("USER_TYPE").equals("ADMIN")) {
			chain.doFilter(httpRequest, response);
		} else {
			HttpServletResponse httpResponse =  ()res;
			httpResponse.sendRedirect("/admin-login.html");
		}
	}
}
