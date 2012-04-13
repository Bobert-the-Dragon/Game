/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import interfaces.Drawable;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import rosslib.RossLib;
/**
 *
 * @author r.anderson8
 */
public class Projectile extends Sprite 
                        implements Drawable {
    
    static String resourcesPath = resourcesPathStem + "projectiles/";
    static String dataPath = resourcesPath + "projectile_data.xml";
    
    static int imageCount = 0;
    static int numImages;
    
    static final int defaultSpeed = 18;
    static ArrayList<Projectile>availableProjectiles = new ArrayList<Projectile>();
    
    public boolean destroyed;
    public boolean movingQuickerSpeed;
    
    
    // Should be just high enough of a bounce that there's a possibility it could
    // bounce too high.
    public static final int vertVelocityBounce = -10;

    public Projectile() {
        String filePath = Projectile.dataPath;        
        imageCount++;
        if (imageCount >= numImages) {
            imageCount = 0;
        }
        //name
        name = RossLib.parseXML(filePath, "projectile", imageCount, "name");
        //location
        String location = RossLib.parseXML(filePath, "projectile", imageCount, "location");
        ImageIcon ii = new ImageIcon(location);
        image = ii.getImage();
        worldObjectType = WorldObjectType.PROJECTILE;
        collisionType = CollisionType.IMPASSABLE;
        //width
        int width = Integer.parseInt(RossLib.parseXML(filePath, "projectile", imageCount, "width"));
        //height
        int height = Integer.parseInt(RossLib.parseXML(filePath, "projectile", imageCount, "height"));
        this.moveSpeed = defaultSpeed;
        this.drawHitOffset = (int) (width * 0.12);
        initBoxes(new Rectangle(0, 0,
                                width, height)
                  );
    }
}
