package sistemabiblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean isFinalizado;
    private LocalDate foiDevolvido;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = calcularDataDevolucao();
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.foiDevolvido = null;
        this.isFinalizado = false;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    private LocalDate calcularDataDevolucao() {
        int diasEmprestimo = usuario.getTempoEmprestimo();
        return dataEmprestimo.plusDays(diasEmprestimo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public boolean isFinalizado() {
        return isFinalizado;
    }

    public void setIsFinalizado(boolean isFinalizado) {
        this.isFinalizado = isFinalizado;
    }

    public LocalDate getFoiDevolvido() {
        return foiDevolvido;
    }

    public void setFoiDevolvido(LocalDate foiDevolvido) {
        this.foiDevolvido = foiDevolvido;
    }

}