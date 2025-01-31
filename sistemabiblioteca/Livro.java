package sistemabiblioteca;
import java.util.ArrayList;
import java.util.List;

public class Livro implements IObservado{
    private String id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private String anoPublicacao;

    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    private List<IObservador> observadores = new ArrayList<IObservador>();

    public Livro(String id, String titulo, String editora, String autores, String edicao, String anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutores() {
        return autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void adicionarExemplar(Exemplar exemplar){
        exemplares.add(exemplar);
    }

    public void removerExemplar(Exemplar exemplar){
        exemplares.remove(exemplar);
    }

    public List<Exemplar> listarExemplares(){
        return new ArrayList<>(exemplares);
    }

    public int getQuantidadeExemplaresDisponiveis(){
        int quantidade = 0;
        for(Exemplar exemplar : exemplares){
            if(exemplar.isDisponivel()){
                quantidade++;
            }
        }
        return quantidade;
    }

    public Exemplar retornarExemplarDisponivel(){
        for(Exemplar exemplar : exemplares){
            if(exemplar.isDisponivel()){
                return exemplar;
            }
        }
        return null;
    }
    
    public boolean temExemplarDisponivel(){
        for(Exemplar exemplar : exemplares){
            if(exemplar.isDisponivel()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionarObservador(IObservador observador){
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservador observador){
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(){
        for(IObservador observador : observadores){
            observador.atualizar();
        }
    }




    
}
