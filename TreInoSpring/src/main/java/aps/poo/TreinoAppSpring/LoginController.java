package aps.poo.TreinoAppSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired LoginDao dao;

    @PostMapping("/registro")
    public String login (@RequestBody Login l) {
        return "OK";
    }

    @PostMapping("/login")
    public Retorno incluir(@RequestBody Login l) throws Exception {
        try {
            return new Retorno(dao.incluir(l));
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
    public Login alterar(@PathVariable int id, @RequestBody Login l) throws Exception{
        return dao.alterar(l);
    }

    @DeleteMapping("/login/{id}")
    public boolean excluir(@PathVariable int id) throws Exception {
        return dao.excluir(id);
    }
}
