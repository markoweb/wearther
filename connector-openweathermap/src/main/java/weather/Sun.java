package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Sun {

    private String rise;
    private String set;

    public String getRise() {
        return rise;
    }

    @XmlAttribute
    public void setRise(String rise) {
        this.rise = rise;
    }

    public String getSet() {
        return set;
    }

    @XmlAttribute
    public void setSet(String set) {
        this.set = set;
    }
}
