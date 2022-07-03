package com.samsung.android.feature;

import java.util.Hashtable;

public class SemCscFeature {

    private static SemCscFeature sInstance = null;

    private Hashtable<String, String> mFeatureList = new Hashtable<>();

    {
        this.mFeatureList.put("CscFeature_Calendar_EnableLocalHolidayDisplay", "HKTW");
        this.mFeatureList.put("CscFeature_Calendar_EnableLunar", "TRUE");
        this.mFeatureList.put("CscFeature_Calendar_SetColorOfDays", "XXXXXBR");
        this.mFeatureList.put("CscFeature_Camera_CameraFlicker", "50hz");
        this.mFeatureList.put("CscFeature_Camera_EnableCameraDuringCall", "TRUE");
        this.mFeatureList.put("CscFeature_Clock_ReplaceNameTaiwanWithTaipei", "TRUE");
        this.mFeatureList.put("CscFeature_Common_ConfigAllowedPackagesDuringDataSaving", "com.samsung.android.smartcallprovider");
        this.mFeatureList.put("CscFeature_Common_ConfigMarketInfoVariation", "Disable");
        this.mFeatureList.put("CscFeature_Common_ConfigSamsungCloudVariation", "DisablingKeyboardDataSync:boolean:true");
        this.mFeatureList.put("CscFeature_Common_ConfigSvcProviderForUnknownNumber", "whitepages,whitepages,whitepages");
        this.mFeatureList.put("CscFeature_Common_SupportDynamicNetBandwidthAllocation", "TRUE");
        this.mFeatureList.put("CscFeature_Common_SupportGmsAlarmManager", "TRUE");
        this.mFeatureList.put("CscFeature_Contact_ANRConfig", "0");
        this.mFeatureList.put("CscFeature_Contact_AddPreloadedSpeedDialAs", "None,0,None,None");
        this.mFeatureList.put("CscFeature_Contact_CheckSimAlphaLength4UnicodeName", "TRUE");
        this.mFeatureList.put("CscFeature_Contact_ConfigDialerFont", "FixedKeypadLetter");
        this.mFeatureList.put("CscFeature_Contact_ConfigImsOpStyle", "TGY");
        this.mFeatureList.put("CscFeature_Contact_ConfigOpStyleVariation", "TGY");
        this.mFeatureList.put("CscFeature_Contact_DisableMenuNameOrder", "TRUE");
        this.mFeatureList.put("CscFeature_Contact_EnableBPMFSortList", "TRUE");
        this.mFeatureList.put("CscFeature_Contact_EnableStrokeSortList", "TRUE");
        this.mFeatureList.put("CscFeature_Contact_LimitNameLength", "250");
        this.mFeatureList.put("CscFeature_Contact_SupportDuoVideoCall", "TRUE");
        this.mFeatureList.put("CscFeature_Email_UseFixedSmtpPortAs", "25");
        this.mFeatureList.put("CscFeature_GMS_SetClientIDBaseMs", "android-samsung-gs-rev1");
        this.mFeatureList.put("CscFeature_GMS_SupportSTSTool", "FALSE");
        this.mFeatureList.put("CscFeature_NFC_ConfigDynamicFirmwareLoading", "TGY");
        this.mFeatureList.put("CscFeature_NFC_DefStatus", "ON");
        this.mFeatureList.put("CscFeature_NFC_StatusBarIconType", "DEFAULT");
        this.mFeatureList.put("CscFeature_NFC_SupportTechFListenMode", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_CallerIdMatchingDigit", "8");
        this.mFeatureList.put("CscFeature_RIL_ConfigApnForHideDataIcon", "ims,ent1,ent2");
        this.mFeatureList.put("CscFeature_RIL_GetDeviceIdwithIMEIforCDMA", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SupportEsim", "FALSE");
        this.mFeatureList.put("CscFeature_SPen_ConfigDefTranslatorSolution", "BaiduPref");
        this.mFeatureList.put("CscFeature_Security_DeleteCardApplet", "deactivate");
        this.mFeatureList.put("CscFeature_Setting_BlockToSelectDunApnType", "TRUE");
        this.mFeatureList.put("CscFeature_Setting_ConfigAboutDeviceItems", "modelnumberDSsuffix=disabled;");
        this.mFeatureList.put("CscFeature_Setting_ConfigListForDisablingTimeZoneItem", "Asia/Urumqi");
        this.mFeatureList.put("CscFeature_SyncML_ConfigDevicePreId", "IMEI");
        this.mFeatureList.put("CscFeature_SystemUI_ConfigDefQuickSettingItem", "Wifi,SoundMode,Bluetooth,RotationLock,AirplaneMode,Flashlight,MobileData,Hotspot,BatteryMode,Location,WindowsLink,ScreenRecorder,DesktopMode,AllShareCast,NearbyShare,BlueLightFilter,NightMode,Dnd,ScreenCapture");
        this.mFeatureList.put("CscFeature_SystemUI_ConfigMaxRssiLevel", "5");
        this.mFeatureList.put("CscFeature_SystemUI_ConfigOpBrandingForIndicatorIcon", "TGY");
        this.mFeatureList.put("CscFeature_SystemUI_ConfigQuickSettingPopup", "TGY");
        this.mFeatureList.put("CscFeature_SystemUI_ConfigRecentDefaultLockList", "com.tencent.mm");
        this.mFeatureList.put("CscFeature_VT_ConfigBearer", "-CSVT");
        this.mFeatureList.put("CscFeature_VT_ConfigCapability", "three_widget,modify_auto_accept");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleForHdIcon", "TGY_HD");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleForVolte", "VolteCtc,CTC_VOLTE,wait_for_volte_regi_in_airplane_mode_ctc");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleForWaitingTone", "TGY");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOptStyleForCallBarring", "RemoveCDMA");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigRingbackToneForVolte", "HK");
        this.mFeatureList.put("CscFeature_VoiceCall_DisableAlertToneSignal", "TRUE");
        this.mFeatureList.put("CscFeature_VoiceCall_SupportVolteHoldTone", "NOT");
        this.mFeatureList.put("CscFeature_Weather_ConfigCpType", "TWC");
        this.mFeatureList.put("CscFeature_Web_DisableChooser4", "audio/*,audio/mp3,audio/x-mp3,audio/mpeg,audio/mp4,audio/mp4a-latm,application/sdp,video/mpeg,video/3gp,video/3gpp,video/3gpp2,video/x-ms-asf,video/x-ms-wmv,video/x-ms-wma,video/webm,video/flv,video/mkv,video/divx,video/avi,video/skm,video/sktm,video/k3g,video/ak3g,video/x-msvideo,video/vnd.ms-playready.media.pyv,application/x-mpegurl,application/vnd.apple.mpegurl,audio/x-mpegurl,application/x-mpegurl,video/mp4");
        this.mFeatureList.put("CscFeature_Web_EnableAutoSimHomeUrlInProfile", "FALSE");
        this.mFeatureList.put("CscFeature_Wifi_ConfigSnsStatus", "DEFAULT_ON");
    
        
        this.mFeatureList.put("CscFeature_Message_DisableMenuSmsInputMode", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_ConfigGlobalModuleType", "LTE");
        this.mFeatureList.put("CscFeature_RIL_ConfigNetworkTypeCapability", "TGY-TGY-GLB-HKG");
        this.mFeatureList.put("CscFeature_RIL_DataPrefDataTechSnapShot", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_DisplayAntennaLimited", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_DisplayPlmnnameSimload", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_E911RoutingPolicy", "auto");
        this.mFeatureList.put("CscFeature_RIL_GcfSor", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_QmiCdmaGsm", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_ReferEonsWithoutLac", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_ReferSpnOnManualSearch", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_STKHandlingSendSMSbyAP", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SetNetworkTypeWhenRadioOff", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SignalstrengthPolicy", "1");
        this.mFeatureList.put("CscFeature_RIL_SmsCdmaCopyToRuim", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SmsSupportKsc5601Usa", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SpecialAddressHandlingFor", "CTC");
        this.mFeatureList.put("CscFeature_RIL_StkCallControlwithIMS", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SupportQcomCrossMapping", "FALSE");
        this.mFeatureList.put("CscFeature_RIL_SupportRegistrationLocationInfo", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_SupportVolte", "TRUE");
        this.mFeatureList.put("CscFeature_RIL_WapPushFormat4", "CTC");
        this.mFeatureList.put("CscFeature_Setting_CustNetworkSelMenu4", "NUMERIC");
        this.mFeatureList.put("CscFeature_Setting_DisableNetworkMode", "REMOVE_WCDMAONLY");
        this.mFeatureList.put("CscFeature_Setting_SupportWifiCall", "TRUE");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigNetworkList", "NetworkMode_HKTW");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleForEmergencyDialCall", "STATE_UPDATE_AFTER_DIAL");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleForMobileNetSetting", "voltesettingscommon,voltesettingHK,checknonvoltesim,support_hvolte_solution_ctc,support_volte_ctc_spec_2019");
        this.mFeatureList.put("CscFeature_VoiceCall_ConfigOpStyleMobileNetworkSettingMenu", "-cdmasystemselect, ,+datapreferduringcalling");

    }

    public Hashtable<String, String> tracer(int tableNumber) {
        return mFeatureList;
    }

    public static SemCscFeature getInstance() {
        if (sInstance == null) {
            sInstance = new SemCscFeature();
        }
        return sInstance;
    }

    public boolean getBoolean(String tag) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value == null) {
                return false;
            }
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getBoolean(String tag, boolean defaultValue) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value != null) {
                return Boolean.parseBoolean(value);
            }
            return defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public String getString(String tag) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value == null) {
                return "";
            }
            return value;
        } catch (Exception e) {
            return "";
        }
    }

    public String getString(String tag, String defaultValue) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value != null) {
                return value;
            }
            return defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public int getInteger(String tag) {
        return getInt(tag);
    }

    public int getInt(String tag) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value == null) {
                return -1;
            }
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -1;
        }
    }

    public int getInteger(String tag, int defaultValue) {
        return getInt(tag, defaultValue);
    }

    public int getInt(String tag, int defaultValue) {
        String value;
        try {
            value = this.mFeatureList.get(tag);
            if (value != null) {
                return Integer.parseInt(value);
            }
            return defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(int slotId, String tag) {
        return getBoolean(tag);
    }

    public boolean getBoolean(int slotId, String tag, boolean defaultValue) {
        return getBoolean(tag, defaultValue);
    }

    public String getString(int slotId, String tag) {
        return getString(tag);
    }

    public String getString(int slotId, String tag, String defaultValue) {
        return getString(tag, defaultValue);
    }

    public int getInteger(int slotId, String tag) {
        return getInt(slotId, tag);
    }

    public int getInt(int slotId, String tag) {
        return getInt(tag);
    }

    public int getInteger(int slotId, String tag, int defaultValue) {
        return getInt(slotId, tag, defaultValue);
    }

    public int getInt(int slotId, String tag, int defaultValue) {
        return getInt(tag, defaultValue);
    }
    
}
