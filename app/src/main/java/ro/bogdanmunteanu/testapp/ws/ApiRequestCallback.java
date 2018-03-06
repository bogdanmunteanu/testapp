package ro.bogdanmunteanu.testapp.ws;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bogdan on 3/6/2018.
 */

public class ApiRequestCallback<T> implements Callback<T> {

    private ApiManager.Callback<T> callback;
    private boolean nullAnswer = false; //setting this to false because we know that the server is responding with a valid answer

    public ApiRequestCallback(ApiManager.Callback<T> callback)
    {
        this.callback = callback;
    }
    /**
     * @param callback   callback with the server response
     * @param nullAnswer boolean to allow null response from server
     */
    public ApiRequestCallback(ApiManager.Callback<T> callback, boolean nullAnswer) {
        this.callback = callback;
        this.nullAnswer = nullAnswer;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (callback != null) {
            switch (response.code()) {
                case 200:
                case 202:
                case 204:
                    callback.onSuccess(response.body());
                    break;

                case 401:
                    callback.onFailure(String.valueOf(response.code()));
                    break;

                case 500:
                    callback.onFailure(String.valueOf(response.code()));
                    break;

                default:
                    try {
                        if (response.errorBody() != null) {
                            callback.onFailure(String.format("Code: %s. Body: %s", response.code(), response.errorBody().string()));
                        }
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    callback.onFailure(String.valueOf(response.code()));
                    break;
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if(callback!=null)
        {
            callback.onFailure(t.getLocalizedMessage());
        }
    }
}
