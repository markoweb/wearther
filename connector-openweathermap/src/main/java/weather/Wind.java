package weather;

import javax.xml.bind.annotation.XmlElement;

public class Wind {

    private Speed speed;
    private Direction direction;

    public Speed getSpeed() {
        return speed;
    }

    @XmlElement
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    @XmlElement
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
