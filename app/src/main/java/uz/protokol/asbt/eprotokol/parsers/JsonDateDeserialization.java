package uz.protokol.asbt.eprotokol.parsers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class JsonDateDeserialization implements JsonDeserializer<Date> {

    private final String TAG = JsonDateDeserialization.class.getSimpleName();

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String date = json.getAsString();

        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);

        try {
            return format.parse(date);
        } catch (ParseException exp) {
            Log.e(TAG, "Failed to parse Date: " + exp);
            return null;
        }
    }
}
