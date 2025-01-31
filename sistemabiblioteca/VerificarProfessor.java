package sistemabiblioteca;

public class VerificarProfessor implements IVerificarEmprestimoStrategy{
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro){
        if (!livro.temExemplarDisponivel()) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario,livro, "não há exemplares disponíveis para o livro: " + livro.getTitulo() + ".");
            return false;
        }

        if (usuario.isDevedor()) {
            CarregarMensagens.imprimirFalhaEmprestimo(usuario, livro, "está com empréstimos em atraso.");
            return false;
        }

        CarregarMensagens.imprimirSucessoEmprestimo(usuario, livro);
        return true;
    }
}