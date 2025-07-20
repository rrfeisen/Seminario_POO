import java.util.*;

// CLASSE PRINCIPAL - DEMONSTRAÇÃO DOS PADRÕES
public class DemonstracaoPatterns {
    
    public static void main(String[] args) {
        System.out.println("🎯 DEMONSTRAÇÃO DOS PADRÕES PROTOTYPE E ADAPTER");
        System.out.println("=".repeat(60));
        
        demonstrarPrototype();
        
        System.out.println("\n" + "=".repeat(60));
        
        demonstrarAdapter();
    }
    
    private static void demonstrarPrototype() {
        System.out.println("\n🔄 DEMONSTRAÇÃO DO PADRÃO PROTOTYPE");
        System.out.println("-".repeat(40));
        
        // Criar registro de protótipos
        RegistroPrototipos registro = new RegistroPrototipos();
        
        // Criar protótipos base
        Documento docTecnico = new Documento(
            "Manual Técnico Template", 
            "Este é um template para documentos técnicos da empresa. Deve conter introdução, desenvolvimento, conclusão e referências bibliográficas.", 
            "Equipe Técnica"
        );
        docTecnico.adicionarTag("técnico");
        docTecnico.adicionarTag("template");
        docTecnico.adicionarTag("manual");
        
        Relatorio relatorioMensal = new Relatorio("Mensal", "Vendas", "Template Relatório Mensal");
        relatorioMensal.adicionarDado("periodo", "Julho 2025");
        relatorioMensal.adicionarDado("responsavel", "Gerente de Vendas");
        
        // Registrar protótipos
        registro.registrar("doc-tecnico", docTecnico);
        registro.registrar("relatorio-mensal", relatorioMensal);
        
        registro.listarPrototipos();
        
        // Usar protótipos para criar novos objetos
        System.out.println("\n📄 Criando documentos a partir de protótipos:");
        
        Documento novoDoc1 = (Documento) registro.obter("doc-tecnico");
        if (novoDoc1 != null) {
            novoDoc1.setTitulo("Manual de Instalação do Sistema");
            novoDoc1.adicionarTag("instalação");
            novoDoc1.exibirInfo();
        }
        
        Documento novoDoc2 = (Documento) registro.obter("doc-tecnico");
        if (novoDoc2 != null) {
            novoDoc2.setTitulo("Guia de Troubleshooting");
            novoDoc2.adicionarTag("suporte");
            novoDoc2.exibirInfo();
        }
        
        Relatorio novoRel1 = (Relatorio) registro.obter("relatorio-mensal");
        if (novoRel1 != null) {
            novoRel1.setDepartamento("Marketing");
            novoRel1.adicionarDado("vendas_totais", "R$ 150.000");
            novoRel1.exibirInfo();
        }
        
        System.out.println("✅ Protótipos demonstrados com sucesso!");
    }
    
    private static void demonstrarAdapter() {
        System.out.println("\n🔌 DEMONSTRAÇÃO DO PADRÃO ADAPTER");
        System.out.println("-".repeat(40));
        
        AudioPlayer player = new AudioPlayer();
        
        // Listar formatos suportados
        player.listarFormatosSuportados();
        
        // Array de arquivos para testar
        String[][] arquivos = {
            {"mp3", "musica.mp3"},
            {"mp4", "video.mp4"},
            {"vlc", "filme.vlc"},
            {"avi", "documentario.avi"},
            {"wav", "efeito_sonoro.wav"},
            {"ogg", "podcast.ogg"},
            {"flac", "audio_hd.flac"} // Formato não suportado
        };
        
        System.out.println("\n🎵 Testando reprodução de diferentes formatos:");
        for (String[] arquivo : arquivos) {
            String formato = arquivo[0];
            String nome = arquivo[1];
            
            System.out.printf("\n▶️  Tentando reproduzir: %s (%s)\n", nome, formato.toUpperCase());
            player.play(formato, nome);
        }
        
        System.out.println("\n✅ Adapters demonstrados com sucesso!");
        
        // Demonstrar verificação de suporte
        System.out.println("\n🔍 Verificando suporte a formatos:");
        String[] formatosParaTestar = {"mp3", "mp4", "wav", "flac", "mkv"};
        
        for (String formato : formatosParaTestar) {
            boolean suportado = player.supports(formato);
            String status = suportado ? "✅ Suportado" : "❌ Não suportado";
            System.out.printf("• %s: %s\n", formato.toUpperCase(), status);
        }
    }
}