package com.example.model;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "IMAGE")
@Entity
public class Image implements Serializable
{
    private static final long serialVersionUID = 3060341368893026501L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int imageId;
    private byte[] content;
    private String contentType;  // needed for MIME type

    public Image()
    {
    }

    public Image( int imageId, byte[] content, String contentType )
    {
        this.imageId = imageId;
        this.content = content;
        this.contentType = contentType;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId( int imageId )
    {
        this.imageId = imageId;
    }

    public byte[] getContent()
    {
        return content;
    }

    public void setContent( byte[] content )
    {
        this.content = content;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType( String contentType )
    {
        this.contentType = contentType;
    }
}
