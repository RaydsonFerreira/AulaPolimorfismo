/**
 * Classe que representa uma Moto.
 * Moto herda da classe Veiculo (e, portanto, tem modelo, marca, placa, imposto e velocidade atual)
 * E acrescenta as cilindradas de cada moto.
 * 
 * @author Raydson Ferreira Carlota 
 * @version 2016-05-29
 */
public class Moto extends Veiculo {
    // quantidade de passageiros que o onibus pode levar
    private int cilindradas;

    /**
     * Controi objeto da classe Moto a partir dos parametros passados
     * Obs: a velocidade inicial da moto eh definida na classe Veiculo
     * 
     * @param modelo Modelo da moto a ser criado.
     * @param marca Marca do moto a ser criado.
     * @param placa Placa do moto a ser criado.
     * @param imposto Imposto do moto a ser criado
     * @param cilindradas Quantidade de cilindradas a ser criada.
     */
    public Moto (String modelo, String marca, String placa, double imposto, int cilindradas) {
        super(modelo, marca, placa, imposto);
        this.cilindradas = cilindradas;
    }
    
    /**
     * Retorna a quantidade de cilindradas que moto tem
	 *
	 * @return A quantidade de cilindradas que a moto tem
     */
    public int getCilindradas() {
        return cilindradas;
    }
    
    /**
     * Retorna a descricao da moto no formato:
     *  Placa   Modelo  Marca  Imposto  Velocidade km/h    Cilindradas
	 * 
	 * @return A descricao da moto (a descricao do veiculo mais seus campos separados por tabulacoes)
     */
    
    @Override
    public String getDescricaoVeiculo() {
        return super.getDescricaoVeiculo() + "\t" + cilindradas;
    }
}
