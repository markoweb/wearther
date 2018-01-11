package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Visibility {

    private String value;

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }
}
