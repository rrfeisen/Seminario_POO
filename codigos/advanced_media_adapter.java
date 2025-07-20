import java.util.*;

// Adapter para AdvancedMediaPlayer
public class AdvancedMediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer;
    private String[] supportedFormats = {"vlc", "mp4", "avi"};
    
    public AdvancedMediaAdapter() {
        this.advancedPlayer = new AdvancedMediaPlayer();
    }
    
    @Override
    public void play(String audioType, String fileName) {
        audioType = audioType.toLowerCase();
        
        switch (audioType) {
            case "vlc":
                advancedPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedPlayer.playMp4(fileName);
                break;
            case "avi":
                advancedPlayer.playAvi(fileName);
                break;
            default:
                System.out.println("❌ Formato " + audioType + " não suportado pelo AdvancedMediaAdapter");
        }
    }
    
    @Override
    public boolean supports(String audioType) {
        return Arrays.asList(supportedFormats).contains(audioType.toLowerCase());
    }
}