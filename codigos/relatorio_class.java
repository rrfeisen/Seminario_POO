import java.util.*;

// Classe concreta - Relatório
public class Relatorio implements Prototype {
    private String tipo;
    private String departamento;
    private Map<String, Object> dados;
    private String template;
    
    public Relatorio(String tipo, String departamento, String template) {
        this.tipo = tipo;
        this.departamento = departamento;
        this.template = template;
        this.dados = new HashMap<>();
    }
    
    private Relatorio(Relatorio original) {
        this.tipo = original.tipo;
        this.departamento = original.departamento;
        this.template = original.template;
        this.dados = new HashMap<>(original.dados); // Shallow copy é suficiente aqui
    }
    
    @Override
    public Relatorio clone() {
        return new Relatorio(this);
    }
    
    @Override
    public void exibirInfo() {
        System.out.println("=== RELATÓRIO ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Departamento: " + departamento);
        System.out.println("Template: " + template);
        System.out.println("Dados: " + dados);
        System.out.println();
    }
    
    public void adicionarDado(String chave, Object valor) {
        dados.put(chave, valor);
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}