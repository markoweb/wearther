package weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Speed {

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
}
