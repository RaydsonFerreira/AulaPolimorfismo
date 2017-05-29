import java.util.ArrayList;

/**
 * Classe que sera responsavel pela Simulacao do Transito.
 * Por enquanto, ela apenas trata as colecoes de veiculos (carros, caminhoes e onibus).
 * 
 * @author Julio Cesar Alves
 * @version 2016-06-19
 */
public class Simulador
{
    private ArrayList<Veiculo> veiculos;

    
    /**
     * Constroi um simulador e apenas inicializa as colecoes vazias de veiculos.
     */
    public Simulador() {
        veiculos = new ArrayList<>();        
    }
    
    /**
     * Adiciona um carro ao simulador
     * 
     * @param modelo Modelo do carro a ser criado.
     * @param marca Marca do carro a ser criado.
     * @param placa Placa do carro a ser criado.
     * @param imposto Imposto do carro a ser pago.
     * @param ehFlex Indica se o carro eh flex ou nao (em relacao ao combustivel)
     */
    public void adicionarCarro(String modelo, String marca, String placa, double imposto, boolean ehFlex) {
        Carro carro = new Carro(modelo, marca, placa, imposto, ehFlex);
        
        veiculos.add(carro);
    }
    
    /**
     * Adiciona um caminhao ao simulador
     * 
     * @param modelo Modelo do caminhao a ser criado.
     * @param marca Marca do caminhao a ser criado.
     * @param placa Placa do caminhao a ser criado.
     * @param imposto Imposto do caminhão a ser pago.
     * @param capacidadeCarga Capacidade de carga do caminhao (em toneladas).
     */
    public void adicionarCaminhao(String modelo, String marca, String placa, double imposto, double capacidadeCarga) {
        Caminhao caminhao = new Caminhao(modelo, marca, placa, imposto, capacidadeCarga);
        
        veiculos.add(caminhao);
    }
    
    /**
     * Adiciona um onibus ao simulador
     * 
     * @param modelo Modelo do onibus a ser criado.
     * @param marca Marca do onibus a ser criado.
     * @param placa Placa do onibus a ser criado.
     * @param imposto Imposto do onibus a ser pago.
     * @param capacidadePassageiros Quantidade de passageiros que o onibus pode carregar.
     */
    public void adicionarOnibus(String modelo, String marca, String placa, double imposto, int capacidadePassageiros) {
        Onibus onibus = new Onibus(modelo, marca, placa, imposto, capacidadePassageiros);
        
        veiculos.add(onibus);
    }
    
    /**
     * Retorna uma String com a descricao de toda a frota do simulador.
     * Cada veiculo aparece em uma linha.
     * Cada veiculo eh represetado como definido pela sua classe.
	 *
	 * @return Descricao completa da frota com um veiculo por linha
     */
    public String getDescricaoFrota() {
        String descricao = "FROTA DO SIMULADOR";
        
        for(Veiculo v: veiculos) {
            descricao += "\n" + v.getDescricaoVeiculo();
        }
        
        return descricao;
    }
    
    /**
     * Altera a velocidade atual do veiculo cujo modelo foi passado.
     * Se houver dois veiculos com o mesmo modelo, altera apenas o primeiro encontrado.
     * A velocidade eh alterada se o veiculo for encontrado e a velocidade for valida
     * 
     * @param modelo Modelo do veiculo que tera sua velocidade alterada
     * @param velocidade Velocidade que o veiculo passara a ter
     * @return Retorna se a velocidade foi realmente alterada
     */
    public boolean alterarVelocidade(String modelo, int velocidade) {
        Veiculo veiculo = buscarVeiculo(modelo);
        
        if (veiculo != null) {
            return veiculo.setVelocidadeAtual(velocidade);
        }
        else {
            return false;
        }
    }
    
    /**
     * Retorna um veiculo a partir do modelo passado.
     * Se houver dois veiculos com o mesmo modelo retorna o primeiro encontrado.
     * 
     * @param modelo Modelo do veiculo a ser buscado
     * @return Retorna o veiculo encontrado ou null se ele nao existir.
     */
    private Veiculo buscarVeiculo(String modelo) {
        for (Veiculo v: veiculos) {
            if (v.getModelo().equals(modelo)) {
                return v;
            }
        }
        return null;
    }    
}

