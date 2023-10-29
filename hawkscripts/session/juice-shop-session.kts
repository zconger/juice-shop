import net.sf.json.JSONObject
import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import org.openqa.selenium.devtools.v85.network.model.CookieParam
import org.parosproxy.paros.network.HtmlParameter
import org.zaproxy.zap.session.ScriptBasedSessionManagementMethodType
import kotlin.math.log

val logger: Logger = LogManager.getLogger("Juice Shop Session")


// This function is called after the authentication function to establish a session.
// The sessionWrapper.httpMessage will contain the responseBody, responseHeader and requestingUser which can be used to
// gather data pertaining to the authentication status such as cookies, tokens or data from the responseBody
fun extractWebSession(sessionWrapper: ScriptBasedSessionManagementMethodType.SessionWrapper) {
    logger.info("Creating JSON object from authN response.")
    val authResponseObject = JSONObject.fromObject(sessionWrapper.httpMessage.responseBody.toString())
    logger.info("Extracting authZ session token from authN response.")
    val token = authResponseObject.getJSONObject("authentication").getString("token")
    logger.info("Extracted authZ session token from authN response:\ntoken = $token")

    sessionWrapper.session.setValue("token", token)
}

// This function is called on each request allow the request to be modified before it is sent to the web application.
fun processMessageToMatchSession(sessionWrapper: ScriptBasedSessionManagementMethodType.SessionWrapper) {
    val token = sessionWrapper.session.getValue("token").toString()
    logger.debug("Got authZ token from session wrapper:\ntoken = $token")

    logger.debug("Adding authZ token to an Authorization request header.")
    sessionWrapper.httpMessage.requestHeader.addHeader("Authorization", "Bearer $token")

    logger.debug("Adding authZ token to a cookie named \"token\".")
    val cookie = HtmlParameter(HtmlParameter.Type.cookie, "token", token)
    val cookies = sessionWrapper.httpMessage.requestHeader.cookieParams
    cookies.add(cookie)
    sessionWrapper.httpMessage.cookieParams = cookies
}

// Called internally when a new session is required
fun clearWebSessionIdentifiers(sessionWrapper: ScriptBasedSessionManagementMethodType.SessionWrapper) {
}

// The required parameter names for your script, your script will throw an error if these are not supplied in the sessionScript.parameters configuration.
fun getRequiredParamsNames(): Array<String> {
    return arrayOf()
}

fun getOptionalParamsNames(): Array<String> {
    return arrayOf()
}