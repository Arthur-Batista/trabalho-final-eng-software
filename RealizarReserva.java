public class RealizarReserva {
    public void RealizarReservasAtuais(Usuario usuario, Livro livro) {
        if (GerenciadorReservas.procurarReservasPorUsuario(usuario).size() < 3) {
            Reserva reserva = new Reserva(usuario, livro);
            GerenciadorReservas.adicionarReserva(reserva);
        }
    }

}