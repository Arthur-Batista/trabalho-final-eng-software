package sistemabiblioteca;

public class EmprestarComando implements Comando {
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());
		
		realizarEmprestimo(usuario,livro);
		}

	public void realizarEmprestimo(Usuario usuario,Livro livro){
		if (usuario.obterVerificacao(usuario, livro)) {
            if(GerenciadorReservas.getInstance().existeReserva(usuario, livro)){
                Reserva reserva = GerenciadorReservas.getInstance().getReserva(usuario, livro);
                GerenciadorReservas.getInstance().removerReserva(reserva);
            }
            Exemplar exemplar = livro.retornarExemplarDisponivel();
            Emprestimo emprestimo = new Emprestimo(usuario,exemplar);
            GerenciadorEmprestimos.getInstance().adicionarEmprestimo(emprestimo);
            exemplar.setEmprestimo(emprestimo);
            exemplar.setDisponivel(false);
        }
	}	
		
	}

