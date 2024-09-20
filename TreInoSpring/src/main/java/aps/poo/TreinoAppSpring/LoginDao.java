package aps.poo.TreinoAppSpring;

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

        String sqlInsert = "INSERT INTO Login (LOGIN, SENHA, PESO, ALTURA, IMC)"
                + " VALUES (?, ?, ?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, l.getLogin());
            ps.setString(2, l.getSenha());
            ps.setFloat(3, l.getPeso());
            ps.setFloat(4, l.getAltura());
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
        if (l.getLogin() == null || l.getLogin().trim().isEmpty()) {
            throw new Exception("Login é obrigátorio.");
        }
        l.setLogin(l.getLogin().trim());
        if (l.getSenha() == null || l.getSenha().trim().isEmpty()) {
            throw new Exception("Senha é obrigátoria.");
        }
        l.setSenha(l.getSenha().trim());

        if (inclusao) {
            String query = "select * from Login where login = ? ";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, l.getLogin());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Login já cadastrado");
                    }
                }
            }
        } else {
            String query = "select * from Login where login = ?"
                    + "and id <> ?";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query);) {
                ps.setString(1, l.getLogin());
                ps.setInt(2, l.getId());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Login já cadastrado");
                    }
                }
            }
        }
    }

    public List<Login> listar() throws Exception {
        String sql = "select id, login, senha, peso, altura, imc from login";
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
        String sql = "SELECT id, login, senha, peso, altura, imc from login "
                + "where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Login l = getLogin(rs);
                    return l;
                }
            }
        }
        throw new Exception("Não Encontrado.");
    }

    private static Login getLogin(ResultSet rs) throws SQLException {
        Login l = new Login();
        l.setId(rs.getInt("id"));
        l.setLogin(rs.getString("login"));
        l.setSenha(rs.getString("senha"));
        l.setPeso(rs.getFloat("peso"));
        l.setAltura(rs.getFloat("altura"));
        l.setImc(rs.getFloat("imc"));
        return l;
    }

    public Login alterar(Login l) throws Exception {
        validaLogin(l, false);

        String sqlUpdate = "update login set login = ?, senha = ?, peso = ?, altura = ?, imc = ?"
                + "where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate);) {
            ps.setString(1, l.getLogin());
            ps.setString(2, l.getSenha());
            ps.setFloat(3, l.getPeso());
            ps.setFloat(4, l.getAltura());
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
        String sqlUpdate = "delete from login where ID = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate);) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Login Excluido com sucesso. ");
                return true;
            }
            throw new Exception("Erro na exclusão");
        }
    }
}
