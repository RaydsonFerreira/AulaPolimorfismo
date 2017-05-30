/**
 * Classe que representa um Carro.
 * Carro herda da classe Veiculo (e, portanto, tem modelo, marca, placa, imposto e velocidade atual)
 * E acrescenta se o carro é flex ou comum (em relacao ao combustivel).
 * 
 * @author Julio Cesar Alves 
 * @version 2016-09-16
 */
public class Carro extends Veiculo {
    // definimos apenas os atributos que sao especificos do carro
    private boolean ehFlex;

    /**
     * Constroi objeto da classe Carro a partir dos parametros passados
     * Obs: a velocidade inicial do carro eh definida na classe Veiculo
     * 
     * @param modelo Modelo do carro a ser criado.
     * @param marca Marca do carro a ser criado.
     * @param placa Placa do carro a ser criado.
     * @param imposto Valor do imposto anual do veiculo.
     * @param ehFlex Indica se o carro eh flex ou nao. (em relacao ao combustivel)
     */
    public Carro(String modelo, String marca, String placa, double imposto, boolean ehFlex) {
        super(modelo, marca, placa, imposto);
        this.ehFlex = ehFlex;
    }

    /**
     * Retorna se o carro eh flex ou nao (em relacao ao combustivel)
	 *
	 * @return Indicacao se o carro eh flex ou nao
     */
    public boolean getEhFlex() {
        return ehFlex;
    }
    
        /**
     * Retorna a descricao do carro no formato:
     *  Placa   Modelo  Marca  Imposto  Velocidade km/h     Flex (ou Comum)
	 * 
	 * @return A descricao do carro (a descricao do veiculo mais seus campos separados por tabulacoes)
     */
    @Override
    public String getDescricaoVeiculo() {
        String descricao = super.getDescricaoVeiculo();
        if (ehFlex) {
            descricao = descricao + "\t ehFlex";
        }
        else {
            descricao = descricao + "\t Comum";
        }
        return descricao;
    }
}
