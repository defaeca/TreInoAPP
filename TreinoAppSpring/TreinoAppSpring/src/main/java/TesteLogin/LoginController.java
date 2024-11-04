package TesteLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    LoginDao dao;

    @PostMapping("/registro")
    public String registro(@RequestBody Login l) {
        l.calcularImc();
        return "Registro realizado com sucesso!";
    }

    @PostMapping("/login")
    public Retorno incluir(@RequestBody Login l) throws Exception {
        try {
            l.calcularImc();
            Login login = dao.incluir(l); // Persiste no banco de dados
            return new Retorno(login); // Retorna o objeto persistido
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }


    @GetMapping("/login")
    public List<Login> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/login/{id}")
    public Login obter(@PathVariable int id) throws Exception {
        return dao.obter(id);
    }

    @PutMapping("/login/{id}")
    public Login alterar(@PathVariable int id, @RequestBody Login l) throws Exception {
        l.calcularImc();
        return dao.alterar(l);
    }

    @DeleteMapping("/login/{id}")
    public boolean excluir(@PathVariable int id) throws Exception {
        return dao.excluir(id);
    }
}
