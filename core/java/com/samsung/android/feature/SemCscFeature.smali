.class public Lcom/samsung/android/feature/SemCscFeature;
.super Ljava/lang/Object;
.source "SemCscFeature.java"


# static fields
.field private static sInstance:Lcom/samsung/android/feature/SemCscFeature;


# instance fields
.field private mFeatureList:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 7
    const/4 v0, 0x0

    sput-object v0, Lcom/samsung/android/feature/SemCscFeature;->sInstance:Lcom/samsung/android/feature/SemCscFeature;

    return-void
.end method

.method public constructor <init>()V
    .registers 4

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    .line 12
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Calendar_EnableLocalHolidayDisplay"

    const-string v2, "HKTW"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Calendar_EnableLunar"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 14
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Calendar_SetColorOfDays"

    const-string v2, "XXXXXBR"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 15
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Camera_CameraFlicker"

    const-string v2, "50hz"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Camera_EnableCameraDuringCall"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Clock_ReplaceNameTaiwanWithTaipei"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 18
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_ConfigAllowedPackagesDuringDataSaving"

    const-string v2, "com.samsung.android.smartcallprovider"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_ConfigMarketInfoVariation"

    const-string v2, "Disable"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 20
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_ConfigSamsungCloudVariation"

    const-string v2, "DisablingKeyboardDataSync:boolean:true"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_ConfigSvcProviderForUnknownNumber"

    const-string v2, "whitepages,whitepages,whitepages"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_SupportDynamicNetBandwidthAllocation"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Common_SupportGmsAlarmManager"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_ANRConfig"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_AddPreloadedSpeedDialAs"

    const-string v2, "None,0,None,None"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_CheckSimAlphaLength4UnicodeName"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_ConfigDialerFont"

    const-string v2, "FixedKeypadLetter"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_ConfigImsOpStyle"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_ConfigOpStyleVariation"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_DisableMenuNameOrder"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_EnableBPMFSortList"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_EnableStrokeSortList"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_LimitNameLength"

    const-string v2, "250"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 34
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Contact_SupportDuoVideoCall"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Email_UseFixedSmtpPortAs"

    const-string v2, "25"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_GMS_SetClientIDBaseMs"

    const-string v2, "android-samsung-gs-rev1"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_GMS_SupportSTSTool"

    const-string v2, "FALSE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_NFC_ConfigDynamicFirmwareLoading"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_NFC_DefStatus"

    const-string v2, "ON"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_NFC_StatusBarIconType"

    const-string v2, "DEFAULT"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_NFC_SupportTechFListenMode"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_CallerIdMatchingDigit"

    const-string v2, "8"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_ConfigApnForHideDataIcon"

    const-string v2, "ims,ent1,ent2"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_GetDeviceIdwithIMEIforCDMA"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SupportEsim"

    const-string v2, "FALSE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SPen_ConfigDefTranslatorSolution"

    const-string v2, "BaiduPref"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Security_DeleteCardApplet"

    const-string v2, "deactivate"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_BlockToSelectDunApnType"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_ConfigAboutDeviceItems"

    const-string v2, "modelnumberDSsuffix=disabled;"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_ConfigListForDisablingTimeZoneItem"

    const-string v2, "Asia/Urumqi"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SyncML_ConfigDevicePreId"

    const-string v2, "IMEI"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SystemUI_ConfigDefQuickSettingItem"

    const-string v2, "Wifi,SoundMode,Bluetooth,RotationLock,AirplaneMode,Flashlight,MobileData,Hotspot,BatteryMode,Location,WindowsLink,ScreenRecorder,DesktopMode,AllShareCast,NearbyShare,BlueLightFilter,NightMode,Dnd,ScreenCapture"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SystemUI_ConfigMaxRssiLevel"

    const-string v2, "5"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SystemUI_ConfigOpBrandingForIndicatorIcon"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SystemUI_ConfigQuickSettingPopup"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_SystemUI_ConfigRecentDefaultLockList"

    const-string v2, "com.tencent.mm"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VT_ConfigBearer"

    const-string v2, "-CSVT"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VT_ConfigCapability"

    const-string v2, "three_widget,modify_auto_accept"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleForHdIcon"

    const-string v2, "TGY_HD"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleForVolte"

    const-string v2, "VolteCtc,CTC_VOLTE,wait_for_volte_regi_in_airplane_mode_ctc"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleForWaitingTone"

    const-string v2, "TGY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOptStyleForCallBarring"

    const-string v2, "RemoveCDMA"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigRingbackToneForVolte"

    const-string v2, "HK"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_DisableAlertToneSignal"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_SupportVolteHoldTone"

    const-string v2, "NOT"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Weather_ConfigCpType"

    const-string v2, "TWC"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Web_DisableChooser4"

    const-string v2, "audio/*,audio/mp3,audio/x-mp3,audio/mpeg,audio/mp4,audio/mp4a-latm,application/sdp,video/mpeg,video/3gp,video/3gpp,video/3gpp2,video/x-ms-asf,video/x-ms-wmv,video/x-ms-wma,video/webm,video/flv,video/mkv,video/divx,video/avi,video/skm,video/sktm,video/k3g,video/ak3g,video/x-msvideo,video/vnd.ms-playready.media.pyv,application/x-mpegurl,application/vnd.apple.mpegurl,audio/x-mpegurl,application/x-mpegurl,video/mp4"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Web_EnableAutoSimHomeUrlInProfile"

    const-string v2, "FALSE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Wifi_ConfigSnsStatus"

    const-string v2, "DEFAULT_ON"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Message_DisableMenuSmsInputMode"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_ConfigGlobalModuleType"

    const-string v2, "LTE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_ConfigNetworkTypeCapability"

    const-string v2, "TGY-TGY-GLB-HKG"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_DataPrefDataTechSnapShot"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_DisplayAntennaLimited"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_DisplayPlmnnameSimload"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_E911RoutingPolicy"

    const-string v2, "auto"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_GcfSor"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_QmiCdmaGsm"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_ReferEonsWithoutLac"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_ReferSpnOnManualSearch"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_STKHandlingSendSMSbyAP"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SetNetworkTypeWhenRadioOff"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SignalstrengthPolicy"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SmsCdmaCopyToRuim"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SmsSupportKsc5601Usa"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SpecialAddressHandlingFor"

    const-string v2, "CTC"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_StkCallControlwithIMS"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SupportQcomCrossMapping"

    const-string v2, "FALSE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SupportRegistrationLocationInfo"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_SupportVolte"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_RIL_WapPushFormat4"

    const-string v2, "CTC"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_CustNetworkSelMenu4"

    const-string v2, "NUMERIC"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_DisableNetworkMode"

    const-string v2, "REMOVE_WCDMAONLY"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_Setting_SupportWifiCall"

    const-string v2, "TRUE"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigNetworkList"

    const-string v2, "NetworkMode_HKTW"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleForEmergencyDialCall"

    const-string v2, "STATE_UPDATE_AFTER_DIAL"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleForMobileNetSetting"

    const-string v2, "voltesettingscommon,voltesettingHK,checknonvoltesim,support_hvolte_solution_ctc,support_volte_ctc_spec_2019"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    const-string v1, "CscFeature_VoiceCall_ConfigOpStyleMobileNetworkSettingMenu"

    const-string v2, "-cdmasystemselect, ,+datapreferduringcalling"

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    return-void
.end method

.method public static getInstance()Lcom/samsung/android/feature/SemCscFeature;
    .registers 1

    .prologue
    .line 109
    sget-object v0, Lcom/samsung/android/feature/SemCscFeature;->sInstance:Lcom/samsung/android/feature/SemCscFeature;

    if-nez v0, :cond_b

    .line 110
    new-instance v0, Lcom/samsung/android/feature/SemCscFeature;

    invoke-direct {v0}, Lcom/samsung/android/feature/SemCscFeature;-><init>()V

    sput-object v0, Lcom/samsung/android/feature/SemCscFeature;->sInstance:Lcom/samsung/android/feature/SemCscFeature;

    .line 112
    :cond_b
    sget-object v0, Lcom/samsung/android/feature/SemCscFeature;->sInstance:Lcom/samsung/android/feature/SemCscFeature;

    return-object v0
.end method


# virtual methods
.method public getBoolean(ILjava/lang/String;)Z
    .registers 4

    .prologue
    .line 202
    invoke-virtual {p0, p2}, Lcom/samsung/android/feature/SemCscFeature;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getBoolean(ILjava/lang/String;Z)Z
    .registers 5

    .prologue
    .line 206
    invoke-virtual {p0, p2, p3}, Lcom/samsung/android/feature/SemCscFeature;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getBoolean(Ljava/lang/String;)Z
    .registers 4

    .prologue
    const/4 v1, 0x0

    .line 118
    :try_start_1
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 119
    if-nez v0, :cond_d

    move v0, v1

    .line 124
    :goto_c
    return v0

    .line 122
    :cond_d
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_10} :catch_12

    move-result v0

    goto :goto_c

    .line 123
    :catch_12
    move-exception v0

    move v0, v1

    .line 124
    goto :goto_c
.end method

.method public getBoolean(Ljava/lang/String;Z)Z
    .registers 4

    .prologue
    .line 131
    :try_start_0
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 132
    if-eqz v0, :cond_e

    .line 133
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_d} :catch_f

    move-result p2

    .line 137
    :cond_e
    :goto_e
    return p2

    .line 136
    :catch_f
    move-exception v0

    goto :goto_e
.end method

.method public getInt(ILjava/lang/String;)I
    .registers 4

    .prologue
    .line 222
    invoke-virtual {p0, p2}, Lcom/samsung/android/feature/SemCscFeature;->getInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getInt(ILjava/lang/String;I)I
    .registers 5

    .prologue
    .line 230
    invoke-virtual {p0, p2, p3}, Lcom/samsung/android/feature/SemCscFeature;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getInt(Ljava/lang/String;)I
    .registers 4

    .prologue
    const/4 v1, -0x1

    .line 174
    :try_start_1
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 175
    if-nez v0, :cond_d

    move v0, v1

    .line 180
    :goto_c
    return v0

    .line 178
    :cond_d
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_10} :catch_12

    move-result v0

    goto :goto_c

    .line 179
    :catch_12
    move-exception v0

    move v0, v1

    .line 180
    goto :goto_c
.end method

.method public getInt(Ljava/lang/String;I)I
    .registers 4

    .prologue
    .line 191
    :try_start_0
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 192
    if-eqz v0, :cond_e

    .line 193
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_d} :catch_f

    move-result p2

    .line 197
    :cond_e
    :goto_e
    return p2

    .line 196
    :catch_f
    move-exception v0

    goto :goto_e
.end method

.method public getInteger(ILjava/lang/String;)I
    .registers 4

    .prologue
    .line 218
    invoke-virtual {p0, p1, p2}, Lcom/samsung/android/feature/SemCscFeature;->getInt(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getInteger(ILjava/lang/String;I)I
    .registers 5

    .prologue
    .line 226
    invoke-virtual {p0, p1, p2, p3}, Lcom/samsung/android/feature/SemCscFeature;->getInt(ILjava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getInteger(Ljava/lang/String;)I
    .registers 3

    .prologue
    .line 168
    invoke-virtual {p0, p1}, Lcom/samsung/android/feature/SemCscFeature;->getInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getInteger(Ljava/lang/String;I)I
    .registers 4

    .prologue
    .line 185
    invoke-virtual {p0, p1, p2}, Lcom/samsung/android/feature/SemCscFeature;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getString(ILjava/lang/String;)Ljava/lang/String;
    .registers 4

    .prologue
    .line 210
    invoke-virtual {p0, p2}, Lcom/samsung/android/feature/SemCscFeature;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getString(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    .prologue
    .line 214
    invoke-virtual {p0, p2, p3}, Lcom/samsung/android/feature/SemCscFeature;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    .prologue
    .line 144
    :try_start_0
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 145
    if-nez v0, :cond_c

    .line 146
    const-string v0, ""
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_c} :catch_d

    .line 150
    :cond_c
    :goto_c
    return-object v0

    .line 149
    :catch_d
    move-exception v0

    .line 150
    const-string v0, ""

    goto :goto_c
.end method

.method public getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    .prologue
    .line 157
    :try_start_0
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_8} :catch_c

    .line 158
    if-eqz v0, :cond_b

    move-object p2, v0

    .line 163
    :cond_b
    :goto_b
    return-object p2

    .line 162
    :catch_c
    move-exception v0

    goto :goto_b
.end method

.method public tracer(I)Ljava/util/Hashtable;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/samsung/android/feature/SemCscFeature;->mFeatureList:Ljava/util/Hashtable;

    return-object v0
.end method
