package com.android.weatherforecastdemo.usecases

interface BaseUseCase {

    interface NoParamUseCase<Result> {
        suspend fun getAction(): Result?
    }

    interface ParamUseCase<Params, Result> {
        suspend fun getAction(params: Params): Result?
    }
}