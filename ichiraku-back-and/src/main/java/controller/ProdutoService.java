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

import dao.ProdutoDAO;
import model.Produto;


@WebServlet("/api/produtos/*")
public class ProdutoService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProdutoService() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        // GET BY ID
        String pathInfo = request.getPathInfo();
 
        if (pathInfo != null) {
            String[] params = pathInfo.split("/");
 
            if (params.length > 0) {
                Produto produto = ProdutoDAO.getProduto(Integer.parseInt(params[1]));
 
                if (produto != null) {
                    JSONObject jsonObject = new JSONObject();
 
                    jsonObject.put("id", produto.getId());
                    jsonObject.put("nome", produto.getNome());
                    jsonObject.put("ingredientes", produto.getIngredientes());
                    jsonObject.put("preco", produto.getPreco());
                    jsonObject.put("categoria", produto.getCategoria());
                    
 
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print(jsonObject.toString());
                    response.getWriter().flush();
                } 
                return;
            }
        }
 

 
        // GET ALL
        List<Produto> list = ProdutoDAO.getAllProdutos();
 
        try {
            JSONArray jArray = new JSONArray();
 
            for (Produto produto : list) {
                JSONObject jsonObject = new JSONObject();
 
                jsonObject.put("id", produto.getId());
                jsonObject.put("nome", produto.getNome());
                jsonObject.put("ingredientes", produto.getIngredientes());
                jsonObject.put("preco", produto.getPreco());
                jsonObject.put("categoria", produto.getCategoria());
 
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
		 
		StringBuffer jb = new StringBuffer();
	        String line = null;
	        try {
	            BufferedReader reader = request.getReader();
	            while ((line = reader.readLine()) != null)
	                jb.append(line);
	        } catch (Exception e) {
	        }
	 
	        Produto produto = null;
	        JSONObject jsonObject = null;
	 
	        try {
	            // Request
	            jsonObject = new JSONObject(jb.toString());
	            produto = ProdutoDAO.addProduto(jsonObject.getString("nome"), jsonObject.getString("ingredientes"),
	            		jsonObject.getDouble("preco"), jsonObject.getString("categoria"));
	            System.out.println(produto+ "\n\n\n\n\n");
	            // Response
	            jsonObject = new JSONObject();
	            jsonObject.put("id", produto.getId());
                jsonObject.put("nome", produto.getNome());
                jsonObject.put("ingredientes", produto.getIngredientes());
                jsonObject.put("preco", produto.getPreco());
                jsonObject.put("categoria", produto.getCategoria());
	 
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
 
                Produto produto = null;
                JSONObject jsonObject = null;
 
                try {
                    // Request
                    jsonObject = new JSONObject(jb.toString());
                    produto = ProdutoDAO.updateProduto(Integer.parseInt(params[1]), jsonObject.getString("nome"), jsonObject.getString("ingredientes"),
    	            		jsonObject.getDouble("preco"), jsonObject.getString("categoria"));
 
                    // Response
                    jsonObject = new JSONObject();
                    jsonObject.put("id", produto.getId());
                    jsonObject.put("nome", produto.getNome());
                    jsonObject.put("ingredientes", produto.getIngredientes());
                    jsonObject.put("preco", produto.getPreco());
                    jsonObject.put("categoria", produto.getCategoria());
 
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
	                ProdutoDAO.deleteProduto(Integer.parseInt(params[1]));
	 
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }
	
}
