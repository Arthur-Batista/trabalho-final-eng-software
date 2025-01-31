package sistemabiblioteca;

import java.util.HashMap;
import java.util.Scanner;

public class InterfaceUsuario {
    private HashMap<String,Comando> comandos = new HashMap<String,Comando>();
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
		comando.executar(parametros);
	}
	
	public void iniciar() {
        System.out.println("\n📚 Bem-vindo ao Sistema da Biblioteca 📚");
        
        while (true) {
            System.out.println("\nDigite um comando (emp, usu, dev, res, obs, liv, ntf, sai): ");
            String comandoStr = scanner.nextLine();
            
            if (comandoStr.equalsIgnoreCase("sai")) {
                System.out.println("🔴 Encerrando o sistema...");
                break;
            }
             
            CarregadorParametros parametros = new CarregadorParametros(); // Initialize parametros
            executarComando(comandoStr, parametros);
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        ui.iniciar();
    }
}
	
