package uz.protokol.asbt.eprotokol.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

    public static String getProperty(String key, Context context) throws IOException, NullPointerException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream is = assetManager.open("application.properties");
        properties.load(is);
        return properties.getProperty(key);
    }

}
