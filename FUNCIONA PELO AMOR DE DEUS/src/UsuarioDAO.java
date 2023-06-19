
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    ConnectionFactory connect = new ConnectionFactory();
    Connection connection = connect.conectar();

    // ADICIONA USUARIO
    public void adicionar_user(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, idade, funcao, senha) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement pstm = connection.prepareStatement(sql);
            // Adiciona valores
            pstm.setString(1, usuario.getName());
            pstm.setInt(2, usuario.getAge());
            pstm.setString(3, usuario.getFunction());
            pstm.setString(4, usuario.getPassword());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getUsuarios() {
        String sql = "SELECT * FROM usuario";

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            Statement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(sql, 0, sql, sql);
                usuario.setId_User(rs.getInt("id"));
                usuario.setName(rs.getString("nome"));
                usuario.setAge(rs.getInt("idade"));
                usuario.setFunction(rs.getString("funcao"));
                usuarios.add(usuario);
            }
            rs.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void editar_usuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, idade = ?, funcao = ?, senha = ? WHERE id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, usuario.getName());
            pstm.setInt(2, usuario.getAge());
            pstm.setString(3, usuario.getFunction());
            pstm.setString(4, usuario.getPassword());
            pstm.setInt(5, usuario.getId_User());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Usuario getUsuarioById(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getString("nome"), rs.getInt("idade"), rs.getString("funcao"),
                        rs.getString("senha"));
                usuario.setId_User(rs.getInt("id"));
            }

            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public void excluir_usuario(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, usuario.getId_User());
            pstm.execute();
            pstm.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

}
