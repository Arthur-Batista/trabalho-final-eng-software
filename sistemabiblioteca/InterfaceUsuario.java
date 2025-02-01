package sistemabiblioteca;

import java.util.HashMap;
import java.util.Scanner;

public class InterfaceUsuario {
    private HashMap<String, Comando> comandos = new HashMap<String, Comando>();
    private Scanner scanner = new Scanner(System.in);

    private void inicializarComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("usu", new ConsultarUsuarioComando());
        comandos.put("dev", new DevolverComando());
        comandos.put("res", new ReservarComando());    
        comandos.put("obs", new RegistrarObservacaoComando());
        comandos.put("liv", new ConsultarLivroComando());
        comandos.put("ntf", new ConsultarNotificacaoComando());
    }

    public void executarComando(String strComando, CarregadorParametros parametros) {
        Comando comando = comandos.get(strComando);
        if (comando != null) {
            comando.executar(parametros);
        } else {
            CarregarMensagens.imprimirComandoNaoReconhecido(strComando);
        }
    }

    public void iniciar() {
        inicializarComandos();
        CarregarMensagens.imprimirMensagemInicial();

        while (true) {
            CarregarMensagens.imprimirMenu();
            String linha = scanner.nextLine();
            String[] partes = linha.split(" "); 

            String comandoStr = partes[0];
            String var1 = (partes.length > 1) ? partes[1] : ""; 
            String var2 = (partes.length > 2) ? partes[2] : ""; 

            if (comandoStr.equalsIgnoreCase("sai")) {
                CarregarMensagens.imprimirMensagemFinal();
                break;
            }

            CarregadorParametros parametros = new CarregadorParametros(var1, var2);
            executarComando(comandoStr, parametros);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        ui.iniciar();
    }
}
