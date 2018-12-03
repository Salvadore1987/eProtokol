package uz.protokol.asbt.eprotokol.builders;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uz.protokol.asbt.eprotokol.commons.Constants;
import uz.protokol.asbt.eprotokol.parsers.JsonDateDeserialization;
import uz.protokol.asbt.eprotokol.utils.PropUtil;

public class RetfrofitBuilder {

    private RetfrofitBuilder() {
    }

    public static Retrofit build(Context context) throws IOException, NullPointerException {
        String BASE_URL = PropUtil.getProperty(Constants.API_SERVICE_PROP, context);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new JsonDateDeserialization())
                .create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
