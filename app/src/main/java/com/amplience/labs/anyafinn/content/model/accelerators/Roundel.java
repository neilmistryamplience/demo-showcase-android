package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.*;
import com.amplience.cms.content.delivery.model.Image;

public class Roundel {

    private com.amplience.cms.content.delivery.model.Image roundel;
    private double roundelRatio;
    private String roundelPosition;

    public Image getRoundel() {
        return roundel;
    }

    public void setRoundel(Image roundel) {
        this.roundel = roundel;
    }

    public double getRoundelRatio() {
        return roundelRatio;
    }

    public void setRoundelRatio(double roundelRatio) {
        this.roundelRatio = roundelRatio;
    }

    public String getRoundelPosition() {
        return roundelPosition;
    }

    public void setRoundelPosition(String roundelPosition) {
        this.roundelPosition = roundelPosition;
    }

}
