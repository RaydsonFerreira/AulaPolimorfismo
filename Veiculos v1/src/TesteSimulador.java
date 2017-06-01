/**
 * Classe que sera responsavel por fazer testes da classe Simulador.
 * Ela adiciona de maneira automatizada os veiculos a serem criados
 * e os imprime da maneira de frota.
 * 
 * @author raydson
 * @version 2017-05-30
 */
public class TesteSimulador {
    private static Simulador simulador;
    
    public static void addCarro(String modelo, String marca, String placa, double imposto, boolean ehFlex, int velocidade){
        simulador.adicionarCarro(modelo, marca, placa, imposto, ehFlex);
        simulador.alterarVelocidade(modelo, velocidade);
    }
    
    public static void addCaminhao(String modelo, String marca, String placa, double imposto, int capacidadeCarga, int velocidade){
        simulador.adicionarCaminhao(modelo, marca, placa, imposto, capacidadeCarga);
        simulador.alterarVelocidade(modelo, velocidade);
    }
    
    public static void addOnibus(String modelo, String marca, String placa, double imposto, int qntPassageiros, int velocidade){
        simulador.adicionarOnibus(modelo, marca, placa, imposto, qntPassageiros);
        simulador.alterarVelocidade(modelo, velocidade);
    }
    
    public static void addTrator(String modelo, String marca, String placa, double imposto, int velocidade){
        simulador.adicionarTrator(modelo, marca, placa, imposto);
        simulador.alterarVelocidade(modelo, velocidade);
    }
    
    public static void addMoto(String modelo, String marca, String placa, double imposto, int cilindradas, int velocidade){
        simulador.adicionarMoto(modelo, marca, placa, imposto, cilindradas);
        simulador.alterarVelocidade(modelo, velocidade);
    }
    
    public static void main(String[] args){
        simulador = new Simulador();
        addCarro("F50", "Ferrari", "GZA1234", 90.0, true, 240);
        addCarro("Fusca", "VW", "GZA1234", 105.0, false, 50);        
        addCaminhao("Atego", "Mercedes", "GZB1111", 100.0, 10, 60);
        addCaminhao("Brutus", "Sacania", "GZB2222", 300.0, 35, 60);
        addOnibus("Apache", "Caio", "SIM9988", 0.0, 25, 40);
        addTrator("4230", "Agrale", "GZA9999", 0.0, 10);
        
        System.out.println(simulador.getDescricaoFrota());
    }
}
