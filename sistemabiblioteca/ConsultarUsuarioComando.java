package sistemabiblioteca;

public class ConsultarUsuarioComando implements Comando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
				
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

		consultarUsuario(usuario);
	}

	public void consultarUsuario(Usuario usuario) {
		CarregarMensagens.imprimirEmprestimosCorrentes(usuario);
        CarregarMensagens.imprimirEmprestimosPassados(usuario);
        CarregarMensagens.imprimirReservas(usuario);
	}



}
