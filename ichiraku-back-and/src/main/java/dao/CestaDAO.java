package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cesta;
import util.DbUtil;

public class CestaDAO {
	
	private static Connection connection = DbUtil.getConnection();
	 
    public static Cesta addPrato(int idPrato, int idUsuario, String nomePrato, double valorPrato) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO cesta (idPrato, idUsuario, nomePrato, valorPrato) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, idPrato);
            pStmt.setInt(2, idUsuario);
            pStmt.setString(3, nomePrato);
            pStmt.setDouble(4, valorPrato);
            pStmt.executeUpdate();
            System.out.println("entrouu\n\n\n\n\n\n");
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Cesta(rs.getInt("id"), rs.getInt("idPrato"), rs.getInt("idUsuario"), rs.getString("nomePrato"), rs.getDouble("valorPrato"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static Cesta updatePrato(int id, int idPrato, int idUsuario, String nomePrato, double valorPrato) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("update cesta set idPrato=?, idUsuario=?, nomePrato=?, valorPrato=? where id=?",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, idPrato);
            pStmt.setInt(2, idUsuario);
            pStmt.setString(3, nomePrato);
            pStmt.setDouble(4, valorPrato);
            pStmt.setInt(5, id);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
            	return new Cesta(rs.getInt("id"), rs.getInt("idPrato"), rs.getInt("idUsuario"), rs.getString("nomePrato"), rs.getDouble("valorPrato"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static void deletePrato(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("delete from cesta where id=?");
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // RETORNA TODOS PELO USUARIO
    public static List<Cesta> getAllPratosByUsuario(int id) {
        List<Cesta> pratos = new ArrayList<Cesta>();
        try {
        	PreparedStatement pStmt = connection.prepareStatement("select * from cesta where idUsuario=?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
            	Cesta cesta = new Cesta(rs.getInt("id"), rs.getInt("idPrato"), rs.getInt("idUsuario"), rs.getString("nomePrato"), rs.getDouble("valorPrato"));
                pratos.add(cesta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return pratos;
    }
 
//    public static Cesta getPrato(int id) {
//        try {
//            PreparedStatement pStmt = connection.prepareStatement("select * from cesta where id=?");
//            pStmt.setInt(1, id);
//            ResultSet rs = pStmt.executeQuery();
//            if (rs.next()) {
//                return new Cesta(rs.getInt("id"), rs.getInt("idPrato"), rs.getInt("idUsuario"), rs.getString("nomePrato"), rs.getDouble("valorPrato"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
// 
//        return null;
//    }	
	
}
