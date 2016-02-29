/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rodrigo
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = "") 
public class FiltroAutenticaçao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            
            
        String uri = httpRequest.getRequestURI();
        HttpSession sessao = httpRequest.getSession(false);
        
        
      if(sessao != null
      || uri.lastIndexOf("login") != -1 
      || uri.lastIndexOf("autenticador.do") != -1){
          chain.doFilter(request, response);  
      }else{
          httpResponse.sendRedirect("login.html");
      }
        
        
        
        
        
        
        

    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
