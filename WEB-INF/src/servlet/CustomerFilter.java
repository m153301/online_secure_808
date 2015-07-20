package servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//customerがworkerに昇格することを防ぐフィルター

public class CustomerFilter implements Filter{
	
	/**
	 * コンテキストオブジェクト
	 */
	private ServletContext context;
	
	/**
	 * ログインページへのURL
	 */
	private String loginPage;
	
	/**
	 * ログ
	 */
	private Logger log = Logger.getLogger(getClass().getName());
	
	/* (非 Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// コンテキスト取得
		this.context = config.getServletContext();
		// URL取得
		this.loginPage = this.context.getInitParameter("loginPage");
		if(this.loginPage == null){
			log.info("login page is not set.Set default value.");
			this.loginPage = "../../jsp/common/Login.jsp";
		}
	}

	/* (非 Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// ダウンキャスト
		HttpServletRequest request = (HttpServletRequest) _request;
		HttpServletResponse response = (HttpServletResponse) _response;
		// セッション取得
		HttpSession session = request.getSession();
		// 認証済みならリクエストページへ
		if(session.getAttribute("worker") != null ){
			chain.doFilter(request,response);
			return;
		}
		else {
			// 未認証ならログインページへ
			session.invalidate();
			response.sendRedirect(response.encodeRedirectURL("../../jsp/common/Login.jsp"));
			return;
		}
	}

	/* (非 Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// 特記なし
	}
}