package experiment.designerpattern.agileppp.decorator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class HayesModem implements Modem {
    private String itsPhoneNumber;
    private int itsSpekaerVolume;

    @Override
    public void dial(String pno) {
        itsPhoneNumber = pno;
    }

    @Override
    public void setSpeakerVolume(int volume) {
        itsSpekaerVolume = volume;
    }

    @Override
    public String getPhoneNumber() {
        return itsPhoneNumber;
    }

    @Override
    public int getSpeakerVolume() {
        return itsSpekaerVolume;
    }
}
