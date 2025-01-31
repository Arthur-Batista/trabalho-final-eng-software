package sistemabiblioteca;

public interface IVerificarEmprestimoStrategy{
    public boolean podeEmprestar(Usuario usuario, Livro livro);
}
