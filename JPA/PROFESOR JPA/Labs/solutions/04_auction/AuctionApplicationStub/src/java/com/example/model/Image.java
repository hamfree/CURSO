package com.example.model;

import java.io.Serializable;

public class Image
    implements Serializable
{

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

    @Override
    public String toString()
    {
        return "Image{" + "imageId=" + imageId + ", content(bytes)=" + content.length + ", contentType=" + contentType + '}';
    }
}
