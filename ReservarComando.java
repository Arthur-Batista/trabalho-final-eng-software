public class ReservarComando implements Comando {
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        RealizarReserva.RealizarReserva(usuario, livro);
    }
}