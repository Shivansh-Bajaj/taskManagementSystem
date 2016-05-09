package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Welcome</title> \n");
      out.write("             <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n");
      out.write("             <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" > \n");
      out.write("             <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\" ></script> \n");
      out.write("             <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" ></script> \n");
      out.write("              \n");
      out.write("            \n");
      out.write("</head>\n");
      out.write("</html><div class=\"container-fluid\"> \n");
      out.write("             <div class=\"page-header\" align=\"center\"> \n");
      out.write("                 <h1>Manage your projects</h1> \n");
      out.write("                 <p></p>\n");
      out.write("             </div> <div align=\"center\" class=\"col-md-6\"><a href=\"/taskmanagement/Signup\"><button type=\"button\" class=\"btn btn-success\" >SignUp</button></a></div> \n");
      out.write("             <div align=\"center\"  class=\"col-md-6\"> <a href=\"/taskmanagement/login\"><button type=\"button\" class=\"btn btn-info\">Login</button></a></div></div>\n");
      out.write("            \n");
      out.write("         </body> \n");
      out.write("         </html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
