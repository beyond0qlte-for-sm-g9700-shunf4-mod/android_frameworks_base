package com.android.server;

import com.samsung.android.feature.SemCscFeature;
import com.samsung.android.feature.SemFloatingFeature;

/* loaded from: classes4.dex */
public class FMRadioServiceFeature {
    public static final String BANDWIDTHAS_76000_108000 = "76000_108000";
    public static final String BANDWIDTHAS_76000_90000 = "76000_90000";
    public static final String BANDWIDTHAS_87500_108000 = "87500_108000";
    public static final int CHIP_BRAODCOM = 2;
    public static final int CHIP_MRVL = 3;
    public static final int CHIP_MTK = 8;
    public static final int CHIP_QCOM = 4;
    public static final int CHIP_QCOM_CHROKEE = 9;
    public static final int CHIP_RICHWAVE = 5;
    public static final int CHIP_RICHWAVE_V2 = 10;
    public static final int CHIP_SILICON = 1;
    public static final int CHIP_SLSI = 7;
    public static final int CHIP_SPRD = 6;
    public static final int CHIP_VENDOR;
    public static final String FEATURE_BANDWIDTH;
    public static final String FEATURE_CONFIG_SOFTMUTE;
    public static final int FEATURE_DECONSTANT;
    public static final boolean FEATURE_DISABLEDNS;
    public static final boolean FEATURE_FMRADIO_SUPPORT_EXTERNAL_RADIO_CHIPSET;
    public static final int FEATURE_FREQUENCYSPACE;
    public static final String FEATURE_SETLOCALTUNNING;
    public static final String FEATURE_SOFTMUTE;
    public static final boolean FEATURE_SUPPORT_SOFTMUTE;
    public static final boolean FEATURE_USE_CHIPSET_VOLUME;
    public static final boolean FEATURE_WAIT_PID_DURING_SCAN = false;
    public static SemCscFeature sCscFeature;

    static {
        SemCscFeature semCscFeature = SemCscFeature.getInstance();
        sCscFeature = semCscFeature;
        FEATURE_SETLOCALTUNNING = semCscFeature.getString("CscFeature_FMRadio_SetLocalTunning");
        FEATURE_BANDWIDTH = sCscFeature.getString("CscFeature_FMRadio_BandWidthAs");
        FEATURE_FREQUENCYSPACE = sCscFeature.getInteger("CscFeature_FMRadio_FrequencySpaceAs");
        FEATURE_DECONSTANT = sCscFeature.getInteger("CscFeature_FMRadio_DeconstantAs");
        FEATURE_SOFTMUTE = sCscFeature.getString("CscFeature_FMRadio_DefaultSoftMuteValue");
        boolean z = false;
        FEATURE_DISABLEDNS = !SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FMRADIO_SUPPORT_HYBRID_RADIO") || sCscFeature.getBoolean("CscFeature_FMRadio_DisableMenuInternetRadio");
        FEATURE_CONFIG_SOFTMUTE = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_COMMON_SOFTMUTE_TH");
        FEATURE_SUPPORT_SOFTMUTE = SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FMRADIO_SUPPORT_SOFTMUTE");
        int parseInt = Integer.parseInt(SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_CHIP_VENDOR"));
        CHIP_VENDOR = parseInt;
        if (parseInt == 2 || parseInt == 1 || parseInt == 5 || parseInt == 10 || parseInt == 7) {
            z = true;
        }
        FEATURE_USE_CHIPSET_VOLUME = z;
        FEATURE_FMRADIO_SUPPORT_EXTERNAL_RADIO_CHIPSET = SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FMRADIO_SUPPORT_EXTERNAL_RADIO_CHIPSET");
    }
}