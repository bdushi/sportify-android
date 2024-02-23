package al.bruno.sportify.interceptor

import okhttp3.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor() : Interceptor {
    private lateinit var session: Session
    override fun intercept(chain: Interceptor.Chain): Response {
        val mainResponse = chain.proceed(chain.request())
        if (!chain.request().url.encodedPath.contains("security/authenticate") &&
            !chain.request().url.encodedPath.contains("security/checkTokenStatus") &&
            mainResponse.code == 401) {
            session.invalidate()
        }
        return mainResponse
    }

    fun setSession(session: Session) {
        this.session = session
    }
}