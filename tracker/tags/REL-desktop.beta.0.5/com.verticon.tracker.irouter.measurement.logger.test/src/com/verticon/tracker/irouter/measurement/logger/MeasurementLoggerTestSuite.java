package com.verticon.tracker.irouter.measurement.logger;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
  AggregatingTransactionLoggerTest.class,
  NormalizingTransactionLoggerTest.class,
})
public class MeasurementLoggerTestSuite {
    // the class remains completely empty, 
    // being used only as a holder for the above annotations
}
