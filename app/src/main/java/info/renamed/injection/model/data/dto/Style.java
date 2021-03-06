package info.renamed.injection.model.data.dto;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static info.renamed.injection.model.data.dto.ColorHelper.parseColor;

public class Style implements Serializable {
    public final static String DEFAULT_COLOR = "#3F51B5"; //blue
    public final static String DEFAULT_BORDER_COLOR = "#000000"; //black
    public final static String DEFAULT_TEXT_COLOR = "#000000"; //black

    private static final int MAX_CORNER_RADIUS = 40;
    private static final int DEF_CORNER_RADIUS = 8;

    @SerializedName("id") private long id;
    @SerializedName("color") private String color;
    @SerializedName("border_color") private String border_color;
    @SerializedName("text_color") private String text_color;
    @SerializedName("corner_radius") private float corner_radius;



    public Style(long id,
                 String color,
                 String border_color,
                 String text_color,
                 float corner_radius) {
        this.id = id;
        this.color = color;
        this.border_color = border_color;
        this.text_color = text_color;
        this.corner_radius = corner_radius;
    }

    public static Style getDefaultStyle() {
        return new Style(-1,
                DEFAULT_COLOR,
                DEFAULT_BORDER_COLOR,
                DEFAULT_TEXT_COLOR,
                DEF_CORNER_RADIUS);
    }

    public long getId() {
        return id;
    }

    public int getColor() {
        return parseColor(color, Color.GRAY);
    }

    public int getBorderColor() {
        return parseColor(border_color, Color.GRAY);
    }

    public int getTextColor() {
        return parseColor(text_color, Color.BLACK);
    }

    public float getCornerRadius() {
        return corner_radius > MAX_CORNER_RADIUS ? DEF_CORNER_RADIUS : corner_radius;
    }
}
