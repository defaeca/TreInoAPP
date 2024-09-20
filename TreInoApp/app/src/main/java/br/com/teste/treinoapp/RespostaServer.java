package br.com.teste.treinoapp;

import org.json.JSONObject;
import org.json.JSONTokener;

public class RespostaServer {
    public String validacao;
    public Long chave;
    public String erro;

    public void fromJson(String json) {
        if (json == null || json.trim().isEmpty()) {
            this.validacao = "NOK";
            this.erro = "Mensagem vazia";
        }
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            this.validacao = object.getString("validacao");
            if (validacao.equals("OK")) {
                this.chave = object.getLong("chave");
            }
            this.erro = object.getString("erro");
        } catch (Exception ex) {
            ex.printStackTrace();
            this.validacao = "NOK";
            this.erro = ex.getMessage();
        }
    }

}

