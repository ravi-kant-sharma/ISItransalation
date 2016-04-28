package utill;

/**
 * Created by ttnd on 28/4/16.
 */
public class ISITransConstants {
    /** API URL CONSTANTS**/
    public final static String API_CONNECTION_URL = "/api/connect";
    public final static String API_DISCONNECT_URL = "/api/disconnect";
    public final static String API_GENERIC_URL = "/api/files/file";
    public final static String API_CLEAR_SANDBOX_URL = "/api/files/directory";
    public final static String API_PROJECT_DETAILS = "/api/details";
    public final static String API_OP_ID_URL = "/api/files/operations/sandbox/count";
    public final static String API_TRANSLATION_STATUS_URL = "/api/workprogress/translatedfiles";
    public final static String API_QUOTATION_PRICE_STATUS = "/api/async/operation/status";

    /** JSON CONSTANTS **/
    public final static String SERVER_URL = "serverUrl";
    public final static String PROJECT_KEY = "projectKey";
    public final static String USERNAME = "userName";
    public final static String PASSWORD = "password";
    public final static String WAIT_IN_SECS = "waitsecs";
    public final static String CONNECTOR = "connector";
    public final static String VERSION = "version";
    public final static String BEEBOX_LANGUAGE_CODE = "beeboxLanguageCode";
    public final static String AEM_LANGUAGE_CODE = "aemLanguage";
    public final static String BEEBOX_CONNECTOR_NAME = "AEM-Beebox";
    public final static String BEEBOX_CONNECTOR_VERSION = "1.00";

    //    Configuration Path
    public final static String CONNECTION_CONFIGURATION_PATH = "/etc/beebox-configuration/beeboxConfig";
    public final static String JOBS_CONFIGURATION_PATH = "/etc/beebox-configuration/beebox-job-description/";
    public final static String COMPLETED_JOB_PATH = "/etc/beebox-configuration/beebox-completed-jobs/";
    public final static String LANGUAGE_CONFIGURATION = "/etc/beebox-configuration/beeboxLanguageMapping/";
    public final static String SKIP_NODE = "cq:LiveSyncConfig";
    public final static String BEEBOX_PREFIX = "beebox_";

    /**Job Properties**/
    public final static String JOB_STATUS_VARIABLE = "${BEEBOX_PREFIX}jobStatus";
    public final static String JOB_STATUS_QUOTATION = "in_quotation";
    public final static String JOB_STATUS_QUOTATION_RECEIVED = "received_quotation";
    public final static String JOB_STATUS_TRANSLATION = "in_translation";
    public final static String JOB_OPERATION_ID_VARIABLE = "operationId";
    public final static String JOB_NODE_TYPE = "beebox-job-container";
    public final static String JOB_WORD_COUNT = "beebox-job-wordcount";
    public final static String JOB_COSTED = "beebox-job-costed";
    public final static String JOB_COST = "beebox-job-cost";
    public final static String JOB_SOURCE_LANGUAGE = "beebox-sourceLanguage";
    public final static String JOB_TARGET_LANGUAGE = "beebox-targetLanguage";

    /*Translation Status Properties*/
    public final static String TRANSLATION_PROP_NAME = "${BEEBOX_PREFIX}translationStatus";
    public final static String OUTDATED = "outdated";
    public final static String TRANSLATED = "translated";
    public final static String NOT_TRANSLATED = "not_translated";
    public final static String TRANSLATED_FROM = "${BEEBOX_PREFIX}translatedFrom";
    public final static String TRANSLATED_TO = "${BEEBOX_PREFIX}translatedTo";
    public final static String LAST_TRANSLATED_DATE = "${BEEBOX_PREFIX}lastTranslationDate";
    public final static String TRANSLATION_START_DATE = "${BEEBOX_PREFIX}translationStartDate";

    /**
     * Beebox Request types
     */
    public final static String REQUEST_TYPE_TRANSLATION = "translation";
    public final static String REQUEST_TYPE_QUOTATION = "quotation";
    public final static String TRANSLATION_LEVEL_FIRST = "immediate";


    /*Beebox Response Constants*/
    public final static String READY_TO_DOWNLOAD = "uptodate";
    public final static String DEFAULT_PAGES_FORMAT = "xml";

    /**
     * Beebox DAM assets constants
     */
    public final static String DAM_ASSETS_JCR_PATH = "/jcr:content/renditions/original/jcr:content";

}
