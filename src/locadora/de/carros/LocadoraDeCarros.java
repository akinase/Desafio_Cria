package locadora.de.carros;

import java.time.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Wesley Ribeiro de Souza
 */
public class LocadoraDeCarros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException { 

        double data;
        int opcao, numPessoas;
        boolean cliente;
        
        ArrayList<String> vetor = new ArrayList<String>();
        
        try {
            FileReader  arquivo = new FileReader ("locacao.txt");
            BufferedReader br = new BufferedReader(new FileReader ("locacao.txt"));
            
            Scanner entrada = new Scanner(arquivo);            

            opcao = entrada.nextInt();//tipo do carro
            numPessoas = entrada.nextInt();//Quantidade de pessoas
            cliente = entrada.hasNextBoolean();//Tem fidelidade ou não
            
            String str;
            while((str = br.readLine()) != null) {//leitura das datas
                String[] aux = str.split(" ");
                
                vetor.add(aux[3]);
                vetor.add(aux[4]);
                vetor.add(aux[5]);
            } 
            
            SouthCar exemplo = new SouthCar();// Obj criado para o vetor ser implementado na classe abstrata
            
            for(int i = 0; i < vetor.size(); i++){
                //vetor de data
                exemplo.addVetor(vetor.get(i));
            }
            if(cliente == true){//se cliente for premium
                exemplo.verificarPremium(numPessoas);
            }else
                 exemplo.verificarNormal(numPessoas);
            exemplo.tabela(cliente);

        }catch (FileNotFoundException e) {
            System.out.println("Erro de leitura, verifique o arquivo");
            e.printStackTrace();
        }
           

           /* 
            switch(opcao){
                case 1:
                    SouthCar carro1 = new SouthCar();
                    break;                
                case 2:
                    WestCar carro2 = new WestCar();
                    break;
                case 3:
                    NorthCar carro3 = new NorthCar();
                    break;
            }
            {
        
        
        
        
       /** LocalDate localDate = LocalDate.of(ano, Month.MARCH, dia);
        System.out.println(localDate);
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
        System.out.println("Mes: " + localDate.getMonthValue());
        System.out.println("Mes: " + localDate.getMonth().name());       
        System.out.println("Ano: " + localDate.getYear());
        */
    
        
        // DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
        //System.out.println(dff.format(data)); // Segunda-feira, 14 de Março de 2016
    }
    
}
