package com.duoduolicai360.goodtv.http.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by swg on 2017/9/18.
 */

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson mGson;
    private final TypeAdapter<T> mAdapter;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter){
        this.mGson = gson;
        this.mAdapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader = mGson.newJsonReader(value.charStream());
        try {
            return mAdapter.read(jsonReader);
        } finally {
            value.close();
        }
    }

}
