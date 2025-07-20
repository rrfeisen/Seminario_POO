// Adaptee - classe incompatível que queremos usar
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("🎵 Reproduzindo arquivo VLC: " + fileName);
    }
    
    public void playMp4(String fileName) {
        System.out.println("🎬 Reproduzindo arquivo MP4: " + fileName);
    }
    
    public void playAvi(String fileName) {
        System.out.println("🎞️  Reproduzindo arquivo AVI: " + fileName);
    }
}