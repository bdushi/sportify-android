package al.bruno.sportify.data.source.entity

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * SateFlow Generic Response Class which
 * Represents different states for the screens
 */
sealed class State<out T> {
    data object Loading : State<Nothing>()
    data class Success<out T>(val t: T?): State<T>()
    data class Error(val error: String?): State<Nothing>()
}

/**
 *
 */
fun <T> Flow<T>.asResult(): Flow<State<T>> {
    return map<T, State<T>> {
        State.Success(it)
    }.onStart {
        emit(State.Loading)
    }.catch {
        emit(State.Error(it.message))
    }
}