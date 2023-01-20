package entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public int compareTo(Funcionario outroFuncionario) {
        return this.getNome().compareTo(outroFuncionario.getNome());
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "["
                + "Nome = " + this.getNome()
                + ", Data de Nascimento = " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ", Salário = " + NumberFormat.getCurrencyInstance().format(salario)
                + ", Função = " + funcao
                + "]";
    }

}
