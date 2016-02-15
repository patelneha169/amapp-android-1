package org.anoopam.ext.smart.framework;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 *
 * @author tasol
 */
public abstract class  SmartSuperMaster extends SmartActivity implements SharedPreferenceConstants {

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

//    private GoogleCloudMessaging gcm;
//    protected LocationListener locationListener;
//    protected Location mLastLocation;

    /**
     * Constructor
     */
    public SmartSuperMaster() {
    }


//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        if (mGoogleApiClient!=null && mGoogleApiClient.isConnected()) {
//            mGoogleApiClient.disconnect();
//        }
//    }
//
//
//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        if (SmartApplication.REF_SMART_APPLICATION.IS_HTTP_ALLOW_ACCESS) {
//        }
//
////        enableGCM();
//    }
//
//    @Override
//    public void onConnected(Bundle bundle) {
//
//
//        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//        if (locationListener != null) {
//            locationListener.onReceived(mLastLocation);
//            if (mGoogleApiClient.isConnected()) {
//                mGoogleApiClient.disconnect();
//            }
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//
//    }


    /**
     * This method used to enable GCM.
     */
   /* public void enableGCM() {

        try {
            if (checkPlayServices()) {
                gcm = GoogleCloudMessaging.getInstance(this);
                String regid = getRegistrationId();

                if (regid.isEmpty()) {
                    registerInBackground();
                }
            } else {
                Log.i("GCM", "No valid Google Play Services APK found.");
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }*/

    /*private String getRegistrationId() {

        String registrationId = SmartApplication.REF_SMART_APPLICATION.readSharedPreferences().getString(SP_GCM_REGID, "");
        if (registrationId.isEmpty()) {
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = SmartApplication.REF_SMART_APPLICATION.readSharedPreferences().getInt(SP_GCM_REGID, Integer.MIN_VALUE);
        int currentVersion = getAppVersion();
        if (registeredVersion != currentVersion) {
            return "";
        }
        return registrationId;
    }*/

   /* private int getAppVersion() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
*/
   /* private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                if (!SmartApplication.REF_SMART_APPLICATION.readSharedPreferences().getBoolean(SP_GCM_ERROR_DIALOG, false)) {
                    GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
                    SmartApplication.REF_SMART_APPLICATION.writeSharedPreferences(SP_GCM_ERROR_DIALOG, true);
                }
            } else {
                Log.i("GCM", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }*/

   /* private void registerInBackground() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(SmartSuperMaster.this);
                    }
                    String regid = gcm.register(SmartApplication.REF_SMART_APPLICATION.GCM_ID);

                    storeRegistrationId(regid);
                } catch (Exception ex) {

                }
                return null;
            }
        }.execute();
    }*/

   /* private void storeRegistrationId(String regId) {
        int appVersion = getAppVersion();
        SmartApplication.REF_SMART_APPLICATION.writeSharedPreferences(SP_GCM_REGID, regId);
        SmartApplication.REF_SMART_APPLICATION.writeSharedPreferences(SP_GCM_APP_VERSION, appVersion);

    }*/

    /**
     * This method used to add fragment to given layout id.
     *
     * @param layoutId represented layout id
     * @param fragment represented fragment
     */
    public void addFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(layoutId, fragment);
        ft.commit();
    }


}