package com.android.server;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManagerPolicyConstants;
import com.android.server.FMPlayerNativeBase;
import com.samsung.android.audio.AudioConstants;
import com.samsung.android.emergencymode.SemEmergencyConstants;
import com.samsung.android.emergencymode.SemEmergencyManager;
import com.samsung.android.feature.SemCscFeature;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.media.fmradio.internal.IFMEventListener;
import com.samsung.android.media.fmradio.internal.IFMPlayer;
import com.samsung.android.share.SemShareConstants;
import com.samsung.android.transcode.constants.EncodeConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class FMRadioService extends IFMPlayer.Stub {

    @Override
    public boolean modSamsungSetRadioOutputPath(int path) {
        if (mIsFMAudioPathOn) {
            path = path | AudioManager.MOD_RADIO_OUTPUT_PATH_IS_FMRADIO_ON;
        }

        boolean result = this.mAudioManager.modSamsungSetRadioOutputPath(path);

        if ((path & AudioManager.MOD_RADIO_OUTPUT_PATH_IS_FMRADIO_ON) != 0) {

            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    FMRadioService.this.setVolume(FMRadioService.this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)));
                }
            }, 600);

            int intSize = android.media.AudioTrack.getMinBufferSize(
                            48000, android.media.AudioFormat.CHANNEL_CONFIGURATION_STEREO,
                            android.media.AudioFormat.ENCODING_PCM_16BIT);

            android.media.AudioTrack temporaryDummyAudio = new android.media.AudioTrack(AudioManager.STREAM_MUSIC,
                    48000, android.media.AudioFormat.CHANNEL_CONFIGURATION_STEREO,
                    android.media.AudioFormat.ENCODING_PCM_16BIT, intSize*2,
                    android.media.AudioTrack.MODE_STREAM);

            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    temporaryDummyAudio.play();
                }
            }, 700);

            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    temporaryDummyAudio.stop();
                    temporaryDummyAudio.release();
                }
            }, 800);
        }
        
        return result;
    }

    @Override
    public int modSamsungGetRadioOutputPath() {
        return this.mAudioManager.modSamsungGetRadioOutputPath();
    }

    private static final String ACTINON_ALARM_PLAY = "com.sec.android.app.voicecommand";
    private static final String ACTION_ALL_SOUND_OFF = "android.settings.ALL_SOUND_MUTE";
    private static final String ACTION_CAMERA_START = "com.sec.android.app.camera.ACTION_CAMERA_START";
    private static final String ACTION_CAMERA_STOP = "com.sec.android.app.camera.ACTION_CAMERA_STOP";
    private static final String ACTION_DNS_PAUSE_INTERNET_STREAM = "com.sec.android.app.dns.action.pause_internet_stream";
    private static final String ACTION_DNS_RESUME_INTERNET_STREAM = "com.sec.android.app.dns.action.resume_internet_stream";
    private static final String ACTION_DNS_STOP_INTERNET_STREAM = "com.sec.android.app.dns.action.stop_internet_stream";
    private static final String ACTION_MUSIC_COMMAND = "com.android.music.musicservicecommand";
    private static final String ACTION_SAVE_FMRECORDING_ONLY = "com.samsung.media.save_fmrecording_only";
    private static final String ACTION_VOLUME_LOCK = "com.sec.android.fm.volume_lock";
    private static final String ACTION_VOLUME_UNLOCK = "com.sec.android.fm.volume_unlock";
    private static final String APP_NAME = "com.sec.android.app.fm";
    private static final int AVC_MODE_ON = 1;
    public static final int BAND_76000_108000_kHz = 2;
    public static final int BAND_76000_90000_kHz = 3;
    public static final int BAND_87500_108000_kHz = 1;
    public static final int BAND_EXTERNALCHIPSET_64000_76000_kHz = 3;
    public static final int BAND_EXTERNALCHIPSET_76000_107000_kHz = 1;
    public static final int BAND_EXTERNALCHIPSET_76000_91000_kHz = 2;
    public static final int BAND_EXTERNALCHIPSET_87000_108000_kHz = 0;
    public static final int CHAN_SPACING_100_kHz = 10;
    public static final int CHAN_SPACING_200_kHz = 20;
    public static final int CHAN_SPACING_50_kHz = 5;
    public static final int CHAN_SPACING_EXTERNALCHIPSET_100_kHz = 1;
    public static final int CHAN_SPACING_EXTERNALCHIPSET_200_kHz = 0;
    public static final int CHAN_SPACING_EXTERNALCHIPSET_50_kHz = 2;
    private static final int CODE_SCAN_PROGRESS = 1;
    public static final boolean DEBUG = true;
    private static final boolean DEBUGGABLE;
    private static final int DELAY_WAITING_STREAM_STOPPED = 150;
    public static final int DE_TIME_CONSTANT_50 = 1;
    public static final int DE_TIME_CONSTANT_75 = 0;
    private static final int DISABLE_SLIMBUS_DATA_PORT = 0;
    private static final int ENABLE_SLIMBUS_DATA_PORT = 1;
    static final int EVENT_AF_RECEIVED = 14;
    static final int EVENT_AF_STARTED = 13;
    private static final int EVENT_CHANNEL_FOUND = 1;
    private static final int EVENT_EAR_PHONE_CONNECT = 8;
    private static final int EVENT_EAR_PHONE_DISCONNECT = 9;
    private static final int EVENT_OFF = 6;
    private static final int EVENT_ON = 5;
    static final int EVENT_PIECC_EVENT = 18;
    private static final int EVENT_RDS_DISABLED = 12;
    private static final int EVENT_RDS_ENABLED = 11;
    static final int EVENT_RDS_EVENT = 10;
    static final int EVENT_REC_FINISH = 17;
    static final int EVENT_RTPLUS_EVENT = 16;
    private static final int EVENT_SCAN_FINISHED = 3;
    private static final int EVENT_SCAN_STARTED = 2;
    private static final int EVENT_SCAN_STOPPED = 4;
    private static final int EVENT_TUNE = 7;
    public static final int EVENT_VOLUME_LOCK = 15;
    private static final String FACTORY_APP_NAME = "com.sec.factory.app.fm";
    private static final String FMRADIO_CTS_APP_NAME = "com.samsung.cts.SamsungMediaFmradio";
    private static final String FMTEST_APP_NAME = "com.sec.android.fmtestapp";
    private static final String FM_RADIO_AUDIO_FOCUS_TAG = "FM_RADIO";
    private static final String JAPANRADIO_APP_NAME = "jp.radiko.plusfm.player";
    private static final String JAPANRADIO_TUNER_NAME = "jp.radiko.radio.player";
    private static final String KEY_RETURNBACK_VOLUME = "com.sec.android.fm.return_back_volume";
    private static final String KNOX_MODE_USER_SWITCH = "android.intent.action.USER_SWITCHED";
    private static final String MDM_SPEAKER_ENABLED = "com.samsung.android.knox.intent.action.SET_DEVICE_SPEAKER_ENABLED";
    private static final String NEXTRADIO_NAME = "com.nextradioapp.nextradio";
    public static final int OFF_AIRPLANE_MODE_SET = 3;
    public static final int OFF_BATTERY_LOW = 7;
    public static final int OFF_CALL_ACTIVE = 1;
    public static final int OFF_DEVICE_SHUTDOWN = 6;
    public static final int OFF_EAR_PHONE_DISCONNECT = 2;
    public static final int OFF_MOTION_LISTENER = 21;
    public static final int OFF_NORMAL = 0;
    public static final int OFF_PAUSE_COMMAND = 5;
    public static final int OFF_STOP_COMMAND = 4;
    public static final int OFF_TV_OUT = 10;
    private static final String PARAMETER_AFRMSSI_SAMPLES = "AFRMSSISamples";
    private static final String PARAMETER_AFRMSSI_TH = "AFRMSSIThreshold";
    private static final String PARAMETER_AF_TH = "AF_th";
    private static final String PARAMETER_AF_VALID_TH = "AFValid_th";
    private static final String PARAMETER_ATJ_CONFIG = "ATJCofig";
    private static final String PARAMETER_BLEND_PAMD_TH = "BlendPAMD_th";
    private static final String PARAMETER_BLEND_RMSSI = "BlendRmssi";
    private static final String PARAMETER_BLEND_RSSI_TH = "BlendRSSI_th";
    private static final String PARAMETER_BLEND_SINR = "BlendSinr";
    private static final String PARAMETER_CFO_TH = "CFOTh12";
    private static final String PARAMETER_CURRENT_RSSI = "CurrentRSSI";
    private static final String PARAMETER_CURRENT_SNR = "CurrentSNR";
    private static final String PARAMETER_DESENSE_LIST = "DeSenseList";
    private static final String PARAMETER_DE_CONSTANT = "DEConstant";
    private static final String PARAMETER_FAKE_CHANNEL = "FakeChannel";
    private static final String PARAMETER_FIRST_CNT_TH = "Cnt_th";
    private static final String PARAMETER_FIRST_RSSI_TH = "RSSI_th";
    private static final String PARAMETER_FIRST_SNR_TH = "SNR_th";
    private static final String PARAMETER_GOOD_CH_RMSSI_TH = "GoodChannelRMSSIThreshold";
    private static final String PARAMETER_HYBRID_SEARCH = "HybridSearch";
    public static final String PARAMETER_IF_COUNT_1 = "IFCount1";
    public static final String PARAMETER_IF_COUNT_2 = "IFCount2";
    private static final String PARAMETER_OFF_CHANNEL_TH = "OffChannelThreshold";
    private static final String PARAMETER_ON_CHANNEL_TH = "OnChannelThreshold";
    private static final String PARAMETER_RMSSI_FIRST_STAGE = "RMSSIFirstStage";
    private static final String PARAMETER_SEARCH_ALGO_TYPE = "SearchAlgoType";
    private static final String PARAMETER_SECOND_CNT_TH = "Cnt_th_2";
    private static final String PARAMETER_SECOND_RSSI_TH = "RSSI_th_2";
    private static final String PARAMETER_SECOND_SNR_TH = "SNR_th_2";
    private static final String PARAMETER_SEEK_DC = "SeekDC";
    private static final String PARAMETER_SEEK_DESENSE_RSSI = "SeekDesenseRSSI";
    private static final String PARAMETER_SEEK_QA = "SeekQA";
    private static final String PARAMETER_SEEK_RSSI = "SeekRSSI";
    private static final String PARAMETER_SEEK_SMG = "SeekSMG";
    private static final String PARAMETER_SEEK_SNR = "SeekSNR";
    private static final String PARAMETER_SINR_FIRST_STAGE = "SINRFirstStage";
    private static final String PARAMETER_SINR_SAMPLES = "SINRSamples";
    private static final String PARAMETER_SINR_TH = "SINRThreshold";
    private static final String PARAMETER_SKIP_TUNNING_VALUE = "SkipTuningValue";
    public static final String PARAMETER_SOFTMUTE_COEFF = "SoftMuteCoeff";
    private static final String PARAMETER_SOFTMUTE_TH = "Softmute_th";
    public static final String PARAMETER_SOFT_STEREO_BLEND_COEFF = "SoftStereoBlendCoeff";
    public static final String PARAMETER_SOFT_STEREO_BLEND_REF = "SoftStereoBlendRef";
    public static final int PAUSED = 11;
    private static final int RECORDING_END = 0;
    private static final int RECORDING_START = 1;
    private static final String RESET_SETTING = "android.intent.action.SETTINGS_SOFT_RESET";
    private static final String SA_ACTION = "com.sec.android.diagmonagent.intent.USE_APP_FEATURE_SURVEY";
    private static final String SA_FEATURE = "SBKS";
    private static final String SA_PACKAGE = "com.sec.android.diagmonagent";
    private static final String SA_SM_SDK_ID = "Galaxy FM Radio SDK";
    private static final String SA_TRACKING_ID = "4M3-399-1025498";
    static final int VOLUME_FADEIN = 200;
    static final int VOLUME_FADEIN_DELAYTIME = 100;
    static final int VOLUME_FADEIN_FIRST_DELAYTIME = 800;
    private static final String VOLUME_UP_DOWN = "114,115";
    private static final String audioMute = "g_fmradio_mute=true";
    private static final String audioUnMute = "g_fmradio_mute=false";
    private static long curFreq;
    private static final boolean isFactoryBinary;
    private static final Object mFMRadioServiceLock;
    private static boolean mIsTransientPaused;
    private static boolean mNeedToResumeFM;
    private boolean mAFEnable;
    private boolean mAirPlaneEnabled;
    private AudioManager mAudioManager;
    private Context mContext;
    private long mCurrentResumeVol;
    private boolean mDNSEnable;
    private Handler mHandlerSA;
    private boolean mIsBatteryLow;
    private boolean mIsExternalChipset;
    private boolean mIsMute;
    private boolean mIsOn;
    private boolean mIsSeeking;
    private boolean mIsSkipTunigVal;
    private boolean mIsTestMode;
    private Vector<ListenerRecord> mListeners;
    private PlayerExternalChipsetBase mPlayerExternalChipset;
    private FMPlayerNativeBase mPlayerNative;
    private PowerManager mPowerManager;
    private boolean mRDSEnable;
    private long mResumeVol;
    private Runnable mSamsungAnalyticsRunnable;
    private ArrayList<Long> mScanChannelList;
    private long mScanFreq;
    private boolean mScanProgress;
    private TelephonyManager mTelephonyManager;
    private PowerManager.WakeLock mWakeLock;
    private boolean mOnProgress = false;
    private boolean mOffProgress = false;
    private boolean mIsHeadsetPlugged = false;
    private boolean mIsMicrophoneConnected = false;
    private boolean mIsEarphoneConnected = false;
    private boolean mIsTvOutPlugged = false;
    private long mNeedResumeToFreq = -2;
    private boolean mBikeMode = false;
    private boolean mIsTransientDuck = false;
    private boolean mIsPhoneStateListenerRegistered = false;
    private boolean mAvrcpMode = false;
    private long mPreviousFoundFreq = 0;
    private long mCurrentFoundFreq = 0;
    boolean mRecFinishNotified = false;
    private boolean volumeLock = false;
    private boolean isRecording = false;
    private boolean alarmTTSPlay = false;
    private boolean mIsForcestop = false;
    private String SetPropertyPermission = "com.sec.android.app.fm.permission.setproperty";
    private String VolumePropertyname = "service.brcm.fm.volumetable";
    private int mRssi_th = 0;
    private int mSnr_th = 0;
    private int mCnt_th = 0;
    private int mRssi_th_2 = 0;
    private int mSnr_th_2 = 0;
    private int mCnt_th_2 = 0;
    private int mAlgo_type = 1;
    private int mCf0_th12 = 0;
    private int mAfRmssith_th = 0;
    private int mAfRmssisampleCnt_th = 0;
    private int mgoodChrmssi_th = 0;
    private boolean mIsSupportSoftmute = false;
    private String mSoftmutePath = "Speaker";
    private int mSoftmute_th = 0;
    public int mBand = 1;
    public int mChannelSpacing = 10;
    public int mDEConstant = 1;
    private boolean mIsSetWakeKey = false;
    private int mReturnBackVolume = -1;
    public boolean mIsAudioFocusAlive = false;
    private boolean mIsFMAudioPathOn = false;
    private int mQualcomm_rmssi_firststate = -113;
    private int mQualcomm_onchannel = 109;
    private int mQualcomm_offchannel = 115;
    private int mQualcomm_sinr_samplecnt = 10;
    private int mQualcomm_cfoth12 = 15000;
    private int mQualcomm_af_rmssith = 53;
    private int mQualcomm_af_rmssisamplecnt = 80;
    private int mRichwave_seekDC = 64;
    private int mRichwave_seekQA = 80;
    private int mSlsi_ifcount1 = 5000;
    private int mSlsi_ifcount2 = 4800;
    private long mSlsi_blendcoeff = 3172;
    private long mSlsi_softmutecoeff = -1;
    private long mSlsi_softstereoblendref = 0;
    private int mMtk_seekdesenserssi = -96;
    private int mMtk_seeksmg = EncodeConstants.BitRate.VIDEO_FHD_BITRATE;
    private int mMtk_blendrssi_th = -65;
    private int mMtk_blendpamd_th = -30;
    private int mMtk_ATJ_config = 1;
    private final boolean SURVEY_MODE_ENABLE = SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE", false);
    private final boolean FEATURE_INDIRECT_MODE = SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FMRADIO_SUPPORT_INDIRECT_MODE", false);
    private ContentObserver mAvrcpObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.android.server.FMRadioService.1
        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            FMRadioService.this.handleAvrcpMode();
        }
    };
    private BroadcastReceiver mVolumeEventReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FMRadioService.log("*** mVolumeEventReceiver: ACTION  - " + intent.getAction());
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                int stream = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 10);
                int volume = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                FMRadioService.log("Stream: " + stream + "  and volume: " + volume);
                if (stream == AudioManager.modSamsungGetStreamType(1) || (stream == 3 && FMRadioService.this.mIsOn)) {
                    if (!FMRadioService.this.volumeLock) {
                        int current_stream_volume = FMRadioService.this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1));
                        FMRadioService.log("current_stream_volume: " + current_stream_volume);
                        if (volume != current_stream_volume || FMRadioService.this.isDNDEnable()) {
                            int type = FMRadioService.this.modSamsungGetRadioOutputPath();
                            FMRadioService fMRadioService = FMRadioService.this;
                            fMRadioService.mAvrcpMode = Settings.Secure.getInt(fMRadioService.mContext.getContentResolver(), "bluetooth_avc_mode", 1) == 1;
                            if (FMRadioService.this.mAvrcpMode && type == 8 && FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
                                FMRadioService.log("mAvrcpMode = true set chip volume 15");
                                FMRadioService.this.mPlayerNative.setVolume(15L);
                            }
                        } else {
                            if (FMRadioService.this.mHandler.hasMessages(200)) {
                                FMRadioService.this.mHandler.removeMessages(200);
                            }
                            FMRadioService.this.setVolume(volume);
                        }
                    } else {
                        FMRadioService.this.notifyEvent(15, null);
                    }
                }
            }
            if (FMRadioService.ACTION_VOLUME_LOCK.equals(intent.getAction())) {
                FMRadioService.this.mReturnBackVolume = intent.getIntExtra(FMRadioService.KEY_RETURNBACK_VOLUME, -1);
                FMRadioService.log("Volume Locked...");
                FMRadioService.this.volumeLock = true;
            } else if (FMRadioService.ACTION_VOLUME_UNLOCK.equals(intent.getAction())) {
                FMRadioService.log("Volume Unlocked...");
                FMRadioService.this.mReturnBackVolume = -1;
                FMRadioService.this.volumeLock = false;
            }
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FMRadioService.log("Headset action : " + intent.getAction());
            boolean z = false;
            if (intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_ATTACHED) || intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_DETACHED)) {
                if (!SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_AUDIO_CONFIG_FMRADIO_EXTERNAL_DEVICE").contains("USB") && !FMRadioService.this.mIsExternalChipset) {
                    return;
                }
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                FMRadioService.log("Headset getProductId : " + usbDevice.getProductId());
                FMRadioService.log("Headset getVendorId : " + usbDevice.getVendorId());
                if ((!FMRadioService.this.mIsExternalChipset && FMRadioService.this.checkUsbExternalChipset(usbDevice)) || (FMRadioService.this.mIsExternalChipset && !FMRadioService.this.checkUsbExternalChipset(usbDevice))) {
                    FMRadioService.log("Earphone is not compatible");
                    return;
                }
                if ((usbDevice.getVendorId() != 1256 || (usbDevice.getProductId() != 41035 && usbDevice.getProductId() != 41036 && usbDevice.getProductId() != 41015 && usbDevice.getProductId() != 41039 && usbDevice.getProductId() != 41044 && usbDevice.getProductId() != 41041 && usbDevice.getProductId() != 41047 && usbDevice.getProductId() != 41055 && usbDevice.getProductId() != 41051 && usbDevice.getProductId() != 41049 && usbDevice.getProductId() != 41054)) && ((usbDevice.getProductId() != 5268 || usbDevice.getVendorId() != 1739) && (!FMRadioService.isFactoryBinary || usbDevice.getVendorId() != 1065 || (usbDevice.getProductId() != 294 && usbDevice.getProductId() != 298)))) {
                    if (usbDevice.getVendorId() != 48727) {
                        return;
                    }
                    if (usbDevice.getProductId() != 257 && usbDevice.getProductId() != 527) {
                        return;
                    }
                }
                FMRadioService.log("mReceiver: ACTION_USB_HEADSET");
                FMRadioService.this.mIsHeadsetPlugged = intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_ATTACHED);
                if (!FMRadioService.this.mIsTestMode) {
                    if (!FMRadioService.this.mIsExternalChipset) {
                        if (!FMRadioService.this.mIsHeadsetPlugged) {
                            int tvstatus = Settings.System.getInt(FMRadioService.this.mContext.getContentResolver(), "tv_out", 0);
                            FMRadioService.log("TV out setting value :" + tvstatus);
                            if (tvstatus != 1) {
                                if (FMRadioService.this.volumeLock) {
                                    try {
                                        FMRadioService.this.notifyRecFinish();
                                        FMRadioService.this.mRecFinishNotified = true;
                                        Thread.sleep(50L);
                                    } catch (InterruptedException e) {
                                        Log.e("FMRadioService", "InterruptedException in sleep() : " + e);
                                    }
                                }
                                FMRadioService fMRadioService = FMRadioService.this;
                                fMRadioService.mBikeMode = Settings.Secure.getInt(fMRadioService.mContext.getContentResolver(), AudioConstants.SETTING_BIKE_MODE, 0) == 1;
                                FMRadioService.log("mReceiver: bike mode check : " + FMRadioService.this.mBikeMode);
                                if (!FMRadioService.this.mBikeMode) {
                                    FMRadioService.this.notifyEvent(9, null);
                                }
                                if (FMRadioService.this.mIsOn) {
                                    FMRadioService.this.stopInternetStreaming();
                                    FMRadioService.this.cancelSeek();
                                    FMRadioService.this.offInternal(2, true);
                                    return;
                                }
                                FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
                                boolean unused = FMRadioService.mIsTransientPaused = false;
                                return;
                            }
                            return;
                        }
                        FMRadioService.this.notifyEvent(8, null);
                        return;
                    }
                    FMRadioService.log("mIsExternalChipset " + FMRadioService.this.mIsExternalChipset + " mIsHeadsetPlug " + FMRadioService.this.mIsHeadsetPlugged);
                    if (FMRadioService.this.mIsHeadsetPlugged) {
                        FMRadioService.this.mPlayerExternalChipset.init(usbDevice);
                        FMRadioService.this.notifyEvent(8, null);
                        return;
                    } else if (FMRadioService.this.mIsOn) {
                        FMRadioService fMRadioService2 = FMRadioService.this;
                        if (Settings.Secure.getInt(fMRadioService2.mContext.getContentResolver(), AudioConstants.SETTING_BIKE_MODE, 0) == 1) {
                            z = true;
                        }
                        fMRadioService2.mBikeMode = z;
                        FMRadioService.log("mReceiver: bike mode check : " + FMRadioService.this.mBikeMode);
                        if (!FMRadioService.this.mBikeMode) {
                            FMRadioService.this.notifyEvent(9, null);
                        }
                        FMRadioService.this.mPlayerExternalChipset.init(null);
                        FMRadioService.this.cancelSeek();
                        FMRadioService.this.offInternal(2, true);
                        return;
                    } else {
                        return;
                    }
                }
                FMRadioService fMRadioService3 = FMRadioService.this;
                fMRadioService3.setSpeakerOn(!fMRadioService3.mIsHeadsetPlugged);
                StringBuilder sb = new StringBuilder();
                sb.append("TestMode :- making setRadioSpeakerOn:");
                sb.append(!FMRadioService.this.mIsHeadsetPlugged);
                FMRadioService.log(sb.toString());
            } else if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG") || FMRadioService.this.mIsExternalChipset) {
                if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
                    FMRadioService.log("mReceiver: ACTION_AIRPLANE_MODE_CHANGED");
                    FMRadioService fMRadioService4 = FMRadioService.this;
                    if (Settings.Global.getInt(fMRadioService4.mContext.getContentResolver(), "airplane_mode_on", 0) != 0) {
                        z = true;
                    }
                    fMRadioService4.mAirPlaneEnabled = z;
                    FMRadioService.log("mAirPlaneEnabled flag :" + FMRadioService.this.mAirPlaneEnabled);
                    if (FMRadioService.this.mAirPlaneEnabled && FMRadioService.this.mIsOn) {
                        FMRadioService.this.stopInternetStreaming();
                        FMRadioService.this.offInternal(3, true);
                    }
                } else if (intent.getAction().equals(WindowManagerPolicyConstants.ACTION_HDMI_PLUGGED)) {
                    FMRadioService.log("mReceiver: ACTION_HDMI_PLUGGED");
                    if (FMRadioService.DEBUGGABLE) {
                        FMRadioService.log("==> intent: " + intent);
                    }
                    FMRadioService.log("   state: " + intent.getBooleanExtra("state", false));
                    if (!FMRadioService.this.mIsTestMode) {
                        FMRadioService.this.mIsTvOutPlugged = intent.getBooleanExtra("state", false);
                        if (FMRadioService.this.mIsTvOutPlugged && FMRadioService.this.mIsOn) {
                            FMRadioService.this.stopInternetStreaming();
                            FMRadioService.this.cancelSeek();
                            FMRadioService.this.offInternal(10, true);
                        }
                    }
                } else if (intent.getAction().equals(FMRadioService.ACTION_SAVE_FMRECORDING_ONLY) || intent.getAction().equals(FMRadioService.ACTION_CAMERA_START)) {
                    FMRadioService.log("mReceiver: ACTION_SAVE_FMRECORDING_ONLY ");
                    if (FMRadioService.this.isRecording) {
                        FMRadioService.log("mReceiver: Stop recording for Camera ");
                        FMRadioService.this.notifyRecFinish();
                    }
                } else if (intent.getAction().equals("android.intent.action.USER_SWITCHED")) {
                    FMRadioService.log("mReceiver: KNOX_MODE_USER_SWITCH - fmradio off");
                    if (FMRadioService.this.mIsOn) {
                        FMRadioService.this.stopInternetStreaming();
                        FMRadioService.this.cancelSeek();
                        FMRadioService.this.offInternal(4, true);
                    }
                }
            } else {
                FMRadioService.log("mReceiver: ACTION_HEADSET_PLUG");
                FMRadioService.log("==> intent: " + intent);
                FMRadioService.log("   state: " + intent.getIntExtra("state", 0));
                FMRadioService.log("    name: " + intent.getStringExtra("name"));
                FMRadioService.log("    portName: " + intent.getStringExtra("portName"));
                if (!FMRadioService.this.mIsExternalChipset && intent.hasExtra("portName") && intent.getStringExtra("portName").contains("USB")) {
                    if (!FMRadioService.this.mIsHeadsetPlugged && SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_AUDIO_CONFIG_FMRADIO_EXTERNAL_DEVICE").contains("USB")) {
                        FMRadioService.this.checkUSBDeviceConnected(context);
                        if (!FMRadioService.this.mIsHeadsetPlugged) {
                            FMRadioService.log("USB earphone is not compatible.");
                            return;
                        }
                        FMRadioService.this.notifyEvent(8, null);
                    } else {
                        return;
                    }
                }
                if (intent.hasExtra("portName") && !intent.getStringExtra("portName").equals(AudioConstants.H2W) && !SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_AUDIO_CONFIG_FMRADIO_EXTERNAL_DEVICE").contains("USB")) {
                    FMRadioService.log("Not 3.5pi type, and audio not support play FM Radio via usb type c");
                    return;
                }
                boolean isMicrophoneEvent = intent.getIntExtra("microphone", 0) == 1;
                if (!isMicrophoneEvent) {
                    FMRadioService.this.mIsEarphoneConnected = intent.getIntExtra("state", 0) == 1;
                } else {
                    FMRadioService.this.mIsMicrophoneConnected = intent.getIntExtra("state", 0) == 1;
                }
                FMRadioService fMRadioService5 = FMRadioService.this;
                fMRadioService5.mIsHeadsetPlugged = fMRadioService5.mIsMicrophoneConnected || FMRadioService.this.mIsEarphoneConnected;
                if (!FMRadioService.this.mIsTestMode) {
                    if (!FMRadioService.this.mIsHeadsetPlugged) {
                        int tvstatus2 = Settings.System.getInt(FMRadioService.this.mContext.getContentResolver(), "tv_out", 0);
                        FMRadioService.log("TV out setting value :" + tvstatus2);
                        if (tvstatus2 != 1) {
                            if (FMRadioService.this.volumeLock) {
                                FMRadioService.this.notifyRecFinish();
                            }
                            FMRadioService fMRadioService6 = FMRadioService.this;
                            fMRadioService6.mBikeMode = Settings.Secure.getInt(fMRadioService6.mContext.getContentResolver(), AudioConstants.SETTING_BIKE_MODE, 0) == 1;
                            FMRadioService.log("mReceiver: bike mode check : " + FMRadioService.this.mBikeMode);
                            if (!FMRadioService.this.mBikeMode) {
                                FMRadioService.this.notifyEvent(9, null);
                            }
                            if (FMRadioService.this.mIsOn) {
                                FMRadioService.this.stopInternetStreaming();
                                FMRadioService.this.cancelSeek();
                                FMRadioService.this.offInternal(2, true);
                                return;
                            }
                            FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
                            boolean unused2 = FMRadioService.mIsTransientPaused = false;
                            return;
                        }
                        return;
                    }
                    FMRadioService.this.notifyEvent(8, null);
                    return;
                }
                FMRadioService fMRadioService7 = FMRadioService.this;
                fMRadioService7.setSpeakerOn(!fMRadioService7.mIsHeadsetPlugged);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TestMode :- making setRadioSpeakerOn:");
                sb2.append(!FMRadioService.this.mIsHeadsetPlugged);
                FMRadioService.log(sb2.toString());
            }
        }
    };
    private BroadcastReceiver mButtonReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {
                boolean isFromBT = intent.getBooleanExtra("android.bluetooth.a2dp.extra.DISCONNECT_A2DP", false);
                FMRadioService.log("ACTION_AUDIO_BECOMING_NOISE , Its from BT :" + isFromBT);
                boolean isFromDock = intent.getBooleanExtra("DISCONNECT_DOCK", false);
                FMRadioService.log("ACTION_AUDIO_BECOMING_NOISE , Its from Dock :" + isFromDock);
                if (FMRadioService.this.mIsOn && !FMRadioService.this.mIsTestMode && !isFromBT && !isFromDock) {
                    if (FMRadioService.this.volumeLock) {
                        FMRadioService.this.notifyRecFinish();
                    }
                    FMRadioService.this.notifyEvent(9, null);
                    FMRadioService.this.stopInternetStreaming();
                    if (FMRadioService.this.mIsExternalChipset) {
                        FMRadioService.this.mPlayerExternalChipset.init(null);
                    }
                    FMRadioService.this.cancelSeek();
                    FMRadioService.this.offInternal(2, true);
                }
            }
        }
    };
    private BroadcastReceiver mResetSettingReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(FMRadioService.RESET_SETTING)) {
                FMRadioService.log("ACTION_RESET_SETTING");
                off();
            }
        }

        private void off() {
            if (FMRadioService.this.mIsOn) {
                FMRadioService.log("reset setting : stop FM");
                FMRadioService.this.stopInternetStreaming();
                FMRadioService.this.cancelSeek();
                FMRadioService.this.offInternal(6, true);
                return;
            }
            FMRadioService.log("reset setting : remove audiofocus: FM");
            FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
        }
    };
    private PhoneStateListener mPhoneListener = new PhoneStateListener(null, Looper.getMainLooper()) { // from class: com.android.server.FMRadioService.6
        private boolean mIsPhoneCallRinging = false;

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String incomingNumber) {
            FMRadioService.log("phone state : " + state + " mNeedToResumeFM: " + FMRadioService.mNeedToResumeFM + " mIsPhoneCallRinging : " + this.mIsPhoneCallRinging + " mNeedResumeToFreq : " + FMRadioService.this.mNeedResumeToFreq + " mIsForcestop : " + FMRadioService.this.mIsForcestop);
            if (state == 0) {
                if (FMRadioService.mNeedToResumeFM && !FMRadioService.this.isOn() && FMRadioService.this.mNeedResumeToFreq != -2 && !FMRadioService.this.mIsForcestop && this.mIsPhoneCallRinging) {
                    if (FMRadioService.this.on(false)) {
                        int outputPath = FMRadioService.this.modSamsungGetRadioOutputPath();
                        FMRadioService.log("onCallStateChanged() :: CALL_STATE_IDLE setPath() = " + outputPath);
                        FMRadioService.this.modSamsungSetRadioOutputPath(outputPath);
                        
                        if (FMRadioService.mIsTransientPaused) {
                            FMRadioService fMRadioService = FMRadioService.this;
                            fMRadioService.mResumeVol = fMRadioService.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1));
                            FMRadioService.log("slowly increase the volume till :" + FMRadioService.this.mResumeVol);
                            if (FMRadioService.this.mResumeVol != 0) {
                                FMRadioService fMRadioService2 = FMRadioService.this;
                                fMRadioService2.mCurrentResumeVol = fMRadioService2.mResumeVol;
                                if (FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
                                    FMRadioService.this.setVolume(1L);
                                    FMRadioService.this.mHandler.removeMessages(200);
                                    FMRadioService.this.mHandler.sendEmptyMessageDelayed(200, 100L);
                                } else {
                                    FMRadioService fMRadioService3 = FMRadioService.this;
                                    fMRadioService3.setVolume(fMRadioService3.mResumeVol);
                                }
                            } else {
                                FMRadioService.this.mAudioManager.setStreamVolume(AudioManager.modSamsungGetStreamType(1), (int) FMRadioService.this.mResumeVol, 0);
                            }
                            boolean unused = FMRadioService.mIsTransientPaused = false;
                        } else {
                            FMRadioService.this.mAudioManager.setStreamVolume(AudioManager.modSamsungGetStreamType(1), FMRadioService.this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)), 0);
                        }
                        if (FMRadioService.this.mNeedResumeToFreq <= 0) {
                            FMRadioService.this.mNeedResumeToFreq = 87500L;
                        }
                        if (FMRadioService.this.mIsExternalChipset) {
                            int freqExt = ((int) FMRadioService.this.mNeedResumeToFreq) / 10;
                            FMRadioService.this.mPlayerExternalChipset.tune(freqExt);
                        } else {
                            FMRadioService.this.mPlayerNative.tune(FMRadioService.this.mNeedResumeToFreq);
                        }
                        FMRadioService.log("tune from CALL_STATE_IDLE");
                        FMRadioService fMRadioService4 = FMRadioService.this;
                        fMRadioService4.notifyEvent(7, Long.valueOf(fMRadioService4.mNeedResumeToFreq));
                        FMRadioService.this.mNeedResumeToFreq = -2L;
                    } else {
                        FMRadioService.log("Not able to resume FM player");
                    }
                }
                boolean unused2 = FMRadioService.mNeedToResumeFM = false;
                this.mIsPhoneCallRinging = false;
            } else if (state == 1) {
                this.mIsPhoneCallRinging = true;
            }
        }
    };
    private BroadcastReceiver mMusicCommandRec = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String cmdStr = intent.getStringExtra("command");
            String appName = intent.getStringExtra("from");
            if (FMRadioService.DEBUGGABLE) {
                FMRadioService.log("Got Music command :" + cmdStr + " from:" + appName);
            }
            if (!"com.sec.android.app.fm".equals(appName)) {
                if ("stop".equals(cmdStr) || "pause".equals(cmdStr)) {
                    FMRadioService.this.offInternal(11, true);
                }
            }
        }
    };
    public boolean mIsMDMSpeakerEnabled = false;
    private final BroadcastReceiver mMDMSpeakerEnabled = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundle;
            String action = intent.getAction();
            FMRadioService.log("*** mMDMSpeakerEnabled: ACTION  - " + intent.getAction());
            if (action.equals(FMRadioService.MDM_SPEAKER_ENABLED) && (bundle = intent.getExtras()) != null) {
                FMRadioService.this.mIsMDMSpeakerEnabled = ((Boolean) bundle.get("state")).booleanValue();
            }
        }
    };
    final Handler mAudioFocusHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.server.FMRadioService.9
        public static final int EVENT_AUDIOFOCUS_GAIN = 1;
        public static final int EVENT_AUDIOFOCUS_LOSS = -1;
        public static final int EVENT_AUDIOFOCUS_LOSS_TRANSIENT = -2;
        public static final int EVENT_AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
        private static final String TAG = "mAudioFocusHandler:";

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            FMRadioService.log("mAudioFocusHandler:mHandler(g.what=" + msg.what + ") is called");
            int i = msg.what;
            if (i == -3 || i == -2 || i == -1 || i == 1) {
                FMRadioService.log("mAudioFocusHandler:Fired  TIME = " + (SystemClock.uptimeMillis() / 1000));
                FMRadioService.this.responedFocusEvent(msg.what);
                FMRadioService.this.respondAudioFocusChangeForDns(msg.what);
            }
        }
    };
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.android.server.FMRadioService.10
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            FMRadioService.log("onAudioFocusChange : " + focusChange);
            if (FMRadioService.this.volumeLock && (focusChange == -1 || focusChange == -2)) {
                FMRadioService.this.mRecFinishNotified = true;
                FMRadioService.this.notifyEvent(17, null);
                FMRadioService.this.setDelay(100L);
            }
            if ((focusChange == -1 || focusChange == -2) && FMRadioServiceFeature.CHIP_VENDOR != 9 && !FMRadioService.this.mIsExternalChipset) {
                if (FMRadioService.this.FEATURE_INDIRECT_MODE) {
                    FMRadioService.this.mute(true);
                    FMRadioService.this.inDirectModeBroadcast();
                }
                if (FMRadioServiceFeature.CHIP_VENDOR == 2 || FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    FMRadioService.log("onAudioFocusChange : set mute");
                    FMRadioService.this.mute(true);
                    if (SystemProperties.get("ro.board.platform").equals("universal3830")) {
                        FMRadioService.log("set 100ms delay for only universal3830 chipset");
                        FMRadioService.this.setDelay(100L);
                    }
                }
                if (FMRadioServiceFeature.CHIP_VENDOR != 7) {
                    FMRadioService.this.setFMAudioPath(false);
                }
            }
            if (!FMRadioService.this.volumeLock && (focusChange == -1 || focusChange == -2)) {
                FMRadioService.log("OnAudioFocusChangeListener : mute FM before turn off");
                if (FMRadioService.this.mIsExternalChipset) {
                    FMRadioService.this.mPlayerExternalChipset.muteOn();
                }
                FMRadioService.this.mAudioManager.setParameters(FMRadioService.audioMute);
            }
            FMRadioService.this.clearMessageQueue();
            Message msg = Message.obtain();
            msg.what = focusChange;
            FMRadioService.this.mAudioFocusHandler.sendMessageAtFrontOfQueue(msg);
            if (FMRadioService.DEBUGGABLE) {
                FMRadioService.log("OnAudioFocusChangeListener switch off mAudioFocusListener :" + focusChange + " stored freq:" + FMRadioService.this.mNeedResumeToFreq);
            }
        }
    };
    final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.server.FMRadioService.11
        long currentVolume = 0;

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            FMRadioService.log("mHandler(g.what=" + msg.what + ") is called");
            if (msg.what == 200) {
                if (FMRadioService.this.mIsOn) {
                    if (this.currentVolume >= FMRadioService.this.mCurrentResumeVol) {
                        long j = FMRadioService.this.mResumeVol;
                        this.currentVolume = j;
                        FMRadioService.this.setVolume(j);
                        this.currentVolume = 0L;
                        return;
                    }
                    long j2 = this.currentVolume + 1;
                    this.currentVolume = j2;
                    FMRadioService.this.setVolume(j2);
                    FMRadioService.this.queueUpdate(200, 100L);
                    return;
                }
                this.currentVolume = 0L;
            }
        }
    };
    private final BroadcastReceiver mSystemReceiver1 = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.12
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Boolean extraDontKillApp = Boolean.valueOf(intent.getBooleanExtra(Intent.EXTRA_DONT_KILL_APP, false));
            Uri uri = intent.getData();
            String packageName = uri.getSchemeSpecificPart();
            if (action.equals("android.intent.action.PACKAGE_REMOVED") || action.equals(Intent.ACTION_PACKAGE_RESTARTED) || (SemEmergencyManager.isEmergencyMode(context) && FMRadioService.this.mIsOn && action.equals(Intent.ACTION_PACKAGE_CHANGED) && !extraDontKillApp.booleanValue())) {
                if (!"com.sec.android.app.fm".equals(packageName)) {
                    if (SemCscFeature.getInstance().getBoolean("CscFeature_Common_SupportSamsungFMRadioLib")) {
                        if (!FMRadioService.JAPANRADIO_APP_NAME.equals(packageName) && !FMRadioService.JAPANRADIO_TUNER_NAME.equals(packageName)) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                FMRadioService.this.mIsForcestop = true;
                FMRadioService.this.mIsAudioFocusAlive = false;
                off();
                if (FMRadioService.this.volumeLock) {
                    FMRadioService.this.volumeLock = false;
                    FMRadioService.this.releaseAudioSystemMute();
                }
            } else if (action.equals(Intent.ACTION_PACKAGE_CHANGED) && !FMRadioService.this.mIsOn && FMRadioService.this.mIsAudioFocusAlive && SemEmergencyManager.isEmergencyMode(context)) {
                if (!"com.sec.android.app.fm".equals(packageName)) {
                    if (SemCscFeature.getInstance().getBoolean("CscFeature_Common_SupportSamsungFMRadioLib")) {
                        if (!FMRadioService.JAPANRADIO_APP_NAME.equals(packageName) && !FMRadioService.JAPANRADIO_TUNER_NAME.equals(packageName)) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
                FMRadioService.this.mIsAudioFocusAlive = false;
            }
        }

        private void off() {
            if (FMRadioService.this.mIsOn) {
                FMRadioService.log("mSystemReceiver1 force stop : making off FM");
                FMRadioService.this.stopInternetStreaming();
                FMRadioService.this.cancelSeek();
                FMRadioService.this.offInternal(6, true);
                return;
            }
            FMRadioService.log("mSystemReceiver1 : remove audiofocus");
            FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
        }
    };
    private final BroadcastReceiver mSystemReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.13
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.ACTION_SHUTDOWN")) {
                off();
            }
        }

        private void off() {
            if (FMRadioService.this.mIsOn) {
                FMRadioService.log("Powering off : stop FM");
                FMRadioService.this.stopInternetStreaming();
                FMRadioService.this.cancelSeek();
                FMRadioService.this.offInternal(6, true);
                return;
            }
            FMRadioService.log("Powering off : remove audiofocus: FM");
            FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
        }
    };
    private final BroadcastReceiver mLowBatteryReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.14
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            FMRadioService.log("FMRadioService:mLowBatteryReceiver " + action);
            FMRadioService.log("Low batteryWarning Level :1");
            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int battStatus = intent.getIntExtra("status", 1);
                int battScale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
                int battLevel = intent.getIntExtra("level", battScale);
                FMRadioService.log("Level = " + battLevel + "/" + battScale);
                StringBuilder sb = new StringBuilder();
                sb.append("Status = ");
                sb.append(battStatus);
                FMRadioService.log(sb.toString());
                if (battLevel > 1 || battStatus == 2) {
                    FMRadioService.this.mIsBatteryLow = false;
                    return;
                }
                FMRadioService.this.mIsBatteryLow = true;
                if (FMRadioService.this.mIsOn) {
                    FMRadioService.this.stopInternetStreaming();
                    FMRadioService.this.offInternal(7, true);
                }
            }
        }
    };
    private final BroadcastReceiver mSetPropertyReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.15
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            FMRadioService.log("mSetPropertyReceiver : action is " + action);
            if ("com.sec.android.app.fm.set_property".equals(action)) {
                String key = intent.getStringExtra("key");
                int value = intent.getIntExtra("value", 0);
                if (FMRadioService.DEBUGGABLE) {
                    FMRadioService.log("mSetPropertyReceiver :: " + key + "=" + value);
                }
                if (key.startsWith("service.brcm.fm") || key.startsWith("service.mrvl.fm")) {
                    SystemProperties.set(key, String.valueOf(value));
                }
            } else if ("com.sec.android.app.fm.set_volume".equals(action)) {
                String key2 = intent.getStringExtra("key");
                String volumetable = intent.getStringExtra("volumetable");
                if (FMRadioService.DEBUGGABLE) {
                    FMRadioService.log("mSetPropertyReceiver :: " + key2 + "=" + volumetable);
                }
                if (FMRadioService.this.VolumePropertyname.equals(key2)) {
                    SystemProperties.set(key2, volumetable);
                }
            }
        }
    };
    private final BroadcastReceiver mAllSoundOffReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.16
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int AllSoundOff = intent.getIntExtra("mute", 0);
            FMRadioService.log("mAllSoundOffReceiver :: " + AllSoundOff);
            if (AllSoundOff == 1) {
                FMRadioService.log("FM chip mute");
                FMRadioService.this.mute(true);
                if (FMRadioService.this.volumeLock) {
                    FMRadioService.this.notifyRecFinish();
                }
            } else if (!FMRadioService.this.isDNDEnable()) {
                FMRadioService.log("FM chip unmute");
                FMRadioService.this.mute(false);
            }
        }
    };
    private final BroadcastReceiver mDNDStatusReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.17
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int volume;
            if (!FMRadioService.this.isDNDEnable()) {
                if (FMRadioService.this.mIsMute && !FMRadioService.this.isAllSoundOff()) {
                    FMRadioService.this.mute(false);
                    if (FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME && (volume = FMRadioService.this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1))) != 0) {
                        FMRadioService.this.setVolume(volume);
                    }
                    FMRadioService.log("mDNDStatusReceiver onReceive : DND Disable ");
                    return;
                }
                return;
            }
            FMRadioService.log("mDNDStatusReceiver onReceive : DND Enable");
            if (FMRadioService.this.volumeLock) {
                FMRadioService.this.notifyRecFinish();
            }
            FMRadioService.this.mute(true);
        }
    };
    private final BroadcastReceiver mAlarmReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.18
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FMRadioService.log("Alarm onReceive");
            String cmdStr = intent.getStringExtra("command");
            if ("TTSstart".equals(cmdStr)) {
                FMRadioService.log("TTSstart play");
                FMRadioService.this.alarmTTSPlay = true;
            }
            if ("TTSstop".equals(cmdStr)) {
                FMRadioService.log("TTSstop play");
                FMRadioService.this.alarmTTSPlay = false;
            }
        }
    };
    private final BroadcastReceiver mEmergencyReceiver = new BroadcastReceiver() { // from class: com.android.server.FMRadioService.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int reason = intent.getIntExtra("reason", 0);
            FMRadioService.log("mEmergencyReceiver onReceive : reason- " + reason);
            if (!FMRadioService.this.mIsOn || (reason != 2 && reason != 3 && reason != 4 && reason != 5)) {
                if (FMRadioService.this.mIsOn) {
                    return;
                }
                if (reason == 2 || reason == 4) {
                    FMRadioService.this.mIsForcestop = true;
                    FMRadioService.this.mIsAudioFocusAlive = false;
                    FMRadioService.log("force stop : remove audiofocus");
                    FMRadioService.this.mAudioManager.abandonAudioFocus(FMRadioService.this.mAudioFocusListener);
                    return;
                }
                return;
            }
            FMRadioService.log("mReceiver: EMERGENCY_STATE_CHANGED - fmradio off");
            FMRadioService.this.stopInternetStreaming();
            FMRadioService.this.cancelSeek();
            FMRadioService.this.offInternal(4, true);
        }
    };
    private Thread mScanThread = null;
    private boolean mInternetStreamingMode = false;
    private boolean mWaitPidDuringScanning = false;
    private ContentObserver bmObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.android.server.FMRadioService.20
        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            FMRadioService.log("bike mode onChange");
            FMRadioService.this.handleBikeMode();
        }
    };

    static {
        boolean z = true;
        if (0 != 1) {
            z = false;
        }
        DEBUGGABLE = z;
        isFactoryBinary = true;
        curFreq = -1L;
        mIsTransientPaused = false;
        mNeedToResumeFM = false;
        mFMRadioServiceLock = new Object();
    }

    public static int modSamsungGetStreamType(int samsung_stream) {
        return AudioManager.modSamsungGetStreamType(samsung_stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAvrcpMode() {
        int type = this.modSamsungGetRadioOutputPath();
        boolean z = Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_avc_mode", 1) == 1;
        this.mAvrcpMode = z;
        if (type == 8) {
            if (z && FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
                log("Avrcp mode enabled!!!");
                if (!this.volumeLock) {
                    this.mPlayerNative.setVolume(15L);
                    return;
                }
                return;
            }
            log("Avrcp mode disabled");
            if (!this.volumeLock) {
                int current_stream_volume = this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1));
                log("current_stream_volume: " + current_stream_volume);
                setVolume((long) current_stream_volume);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUsbExternalChipset(UsbDevice usbDevice) {
        if (usbDevice.getVendorId() == 1256) {
            if (usbDevice.getProductId() == 41044 || usbDevice.getProductId() == 41049 || usbDevice.getProductId() == 41051 || usbDevice.getProductId() == 41054) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean checkValidUsbEarphone(UsbDevice usbDevice) {
        if (usbDevice.getVendorId() != 1256 || (usbDevice.getProductId() != 41035 && usbDevice.getProductId() != 41036 && usbDevice.getProductId() != 41015 && usbDevice.getProductId() != 41039 && usbDevice.getProductId() != 41044 && usbDevice.getProductId() != 41041 && usbDevice.getProductId() != 41047 && usbDevice.getProductId() != 41055)) {
            if (usbDevice.getProductId() != 5268 || usbDevice.getVendorId() != 1739) {
                if (!isFactoryBinary || usbDevice.getVendorId() != 1065 || (usbDevice.getProductId() != 294 && usbDevice.getProductId() != 298)) {
                    if (usbDevice.getVendorId() != 48727) {
                        return false;
                    }
                    if (usbDevice.getProductId() == 257 || usbDevice.getProductId() == 527) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUSBDeviceConnected(Context context) {
        log("checkUSBDeviceConnected");
        try {
            UsbManager mUsbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
            if (mUsbManager == null) {
                log("mUsbManager null");
                return;
            }
            Map<String, UsbDevice> devices = mUsbManager.getDeviceList();
            if (devices == null) {
                log("USB Device null");
                return;
            }
            for (UsbDevice usbDevice : devices.values()) {
                log("Headset getProductId : " + usbDevice.getProductId());
                log("Headset getVendorId : " + usbDevice.getVendorId());
                if (this.mIsExternalChipset && checkUsbExternalChipset(usbDevice)) {
                    this.mIsHeadsetPlugged = true;
                    this.mPlayerExternalChipset.init(usbDevice);
                } else if (!this.mIsExternalChipset && checkValidUsbEarphone(usbDevice)) {
                    this.mIsHeadsetPlugged = true;
                }
            }
        } catch (NullPointerException e) {
            Log.e("FMRadioService", "NullPointerException in checkUSBDeviceConnected() : " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageQueue() {
        this.mAudioFocusHandler.removeMessages(-1);
        this.mAudioFocusHandler.removeMessages(-2);
        this.mAudioFocusHandler.removeMessages(-3);
        this.mAudioFocusHandler.removeMessages(1);
        this.mHandler.removeMessages(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternetStreaming() {
        log("stopInternetStreaming() - streamingMode:" + this.mInternetStreamingMode);
        if (FMRadioServiceFeature.FEATURE_DISABLEDNS) {
            return;
        }
        try {
            this.mContext.sendBroadcast(new Intent(ACTION_DNS_STOP_INTERNET_STREAM));
            Thread.sleep(150L);
        } catch (InterruptedException e) {
            Log.e("FMRadioService", "InterruptedException in stopInternetStreaming() : " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void respondAudioFocusChangeForDns(int focusChange) {
        log("respondAudioFocusChangeForDns()-focusChange:" + focusChange + " streamingMode:" + this.mInternetStreamingMode);
        if (!this.mInternetStreamingMode) {
            return;
        }
        String action = null;
        if (focusChange == -3 || focusChange == -2) {
            action = ACTION_DNS_PAUSE_INTERNET_STREAM;
        } else if (focusChange == -1) {
            action = ACTION_DNS_STOP_INTERNET_STREAM;
        } else if (focusChange == 1) {
            action = ACTION_DNS_RESUME_INTERNET_STREAM;
        }
        this.mContext.sendBroadcast(new Intent(action));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responedFocusEvent(int focusEvent) {
        if (focusEvent == -3) {
            if (isOn()) {
                if (this.volumeLock) {
                    log("AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK - recoding O");
                    return;
                }
                log("AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK - recoding X");
                if (this.mScanProgress) {
                    this.mNeedResumeToFreq = this.mScanFreq;
                } else if (this.mIsSeeking) {
                    this.mNeedResumeToFreq = curFreq;
                } else {
                    this.mNeedResumeToFreq = getCurrentChannel();
                }
                this.mIsTransientDuck = true;
                mute(true);
                respondAudioFocusChangeForDns(focusEvent);
            }
        } else if (focusEvent == -2) {
            log("AUDIOFOCUS_LOSS_TRANSIENT ");
            if (isOn()) {
                if (this.mScanProgress) {
                    if (this.mIsExternalChipset) {
                        cancelScan();
                    }
                    this.mNeedResumeToFreq = this.mScanFreq;
                } else if (this.mIsSeeking) {
                    if (this.mIsExternalChipset) {
                        cancelSeek();
                    }
                    this.mNeedResumeToFreq = curFreq;
                } else {
                    this.mNeedResumeToFreq = getCurrentChannel();
                }
                offInternal(11, false);
                respondAudioFocusChangeForDns(focusEvent);
            } else if (this.mOnProgress) {
                log("still FM on in progress");
                this.mAudioFocusHandler.removeMessages(focusEvent);
                this.mAudioFocusHandler.sendEmptyMessage(focusEvent);
            }
            mNeedToResumeFM = false;
        } else if (focusEvent == -1) {
            log("AUDIOFOCUS_LOSS ");
            if (isOn()) {
                if (this.mScanProgress) {
                    if (this.mIsExternalChipset) {
                        cancelScan();
                    }
                    this.mNeedResumeToFreq = this.mScanFreq;
                } else if (this.mIsSeeking) {
                    if (this.mIsExternalChipset) {
                        cancelSeek();
                    }
                    this.mNeedResumeToFreq = curFreq;
                } else {
                    this.mNeedResumeToFreq = getCurrentChannel();
                }
                respondAudioFocusChangeForDns(focusEvent);
                offInternal(0, true);
            } else if (this.mOnProgress) {
                log("still FM on in progress");
                this.mAudioFocusHandler.removeMessages(focusEvent);
                this.mAudioFocusHandler.sendEmptyMessage(focusEvent);
            }
        } else if (focusEvent == 1) {
            log("AUDIOFOCUS_GAIN ");
            if (this.mIsExternalChipset) {
                setDelay(700L);
            }
            if (isOn() && this.mIsTransientDuck) {
                mute(false);
            }
            this.mIsTransientDuck = false;
            if (!isOn() && this.mNeedResumeToFreq != -2 && !this.mIsForcestop) {
                respondAudioFocusChangeForDns(focusEvent);
                if (on(false)) {
                    if (mIsTransientPaused) {
                        this.mResumeVol = this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1));
                        log("slowly increase the volume till :" + this.mResumeVol);
                        long j = this.mResumeVol;
                        if (j != 0) {
                            this.mCurrentResumeVol = j;
                            if (FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
                                if (!this.mIsExternalChipset) {
                                    setVolume(0L);
                                    this.mHandler.removeMessages(200);
                                    this.mHandler.sendEmptyMessageDelayed(200, 800L);
                                }
                            } else {
                                setVolume(this.mResumeVol);
                            }
                        } else {
                            this.mAudioManager.setStreamVolume(AudioManager.modSamsungGetStreamType(1), (int) this.mResumeVol, 0);
                        }
                        mIsTransientPaused = false;
                    } else {
                        this.mAudioManager.setStreamVolume(AudioManager.modSamsungGetStreamType(1), this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)), 0);
                    }
                    if (this.mNeedResumeToFreq <= 0) {
                        this.mNeedResumeToFreq = 87500L;
                    }
                    if (this.mIsExternalChipset) {
                        int freqExt = ((int) this.mNeedResumeToFreq) / 10;
                        this.mPlayerExternalChipset.tune(freqExt);
                        if (isUnMuteRadio()) {
                            mute(false);
                        } else {
                            mute(true);
                        }
                    } else {
                        this.mPlayerNative.tune(this.mNeedResumeToFreq);
                    }
                    notifyEvent(7, Long.valueOf(this.mNeedResumeToFreq));
                    this.mNeedResumeToFreq = -2L;
                } else if (!mNeedToResumeFM) {
                    log("Not able to resume FM player");
                    this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
                }
            } else if (this.mOffProgress) {
                log("still FM off in progress");
                this.mAudioFocusHandler.removeMessages(focusEvent);
                this.mAudioFocusHandler.sendEmptyMessage(focusEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inDirectModeBroadcast() {
        log("Broadcast audio focus loss intent");
        Intent intent = new Intent();
        intent.setAction("inDirect.mode.audioFocusLoss");
        intent.setClassName("com.sec.android.app.fm", "com.sec.android.app.fm.receiver.AudioFocusLossReceiver");
        this.mContext.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAudioSystemMute() {
        log("releaseAudioSystemMute ");
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            int ringermode = audioManager.getRingerMode();
            if (ringermode == 2 && this.mAudioManager.isStreamMute(1) && this.mAudioManager.isStreamMute(5)) {
                this.mAudioManager.adjustStreamVolume(1, 100, 0);
                this.mAudioManager.adjustStreamVolume(5, 100, 0);
            }
        }
    }

    private void registerDNDStatusChangedListener() {
        IntentFilter intentDNDFilter = new IntentFilter();
        intentDNDFilter.addAction(NotificationManager.ACTION_INTERRUPTION_FILTER_CHANGED);
        intentDNDFilter.addAction(NotificationManager.ACTION_NOTIFICATION_POLICY_CHANGED);
        this.mContext.registerReceiver(this.mDNDStatusReceiver, intentDNDFilter);
        log("registering DND Status change Listener");
    }

    private void unregisterDNDStatusChangedListener() {
        log("Unregistering DND Status change listner");
        this.mContext.unregisterReceiver(this.mDNDStatusReceiver);
    }

    private void registerAllSoundOffListener() {
        IntentFilter intentAllSoundOffFilter = new IntentFilter();
        intentAllSoundOffFilter.addAction("android.settings.ALL_SOUND_MUTE");
        this.mContext.registerReceiver(this.mAllSoundOffReceiver, intentAllSoundOffFilter);
        log("registering AllSoundOff listener");
    }

    private void unregisterAllSoundOffListener() {
        log("Unregistering AllSoundOff listener");
        this.mContext.unregisterReceiver(this.mAllSoundOffReceiver);
    }

    private void registerAlarmListener() {
        IntentFilter intentAlarmFilter = new IntentFilter();
        intentAlarmFilter.addAction(ACTINON_ALARM_PLAY);
        this.mContext.registerReceiver(this.mAlarmReceiver, intentAlarmFilter);
        log("registering Alarm play listener");
    }

    private void unregisterAlarmListener() {
        log("Unregistering Alarm play listener");
        this.mContext.unregisterReceiver(this.mAlarmReceiver);
    }

    private void registerBikeModeObserver() {
        log("register bike mode observer");
        boolean z = false;
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor(AudioConstants.SETTING_BIKE_MODE), false, this.bmObserver);
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), AudioConstants.SETTING_BIKE_MODE, 0) == 1) {
            z = true;
        }
        this.mBikeMode = z;
    }

    private void unregisterBikeModeObserver() {
        log("unregister bike mode observer");
        this.mContext.getContentResolver().unregisterContentObserver(this.bmObserver);
    }

    private void registerAvrcpModeObserver() {
        log("register avrcp mode observer");
        boolean z = false;
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("bluetooth_avc_mode"), false, this.mAvrcpObserver);
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_avc_mode", 1) == 1) {
            z = true;
        }
        this.mAvrcpMode = z;
    }

    private void unregisterAvrcpModeObserver() {
        log("unregister avrcp mode observer");
        this.mContext.getContentResolver().unregisterContentObserver(this.mAvrcpObserver);
    }

    private void registerEmergencyStateChangedListener() {
        // IntentFilter intentEmergencyFilter = new IntentFilter();
        // intentEmergencyFilter.addAction(SemEmergencyConstants.EMERGENCY_STATE_CHANGED);
        // this.mContext.registerReceiver(this.mEmergencyReceiver, intentEmergencyFilter);
        log("registering Emergency State Changed Listener");
    }

    private void unregisterEmegencyStateChangedListener() {
        log("Unregistering Emergency State Changed Listener");
        // this.mContext.unregisterReceiver(this.mEmergencyReceiver);
    }

    private void readTuningParameters() {
        if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
            String productName = getPropertyProductName();
            if (productName.startsWith("zerolte")) {
                SystemProperties.set("service.brcm.fm.start_snr", Integer.toString(34));
                SystemProperties.set("service.brcm.fm.set_blndmute", "1");
            } else if (productName.startsWith("j2lte")) {
                SystemProperties.set("service.brcm.fm.start_mute", Integer.toString(4));
            }
        }
        String start_mute = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_BROADCOM_START_MUTE");
        if (!"".equals(start_mute)) {
            SystemProperties.set("service.brcm.fm.start_mute", start_mute);
        }
        String start_snr = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_BROADCOM_START_SNR");
        if (!"".equals(start_snr)) {
            SystemProperties.set("service.brcm.fm.start_snr", start_snr);
            SystemProperties.set("service.brcm.fm.set_blndmute", "1");
        }
        if ("".equals(FMRadioServiceFeature.FEATURE_SETLOCALTUNNING)) {
            if (FMRadioServiceFeature.CHIP_VENDOR == 1) {
                this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                this.mSnr_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR"));
                this.mCnt_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS"));
                return;
            } else if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                this.mSnr_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR"));
                this.mCnt_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS"));
                return;
            } else if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                this.mSnr_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR"));
                this.mIsSupportSoftmute = FMRadioServiceFeature.FEATURE_SUPPORT_SOFTMUTE;
                this.mSoftmutePath = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH");
                this.mAlgo_type = 1;
                this.mSnr_th_2 = -2;
                this.mRssi_th = this.mQualcomm_rmssi_firststate;
                this.mCnt_th = this.mQualcomm_onchannel;
                this.mCnt_th_2 = this.mQualcomm_offchannel;
                this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                this.mCf0_th12 = this.mQualcomm_cfoth12;
                this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                this.mgoodChrmssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH"));
                return;
            } else if (FMRadioServiceFeature.CHIP_VENDOR == 5 || FMRadioServiceFeature.CHIP_VENDOR == 10) {
                this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                this.mRichwave_seekDC = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_DC"));
                this.mRichwave_seekQA = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_QA"));
                return;
            } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                this.mSlsi_ifcount1 = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT1"));
                this.mSlsi_ifcount2 = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT2"));
                this.mSlsi_blendcoeff = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_BLENDCOEF"));
                this.mSlsi_softmutecoeff = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH"));
                return;
            } else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                this.mMtk_seeksmg = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKSMG"));
                this.mMtk_seekdesenserssi = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKDESENSERSSI"));
                this.mSoftmute_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH"));
                this.mMtk_blendrssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH"));
                this.mMtk_blendpamd_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH"));
                return;
            } else {
                return;
            }
        }
        String[] Local_Tunning_vals = FMRadioServiceFeature.FEATURE_SETLOCALTUNNING.split(",");
        log("Tuning value size: " + Local_Tunning_vals.length);
        switch (Local_Tunning_vals.length) {
            case 1:
                if (FMRadioServiceFeature.CHIP_VENDOR == 1) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR"));
                    this.mCnt_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                    SystemProperties.set("service.brcm.fm.start_mute", Local_Tunning_vals[0]);
                    SystemProperties.set("service.brcm.fm.set_blndmute", "1");
                    this.mRssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_RSSI"));
                    this.mSnr_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SNR"));
                    this.mCnt_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mIsSupportSoftmute = FMRadioServiceFeature.FEATURE_SUPPORT_SOFTMUTE;
                    this.mSoftmutePath = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH");
                    this.mAlgo_type = 1;
                    this.mSnr_th_2 = -2;
                    this.mRssi_th = this.mQualcomm_rmssi_firststate;
                    this.mCnt_th = this.mQualcomm_onchannel;
                    this.mCnt_th_2 = this.mQualcomm_offchannel;
                    this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                    this.mCf0_th12 = this.mQualcomm_cfoth12;
                    this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                    this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                    this.mgoodChrmssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 5 || FMRadioServiceFeature.CHIP_VENDOR == 10) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mRichwave_seekDC = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_DC"));
                    this.mRichwave_seekQA = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_RICHWAVE_SEEK_QA"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSlsi_ifcount1 = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT1"));
                    this.mSlsi_ifcount2 = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_IFCOUNT2"));
                    this.mSlsi_blendcoeff = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_BLENDCOEF"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mMtk_seeksmg = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKSMG"));
                    this.mMtk_seekdesenserssi = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKDESENSERSSI"));
                    this.mSoftmute_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH"));
                    this.mMtk_blendrssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH"));
                    this.mMtk_blendpamd_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH"));
                    return;
                } else {
                    return;
                }
            case 2:
                if (FMRadioServiceFeature.CHIP_VENDOR == 1) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mCnt_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_CNT_OR_COS"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mCnt_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mIsSupportSoftmute = FMRadioServiceFeature.FEATURE_SUPPORT_SOFTMUTE;
                    this.mSoftmutePath = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH");
                    this.mAlgo_type = 1;
                    this.mSnr_th_2 = -2;
                    this.mRssi_th = this.mQualcomm_rmssi_firststate;
                    this.mCnt_th_2 = this.mQualcomm_offchannel;
                    this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                    this.mCf0_th12 = this.mQualcomm_cfoth12;
                    this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                    this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                    this.mgoodChrmssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mMtk_seeksmg = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mMtk_seekdesenserssi = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_SEEKDESENSERSSI"));
                    this.mSoftmute_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH"));
                    this.mMtk_blendrssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH"));
                    this.mMtk_blendpamd_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH"));
                    return;
                } else {
                    return;
                }
            case 3:
                if (FMRadioServiceFeature.CHIP_VENDOR == 5 || FMRadioServiceFeature.CHIP_VENDOR == 10) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mRichwave_seekDC = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mRichwave_seekQA = Integer.parseInt(Local_Tunning_vals[2]);
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSlsi_ifcount1 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSlsi_ifcount2 = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSlsi_blendcoeff = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SLSI_BLENDCOEF"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mMtk_seeksmg = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mMtk_seekdesenserssi = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSoftmute_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH"));
                    this.mMtk_blendrssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH"));
                    this.mMtk_blendpamd_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mIsSupportSoftmute = Boolean.parseBoolean(Local_Tunning_vals[1]);
                    this.mSoftmutePath = Local_Tunning_vals[2];
                    this.mAlgo_type = 1;
                    this.mSnr_th_2 = -2;
                    this.mRssi_th = this.mQualcomm_rmssi_firststate;
                    this.mCnt_th = this.mQualcomm_onchannel;
                    this.mCnt_th_2 = this.mQualcomm_offchannel;
                    this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                    this.mCf0_th12 = this.mQualcomm_cfoth12;
                    this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                    this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                    this.mgoodChrmssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH"));
                    return;
                } else {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mCnt_th = Integer.parseInt(Local_Tunning_vals[2]);
                    return;
                }
            case 4:
                if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th_2 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mAlgo_type = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mIsSupportSoftmute = FMRadioServiceFeature.FEATURE_SUPPORT_SOFTMUTE;
                    this.mSoftmutePath = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH");
                    this.mCnt_th = this.mQualcomm_onchannel;
                    this.mCnt_th_2 = this.mQualcomm_offchannel;
                    this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                    this.mCf0_th12 = this.mQualcomm_cfoth12;
                    this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                    this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                    this.mgoodChrmssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_QUALCOMM_GOODCH_RMSSITH"));
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSlsi_ifcount1 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSlsi_ifcount2 = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSlsi_blendcoeff = Integer.parseInt(Local_Tunning_vals[3]);
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mMtk_seeksmg = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mMtk_seekdesenserssi = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSoftmute_th = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mMtk_blendrssi_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDRSSI_TH"));
                    this.mMtk_blendpamd_th = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_MEDIATEK_BLENDPAMD_TH"));
                    return;
                } else {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mCnt_th = Integer.parseInt(Local_Tunning_vals[2]);
                    if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                        SystemProperties.set("service.brcm.fm.start_mute", Local_Tunning_vals[3]);
                        SystemProperties.set("service.brcm.fm.set_blndmute", "1");
                        return;
                    }
                    return;
                }
            case 5:
                if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th_2 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mAlgo_type = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mgoodChrmssi_th = Integer.parseInt(Local_Tunning_vals[4]);
                    this.mIsSupportSoftmute = FMRadioServiceFeature.FEATURE_SUPPORT_SOFTMUTE;
                    this.mSoftmutePath = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_SOFTMUTE_PATH");
                    this.mCnt_th = this.mQualcomm_onchannel;
                    this.mCnt_th_2 = this.mQualcomm_offchannel;
                    this.mRssi_th_2 = this.mQualcomm_sinr_samplecnt;
                    this.mCf0_th12 = this.mQualcomm_cfoth12;
                    this.mAfRmssith_th = this.mQualcomm_af_rmssith;
                    this.mAfRmssisampleCnt_th = this.mQualcomm_af_rmssisamplecnt;
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSlsi_ifcount1 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSlsi_ifcount2 = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSlsi_blendcoeff = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mSlsi_softmutecoeff = Integer.parseInt(Local_Tunning_vals[4]);
                    return;
                } else {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mCnt_th = Integer.parseInt(Local_Tunning_vals[2]);
                    if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                        SystemProperties.set("service.brcm.fm.start_snr", Local_Tunning_vals[3]);
                        SystemProperties.set("service.brcm.fm.stop_snr", Local_Tunning_vals[4]);
                        SystemProperties.set("service.brcm.fm.set_blndmute", "1");
                        return;
                    }
                    return;
                }
            case 6:
                if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mMtk_seeksmg = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mMtk_seekdesenserssi = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSoftmute_th = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mMtk_blendrssi_th = Integer.parseInt(Local_Tunning_vals[4]);
                    this.mMtk_blendpamd_th = Integer.parseInt(Local_Tunning_vals[5]);
                    return;
                } else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSlsi_ifcount1 = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mSlsi_ifcount2 = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mSlsi_blendcoeff = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mSlsi_softmutecoeff = Integer.parseInt(Local_Tunning_vals[4]);
                    this.mSlsi_softstereoblendref = Integer.parseInt(Local_Tunning_vals[5]);
                    return;
                } else {
                    this.mRssi_th = Integer.parseInt(Local_Tunning_vals[0]);
                    this.mSnr_th = Integer.parseInt(Local_Tunning_vals[1]);
                    this.mCnt_th = Integer.parseInt(Local_Tunning_vals[2]);
                    this.mRssi_th_2 = Integer.parseInt(Local_Tunning_vals[3]);
                    this.mSnr_th_2 = Integer.parseInt(Local_Tunning_vals[4]);
                    this.mCnt_th_2 = Integer.parseInt(Local_Tunning_vals[5]);
                    return;
                }
            default:
                log("Tuning value size: " + Local_Tunning_vals.length);
                return;
        }
    }

    private void readParametersForCurrentRegion() {
        try {
            if (FMRadioServiceFeature.BANDWIDTHAS_87500_108000.equals(FMRadioServiceFeature.FEATURE_BANDWIDTH)) {
                if (!this.mIsExternalChipset) {
                    this.mBand = 1;
                } else {
                    this.mBand = 0;
                }
            } else if (FMRadioServiceFeature.BANDWIDTHAS_76000_108000.equals(FMRadioServiceFeature.FEATURE_BANDWIDTH)) {
                if (!this.mIsExternalChipset) {
                    this.mBand = 2;
                } else {
                    this.mBand = 1;
                }
            } else if (FMRadioServiceFeature.BANDWIDTHAS_76000_90000.equals(FMRadioServiceFeature.FEATURE_BANDWIDTH)) {
                if (!this.mIsExternalChipset) {
                    this.mBand = 3;
                } else {
                    this.mBand = 2;
                }
            } else if (!this.mIsExternalChipset) {
                this.mBand = 1;
            } else {
                this.mBand = 0;
            }
            int i = FMRadioServiceFeature.FEATURE_FREQUENCYSPACE;
            if (i != 50) {
                if (i == 100) {
                    if (!this.mIsExternalChipset) {
                        this.mChannelSpacing = 10;
                    } else {
                        this.mChannelSpacing = 1;
                    }
                } else if (!this.mIsExternalChipset) {
                    this.mChannelSpacing = 10;
                } else {
                    this.mChannelSpacing = 1;
                }
            } else if (!this.mIsExternalChipset) {
                this.mChannelSpacing = 5;
            } else {
                this.mChannelSpacing = 2;
            }
            int i2 = FMRadioServiceFeature.FEATURE_DECONSTANT;
            if (i2 == 50) {
                this.mDEConstant = 1;
            } else if (i2 == 75) {
                this.mDEConstant = 0;
            } else {
                this.mDEConstant = 1;
            }
        } catch (Exception e) {
            if (!this.mIsExternalChipset) {
                this.mBand = 1;
                this.mChannelSpacing = 10;
                this.mDEConstant = 1;
            } else {
                this.mBand = 0;
                this.mChannelSpacing = 1;
            }
            Log.e("FMRadioService", "Exception in readParametersForCurrentRegion() : " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueUpdate(int what, long delay) {
        log("queueUpdate(" + what + "," + delay + ") is called");
        if (what == 200) {
            log("queueUpdate ## VOLUME_FADEIN");
            this.mHandler.removeMessages(what);
        }
        this.mHandler.sendEmptyMessageDelayed(what, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ListenerRecord {
        IBinder mBinder;
        IFMEventListener mListener;

        public ListenerRecord(IFMEventListener listener, IBinder binder) {
            this.mBinder = binder;
            this.mListener = listener;
        }
    }

    public static void log(String str) {
        Log.i("FMRadioService", str);
    }

    public Context getContext() {
        return this.mContext;
    }

    @SuppressLint({"InvalidWakeLockTag", "WrongConstant"})
    public FMRadioService(Context context) {
        boolean z = false;
        this.mIsExternalChipset = false;
        this.mHandlerSA = null;
        this.mContext = context;
        this.mIsExternalChipset = FMRadioServiceFeature.FEATURE_FMRADIO_SUPPORT_EXTERNAL_RADIO_CHIPSET;
        log("mIsExternalChipset" + this.mIsExternalChipset);
        if (this.mIsExternalChipset) {
            if (FMRadioServiceFeature.CHIP_VENDOR == 5) {
                log("mIsExternalChipset CHIP_RICHWAVE");
                this.mPlayerExternalChipset = new PlayerExternalChipsetBesRichwave(this.mContext, this);
            }
        } else if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
            // this.mPlayerNative = new FMPlayerNativeBRCM(this);
        } else {
            this.mPlayerNative = new FMPlayerNative(this);
        }
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mWakeLock = this.mPowerManager.newWakeLock(1, "FMRadio Service");
        if (this.SURVEY_MODE_ENABLE) {
            this.mHandlerSA = new Handler(Looper.getMainLooper());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        intentFilter.addAction(WindowManagerPolicyConstants.ACTION_HDMI_PLUGGED);
        context.registerReceiver(this.mReceiver, intentFilter);
        IntentFilter intentFilterVol = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        intentFilterVol.setPriority(999);
        context.registerReceiver(this.mVolumeEventReceiver, intentFilterVol);
        context.registerReceiver(this.mVolumeEventReceiver, new IntentFilter(ACTION_VOLUME_LOCK));
        context.registerReceiver(this.mVolumeEventReceiver, new IntentFilter(ACTION_VOLUME_UNLOCK));
        this.mAirPlaneEnabled = Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 0 ? true : z;
        log("mAirPlaneEnabled flag :" + this.mAirPlaneEnabled);
        context.registerReceiver(this.mReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        context.registerReceiver(this.mButtonReceiver, new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY));
        context.registerReceiver(this.mResetSettingReceiver, new IntentFilter(RESET_SETTING));
        context.registerReceiver(this.mReceiver, new IntentFilter(ACTION_SAVE_FMRECORDING_ONLY));
        IntentFilter intentFilter2 = new IntentFilter(ACTION_CAMERA_START);
        intentFilter2.addAction(ACTION_CAMERA_STOP);
        context.registerReceiver(this.mReceiver, intentFilter2);
        registerSystemListener();
        registerSetPropertyListener();
        registerMDMCommandRec();
        readTuningParameters();
        readParametersForCurrentRegion();
        if (this.mIsExternalChipset) {
            checkUSBDeviceConnected(context);
        }
    }

    private void registerBatteryListener() {
        IntentFilter intentFilterBattery = new IntentFilter();
        intentFilterBattery.addAction(Intent.ACTION_BATTERY_CHANGED);
        this.mContext.registerReceiver(this.mLowBatteryReceiver, intentFilterBattery);
        log("registering low battery listener");
    }

    private void unRegisterBatteryListener() {
        this.mContext.unregisterReceiver(this.mLowBatteryReceiver);
        log("unregistering low battery listener");
    }

    private void registerSystemListener() {
        IntentFilter intentSystemFilter = new IntentFilter();
        intentSystemFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        this.mContext.registerReceiver(this.mSystemReceiver, intentSystemFilter);
        IntentFilter intentSystemFilter2 = new IntentFilter();
        intentSystemFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
        intentSystemFilter2.addAction(Intent.ACTION_PACKAGE_CHANGED);
        intentSystemFilter2.addAction(Intent.ACTION_PACKAGE_RESTARTED);
        intentSystemFilter2.addDataScheme("package");
        this.mContext.registerReceiver(this.mSystemReceiver1, intentSystemFilter2);
    }

    private void unregisterSystemListener() {
        this.mContext.unregisterReceiver(this.mSystemReceiver);
    }

    private void registerSetPropertyListener() {
        IntentFilter intentFilterSetProperty = new IntentFilter();
        intentFilterSetProperty.addAction("com.sec.android.app.fm.set_property");
        intentFilterSetProperty.addAction("com.sec.android.app.fm.set_volume");
        this.mContext.registerReceiver(this.mSetPropertyReceiver, intentFilterSetProperty, this.SetPropertyPermission, null);
        log("registering set property listener");
    }

    private void unRegisterSetPropertyListener() {
        this.mContext.unregisterReceiver(this.mSetPropertyReceiver);
        log("unregistering set property listener");
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void tune(long freq) {
        log("tune" + freq);
        if (!isValidPackage()) {
            return;
        }
        if (this.mOffProgress || !this.mIsOn) {
            log("tune can not be processed becuase FM chipset is either off or off in process");
            return;
        }
        mute(true);
        if (this.mIsExternalChipset) {
            int freqExt = ((int) freq) / 10;
            this.mPlayerExternalChipset.tune(freqExt);
        } else {
            this.mPlayerNative.tune(freq);
        }
        mute(false);
        log("tune notify event tune");
        notifyEvent(7, Long.valueOf(freq));
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void mute(boolean value) {
        log("mute - " + value);
        if (value) {
            if (this.mIsExternalChipset) {
                this.mPlayerExternalChipset.muteOn();
            } else {
                this.mPlayerNative.muteOn();
            }
            this.mAudioManager.setParameters(audioMute);
            this.mIsMute = true;
        } else if (isDNDEnable() || isAllSoundOff()) {
            log("AllSoundOff or DND is enabled. So FMRadio is muted.");
        } else {
            if (this.mIsExternalChipset) {
                this.mPlayerExternalChipset.muteOff();
            } else {
                this.mPlayerNative.muteOff();
            }
            this.mAudioManager.setParameters(audioUnMute);
            this.mIsMute = false;
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long[] getLastScanResult() {
        ArrayList<Long> arrayList = this.mScanChannelList;
        if (arrayList != null) {
            Long[] arryL = (Long[]) arrayList.toArray(new Long[0]);
            return convertToPrimitives(arryL);
        }
        log("getLastScanResult - mScanChannelList null");
        return null;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long seekUp() {
        long freq;
        if (!isValidPackage()) {
            return -1L;
        }
        this.mIsSeeking = true;
        mute(true);
        if (this.mIsExternalChipset) {
            freq = this.mPlayerExternalChipset.seekUp() * 10;
        } else {
            freq = this.mPlayerNative.seekUp();
        }
        mute(false);
        this.mIsSeeking = false;
        notifyEvent(7, Long.valueOf(freq));
        return freq;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long seekDown() {
        long freq;
        if (!isValidPackage()) {
            return -1L;
        }
        this.mIsSeeking = true;
        mute(true);
        if (this.mIsExternalChipset) {
            freq = this.mPlayerExternalChipset.seekDown() * 10;
        } else {
            freq = this.mPlayerNative.seekDown();
        }
        mute(false);
        this.mIsSeeking = false;
        notifyEvent(7, Long.valueOf(freq));
        return freq;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void cancelSeek() {
        if (this.mIsExternalChipset) {
            boolean result = this.mPlayerExternalChipset.stopSeek();
            log("result = " + result);
            return;
        }
        this.mPlayerNative.cancelSeek();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public int isBusy() {
        if (this.mScanProgress) {
            return 1;
        }
        return -1;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isHeadsetPlugged() {
        return this.mIsHeadsetPlugged;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isTvOutPlugged() {
        return this.mIsTvOutPlugged;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isBatteryLow() {
        return this.mIsBatteryLow;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isAirPlaneMode() {
        return this.mAirPlaneEnabled;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long getCurrentChannel() {
        if (this.mIsExternalChipset) {
            long freqExt = this.mPlayerExternalChipset.getTunedFrequency() * 10;
            return freqExt;
        }
        return this.mPlayerNative.getCurrentChannel();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setListener(IFMEventListener listener) {
        log("[FMRadioService] setListener :" + listener);
        if (listener != null) {
            synchronized (mFMRadioServiceLock) {
                if (this.mListeners == null) {
                    this.mListeners = new Vector<>();
                }
                ListenerRecord record = new ListenerRecord(listener, listener.asBinder());
                this.mListeners.addElement(record);
                log("no of listener:" + this.mListeners.size());
            }
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void removeListener(IFMEventListener listener) {
        log("[FMRadioService] (removeListener) :" + listener);
        if (listener == null) {
            return;
        }
        remove(listener);
    }

    @SuppressLint("WrongConstant")
    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public synchronized boolean on_in_testmode() {
        if (!isFactoryBinary) {
            log("on_in_testmode is called with normal binary. This function is only for Factory binary. So just return");
            return false;
        }
        if (this.mTelephonyManager.getCallState() != 1 && this.mTelephonyManager.getCallState() != 2) {
            if (this.mIsOn) {
                return true;
            }
            try {
                if (!this.mIsExternalChipset) {
                    if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                        if (this.mPlayerNative.preInitialize() > 0) {
                            setFMAudioPath(true);
                        } else {
                            log("FM preInitialize() failed");
                            return false;
                        }
                    }
                    this.mIsOn = this.mPlayerNative.on() > 0;
                } else if (this.modSamsungGetRadioOutputPath() == 2) {
                    this.mPlayerExternalChipset.setRecordMode(true);
                    this.mIsOn = this.mPlayerExternalChipset.isOn();
                } else {
                    this.mIsOn = this.mPlayerExternalChipset.on();
                }
                if (!this.mIsOn) {
                    if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                        setFMAudioPath(false);
                    }
                    this.mIsFMAudioPathOn = false;
                    this.mIsOn = false;
                    releaseWakeLock();
                    return false;
                }
                setSoftmute(false);
                this.mIsTestMode = true;
                notifyEvent(5, null);
                mute(false);
                setFMAudioPath(true);
                log("on_in_testmode Turning on FM radio");
                return true;
            } catch (Exception e) {
                if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    setFMAudioPath(false);
                }
                this.mIsFMAudioPathOn = false;
                this.mIsOn = false;
                Log.e("FMRadioService", "Exception in on_in_testmode() : " + e);
                releaseWakeLock();
                return false;
            }
        }
        return false;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean on() {
        if (!isValidPackage()) {
            return false;
        }
        return on(true);
    }

    private boolean isValidPackage() {
        return true;
    }

    private boolean isCTSTestApp() {
        int caller = Binder.getCallingUid();
        String[] pkgName = getContext().getPackageManager().getPackagesForUid(caller);
        for (String mPackageName : pkgName) {
            if (FMRADIO_CTS_APP_NAME.equals(mPackageName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFmTestApp() {
        int caller = Binder.getCallingUid();
        String[] pkgName = getContext().getPackageManager().getPackagesForUid(caller);
        String mPackageName = pkgName[0];
        return FMTEST_APP_NAME.equals(mPackageName);
    }

    @SuppressLint("WrongConstant")
    private boolean on(final boolean b) {
        synchronized (this) {
            log("on");
            if (this.SURVEY_MODE_ENABLE) {
                final String s = this.getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid())[0];
                String versionName = "";
                if (!"com.sec.android.app.fm".equals(s)) {
                    try {
                        versionName = this.mContext.getPackageManager().getPackageInfo(s, 0).versionName;
                    }
                    catch (final PackageManager.NameNotFoundException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("NameNotFoundException: ");
                        sb.append(ex);
                        Log.e("FMRadioService", sb.toString());
                    }
                    final FMRadioService.SamsungAnalyticsRunnable mSamsungAnalyticsRunnable = new FMRadioService.SamsungAnalyticsRunnable(s, versionName);
                    this.mSamsungAnalyticsRunnable = (Runnable)mSamsungAnalyticsRunnable;
                    this.mHandlerSA.post((Runnable)mSamsungAnalyticsRunnable);
                }
            }
            else {
                log("SamsungAnalytics survey mode is not enable");
            }
            if (this.mIsHeadsetPlugged) {
                if (!this.mOnProgress) {
                    if (this.mIsTvOutPlugged) {
                        return false;
                    }
                    if (this.mAirPlaneEnabled) {
                        return false;
                    }
                    this.registerBatteryListener();
                    if (this.mIsBatteryLow) {
                        return false;
                    }
                    if ((this.mTelephonyManager.getCallState() == 1 && !this.isDNDEnable()) || this.mTelephonyManager.getCallState() == 2) {
                        if (FMRadioService.mIsTransientPaused) {
                            FMRadioService.mNeedToResumeFM = true;
                        }
                        return false;
                    }
//                    if (SemEmergencyManager.getInstance(this.mContext).isModifying()) {
//                        log("UPSM Enabling : On failed");
//                        return false;
//                    }
                    if (this.alarmTTSPlay) {
                        return false;
                    }
                    if (this.mIsOn) {
                        return true;
                    }
                    {
                        try {
                            Label_0445: {
                                if (b || !FMRadioService.mIsTransientPaused) {
                                    if (!this.isFmTestApp() && !this.isCTSTestApp()) {
                                        log("AudioFocusListener registered");
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            this.mAudioManager.requestAudioFocus(new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(AudioManager.modSamsungGetStreamType(1)).addTag("FM_RADIO").build()).setOnAudioFocusChangeListener(this.mAudioFocusListener).build());
                                            break Label_0445;
                                        }
                                        this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, AudioManager.modSamsungGetStreamType(1), 1);
                                        break Label_0445;
                                    }
                                }
                                log("AudioFocusListener : skip the requestAudioFocus");
                            }
                            for (int n = 0; n < 50 && false; ++n) {
                                log("DMB enabled - waiting for DMB is closed");
                                this.wait(50L);
                            }
                            this.mOnProgress = true;
                            if (this.mIsExternalChipset) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("on() mIsExternalChipset ");
                                sb2.append(this.mIsExternalChipset);
                                log(sb2.toString());
                                if (modSamsungGetRadioOutputPath() == 2) {
                                    this.mPlayerExternalChipset.setRecordMode(true);
                                    this.mIsOn = this.mPlayerExternalChipset.isOn();
                                }
                                else {
                                    this.mIsOn = this.mPlayerExternalChipset.on();
                                }
                                this.wait(20L);
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("on state mPlayerExternalChipset ");
                                sb3.append(this.mIsOn);
                                log(sb3.toString());
                                if (!this.mIsOn) {
                                    this.setFMAudioPath(false);
                                    return this.mOnProgress = false;
                                }
                                if (FMRadioServiceFeature.CHIP_VENDOR == 5) {
                                    log("ext chip scan parameters setting");
                                    this.mPlayerExternalChipset.setRssiThreshold(this.mRssi_th);
                                    this.mPlayerExternalChipset.setSeekDC(this.mRichwave_seekDC);
                                    this.mPlayerExternalChipset.setSeekQA(this.mRichwave_seekQA);
                                }
                                this.mPlayerExternalChipset.setBand(this.mBand);
                                this.mPlayerExternalChipset.setChannelSpacing(this.mChannelSpacing);
                                this.wait(50L);
                                this.setFMAudioPath(true);
                                this.mOnProgress = false;
                                this.notifyEvent(5, null);
                                this.registerMusicCommandRec();
                                this.registerBikeModeObserver();
                                this.registerAvrcpModeObserver();
                                this.registerAlarmListener();
                                this.registerAllSoundOffListener();
                                this.registerEmergencyStateChangedListener();
                                this.registerDNDStatusChangedListener();
                                this.registerTelephonyListener();
                                final InputManager inputManager = (InputManager)this.mContext.getSystemService("input");
                                if (this.mIsOn != this.mIsSetWakeKey && inputManager != null) {
                                    try {
                                        // inputManager.semSetWakeKeyDynamically("com.sec.android.app.fm", this.mIsOn, "114,115");
                                    }
                                    catch (final SecurityException ex2) {
                                        final StringBuilder sb4 = new StringBuilder();
                                        sb4.append("Exception in semSetWakeKeyDynamically(): ");
                                        sb4.append(ex2.toString());
                                        log(sb4.toString());
                                    }
                                    this.mIsSetWakeKey = this.mIsOn;
                                }
                                this.mIsForcestop = false;
                                return true;
                            }
                            else {
                                if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                                    if (this.mPlayerNative.preInitialize() <= 0L) {
                                        log("FM preInitialize() failed");
                                        return this.mOnProgress = false;
                                    }
                                    this.setFMAudioPath(true);
                                    final int semGetRadioOutputPath = modSamsungGetRadioOutputPath();
                                    final StringBuilder sb5 = new StringBuilder();
                                    sb5.append("OnAudioFocusChangeListener switch on mNeedResumeToFreq:");
                                    sb5.append(this.mNeedResumeToFreq);
                                    sb5.append("setOutputPath = ");
                                    sb5.append(semGetRadioOutputPath);
                                    log(sb5.toString());
                                    this.modSamsungSetRadioOutputPath(semGetRadioOutputPath);
                                    this.wait(200L);
                                }
                                if (this.mPlayerNative.on() <= 0L) {
                                    if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                                        this.setFMAudioPath(false);
                                    }
                                    this.mOnProgress = false;
                                    this.mIsFMAudioPathOn = false;
                                    this.mIsOn = false;
                                    log("on is failed :: remove audiofocus ");
                                    this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
                                    this.releaseWakeLock();
                                    return false;
                                }
                                log("on returned from native");
                                this.mOnProgress = false;
                                this.mute(this.mIsOn = true);
                                if (!this.mIsHeadsetPlugged) {
                                    this.offInternal(2, true);
                                    return false;
                                }
                                this.notifyEvent(5, null);
                                if (FMRadioServiceFeature.CHIP_VENDOR == 1 || FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
                                    if (this.mIsSupportSoftmute && this.isPathSupportSoftmute(modSamsungGetRadioOutputPath())) {
                                        log("set softmute : true");
                                        this.setSoftmute(true);
                                    }
                                    else {
                                        log("set softmute : false");
                                        this.setSoftmute(false);
                                    }
                                }
                                if (FMRadioServiceFeature.CHIP_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9) {
                                    if (FMRadioServiceFeature.CHIP_VENDOR != 5 && FMRadioServiceFeature.CHIP_VENDOR != 10) {
                                        if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                                            this.mPlayerNative.setRSSI_th(this.mRssi_th);
                                            this.mPlayerNative.setIFCount1(this.mSlsi_ifcount1);
                                            this.mPlayerNative.setIFCount2(this.mSlsi_ifcount2);
                                            this.mPlayerNative.setStereo();
                                            this.mPlayerNative.setSoftStereoBlendCoeff(this.mSlsi_blendcoeff);
                                            if (this.mSlsi_softmutecoeff != -1L) {
                                                this.mPlayerNative.setSoftMuteCoeff(this.mSlsi_softmutecoeff);
                                            }
                                            if (this.mSlsi_softstereoblendref != 0L) {
                                                this.mPlayerNative.setSoftStereoBlendRef(this.mSlsi_softstereoblendref);
                                            }
                                        }
                                        else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                                            this.mPlayerNative.setSeekRSSI((long)this.mRssi_th);
                                            this.mPlayerNative.setSeekDesenseRSSI(this.mMtk_seekdesenserssi);
                                            this.mPlayerNative.setSeekSMG(this.mMtk_seeksmg);
                                            this.mPlayerNative.setSoftmute_th(this.mSoftmute_th);
                                            this.mPlayerNative.setBlendRSSI_th(this.mMtk_blendrssi_th);
                                            this.mPlayerNative.setBlendPAMD_th(this.mMtk_blendpamd_th);
                                            this.mPlayerNative.setATJ(this.mMtk_ATJ_config);
                                            if (SystemProperties.get("ro.product.vendor.model").toLowerCase().contains("a325")) {
                                                this.mPlayerNative.setVolume(29L);
                                            }
                                        }
                                        else {
                                            this.setSignalSetting(this.mRssi_th, this.mSnr_th, this.mCnt_th);
                                        }
                                    }
                                    else {
                                        this.mPlayerNative.setRSSI_th(this.mRssi_th);
                                        this.mPlayerNative.setSeekDC(this.mRichwave_seekDC);
                                        this.mPlayerNative.setSeekQA(this.mRichwave_seekQA);
                                    }
                                }
                                else {
                                    this.setSINRThreshold(this.mSnr_th);
                                    this.setSearchAlgoType(this.mAlgo_type);
                                    this.setSINRFirstStage(this.mSnr_th_2);
                                    this.setRMSSIFirstStage(this.mRssi_th);
                                    this.setOnChannelThreshold(this.mCnt_th);
                                    this.setOffChannelThreshold(this.mCnt_th_2);
                                    this.setSINRSamples(this.mRssi_th_2);
                                    this.setCFOTh12(this.mCf0_th12);
                                    this.setAFRMSSIThreshold(this.mAfRmssith_th);
                                    this.setAFRMSSISamples(this.mAfRmssisampleCnt_th);
                                    this.setGoodChannelRMSSIThreshold(this.mgoodChrmssi_th);
                                }
                                this.setBand(this.mBand);
                                this.setChannelSpacing(this.mChannelSpacing);
                                this.setDEConstant(this.mDEConstant);
                                this.registerMusicCommandRec();
                                this.registerBikeModeObserver();
                                this.registerAvrcpModeObserver();
                                this.registerAlarmListener();
                                this.registerAllSoundOffListener();
                                this.registerEmergencyStateChangedListener();
                                this.registerDNDStatusChangedListener();
                                this.registerTelephonyListener();
                                final InputManager inputManager2 = (InputManager)this.mContext.getSystemService("input");
                                if (this.mIsOn != this.mIsSetWakeKey && inputManager2 != null) {
                                    try {
                                        // inputManager2.semSetWakeKeyDynamically("com.sec.android.app.fm", this.mIsOn, "114,115");
                                    }
                                    catch (final SecurityException ex3) {
                                        final StringBuilder sb6 = new StringBuilder();
                                        sb6.append("Exception in semSetWakeKeyDynamically(): ");
                                        sb6.append(ex3.toString());
                                        log(sb6.toString());
                                    }
                                    this.mIsSetWakeKey = this.mIsOn;
                                }
                                this.mIsForcestop = false;
                                return true;
                            }
                        }
                        catch (final Exception ex4) {
                            final StringBuilder sb7 = new StringBuilder();
                            sb7.append("Exception in on() : ");
                            sb7.append(ex4);
                            Log.e("FMRadioService", sb7.toString());
                            if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                                this.setFMAudioPath(false);
                            }
                            this.mIsOn = false;
                            this.mOnProgress = false;
                            this.mIsFMAudioPathOn = false;
                            log("on is failed by exception :: remove audiofocus ");
                            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
                            this.releaseWakeLock();
                            this.unRegisterBatteryListener();
                            return false;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void registerTelephonyListener() {
        if (this.mIsPhoneStateListenerRegistered) {
            log("listner already registered");
            return;
        }
        long id = Binder.clearCallingIdentity();
        try {
            this.mTelephonyManager.listen(this.mPhoneListener, 32);
            Binder.restoreCallingIdentity(id);
            this.mIsPhoneStateListenerRegistered = true;
            log("registering telephony listener..");
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(id);
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void unRegisterTelephonyListener() {
        if (!this.mIsPhoneStateListenerRegistered) {
            log("listner is not registered");
            return;
        }
        long id = Binder.clearCallingIdentity();
        try {
            this.mTelephonyManager.listen(this.mPhoneListener, 0);
            Binder.restoreCallingIdentity(id);
            this.mIsPhoneStateListenerRegistered = false;
            log("unRegisterTelephonyListener ..");
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(id);
            throw th;
        }
    }

    private void registerMusicCommandRec() {
        IntentFilter intentFilter = new IntentFilter(ACTION_MUSIC_COMMAND);
        this.mContext.registerReceiver(this.mMusicCommandRec, intentFilter);
        log("music command reciever registered");
    }

    private void registerMDMCommandRec() {
        IntentFilter intentFilter = new IntentFilter(MDM_SPEAKER_ENABLED);
        this.mContext.registerReceiver(this.mMDMSpeakerEnabled, intentFilter);
        log("MDM command reciever registered");
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setVolume(long val) {
        log("set chipset Volume : " + val);
        if (!this.mIsOn) {
            return;
        }
        if (this.mScanProgress) {
            log("setVolume :: unset on ScanProgress");
        } else if (val < 0 || val > 15) {
        } else {
            int type = this.modSamsungGetRadioOutputPath();
            boolean z = Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_avc_mode", 1) == 1;
            this.mAvrcpMode = z;
            try {
                if (!this.mInternetStreamingMode) {
                    if (z && type == 8 && FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
                        log("Avrcp on");
                        if (!this.isRecording) {
                            if (!this.mIsExternalChipset) {
                                this.mPlayerNative.setVolume(15L);
                            } else {
                                this.mPlayerExternalChipset.setVolume(15);
                            }
                        }
                    } else if (this.mIsExternalChipset) {
                        int value = (int) val;
                        this.mPlayerExternalChipset.setVolume(value);
                    } else if (FMRadioServiceFeature.CHIP_VENDOR != 8) {
                        this.mPlayerNative.setVolume(val);
                    }
                    this.mResumeVol = val;
                    if (!isAllSoundOff() && !isDNDEnable()) {
                        if (FMRadioServiceFeature.CHIP_VENDOR != 3) {
                            if (val <= 0) {
                                if (!this.mIsMute) {
                                    mute(true);
                                    return;
                                }
                                return;
                            } else if (this.mIsMute) {
                                mute(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    log("setVolume :: AllSoundOff or DND is enabled. So FMRadio is muted.");
                    if (!this.mIsMute) {
                        mute(true);
                    }
                } else if (!this.mIsMute) {
                    if (!this.mIsExternalChipset && FMRadioServiceFeature.CHIP_VENDOR != 8) {
                        this.mPlayerNative.setVolume(0L);
                    } else {
                        this.mPlayerExternalChipset.setVolume(0);
                    }
                    mute(true);
                }
            } catch (NullPointerException e) {
                Log.e("FMRadioService", "NullPointerException in setVolume() : " + e);
            }
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long getVolume() {
        if (this.mIsExternalChipset) {
            return this.mPlayerExternalChipset.getVolume();
        }
        return this.mPlayerNative.getVolume();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setSpeakerOn(boolean bSpeakerOn) {
        if (this.mIsExternalChipset) {
            if (isOn()) {
                int freqExt = this.mPlayerExternalChipset.getTunedFrequency();
                if (bSpeakerOn) {
                    this.mPlayerExternalChipset.off();
                    this.mPlayerExternalChipset.setRecordMode(true);
                } else {
                    this.mPlayerExternalChipset.setRecordMode(false);
                    this.mPlayerExternalChipset.on();
                }
                this.mPlayerExternalChipset.setRssiThreshold(this.mRssi_th);
                this.mPlayerExternalChipset.setBand(this.mBand);
                this.mPlayerExternalChipset.setChannelSpacing(this.mChannelSpacing);
                if (FMRadioServiceFeature.CHIP_VENDOR == 5) {
                    this.mPlayerExternalChipset.setSeekDC(this.mRichwave_seekDC);
                    this.mPlayerExternalChipset.setSeekQA(this.mRichwave_seekQA);
                }
                if (this.mIsMute) {
                    this.mPlayerExternalChipset.muteOn();
                }
                this.mPlayerExternalChipset.tune(freqExt);
                if (this.mRDSEnable) {
                    this.mPlayerExternalChipset.setRdsEnable(true);
                }
            }
        } else {
            this.mPlayerNative.setSpeakerOn(bSpeakerOn);
        }
        setSlimbusEnable(0);
        if (FMRadioServiceFeature.CHIP_VENDOR == 1 || FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9) {
            if (this.mIsSupportSoftmute) {
                if (isPathSupportSoftmute(bSpeakerOn ? 2 : 3)) {
                    log("set softmute : true");
                    setSoftmute(true);
                }
            }
            log("set softmute : false");
            setSoftmute(false);
        }
        if (bSpeakerOn) {
            this.modSamsungSetRadioOutputPath(2);
        } else {
            this.modSamsungSetRadioOutputPath(3);
        }
        setSlimbusEnable(1);
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setRecordMode(boolean isRecord) {
        if (this.mIsExternalChipset) {
            return;
        }
        int value = 0;
        if (isRecord) {
            value = 1;
        }
        this.isRecording = isRecord;
        int type = this.modSamsungGetRadioOutputPath();
        boolean z = true;
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_avc_mode", 1) != 1) {
            z = false;
        }
        this.mAvrcpMode = z;
        if (z && type == 8 && FMRadioServiceFeature.FEATURE_USE_CHIPSET_VOLUME) {
            log(" setRecordMode avrcp on");
            if (this.isRecording) {
                this.mPlayerNative.setVolume(11L);
            }
        }
        this.mPlayerNative.setRecordMode(value);
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long getMaxVolume() {
        if (this.mIsExternalChipset) {
            return 15L;
        }
        return this.mPlayerNative.getMaxVolume();
    }

    private void releaseWakeLock() {
        long id = Binder.clearCallingIdentity();
        try {
            if (this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
                log("Lock is released");
            }
        } finally {
            Binder.restoreCallingIdentity(id);
        }
    }

    private void acquireWakeLock() {
        long id = Binder.clearCallingIdentity();
        try {
            if (!this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
                log("Lock is held");
            }
        } finally {
            Binder.restoreCallingIdentity(id);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isOn() {
        return this.mIsOn;
    }

    private boolean offInternal(final int n, final boolean b) {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            sb.append("offInternal :: reasonCode=");
            sb.append(n);
            log(sb.toString());
            this.mIsTransientDuck = false;
            if (!this.mIsOn) {
                if (b) {
                    log("offInternal :: remove audiofocus ");
                    this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
                }
                return true;
            }
            try {
                this.mOffProgress = true;
                Label_0132: {
                    if (!this.FEATURE_INDIRECT_MODE) {
                        if (!this.mIsExternalChipset) {
                            if (FMRadioServiceFeature.CHIP_VENDOR != 7) {
                                break Label_0132;
                            }
                        }
                    }
                    this.mute(true);
                    this.setDelay(10L);
                }
                FMRadioService.mIsTransientPaused = !b;
                if (this.mReturnBackVolume != -1) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("offInternal :: mReturnBackVolume=");
                    sb2.append(this.mReturnBackVolume);
                    log(sb2.toString());
                    this.mAudioManager.setStreamVolume(AudioManager.modSamsungGetStreamType(1), this.mReturnBackVolume, 0);
                    this.mReturnBackVolume = -1;
                }
                if (this.volumeLock && !this.mRecFinishNotified) {
                    this.notifyEvent(17, null);
                }
                else if (this.mRecFinishNotified) {
                    this.mRecFinishNotified = false;
                }
                if (FMRadioServiceFeature.CHIP_VENDOR != 7) {
                    this.setFMAudioPath(false);
                }
                if (FMRadioServiceFeature.CHIP_VENDOR == 2 && n != 3) {
                    this.mute(true);
                }
                log("offInternal Turning off FM radio");
                this.mIsAudioFocusAlive = !b;
                if (this.mIsExternalChipset) {
                    if (this.mRDSEnable) {
                        this.mPlayerExternalChipset.setRdsEnable(false);
                    }
                    this.mPlayerExternalChipset.stopNotifyThread(false);
                    if (this.mIsHeadsetPlugged) {
                        final boolean off = this.mPlayerExternalChipset.off();
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("off external chip set");
                        sb3.append(off);
                        log(sb3.toString());
                        this.wait(200L);
                    }
                }
                if (FMRadioServiceFeature.CHIP_VENDOR == 2 && n == 3) {
                    this.mPlayerNative.offFMService();
                }
                else if (!this.mIsExternalChipset) {
                    this.mPlayerNative.off();
                }
                if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                    this.setFMAudioPath(false);
                }
                this.mOffProgress = false;
                this.mIsOn = false;
                log("off returned from native");
                this.mRDSEnable = false;
                this.mAFEnable = false;
                this.mDNSEnable = false;
                this.mIsMute = false;
                this.mIsSkipTunigVal = false;
                this.unregisterBikeModeObserver();
                this.unregisterAvrcpModeObserver();
                if (!this.mIsTestMode) {
                    this.unRegisterMusicCommandRec();
                    this.unRegisterBatteryListener();
                    if (!this.alarmTTSPlay) {
                        this.unregisterAlarmListener();
                    }
                    this.unregisterAllSoundOffListener();
                    this.unregisterDNDStatusChangedListener();
                    if (b) {
                        this.unregisterEmegencyStateChangedListener();
                    }
                }
                this.mIsTestMode = false;
                if (b) {
                    this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
                    this.unRegisterTelephonyListener();
                }
                this.notifyEvent(6, n);
                if (!this.mIsForcestop) {
                    this.sendFMOFFBroadcast();
                }
                @SuppressLint("WrongConstant") final InputManager inputManager = (InputManager)this.mContext.getSystemService("input");
                if (this.mIsOn != this.mIsSetWakeKey && inputManager != null) {
                    try {
                        // inputManager.semSetWakeKeyDynamically("com.sec.android.app.fm", this.mIsOn, "114,115");
                    }
                    catch (final SecurityException ex2) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Exception in semSetWakeKeyDynamically(): ");
                        sb4.append(ex2.toString());
                        log(sb4.toString());
                    }
                    this.mIsSetWakeKey = this.mIsOn;
                }
                this.releaseWakeLock();
                return true;
            }
            catch (final Exception ex3) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("Exception in offInternal() : ");
                sb5.append(ex3);
                Log.e("FMRadioService", sb5.toString());
                this.mOffProgress = false;
                return false;
            } finally {
                this.releaseWakeLock();
            }
        }
    }

    @SuppressLint("WrongConstant")
    private void sendFMOFFBroadcast() {
        log("Sending broadcast FM is in OFF state");
        Intent intent = new Intent("com.sec.android.fm.player_lock.status.off");
        intent.setClassName("com.sec.android.app.fm", "com.sec.android.app.fm.widget.FMRadioProvider");
        intent.setFlags(1073741824);
        this.mContext.sendBroadcast(intent);
    }

    @SuppressLint("WrongConstant")
    private void sendFMONBroadcast(Object data) {
        log("Sending broadcast FM is in ON state");
        if (data != null) {
            Intent intent = new Intent("com.app.fm.auto.on");
            intent.setFlags(268435456);
            intent.setClassName("com.sec.android.app.fm", "com.sec.android.app.fm.receiver.AutoResumeReceiver");
            intent.putExtra("freq", (((float) ((Long) data).longValue()) / 1000.0f) + "");
            this.mContext.sendBroadcast(intent);
            return;
        }
        log("sendFMONBroadcast : data is null");
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean off() {
        if (!isValidPackage()) {
            return false;
        }
        return offInternal(0, true);
    }

    private void unRegisterMusicCommandRec() {
        this.mContext.unregisterReceiver(this.mMusicCommandRec);
        log("music command reciever un-registered");
    }

    private void unRegisterMDMCommandRec() {
        this.mContext.unregisterReceiver(this.mMDMSpeakerEnabled);
        log("MDM reciever un-registered");
    }

    private void remove(IFMEventListener listener) {
        synchronized (mFMRadioServiceLock) {
            if (this.mListeners != null && this.mListeners.size() != 0) {
                for (int i = 0; i < this.mListeners.size(); i++) {
                    ListenerRecord record = this.mListeners.get(i);
                    if (record.mBinder == listener.asBinder()) {
                        ListenerRecord delRecord = this.mListeners.remove(i);
                        log("[FMRadioService] deleted Listener :" + delRecord);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void scan() {
        if (this.mScanProgress) {
            return;
        }
        if (FMRadioServiceFeature.CHIP_VENDOR == 9 && this.mPlayerNative.preInitialize() <= 0) {
            return;
        }
        this.mScanProgress = true;
        ScanThread scanThread = new ScanThread();
        this.mScanThread = scanThread;
        scanThread.start();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isScanning() {
        return this.mScanProgress;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isSeeking() {
        return this.mIsSeeking;
    }

    public long getCurrentRSSI() {
        if (this.mIsExternalChipset) {
            return this.mPlayerExternalChipset.getCurrentRSSI();
        }
        return this.mPlayerNative.getCurrentRSSI();
    }

    public long getCurrentSNR() {
        if (!this.mIsExternalChipset) {
            return this.mPlayerNative.getCurrentSNR();
        }
        return -1L;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean cancelScan() {
        try {
            if (this.mScanProgress) {
                this.mScanProgress = false;
                if (this.mIsExternalChipset) {
                    this.mPlayerExternalChipset.stopSeek();
                } else {
                    this.mPlayerNative.cancelSeek();
                }
                if (this.mScanChannelList != null) {
                    notifyEvent(4, this.mScanChannelList.toArray(new Long[0]));
                    return true;
                }
                return true;
            }
        } catch (Exception e) {
            Log.e("FMRadioService", "Exception in cancelScan() : " + e);
        }
        return false;
    }

    public boolean checkBaseFreq() {
        if (this.mIsOn && !this.mIsExternalChipset) {
            return this.mPlayerNative.checkBaseFreq();
        }
        return false;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long searchUp() {
        if (isValidPackage() && this.mIsOn && !this.mIsExternalChipset) {
            return this.mPlayerNative.searchUp();
        }
        return -1L;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long searchAll() {
        if (this.mIsOn) {
            if (!this.mIsExternalChipset) {
                return this.mPlayerNative.searchAll();
            }
            return this.mPlayerExternalChipset.searchAll() * 10;
        }
        return -1L;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long searchDown() {
        if (!isValidPackage() || this.mIsExternalChipset) {
            return -1L;
        }
        return this.mPlayerNative.searchDown();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void enableRDS() {
        if (!isValidPackage()) {
            return;
        }
        if (this.mRDSEnable) {
            log("RDS is already enabled");
            return;
        }
        if (this.mIsExternalChipset) {
            this.mPlayerExternalChipset.setRdsEnable(true);
        } else {
            this.mPlayerNative.enableRDS();
        }
        this.mRDSEnable = true;
        notifyEvent(11, null);
        acquireWakeLock();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void disableRDS() {
        if (!isValidPackage()) {
            return;
        }
        if (!this.mRDSEnable) {
            log("RDS is already disabled");
            return;
        }
        this.mRDSEnable = false;
        if (this.mIsExternalChipset) {
            this.mPlayerExternalChipset.setRdsEnable(false);
        } else {
            this.mPlayerNative.disableRDS();
        }
        notifyEvent(12, null);
        checkForWakeLockRelease();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void enableDNS() {
        if (!isValidPackage()) {
            return;
        }
        if (this.mDNSEnable) {
            log("DNS is already enabled");
            return;
        }
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.enableDNS();
        }
        this.mDNSEnable = true;
        acquireWakeLock();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void disableDNS() {
        if (!isValidPackage()) {
            return;
        }
        this.mDNSEnable = false;
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.disableDNS();
        }
        checkForWakeLockRelease();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isDNSEnable() {
        return this.mDNSEnable;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void enableAF() {
        if (!isValidPackage()) {
            return;
        }
        if (this.mAFEnable) {
            log("AF is already enabled");
            return;
        }
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.enableAF();
        }
        this.mAFEnable = true;
        acquireWakeLock();
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void disableAF() {
        if (!isValidPackage()) {
            return;
        }
        this.mAFEnable = false;
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.disableAF();
        }
        checkForWakeLockRelease();
    }

    private void checkForWakeLockRelease() {
        if (!this.mAFEnable && !this.mRDSEnable && !this.mDNSEnable) {
            log("AF and RDS is off. release the wake lock");
            releaseWakeLock();
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setBand(int band) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setBand(band);
        } else {
            this.mPlayerExternalChipset.setBand(band);
        }
        this.mBand = band;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setChannelSpacing(int spacing) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setChannelSpacing(spacing);
        } else {
            this.mPlayerExternalChipset.setChannelSpacing(spacing);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isRDSEnable() {
        return this.mRDSEnable;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isAFEnable() {
        return this.mAFEnable;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void cancelAFSwitching() {
        if (isValidPackage() && !this.mIsExternalChipset) {
            this.mPlayerNative.cancelAFSwitching();
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setStereo() {
        if (!isValidPackage()) {
            return;
        }
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setStereo();
        } else {
            this.mPlayerExternalChipset.setSoundMode(0);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setMono() {
        if (!isValidPackage()) {
            return;
        }
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setMono();
        } else {
            this.mPlayerExternalChipset.setSoundMode(1);
        }
    }

    public void notifyEvent(int type, Object data) {
        if (this.mIsOn && type == 7) {
            if (!this.mOffProgress) {
                if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                    if (isUnMuteRadio()) {
                        this.mAudioManager.setParameters(audioUnMute);
                    }
                } else {
                    setFMAudioPath(true);
                }
                log("notifyEvent Turning on FM radio");
            } else {
                log("Fail to notify turning on FM radio ");
            }
        }
        if (this.mIsExternalChipset && type == 3) {
            this.mPlayerExternalChipset.setVolume(this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)));
        }
        synchronized (mFMRadioServiceLock) {
            try {
                if (this.mListeners != null && this.mListeners.size() != 0) {
                    log("Total listener:" + this.mListeners.size());
                    int size = this.mListeners.size();
                    for (int i = size + (-1); i >= 0; i--) {
                        log("Notifying listener:" + i);
                        switch (type) {
                            case 1:
                                long freq = 0;
                                if (data != null) {
                                    freq = ((Long) data).longValue();
                                }
                                if (DEBUGGABLE) {
                                    log("notifying :EVENT_CHANNEL_FOUND to : listener -->" + i + " : with freq:" + freq + "-->" + this.mListeners.get(i).mListener.asBinder());
                                }
                                this.mListeners.get(i).mListener.onChannelFound(freq);
                                break;
                            case 2:
                                log("notifying :EVENT_SCAN_STARTED to : listener -->" + i + " :" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onScanStarted();
                                break;
                            case 3:
                                if (data != null) {
                                    Long[] Ifreq = (Long[]) data;
                                    long[] freqArry = convertToPrimitives(Ifreq);
                                    int count = 0;
                                    if (freqArry != null) {
                                        count = freqArry.length;
                                    }
                                    log("notifying :EVENT_SCAN_FINISHED to : listener -->" + i + " : with data array:" + count + "-->" + this.mListeners.get(i).mListener.asBinder());
                                    this.mListeners.get(i).mListener.onScanFinished(freqArry);
                                    break;
                                } else {
                                    log("notifying : EVENT_SCAN_FINISHED : data is null !!!");
                                    break;
                                }
                            case 4:
                                if (data != null) {
                                    Long[] Ifreq2 = (Long[]) data;
                                    long[] freqArry2 = convertToPrimitives(Ifreq2);
                                    int count2 = 0;
                                    if (freqArry2 != null) {
                                        count2 = freqArry2.length;
                                    }
                                    log("notifying :EVENT_SCAN_STOPPED to : listener -->" + i + " : with data array:" + count2 + "-->" + this.mListeners.get(i).mListener.asBinder());
                                    this.mListeners.get(i).mListener.onScanStopped(freqArry2);
                                    break;
                                } else {
                                    log("notifying : EVENT_SCAN_STOPPED : data is null !!!");
                                    break;
                                }
                            case 5:
                                log("notifying :EVENT_POWER_ON to : listener -->" + i + "-->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onRadioEnabled();
                                break;
                            case 6:
                                log("notifying :EVENT_POWER_OFF to : listener -->" + i + "-->" + this.mListeners.get(i).mListener.asBinder());
                                int reasonCode = -1;
                                if (data != null) {
                                    reasonCode = ((Integer) data).intValue();
                                }
                                this.mListeners.get(i).mListener.onRadioDisabled(reasonCode);
                                break;
                            case 7:
                                if (data != null) {
                                    long freq2 = ((Long) data).longValue();
                                    curFreq = freq2;
                                    if (DEBUGGABLE) {
                                        log("notifying :EVENT_TUNE to : listener -->" + i + " : with data array:" + freq2 + "-->" + this.mListeners.get(i).mListener.asBinder());
                                    }
                                    this.mListeners.get(i).mListener.onTuned(freq2);
                                    break;
                                } else {
                                    log("notifying : EVENT_TUNE : data is null !!!");
                                    break;
                                }
                            case 8:
                                log("notifying :EVENT_EAR_PHONE_CONNECT to : listener -->" + i + ": -->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onHeadsetConnected();
                                break;
                            case 9:
                                log("notifying :EVENT_EAR_PHONE_DISCONNECT to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onHeadsetDisconnected();
                                break;
                            case 10:
                                log("notifying : EVENT_RDS_EVENT : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                if (data != null) {
                                    FMPlayerNativeBase.RDSData rdsData = (FMPlayerNativeBase.RDSData) data;
                                    this.mListeners.get(i).mListener.onRadioDataSystemReceived(rdsData.mFreq, rdsData.mChannelName, rdsData.mRadioText);
                                    break;
                                } else {
                                    log("notifying : EVENT_RDS_EVENT : data is null !!!");
                                    break;
                                }
                            case 11:
                                log("notifying :EVENT_RDS_ENABLED to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onRadioDataSystemEnabled();
                                break;
                            case 12:
                                log("notifying :EVENT_RDS_DISABLED to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onRadioDataSystemDisabled();
                                break;
                            case 13:
                                log("notifying :EVENT_AF_STARTED to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onAlternateFrequencyStarted();
                                break;
                            case 14:
                                log("notifying :EVENT_AF_RECEIVED to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                if (data != null) {
                                    long freq3 = ((Long) data).longValue();
                                    this.mListeners.get(i).mListener.onAlternateFrequencyReceived(freq3);
                                    break;
                                } else {
                                    log("notifying : EVENT_AF_RECEIVED : data is null !!!");
                                    break;
                                }
                            case 15:
                                log("notifying :EVENT_VOLUME_LOCK to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onVolumeLocked();
                                break;
                            case 16:
                                log("notifying :EVENT_RTPLUS_EVENT to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                if (data != null) {
                                    FMPlayerNativeBase.RTPlusData rtplusData = (FMPlayerNativeBase.RTPlusData) data;
                                    this.mListeners.get(i).mListener.onRadioTextPlusReceived(rtplusData.mContentType1, rtplusData.mStartPos1, rtplusData.mAdditionalLen1, rtplusData.mContentType2, rtplusData.mStartPos2, rtplusData.mAdditionalLen2);
                                    break;
                                } else {
                                    log("notifying : EVENT_RTPLUS_EVENT : data is null !!!");
                                    break;
                                }
                            case 17:
                                log("notifying :EVENT_REC_FINISH to : listener -->" + i + " : ->" + this.mListeners.get(i).mListener.asBinder());
                                this.mListeners.get(i).mListener.onRecordingFinished();
                                break;
                            case 18:
                                if (data != null) {
                                    try {
                                        FMPlayerNativeBase.PIECCData pieccData = (FMPlayerNativeBase.PIECCData) data;
                                        this.mListeners.get(i).mListener.onProgrammeIdentificationExtendedCountryCodesReceived(pieccData.mPI, pieccData.mECC);
                                        if (!FMRadioServiceFeature.FEATURE_DISABLEDNS && this.mWaitPidDuringScanning && this.mScanThread != null) {
                                            synchronized (this.mScanThread) {
                                                this.mScanThread.notify();
                                            }
                                        }
                                        break;
                                    } catch (Exception e) {
                                        Log.e("FMRadioService", "Exception in notifyEvent() : " + e);
                                        Log.e("FMRadioService", "we loose " + i + " listener--ignore it :" + this.mListeners.get(i).mListener);
                                        remove(this.mListeners.get(i).mListener);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Remove done go for next i's value:");
                                        sb.append(i);
                                        log(sb.toString());
                                        if (this.mIsOn && type == 7) {
                                            sendFMONBroadcast(data);
                                            break;
                                        }
                                    }
                                } else {
                                    log("notifying : EVENT_PIECC_EVENT : data is null !!!");
                                    break;
                                }
                                break;
                        }
                    }
                    return;
                }
                if (this.mIsOn && type == 7) {
                    sendFMONBroadcast(data);
                }
            } catch (RemoteException e) {
            }
        }
    }

    private long[] convertToPrimitives(Long[] longObArray) {
        if (longObArray != null) {
            long[] longArray = new long[longObArray.length];
            for (int i = 0; i < longArray.length; i++) {
                longArray[i] = longObArray[i].longValue();
            }
            return longArray;
        }
        return null;
    }

    private void setDEConstant(long value) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setDEConstant(value);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public long getPlayedFreq() {
        return curFreq;
    }

    private void setSeekRSSI(long value) {
        if (this.mIsExternalChipset) {
            this.mPlayerExternalChipset.setRssiThreshold((int) value);
        } else {
            this.mPlayerNative.setSeekRSSI(value);
        }
    }

    private void setSeekSNR(long value) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setSeekSNR(value);
        }
    }

    private void setRSSI_th(int value) {
        this.mRssi_th = value;
    }

    private void setSNR_th(int value) {
        this.mSnr_th = value;
    }

    private void setCnt_th(int value) {
        this.mCnt_th = value;
    }

    private void setRSSI_th_2(int value) {
        this.mRssi_th_2 = value;
    }

    private void setSNR_th_2(int value) {
        this.mSnr_th_2 = value;
    }

    private void setCnt_th_2(int value) {
        this.mCnt_th_2 = value;
    }

    private void SkipTuning_Value() {
        this.mIsSkipTunigVal = true;
        Log.e("FMRadioService", "SkipTuning_Value");
    }

    private int getRSSI_th() {
        if (this.mIsExternalChipset) {
            return this.mPlayerExternalChipset.getRssiThreshold();
        }
        return this.mRssi_th;
    }

    private int getSNR_th() {
        return this.mSnr_th;
    }

    private int getCnt_th() {
        return this.mCnt_th;
    }

    private int getRSSI_th_2() {
        return this.mRssi_th_2;
    }

    private int getSNR_th_2() {
        return this.mSnr_th_2;
    }

    private int getCnt_th_2() {
        return this.mCnt_th_2;
    }

    private void setAF_th(int value) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setAF_th(value);
        }
    }

    private int getAF_th() {
        if (!this.mIsExternalChipset) {
            return this.mPlayerNative.getAF_th();
        }
        return -1;
    }

    private void setAFValid_th(int value) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setAFValid_th(value);
        }
    }

    private int getAFValid_th() {
        if (!this.mIsExternalChipset) {
            return this.mPlayerNative.getAFValid_th();
        }
        return -1;
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setFMIntenna(boolean setFMIntenna) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setFMIntenna(setFMIntenna);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setSoftmute(boolean setSoftmute) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setSoftmute(setSoftmute);
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean getSoftMuteMode() {
        if (!this.mIsExternalChipset) {
            return this.mPlayerNative.getSoftMuteMode();
        }
        return true;
    }

    private void setSearchAlgoType(int value) {
        if (!this.mIsExternalChipset) {
            this.mPlayerNative.setSearchAlgoType(value);
        }
    }

    private int getSearchAlgoType() {
        return this.mPlayerNative.getSearchAlgoType();
    }

    private void setSINRSamples(int value) {
        this.mPlayerNative.setSINRSamples(value);
    }

    private int getSINRSamples() {
        return this.mPlayerNative.getSINRSamples();
    }

    private void setOnChannelThreshold(int value) {
        this.mPlayerNative.setOnChannelThreshold(value);
    }

    private int getOnChannelThreshold() {
        return this.mPlayerNative.getOnChannelThreshold();
    }

    private void setOffChannelThreshold(int value) {
        this.mPlayerNative.setOffChannelThreshold(value);
    }

    private int getOffChannelThreshold() {
        return this.mPlayerNative.getOffChannelThreshold();
    }

    private void setSINRThreshold(int value) {
        this.mPlayerNative.setSINRThreshold(value);
    }

    private int getSINRThreshold() {
        return this.mPlayerNative.getSINRThreshold();
    }

    private void setCFOTh12(int value) {
        this.mPlayerNative.setCFOTh12(value);
    }

    private int getCFOTh12() {
        return this.mPlayerNative.getCFOTh12();
    }

    private void setRMSSIFirstStage(int value) {
        this.mPlayerNative.setRMSSIFirstStage(value);
    }

    private int getRMSSIFirstStage() {
        return this.mPlayerNative.getRMSSIFirstStage();
    }

    private void setSINRFirstStage(int value) {
        this.mPlayerNative.setSINRFirstStage(value);
    }

    private int getSINRFirstStage() {
        return this.mPlayerNative.getSINRFirstStage();
    }

    private void setAFRMSSIThreshold(int value) {
        this.mPlayerNative.setAFRMSSIThreshold(value);
    }

    private int getAFRMSSIThreshold() {
        return this.mPlayerNative.getAFRMSSIThreshold();
    }

    private void setAFRMSSISamples(int value) {
        this.mPlayerNative.setAFRMSSISamples(value);
    }

    private int getAFRMSSISamples() {
        return this.mPlayerNative.getAFRMSSISamples();
    }

    private void setGoodChannelRMSSIThreshold(int value) {
        this.mPlayerNative.setGoodChannelRMSSIThreshold(value);
    }

    private int getGoodChannelRMSSIThreshold() {
        return this.mPlayerNative.getGoodChannelRMSSIThreshold();
    }

    private void setHybridSearch(String value) {
        this.mPlayerNative.setHybridSearch(value);
    }

    private String getHybridSearch() {
        return this.mPlayerNative.getHybridSearch();
    }

    private void setBlendRmssi(int value) {
        this.mPlayerNative.setBlendRmssi(value);
    }

    private int getBlendRmssi() {
        return this.mPlayerNative.getBlendRmssi();
    }

    private void setBlendSinr(int value) {
        this.mPlayerNative.setBlendSinr(value);
    }

    private int getBlendSinr() {
        return this.mPlayerNative.getBlendSinr();
    }

    private void setFrequencyOffsetThreshold(int value) {
        this.mPlayerNative.setFrequencyOffsetThreshold(value);
    }

    private int getFrequencyOffsetThreshold() {
        return this.mPlayerNative.getFrequencyOffsetThreshold();
    }

    private void setPilotPowerThreshold(int value) {
        this.mPlayerNative.setPilotPowerThreshold(value);
    }

    private int getPilotPowerThreshold() {
        return this.mPlayerNative.getPilotPowerThreshold();
    }

    private void setNoisePowerThreshold(int value) {
        this.mPlayerNative.setNoisePowerThreshold(value);
    }

    private int getNoisePowerThreshold() {
        return this.mPlayerNative.getNoisePowerThreshold();
    }

    private void setSeekDC(int value) {
        if (this.mIsExternalChipset) {
            this.mPlayerExternalChipset.setSeekDC(value);
        } else {
            this.mPlayerNative.setSeekDC(value);
        }
    }

    private int getSeekDC() {
        if (this.mIsExternalChipset) {
            return this.mPlayerExternalChipset.getSeekDC();
        }
        return this.mPlayerNative.getSeekDC();
    }

    private void setSeekQA(int value) {
        if (this.mIsExternalChipset) {
            this.mPlayerExternalChipset.setSeekQA(value);
        } else {
            this.mPlayerNative.setSeekQA(value);
        }
    }

    private int getSeekQA() {
        if (this.mIsExternalChipset) {
            return this.mPlayerExternalChipset.getSeekQA();
        }
        return this.mPlayerNative.getSeekQA();
    }

    private void setIFCount1(int value) {
        this.mSlsi_ifcount1 = value;
        this.mPlayerNative.setIFCount1(value);
    }

    private void setIFCount2(int value) {
        this.mSlsi_ifcount2 = value;
        this.mPlayerNative.setIFCount2(value);
    }

    private int getIFCount1() {
        return this.mSlsi_ifcount1;
    }

    private int getIFCount2() {
        return this.mSlsi_ifcount2;
    }

    private void setSoftStereoBlendCoeff(long value) {
        this.mSlsi_blendcoeff = value;
        this.mPlayerNative.setSoftStereoBlendCoeff(value);
    }

    private long getSoftStereoBlendCoeff() {
        return this.mSlsi_blendcoeff;
    }

    private void setSoftMuteCoeff(long value) {
        this.mSlsi_softmutecoeff = value;
        this.mPlayerNative.setSoftMuteCoeff(value);
    }

    private long getSoftMuteCoeff() {
        return this.mSlsi_softmutecoeff;
    }

    private void setSoftStereoBlendRef(long value) {
        this.mSlsi_softstereoblendref = value;
        this.mPlayerNative.setSoftStereoBlendRef(value);
    }

    private long getSoftStereoBlendRef() {
        return this.mSlsi_softstereoblendref;
    }

    private void setSeekDesenseRSSI(int value) {
        this.mMtk_seekdesenserssi = value;
        this.mPlayerNative.setSeekDesenseRSSI(value);
    }

    private int getSeekDesenseRSSI() {
        return this.mMtk_seekdesenserssi;
    }

    private void setSeekSMG(int value) {
        this.mMtk_seeksmg = value;
        this.mPlayerNative.setSeekSMG(value);
    }

    private int getSeekSMG() {
        return this.mMtk_seeksmg;
    }

    private void setSoftmute_th(int value) {
        this.mSoftmute_th = value;
        this.mPlayerNative.setSoftmute_th(value);
    }

    private int getSoftmute_th() {
        return this.mSoftmute_th;
    }

    private void setBlendRSSI_th(int value) {
        this.mMtk_blendrssi_th = value;
        this.mPlayerNative.setBlendRSSI_th(value);
    }

    private int getBlendRSSI_th() {
        return this.mMtk_blendrssi_th;
    }

    private void setBlendPAMD_th(int value) {
        this.mMtk_blendpamd_th = value;
        this.mPlayerNative.setBlendPAMD_th(value);
    }

    private int getBlendPAMD_th() {
        return this.mMtk_blendpamd_th;
    }

    private void setFakeChannel(String value) {
        this.mPlayerNative.setFakeChannel(value);
    }

    private String getFakeChannel() {
        return this.mPlayerNative.getFakeChannel();
    }

    private void setDeSenseList(String value) {
        this.mPlayerNative.setDeSenseList(value);
    }

    private String getDeSenseList() {
        return this.mPlayerNative.getDeSenseList();
    }

    private void setATJ(int bATJOn) {
        this.mMtk_ATJ_config = bATJOn;
        this.mPlayerNative.setATJ(bATJOn);
    }

    private int getATJ() {
        return this.mMtk_ATJ_config;
    }

    public void setIntegerTunningParameter(final String s, final int seekDC) {
        if (!this.isValidPackage()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("setIntegerTunningParameter:  parameterName- ");
        sb.append(s);
        sb.append("  value:- ");
        sb.append(seekDC);
        log(sb.toString());
        if (s == null) {
            log("setIntegerTunningParameter:  parameterName is null. So do nothing");
            return;
        }
        final int hashCode = s.hashCode();
        final int n = 3;
        final int n2 = -1;
        int n3 = 0;
        Label_0186: {
            switch (hashCode) {
                case 2023291178: {
                    if (s.equals("Cnt_th")) {
                        n3 = 2;
                        break Label_0186;
                    }
                    break;
                }
                case -62558051: {
                    if (s.equals("SkipTuningValue")) {
                        n3 = 3;
                        break Label_0186;
                    }
                    break;
                }
                case -1844175268: {
                    if (s.equals("SNR_th")) {
                        n3 = 1;
                        break Label_0186;
                    }
                    break;
                }
                case -2078967972: {
                    if (s.equals("RSSI_th")) {
                        n3 = 0;
                        break Label_0186;
                    }
                    break;
                }
            }
            n3 = -1;
        }
        if (n3 == 0) {
            this.setRSSI_th(seekDC);
            return;
        }
        if (n3 == 1) {
            this.setSNR_th(seekDC);
            return;
        }
        if (n3 == 2) {
            this.setCnt_th(seekDC);
            return;
        }
        if (n3 != 3) {
            if (FMRadioServiceFeature.CHIP_VENDOR != 5 && FMRadioServiceFeature.CHIP_VENDOR != 10) {
                if (FMRadioServiceFeature.CHIP_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9) {
                    if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                        final int hashCode2 = s.hashCode();
                        int n4;
                        if ((hashCode2 == 62209230) ? s.equals("AF_th") : (hashCode2 == 1082099932 && s.equals("AFValid_th"))) {
                            n4 = 1;
                        }
                        else {
                            n4 = -1;
                        }
                        if (n4 != 0) {
                            if (n4 != 1) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("setIntegerTunningParameter() : invalid parameterName - ");
                                sb2.append(s);
                                sb2.append(" for chip vendor - ");
                                sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
                                log(sb2.toString());
                            }
                            else {
                                this.setAFValid_th(seekDC);
                            }
                        }
                        else {
                            this.setAF_th(seekDC);
                        }
                    }
                    else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                        int n5 = 0;
                        Label_0447: {
                            switch (s.hashCode()) {
                                case -1898857344: {
                                    if (s.equals("IFCount2")) {
                                        n5 = 1;
                                        break Label_0447;
                                    }
                                    break;
                                }
                                case -1898857345: {
                                    if (s.equals("IFCount1")) {
                                        n5 = 0;
                                        break Label_0447;
                                    }
                                    break;
                                }
                            }
                            n5 = -1;
                        }
                        if (n5 != 0) {
                            if (n5 != 1) {
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("setIntegerTunningParameter() : invalid parameterName - ");
                                sb3.append(s);
                                sb3.append(" for chip vendor - ");
                                sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                                log(sb3.toString());
                            }
                            else {
                                this.setIFCount2(seekDC);
                            }
                        }
                        else {
                            this.setIFCount1(seekDC);
                        }
                    }
                    else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                        int n6 = 0;
                        Label_0686: {
                            switch (s.hashCode()) {
                                case 1910102394: {
                                    if (s.equals("BlendPAMD_th")) {
                                        n6 = 4;
                                        break Label_0686;
                                    }
                                    break;
                                }
                                case 1038261217: {
                                    if (s.equals("ATJCofig")) {
                                        n6 = 5;
                                        break Label_0686;
                                    }
                                    break;
                                }
                                case -88842741: {
                                    if (s.equals("BlendRSSI_th")) {
                                        n6 = 3;
                                        break Label_0686;
                                    }
                                    break;
                                }
                                case -658516075: {
                                    if (s.equals("SeekSMG")) {
                                        n6 = 1;
                                        break Label_0686;
                                    }
                                    break;
                                }
                                case -1416966448: {
                                    if (s.equals("Softmute_th")) {
                                        n6 = 2;
                                        break Label_0686;
                                    }
                                    break;
                                }
                                case -1731989524: {
                                    if (s.equals("SeekDesenseRSSI")) {
                                        n6 = 0;
                                        break Label_0686;
                                    }
                                    break;
                                }
                            }
                            n6 = n2;
                        }
                        if (n6 != 0) {
                            if (n6 != 1) {
                                if (n6 != 2) {
                                    if (n6 != 3) {
                                        if (n6 != 4) {
                                            if (n6 != 5) {
                                                final StringBuilder sb4 = new StringBuilder();
                                                sb4.append("setIntegerTunningParameter() : invalid parameterName - ");
                                                sb4.append(s);
                                                sb4.append(" for chip vendor - ");
                                                sb4.append(FMRadioServiceFeature.CHIP_VENDOR);
                                                log(sb4.toString());
                                            }
                                            else {
                                                this.setATJ(seekDC);
                                            }
                                        }
                                        else {
                                            this.setBlendPAMD_th(seekDC);
                                        }
                                    }
                                    else {
                                        this.setBlendRSSI_th(seekDC);
                                    }
                                }
                                else {
                                    this.setSoftmute_th(seekDC);
                                }
                            }
                            else {
                                this.setSeekSMG(seekDC);
                            }
                        }
                        else {
                            this.setSeekDesenseRSSI(seekDC);
                        }
                    }
                    else {
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("setIntegerTunningParameter() : this parameter is not support yet - ");
                        sb5.append(s);
                        sb5.append(" chipvendor - ");
                        sb5.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb5.toString());
                    }
                }
                else {
                    int n7 = 0;
                    Label_1262: {
                        switch (s.hashCode()) {
                            case 2004862370: {
                                if (s.equals("AFRMSSIThreshold")) {
                                    n7 = 8;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 1826319004: {
                                if (s.equals("RMSSIFirstStage")) {
                                    n7 = 6;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 1569063695: {
                                if (s.equals("SNR_th_2")) {
                                    n7 = 12;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 1412807169: {
                                if (s.equals("CFOTh12")) {
                                    n7 = 5;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 1051458289: {
                                if (s.equals("SINRThreshold")) {
                                    n7 = 4;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 879837199: {
                                if (s.equals("SINRSamples")) {
                                    n7 = 1;
                                    break Label_1262;
                                }
                                break;
                            }
                            case 612887239: {
                                if (s.equals("OnChannelThreshold")) {
                                    n7 = 2;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -303196099: {
                                if (s.equals("BlendRmssi")) {
                                    n7 = 14;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -728425457: {
                                if (s.equals("RSSI_th_2")) {
                                    n7 = 11;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1075284457: {
                                if (s.equals("OffChannelThreshold")) {
                                    n7 = n;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1237360035: {
                                if (s.equals("Cnt_th_2")) {
                                    n7 = 13;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1271273368: {
                                if (s.equals("SINRFirstStage")) {
                                    n7 = 7;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1395228053: {
                                if (s.equals("BlendSinr")) {
                                    n7 = 15;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1471559147: {
                                if (s.equals("SearchAlgoType")) {
                                    n7 = 0;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -1620552413: {
                                if (s.equals("GoodChannelRMSSIThreshold")) {
                                    n7 = 10;
                                    break Label_1262;
                                }
                                break;
                            }
                            case -2006318336: {
                                if (s.equals("AFRMSSISamples")) {
                                    n7 = 9;
                                    break Label_1262;
                                }
                                break;
                            }
                        }
                        n7 = -1;
                    }
                    switch (n7) {
                        default: {
                            final StringBuilder sb6 = new StringBuilder();
                            sb6.append("setIntegerTunningParameter() : invalid parameterName - ");
                            sb6.append(s);
                            sb6.append(" for chip vendor - ");
                            sb6.append(FMRadioServiceFeature.CHIP_VENDOR);
                            log(sb6.toString());
                            break;
                        }
                        case 15: {
                            this.setBlendSinr(seekDC);
                            break;
                        }
                        case 14: {
                            this.setBlendRmssi(seekDC);
                            break;
                        }
                        case 13: {
                            this.setCnt_th_2(seekDC);
                            break;
                        }
                        case 12: {
                            this.setSNR_th_2(seekDC);
                            break;
                        }
                        case 11: {
                            this.setRSSI_th_2(seekDC);
                            break;
                        }
                        case 10: {
                            this.setGoodChannelRMSSIThreshold(seekDC);
                            break;
                        }
                        case 9: {
                            this.setAFRMSSISamples(seekDC);
                            break;
                        }
                        case 8: {
                            this.setAFRMSSIThreshold(seekDC);
                            break;
                        }
                        case 7: {
                            this.setSINRFirstStage(seekDC);
                            break;
                        }
                        case 6: {
                            this.setRMSSIFirstStage(seekDC);
                            break;
                        }
                        case 5: {
                            this.setCFOTh12(seekDC);
                            break;
                        }
                        case 4: {
                            this.setSINRThreshold(seekDC);
                            break;
                        }
                        case 3: {
                            if (!this.mIsExternalChipset) {
                                this.mPlayerNative.setOffChannelThreshold(seekDC);
                                break;
                            }
                            break;
                        }
                        case 2: {
                            this.setOnChannelThreshold(seekDC);
                            break;
                        }
                        case 1: {
                            this.setSINRSamples(seekDC);
                            break;
                        }
                        case 0: {
                            this.setSearchAlgoType(seekDC);
                            break;
                        }
                    }
                }
            }
            else {
                final int hashCode3 = s.hashCode();
                int n8;
                if ((hashCode3 == -1822358249) ? s.equals("SeekDC") : (hashCode3 == -1822357848 && s.equals("SeekQA"))) {
                    n8 = 1;
                }
                else {
                    n8 = -1;
                }
                if (n8 != 0) {
                    if (n8 != 1) {
                        final StringBuilder sb7 = new StringBuilder();
                        sb7.append("setIntegerTunningParameter() : invalid parameterName - ");
                        sb7.append(s);
                        sb7.append(" for chip vendor - ");
                        sb7.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb7.toString());
                    }
                    else {
                        this.setSeekQA(seekDC);
                    }
                }
                else {
                    this.setSeekDC(seekDC);
                }
            }
            return;
        }
        this.SkipTuning_Value();
    }

    public int getIntegerTunningParameter(final String s, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("getIntegerTunningParameter: parameterName- ");
        sb.append(s);
        log(sb.toString());
        if (s == null) {
            log("getIntegerTunningParameter:  parameterName is null. So do nothing");
            return n;
        }
        final int hashCode = s.hashCode();
        final int n2 = 0;
        final int n3 = 0;
        final int n4 = 0;
        int n5;
        if ((hashCode == -2078967972) ? s.equals("RSSI_th") : ((hashCode == -1844175268) ? s.equals("SNR_th") : (hashCode == 2023291178 && s.equals("Cnt_th")))) {
            n5 = 2;
        }
        else {
            n5 = -1;
        }
        if (n5 == 0) {
            return this.getRSSI_th();
        }
        if (n5 == 1) {
            return this.getSNR_th();
        }
        if (n5 != 2) {
            if (FMRadioServiceFeature.CHIP_VENDOR != 5 && FMRadioServiceFeature.CHIP_VENDOR != 10) {
                if (FMRadioServiceFeature.CHIP_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9) {
                    if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                        final int hashCode2 = s.hashCode();
                        int n6;
                        if ((hashCode2 == 62209230) ? s.equals("AF_th") : (hashCode2 == 1082099932 && s.equals("AFValid_th"))) {
                            n6 = 1;
                        }
                        else {
                            n6 = -1;
                        }
                        if (n6 == 0) {
                            return this.getAF_th();
                        }
                        if (n6 == 1) {
                            return this.getAFValid_th();
                        }
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("getIntegerTunningParameter() : invalid parameterName - ");
                        sb2.append(s);
                        sb2.append(" for chip vendor - ");
                        sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb2.toString());
                    }
                    else if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                        int n7 = 0;
                        Label_0388: {
                            switch (s.hashCode()) {
                                case -1898857344: {
                                    if (s.equals("IFCount2")) {
                                        n7 = 1;
                                        break Label_0388;
                                    }
                                    break;
                                }
                                case -1898857345: {
                                    if (s.equals("IFCount1")) {
                                        n7 = n2;
                                        break Label_0388;
                                    }
                                    break;
                                }
                            }
                            n7 = -1;
                        }
                        if (n7 == 0) {
                            return this.getIFCount1();
                        }
                        if (n7 == 1) {
                            return this.getIFCount2();
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("getIntegerTunningParameter() : invalid parameterName - ");
                        sb3.append(s);
                        sb3.append(" for chip vendor - ");
                        sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb3.toString());
                    }
                    else if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                        int n8 = 0;
                        Label_0625: {
                            switch (s.hashCode()) {
                                case 1910102394: {
                                    if (s.equals("BlendPAMD_th")) {
                                        n8 = 4;
                                        break Label_0625;
                                    }
                                    break;
                                }
                                case 1038261217: {
                                    if (s.equals("ATJCofig")) {
                                        n8 = 5;
                                        break Label_0625;
                                    }
                                    break;
                                }
                                case -88842741: {
                                    if (s.equals("BlendRSSI_th")) {
                                        n8 = 3;
                                        break Label_0625;
                                    }
                                    break;
                                }
                                case -658516075: {
                                    if (s.equals("SeekSMG")) {
                                        n8 = 1;
                                        break Label_0625;
                                    }
                                    break;
                                }
                                case -1416966448: {
                                    if (s.equals("Softmute_th")) {
                                        n8 = 2;
                                        break Label_0625;
                                    }
                                    break;
                                }
                                case -1731989524: {
                                    if (s.equals("SeekDesenseRSSI")) {
                                        n8 = n3;
                                        break Label_0625;
                                    }
                                    break;
                                }
                            }
                            n8 = -1;
                        }
                        if (n8 == 0) {
                            return this.getSeekDesenseRSSI();
                        }
                        if (n8 == 1) {
                            return this.getSeekSMG();
                        }
                        if (n8 == 2) {
                            return this.getSoftmute_th();
                        }
                        if (n8 == 3) {
                            return this.getBlendRSSI_th();
                        }
                        if (n8 == 4) {
                            return this.getBlendPAMD_th();
                        }
                        if (n8 == 5) {
                            return this.getATJ();
                        }
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("setIntegerTunningParameter() : invalid parameterName - ");
                        sb4.append(s);
                        sb4.append(" for chip vendor - ");
                        sb4.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb4.toString());
                    }
                    else {
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("getIntegerTunningParameter() : this parameter is not support yet - ");
                        sb5.append(s);
                        sb5.append(" chipvendor - ");
                        sb5.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb5.toString());
                    }
                }
                else {
                    int n9 = 0;
                    Label_1186: {
                        switch (s.hashCode()) {
                            case 2004862370: {
                                if (s.equals("AFRMSSIThreshold")) {
                                    n9 = 8;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 1826319004: {
                                if (s.equals("RMSSIFirstStage")) {
                                    n9 = 6;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 1569063695: {
                                if (s.equals("SNR_th_2")) {
                                    n9 = 12;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 1412807169: {
                                if (s.equals("CFOTh12")) {
                                    n9 = 5;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 1051458289: {
                                if (s.equals("SINRThreshold")) {
                                    n9 = 4;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 879837199: {
                                if (s.equals("SINRSamples")) {
                                    n9 = 1;
                                    break Label_1186;
                                }
                                break;
                            }
                            case 612887239: {
                                if (s.equals("OnChannelThreshold")) {
                                    n9 = 2;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -303196099: {
                                if (s.equals("BlendRmssi")) {
                                    n9 = 14;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -728425457: {
                                if (s.equals("RSSI_th_2")) {
                                    n9 = 11;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1075284457: {
                                if (s.equals("OffChannelThreshold")) {
                                    n9 = 3;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1237360035: {
                                if (s.equals("Cnt_th_2")) {
                                    n9 = 13;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1271273368: {
                                if (s.equals("SINRFirstStage")) {
                                    n9 = 7;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1395228053: {
                                if (s.equals("BlendSinr")) {
                                    n9 = 15;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1471559147: {
                                if (s.equals("SearchAlgoType")) {
                                    n9 = n4;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -1620552413: {
                                if (s.equals("GoodChannelRMSSIThreshold")) {
                                    n9 = 10;
                                    break Label_1186;
                                }
                                break;
                            }
                            case -2006318336: {
                                if (s.equals("AFRMSSISamples")) {
                                    n9 = 9;
                                    break Label_1186;
                                }
                                break;
                            }
                        }
                        n9 = -1;
                    }
                    switch (n9) {
                        default: {
                            final StringBuilder sb6 = new StringBuilder();
                            sb6.append("getIntegerTunningParameter() : invalid parameterName - ");
                            sb6.append(s);
                            sb6.append(" for chip vendor - ");
                            sb6.append(FMRadioServiceFeature.CHIP_VENDOR);
                            log(sb6.toString());
                            break;
                        }
                        case 15: {
                            return this.getBlendSinr();
                        }
                        case 14: {
                            return this.getBlendRmssi();
                        }
                        case 13: {
                            return this.getCnt_th_2();
                        }
                        case 12: {
                            return this.getSNR_th_2();
                        }
                        case 11: {
                            return this.getRSSI_th_2();
                        }
                        case 10: {
                            return this.getGoodChannelRMSSIThreshold();
                        }
                        case 9: {
                            return this.getAFRMSSISamples();
                        }
                        case 8: {
                            return this.getAFRMSSIThreshold();
                        }
                        case 7: {
                            return this.getSINRFirstStage();
                        }
                        case 6: {
                            return this.getRMSSIFirstStage();
                        }
                        case 5: {
                            return this.getCFOTh12();
                        }
                        case 4: {
                            return this.getSINRThreshold();
                        }
                        case 3: {
                            return this.getOffChannelThreshold();
                        }
                        case 2: {
                            return this.getOnChannelThreshold();
                        }
                        case 1: {
                            return this.getSINRSamples();
                        }
                        case 0: {
                            return this.getSearchAlgoType();
                        }
                    }
                }
            }
            else {
                final int hashCode3 = s.hashCode();
                int n10;
                if ((hashCode3 == -1822358249) ? s.equals("SeekDC") : (hashCode3 == -1822357848 && s.equals("SeekQA"))) {
                    n10 = 1;
                }
                else {
                    n10 = -1;
                }
                if (n10 == 0) {
                    return this.getSeekDC();
                }
                if (n10 == 1) {
                    return this.getSeekQA();
                }
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("getIntegerTunningParameter() : invalid parameterName - ");
                sb7.append(s);
                sb7.append(" for chip vendor - ");
                sb7.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb7.toString());
            }
            return n;
        }
        return this.getCnt_th();
    }

    public void setLongTunningParameter(final String s, final long n) {
        if (!this.isValidPackage()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("long setLongTunningParameter: parameterName - ");
        sb.append(s);
        sb.append("  value: ");
        sb.append(n);
        log(sb.toString());
        if (s == null) {
            log("setLongTunningParameter:  parameterName is null. So do nothing");
            return;
        }
        final int hashCode = s.hashCode();
        int n2;
        if ((hashCode == -1141489851) ? s.equals("DEConstant") : ((hashCode == -658516033) ? s.equals("SeekSNR") : (hashCode == 1060814575 && s.equals("SeekRSSI")))) {
            n2 = 0;
        }
        else {
            n2 = -1;
        }
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("setLongTunningParameter() : invalid parameterName - ");
                    sb2.append(s);
                    sb2.append(" for chip vendor - ");
                    sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
                    log(sb2.toString());
                }
                else {
                    this.setDEConstant(n);
                }
            }
            else {
                this.setSeekSNR(n);
            }
        }
        else {
            this.setSeekRSSI(n);
        }
        if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
            final int hashCode2 = s.hashCode();
            int n3;
            if ((hashCode2 == -681786198) ? s.equals("SoftStereoBlendCoeff") : ((hashCode2 == 1746788740) ? s.equals("SoftStereoBlendRef") : (hashCode2 == 1777837110 && s.equals("SoftMuteCoeff")))) {
                n3 = 1;
            }
            else {
                n3 = -1;
            }
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 != 2) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("setLongTunningParameter() : invalid parameterName - ");
                        sb3.append(s);
                        sb3.append(" for chip vendor - ");
                        sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb3.toString());
                    }
                    else {
                        this.setSoftStereoBlendRef(n);
                    }
                }
                else {
                    this.setSoftMuteCoeff(n);
                }
            }
            else {
                this.setSoftStereoBlendCoeff(n);
            }
        }
    }

    public long getLongTunningParameter(final String s, final long n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("long getLongTunningParameter: parameterName - ");
        sb.append(s);
        log(sb.toString());
        if (s == null) {
            log("getLongTunningParameter:  parameterName is null. So do nothing");
            return n;
        }
        final int hashCode = s.hashCode();
        int n2;
        if ((hashCode == -2025944784) ? s.equals("CurrentRSSI") : (hashCode == 904479070 && s.equals("CurrentSNR"))) {
            n2 = 0;
        }
        else {
            n2 = -1;
        }
        if (n2 == 0) {
            return this.getCurrentSNR();
        }
        if (n2 != 1) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("getLongTunningParameter() : invalid parameterName - ");
            sb2.append(s);
            sb2.append(" for chip vendor - ");
            sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
            log(sb2.toString());
            if (FMRadioServiceFeature.CHIP_VENDOR == 7) {
                final int hashCode2 = s.hashCode();
                int n3;
                if ((hashCode2 == -681786198) ? s.equals("SoftStereoBlendCoeff") : ((hashCode2 == 1746788740) ? s.equals("SoftStereoBlendRef") : (hashCode2 == 1777837110 && s.equals("SoftMuteCoeff")))) {
                    n3 = 1;
                }
                else {
                    n3 = -1;
                }
                if (n3 == 0) {
                    return this.getSoftStereoBlendCoeff();
                }
                if (n3 == 1) {
                    return this.getSoftMuteCoeff();
                }
                if (n3 == 2) {
                    return this.getSoftStereoBlendRef();
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("getLongTunningParameter() : invalid parameterName - ");
                sb3.append(s);
                sb3.append(" for chip vendor - ");
                sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb3.toString());
            }
            return n;
        }
        return this.getCurrentRSSI();
    }

    public void setStringTunningParameter(final String s, final String hybridSearch) {
        if (!this.isValidPackage()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("setStringTunningParameter: parameterName - ");
        sb.append(s);
        sb.append("  value: ");
        sb.append(hybridSearch);
        log(sb.toString());
        if (s == null) {
            log("setStringTunningParameter:  parameterName is null. So do nothing");
            return;
        }
        final int chip_VENDOR = FMRadioServiceFeature.CHIP_VENDOR;
        final int n = 0;
        int n2 = 0;
        if (chip_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9) {
            if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                final int hashCode = s.hashCode();
                Label_0156: {
                    if (hashCode != -2137129525) {
                        if (hashCode == -904795186 && s.equals("FakeChannel")) {
                            break Label_0156;
                        }
                    }
                    else if (s.equals("DeSenseList")) {
                        n2 = 1;
                        break Label_0156;
                    }
                    n2 = -1;
                }
                if (n2 != 0) {
                    if (n2 != 1) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("setStringTunningParameter() : invalid parameterName - ");
                        sb2.append(s);
                        sb2.append(" for chip vendor - ");
                        sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
                        log(sb2.toString());
                    }
                    else {
                        this.setDeSenseList(hybridSearch);
                    }
                }
                else {
                    this.setFakeChannel(hybridSearch);
                }
            }
            else {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("setStringTunningParameter() : this parameter is not support yet - ");
                sb3.append(s);
                sb3.append(" chipvendor - ");
                sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb3.toString());
            }
        }
        else {
            int n3;
            if (s.hashCode() == -313550108 && s.equals("HybridSearch")) {
                n3 = n;
            }
            else {
                n3 = -1;
            }
            if (n3 != 0) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("setStringTunningParameter() : invalid parameterName - ");
                sb4.append(s);
                sb4.append(" for chip vendor - ");
                sb4.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb4.toString());
            }
            else {
                this.setHybridSearch(hybridSearch);
            }
        }
    }

    public String getStringTunningParameter(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("getStringTunningParameter: parameterName - ");
        sb.append(s);
        log(sb.toString());
        if (s == null) {
            log("getStringTunningParameter:  parameterName is null. So do nothing");
            return s2;
        }
        final int chip_VENDOR = FMRadioServiceFeature.CHIP_VENDOR;
        final int n = 0;
        int n2 = 0;
        if (chip_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9) {
            if (FMRadioServiceFeature.CHIP_VENDOR == 8) {
                final int hashCode = s.hashCode();
                Label_0133: {
                    if (hashCode != -2137129525) {
                        if (hashCode == -904795186 && s.equals("FakeChannel")) {
                            break Label_0133;
                        }
                    }
                    else if (s.equals("DeSenseList")) {
                        n2 = 1;
                        break Label_0133;
                    }
                    n2 = -1;
                }
                if (n2 == 0) {
                    return this.getFakeChannel();
                }
                if (n2 == 1) {
                    return this.getDeSenseList();
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("getStringTunningParameter() : invalid parameterName - ");
                sb2.append(s);
                sb2.append(" for chipvendor - ");
                sb2.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb2.toString());
            }
            else {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("getStringTunningParameter() : this parameter is not support yet - ");
                sb3.append(s);
                sb3.append(" chipvendor - ");
                sb3.append(FMRadioServiceFeature.CHIP_VENDOR);
                log(sb3.toString());
            }
        }
        else {
            int n3;
            if (s.hashCode() == -313550108 && s.equals("HybridSearch")) {
                n3 = n;
            }
            else {
                n3 = -1;
            }
            if (n3 == 0) {
                return this.getHybridSearch();
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("getStringTunningParameter() : invalid parameterName - ");
            sb4.append(s);
            sb4.append(" for chipvendor - ");
            sb4.append(FMRadioServiceFeature.CHIP_VENDOR);
            log(sb4.toString());
        }
        return s2;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
            unregisterSystemListener();
            unRegisterSetPropertyListener();
            unRegisterMDMCommandRec();
            this.mScanProgress = false;
        } catch (Error e) {
            Log.e("FMRadioService", "Exception in finalize() : " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSignalSetting(int rssi, int snr, int cnt) {
        if (this.mIsOn && !this.mIsExternalChipset) {
            this.mPlayerNative.setRSSI_th(rssi);
            this.mPlayerNative.setSNR_th(snr);
            this.mPlayerNative.setCnt_th(cnt);
        }
    }

    /* loaded from: classes4.dex */
    class ScanThread extends Thread
    {
        private void doScan() throws InterruptedException {
            if (FMRadioService.this.mIsExternalChipset) {
                if (FMRadioService.this.mBand == 0) {
                    FMRadioService.this.mPlayerExternalChipset.tune(8750);
                }
                if (FMRadioService.this.mBand == 1 || FMRadioService.this.mBand == 2) {
                    FMRadioService.this.mPlayerExternalChipset.tune(7600);
                }
                if (FMRadioService.this.mBand == 3) {
                    FMRadioService.this.mPlayerExternalChipset.tune(6400);
                }
            }
            else if (FMRadioService.this.mBand == 1) {
                if (FMRadioServiceFeature.CHIP_VENDOR == 2) {
                    FMRadioService.this.mPlayerNative.tune(108000L);
                }
                else {
                    FMRadioService.this.mPlayerNative.tune(87500L);
                }
            }
            else {
                FMRadioService.this.mPlayerNative.tune(76000L);
            }
            if (FMRadioServiceFeature.CHIP_VENDOR == 4 || FMRadioServiceFeature.CHIP_VENDOR == 9 || FMRadioService.this.mIsExternalChipset) {
                FMRadioService.this.mPreviousFoundFreq = 0L;
                FMRadioService.this.mCurrentFoundFreq = 0L;
            }
            if (!FMRadioServiceFeature.FEATURE_DISABLEDNS && FMRadioService.this.mWaitPidDuringScanning && !FMRadioService.this.mIsExternalChipset) {
                FMRadioService.this.mPlayerNative.setScanning(true);
            }
            if (FMRadioServiceFeature.CHIP_VENDOR == 1) {
                long n;
                if (FMRadioService.this.mBand == 1) {
                    n = 87500L;
                }
                else {
                    n = 76000L;
                }
                if (FMRadioService.this.checkBaseFreq() && FMRadioService.this.mScanProgress) {
                    if (FMRadioService.DEBUGGABLE) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Found channel :");
                        sb.append(n);
                        FMRadioService.log(sb.toString());
                    }
                    FMRadioService.this.mScanChannelList.add(n);
                    FMRadioService.this.notifyEvent(1, (Object)n);
                    if (!FMRadioServiceFeature.FEATURE_DISABLEDNS && FMRadioService.this.mWaitPidDuringScanning && FMRadioService.this.mScanThread != null) {
                        synchronized (FMRadioService.this.mScanThread) {
                            FMRadioService.this.mScanThread.wait(250L);
                        }
                    }
                }
            }
            while (FMRadioService.this.mScanProgress) {
                final long searchAll = FMRadioService.this.searchAll();
                if (FMRadioService.DEBUGGABLE) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Found channel :");
                    sb2.append(searchAll);
                    FMRadioService.log(sb2.toString());
                }
                if (FMRadioServiceFeature.CHIP_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9 && !FMRadioService.this.mIsExternalChipset && FMRadioService.this.mScanChannelList.contains(searchAll)) {
                    if (!FMRadioService.DEBUGGABLE) {
                        continue;
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Duplicate channel :");
                    sb3.append(searchAll);
                    FMRadioService.log(sb3.toString());
                }
                else {
                    if (searchAll <= 0L) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Testmode Skipp value : ");
                        sb4.append(FMRadioService.this.mIsSkipTunigVal);
                        FMRadioService.log(sb4.toString());
                        if (FMRadioService.this.mIsExternalChipset) {
                            FMRadioService.this.mPlayerExternalChipset.stopNotifyThread(true);
                        }
                        final FMRadioService this$0 = FMRadioService.this;
                        this$0.notifyEvent(3, (Object)FMRadioService.this.mScanChannelList.toArray(new Long[0]));
                        Thread.sleep(20L);
                        break;
                    }
                    if (FMRadioService.this.mScanFreq <= 0L) {
                        FMRadioService.this.mScanFreq = searchAll;
                    }
                    if (FMRadioServiceFeature.CHIP_VENDOR != 4 && FMRadioServiceFeature.CHIP_VENDOR != 9 && !FMRadioService.this.mIsExternalChipset) {
                        if (FMRadioService.this.mScanProgress) {
                            FMRadioService.this.mScanChannelList.add(searchAll);
                            FMRadioService.this.notifyEvent(1, (Object)searchAll);
                            if (!FMRadioServiceFeature.FEATURE_DISABLEDNS && FMRadioService.this.mWaitPidDuringScanning && FMRadioService.this.mScanThread != null) {
                                synchronized (FMRadioService.this.mScanThread) {
                                    FMRadioService.this.mScanThread.wait(250L);
                                }
                            }
                        }
                        if (((FMRadioService.this.mBand != 1 && FMRadioService.this.mBand != 2) || searchAll != 108000L) && (FMRadioService.this.mBand != 3 || searchAll != 90000L)) {
                            continue;
                        }
                        FMRadioService.this.notifyEvent(3, (Object)FMRadioService.this.mScanChannelList.toArray(new Long[0]));
                        Thread.sleep(20L);
                        break;
                    }
                    else {
                        FMRadioService.this.mCurrentFoundFreq = searchAll;
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("scanning current and prev freq:");
                        sb5.append(FMRadioService.this.mCurrentFoundFreq);
                        sb5.append(", ");
                        sb5.append(FMRadioService.this.mPreviousFoundFreq);
                        FMRadioService.log(sb5.toString());
                        if (FMRadioService.this.mPreviousFoundFreq >= FMRadioService.this.mCurrentFoundFreq) {
                            FMRadioService.log("scanning finish");
                            if (FMRadioService.this.mCurrentFoundFreq == 87500L) {
                                FMRadioService.this.mScanChannelList.add(searchAll);
                                FMRadioService.this.notifyEvent(1, (Object)searchAll);
                            }
                            if (FMRadioService.this.mIsExternalChipset) {
                                FMRadioService.this.mPlayerExternalChipset.stopNotifyThread(true);
                            }
                            final FMRadioService this$3 = FMRadioService.this;
                            this$3.notifyEvent(3, (Object)FMRadioService.this.mScanChannelList.toArray(new Long[0]));
                            Thread.sleep(20L);
                            break;
                        }
                        if (!FMRadioService.this.mScanProgress) {
                            continue;
                        }
                        FMRadioService.log("scanning found channel");
                        final FMRadioService this$4 = FMRadioService.this;
                        this$4.mPreviousFoundFreq = this$4.mCurrentFoundFreq;
                        FMRadioService.this.mScanChannelList.add(searchAll);
                        FMRadioService.this.notifyEvent(1, (Object)searchAll);
                        if (FMRadioServiceFeature.FEATURE_DISABLEDNS || !FMRadioService.this.mWaitPidDuringScanning || FMRadioService.this.mScanThread == null) {
                            continue;
                        }
                        synchronized (FMRadioService.this.mScanThread) {
                            FMRadioService.this.mScanThread.wait(250L);
                        }
                    }
                }
            }
            if (!FMRadioServiceFeature.FEATURE_DISABLEDNS && FMRadioService.this.mWaitPidDuringScanning && !FMRadioService.this.mIsExternalChipset) {
                FMRadioService.this.mPlayerNative.setScanning(false);
            }
        }

        @Override
        public void run() {
            @SuppressLint("InvalidWakeLockTag") final PowerManager.WakeLock wakeLock = FMRadioService.this.mPowerManager.newWakeLock(536870913, "FMRadio Service Scan Thread");
            wakeLock.acquire();
            FMRadioService.log("Scan thread gets the dimmed screen lock");
            try {
                Label_0474: {
                    try {
                        FMRadioService.log("Scanning Thread started...");
                        FMRadioService.this.notifyEvent(2, (Object)null);
                        if (FMRadioServiceFeature.CHIP_VENDOR == 9) {
                            if (FMRadioService.this.isUnMuteRadio()) {
                                FMRadioService.this.mAudioManager.setParameters("g_fmradio_mute=true");
                            }
                        }
                        else if (!FMRadioService.this.mIsExternalChipset) {
                            FMRadioService.this.setFMAudioPath(false);
                        }
                        else {
                            FMRadioService.this.mPlayerExternalChipset.muteOn();
                        }
                        FMRadioService.log("Scanning Thread started... - Turning off FM");
                        FMRadioService.this.mScanFreq = FMRadioService.this.getCurrentChannel();
                        if (FMRadioService.this.mScanChannelList == null) {
                            FMRadioService.this.mScanChannelList = new ArrayList();
                        }
                        else {
                            FMRadioService.this.mScanChannelList.clear();
                        }
                        if (FMRadioService.this.mIsSkipTunigVal && !FMRadioService.this.mIsExternalChipset) {
                            FMRadioService.this.setSignalSetting(FMRadioService.this.mRssi_th, FMRadioService.this.mSnr_th, FMRadioService.this.mCnt_th);
                            final StringBuilder sb = new StringBuilder();
                            sb.append("first scan no block channel with ");
                            sb.append((FMRadioService.this.mRssi_th));
                            sb.append((FMRadioService.this.mSnr_th));
                            sb.append((FMRadioService.this.mCnt_th));
                            FMRadioService.log(sb.toString());
                        }
                        if (FMRadioService.this.mIsExternalChipset) {
                            if (!FMRadioService.this.mPlayerExternalChipset.startNotifyThread(true)) {
                                if (FMRadioService.this.mScanChannelList == null) {
                                    FMRadioService.this.mScanChannelList = new ArrayList();
                                }
                                else {
                                    FMRadioService.this.mScanChannelList.clear();
                                }
                                FMRadioService.this.notifyEvent(3, (Object)FMRadioService.this.mScanChannelList.toArray(new Long[0]));
                            }
                            else {
                                this.doScan();
                            }
                        }
                        else {
                            this.doScan();
                        }
                        FMRadioService.this.mScanProgress = false;
                        FMRadioService.this.mScanThread = (Thread)null;
                        if (wakeLock.isHeld()) {
                            break Label_0474;
                        }
                        break Label_0474;
                    }
                    finally {
                        FMRadioService.this.mScanProgress = false;
                        FMRadioService.this.mScanThread = (Thread)null;
                        if (wakeLock.isHeld()) {
                            wakeLock.release();
                            FMRadioService.log("Scan thread released the dimmed screen lock");
                        }
                        wakeLock.release();
                        FMRadioService.log("Scan thread released the dimmed screen lock");
                        FMRadioService.log("Scanning Thread work is done...");
                    }
                }
            }
            catch (final Exception ex) {}
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public void setInternetStreamingMode(boolean mode) {
        if (!isValidPackage()) {
            return;
        }
        log("setInternetStreamingMode :: mode:" + mode);
        this.mInternetStreamingMode = mode;
        if (mode) {
            setVolume(0L);
        } else {
            setVolume(this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)));
        }
    }

    public void notifyRecFinish() {
        log("notifyRecFinish EVENT_REC_FINISH");
        notifyEvent(17, null);
        this.mAudioManager.setParameters("fmradio_recoding=off");
    }

    private String getPropertyProductName() {
        return SystemProperties.get("ro.product.name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBikeMode() {
        boolean z = false;
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), AudioConstants.SETTING_BIKE_MODE, 0) == 1) {
            z = true;
        }
        this.mBikeMode = z;
        if (z) {
            log("bike mode enabled");
            offInternal(4, true);
            return;
        }
        log("bike mode disabled");
    }

    public boolean isDNDEnable() {
        // boolean dndOn = Settings.Global.getInt(this.mContext.getContentResolver(), Settings.Global.ZEN_MODE, 0) == 1;
        boolean dndOn = false;
        @SuppressLint("WrongConstant") NotificationManager mNm = (NotificationManager) this.mContext.getSystemService("notification");
        NotificationManager.Policy zenPolicy = mNm.getNotificationPolicy();
        boolean muteMedia = (zenPolicy.priorityCategories & 64) == 0;
        return dndOn && muteMedia;
    }

    public boolean isAllSoundOff() {
        return Settings.System.getInt(this.mContext.getContentResolver(), AudioConstants.SETTING_ALL_SOUND_OFF, 0) == 1;
    }


    /* JADX INFO: Access modifiers changed from: private */
    public void setFMAudioPath(boolean isOn) {
        String keyValuePairs;
        log("setFMAudioPath : " + isOn + " mIsFMAudioPathOn : " + this.mIsFMAudioPathOn);
        if (isOn == this.mIsFMAudioPathOn) {
            return;
        }
        this.mIsFMAudioPathOn = isOn;
        if (isOn) {
            this.modSamsungSetRadioOutputPath(0 | AudioManager.MOD_RADIO_OUTPUT_PATH_IS_FMRADIO_ON);

            keyValuePairs = "g_fmradio_enable=true";
            this.mAudioManager.setParameters(keyValuePairs);

            this.mAudioManager.modStartDummyAudio();

            this.mAudioManager.setParameters("l_fmradio_mode=on");
            android.media.AudioSystem.setDeviceConnectionState(-2147475456, 1, "dummy", "", 0);
            this.mAudioManager.setParameters("l_fmradio_volume=0.1");
        } else {
            keyValuePairs = "g_fmradio_enable=false";
            this.mAudioManager.setParameters(keyValuePairs);
            android.media.AudioSystem.setDeviceConnectionState(-2147475456, 0, "dummy", "", 0);
            this.mAudioManager.setParameters("l_fmradio_mode=off");
            this.mAudioManager.modStopDummyAudio();
            this.modSamsungSetRadioOutputPath(0);
        }
    }

    private boolean isCherokeeChip() {
        return FMRadioServiceFeature.CHIP_VENDOR == 9;
    }

    private void setSlimbusEnable(int mode) {
        log("setSlimbusEnable " + mode);
        log("isCherokeeChip: " + isCherokeeChip() + " volumeLock: " + this.volumeLock);
        if (isCherokeeChip() && !this.volumeLock) {
            this.mPlayerNative.setSlimbusEnable(mode);
        } else {
            log("setSlimbusEnable : Not applicable");
        }
    }

    @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
    public boolean isDeviceSpeakerEnabled() {
        return this.mIsMDMSpeakerEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDelay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Log.e("FMRadioService", "InterruptedException in sleep() : " + e);
        }
    }

    public boolean isUnMuteRadio() {
        return this.mAudioManager.getStreamVolume(AudioManager.modSamsungGetStreamType(1)) > 0 && !isAllSoundOff() && !isDNDEnable();
    }

    public boolean isPathSupportSoftmute(int path) {
        if (!"Both".equals(this.mSoftmutePath)) {
            if (!"Speaker".equals(this.mSoftmutePath) || path != 2) {
                if ("Headset".equals(this.mSoftmutePath) && path == 3) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class SamsungAnalyticsRunnable implements Runnable {
        private String packageName;
        private String version;

        public SamsungAnalyticsRunnable(String PackageName, String Version) {
            this.packageName = PackageName;
            this.version = Version;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FMRadioService.this.sendInfoSamsungAnalytics(this.packageName, this.version);
            } catch (Exception e) {
                Log.e("FMRadioService", "SamsungAnalyticsRunnable Exception: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInfoSamsungAnalytics(String packageName, String version) {
        log("sendInfoSamsungAnalytics ,packageName : " + packageName + ", version : " + version);
        Bundle bundle = new Bundle();
        bundle.putString(SemShareConstants.DMA_SURVEY_FEATURE_TRACKING_ID, SA_TRACKING_ID);
        bundle.putString(SemShareConstants.SURVEY_CONTENT_FEATURE, SA_FEATURE);
        JSONObject jobj = new JSONObject();
        try {
            jobj.put("sm_sdk_id", SA_SM_SDK_ID);
            jobj.put("sm_sdk_client_pkg_name", packageName);
            jobj.put("sm_sdk_client_pkg_version", version);
        } catch (JSONException e) {
            Log.e("FMRadioService", "JSONException: " + e);
        }
        log("SALog jsonstring: " + jobj.toString());
        bundle.putString(SemShareConstants.SURVEY_CONTENT_EXTRA, jobj.toString());
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("com.sec.android.diagmonagent.intent.USE_APP_FEATURE_SURVEY");
        broadcastIntent.putExtras(bundle);
        broadcastIntent.setPackage("com.sec.android.diagmonagent");
        log("SALog sendbroadcast");
        this.mContext.sendBroadcast(broadcastIntent);
    }
}
