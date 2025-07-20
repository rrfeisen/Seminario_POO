import java.util.*;

// Registro de Protótipos
public class RegistroPrototipos {
    private Map<String, Prototype> prototipos = new HashMap<>();
    
    public void registrar(String chave, Prototype prototipo) {
        prototipos.put(chave, prototipo);
        System.out.println("Protótipo '" + chave + "' registrado com sucesso!");
    }
    
    public Prototype obter(String chave) {
        Prototype prototipo = prototipos.get(chave);
        if (prototipo != null) {
            return prototipo.clone();
        }
        System.out.println("Protótipo '" + chave + "' não encontrado!");
        return null;
    }
    
    public void listarPrototipos() {
        System.out.println("Protótipos disponíveis: " + prototipos.keySet());
    }
}