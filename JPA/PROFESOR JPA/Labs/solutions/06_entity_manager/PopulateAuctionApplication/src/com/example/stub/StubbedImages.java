package com.example.stub;

import com.example.model.Image;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;

public class StubbedImages
{
    private static final ConcurrentHashMap<Integer, Image> IMAGES;
    private static int imageId = 2000;
    private static final String IMAGES_DIR = "../../../resources/images/";

    static {
        IMAGES = new ConcurrentHashMap<>();

        String[] imageNames = {
            "AntiquePhoneStand", "Doll", "AntiqueCoffeeGrinder",
            "SaltPepperShakers", "PolarBear", "Backpack",
            "HorseSculpture" };

        for ( String name : imageNames ) {
            createImage( name + ".jpg" );
        }
    }

    public static ConcurrentHashMap<Integer, Image> getIMAGES()
    {
        return IMAGES;
    }

    public static int getNextId()
    {
        return imageId++;
    }

    private static void createImage( String jpgFile )
    {
        try {
            Path p = FileSystems.getDefault().getPath( IMAGES_DIR + jpgFile );
            byte[] photo = Files.readAllBytes( p );
            int id = StubbedImages.getNextId();
            IMAGES.put( id, new Image( id, photo, "image/jpeg" ) );
        }
        catch( IOException e ) {
            System.out.println( "IOException: " + e );
        }
    }
}
