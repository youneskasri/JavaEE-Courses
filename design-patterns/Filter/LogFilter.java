
@WebFitler(filterName = "log", 
	urlPatterns = "/admins*",
	servletNames = "adminRequestHandler")
public class LogFilter implements Filter {
	
	@Inject 
	private Logger logger;

	@Override
	doFilter(req, res, chain) throws IOException, ServletException{
		logger.info(request.getContentType());
		chain.doFilter(req, res);

		/* After the chain, useful when: compressing files in 
the fly, crypt the content etc..*/
		logger.info(response.getContent());
	}
}
