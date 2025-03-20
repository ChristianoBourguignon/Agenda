import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Agenda ctChristiano = new Agenda("Christiano", "123");
        Agenda ctChristiano1 = new Agenda("Christiano", "1234");
        //Agenda.escrita(ctChristiano);
        //Agenda.escrita(ctChristiano1);
        //Agenda.lerTodos();
        //Agenda.lerContato(ctChristiano.getNome());
        Agenda.alterarContato(ctChristiano.getNumero(), "256985");
        Agenda.lerTodos();
    }
}