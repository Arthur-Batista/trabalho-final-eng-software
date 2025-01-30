public class VerificarProfessor implements IVerificarEmprestimoStrategy{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro){
        if (!livro.temExemplarDisponivel()) {
            System.out.println("Não há exemplares disponíveis para o livro: " + livro.getTitulo());
            return false;
        }

        if (usuario.isDevedor()) {
            System.out.println("O professor \"" + usuario.getNome() + "\" está com empréstimos em atraso.");
            return false;
        }

        return true;
        System.out.println("Emprestimo realizado com sucesso.");
    }
}