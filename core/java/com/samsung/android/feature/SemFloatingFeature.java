package com.samsung.android.feature;

import java.util.Hashtable;

public class SemFloatingFeature {

    private static SemFloatingFeature sInstance = null;
    private final Hashtable<String, String> mFeatureList = new Hashtable<>();

    {
        this.mFeatureList.put("SEC_FLOATING_FEATURE_ACCESSIBILITY_SUPPORT_DIRECTION_LOCK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_ACCESSIBILITY_SUPPORT_HEARING_AIDS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_ACCESSIBILITY_SUPPORT_HW_KEY_POSITION", "none");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_ACCESSIBILITY_SUPPORT_MANAGE_EXCLUSIVE_TASK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_ALLSHARE_CONFIG_VERSION", "DMC_ONLY");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_FMRADIO_EXTERNAL_DEVICE", "BT");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_MULTI_MIC", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_MULTIRECORD", "10");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_REMOTE_MIC", "DSP");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_SOUNDALIVE_NUMBER_OF_SPEAKER", "1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_SOUNDALIVE_VERSION", "eq_custom,uhq_level,karaoke,adapt,spk_stereo,dvfs_700000");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_VOLUMEMONITOR_GAIN", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_CONFIG_VOLUME_PANEL_POSITION", "left");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_BT_RECORDING", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DC_MOTOR_HAPTIC_FEEDBACK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DEFAULT_ON_DOLBY_IN_GAME", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DOLBY_GAME_PROFILE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DUAL_SPEAKER", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_HEADTRACKING_EFFECT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_MULTI_AUDIO_FOCUS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_MULTI_DEVICE_SOUND", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_RECORDING_POPUP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_SPEAKER_AEC", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_VOIP_VIA_SMART_VIEW", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_HV", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_HV_DURING_CHARGING", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_WIRELESS_HV", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_WIRELESS_NIGHT_MODE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_WIRELESS_TX", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BATTERY_SUPPORT_WIRELESS_TX_5V_TA", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIOAUTH_CONFIG_FINGERPRINT_FEATURES", "capacitive_powerkey_phone");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBY_CONFIG_BARGEIN_FUNCTION", "1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBY_CONFIG_DSP_BITRATE", "32bit");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBY_CONFIG_DSPNS_FUNCTION", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBY_SUPPORT_CUSTOM_WAKEUP", "1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBY_SUPPORT_USERKWD_WAKEUP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_BIXBYVISION_CONFIG_FUNCTIONS", "Phone;Lens;LiveTranslation;Makeup");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CALENDAR_CONFIG_PACKAGE_NAME", "com.samsung.android.calendar");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_MACRO", "-1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_TELE2", "54");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_TELE_BINNING", "50");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_TELE_STANDARD_CROP", "52");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_UW", "58");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CAMID_WIDE", "56");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_CORE_VERSION", "v2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_IRIS_OPERATION", "RGB");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_LLHDR_PROCESSING_TIMEOUT", "2000");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_MEMORY_USAGE_LEVEL", "3");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_MYFILTER", "1,1,0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_NIGHT_FRONT_BEAUTY_LEVEL", "4");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_NIGHT_FRONT_DISPLAY_FLASH_TRANSPARENT", "50");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_PERSONALIZATION", "CoolOriWarm");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_THRESHOLD_FOR_LOW_BATTERY", "5");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_UW_DISTORTION_CORRECTION", "0,119,2,18010101,4608,3456,0,0,0,0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_VENDOR_LIB_INFO", "beauty.samsung.v4,single_bokeh.samsung.v2,dual_bokeh.samsung.v1,facial_attribute.samsung.v1,mfhdr.arcsoft.v1,llhdr.arcsoft.v1,human_tracking.arcsoft.v2_1,scene_detection.samsung.v1,event_detection.samsung.v2,food.samsung.v1,intelligent_guide.samsung.v1,star_effect.samsung.v1,localtm.samsung.v1_1,swldc.samsung.v1,smart_scan.samsung.v2,selfie_correction.samsung.v1,face_landmark.arcsoft.v2,human_segmentation.samsung.v2,high_res.arcsoft.v1,swuwdc.arcsoft.v1,image_enhance.arcsoft.v1,super_night.mpi.v2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_CONFIG_VERSION_FILTER_PROVIDER", "5");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_SUPPORT_AVATAR", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_SUPPORT_CONTROLLING_WATCH", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_SUPPORT_DOWNLOAD_EFFECT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CAMERA_SUPPORT_TORCH_BRIGHTNESS_LEVEL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_DEVICE_MANUFACTURING_TYPE", "in_house");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_DEX_MODE", "dual,wireless,dexforpc");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_DUAL_IMS", "DSDS_DI");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_EDGE", "people,task,circle,panel,-edgefeeds,debug,search,phonecolor,dot_bottom");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_MDNIE_MODE", "65303");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_MULTIMEDIA_EDITOR_PLUGIN_PACKAGES", "videoeditor,slowmotion,storyvideoeditor,videotrimmer,superslowmotion,superslowmotion_9,highlight");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_OMC_VERSION", "5.1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_ONEHAND_MODE_POLICY", "Enabled;GestureType");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_PREFERRED_USER_ROTATION", "-1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_SEP_CATEGORY", "sep_basic");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_SMARTTUTOR_PACKAGES_NAME", "com.rsupport.rs.activity.rsupport.aas2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_SMARTTUTOR_PACKAGES_PATH", "system/hidden/SmartTutor/SmartTutor.apk");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_CONFIG_SWLENS_DISTORTION_CORRECTION", "beyond,S5K3P9");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_ACCESSIBILITY_CONFLICT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_AOD_LOCK_SHARE_INFO", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_BIXBY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_COLOR_LENS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_CONVENTIONAL_MODE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_DEX_ON_PC", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_ELASTIC_PLUGIN", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_EVS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_FLASH_NOTIFICATION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_HDR_EFFECT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_KNOX_DESKTOP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_LTW_REMOTE_APP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_SAFETYCARE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_SAMSUNG_MARKETING_INFO", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_SECUREUI_LANDSCAPE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_SERVICEBOX", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_SMART_SWITCH", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_ULTRA_POWER_SAVING", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_COMMON_SUPPORT_WCDMA_INSLAVE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CONTACTS_CONFIG_PACKAGE_NAME", "com.samsung.android.app.contacts");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CONTACTS_CONFIG_PROVIDER_PACKAGE_NAME", "com.samsung.android.providers.contacts");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CONTACTS_SUPPORT_INDEX_SCROLL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CONTACTS_SUPPORT_MESSAGE_LOGS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_DEVICESEARCH_CONFIG_SOLUTION", "finder");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FACTORY_SUPPORT_FTL_SPEN_TYPE", "none");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FACTORY_SUPPORT_FTL_UI_RATIO", "1.0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_BROADCOM_VOLUME_TABLE", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_CHIP_VENDOR", "5");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_AF_THRESH", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_AFVALID_THRESH", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI", "12");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SUPPORT_HYBRIDSEARCH", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH", "-42");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH", "-69");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_DESENSE_LIST", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKDESENSERSSI", "-90");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKSMG", "1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_BLEND_RMSSI_HI", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_BLEND_SINR_HI", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH", "-110");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_DC", "64");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_QA", "80");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_BLENDCOEF", "3172");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT1", "4800");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT2", "5600");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH", "Speaker");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_REMOVE_AF_MENU", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FMRADIO_SUPPORT_SOFTMUTE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_AOD_DOZE_SERVICE_VERSION", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_AOD_ITEM", "activeclock=4,aodversion=7");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_CLIPBOARD_STYLE_VERSION", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_COVER", "null");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_EDGE_QUICKTOOLS_SCREEN_HEIGHT", "1321,0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_FRAME_SPLIT_COUNT", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_NAVIGATION_BAR_THEME", "SupportLightNavigationBar|SupportCustomBgColor|SupportNaviBarRemoteView");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_NFC_LED_COVER_LEVEL", "60");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_ROUNDED_CORNER_RADIUS", "26");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_VERSION", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_CLIPBOARD_LOCK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_CUSTOM_STARTING_WINDOW", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_SCREEN_RECORDER", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_TSP_STATE_MANAGER", "deadzone_v2,change_ratio");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_FACE_CLUSTER_VERSION", "SRCB_V3");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_IMAGE_TAGGER_UPDATE", "None");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_IMAGE_TAGGER_VERSION", "V448");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_LIVEFOCUS_CAMERA_MODE", "SINGLE,DUAL");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_LIVEFOCUS_EFFECT_DUAL_BOKEH", "BLUR,EFFECT,BIGBOKEH,PORTRAIT,RELIGHT,REFOCUS");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_LIVEFOCUS_EFFECT_SINGLE_BOKEH", "BLUR,EFFECT,BIGBOKEH,PORTRAIT,RELIGHT");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_LIVEFOCUS_PROJECT_ID", "DUAL_11");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_CONFIG_ZOOM_TYPE", "ZOOM_2K");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_SUPPORT_LOCATION_POI", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_SUPPORT_MORE_ALBUM", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_SUPPORT_MOVE_COPY_ALBUM_THUMBNAIL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_SUPPORT_SLOW_FAST_MOTION_EXPORT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GALLERY_SUPPORT_STORYEDITOR", "4");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_CAPTURED_BLUR", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_DEFAULT_GAMELAUNCHER_ENABLE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_PARTIAL_BLUR", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_HELP_CONFIG_THEME_TYPE", "K");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_IMS_CONFIG_EVS_MAX_HW_BANDWIDTH", "swb");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_KNOX_SUPPORT_LEGACY_CCM", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_KNOX_SUPPORT_TKS_DEPRECATION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_KNOX_SUPPORT_UKS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LAUNCHER_CONFIG_ANIMATION_TYPE", "CHNHighEnd");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LAUNCHER_CONFIG_LOCAL_THEME_DOWNLOAD", "China");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LAUNCHER_CONFIG_RECENTS_MULTIWINDOW", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LAUNCHER_SUPPORT_CLOCK_LIVE_ICON", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_CONTROL_AUTO_BRIGHTNESS", "4");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_DEFAULT_SCREEN_MODE", "4");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_HFR_DEFAULT_REFRESH_RATE", "60");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_HFR_MODE", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_HFR_SUPPORTED_REFRESH_RATE_NS", "60");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_REPLACE_COLOR_FOR_DARKMODE", "#FF171717");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_CONFIG_SELFMASK_VERSION", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_AMOLED_DISPLAY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_BLUE_FILTER_ADAPTIVE_MODE", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_MDNIE_HW", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_POC_GRAY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_SCREEN_MODE_TYPE", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_SELFMASK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LCD_SUPPORT_WIDE_COLOR_GAMUT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_CONFIG_DEFAULT_WALLPAPER_STYLE", "MULTIPLE=com.samsung.android.beyond.p00.wallpapermulti:tilt");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_CONFIG_WALLPAPER_DEV_COLOR_MATCHING", "CMF");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_CONFIG_WALLPAPER_STYLE", "MOTION,VIDEO,INCONSISTENCY");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_SUPPORT_BACKGROUND_AUTHENTICATION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_SUPPORT_FLOATING_SHORTCUT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_LOCKSCREEN_SUPPORT_SIMPLE_PIN", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY", "15");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MCF_SUPPORT_FRAMEWORK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MESSAGE_CONFIG_PACKAGE_NAME", "com.samsung.android.messaging");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_CONFIG_SMART_MIRRORING_PACKAGE_NAME", "com.samsung.android.smartmirroring");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_CONFIG_UHDA", "-1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_AC4_CODEC", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_APE_FORMAT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_DOLBY_AUDIO", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_DSD_FORMAT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_HDR10PLUS_PLAYBACK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_HW_HDR", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_MOV", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_MUSIC_ALBUMART_3DAUDIO", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_MUSIC_AUTO_RECOMMENDATION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MMFW_SUPPORT_SMARTFITTING", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MUSICPLAYER_SUPPORT_COVER_FLOW_NEXT_PREV_VI", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_MUSICPLAYER_SUPPORT_SCREEN_OFF_MUSIC", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_NFC_SUPPORT_DEFAULT_NFC_METHOD", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_QUICKCONNECT_CONFIG_PACKAGE_NAME", "com.samsung.android.oneconnect");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_QUICKCONNECT_SUPPORT_D2D", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_RIL_SUPPORT_MOBILE_DATA_ONLY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAIV_CONFIG_AI_REVITAL_VERSION", "1.7,1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAIV_CONFIG_BEAUTY_FACE", "204");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAIV_CONFIG_MIDAS", "UPSCALE,LOWLIGHT,HDR,DEBLUR");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAIV_SUPPORT_AI_REVITAL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAIV_SUPPORT_BEST_PHOTO", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SAMSUNGCLOUD_SUPPORT_SAMSUNGKEYBOARD_SYNC", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SECURITY_CONFIG_DEVICEMONITOR_PACKAGE_NAME", "com.samsung.android.sm.devicesecurity");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SECURITY_SUPPORT_STRONGBOX", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_BRAND_NAME", "Galaxy S10e");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_DEFAULT_FONT_SIZE", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_DEFAULT_POCKET_MODE", "1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_ELECTRIC_RATED_VALUE", "DC 9 V; 1.67 A");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_FCC_ID", "A3LSMG9700");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_SIM_MGR", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_ACCESSORY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_AUTO_BRIGTNESS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_AUTOMATIC_BRIGHTNESS_DETAIL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_DEFAULT_DOUBLE_TAP_TO_WAKE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_DRIVING_MODE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_EASY_MODE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_EXTERNAL_APP_SETTINGS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_DOUBLE_TAP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PALM_SWIPE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PALM_TOUCH", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PAN", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PAN_TO_BROWSE_IMAGE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PICK_UP", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_PICK_UP_TO_CALL_OUT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_SHAKE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_TILT", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_MOTION_TRUN_OVER", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_SEPERATE_LOCK_AND_SECURITY", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_S_PEN_HOVERING", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SETTINGS_SUPPORT_SURFACE", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SFINDER_CONFIG_QUERY_PARSER_VERSION", "2");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_ENGINE_DB_TYPE", "ALM");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_FOLD_UX_VERSION", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_HWR_ENGINE", "SSHWRPANEL");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_PACKAGE_NAME", "com.samsung.android.honeyboard");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_PREDICTION_ENGINE", "XT9");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_CONFIG_STICKER_CONTENTS", "mojitok,bitmoji");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_ENABLE_DEF_KEY_SOUND", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SIP_SUPPORT_CURSOR_CONTROL", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SMARTMANAGER_CONFIG_PACKAGE_NAME", "com.samsung.android.lool");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SPAY_CONFIG_SWIPEUP_HEIGHT", "0.5");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEM_CONFIG_HCM_AI_POWER_SAVING_LEVEL", "225");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEM_CONFIG_HCM_N2PE_LEVEL", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEM_CONFIG_SIOP_POLICY_FILENAME", "ssrm_default");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEM_CONFIG_SYSINT_DQA_LOGLEVEL", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEM_SUPPORT_ENHANCED_CPU_RESPONSIVENESS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEMUI_CONFIG_CORNER_ROUND", "5.0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEMUI_CONFIG_EDGELIGHTING_FRAME_EFFECT", "frame_effect");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEMUI_CONFIG_READING_MODE", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_SYSTEMUI_SUPPORT_BRIEF_NOTIFICATION", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VIDEOEDITOR_CONFIG_360MODE", "0");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VIDEOPLAYER_CONFIG_PLAY_DEBOUNCE_MILLIS", "100");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VISION_CONFIG_FACE_DETECTOR_SOLUTION", "SW");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VISION_CONFIG_RELIGHTING_SOLUTION", "arsoft_vieweronly.v1");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VOICECALL_CONFIG_INCALLUI_PACKAGE_NAME", "com.samsung.android.incallui");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VOICECALL_SUPPORT_GLOBAL_NETWORK", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VOICECALL_SUPPORT_MOBILE_DATA_SETTINGS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VOICERECORDER_CONFIG_DEF_MODE", "normal,interview,voicememo");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_VOICERECORDER_CONFIG_PACKAGE_NAME", "com.sec.android.app.voicenote");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_WEATHER_SUPPORT_DETAIL_CITY_VIEW", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_WEB_CONFIG_DEFAULT_BROWSER", "VZW,ATT,AIO,SPR,XAS,VMU,BST,TMB,TMK,CCT,CHA,USC");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_WIFI_SUPPORT_ADPS", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_WLAN_SUPPORT_ADAPTIVE_WIFI", "TRUE");
        this.mFeatureList.put("SEC_FLOATING_FEATURE_WLAN_SUPPORT_AP_LINK", "TRUE");

    }

    public static SemFloatingFeature getInstance() {
        if (sInstance == null) {
            sInstance = new SemFloatingFeature();
        }
        return sInstance;
    }

    public boolean getBoolean(String tag) {
        if (tag == null) {
            return false;
        }
        String original = this.mFeatureList.get(tag);
        boolean value = Boolean.parseBoolean(original);
        return value;
    }

    public boolean getBoolean(String tag, boolean defaultValue) {
        if (tag == null) {
            return false;
        }
        String original = this.mFeatureList.get(tag);
        if (original == null) {
            return defaultValue;
        }
        boolean value = Boolean.parseBoolean(original);
        return value;
    }

    public String getString(String tag) {
        if (tag == null) {
            return "";
        }
        String original = this.mFeatureList.get(tag);
        return original == null ? "" : original;
    }

    public String getString(String tag, String defaultValue) {
        if (tag == null) {
            return "";
        }
        String original = this.mFeatureList.get(tag);
        return original == null ? defaultValue : original;
    }

    public int getInteger(String tag) {
        return getInt(tag);
    }

    public int getInt(String tag) {
        if (tag == null) {
            return -1;
        }
        String original = this.mFeatureList.get(tag);
        try {
            int value = Integer.parseInt(original);
            return value;
        } catch (Exception e) {
            return -1;
        }
    }

    public int getInteger(String tag, int defaultValue) {
        return getInt(tag, defaultValue);
    }

    public int getInt(String tag, int defaultValue) {
        if (tag == null) {
            return -1;
        }
        String original = this.mFeatureList.get(tag);
        try {
            int value = Integer.parseInt(original);
            return value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

}