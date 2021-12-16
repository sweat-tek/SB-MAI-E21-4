package org.jhotdraw.draw.action;

public enum ArrangeType {
    TOFRONT("edit.bringToFront"), TOBACK("edit.sendToBack");

    private String text;

    ArrangeType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
