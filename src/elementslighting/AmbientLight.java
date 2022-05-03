package elementslighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
    private final Color intensity;

    public AmbientLight(Color Ia, Double3 Ka) {
        intensity = Ia.scale(Ka);
    }
    public AmbientLight() {
        intensity= Color.BLACK;
    }

    public Color getIntensity() {
        return intensity;
    }
}
