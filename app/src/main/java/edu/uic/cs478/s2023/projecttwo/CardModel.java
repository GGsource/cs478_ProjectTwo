package edu.uic.cs478.s2023.projecttwo;

public class CardModel {
    private String title;
    private int imageIndex;

    public CardModel(String givenTitle, int imgNdx) {
        title = givenTitle;
        imageIndex = imgNdx;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String givenTitle) {
        title = givenTitle;
    }
    public int getImageIndex() {
        return imageIndex;
    }
    public void setImageIndex(int imgNdx) {
        imageIndex = imgNdx;
    }
}
