package sistemabiblioteca;

public class RegistrarObservacaoComando implements Comando {
    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());
		
        registrarObservador(usuario, livro);
		}

    public void registrarObservador( Usuario usuario,Livro livro){
        IObservador observador = usuario.getObservador();
        livro.adicionarObservador(observador);
        CarregarMensagens.imprimirSucessoObservacao(usuario, livro);
        }   
    }
  