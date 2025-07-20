// Interface Target - o que o cliente espera
public interface MediaPlayer {
    void play(String audioType, String fileName);
    boolean supports(String audioType);
}