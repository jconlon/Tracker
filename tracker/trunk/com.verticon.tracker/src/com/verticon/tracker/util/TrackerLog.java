package com.verticon.tracker.util;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.verticon.tracker.TrackerPlugin;

/**
 * The logger of convenience for the Favorites plug-in.
 * @deprecated
 */
public class TrackerLog {
   /**
    * Log the specified information.
    * 
    * @param message, a human-readable message, localized to the
    *           current locale.
    * @deprecated
    */
   public static void logInfo(String message) {
      log(IStatus.INFO, IStatus.OK, message, null);
   }

   /**
    * Log the specified error.
    * 
    * @param exception, a low-level exception.
    * @deprecated
    */
   public static void logError(Throwable exception) {
      logError("Unexpected Exception", exception);
   }

   /**
    * Log the specified error.
    * 
    * @param message, a human-readable message, localized to the
    *           current locale.
    * @param exception, a low-level exception, or <code>null</code>
    *           if not applicable.
    *           @deprecated
    */
   public static void logError(String message, Throwable exception) {
      log(IStatus.ERROR, IStatus.OK, message, exception);
   }

   /**
    * Log the specified information.
    * 
    * @param severity, the severity; one of the following:
    *           <code>IStatus.OK</code>,
    *           <code>IStatus.ERROR</code>,
    *           <code>IStatus.INFO</code>, or
    *           <code>IStatus.WARNING</code>.
    * @param pluginId. the unique identifier of the relevant
    *           plug-in.
    * @param code, the plug-in-specific status code, or
    *           <code>OK</code>.
    * @param message, a human-readable message, localized to the
    *           current locale.
    * @param exception, a low-level exception, or <code>null</code>
    *           if not applicable.
    * @deprecated
    */
   public static void log(int severity, int code, String message,
         Throwable exception) {

      log(createStatus(severity, code, message, exception));
   }

   /**
    * Create a status object representing the specified information.
    * 
    * @param severity, the severity; one of the following:
    *           <code>IStatus.OK</code>,
    *           <code>IStatus.ERROR</code>,
    *           <code>IStatus.INFO</code>, or
    *           <code>IStatus.WARNING</code>.
    * @param pluginId, the unique identifier of the relevant
    *           plug-in.
    * @param code, the plug-in-specific status code, or
    *           <code>OK</code>.
    * @param message, a human-readable message, localized to the
    *           current locale.
    * @param exception, a low-level exception, or <code>null</code>
    *           if not applicable.
    * @return, the status object (not <code>null</code>).
    * @deprecated
    */
   public static IStatus createStatus(int severity, int code,
         String message, Throwable exception) {

      return new Status(severity, TrackerPlugin.ID, code,
            message, exception);
   }

   /**
    * Log the given status.
    * 
    * @param status, the status to log.
    * @deprecated
    */
   public static void log(IStatus status) {
	   TrackerPlugin.getDefault().getLog().log(status);
   }
}