package by.bsuir.Kursov_vsrpp.Servlet;

import by.bsuir.Kursov_vsrpp.Modeler.Modeler;
import by.bsuir.Kursov_vsrpp.Zayav.Zayav;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        
        Modeler base = new Modeler();
  
        String command = request.getParameter("command");    
        System.out.println("suqa "+command);
        switch (command){
            case "show":{
                System.out.println("Nachalo show_contr");
                ArrayList<Zayav> baseTemp = new ArrayList<> ();
                baseTemp = base.showBase();
                for (Zayav baseTemp1 : baseTemp)
                    System.out.println(baseTemp1);
                System.out.println("Seredina show_contr");
                request.setAttribute("lst", baseTemp);
                request.getRequestDispatcher("/view.jsp").forward(request,response); 
                System.out.println("Konec show_contr");
            }
            break;
                
            case "add":{
                System.out.println("Nachalo insert_contr");
                base.insertIntoZayav(   Integer.parseInt(request.getParameter("N")),
                                        request.getParameter("Tovar"),
                                        Integer.parseInt(request.getParameter("Kolich")),
                                        Integer.parseInt(request.getParameter("Stoim")),
                                        request.getParameter("FIO"),
                                        request.getParameter("Adres"),
                                        Integer.parseInt(request.getParameter("Telef")),
                                        request.getParameter("Data"),
                                        Boolean.parseBoolean(request.getParameter("Status"))
                                        );
                System.out.println("Seredina insert_contr");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                System.out.println("Konec insert_contr");
            }
            break;
                
            case "update":{
                System.out.println("Nachalo update_contr");
                base.updateZayav(
                                    Integer.parseInt(request.getParameter("N")),
                                    request.getParameter("Tovar"),
                                    Integer.parseInt(request.getParameter("Kolich")),
                                    Integer.parseInt(request.getParameter("Stoim")),
                                    request.getParameter("FIO"),
                                    request.getParameter("Adres"),
                                    Integer.parseInt(request.getParameter("Telef")),
                                    request.getParameter("Data"),
                                    Boolean.parseBoolean(request.getParameter("Status"))
                                    );
                System.out.println("Seredina update_contr");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                System.out.println("Konec update_contr");
            }
            break;
                
            case "delete":{
                base.deleteFromZayav(request.getParameter("N"));
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
            break;   
                
            case "search":{
                ArrayList<Zayav> baseTemp = new ArrayList<> ();
                baseTemp = base.search(request.getParameter("Tovar"));
                for (Zayav baseTemp1 : baseTemp)
                    System.out.println(baseTemp1);
                request.setAttribute("lst", baseTemp);
                request.getRequestDispatcher("/view.jsp").forward(request,response);
            }
            break;    
            
            case "prib":{
                ArrayList<String> msg = new ArrayList<String>(2);
                msg = base.prib();
                System.out.println(msg);
                request.setAttribute("lst", msg);
                request.getRequestDispatcher("/rezult.jsp").forward(request,response);
            }
            break;    
                
            case "home" :{
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            break; 
                
            case "goInsert" :{
                request.getRequestDispatcher("/insert.jsp").forward(request, response);
            }    
            break;
                            
            case "goUpdate" :{
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            }
            break; 
                
            case "goSearch" :{
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
            case "goDelete" :{
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
            }
            break; 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
