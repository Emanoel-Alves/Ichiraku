package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.PedidoDAO;
import model.Pedido;

@WebServlet("/api/pedidos/*")

public class PedidoService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PedidoService() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// GET BY ID
        String pathInfo = request.getPathInfo();
 
        if (pathInfo != null) {
            String[] params = pathInfo.split("/");
 
            if (params.length > 0) {
                Pedido pedido = PedidoDAO.getPedido(Integer.parseInt(params[1]));
 
                if (pedido != null) {
                    JSONObject jsonObject = new JSONObject();
 
                    jsonObject.put("id", pedido.getId());
                    jsonObject.put("idUser", pedido.getIdUser());
                    jsonObject.put("nome", pedido.getNome());
                    jsonObject.put("valorTotal", pedido.getValorTotal());
                   
                    
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print(jsonObject.toString());
                    response.getWriter().flush();
                } 
                return;
            }
        }
		
		
		// GET ALL
        List<Pedido> list = PedidoDAO.getAllPedidos();
 
        try {
            JSONArray jArray = new JSONArray();
 
            for (Pedido pedido : list) {
                JSONObject jsonObject = new JSONObject();
 
                jsonObject.put("id", pedido.getId());
                jsonObject.put("idUser", pedido.getIdUser());
                jsonObject.put("nome", pedido.getNome());
                jsonObject.put("valorTotal", pedido.getValorTotal());
               
 
                jArray.put(jsonObject);
            }
 
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jArray.toString());
            response.getWriter().flush();
        } catch (Exception e) {
 
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
        }
 
        Pedido pedido = null;
        JSONObject jsonObject = null;
 
        try {
            // Request
            jsonObject = new JSONObject(jb.toString());
            pedido = PedidoDAO.addPedido(jsonObject.getInt("idUser"),jsonObject.getString("nome"),jsonObject.getDouble("preco"));
 
            // Response
            jsonObject = new JSONObject();

            jsonObject.put("id", pedido.getId());
            jsonObject.put("idUser", pedido.getIdUser());
            jsonObject.put("nome", pedido.getNome());
            jsonObject.put("valorTotal", pedido.getValorTotal());
          

 
        } catch (JSONException e) {
        }
 
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonObject.toString());
        response.getWriter().flush();
    }
	
	
	 @Override
	    protected void doPut(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        // UPDATE BY ID
	        String pathInfo = request.getPathInfo();
	 
	        if (pathInfo != null) {
	            String[] params = pathInfo.split("/");
	 
	            if (params.length > 0) {
	                StringBuffer jb = new StringBuffer();
	                String line = null;
	                try {
	                    BufferedReader reader = request.getReader();
	                    while ((line = reader.readLine()) != null)
	                        jb.append(line);
	                } catch (Exception e) {
	                }
	 
	                Pedido pedido = null;
	                JSONObject jsonObject = null;
	 
	                try {
	                    // Request
	                    jsonObject = new JSONObject(jb.toString());
	                    pedido = PedidoDAO.updatePedido(Integer.parseInt(params[1]),jsonObject.getInt("idUser"), jsonObject.getString("nome"),jsonObject.getDouble("preco"));
	 
	                    // Response
	                    jsonObject = new JSONObject();
	                    
	                    jsonObject.put("id", pedido.getId());
	                    jsonObject.put("idUser", pedido.getIdUser());
	                    jsonObject.put("nome", pedido.getNome());
	                    jsonObject.put("valorTotal", pedido.getValorTotal());
	                   
	 
	                } catch (JSONException e) {
	                }
	 
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().print(jsonObject.toString());
	                response.getWriter().flush();
	            }
	        }
	    }
	 
	 @Override
	    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // DELETE BY ID
	        String pathInfo = request.getPathInfo();
	 
	        if (pathInfo != null) {
	            String[] params = pathInfo.split("/");
	 
	            if (params.length > 0) {
	                PedidoDAO.deletePedido(Integer.parseInt(params[1]));
	 
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }

}

