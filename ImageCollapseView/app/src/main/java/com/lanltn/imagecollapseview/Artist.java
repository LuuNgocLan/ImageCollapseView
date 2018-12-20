package com.lanltn.imagecollapseview;

public class Artist {
    private int image;
    private String nameArtist;

    public Artist(int image, String nameArtist) {
        this.image = image;
        this.nameArtist = nameArtist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
}
