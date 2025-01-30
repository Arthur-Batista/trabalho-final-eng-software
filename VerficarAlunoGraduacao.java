public class VerificarAluno implements IVerificarEmprestimoStrategy{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro){
         if (!livro.temExemplarDisponivel()) {
            System.out.println("Não há exemplares disponíveis para empréstimo.");
            return false;
        }

        if (usuario.isDevedor()) {
            System.out.println("Usuário está devedor com livros em atraso.");
            return false;
        }

        if (GerenciadorEmprestimos.procurarEmprestimosPorUsuario(usuario).size() >= usuario.getLimiteEmprestimo()){
            System.out.println("Usuário excedeu o limite de empréstimos.");
            return false;
        }

        if (GerenciadorReservas.procurarReservasPorLivro(livro).size() >= livro.getQuantidadeExemplaresDisponiveis()) {
            if (!GerenciadorReservas.existeReserva(usuario, livro)) {
                System.out.println("Quantidade de reservas excede a de exemplares disponíveis e o usuário não possui uma reserva.");
                return false;
            }
        }

        if (GerenciadorEmprestimos.verificarEmprestimo(usuario, livro)) {
            System.out.println("Usuário já possui um empréstimo em andamento deste livro.");
            return false;
        }

        return true;
        System.out.println("Emprestimo realizado com sucesso.");
    }
}