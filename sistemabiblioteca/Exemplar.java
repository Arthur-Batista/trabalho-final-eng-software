package sistemabiblioteca;

public class Exemplar {
    private String id;
    private boolean disponivel;
    private Emprestimo emprestimo;
    private Livro livro;

    public Exemplar(String id, boolean disponivel, Livro livro) {
        this.id = id;
        this.disponivel = disponivel;
        this.emprestimo = null;
        this.livro = livro;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}