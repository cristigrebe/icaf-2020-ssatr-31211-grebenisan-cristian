package com.tema1.tema1;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonFileProcessing {
    public static Simulator readJsonFileForModelingPN(String jsonFile) throws Exception{
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFile)));
        JSONObject jsonObject = new JSONObject(jsonContent);

        List<Location> locations = new ArrayList<>();
        List<Transition> transitions = new ArrayList<>();

        //get the locations array from jsonObject
        JSONArray jsonLocations = jsonObject.getJSONArray("locations");

        //get the transitions array from jsonObject
        JSONArray jsonTransitions = jsonObject.getJSONArray("transitions");

//      for locations
        for(int i=0; i<jsonLocations.length(); i++){
            //for every iteration a have to get the id,token from jsonLocation; create a new location object with them and
            //add to locations array
            int id = jsonLocations.getJSONObject(i).getJSONObject("location").getInt("id");
            int token = jsonLocations.getJSONObject(i).getJSONObject("location").getInt("token");
            locations.add(new Location(id, token));
        }

//       for transitions
        for(int i=0; i< jsonTransitions.length(); i++){
            // for every iteration a have to get the id,input,output,tmin,tmax from jsonTransition;
            // create a new transition
            // object with them and add to transitions array
            int id = jsonTransitions.getJSONObject(i).getJSONObject("transition").getInt("id");

            //  get jsonArrayInput from jsonTransitions and convert to int array
            JSONArray jsonArrayInput = jsonTransitions.getJSONObject(i).getJSONObject("transition").getJSONArray("input");
            int[] input = getArrayFromJsonArray(jsonArrayInput);

            // get jsonArrayOutput from jsonTransitions and convert to int array
            JSONArray jsonArrayOutput = jsonTransitions.getJSONObject(i).getJSONObject("transition").getJSONArray("output");
            int[] output = getArrayFromJsonArray(jsonArrayOutput);

            // get tmin and tmax
            int tmin = jsonTransitions.getJSONObject(i).getJSONObject("transition").getInt("tmin");
            int tmax = jsonTransitions.getJSONObject(i).getJSONObject("transition").getInt("tmax");
            transitions.add(new Transition(id, tmin, tmax, input, output));
        }

        Simulator simulator = new Simulator(locations, transitions);
        return simulator;
    }

    private static int[] getArrayFromJsonArray(JSONArray jsonArray) {
        int[] array = new int[jsonArray.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = jsonArray.getInt(i);
        }
        return array;
    }
}
