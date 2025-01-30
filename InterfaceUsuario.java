package sistemabiblioteca;
import java.util.HashMap;

public class InterfaceUsuario {
	private  

	private HashMap<String,Comando> comandos = new HashMap<String,Comando>();
	
	private void inicializarComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("usu", new ConsultarUsuarioComando());
		comandos.put("dev", new DevolverComando());
		comandos.put("res", new ReservarComando());	
		comandos.put("obs", new RegistrarObservacaoComando());
		comandos.put("liv", new ConsultarLivroComando());
		comandos.put("ntf", new ConsultarNotificacoesComando());
		comandos.put("sai", new SairComando());
	}
	
	public void executarComando(String strComando, CarregadorParametros parametros) {
		Comando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
	
	//M�todos abaixo para fazer a interface com usu�rio via linha de commando
	//...
	

}
