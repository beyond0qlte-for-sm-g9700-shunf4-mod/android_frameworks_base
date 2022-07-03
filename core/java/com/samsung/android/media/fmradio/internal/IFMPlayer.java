package com.samsung.android.media.fmradio.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.samsung.android.media.fmradio.internal.IFMEventListener;

/* loaded from: classes4.dex */
public interface IFMPlayer extends IInterface {
    boolean modSamsungSetRadioOutputPath(int path) throws RemoteException;
    int modSamsungGetRadioOutputPath() throws RemoteException;

    void cancelAFSwitching() throws RemoteException;

    boolean cancelScan() throws RemoteException;

    void cancelSeek() throws RemoteException;

    void disableAF() throws RemoteException;

    void disableDNS() throws RemoteException;

    void disableRDS() throws RemoteException;

    void enableAF() throws RemoteException;

    void enableDNS() throws RemoteException;

    void enableRDS() throws RemoteException;

    long getCurrentChannel() throws RemoteException;

    int getIntegerTunningParameter(String str, int i) throws RemoteException;

    long[] getLastScanResult() throws RemoteException;

    long getLongTunningParameter(String str, long j) throws RemoteException;

    long getMaxVolume() throws RemoteException;

    long getPlayedFreq() throws RemoteException;

    boolean getSoftMuteMode() throws RemoteException;

    String getStringTunningParameter(String str, String str2) throws RemoteException;

    long getVolume() throws RemoteException;

    boolean isAFEnable() throws RemoteException;

    boolean isAirPlaneMode() throws RemoteException;

    boolean isBatteryLow() throws RemoteException;

    int isBusy() throws RemoteException;

    boolean isDNSEnable() throws RemoteException;

    boolean isDeviceSpeakerEnabled() throws RemoteException;

    boolean isHeadsetPlugged() throws RemoteException;

    boolean isOn() throws RemoteException;

    boolean isRDSEnable() throws RemoteException;

    boolean isScanning() throws RemoteException;

    boolean isSeeking() throws RemoteException;

    boolean isTvOutPlugged() throws RemoteException;

    void mute(boolean z) throws RemoteException;

    boolean off() throws RemoteException;

    /* renamed from: on */
    boolean on() throws RemoteException;

    boolean on_in_testmode() throws RemoteException;

    void removeListener(IFMEventListener iFMEventListener) throws RemoteException;

    void scan() throws RemoteException;

    long searchAll() throws RemoteException;

    long searchDown() throws RemoteException;

    long searchUp() throws RemoteException;

    long seekDown() throws RemoteException;

    long seekUp() throws RemoteException;

    void setBand(int i) throws RemoteException;

    void setChannelSpacing(int i) throws RemoteException;

    void setFMIntenna(boolean z) throws RemoteException;

    void setIntegerTunningParameter(String str, int i) throws RemoteException;

    void setInternetStreamingMode(boolean z) throws RemoteException;

    void setListener(IFMEventListener iFMEventListener) throws RemoteException;

    void setLongTunningParameter(String str, long j) throws RemoteException;

    void setMono() throws RemoteException;

    void setRecordMode(boolean z) throws RemoteException;

    void setSoftmute(boolean z) throws RemoteException;

    void setSpeakerOn(boolean z) throws RemoteException;

    void setStereo() throws RemoteException;

    void setStringTunningParameter(String str, String str2) throws RemoteException;

    void setVolume(long j) throws RemoteException;

    void tune(long j) throws RemoteException;

    /* loaded from: classes4.dex */
    public static class Default implements IFMPlayer {
        @Override public boolean modSamsungSetRadioOutputPath(int path) throws RemoteException { return false; }
        @Override public int modSamsungGetRadioOutputPath() throws RemoteException { return 0; }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setListener(IFMEventListener listener) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void removeListener(IFMEventListener listener) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void tune(long freq) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        /* renamed from: on */
        public boolean on() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean on_in_testmode() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean off() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isOn() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long seekUp() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long seekDown() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void cancelSeek() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long getCurrentChannel() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void scan() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean cancelScan() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isScanning() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isSeeking() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long searchDown() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long searchUp() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long searchAll() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long getPlayedFreq() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void enableRDS() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void disableRDS() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void enableDNS() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void disableDNS() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isDNSEnable() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void enableAF() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void disableAF() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setBand(int band) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setChannelSpacing(int spacing) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public int isBusy() throws RemoteException {
            return 0;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isRDSEnable() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isAFEnable() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void cancelAFSwitching() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long[] getLastScanResult() throws RemoteException {
            return null;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setStereo() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setMono() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setVolume(long val) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long getVolume() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isHeadsetPlugged() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isTvOutPlugged() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setSpeakerOn(boolean bSpeakerOn) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setRecordMode(boolean isRecord) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long getMaxVolume() throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isAirPlaneMode() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void mute(boolean value) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isBatteryLow() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setFMIntenna(boolean setFMIntenna) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setSoftmute(boolean state) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean getSoftMuteMode() throws RemoteException {
            return false;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setInternetStreamingMode(boolean mode) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setIntegerTunningParameter(String parameterName, int value) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public int getIntegerTunningParameter(String parameterName, int defaultValue) throws RemoteException {
            return 0;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setLongTunningParameter(String parameterName, long value) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public long getLongTunningParameter(String parameterName, long defaultValue) throws RemoteException {
            return 0L;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public void setStringTunningParameter(String parameterName, String value) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public String getStringTunningParameter(String parameterName, String defaultValue) throws RemoteException {
            return null;
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
        public boolean isDeviceSpeakerEnabled() throws RemoteException {
            return false;
        }

        @Override // android.p007os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IFMPlayer {
        private static final String DESCRIPTOR = "com.samsung.android.media.fmradio.internal.IFMPlayer";
        static final int TRANSACTION_modSamsungSetRadioOutputPath = 10088;
        static final int TRANSACTION_modSamsungGetRadioOutputPath = 10089;
        static final int TRANSACTION_cancelAFSwitching = 32;
        static final int TRANSACTION_cancelScan = 13;
        static final int TRANSACTION_cancelSeek = 10;
        static final int TRANSACTION_disableAF = 26;
        static final int TRANSACTION_disableDNS = 23;
        static final int TRANSACTION_disableRDS = 21;
        static final int TRANSACTION_enableAF = 25;
        static final int TRANSACTION_enableDNS = 22;
        static final int TRANSACTION_enableRDS = 20;
        static final int TRANSACTION_getCurrentChannel = 11;
        static final int TRANSACTION_getIntegerTunningParameter = 51;
        static final int TRANSACTION_getLastScanResult = 33;
        static final int TRANSACTION_getLongTunningParameter = 53;
        static final int TRANSACTION_getMaxVolume = 42;
        static final int TRANSACTION_getPlayedFreq = 19;
        static final int TRANSACTION_getSoftMuteMode = 48;
        static final int TRANSACTION_getStringTunningParameter = 55;
        static final int TRANSACTION_getVolume = 37;
        static final int TRANSACTION_isAFEnable = 31;
        static final int TRANSACTION_isAirPlaneMode = 43;
        static final int TRANSACTION_isBatteryLow = 45;
        static final int TRANSACTION_isBusy = 29;
        static final int TRANSACTION_isDNSEnable = 24;
        static final int TRANSACTION_isDeviceSpeakerEnabled = 56;
        static final int TRANSACTION_isHeadsetPlugged = 38;
        static final int TRANSACTION_isOn = 7;
        static final int TRANSACTION_isRDSEnable = 30;
        static final int TRANSACTION_isScanning = 14;
        static final int TRANSACTION_isSeeking = 15;
        static final int TRANSACTION_isTvOutPlugged = 39;
        static final int TRANSACTION_mute = 44;
        static final int TRANSACTION_off = 6;
        static final int TRANSACTION_on = 4;
        static final int TRANSACTION_on_in_testmode = 5;
        static final int TRANSACTION_removeListener = 2;
        static final int TRANSACTION_scan = 12;
        static final int TRANSACTION_searchAll = 18;
        static final int TRANSACTION_searchDown = 16;
        static final int TRANSACTION_searchUp = 17;
        static final int TRANSACTION_seekDown = 9;
        static final int TRANSACTION_seekUp = 8;
        static final int TRANSACTION_setBand = 27;
        static final int TRANSACTION_setChannelSpacing = 28;
        static final int TRANSACTION_setFMIntenna = 46;
        static final int TRANSACTION_setIntegerTunningParameter = 50;
        static final int TRANSACTION_setInternetStreamingMode = 49;
        static final int TRANSACTION_setListener = 1;
        static final int TRANSACTION_setLongTunningParameter = 52;
        static final int TRANSACTION_setMono = 35;
        static final int TRANSACTION_setRecordMode = 41;
        static final int TRANSACTION_setSoftmute = 47;
        static final int TRANSACTION_setSpeakerOn = 40;
        static final int TRANSACTION_setStereo = 34;
        static final int TRANSACTION_setStringTunningParameter = 54;
        static final int TRANSACTION_setVolume = 36;
        static final int TRANSACTION_tune = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFMPlayer asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IFMPlayer)) {
                return (IFMPlayer) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.p007os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 10088:
                    return "modSamsungSetRadioOutputPath";
                case 10089:
                    return "modSamsungGetRadioOutputPath";
                case 1:
                    return "setListener";
                case 2:
                    return "removeListener";
                case 3:
                    return "tune";
                case 4:
                    return "on";
                case 5:
                    return "on_in_testmode";
                case 6:
                    return "off";
                case 7:
                    return "isOn";
                case 8:
                    return "seekUp";
                case 9:
                    return "seekDown";
                case 10:
                    return "cancelSeek";
                case 11:
                    return "getCurrentChannel";
                case 12:
                    return "scan";
                case 13:
                    return "cancelScan";
                case 14:
                    return "isScanning";
                case 15:
                    return "isSeeking";
                case 16:
                    return "searchDown";
                case 17:
                    return "searchUp";
                case 18:
                    return "searchAll";
                case 19:
                    return "getPlayedFreq";
                case 20:
                    return "enableRDS";
                case 21:
                    return "disableRDS";
                case 22:
                    return "enableDNS";
                case 23:
                    return "disableDNS";
                case 24:
                    return "isDNSEnable";
                case 25:
                    return "enableAF";
                case 26:
                    return "disableAF";
                case 27:
                    return "setBand";
                case 28:
                    return "setChannelSpacing";
                case 29:
                    return "isBusy";
                case 30:
                    return "isRDSEnable";
                case 31:
                    return "isAFEnable";
                case 32:
                    return "cancelAFSwitching";
                case 33:
                    return "getLastScanResult";
                case 34:
                    return "setStereo";
                case 35:
                    return "setMono";
                case 36:
                    return "setVolume";
                case 37:
                    return "getVolume";
                case 38:
                    return "isHeadsetPlugged";
                case 39:
                    return "isTvOutPlugged";
                case 40:
                    return "setSpeakerOn";
                case 41:
                    return "setRecordMode";
                case 42:
                    return "getMaxVolume";
                case 43:
                    return "isAirPlaneMode";
                case 44:
                    return "mute";
                case 45:
                    return "isBatteryLow";
                case 46:
                    return "setFMIntenna";
                case 47:
                    return "setSoftmute";
                case 48:
                    return "getSoftMuteMode";
                case 49:
                    return "setInternetStreamingMode";
                case 50:
                    return "setIntegerTunningParameter";
                case 51:
                    return "getIntegerTunningParameter";
                case 52:
                    return "setLongTunningParameter";
                case 53:
                    return "getLongTunningParameter";
                case 54:
                    return "setStringTunningParameter";
                case 55:
                    return "getStringTunningParameter";
                case 56:
                    return "isDeviceSpeakerEnabled";
                default:
                    return null;
            }
        }

        @Override // android.p007os.Binder
        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.p007os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            boolean _arg0 = false;
            switch (code) {
                case 10088:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg10088 = data.readInt();
                    boolean _result10088 = modSamsungSetRadioOutputPath(_arg10088);
                    reply.writeNoException();
                    reply.writeInt(_result10088 ? 1 : 0);
                    return true;
                case 10089:
                    data.enforceInterface(DESCRIPTOR);
                    int _result10089 = modSamsungGetRadioOutputPath();
                    reply.writeNoException();
                    reply.writeInt(_result10089);
                    return true;
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    setListener(IFMEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    removeListener(IFMEventListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    tune(data.readLong());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    boolean on = on();
                    reply.writeNoException();
                    reply.writeInt(on ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    boolean on_in_testmode = on_in_testmode();
                    reply.writeNoException();
                    reply.writeInt(on_in_testmode ? 1 : 0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    boolean off = off();
                    reply.writeNoException();
                    reply.writeInt(off ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isOn = isOn();
                    reply.writeNoException();
                    reply.writeInt(isOn ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    long _result = seekUp();
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    long _result2 = seekDown();
                    reply.writeNoException();
                    reply.writeLong(_result2);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    cancelSeek();
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    long _result3 = getCurrentChannel();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    scan();
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    boolean cancelScan = cancelScan();
                    reply.writeNoException();
                    reply.writeInt(cancelScan ? 1 : 0);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isScanning = isScanning();
                    reply.writeNoException();
                    reply.writeInt(isScanning ? 1 : 0);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isSeeking = isSeeking();
                    reply.writeNoException();
                    reply.writeInt(isSeeking ? 1 : 0);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    long _result4 = searchDown();
                    reply.writeNoException();
                    reply.writeLong(_result4);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    long _result5 = searchUp();
                    reply.writeNoException();
                    reply.writeLong(_result5);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    long _result6 = searchAll();
                    reply.writeNoException();
                    reply.writeLong(_result6);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    long _result7 = getPlayedFreq();
                    reply.writeNoException();
                    reply.writeLong(_result7);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    enableRDS();
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface(DESCRIPTOR);
                    disableRDS();
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface(DESCRIPTOR);
                    enableDNS();
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface(DESCRIPTOR);
                    disableDNS();
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isDNSEnable = isDNSEnable();
                    reply.writeNoException();
                    reply.writeInt(isDNSEnable ? 1 : 0);
                    return true;
                case 25:
                    data.enforceInterface(DESCRIPTOR);
                    enableAF();
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface(DESCRIPTOR);
                    disableAF();
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface(DESCRIPTOR);
                    setBand(data.readInt());
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface(DESCRIPTOR);
                    setChannelSpacing(data.readInt());
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface(DESCRIPTOR);
                    int _result8 = isBusy();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 30:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isRDSEnable = isRDSEnable();
                    reply.writeNoException();
                    reply.writeInt(isRDSEnable ? 1 : 0);
                    return true;
                case 31:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isAFEnable = isAFEnable();
                    reply.writeNoException();
                    reply.writeInt(isAFEnable ? 1 : 0);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    cancelAFSwitching();
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _result9 = getLastScanResult();
                    reply.writeNoException();
                    reply.writeLongArray(_result9);
                    return true;
                case 34:
                    data.enforceInterface(DESCRIPTOR);
                    setStereo();
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface(DESCRIPTOR);
                    setMono();
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface(DESCRIPTOR);
                    setVolume(data.readLong());
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface(DESCRIPTOR);
                    long _result10 = getVolume();
                    reply.writeNoException();
                    reply.writeLong(_result10);
                    return true;
                case 38:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isHeadsetPlugged = isHeadsetPlugged();
                    reply.writeNoException();
                    reply.writeInt(isHeadsetPlugged ? 1 : 0);
                    return true;
                case 39:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isTvOutPlugged = isTvOutPlugged();
                    reply.writeNoException();
                    reply.writeInt(isTvOutPlugged ? 1 : 0);
                    return true;
                case 40:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setSpeakerOn(_arg0);
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setRecordMode(_arg0);
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface(DESCRIPTOR);
                    long _result11 = getMaxVolume();
                    reply.writeNoException();
                    reply.writeLong(_result11);
                    return true;
                case 43:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isAirPlaneMode = isAirPlaneMode();
                    reply.writeNoException();
                    reply.writeInt(isAirPlaneMode ? 1 : 0);
                    return true;
                case 44:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    mute(_arg0);
                    reply.writeNoException();
                    return true;
                case 45:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isBatteryLow = isBatteryLow();
                    reply.writeNoException();
                    reply.writeInt(isBatteryLow ? 1 : 0);
                    return true;
                case 46:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setFMIntenna(_arg0);
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setSoftmute(_arg0);
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface(DESCRIPTOR);
                    boolean softMuteMode = getSoftMuteMode();
                    reply.writeNoException();
                    reply.writeInt(softMuteMode ? 1 : 0);
                    return true;
                case 49:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    }
                    setInternetStreamingMode(_arg0);
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg02 = data.readString();
                    int _arg1 = data.readInt();
                    setIntegerTunningParameter(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg03 = data.readString();
                    int _arg12 = data.readInt();
                    int _result12 = getIntegerTunningParameter(_arg03, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 52:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg04 = data.readString();
                    long _arg13 = data.readLong();
                    setLongTunningParameter(_arg04, _arg13);
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg05 = data.readString();
                    long _arg14 = data.readLong();
                    long _result13 = getLongTunningParameter(_arg05, _arg14);
                    reply.writeNoException();
                    reply.writeLong(_result13);
                    return true;
                case 54:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg06 = data.readString();
                    String _arg15 = data.readString();
                    setStringTunningParameter(_arg06, _arg15);
                    reply.writeNoException();
                    return true;
                case 55:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg07 = data.readString();
                    String _arg16 = data.readString();
                    String _result14 = getStringTunningParameter(_arg07, _arg16);
                    reply.writeNoException();
                    reply.writeString(_result14);
                    return true;
                case 56:
                    data.enforceInterface(DESCRIPTOR);
                    boolean isDeviceSpeakerEnabled = isDeviceSpeakerEnabled();
                    reply.writeNoException();
                    reply.writeInt(isDeviceSpeakerEnabled ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static class Proxy implements IFMPlayer {
            public static IFMPlayer sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.p007os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setListener(IFMEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void removeListener(IFMEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeListener(listener);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean modSamsungSetRadioOutputPath(int path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(path);
                    boolean _status = this.mRemote.transact(10088, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().modSamsungSetRadioOutputPath(path);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public int modSamsungGetRadioOutputPath() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(10089, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().modSamsungGetRadioOutputPath();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void tune(long freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(freq);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().tune(freq);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            /* renamed from: on */
            public boolean on() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().on();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean on_in_testmode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().on_in_testmode();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean off() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().off();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isOn() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isOn();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long seekUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().seekUp();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long seekDown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().seekDown();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void cancelSeek() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelSeek();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long getCurrentChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentChannel();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void scan() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().scan();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean cancelScan() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelScan();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isScanning() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isScanning();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isSeeking() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSeeking();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long searchDown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().searchDown();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long searchUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().searchUp();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long searchAll() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().searchAll();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long getPlayedFreq() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayedFreq();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void enableRDS() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enableRDS();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void disableRDS() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(21, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().disableRDS();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void enableDNS() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(22, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enableDNS();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void disableDNS() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(23, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().disableDNS();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isDNSEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(24, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDNSEnable();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void enableAF() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(25, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enableAF();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void disableAF() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(26, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().disableAF();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setBand(int band) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    boolean _status = this.mRemote.transact(27, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setBand(band);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setChannelSpacing(int spacing) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(spacing);
                    boolean _status = this.mRemote.transact(28, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setChannelSpacing(spacing);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public int isBusy() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(29, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBusy();
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isRDSEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(30, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isRDSEnable();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isAFEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(31, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isAFEnable();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void cancelAFSwitching() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(32, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAFSwitching();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long[] getLastScanResult() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(33, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLastScanResult();
                    }
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setStereo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(34, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setStereo();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setMono() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(35, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMono();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setVolume(long val) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(val);
                    boolean _status = this.mRemote.transact(36, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setVolume(val);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long getVolume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(37, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVolume();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isHeadsetPlugged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(38, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isHeadsetPlugged();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isTvOutPlugged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(39, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isTvOutPlugged();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setSpeakerOn(boolean bSpeakerOn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bSpeakerOn ? 1 : 0);
                    boolean _status = this.mRemote.transact(40, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSpeakerOn(bSpeakerOn);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setRecordMode(boolean isRecord) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(isRecord ? 1 : 0);
                    boolean _status = this.mRemote.transact(41, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRecordMode(isRecord);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long getMaxVolume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(42, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMaxVolume();
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isAirPlaneMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(43, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isAirPlaneMode();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void mute(boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = this.mRemote.transact(44, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().mute(value);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isBatteryLow() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(45, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBatteryLow();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setFMIntenna(boolean setFMIntenna) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(setFMIntenna ? 1 : 0);
                    boolean _status = this.mRemote.transact(46, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setFMIntenna(setFMIntenna);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setSoftmute(boolean state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(state ? 1 : 0);
                    boolean _status = this.mRemote.transact(47, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSoftmute(state);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean getSoftMuteMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(48, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSoftMuteMode();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setInternetStreamingMode(boolean mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode ? 1 : 0);
                    boolean _status = this.mRemote.transact(49, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setInternetStreamingMode(mode);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setIntegerTunningParameter(String parameterName, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeInt(value);
                    boolean _status = this.mRemote.transact(50, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIntegerTunningParameter(parameterName, value);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public int getIntegerTunningParameter(String parameterName, int defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeInt(defaultValue);
                    boolean _status = this.mRemote.transact(51, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIntegerTunningParameter(parameterName, defaultValue);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setLongTunningParameter(String parameterName, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeLong(value);
                    boolean _status = this.mRemote.transact(52, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLongTunningParameter(parameterName, value);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public long getLongTunningParameter(String parameterName, long defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeLong(defaultValue);
                    boolean _status = this.mRemote.transact(53, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLongTunningParameter(parameterName, defaultValue);
                    }
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public void setStringTunningParameter(String parameterName, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeString(value);
                    boolean _status = this.mRemote.transact(54, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setStringTunningParameter(parameterName, value);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public String getStringTunningParameter(String parameterName, String defaultValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(parameterName);
                    _data.writeString(defaultValue);
                    boolean _status = this.mRemote.transact(55, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStringTunningParameter(parameterName, defaultValue);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMPlayer
            public boolean isDeviceSpeakerEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    boolean _status = this.mRemote.transact(56, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDeviceSpeakerEnabled();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _status2 = z;
                    return _status2;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFMPlayer impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IFMPlayer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}