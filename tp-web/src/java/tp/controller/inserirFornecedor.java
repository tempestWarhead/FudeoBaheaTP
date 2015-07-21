/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tp.model.domain.Fornecedor;
import tp.model.service.IManterFornecedor;
import tp.model.service.impl.ManterFornecedor;
import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;

/**
 *
 * @author LucasCésar
 */
public class inserirFornecedor extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserirFornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserirFornecedor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setNome( (String) request.getAttribute("nome"));
        fornecedor.setRazaoSocial( (String) request.getAttribute("razaoSocial"));
        
        IManterFornecedor fornecedorService = new ManterFornecedor();
        try {
            fornecedorService.cadastrar(fornecedor);
        } catch (PersistenciaException ex) {
            request.setAttribute("erro", "Falha no cadastro do fornecedor.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        } catch (NegocioException ex) {
            request.setAttribute("erro", "Por favor, preencha todos os campos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedorSucesso.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
