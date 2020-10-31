package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.DbUtil;


public class ProdutoDAO {
	
	private static Connection connection = DbUtil.getConnection();
	 
    public static Produto addProduto(String nome, String ingredientes, double preco, String categoria) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO Produtos (nome, ingredientes, preco, categoria) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, nome);
            pStmt.setString(2, ingredientes);
            pStmt.setDouble(3, preco);
            pStmt.setString(4, categoria);
            pStmt.executeUpdate();
            System.out.println("entrouu\n\n\n\n\n\n");
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("ingredientes"), rs.getDouble("preco"), rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static Produto updateProduto(int id, String nome, String ingredientes, double preco, String categoria) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("update Produtos set nome=?, ingredientes=?, preco=?, categoria=? where id=?",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, nome);
            pStmt.setString(2, ingredientes);
            pStmt.setDouble(3, preco);
            pStmt.setString(4, categoria);
            pStmt.setInt(5, id);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("ingredientes"), rs.getDouble("preco"), rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static void deleteProduto(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("delete from Produtos where id=?");
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static List<Produto> getAllProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Produtos order by id");
            while (rs.next()) {
            	Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("ingredientes"), rs.getDouble("preco"), rs.getString("categoria"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return produtos;
    }
 
    public static Produto getProduto(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from Produtos where id=?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("ingredientes"), rs.getDouble("preco"), rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
//    public static User getUserByLogin(String login) {
//        try {
//            PreparedStatement pStmt = connection.prepareStatement("select * from users where login=?");
//            pStmt.setString(1, login);
//            ResultSet rs = pStmt.executeQuery();
//            if (rs.next()) {
//                return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
// 
//        return null;
//    }
	
}
