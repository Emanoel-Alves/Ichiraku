package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
import model.Pedido;
import util.DbUtil;

public class PedidoDAO {

	private static Connection connection = DbUtil.getConnection();
	 
    public static Pedido addPedido(int idUser, String nome, double preco) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO Pedidos (idUser, nome ,preco) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, idUser);
            pStmt.setString(2, nome);
            pStmt.setDouble(3, preco);
            pStmt.executeUpdate();
            System.out.println("entrouu\n\n\n\n\n\n");
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Pedido(rs.getInt("id"), rs.getInt("idUser"), rs.getString("nome"), rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static Pedido updatePedido(int id, int idUser, String nome, double preco) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("update Pedidos set  nome=?,  preco=? where id=?",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, nome);
            pStmt.setDouble(3, preco);
            pStmt.setInt(5, id);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Pedido(rs.getInt("id"), rs.getInt("idUser"), rs.getString("nome"), rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static void deletePedido(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("delete from Pedidos where id=?");
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static List<Pedido> getAllPedidos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Pedidos order by id");
            while (rs.next()) {
            	Pedido pedido = new Pedido(rs.getInt("id"), rs.getInt("idUser"), rs.getString("nome"), rs.getDouble("preco"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return pedidos;
    }
    
    public static Pedido getPedido(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from Pedidos where id=?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new Pedido(rs.getInt("id"), rs.getInt("idUser"), rs.getString("nome"), rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
    
}

