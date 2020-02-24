package locadora.de.carros;

/**
 *
 * @author Wesley Ribeiro de Souza
 */
public class NorthCar extends DefinindoCarro{
    private double totalFrete;

    public NorthCar(){}
    
    public NorthCar(int tamanhoVetor, boolean cliente){//Contrutor para inicializar o vetor no ojeto
         diasEscolhidos = new String[tamanhoVetor];
         this.cliente = cliente;
    }
   
    @Override
    public double TaxaRegular(){
        this.taxaRegular = 630;
        return taxaRegular;
    }
    
    @Override
    public double TaxaFidelidade(){
         this.taxaFidelidade = 580;
         return taxaFidelidade;
     }
     
    @Override
    public double TaxaRegFds(){
        this.taxaRegFds = 600;
        return taxaRegFds;
    }
    
    @Override
    public double TaxaFidFds(){
        this.taxaFidFds = 590;
        return taxaFidFds;
    }
    
    @Override
    public void setCapacidade(){
        this.capacidade = 7;
    } 
     
    @Override
    public void setNome(){
        this.nome = "Citroën C4 Cactus";
    }
    
    public void setTotalFrete(Double valor, NorthCar objeto){
        this.totalFrete = valor;
        objeto.imprimir(objeto);
    }
    
     public void imprimir( NorthCar objeto){
        NorthCar imprimir = objeto;
        setNome();
        if(cliente == true)
            System.out.print("Premium:");
        else
            System.out.println("Normal:");
         for(int i = 0; i < diasEscolhidos.length; i++ ){
                 System.out.print(diasEscolhidos[i]+", ");
        }
         System.out.println("");
         System.out.println(imprimir.nome + " NorthCar");
    }
}
