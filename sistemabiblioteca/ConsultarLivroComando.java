package sistemabiblioteca;

public class ConsultarLivroComando implements Comando {
    @Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
				
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroUm());

        consultarLivro(livro);
	}

    public void consultarLivro(Livro livro) {
        CarregarMensagens.imprimirDetalhesLivro(livro);
        CarregarMensagens.imprimirReservas(livro);
        CarregarMensagens.imprimirExemplares(livro);
    }
}