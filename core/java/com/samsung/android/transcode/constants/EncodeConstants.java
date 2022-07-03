package com.samsung.android.transcode.constants;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class EncodeConstants {
    public static final int Error_Codec_Config = -1003;
    public static final int Error_Invalid_File = -1001;
    public static final int Error_None = 0;
    public static final int Error_Resolution_limit = -1004;
    public static final int Error_Unsupported_Codec = -1002;

    /* loaded from: classes4.dex */
    public static final class BitRate {
        public static final int AUDIO_AAC_BITRATE = 128;
        public static final int MID_AUDIO_AAC_BITRATE = 64;
        public static final int MIN_AUDIO_AAC_BITRATE = 32;
        public static final int MIN_AUDIO_AMR_BITRATE = 8;
        public static final int VIDEO_D1_BITRATE = 5000;
        public static final int VIDEO_FHD_BITRATE = 13000;
        public static final int VIDEO_HD_BITRATE = 8000;
        public static final int VIDEO_QCIF_BITRATE = 280;
        public static final int VIDEO_QHD_BITRATE = 18000;
        public static final int VIDEO_QVGA_BITRATE = 512;
        public static final int VIDEO_UHD_BITRATE = 35000;
        public static final int VIDEO_VGA_BITRATE = 5000;
    }

    /* loaded from: classes4.dex */
    public static final class CodecsMime {
        public static final String AUDIO_CODEC_AAC = "audio/mp4a-latm";
        public static final String AUDIO_CODEC_AMR = "audio/3gpp";
        public static final String VIDEO_CODEC_H263 = "video/3gpp";
        public static final String VIDEO_CODEC_H264 = "video/avc";
        public static final String VIDEO_CODEC_H265 = "video/hevc";
    }

    /* loaded from: classes4.dex */
    public static final class EncodeResolution {

        /* renamed from: D1 */
        public static final int f952D1 = 4;
        public static final int FULL_HD = 6;

        /* renamed from: HD */
        public static final int f953HD = 5;
        public static final int QCIF = 1;
        public static final int QHD = 7;
        public static final int QVGA = 2;
        public static final int UHD = 8;
        public static final int VGA = 3;
    }

    /* loaded from: classes4.dex */
    public static final class HDRType {
        public static final int HDR_10 = 1;
        public static final int HDR_10_PLUS = 2;
        public static final int NONE_HDR = 0;
    }

    /* loaded from: classes4.dex */
    public static final class RecordingMode {
        public static final int FAST = 2;
        public static final int HDR_10 = 11;
        public static final int HDR_10_PLUS = 10;
        public static final int NORMAL = 0;
        public static final int SLOW = 1;
        public static final int SLOW_V2 = 12;
        public static final int SLOW_V2_120 = 13;
        public static final int SLOW_V2_120_NONE_SVC = 15;
        public static final int SUPER_SLOW = 8;
        public static final int SUPER_SLOW_FRC = 9;
        public static final int SUPER_SLOW_SINGLE = 7;
    }

    /* loaded from: classes4.dex */
    public static final class ContentType {
        public static final String VIDEO_3G2 = "video/3gpp2";
        public static final String VIDEO_3GP = "video/3gp";
        public static final String VIDEO_3GPP = "video/3gpp";
        public static final String VIDEO_ASF = "video/x-ms-asf";
        public static final String VIDEO_AVI = "video/avi";
        public static final String VIDEO_DIVX = "video/divx";
        public static final String VIDEO_FLV = "video/flv";
        public static final String VIDEO_MKV = "video/x-matroska";
        public static final String VIDEO_MP4 = "video/mp4";
        public static final String VIDEO_MP4V_ES = "video/mp4v-es";
        public static final String VIDEO_MPEG = "video/mpeg";
        public static final String VIDEO_MPEG2TS = "video/mp2ts";
        public static final String VIDEO_WEBM = "video/webm";
        public static final String VIDEO_WMV = "video/x-ms-wmv";
        public static final ArrayList<String> sSupportedVideoTypes;

        static {
            ArrayList<String> arrayList = new ArrayList<>();
            sSupportedVideoTypes = arrayList;
            arrayList.add("video/3gpp");
            sSupportedVideoTypes.add("video/3gpp2");
            sSupportedVideoTypes.add("video/mp4");
            sSupportedVideoTypes.add("video/mp4v-es");
            sSupportedVideoTypes.add("video/3gp");
            sSupportedVideoTypes.add("video/avi");
            sSupportedVideoTypes.add("video/x-ms-wmv");
            sSupportedVideoTypes.add("video/x-ms-asf");
            sSupportedVideoTypes.add("video/divx");
            sSupportedVideoTypes.add("video/mpeg");
            sSupportedVideoTypes.add(VIDEO_MKV);
            sSupportedVideoTypes.add(VIDEO_FLV);
            sSupportedVideoTypes.add(VIDEO_MPEG2TS);
            sSupportedVideoTypes.add(VIDEO_WEBM);
        }
    }
}