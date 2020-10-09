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

import dao.CestaDAO;
import model.Cesta;

@WebServlet("/api/cestas/*")
public class CestaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CestaService() {
		super();
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        // GET BY ID
//        String pathInfo = request.getPathInfo();
// 
//        if (pathInfo != null) {
//            String[] params = pathInfo.split("/");
// 
//            if (params.length > 0) {
//                Cesta cesta = CestaDAO.getPrato(Integer.parseInt(params[1]));
// 
//                if (cesta != null) {
//                    JSONObject jsonObject = new JSONObject();
// 
//                    jsonObject.put("id", cesta.getId());
//                    jsonObject.put("idPrato", cesta.getIdPrato());
//                    jsonObject.put("idUsuario", cesta.getIdUsuario());
//                    jsonObject.put("nomePrato", cesta.getNomePrato());
//                    jsonObject.put("valorPrato", cesta.getValorPrato());
//                    
// 
//                    response.setContentType("application/json");
//                    response.setCharacterEncoding("UTF-8");
//                    response.getWriter().print(jsonObject.toString());
//                    response.getWriter().flush();
//                } 
//                return;
//            }
//        }
// 

 
        // GET ALL
	 String pathInfo = request.getPathInfo();
	 if (pathInfo != null) {
       String[] params = pathInfo.split("/");
//
       if (params.length > 0) {
//           Cesta cesta = CestaDAO.getPrato();
        List<Cesta> list = CestaDAO.getAllPratosByUsuario(Integer.parseInt(params[1]));
 
        try {
            JSONArray jArray = new JSONArray();
 
            for (Cesta cesta : list) {
                JSONObject jsonObject = new JSONObject();
 
                jsonObject.put("id", cesta.getId());
                jsonObject.put("idPrato", cesta.getIdPrato());
                jsonObject.put("idUsuario", cesta.getIdUsuario());
                jsonObject.put("nomePrato", cesta.getNomePrato());
                jsonObject.put("valorPrato", cesta.getValorPrato());
 
                jArray.put(jsonObject);
            }
 
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jArray.toString());
            response.getWriter().flush();
        } catch (Exception e) {
 
        }
        }
       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Cesta cesta = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			cesta = CestaDAO.addPrato(jsonObject.getInt("idPrato"), jsonObject.getInt("idUsuario"),
					jsonObject.getString("nomePrato"), jsonObject.getDouble("valorPrato"));
			System.out.println(cesta + "\n\n\n\n\n");
			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", cesta.getId());
			jsonObject.put("idPrato", cesta.getIdPrato());
			jsonObject.put("idUsuario", cesta.getIdUsuario());
			jsonObject.put("nomePrato", cesta.getNomePrato());
			jsonObject.put("valorPrato", cesta.getValorPrato());

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

				Cesta cesta = null;
				JSONObject jsonObject = null;

				try {
					// Request
					jsonObject = new JSONObject(jb.toString());
					cesta = CestaDAO.updatePrato(Integer.parseInt(params[1]), jsonObject.getInt("idPrato"),
							jsonObject.getInt("idUsuario"), jsonObject.getString("nomePrato"),
							jsonObject.getDouble("valorPrato"));

					// Response
					jsonObject = new JSONObject();

					jsonObject.put("id", cesta.getId());
					jsonObject.put("idPrato", cesta.getIdPrato());
					jsonObject.put("idUsuario", cesta.getIdUsuario());
					jsonObject.put("nomePrato", cesta.getNomePrato());
					jsonObject.put("valorPrato", cesta.getValorPrato());

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
				CestaDAO.deletePrato(Integer.parseInt(params[1]));

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().flush();
			}
		}
	}

}
