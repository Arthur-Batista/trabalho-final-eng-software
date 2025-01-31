package sistemabiblioteca;

import java.time.LocalDate;

public class DevolverComando implements Comando{
    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        realizarDevolucao(usuario,livro);
    }

    public void realizarDevolucao(Usuario usuario,Livro livro) {
        if(GerenciadorEmprestimos.getInstance().verificarEmprestimo(usuario, livro)){
            Emprestimo emprestimo = GerenciadorEmprestimos.getInstance().getEmprestimo(usuario, livro);
            Exemplar exemplar = emprestimo.getExemplar();
            exemplar.setDisponivel(true);
            exemplar.setEmprestimo(null);
            emprestimo.setFoiDevolvido(LocalDate.now());
            emprestimo.setIsFinalizado(true);
            usuario.adicionarEmprestimosPassados(emprestimo);
            GerenciadorEmprestimos.getInstance().removerEmprestimo(emprestimo);
            CarregarMensagens.imprimirSucessoDevolucao(usuario, livro);
        }    
        else{
            CarregarMensagens.imprimirFalhaDevolucao(usuario, livro);
        }
     }
}