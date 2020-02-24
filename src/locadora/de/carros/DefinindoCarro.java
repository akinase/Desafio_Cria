package locadora.de.carros;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Wesley Ribeiro de Souza
 */
public abstract class DefinindoCarro{
    protected ArrayList<String> data;
    protected String diaDaSemana;
    protected String[] diasEscolhidos;
    protected  double taxaRegular;
    protected  double taxaFidelidade;
    protected  double taxaRegFds;
    protected  double taxaFidFds;
    protected  double capacidade;
    protected  String nome;
    protected int pessoas;
    protected boolean cliente;// true -> premium / false -> normal
    protected double[] somaTarifas;
    protected int opcao;
    
    DefinindoCarro(){
        data = new ArrayList<>();       
    }
       
    public int verificarPremium( int numPessoas){ 
        this.pessoas = numPessoas;
        if(pessoas <= 2){
           return this.opcao = 2;
        } else if (pessoas <= 4){
            return this.opcao = 1;
        } else if (pessoas <= 7){
            return this.opcao = 3;
        }
         return 0;     
    }
    
    public int verificarNormal( int numPessoas){//Carro esportivo nunca sera a melhor opção para clientes sem fidelidade
        this.pessoas = numPessoas;
        if (pessoas <= 4){
            return this.opcao = 1;
        } else if (pessoas <= 7){
            return this.opcao = 3;
        }
         return 0; 
    }
    
    public void tabela(boolean cliente){
        somaTarifas = new double[data.size()];//alocado com base em todas as datas
        diasEscolhidos = new String[data.size()];//Vetor para deixar no parametro string as datas, prontas para impressão
        int cont = -1;
        double aux = 0;
        int tamanhoVetor = data.size();
        SouthCar carro1 = new SouthCar(tamanhoVetor,cliente);
        WestCar carro2 = new WestCar(tamanhoVetor,cliente);
        NorthCar carro3 = new NorthCar(tamanhoVetor,cliente);
        
        if((cliente == true) && (opcao == 1)){//se for cliente Premium, entrará. Opção 1 é compacto          
            for(int i = 0; i < data.size(); i++ ){
                cont++;
                int d = Integer.parseInt(data.get(i));
                Date date; 
                date = new java.util.Date(d*1000L);

                SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy"); 
                SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana

                dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 

                String formattedDate = dEscolhidos.format(date);
                String formatarData = dSemana.format(date);

                carro1.diasEscolhidos[cont] = formattedDate;
                diaDaSemana = formatarData;
                 
                aux = taxaDoCarroOp1Premium(diaDaSemana);
                
                if (cont != 0){
                somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                } else  somaTarifas[cont] = aux;                                   
            } 
            carro1.setTotalFrete(somaTarifas[cont], carro1);
        }else        
            if((cliente == false) && (opcao == 1)){//se for cliente Normal, entrará. Opção 1 é compacto
                for(int i = 0; i < data.size(); i++ ){
                    cont++;
                    int d = Integer.parseInt(data.get(i));
                    Date date; 
                    date = new java.util.Date(d*1000L);
                    
                    SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy"); 
                    SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana
                    
                    dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                    dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 
                    
                    String formattedDate = dEscolhidos.format(date);
                    String formatarData = dSemana.format(date);
                                        
                    carro1.diasEscolhidos[cont] = formattedDate;
                    diaDaSemana = formatarData;
                    
                    aux = taxaDoCarroOp1Premium(diaDaSemana);
                    
                    if (cont != 0){
                    somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                    } else  somaTarifas[cont] = aux;                                   
            }
                carro1.setTotalFrete(somaTarifas[cont], carro1);
        }else
            if((cliente == true) && (opcao == 2)){//se for cliente Premium, entrará. Opção 2 é esportivo
                for(int i = 0; i < data.size(); i++ ){
                    cont++;
                    int d = Integer.parseInt(data.get(i));
                    Date date; 
                    date = new java.util.Date(d*1000L);
                    
                    SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy"); 
                    SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana
                    
                    dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                    dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 
                    
                    String formattedDate = dEscolhidos.format(date);
                    String formatarData = dSemana.format(date);
                                        
                    carro2.diasEscolhidos[cont] = formattedDate;
                    diaDaSemana = formatarData;
                    
                    aux = taxaDoCarroOp1Premium(diaDaSemana);
                    
                    if (cont != 0){
                    somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                    } else  somaTarifas[cont] = aux;                                   
            } 
            carro2.setTotalFrete(somaTarifas[cont], carro2);
        }else
            if((cliente == false) && (opcao == 2)){//se for cliente Normal, entrará. Opção 1 é compacto
                for(int i = 0; i < data.size(); i++ ){
                    cont++;
                    int d = Integer.parseInt(data.get(i));
                    Date date; 
                    date = new java.util.Date(d*1000L);
                    
                    SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy"); 
                    SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana
                    
                    dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                    dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 
                    
                    String formattedDate = dEscolhidos.format(date);
                    String formatarData = dSemana.format(date);
                                        
                    carro2.diasEscolhidos[cont] = formattedDate;
                    diaDaSemana = formatarData;
                    
                    aux = taxaDoCarroOp1Premium(diaDaSemana);
                    
                    if (cont != 0){
                    somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                    } else  somaTarifas[cont] = aux;                                   
            } 
            carro2.setTotalFrete(somaTarifas[cont], carro2);
        }else
            if((cliente == true) && (opcao == 3)){//se for cliente Premium, entrará. Opção 3 é SUV
                for(int i = 0; i < data.size(); i++ ){
                    cont++;
                    int d = Integer.parseInt(data.get(i));
                    Date date; 
                    date = new java.util.Date(d*1000L);
                    
                    SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE,dd-MM-yyyy"); 
                    SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana
                    
                    dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                    dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 
                    
                    String formattedDate = dEscolhidos.format(date);
                    String formatarData = dSemana.format(date);
                                        
                    carro3.diasEscolhidos[cont] = formattedDate;
                    diaDaSemana = formatarData;
                    
                    aux = taxaDoCarroOp1Premium(diaDaSemana);
                    
                    if (cont != 0){
                    somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                    } else  somaTarifas[cont] = aux;                                
            } 
            carro3.setTotalFrete(somaTarifas[cont], carro3);
        }else
            if((cliente == false) && (opcao == 3)){//se for cliente Normal, entrará. Opção 1 é compacto
                for(int i = 0; i < data.size(); i++ ){
                   cont++;
                    int d = Integer.parseInt(data.get(i));
                    Date date; 
                    date = new java.util.Date(d*1000L);
                    
                    SimpleDateFormat dEscolhidos = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy"); 
                    SimpleDateFormat dSemana = new java.text.SimpleDateFormat("EEEE");//dia da semana
                    
                    dEscolhidos.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4"));
                    dSemana.setTimeZone(java.util.TimeZone.getTimeZone("BRT-4")); 
                    
                    String formattedDate = dEscolhidos.format(date);
                    String formatarData = dSemana.format(date);
                                        
                    carro3.diasEscolhidos[cont] = formattedDate;
                    diaDaSemana = formatarData;
                    
                    aux = taxaDoCarroOp1Premium(diaDaSemana);
                    if (cont != 0){
                    somaTarifas[cont] = somaTarifas[cont - 1] + aux;
                    } else  somaTarifas[cont] = aux;                                   
            } 
            carro3.setTotalFrete(somaTarifas[cont], carro3);
        }        
     }
             
    public double taxaDoCarroOp1Premium(String diaDaSemana){//Taxa de aluguel de carro opcao 1, cliente Premium        
     SouthCar exemplo = new SouthCar();
     if("Segunda-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Terça-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade();
    } else if("Quarta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Quinta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Sexta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade();
    } else if("Sábado".equals(diaDaSemana)){
        return exemplo.TaxaFidFds();
    } else if("Domingo".equals(diaDaSemana)){
        return exemplo.TaxaFidFds();
    }
    return 0;
 }

    public double taxaDoCarroOp1Regular(String diaDaSemana){//Taxa de aluguel de carro opcao 1, cliente Regular     
     SouthCar exemplo = new SouthCar();
     if("Segunda-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Terça-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular();
    } else if("Quarta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Quinta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Sexta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular();
    } else if("Sábado".equals(diaDaSemana)){
        return exemplo.TaxaRegFds();
    } else if("Domingo".equals(diaDaSemana)){
        return exemplo.TaxaRegFds();
    }
    return 0;
 }

    public double taxaDoCarroOp2Premium(String diaDaSemana){//Taxa de aluguel de carro opcao 1, cliente Premium        
     WestCar exemplo = new WestCar();
     if("Segunda-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Terça-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade();
    } else if("Quarta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Quinta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade(); 
    } else if("Sexta-feira".equals(diaDaSemana)){
        return exemplo.TaxaFidelidade();
    } else if("Sábado".equals(diaDaSemana)){
        return exemplo.TaxaFidFds();
    } else if("Domingo".equals(diaDaSemana)){
        return exemplo.TaxaFidFds();
    }
    return 0;
 }

    public double taxaDocarroOp2Regular(String diaDaSemana){//Taxa de aluguel de carro opcao 2, cliente Regular        
     WestCar exemplo = new WestCar();
     if("Segunda-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Terça-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular();
    } else if("Quarta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Quinta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular(); 
    } else if("Sexta-feira".equals(diaDaSemana)){
        return exemplo.TaxaRegular();
    } else if("Sábado".equals(diaDaSemana)){
        return exemplo.TaxaRegFds();
    } else if("Domingo".equals(diaDaSemana)){
        return exemplo.TaxaRegFds();
    }
    return 0;
 }

    public double taxaDoCarroOp3Premium(String diaDaSemana){//Taxa de aluguel de carro opcao 1, cliente Premium        
          NorthCar exemplo = new NorthCar();
         if("Segunda-feira".equals(diaDaSemana)){
            return exemplo.TaxaFidelidade(); 
        } else if("Terça-feira".equals(diaDaSemana)){
            return exemplo.TaxaFidelidade();
        } else if("Quarta-feira".equals(diaDaSemana)){
            return exemplo.TaxaFidelidade(); 
        } else if("Quinta-feira".equals(diaDaSemana)){
            return exemplo.TaxaFidelidade(); 
        } else if("Sexta-feira".equals(diaDaSemana)){
            return exemplo.TaxaFidelidade();
        } else if("Sábado".equals(diaDaSemana)){
            return exemplo.TaxaFidFds();
        } else if("Domingo".equals(diaDaSemana)){
            return exemplo.TaxaFidFds();
        }
        return 0;
     }
        
    public double taxaDoCarroOp3Regular(String diaDaSemana){//Taxa de aluguel de carro opcao 1, cliente Regular     
         NorthCar exemplo = new NorthCar();
         if("Segunda-feira".equals(diaDaSemana)){
            return exemplo.TaxaRegular(); 
        } else if("Terça-feira".equals(diaDaSemana)){
            return exemplo.TaxaRegular();
        } else if("Quarta-feira".equals(diaDaSemana)){
            return exemplo.TaxaRegular(); 
        } else if("Quinta-feira".equals(diaDaSemana)){
            return exemplo.TaxaRegular(); 
        } else if("Sexta-feira".equals(diaDaSemana)){
            return exemplo.TaxaRegular();
        } else if("Sábado".equals(diaDaSemana)){
            return exemplo.TaxaRegFds();
        } else if("Domingo".equals(diaDaSemana)){
            return exemplo.TaxaRegFds();
        }
        return 0;
     }

     
    public void addVetor(String valor){
        ArrayList<String> data1 = data;
        data1.add(valor);
     }
     
    public void setPessoa(int num){
         this.pessoas = num;
     }
   
    public abstract double TaxaRegular();
    public abstract double TaxaFidelidade();
    public abstract double TaxaRegFds();
    public abstract double TaxaFidFds();
    public abstract void setCapacidade();
    public abstract void setNome();
     
}    


