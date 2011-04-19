// SpriteGenerator - a simple java program for creating vertical sprites from a folder of PNG images.
//
// The software is released free of any copyright of license restrictions.
// Modified by Mark Young (http://www.zarzax.com) April 2011
// originally by Peter Moberg (http://sourcecodebean.com/archives/a-simple-image-sprite-generator-in-java/1065) April 2011
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
 
public class SpriteGenerator {
 
    public static void main(String[] args) throws IOException {
 
        if (args.length != 3)
        {
           System.out.print("Usage: SpriteGenerator {path to images} {margin between images in px} {output file}\n");
           System.out.print("Note: The max height should only be around 32,767px due to Microsoft GDI using a 16bit signed integer to store dimensions\n");
           System.out.print("going beyond this dimension is possible with this tool but the generated sprite image will not work correctly with\n");
           System.out.print("most browsers.\n\n");
           return;
        }
 
        String imagePath = args[0];
        Integer margin = Integer.parseInt(args[1]);
        String outputFile = args[2];
 
        File imageFolder = new File(imagePath);
        File[] files = imageFolder.listFiles();
 
        // Read images
        ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
 
        for (File f : files)
        {
            if (f.isFile())
            {
                String fileName = f.getName();
                String ext = fileName.substring(fileName.lastIndexOf(".")+1,
                                     fileName.length());
 
                if (ext.equals("png"))
                {
                    imageList.add(ImageIO.read(f));
                }
            }
        }
 
        // Find max width and total height
        int maxWidth = 0;
        int totalHeight = 0;
 
        for (BufferedImage image : imageList)
        {
            totalHeight += image.getHeight() + margin;
 
            if (image.getWidth() > maxWidth)
                maxWidth = image.getWidth();
        }
 
        System.out.format("Number of images: %s, total height: %spx, width: %spx%n",
                                      imageList.size(), totalHeight, maxWidth);
 
 
        // Create the actual sprite
        BufferedImage sprite = new BufferedImage(maxWidth, totalHeight,
                                                      BufferedImage.TYPE_INT_ARGB);
 
        int currentY = 0;
        Graphics g = sprite.getGraphics();
        for (BufferedImage image : imageList)
        {
            g.drawImage(image, 0, currentY, null);
            currentY += image.getHeight() + margin;
        }
 
        System.out.format("Writing sprite: %s%n", outputFile);
        ImageIO.write(sprite, "png", new File(outputFile));
    }
}
 