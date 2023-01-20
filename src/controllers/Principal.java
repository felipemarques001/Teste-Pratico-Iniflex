package controllers;

import entities.Funcionario;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Principal {

    private ArrayList<Funcionario> listaFuncionarios;

    public Principal() {
        listaFuncionarios = new ArrayList<>();
    }

    public void adicionarFuncionarios() {
        Funcionario funcionario1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"), "Operador");
        Funcionario funcionario2 = new Funcionario("João", LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"), "Operador");
        Funcionario funcionario3 = new Funcionario("Caio", LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"), "Coordenador");
        Funcionario funcionario4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"), "Diretor");
        Funcionario funcionario5 = new Funcionario("Alice", LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"), "Recepcionista");
        Funcionario funcionario6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"), "Operador");
        Funcionario funcionario7 = new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"), "Contador");
        Funcionario funcionario8 = new Funcionario("Laura", LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"), "Gerente");
        Funcionario funcionario9 = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"), "Eletricista");
        Funcionario funcionario10 = new Funcionario("Helena", LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"), "Gerente");

        listaFuncionarios.add(funcionario1);
        listaFuncionarios.add(funcionario2);
        listaFuncionarios.add(funcionario3);
        listaFuncionarios.add(funcionario4);
        listaFuncionarios.add(funcionario5);
        listaFuncionarios.add(funcionario6);
        listaFuncionarios.add(funcionario7);
        listaFuncionarios.add(funcionario8);
        listaFuncionarios.add(funcionario9);
        listaFuncionarios.add(funcionario10);
    }

    public void removerFuncionario(String name) {
        listaFuncionarios.removeIf(fun -> fun.getNome().equals(name));
    }

    public void imprimirFuncionarios() {
        listaFuncionarios.forEach(funcionario -> System.out.println(funcionario.toString()));
    }

    public void atualizarSalalarioFuncionarios(String valor) {
        listaFuncionarios.forEach(funcionario ->
                funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal(valor))));
    }

    public Map<String, ArrayList<Funcionario>> agruparFuncionariosPorFuncao() {
        ArrayList<Funcionario> operadores = new ArrayList<>();
        ArrayList<Funcionario> coordenadores = new ArrayList<>();
        ArrayList<Funcionario> diretores = new ArrayList<>();
        ArrayList<Funcionario> recepcionistas = new ArrayList<>();
        ArrayList<Funcionario> contadores = new ArrayList<>();
        ArrayList<Funcionario> eletricistas = new ArrayList<>();
        ArrayList<Funcionario> gerentes = new ArrayList<>();

        for (Funcionario funcionario: listaFuncionarios) {
            if(funcionario.getFuncao().equals("Operador"))
                operadores.add(funcionario);
            if(funcionario.getFuncao().equals("Coordenador"))
                coordenadores.add(funcionario);
            if(funcionario.getFuncao().equals("Diretor"))
                diretores.add(funcionario);
            if(funcionario.getFuncao().equals("Recepcionista"))
                recepcionistas.add(funcionario);
            if(funcionario.getFuncao().equals("Contador"))
                contadores.add(funcionario);
            if(funcionario.getFuncao().equals("Eletricista"))
                eletricistas.add(funcionario);
            if(funcionario.getFuncao().equals("Gerente"))
                gerentes.add(funcionario);
        }

        Map<String, ArrayList<Funcionario>> mapFuncionarios = new HashMap<>();
        mapFuncionarios.put("operadores", operadores);
        mapFuncionarios.put("coordenadores", coordenadores);
        mapFuncionarios.put("diretores", diretores);
        mapFuncionarios.put("recepcionistas", recepcionistas);
        mapFuncionarios.put("contadores", contadores);
        mapFuncionarios.put("eletricistas", eletricistas);
        mapFuncionarios.put("gerentes", gerentes);

        return mapFuncionarios;
    }

    public void imprimirFuncionariosPorFuncao() {
        Map<String, ArrayList<Funcionario>> mapFuncionarios = this.agruparFuncionariosPorFuncao();
        mapFuncionarios.values().forEach(funcionario -> System.out.println(funcionario.toString()));
    }

    public void imprimirFuncionariosPeloMes(int mes1, int mes2) {
        listaFuncionarios.forEach(funcionario -> {
            if(funcionario.getDataNascimento().getMonthValue() == mes1 ||  funcionario.getDataNascimento().getMonthValue() == mes2)
                System.out.println(funcionario);
        });
    }

    public void imprimirFuncionarioMaisVelho() {
        Funcionario funcionarioMaisVelho = listaFuncionarios.get(0);
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento()))
                funcionarioMaisVelho = funcionario;
        }
        LocalDate dataAtual = LocalDate.now();
        int idadeFuncionarioMaisVelho = Period.between(funcionarioMaisVelho.getDataNascimento(), dataAtual).getYears();
        System.out.println("Funcionário mais velho: " + "Nome = " + funcionarioMaisVelho.getNome()
                + ", Idade = " + idadeFuncionarioMaisVelho + " anos");
    }

    public void imprimirFuncionariosPorOrdemAlfabetica() {
        Collections.sort(listaFuncionarios);
        listaFuncionarios.forEach(funcionario -> System.out.println(funcionario.toString()));
    }

    public void imprimirTotalSalario() {
        BigDecimal totalSalario = new BigDecimal("0");
        for (Funcionario funcionario : listaFuncionarios) {
            totalSalario = totalSalario.add(funcionario.getSalario());
        }
        System.out.println(totalSalario);
    }

    public void imprimirQtdSalarioMininoFuncionario(String valorSalarioMinino, int precisao) {
        BigDecimal salarioMinimo = new BigDecimal(valorSalarioMinino);
        for (Funcionario funcionario: listaFuncionarios) {
            BigDecimal qtdSalariosMininos = funcionario.getSalario().divide(salarioMinimo, new MathContext(precisao, RoundingMode.HALF_EVEN));
            System.out.println("O(a) funcionário(a) " + funcionario.getNome() + " recebe aproximadamente " + qtdSalariosMininos + " salários minímos");
        }
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
}
