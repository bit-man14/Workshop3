package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.OutputStream;

@WebFilter("/*")
public class FilterUTF8 implements Filter {
    private String charsetEncoding = "UTF-8";
    private String contentType = "text/html;charset=UTF-8";
    
    public void destroy() {
    }
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);
        filterChain.doFilter(request, response);
    }
    
    
    public void init(FilterConfig config) {
        
    }
    
}
