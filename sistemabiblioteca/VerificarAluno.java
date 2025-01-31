package sistemabiblioteca;

public class VerificarAluno implements IVerificarEmprestimoStrategy{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro){
        if (!livro.temExemplarDisponivel()) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario, livro, "não há exemplares disponíveis para empréstimo.");
            return false;
        }

        if (usuario.isDevedor()) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario,livro, "está devedor com livros em atraso.");
            return false;
        }

        if (GerenciadorEmprestimos.getInstance().procurarEmprestimosPorUsuario(usuario).size() >= usuario.getLimiteEmprestimo()) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario,livro, "excedeu o limite de empréstimos.");
            return false;
        }

        if (GerenciadorReservas.getInstance().procurarReservasPorLivro(livro).size() >= livro.getQuantidadeExemplaresDisponiveis()) {
            if (!GerenciadorReservas.getInstance().existeReserva(usuario, livro)) {
                CarregarMensagens.imprimirFalhaEmprestimo(usuario,livro, "a quantidade de reservas excede a de exemplares disponíveis e o usuário não possui uma reserva.");
                return false;
            }
        }

        if (GerenciadorEmprestimos.getInstance().verificarEmprestimo(usuario, livro)) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario,livro, "já possui um empréstimo em andamento deste livro.");
            return false;
        }

        CarregarMensagens.imprimirSucessoEmprestimo(usuario,livro);
        return true;
    }
}