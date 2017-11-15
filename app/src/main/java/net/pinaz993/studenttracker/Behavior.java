package net.pinaz993.studenttracker;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

/**
 * Created by Patrick Shannon on 10/18/2017.
 * This class represents user defined behaviors that are either positive, negative, or neutral.
 * Instances of a behavior can be recorded in a database, and later can be compiled. This class is
 * mostly used to make constructing a list view easier.
 */

public class Behavior{

    public boolean checked;

    public enum Positivity{

        NEGATIVE (-1, R.string.behavior_negative),
        NEUTRAL (0, R.string.behavior_neutral),
        POSITIVE (1, R.string.behavior_positive);

        public final int value;
        private int nameLoc;


        Positivity(int value, int nameLoc) {
            this.value = value;
            this.nameLoc = nameLoc;
        }

        public String toStringfromContext(Context context) {
            return context.getString(nameLoc);
        }

        public static Positivity toPos(int i){
            switch (i){
                case -1: return NEGATIVE;
                case 1: return POSITIVE;
                default: return NEUTRAL;
            }
        }
    }

    public final int behaviorID;
    public String behaviorName;
    public final Positivity behaviorPositivity;
    public final Context context;

    public Behavior(int behaviorID, String behaviorName, Positivity behaviorPositivity, Context context) {
        this.behaviorID = behaviorID;
        this.behaviorName = behaviorName;
        this.behaviorPositivity = behaviorPositivity;
        this.context = context;
        this.checked = false;
    }

    @Override
    public String toString() {
        return this.behaviorName;
    }

    public int getColor() {
        switch (this.behaviorPositivity){
            case NEGATIVE:
                return ContextCompat.getColor(context, R.color.colorBehaviorNegetive);
            case NEUTRAL:
                return ContextCompat.getColor(context, R.color.colorBehaviorNeutral);
            case POSITIVE:
                return ContextCompat.getColor(context, R.color.colorBehaviorPositive);
            default:
                return Color.WHITE;
        }
    }
}