package sistemabiblioteca;

public class ConsultarNotificacaoComando implements Comando {

    @Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
				
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        consultarNotificacao(usuario);
}

    public void consultarNotificacao(Usuario usuario) {
        CarregarMensagens.imprimirNotificacoes(usuario);
    }
}