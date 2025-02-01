package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private static Repositorio instancia;

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    // Construtor privado para garantir que não haja mais de uma instância
    private Repositorio() {
        inicializarDados();
    }

    // Método para obter a instância única do repositório
    public static Repositorio obterInstancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    // Método para buscar um usuário pelo código
    public Usuario obterUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuarioId().equals(codigo)) {
                return usuario;
            }
        }
        // Caso não encontre o usuário, exibimos uma mensagem
        System.out.println("Usuário não encontrado com o código: " + codigo);
        return null; // Retorna null, indicando que não foi encontrado
    }

    // Método para buscar um livro pelo código
    public Livro obterLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getId().equals(codigo)) {
                return livro;
            }
        }
        // Caso não encontre o livro, exibimos uma mensagem
        System.out.println("Livro não encontrado com o código: " + codigo);
        return null; // Retorna null, indicando que não foi encontrado
    }

	private void inicializarDados() {

        usuarios.add(new AlunoGraduacao("123", "João da Silva"));
        usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGraduacao("789", "Pedro Paulo"));
        usuarios.add(new Professor("100", "Carlos Lucena"));

        Livro livro1 = new Livro("100", "Engenharia de Software", "Addison Wesley", "Ian Sommerville", "6a", "2000");
        Livro livro2 = new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7a", "2000");
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2a", "2014");
        Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", "Robert Martin", "1a", "2002");
        Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", "Martin Fowler", "1a", "1999");
        Livro livro6 = new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3a", "2014");
        Livro livro7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1a", "1994");
        Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", "Martin Fowler", "3a", "2003");


        livros.add(livro1);
        livros.add(livro2);
		livros.add(livro3);
		livros.add(livro4);
		livros.add(livro5);
		livros.add(livro6);
		livros.add(livro7);
		livros.add(livro8);

		livro1.adicionarExemplar(new Exemplar("01", true, livro1));
		livro1.adicionarExemplar(new Exemplar("02", true, livro1));
		livro2.adicionarExemplar(new Exemplar("03", true, livro2));
		livro3.adicionarExemplar(new Exemplar("04", true, livro3));
		livro3.adicionarExemplar(new Exemplar("04", true, livro3));
		livro4.adicionarExemplar(new Exemplar("05", true, livro4));
		livro5.adicionarExemplar(new Exemplar("06", true, livro5));
		livro5.adicionarExemplar(new Exemplar("07", true, livro5));
		livro7.adicionarExemplar(new Exemplar("08", true, livro7));
		livro7.adicionarExemplar(new Exemplar("09", true, livro7));
    }
}
