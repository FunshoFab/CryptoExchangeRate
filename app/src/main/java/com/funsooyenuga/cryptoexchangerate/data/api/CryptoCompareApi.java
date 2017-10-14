package com.funsooyenuga.cryptoexchangerate.data.api;

import com.funsooyenuga.cryptoexchangerate.data.ApiResponse;
import com.funsooyenuga.cryptoexchangerate.util.ApiUtils;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FAB THE GREAT on 13/10/2017.
 */

public interface CryptoCompareApi {

    @GET(ApiUtils.PATH_MULTI_FULL)
    Observable<ApiResponse> getExchangeRate(@Query(ApiUtils.QUERY_FROM_SYMBOLS) String fromSymbols,
                                            @Query(ApiUtils.QUERY_TO_SYMBOLS) String toSymbols);
}
