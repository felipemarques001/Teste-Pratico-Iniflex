import controllers.Principal;

public class Main {

    public static void main(String[] args) {

        // Desafio 3.1
        Principal principal = new Principal();
        principal.adicionarFuncionarios();

        // Desafio 3.2
        principal.removerFuncionario("João");


       // Desafio 3.3
        System.out.println("\n----DESAFIO 3.3-----");
        principal.imprimirFuncionarios();

        // Desafio 3.4
        principal.atualizarSalalarioFuncionarios("1.1");

        // Desafio 3.5
        principal.agruparFuncionariosPorFuncao();

        // Desafio 3.6
        System.out.println("\n----DESAFIO 3.6-----");
        principal.imprimirFuncionariosPorFuncao();

        // Desafio 3.8
        System.out.println("\n----DESAFIO 3.8-----");
        principal.imprimirFuncionariosPeloMes(10, 12);

        // Desafio 3.9
       System.out.println("\n----DESAFIO 3.9-----");
        principal.imprimirFuncionarioMaisVelho();

        // Desafio 3.10
        System.out.println("\n----DESAFIO 3.10-----");
        principal.imprimirFuncionariosPorOrdemAlfabetica();

        // Desafio 3.11
        System.out.println("\n----DESAFIO 3.11-----");
        principal.imprimirTotalSalario();

        // Desafio 3.12
        System.out.println("\n----DESAFIO 3.12-----");
        principal.imprimirQtdSalarioMininoFuncionario("1212.00", 4);
    }

}