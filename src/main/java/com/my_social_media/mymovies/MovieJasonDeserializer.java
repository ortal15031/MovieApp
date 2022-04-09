package com.my_social_media.mymovies;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.my_social_media.mymovies.Model.Movie;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MovieJasonDeserializer implements JsonDeserializer {


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ArrayList<Movie> mData = null;

        try {
            // root element
            JsonObject obj = json.getAsJsonObject();
            JsonArray movieJson = obj.getAsJsonArray("results");
            mData = new ArrayList<>(5);
            for (int i = 0; i < movieJson.size(); i++) {

            JsonObject item= movieJson.get(i).getAsJsonObject();
            String title= String.valueOf(item.get("title"));

            if(title.toLowerCase().contains("dune")||title.toLowerCase().contains("the addams family 2")
            ||title.toLowerCase().contains("the boss baby: family business")||title.toLowerCase().contains("after we fell")
            ||title.toLowerCase().contains("free guy")){

            Movie newItem = context.deserialize(item, Movie.class);
            mData.add(newItem);
            }
            }

           } catch (JsonParseException e) {
            e.printStackTrace();
        //    throw new Error("Copying Failed");
        }
           return mData;
        }
        }
