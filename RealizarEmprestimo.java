public class RealizarEmprestimo {

    public void RealizarEmprestimo(Usuario usuario, Livro livro) {
        if (usuario.obterVerificacao(usuario, livro)) {
            if(GerenciadorEmprestimos.existeReserva(usuario, livro)){
                Reserva reserva = GerenciadorReservas.getReserva(usuario, livro);
                GerenciadorReservas.removerReserva(reserva);
            }
            Exemplar exemplar = livro.retornarExemplarDisponivel();
            Emprestimo emprestimo = new Emprestimo(usuario,exemplar);
            GerenciadorEmprestimos.adicionarEmprestimo(emprestimo);
            exemplar.setEmprestimo(emprestimo);
            exemplar.setDisponivel(false);
        }
    }
}