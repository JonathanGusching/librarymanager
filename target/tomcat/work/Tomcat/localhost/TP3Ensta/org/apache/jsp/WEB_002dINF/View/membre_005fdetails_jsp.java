/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-03-28 14:07:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class membre_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Library Management</title>\n");
      out.write("  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>\n");
      out.write("  <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css\">\n");
      out.write("  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"assets/css/custom.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("  <main>\n");
      out.write("    <section class=\"content\">\n");
      out.write("      <div class=\"page-announce valign-wrapper\">\n");
      out.write("        <a href=\"#\" data-activates=\"slide-out\" class=\"button-collapse valign hide-on-large-only\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("        <h1 class=\"page-announce-text valign\">Fiche membre</h1>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("      <h5>Détails du membre n°");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h5> <!-- TODO : remplacer 007 par l'id du membre -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("\t      <form action=\"/TP3Ensta/membre_details?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" method=\"post\" class=\"col s12\"> <!-- TODO : remplacer idDuMembre par l'id du membre -->\n");
      out.write("\t        <div class=\"row\">\n");
      out.write("\t          <div class=\"input-field col s4\">\n");
      out.write("\t            <input id=\"nom\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getNom() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"nom\"> <!-- TODO : remplacer nomDuMembre par le nom du membre -->\n");
      out.write("\t            <label for=\"nom\">Nom</label>\n");
      out.write("\t          </div>\n");
      out.write("\t          <div class=\"input-field col s4\">\n");
      out.write("\t            <input id=\"prenom\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getPrenom() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"prenom\"> <!-- TODO : remplacer prenomDuMembre par le prénom du membre -->\n");
      out.write("\t            <label for=\"prenom\">Prénom</label>\n");
      out.write("\t          </div>\n");
      out.write("\t          <div class=\"input-field col s4\">\n");
      out.write("\t            <select name=\"abonnement\" class=\"browser-default\">\n");
      out.write("\t              <!-- TODO : faire en sorte que l'option correspondant à l'abonnement du membre soit sélectionnée par défaut -->\n");
      out.write("\t              <!-- Pour cela, vous devez rajouter l'attribut selecter sur la balise <option> concernée -->\n");
      out.write("\t              <option value=\"BASIC\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(membre.abonnement == \"BASIC\") ? \" selected\" : \"\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">Abonnement BASIC</option>\n");
      out.write("\t              <option value=\"PREMIUM\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(membre.abonnement == \"PREMIUM\") ? \" selected\" : \"\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">Abonnement PREMIUM</option>\n");
      out.write("\t              <option value=\"VIP\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(membre.abonnement == \"VIP\") ? \" selected\" : \"\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">Abonnement VIP</option>\n");
      out.write("\t            </select>\n");
      out.write("\t          </div>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"row\">\n");
      out.write("\t          <div class=\"input-field col s12\">\n");
      out.write("\t            <input id=\"adresse\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getAdresse() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"adresse\"> <!-- TODO : remplacer adresseDuMembre par l'adresse du membre -->\n");
      out.write("\t            <label for=\"adresse\">Adresse</label>\n");
      out.write("\t          </div>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"row\">\n");
      out.write("\t          <div class=\"input-field col s6\">\n");
      out.write("\t            <input id=\"email\" type=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getEmail()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"email\"> <!-- TODO : remplacer emailDuMembre par l'email du membre -->\n");
      out.write("\t            <label for=\"email\">E-mail</label>\n");
      out.write("\t          </div>\n");
      out.write("\t          <div class=\"input-field col s6\">\n");
      out.write("\t            <input id=\"telephone\" type=\"tel\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getTelephone() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"telephone\"> <!-- TODO : remplacer telephoneDuMembre par le téléphone du membre -->\n");
      out.write("\t            <label for=\"telephone\">Téléphone</label>\n");
      out.write("\t          </div>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"row center\">\n");
      out.write("\t          <button class=\"btn waves-effect waves-light\" type=\"submit\">Enregistrer</button>\n");
      out.write("\t          <button class=\"btn waves-effect waves-light orange\" type=\"reset\">Annuler</button>\n");
      out.write("\t        </div>\n");
      out.write("\t      </form>\n");
      out.write("\t      \n");
      out.write("\t      <form action=\"/TP3Ensta/membre_delete\" method=\"get\" class=\"col s12\">\n");
      out.write("\t        <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${membre.getId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"id\"> <!-- TODO : remplacer idDuMembre par l'id du membre -->\n");
      out.write("\t        <div class=\"row center\">\n");
      out.write("\t          <button class=\"btn waves-effect waves-light red\" type=\"submit\">Supprimer le membre\n");
      out.write("\t            <i class=\"material-icons right\">delete</i>\n");
      out.write("\t          </button>\n");
      out.write("\t        </div>\n");
      out.write("\t      </form>\n");
      out.write("\t    </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col s12\">\n");
      out.write("\t        <table class=\"striped\">\n");
      out.write("              <thead>\n");
      out.write("                <tr>\n");
      out.write("                  <th>Livre</th>\n");
      out.write("                  <th>Date d'emprunt</th>\n");
      out.write("                  <th>Retour</th>\n");
      out.write("                </tr>\n");
      out.write("              </thead>\n");
      out.write("              <tbody id=\"results\">\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- TODO : parcourir la liste des emprunts en cours pour ce membre et les afficher selon la structure d'exemple ci-dessus -->\n");
      out.write("              </tbody>\n");
      out.write("            </table>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("  </main>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/View/membre_details.jsp(89,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("emprunt");
    // /WEB-INF/View/membre_details.jsp(89,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/View/membre_details.jsp(89,16) '${emprunts}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${emprunts}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <tr>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${emprunt.getLivre().getTitre() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${emprunt.getDateEmprunt() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                  <td>\n");
          out.write("                    <a href=\"emprunt_return?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${emprunt.getId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">Retour<ion-icon class=\"table-item\" name=\"log-in\"></a>\n");
          out.write("                  </td>\n");
          out.write("                </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
