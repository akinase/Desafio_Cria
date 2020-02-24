package locadora.de.carros;

/**
 *
 * @author Wesley Ribeiro de Souza
 */
public class WestCar extends DefinindoCarro{    
    private double totalFrete;
   
    public WestCar(){}
    
    public WestCar(int tamanhoVetor, boolean cliente){//Contrutor para inicializar o vetor no ojeto
        diasEscolhidos = new String[tamanhoVetor];
        this.cliente = cliente;
    }
    
    @Override
    public double TaxaRegular(){
        this.taxaRegular = 530;
        return taxaRegular;
    }
    
    @Override
    public double TaxaFidelidade(){
         this.taxaFidelidade = 150;
          return taxaFidelidade;
     }
     
    @Override
    public double TaxaRegFds(){
        this.taxaRegFds = 200;
        return taxaRegFds;
    }
    
    @Override
    public double TaxaFidFds(){
        this.taxaFidFds = 90;
        return taxaFidFds;
    }
    
    @Override
    public void setCapacidade(){
        this.capacidade = 2;
    } 
     
    @Override
    public void setNome(){
        this.nome = "Audi A1";
    }
    
    public void setTotalFrete(Double valor, WestCar objeto){
        this.totalFrete = valor;
        objeto.imprimir(objeto);
    }
    
    public void imprimir(WestCar objeto){
        WestCar imprimir = objeto;
        setNome();
        if(cliente == true)
            System.out.print("Premium:");
        else
            System.out.println("Normal:");
         for(int i = 0; i < diasEscolhidos.length; i++ ){
                 System.out.print(diasEscolhidos[i]+", ");
        }
         System.out.println("");
         System.out.println(imprimir.nome + " WestCar");
    }
}
