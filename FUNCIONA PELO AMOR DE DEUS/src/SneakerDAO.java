import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SneakerDAO {

    ConnectionFactory connect = new ConnectionFactory();
    Connection connection = connect.conectar();

    public void adicionar_sneaker(Sneaker sneaker) {
        String sql = "INSERT INTO sneaker(nome_sneaker, descricao, preco, criador) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement pstm = connection.prepareStatement(sql);
            // Adiciona valores
            pstm.setString(1, sneaker.getName_sneaker());
            pstm.setString(2, sneaker.getDescription());
            pstm.setDouble(3, sneaker.getPrice());
            pstm.setString(4, sneaker.getCreator());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Sneaker> getSneakers() {
        String sql = "SELECT * FROM sneaker";

        List<Sneaker> sneakers = new ArrayList<Sneaker>();

        try {
            Statement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Sneaker sneaker = new Sneaker(sql, sql, 0, sql);
                sneaker.setId(rs.getInt("id_sneaker"));
                sneaker.setName_sneaker(rs.getString("nome_sneaker"));
                sneaker.setDescription(rs.getString("descricao"));
                sneaker.setPrice(rs.getDouble("preco"));
                sneaker.setCreator(rs.getString("criador"));

                sneakers.add(sneaker);
            }
            rs.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sneakers;
    }

    public void editar_sneaker(Sneaker sneaker) {
        String sql = "UPDATE sneaker SET nome_sneaker = ?, descricao = ?, preco = ?, criador = ? WHERE id_sneaker = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, sneaker.getName_sneaker());
            pstm.setString(2, sneaker.getDescription());
            pstm.setDouble(3, sneaker.getPrice());
            pstm.setString(4, sneaker.getCreator());
            pstm.setInt(5, sneaker.getId());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Sneaker getSneakerById(int id) {
        String sql = "SELECT * FROM sneaker WHERE id_sneaker = ?";
        Sneaker sneaker = null;

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                sneaker = new Sneaker(rs.getString("nome_sneaker"), rs.getString("descricao"), rs.getDouble("preco"),
                        rs.getString("criador"));
                sneaker.setId((rs.getInt("id_sneaker")));
            }

            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sneaker;
    }

    public void excluir_sneaker(Sneaker sneaker) {
        String sql = "DELETE FROM sneaker WHERE id_sneaker = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, sneaker.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException var4) {
        }

    }
}
