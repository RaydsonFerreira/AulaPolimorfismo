/**
 * Classe que representa um Trator.
 * Trator herda da classe Veiculo (e, portanto, tem modelo, marca, placa, imposto e velocidade atual)
 * 
 * @author Raydson Ferreira Carlota 
 * @version 2016-05-29
 */
public class Trator extends Veiculo {
    /**
     * Constroi objeto da classe Trator a partir dos parametros passados
     * Obs: a velocidade inicial do trator eh definida na classe Veiculo
     * 
     * @param modelo Modelo do Trator a ser criado.
     * @param marca Marca do trator a ser criado.
     * @param placa Placa do trator a ser criado.
     * @param imposto Valor do imposto anual do veiculo.
     */
    public Trator(String modelo, String marca, String placa, double imposto) {
        super(modelo, marca, placa, imposto);
    }
    
    /**
     * Retorna a descricao do trator no formato:
     *  Placa   Modelo  Marca  Imposto Velocidade km/h     
	 * 
	 * @return A descricao do trator (a descricao do veiculo mais seus campos separados por tabulacoes)
     */
    @Override
    public String getDescricaoVeiculo() {
        String descricao = super.getDescricaoVeiculo();
        
        return descricao;
    }
}
