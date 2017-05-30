/**
 * Outra Classe que sera responsavel por fazer testes da classe Simulador.
 * Ela adiciona de maneira automatizada os veiculos a serem criados
 * e os imprime da maneira de frota.
 * 
 * @author raydson
 * @version 2017-05-30
 */
public class TesteSimulador2 {
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
        boolean ehFlex = true;
        addMoto("CG", "Honda", "BOI1234", 155.0, 125, 80);
        addCarro("Corolla", "Toyota", "EVA5463", 95.0, ehFlex, 90);
        addOnibus("Apache", "Caio", "SIM9988", 100.0, 40, 40);
        addMoto("Ninja", "Kawasaki", "BOA5151", 175.0, 300, 110);
                
        System.out.println(simulador.getDescricaoFrota());
    }
    
}