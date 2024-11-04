package TesteLogin;

import lombok.Data;

@Data
public class Login {
    public int id;
    public String nome;
    public String email;
    public float altura;
    public float peso;
    public float imc;

    public void calcularImc() {
        this.imc = peso / (altura * altura);
    }
}
