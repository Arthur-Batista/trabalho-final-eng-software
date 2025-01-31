package sistemabiblioteca;

public class ReservarComando implements Comando {
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        realizarReserva(usuario, livro);
    }
        
    public void realizarReserva(Usuario usuario, Livro livro) {
        if (GerenciadorReservas.getInstance().procurarReservasPorUsuario(usuario).size() < 3) {
            Reserva reserva = new Reserva(usuario, livro);
            GerenciadorReservas.getInstance().adicionarReserva(reserva);
            CarregarMensagens.imprimirSucessoReserva(usuario, livro);
        }
        else{
            CarregarMensagens.imprimirFalhaReserva(usuario, livro);
        }
    }

}