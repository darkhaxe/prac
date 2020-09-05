package designerpattern.agileppp.decorator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface Modem {
    void dial(String pno);

    void setSpeakerVolume(int volume);

    String getPhoneNumber();

    int getSpeakerVolume();
}
