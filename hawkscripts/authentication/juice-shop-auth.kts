import org.apache.commons.httpclient.URI
import org.apache.log4j.LogManager
import org.parosproxy.paros.network.HttpHeader
import org.parosproxy.paros.network.HttpMessage
import org.parosproxy.paros.network.HttpRequestHeader
import org.zaproxy.zap.authentication.AuthenticationHelper
import org.zaproxy.zap.authentication.GenericAuthenticationCredentials
import com.stackhawk.hawk.Utils
import org.zaproxy.zap.network.HttpRequestBody

val logger = LogManager.getLogger("Juice Shop Auth")
logger.info("Juice Shop authentication script starting.")

// This function is called before a scan is started and when the loggedOutIndicator is matched indicating re-authentication is needed.
fun authenticate(
        helper: AuthenticationHelper,
        paramsValues: Map<String, String>,
        credentials: GenericAuthenticationCredentials
): HttpMessage {

    val authEndpoint = "http://localhost:3000/rest/user/login"
    val username = "test@test.com"
    val password = "testtest"
    val authRequestBody = "{\"email\":\"${username}\",\"password\":\"${password}\"}"

    logger.info("Authentication URL: ${authEndpoint}")

    val msg = helper.prepareMessage()
    msg.requestHeader = HttpRequestHeader(
            HttpRequestHeader.POST,
            URI(authEndpoint, true),
            HttpHeader.HTTP11
    )
    msg.requestHeader.setHeader("Content-Type", "application/json")
    msg.requestHeader.setHeader("Accept", "*/*")
    msg.requestHeader.setHeader("Cache-control", "no-cache")
    msg.requestBody = HttpRequestBody(authRequestBody)
    msg.requestHeader.contentLength = msg.requestBody.length()

    helper.sendAndReceive(msg)
    logger.info("Auth Request:\n=== REQUEST HEADERS ===\n${msg.requestHeader}\n=== REQUEST BODY ===\n${msg.requestBody}\n")
    logger.info("Auth Response:\n=== RESPONSE HEADERS ===\n${msg.responseHeader}\n=== RESPONSE BODY ===\n${msg.responseBody}\n")
    return msg
}

// The required parameter names for your script, your script will throw an error if these are not supplied in the script.parameters configuration.
fun getRequiredParamsNames(): Array<String> {
    return arrayOf()
}

// The required credential parameters, your script will throw an error if these are not supplied in the script.credentials configuration.
fun getCredentialsParamsNames(): Array<String> {
    return arrayOf()
}

fun getOptionalParamsNames(): Array<String> {
    return arrayOf()
}