package TesteLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Login incluir(Login l) throws Exception {
        validaLogin(l, true);
        System.out.println("Tentando inserir: " + l);

        String sqlInsert = "INSERT INTO Login (NOME, EMAIL, ALTURA, PESO, IMC) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, l.getNome());
            ps.setString(2, l.getEmail());
            ps.setFloat(3, l.getAltura());
            ps.setFloat(4, l.getPeso());
            ps.setFloat(5, l.getImc());
            int result = ps.executeUpdate();
            if (result == 1) {
                ResultSet tableKeys = ps.getGeneratedKeys();
                tableKeys.next();
                l.setId(tableKeys.getInt(1));

                System.out.println("Login inserido com sucesso.");
                return l;
            }
            throw new Exception("Erro na inserção.");
        }
    }

    private void validaLogin(Login l, boolean inclusao) throws Exception {
        if (l.getNome() == null || l.getNome().trim().isEmpty()) {
            throw new Exception("Nome é obrigatório.");
        }
        l.setNome(l.getNome().trim());
        if (l.getEmail() == null || l.getEmail().trim().isEmpty()) {
            throw new Exception("Email é obrigatório.");
        }
        l.setEmail(l.getEmail().trim());

        if (inclusao) {
            String query = "select * from Login where email = ?";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, l.getEmail());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Email já cadastrado");
                    }
                }
            }
        }
    }

    public List<Login> listar() throws Exception {
        String sql = "SELECT id, nome, email, altura, peso, imc FROM login";
        List<Login> lista = new ArrayList<>();
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Login l = getLogin(rs);
                lista.add(l);
            }
        }
        return lista;
    }

    public Login obter(int id) throws Exception {
        String sql = "SELECT id, nome, email, altura, peso, imc FROM login WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return getLogin(rs);
                }
            }
        }
        throw new Exception("Não Encontrado.");
    }

    private static Login getLogin(ResultSet rs) throws SQLException {
        Login l = new Login();
        l.setId(rs.getInt("id"));
        l.setNome(rs.getString("nome"));
        l.setEmail(rs.getString("email"));
        l.setAltura(rs.getFloat("altura"));
        l.setPeso(rs.getFloat("peso"));
        l.setImc(rs.getFloat("imc"));
        return l;
    }

    public Login alterar(Login l) throws Exception {
        validaLogin(l, false);

        String sqlUpdate = "UPDATE login SET nome = ?, email = ?, altura = ?, peso = ?, imc = ? WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setString(1, l.getNome());
            ps.setString(2, l.getEmail());
            ps.setFloat(3, l.getAltura());
            ps.setFloat(4, l.getPeso());
            ps.setFloat(5, l.getImc());
            ps.setInt(6, l.getId());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Login atualizado com sucesso");
                return l;
            }
            throw new Exception("Erro na atualização");
        }
    }

    public boolean excluir(int id) throws Exception {
        String sqlUpdate = "DELETE FROM login WHERE id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Login excluído com sucesso.");
                return true;
            }
            throw new Exception("Erro na exclusão.");
        }
    }
}
