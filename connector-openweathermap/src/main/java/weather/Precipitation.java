package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Precipitation {

    private String mode;

    public String getMode() {
        return mode;
    }

    @XmlAttribute
    public void setMode(String mode) {
        this.mode = mode;
    }
}
