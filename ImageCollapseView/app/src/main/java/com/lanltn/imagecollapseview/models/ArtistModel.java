package com.lanltn.imagecollapseview.models;

public class ArtistModel
{

    private String urlImage = "https://api.androidhive.info/images/nature/david.jpg";
    private String nameArtist = "ABabあい愛アイ1234567 ";

    public ArtistModel(String urlImage, String nameArtist) {
        this.urlImage = urlImage;
        this.nameArtist = nameArtist;
    }

    public ArtistModel() {
    }

    public String getImage() {
        return urlImage;
    }

    public void setImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
}
