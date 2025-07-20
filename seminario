# Padrões de Projeto: Prototype e Adapter
**Seminário de POO**

---

## 1. Contextualização e Introdução

### O que são Padrões de Projeto?

Os padrões de projeto (*Design Patterns*) são soluções reutilizáveis para problemas comuns que ocorrem no desenvolvimento de software. Eles representam as melhores práticas desenvolvidas por programadores experientes ao longo do tempo e foram formalizados pela primeira vez no livro "Design Patterns: Elements of Reusable Object-Oriented Software" (1994), conhecido como "Gang of Four" (GoF).

### Motivações para uso de Padrões de Projeto:

- **Reutilização**: Soluções testadas e aprovadas
- **Comunicação**: Vocabulário comum entre desenvolvedores
- **Qualidade**: Código mais robusto e manutenível
- **Flexibilidade**: Sistemas mais adaptáveis a mudanças
- **Produtividade**: Redução do tempo de desenvolvimento

### Vantagens da Aplicação:

1. **Padronização**: Estabelece um padrão de desenvolvimento consistente
2. **Manutenibilidade**: Facilita a manutenção e evolução do código
3. **Legibilidade**: Torna o código mais compreensível
4. **Testabilidade**: Facilita a criação de testes unitários
5. **Escalabilidade**: Permite que o sistema cresça de forma organizada

---

## 2. Categorias dos Padrões de Projeto

Os padrões de projeto são classificados em três categorias principais:

### 2.1 Padrões Criacionais (Creational Patterns)
**Objetivo**: Abstraem o processo de criação de objetos, tornando o sistema independente de como seus objetos são criados, compostos e representados.

**Padrões**:
- **Abstract Factory**: Cria famílias de objetos relacionados
- **Builder**: Constrói objetos complexos passo a passo
- **Factory Method**: Cria objetos sem especificar suas classes exatas
- **Prototype**: Cria objetos através de clonagem
- **Singleton**: Garante uma única instância de uma classe

### 2.2 Padrões Estruturais (Structural Patterns)
**Objetivo**: Lidam com a composição de classes e objetos, formando estruturas maiores e mais complexas.

**Padrões**:
- **Adapter**: Permite que classes incompatíveis trabalhem juntas
- **Bridge**: Separa abstração de implementação
- **Composite**: Compõe objetos em estruturas de árvore
- **Decorator**: Adiciona funcionalidades dinamicamente
- **Facade**: Fornece interface simplificada para subsistemas
- **Flyweight**: Compartilha objetos para reduzir uso de memória
- **Proxy**: Fornece substituto ou placeholder para outro objeto

### 2.3 Padrões Comportamentais (Behavioral Patterns)
**Objetivo**: Focam nos algoritmos e na atribuição de responsabilidades entre objetos.

**Padrões**:
- **Chain of Responsibility**: Passa requisições através de cadeia de handlers
- **Command**: Encapsula requisições como objetos
- **Interpreter**: Define gramática para linguagem e interpreta sentenças
- **Iterator**: Acessa elementos de coleção sequencialmente
- **Mediator**: Define comunicação entre objetos
- **Memento**: Captura e restaura estado interno de objetos
- **Observer**: Define dependência um-para-muitos entre objetos
- **State**: Permite que objeto altere comportamento quando estado muda
- **Strategy**: Define família de algoritmos intercambiáveis
- **Template Method**: Define esqueleto de algoritmo
- **Visitor**: Separa algoritmo da estrutura de objetos

---

## 3. Padrão Prototype

### 3.1 Objetivo e Problema Resolvido

O padrão **Prototype** é um padrão criacional que permite criar novos objetos clonando instâncias existentes, sem acoplar o código às classes específicas dos objetos que estão sendo clonados.

**Problema que resolve**:
- Criação custosa de objetos (ex: leitura de banco de dados, arquivos)
- Necessidade de criar objetos similares com pequenas variações
- Evitar subclasses apenas para especializar criação de objetos
- Criar objetos sem conhecer suas classes concretas

### 3.2 Conceitos Envolvidos

- **Clonagem**: Processo de criar cópia exata de um objeto
- **Shallow Copy**: Copia apenas referências dos objetos internos
- **Deep Copy**: Cria novos objetos para todas as referências internas
- **Registro de Protótipos**: Armazena protótipos pré-configurados

### 3.3 Funcionamento e Aplicação

O padrão funciona através da implementação de um método `clone()` nas classes que serão clonadas. O cliente solicita a clonagem ao invés de criar novos objetos diretamente.

**Aplicações práticas**:
- Sistemas de configuração com templates pré-definidos
- Editores gráficos (cópia de formas, elementos)
- Jogos (clonagem de personagens, itens)
- Sistemas CAD (Computer Aided Design)

### 3.4 Diagrama UML - Prototype

```
┌─────────────────────┐
│    <<interface>>    │
│     Prototype       │
├─────────────────────┤
│ + clone(): Object   │
└─────────────────────┘
           △
           │
┌──────────────────────┐
│  ConcretePrototype   │
├──────────────────────┤
│ - field1: String     │
│ - field2: int        │
├──────────────────────┤
│ + clone(): Object    │
│ + getField1(): String│
│ + setField1(String)  │
└──────────────────────┘
           △
           │
┌───────────────────────┐
│       Client          │
├───────────────────────┤
│ - prototype: Prototype│
├───────────────────────┤
│ + operation()         │
└───────────────────────┘
```

### 3.5 Implementação Java - Prototype

**Interface Prototype:**
```java
public interface Prototype extends Cloneable {
    Prototype clone();
}
```

**Classe Concreta:**
```java
public class Documento implements Prototype {
    private String titulo;
    private String conteudo;
    private List<String> tags;
    
    public Documento(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tags = new ArrayList<>();
    }
    
    @Override
    public Documento clone() {
        try {
            Documento clone = (Documento) super.clone();
            // Deep copy da lista
            clone.tags = new ArrayList<>(this.tags);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro na clonagem", e);
        }
    }
    
    // Getters e setters...
}
```

**Registro de Protótipos:**
```java
public class RegistroPrototipos {
    private Map<String, Prototype> prototipos = new HashMap<>();
    
    public void registrar(String chave, Prototype prototipo) {
        prototipos.put(chave, prototipo);
    }
    
    public Prototype obter(String chave) {
        Prototype prototipo = prototipos.get(chave);
        return prototipo != null ? prototipo.clone() : null;
    }
}
```

---

## 4. Padrão Adapter

### 4.1 Objetivo e Problema Resolvido

O padrão **Adapter** é um padrão estrutural que permite que objetos com interfaces incompatíveis colaborem entre si, atuando como um tradutor entre duas interfaces diferentes.

**Problema que resolve**:
- Integração de bibliotecas de terceiros com interfaces incompatíveis
- Reutilização de classes existentes que não possuem a interface adequada
- Adaptação de sistemas legados para novas interfaces
- Comunicação entre componentes com protocolos diferentes

### 4.2 Conceitos Envolvidos

- **Target**: Interface esperada pelo cliente
- **Adaptee**: Classe existente com interface incompatível
- **Adapter**: Classe que adapta Adaptee para Target
- **Client**: Classe que usa a interface Target

### 4.3 Funcionamento e Aplicação

O Adapter implementa a interface esperada pelo cliente e internamente delega as chamadas para o objeto adaptado, fazendo as conversões necessárias.

**Aplicações práticas**:
- Integração de APIs diferentes
- Adaptação de drivers de banco de dados
- Conversores de formato de dados
- Wrappers para bibliotecas legadas

### 4.4 Diagrama UML - Adapter

```
┌─────────────────────┐    ┌─────────────────────┐
│       Client        │────│    <<interface>>    │
└─────────────────────┘    │       Target        │
                           ├─────────────────────┤
                           │ + request(): void   │
                           └─────────────────────┘
                                      △
                                      │
                           ┌─────────────────────┐    ┌─────────────────────┐
                           │      Adapter        │────│      Adaptee        │
                           ├─────────────────────┤    ├─────────────────────┤
                           │ - adaptee: Adaptee  │    │ + specificRequest() │
                           ├─────────────────────┤    └─────────────────────┘
                           │ + request(): void   │
                           └─────────────────────┘
```

### 4.5 Implementação Java - Adapter

**Interface Target:**
```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

**Adaptee (classe incompatível):**
```java
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Reproduzindo arquivo vlc: " + fileName);
    }
    
    public void playMp4(String fileName) {
        System.out.println("Reproduzindo arquivo mp4: " + fileName);
    }
}
```

**Adapter:**
```java
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer;
    
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc") || 
            audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new AdvancedMediaPlayer();
        }
    }
    
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}
```

**Client:**
```java
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;
    
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduzindo arquivo mp3: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || 
                   audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Formato " + audioType + " não suportado");
        }
    }
}
```

---

## 5. Comparação entre Prototype e Adapter

| Aspecto | Prototype | Adapter |
|---------|-----------|---------|
| **Categoria** | Criacional | Estrutural |
| **Propósito** | Criar objetos por clonagem | Compatibilizar interfaces |
| **Problema** | Criação custosa de objetos | Interfaces incompatíveis |
| **Solução** | Clonagem de instâncias | Tradução de chamadas |
| **Uso típico** | Templates, configurações | Integração de sistemas |

---

## 6. Vantagens e Desvantagens

### Prototype
**Vantagens:**
- Reduz custo de criação de objetos complexos
- Permite runtime configuration
- Reduz número de subclasses

**Desvantagens:**
- Implementação complexa do clone
- Problemas com referências circulares
- Shallow vs Deep copy

### Adapter
**Vantagens:**
- Permite reutilização de código existente
- Separa lógica de negócio da interface
- Flexibilidade na integração

**Desvantagens:**
- Aumenta complexidade do código
- Overhead de performance
- Pode mascarar problemas de design

---

## 7. Referências

### Bibliografia Principal:
1. GAMMA, Erich et al. **Design Patterns: Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1994.
2. FREEMAN, Eric; FREEMAN, Elisabeth. **Head First Design Patterns**. O'Reilly Media, 2004.
3. SHALLOWAY, Alan; TROTT, James R. **Design Patterns Explained: A New Perspective on Object-Oriented Design**. Addison-Wesley, 2004.

### Referencias Complementares:
4. MARTIN, Robert C. **Clean Code: A Handbook of Agile Software Craftsmanship**. Prentice Hall, 2008.
5. FOWLER, Martin. **Refactoring: Improving the Design of Existing Code**. Addison-Wesley, 1999.
6. Oracle Java Documentation - **Cloneable Interface**. Disponível em: https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html

### Sites e Recursos Online:
7. **Refactoring.Guru** - Design Patterns. Disponível em: https://refactoring.guru/design-patterns
8. **SourceMaking** - Design Patterns. Disponível em: https://sourcemaking.com/design_patterns
9. **Java Design Patterns** - GitHub Repository. Disponível em: https://github.com/iluwatar/java-design-patterns

---
