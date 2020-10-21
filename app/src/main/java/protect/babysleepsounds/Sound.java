package protect.babysleepsounds;

import android.content.Context;

import androidx.annotation.DrawableRes;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;

import com.google.common.collect.ImmutableList;

public class Sound {

    public static ImmutableList<Sound> allSounds;

    private final String label;
    private final @RawRes int mp3Resource;
    private final @DrawableRes int imageResource;

    private Sound(Context context, @StringRes int label, @RawRes int mp3Resource, @DrawableRes int image) {
        this.label = context.getResources().getString(label);
        this.mp3Resource = mp3Resource;
        this.imageResource = image;
    }

    public String getLabel() {
        return label;
    }

    public @RawRes int getMp3Resource() {
        return mp3Resource;
    }

    public @DrawableRes int getImageResource() {
        return imageResource;
    }

    public static ImmutableList<Sound> getAllSounds(Context context) {
        if (allSounds == null) {

            // These sound files by convention are:
            // - take a ~10 second clip
            // - Apply a 2 second fade-in and fade-out
            // - Cut the first 3 seconds, and place it over the last three seconds
            //   which should create a seamless track appropriate for looping
            // - Save as a mp3 file, 128kbps, stereo
            allSounds = ImmutableList.<Sound>builder()
                    .add(new Sound(context, R.string.campfire, R.raw.campfire, R.drawable.campfire))
                    .add(new Sound(context, R.string.dryer, R.raw.dryer, R.drawable.dryer))
                    
                    .add(new Sound(context, R.string.ocean, R.raw.ocean, R.drawable.ocean))
                    .add(new Sound(context, R.string.rain, R.raw.rain, R.drawable.rain))
                    .add(new Sound(context, R.string.refrigerator, R.raw.refrigerator, R.drawable.vacuum))
                    .add(new Sound(context, R.string.shhhh, R.raw.shhhh, R.drawable.vacuum))
                    .add(new Sound(context, R.string.shower, R.raw.shower, R.drawable.vacuum))
                    .add(new Sound(context, R.string.stream, R.raw.stream, R.drawable.vacuum))
                    .add(new Sound(context, R.string.vacuum, R.raw.vacuum, R.drawable.vacuum))
                    .add(new Sound(context, R.string.water, R.raw.water, R.drawable.vacuum))
                    .add(new Sound(context, R.string.waterfall, R.raw.waterfall, R.drawable.vacuum))
                    .add(new Sound(context, R.string.waves, R.raw.waves, R.drawable.vacuum))
                    .add(new Sound(context, R.string.whiteNoise, R.raw.white_noise, R.drawable.vacuum))
                    .build();
        }

        return allSounds;
    }
}
