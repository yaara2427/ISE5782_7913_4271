package renderer;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    void testWriteToImage() {
        //checking creation of image with blue background and red grid

        ImageWriter imageWriter=new ImageWriter("testImage",800,500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();
        int interval=50;
        Color red=new Color(255,0,0);
        Color yellow=new Color(255,255,0);

        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                if(i%interval==0 || j%interval==0)
                    imageWriter.writePixel(j, i, red);
                else
                    imageWriter.writePixel(j, i, yellow);
            }
        }
        imageWriter.writeToImage();
    }
}