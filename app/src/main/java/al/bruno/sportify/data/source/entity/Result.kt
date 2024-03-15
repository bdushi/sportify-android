package al.bruno.sportify.data.source.entity

import kotlinx.coroutines.flow.*

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String?) : Result<Nothing>()
    data object Loading : State<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
        }
    }
}

//suspend fun <T> Response<T>.asResponse(): Flow<Result<T>> = flow {
//    val body = this@asResponse.body()
//    if(this@asResponse.isSuccessful && body != null) {
//        emit(Result.Success<T>(body))
//    } else {
//        emit(Result.Error(this@asResponse.message()))
//    }
//}.catch {
//    emit(Result.Error(it.message))
//}

suspend fun <T>T.asResponse(): Flow<Result<T>> = flow {
    if(this@asResponse != null) {
        emit(Result.Success<T>(this@asResponse))
    } else {
        emit(Result.Error("Error"))
    }
}.catch {
    emit(Result.Error(it.message))
}