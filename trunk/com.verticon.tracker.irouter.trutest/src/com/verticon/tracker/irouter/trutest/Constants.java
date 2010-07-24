package com.verticon.tracker.irouter.trutest;

import static com.verticon.tracker.irouter.common.TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.ANIMAL_WEIGHT_MEASUREMENT_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.COMMAND_STRING_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRANSACTION_STATE_SCOPE;

/**
 * Set of commands used by the TruTest component.
 * @author jconlon
 *
 */
public class Constants {

	private Constants() {
	}// prevents instantiation

    static final String BEEP_COMMAND = "{SABP50}\r";
    static final String POLL_COMMAND = "{RP}\r";
	static final String SET_RP_POLL_COMMAND_ID = "{SPRP2}\r";
	static final String TURN_ON_CRLF = "{ZC1}\r";

	static final String TURN_OFF_ACK = "{ZA0}\r";
	static final String TURN_ON_ACK = "{ZA1}\r";

	static final String TURN_ON_ERROR_CODES = "{ZE1}\r";

	static final String CLEAR_FILE = "{FC1}\r";

	static final String GET_NEXT_RECORD = "{FN}\r";

	static final String RESET_TO_FIRST_RECORD = "{FD}\r";

	static final String SELECT_LIFE_DATA_PAGE = "{FGLD}\r";
	
	static final int ANIMAL_WEIGHT = 0;
	static final int RECORD_STATE = 1;
	static final int EID = 2;
	static final String[] PRODUCER_SCOPE = { ANIMAL_WEIGHT_MEASUREMENT_SCOPE,
	   TRANSACTION_STATE_SCOPE, ANIMAL_TAG_NUMBER_SCOPE };
	
    static final String[] CONSUMER_SCOPE = { "trutest."+COMMAND_STRING_SCOPE };
	static final Long RETRY_CONNECTION_DELAY_DEFAULT = new Long(5);
	static final String RESPONSE_PATTERN_DEFAULT = "^\\[(.+)\\]$";
	static final Double UNSTABLE_WEIGHT_ERROR_DEFAULT = new Double(.1);
	static final Double STABLE_WEIGHT_ERROR_DEFAULT = new Double(.01);
	static final String REQUEST_COMMAND_DEFAULT = "{RP}%13%";
	static final String FILE_HEADER_COMMAND_DEFAULT = "{FIF1,F2,F3,F4}%13%";
	static final String FILE_HEADER_COMMAND = "fileheader.command";
    static final String DOWNLOAD_RECORD_PATTERN_DEFAULT = "^\\[\\d,(.+)\\]$";
    static final String DOWNLOAD_RECORD_PATTERN = "download.record.pattern";
    static final String UPLOAD_RECORD_PATTERN ="upload.record.pattern";
    static final String UPLOAD_RECORD_PATTERN_DEFAULT = 
    	"^[0-9]{15,15},[0-9]{4,4},\\d.\\d\\d,[1-2]$";

	static final Long POLL_DELAY_DEFAULT = new Long(200);
	static final Integer CONSUME_COMMAND_DELAY_DEFAULT = new Integer(100);
    static final String CONSUME_COMMAND_DELAY = "consumer.command.delay";
    static final String SEND_UNSTABLE_WEIGHTS = "send.unstable.weights";
    static final Boolean SEND_UNSTABLE_WEIGHTS_DEFAULT = Boolean.TRUE;
    static final String DATA_SYNC_DIRECTORY = "data.synchronization.directory";
    static final String DATA_SYNC_DIRECTORY_DEFAULT = "/mnt/USB";
    
}
