package database.google.com.firebaseimage1;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by ray on 10/12/2017.
 */

public class firstclass {

    String desc,title,timestamp;


public  firstclass(){


}

    public firstclass(String desc, String title, String timestamp, ImageView img) {
        this.desc = desc;
        this.title = title;
        this.timestamp = timestamp;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
