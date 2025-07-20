import java.util.*;

// Adapter para LegacyAudioSystem
public class LegacyAudioAdapter implements MediaPlayer {
    private LegacyAudioSystem legacySystem;
    private String[] supportedFormats = {"wav", "ogg"};
    
    public LegacyAudioAdapter() {
        this.legacySystem = new LegacyAudioSystem();
    }
    
    @Override
    public void play(String audioType, String fileName) {
        audioType = audioType.toLowerCase();
        
        switch (audioType) {
            case "wav":
                legacySystem.reproduzirWav(fileName);
                break;
            case "ogg":
                legacySystem.reproduzirOgg(fileName);
                break;
            default:
                System.out.println("❌ Formato " + audioType + " não suportado pelo LegacyAudioAdapter");
        }
    }
    
    @Override
    public boolean supports(String audioType) {
        return Arrays.asList(supportedFormats).contains(audioType.toLowerCase());
    }
}