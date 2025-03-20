import java.io.*;

public class Agenda {
    String nome;
    String numero;

    public Agenda(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome(){
        return this.nome;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setNome(String nome){
        this.nome = numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public static void escrita(Agenda agenda){
        try {
            FileWriter fw = new FileWriter("agenda.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(agenda.getNome()+";"+agenda.getNumero());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    };
    public static void lerTodos() {
        try{
            FileReader fr = new FileReader("agenda.txt");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String aux = br.readLine();
                String [] dados = aux.split(";");
                System.out.println("Nome: "+ dados[0] + " - Telefone: " + dados[1]);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void lerContato(String nome) {
        try{
            FileReader fr = new FileReader("agenda.txt");
            BufferedReader br = new BufferedReader(fr);
            boolean encontrado = false;
            while(br.ready()) {
                String aux = br.readLine();
                String[] dados = aux.split(";");
                if (dados[0].equals(nome)){
                    if (!encontrado) {
                        System.out.println("Encontrado os seguintes contatos com o nome: " + nome);
                        encontrado = true;
                    }
                    System.out.println("Nome: " + dados[0] + " - Telefone: " + dados[1]);
                }
            }
            if (!encontrado){
                System.out.println("Contato " + nome +" não encontrado.");
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void alterarContato(String antNumero, String novoNumero){
        try {
            FileReader fr = new FileReader("agenda.txt");
            BufferedReader br = new BufferedReader(fr);
            boolean encontrado = false;
            while(br.ready()){
                String aux = br.readLine();
                String[] dados = aux.split(";");
                if (dados[1].equals(antNumero)){
                    FileWriter fw = new FileWriter("agenda.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(dados[0]+";"+ novoNumero);
                    bw.close();
                    fw.close();
                }
            }
            if (!encontrado){
                System.out.println("Não encontrado contato com esse numero: " + antNumero);
            }
            fr.close();
            br.close();
            //FileWriter fw = new FileWriter("agenda.txt", true);
            //BufferedWriter bw = new BufferedWriter(fw);
            //bw.write(agenda.getNome()+";"+agenda.getNumero());
            //bw.newLine();
            //bw.close();
            //fw.close();
        } catch (IOException e) {
            System.out.println(e);
        };
    };
}


