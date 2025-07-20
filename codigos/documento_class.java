import java.util.*;

// Classe concreta - Documento
public class Documento implements Prototype {
    private String titulo;
    private String conteudo;
    private String autor;
    private List<String> tags;
    private Date dataCriacao;
    
    public Documento(String titulo, String conteudo, String autor) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.tags = new ArrayList<>();
        this.dataCriacao = new Date();
    }
    
    // Construtor para clonagem
    private Documento(Documento original) {
        this.titulo = original.titulo;
        this.conteudo = original.conteudo;
        this.autor = original.autor;
        this.tags = new ArrayList<>(original.tags); // Deep copy
        this.dataCriacao = new Date(original.dataCriacao.getTime()); // Deep copy
    }
    
    @Override
    public Documento clone() {
        return new Documento(this);
    }
    
    @Override
    public void exibirInfo() {
        System.out.println("=== DOCUMENTO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Conteúdo: " + conteudo.substring(0, Math.min(50, conteudo.length())) + "...");
        System.out.println("Tags: " + tags);
        System.out.println("Data: " + dataCriacao);
        System.out.println();
    }
    
    // Getters e Setters
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }
    
    public void setConteudo(String conteudo) { 
        this.conteudo = conteudo; 
    }
    
    public void adicionarTag(String tag) { 
        this.tags.add(tag); 
    }
    
    public String getTitulo() { 
        return titulo; 
    }
    
    public String getConteudo() { 
        return conteudo; 
    }
    
    public List<String> getTags() { 
        return new ArrayList<>(tags); 
    }
}