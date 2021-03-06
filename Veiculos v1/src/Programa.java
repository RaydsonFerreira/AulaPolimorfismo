import java.util.Scanner;

/**
 * Classe principal que faz a interface com usuario do simulador.
 * Permite cadastrar carros, caminhoes e onibus e lista-los.
 * 
 * @author Julio Cesar Alves
 * @version 2016-09-16
 */
public class Programa {
    private static Simulador simulador;
    
    /**
     * Metodo principal que inicial a execucao do programa
	 *
	 * @param args Parametros do programa (o programa nao espera nenhum)
     */
    public static void main(String[] args) {
        simulador = new Simulador();
        
        System.out.println("Simulador de Veiculos");
        
        int opcaoMenu;
        do {
            opcaoMenu = exibirMenu();
            
            switch (opcaoMenu) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    alterarVelocidadeVeiculo();
                    break;
                case 3:
                    exibirVeiculos();
                    break;
                case 4: // nao faz nada, apenas vai sair do programa
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcaoMenu != 4);
    }
    
    /**
     * Exibe o menu para o usuario e retorna a opcao escolhida por ele
     * 
     * @return Opcao de menu escolhida pelo usuario
     */
    private static int exibirMenu() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\n\n1) Adicionar Veiculo");
        System.out.println("2) Alterar velocidade");
        System.out.println("3) Listar Veiculos");
        System.out.println("4) Sair");
        System.out.print("\tDigite sua opcao: ");
        
        return entrada.nextInt();
    }
    
    /**
     * Permite ao usuario adicionar um veiculo ao simulador.
     * O usuario passa os dados de acordo com o tipo de veiculo.
     */
    private static void adicionarVeiculo() {        
        String modelo, marca, placa;
        double imposto = 100.0;
        int tipo;
        boolean adicionado = false;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o modelo: ");
        modelo = entrada.next();
        System.out.print("Digite a marca: ");
        marca = entrada.next();
        System.out.print("Digite a placa: ");
        placa = entrada.next();
        
        System.out.print("Qual o tipo de veiculo (1-carro, 2-caminhao, 3-onibus, 4-trator, 5-moto)? ");
        tipo = entrada.nextInt();
        
        switch(tipo) {
            case 1: // carro
                System.out.print("Digite se eh flex (1-sim, 2-nao): ");
                int flex = entrada.nextInt();
                boolean ehFlex = (flex == 1);
                if(ehFlex) imposto -= imposto * 0.1;
                else imposto += imposto * 0.05;
                simulador.adicionarCarro(modelo, marca, placa, imposto, ehFlex);
                adicionado = true;
                break;
            case 2: // caminhao
                System.out.print("Digite a capacidade de carga (ton): ");
                double capacidadeCarga = entrada.nextDouble();
                if(capacidadeCarga <= 10) imposto -= imposto * 0.1;
                else if(capacidadeCarga >= 30) imposto += imposto + 2.0;
                simulador.adicionarCaminhao(modelo, marca, placa, imposto, capacidadeCarga);
                adicionado = true;
                break;
            case 3: // onibus
                System.out.print("Digite a capacidade de passageiros: ");
                int capacidadePas = entrada.nextInt();
                if(capacidadePas <= 30) imposto = 0.0;
                simulador.adicionarOnibus(modelo, marca, placa, imposto, capacidadePas);
                adicionado = true;
                break;
            case 4: // trator
                imposto = 0.0;
                simulador.adicionarTrator(modelo, marca, placa, imposto);
                adicionado = true;
                break;
            case 5:
                System.out.print("Digite a quantidade de cilindradas: ");
                int cilindradas = entrada.nextInt();
                if(cilindradas == 125) imposto += (imposto * 0.05) + 50;
                else if(cilindradas == 250) imposto += (imposto * 0.15) + 50;
                else imposto += (imposto * 0.25) + 50;
                simulador.adicionarMoto(modelo, marca, placa, imposto, cilindradas);
                adicionado = true;
                break;
            default:
                System.out.println("Tipo de veiculo invalido!");
        }
        
        if (adicionado) {
            System.out.print("Veiculo adicionado!");
        }
		// espera usuario digitar uma tecla qualquer
        esperarTecla();
    }
    
    /**
     * Permite ao usuario alterar a velocidade de um veiculo do simulador.
     * O usuario informa o tipo de veiculo e o modelo.
     */
    private static void alterarVelocidadeVeiculo() {
        int tipo, velocidade;
        String modelo;
        boolean alterou = false;
        Scanner entrada = new Scanner(System.in);
       
        System.out.print("Digite o modelo: ");
        modelo = entrada.next();
        System.out.print("Digite a velocidade: ");
        velocidade = entrada.nextInt();
        alterou = simulador.alterarVelocidade(modelo, velocidade);
        
        if (alterou) {
            System.out.println("Velocidade alterada!");
        }
        else {
            System.out.println("Veiculo nao encontrado ou velocidade invalida!");
        }
		// espera usuario digitar uma tecla qualquer
        esperarTecla();
    }
    
    /**
     * Exibe na tela os veiculos retornados pelo simulador
     */
    private static void exibirVeiculos() {
        System.out.println(simulador.getDescricaoFrota());
        
		// espera usuario digitar uma tecla qualquer
        esperarTecla();
    }
	
	/**
	 * Exibe na tela o texto "ENTER para continuar" e aguarda um ENTER
	 */
	private static void esperarTecla() {
		try {
			System.out.print("\n\nENTER para continuar...");
			Scanner entrada = new Scanner(System.in);
			entrada.nextLine();
		} catch(Exception e) {}
	}
}
