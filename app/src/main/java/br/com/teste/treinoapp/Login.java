package br.com.teste.treinoapp;
import org.json.JSONObject;

public class Login {
    public String login;
    public String senha;
    public float peso;
    public float altura;
    public float imc;


    public String toJSON() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("login", this.login);
        obj.put("senha", this.senha);
        obj.put("peso", this.peso);
        obj.put("altura", this.altura);
        obj.put("imc", this.imc);
        return obj.toString();
    }
}
