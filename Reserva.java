public class Reserva {
    private Usuario usuario;
    private Date dataReserva;
    private Livro livro;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.dataReserva = LocalDate.now();
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
}