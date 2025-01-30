public class DevolverComando implements Comando{
    @Override
    public void execute() {
        Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        RealizarDevolucao.RealizarDevolucao(usuario,livro);
    }
}