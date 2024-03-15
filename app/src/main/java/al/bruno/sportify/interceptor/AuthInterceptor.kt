package al.bruno.sportify.interceptor



//class AuthInterceptor : Interceptor {
//    var token: String? = null
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val builder = chain.request().newBuilder()
//        token?.let { builder.addHeader("Authorization", it) }
//        return chain.proceed(builder.build())
//    }
//}