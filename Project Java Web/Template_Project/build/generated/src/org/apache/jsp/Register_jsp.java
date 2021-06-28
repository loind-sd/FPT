package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Đăng kí</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/register.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\" integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Merriweather:300,400,400i|Noto+Sans:400,400i,700\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"to\">\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <!--                <h2>Đăng ký</h2>\n");
      out.write("                                <label style=\"margin-left: -150px;\">Họ và tên</label>\n");
      out.write("                                <input type=\"text\" name=\"name\" id=\"name\">\n");
      out.write("                                <label>Số điện thoại</label>\n");
      out.write("                                <input type=\"text\" name=\"phone\" id=\"phone\">    \n");
      out.write("                                <label style=\"margin-left: -180px;\">Địa chỉ</label>\n");
      out.write("                                <input type=\"text\" name=\"address\" id=\"address\"> \n");
      out.write("                                <label style=\"margin-left: -135px;\">Tên tài khoản</label>\n");
      out.write("                                <input type=\"text\" name=\"user\"id=\"user\" >\n");
      out.write("                                <label style=\"margin-left: -160px;\">Mật khẩu</label>\n");
      out.write("                                <input type=\"password\" name=\"pass\" id=\"pass\">\n");
      out.write("                                <label style=\"margin-left: -95px;\">Nhập lại mật khẩu</label>\n");
      out.write("                                <input type=\"password\" name=\"rePass\" id=\"rePass\">\n");
      out.write("                                <input id=\"submit\" type=\"button\" onclick=\"check()\" name=\"submit\" value=\"Đăng ký\">-->\n");
      out.write("                <img class=\"bg-img\" src=\"https://mariongrandvincent.github.io/HTML-Personal-website/img-codePen/bg.jpg\" alt=\"\">\n");
      out.write("                <div class=\"connexion\">\n");
      out.write("                    <div class=\"contact-form\">\n");
      out.write("                        <label>FULL NAME</label>\n");
      out.write("                        <input placeholder=\"\" type=\"text\"name=\"name\">\n");
      out.write("                        \n");
      out.write("                        <label>PHONE NUMBER</label>\n");
      out.write("                        <input placeholder=\"\" type=\"text\" name=\"phone\">\n");
      out.write("                        \n");
      out.write("                        <label>ADDRESS</label>\n");
      out.write("                        <input placeholder=\"\" type=\"text\" name=\"address\">\n");
      out.write("                        \n");
      out.write("                        <label>USERNAME</label>\n");
      out.write("                        <input placeholder=\"\" type=\"text\" name=\"user\">\n");
      out.write("\n");
      out.write("                        <label>PASSWORD</label>\n");
      out.write("                        <input placeholder=\"\" type=\"password\" name=\"pass\">\n");
      out.write("\n");
      out.write("                        <label>RE-PASSWORD</label>\n");
      out.write("                        <input placeholder=\"\" type=\"password\" name=\"rePass\">\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        <input class=\"submit\" value=\"Register\" type=\"button\" onclick=\"check()\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>                \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function check() {\n");
      out.write("                var name = document.getElementById(\"name\").value;\n");
      out.write("                var phone = document.getElementById(\"phone\").value;\n");
      out.write("                var address = document.getElementById(\"address\").value;\n");
      out.write("                var username = document.getElementById(\"user\").value;\n");
      out.write("                var password = document.getElementById(\"pass\").value;\n");
      out.write("                var rePassword = document.getElementById(\"rePass\").value;\n");
      out.write("\n");
      out.write("                console.log(address, name, phone, username, password, rePassword);\n");
      out.write("\n");
      out.write("                if (name === \"\" || phone === \"\" || address === \"\" || username === \"\" || password === \"\" || rePassword === \"\") {\n");
      out.write("                    alert(\"Vui lòng điền vào các vị trí còn trống!\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (password !== rePassword) {\n");
      out.write("                    alert(\"Xác nhận mật khẩu không chính xác\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                window.location = \"register?name=\" + name + \"&phone=\" + phone + \"&address=\"\n");
      out.write("                        + address + \"&user=\" + username + \"&pass=\" + password;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
