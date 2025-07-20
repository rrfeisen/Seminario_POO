import java.util.*;

// Client - classe principal que usa a interface MediaPlayer
public class AudioPlayer implements MediaPlayer {
    private List<MediaPlayer> adapters;
    
    public AudioPlayer() {
        // Registra todos os adapters disponíveis
        adapters = new ArrayList<>();
        adapters.add(new AdvancedMediaAdapter());
        adapters.add(new LegacyAudioAdapter());
    }
    
    @Override
    public void play(String audioType, String fileName) {
        audioType = audioType.toLowerCase();
        
        // Formatos nativos suportados
        if (audioType.equals("mp3")) {
            System.out.println("🎵 Reproduzindo arquivo MP3: " + fileName);
            return;
        }
        
        // Tenta encontrar um adapter que suporte o formato
        for (MediaPlayer adapter : adapters) {
            if (adapter.supports(audioType)) {
                adapter.play(audioType, fileName);
                return;
            }
        }
        
        System.out.println("❌ Formato " + audioType + " não é suportado por nenhum adapter disponível");
    }
    
    @Override
    public boolean supports(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            return true;
        }
        
        for (MediaPlayer adapter : adapters) {
            if (adapter.supports(audioType)) {
                return true;
            }
        }
        return false;
    }
    
    public void listarFormatosSuportados() {
        System.out.println("\n📋 Formatos suportados:");
        System.out.println("• MP3 (nativo)");
        System.out.println("• VLC, MP4, AVI (via AdvancedMediaAdapter)");
        System.out.println("• WAV, OGG (via LegacyAudioAdapter)");
    }
}