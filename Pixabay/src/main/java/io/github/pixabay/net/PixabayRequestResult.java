package io.github.pixabay.net;

import org.json.JSONObject;

@Deprecated
public interface PixabayRequestResult {
    void response(JSONObject response);
}
