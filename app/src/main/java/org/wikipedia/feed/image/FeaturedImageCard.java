package org.wikipedia.feed.image;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.wikipedia.R;
import org.wikipedia.WikipediaApp;
import org.wikipedia.dataclient.WikiSite;
import org.wikipedia.feed.model.Card;
import org.wikipedia.feed.model.CardType;
import org.wikipedia.feed.model.UtcDate;
import org.wikipedia.util.DateUtil;

public class FeaturedImageCard extends Card {
    @NonNull private UtcDate date;
    @NonNull private WikiSite wiki;
    @NonNull private FeaturedImage featuredImage;

    public FeaturedImageCard(@NonNull FeaturedImage featuredImage, @NonNull UtcDate date, @NonNull WikiSite wiki) {
        this.featuredImage = featuredImage;
        this.wiki = wiki;
        this.date = date;
    }

    @NonNull
    public FeaturedImage baseImage() {
        return featuredImage;
    }

    @NonNull
    public UtcDate date() {
        return date;
    }

    @Override
    @NonNull
    public String title() {
        return WikipediaApp.getInstance().getString(R.string.view_featured_image_card_title);
    }

    @Override
    @NonNull
    public String subtitle() {
        return DateUtil.getFeedCardDateString(date.baseCalendar());
    }

    @NonNull
    public WikiSite wikiSite() {
        return wiki;
    }

    @NonNull
    public String filename() {
        return featuredImage.title();
    }

    @Override
    @NonNull
    public Uri image() {
        return featuredImage.thumbnail().source();
    }

    @NonNull @Override public CardType type() {
        return CardType.FEATURED_IMAGE;
    }

    @Nullable
    public String description() {
        return featuredImage.description();
    }

    @Override
    protected int dismissHashCode() {
        return featuredImage.title().hashCode();
    }
}
