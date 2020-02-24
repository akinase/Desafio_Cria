package locadora.de.carros;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Wesley Ribeiro de Souza
 */
public class SouthCar extends DefinindoCarro{
    private double totalFrete;
    protected String diaescolhidos;
    
    public SouthCar(){}
    
    public SouthCar(int tamanhoVetor, boolean cliente){//Contrutor para inicializar o vetor no ojeto
        diasEscolhidos = new String[tamanhoVetor];
        this.cliente = cliente;
    }

    @Override
    public double TaxaRegular(){
        this.taxaRegular = 210;
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
        this.capacidade = 4;
    } 
     
    @Override
    public void setNome(){
        this.nome = "Fiat Mobi";
    }
    
    public void setTotalFrete(Double valor, SouthCar objeto){
        this.totalFrete = valor;
        objeto.imprimir(objeto);
    }
    
    public void imprimir( SouthCar objeto){
        SouthCar imprimir = objeto;
        setNome();
        if(cliente == true)
            System.out.print("Premium:");
        else
            System.out.println("Normal:");
         for(int i = 0; i < diasEscolhidos.length; i++ ){
                 System.out.print(diasEscolhidos[i]+", ");
        }
         System.out.println("");
         System.out.println(imprimir.nome + " SouthCar");
    }
}
