package com.samsung.android.media.fmradio.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IFMEventListener extends IInterface {
    void onAlternateFrequencyReceived(long j) throws RemoteException;

    void onAlternateFrequencyStarted() throws RemoteException;

    void onChannelFound(long j) throws RemoteException;

    void onHeadsetConnected() throws RemoteException;

    void onHeadsetDisconnected() throws RemoteException;

    void onProgrammeIdentificationExtendedCountryCodesReceived(int i, int i2) throws RemoteException;

    void onRadioDataSystemDisabled() throws RemoteException;

    void onRadioDataSystemEnabled() throws RemoteException;

    void onRadioDataSystemReceived(long j, String str, String str2) throws RemoteException;

    void onRadioDisabled(int i) throws RemoteException;

    void onRadioEnabled() throws RemoteException;

    void onRadioTextPlusReceived(int i, int i2, int i3, int i4, int i5, int i6) throws RemoteException;

    void onRecordingFinished() throws RemoteException;

    void onScanFinished(long[] jArr) throws RemoteException;

    void onScanStarted() throws RemoteException;

    void onScanStopped(long[] jArr) throws RemoteException;

    void onTuned(long j) throws RemoteException;

    void onVolumeLocked() throws RemoteException;

    /* loaded from: classes4.dex */
    public static class Default implements IFMEventListener {
        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioEnabled() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioDisabled(int reasonCode) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onChannelFound(long freq) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onScanStarted() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onScanStopped(long[] freqArray) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onScanFinished(long[] freqArray) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onTuned(long freq) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onHeadsetConnected() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onHeadsetDisconnected() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioDataSystemReceived(long freq, String channelName, String radioText) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioTextPlusReceived(int contentType1, int startPos1, int additionalLen1, int contentType2, int startPos2, int additionalLen2) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioDataSystemEnabled() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRadioDataSystemDisabled() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onAlternateFrequencyStarted() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onAlternateFrequencyReceived(long freq) throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onVolumeLocked() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onRecordingFinished() throws RemoteException {
        }

        @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
        public void onProgrammeIdentificationExtendedCountryCodesReceived(int pi, int ecc) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IFMEventListener {
        private static final String DESCRIPTOR = "com.samsung.android.media.fmradio.internal.IFMEventListener";
        static final int TRANSACTION_onAlternateFrequencyReceived = 15;
        static final int TRANSACTION_onAlternateFrequencyStarted = 14;
        static final int TRANSACTION_onChannelFound = 3;
        static final int TRANSACTION_onHeadsetConnected = 8;
        static final int TRANSACTION_onHeadsetDisconnected = 9;
        static final int TRANSACTION_onProgrammeIdentificationExtendedCountryCodesReceived = 18;
        static final int TRANSACTION_onRadioDataSystemDisabled = 13;
        static final int TRANSACTION_onRadioDataSystemEnabled = 12;
        static final int TRANSACTION_onRadioDataSystemReceived = 10;
        static final int TRANSACTION_onRadioDisabled = 2;
        static final int TRANSACTION_onRadioEnabled = 1;
        static final int TRANSACTION_onRadioTextPlusReceived = 11;
        static final int TRANSACTION_onRecordingFinished = 17;
        static final int TRANSACTION_onScanFinished = 6;
        static final int TRANSACTION_onScanStarted = 4;
        static final int TRANSACTION_onScanStopped = 5;
        static final int TRANSACTION_onTuned = 7;
        static final int TRANSACTION_onVolumeLocked = 16;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFMEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IFMEventListener)) {
                return (IFMEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "onRadioEnabled";
                case 2:
                    return "onRadioDisabled";
                case 3:
                    return "onChannelFound";
                case 4:
                    return "onScanStarted";
                case 5:
                    return "onScanStopped";
                case 6:
                    return "onScanFinished";
                case 7:
                    return "onTuned";
                case 8:
                    return "onHeadsetConnected";
                case 9:
                    return "onHeadsetDisconnected";
                case 10:
                    return "onRadioDataSystemReceived";
                case 11:
                    return "onRadioTextPlusReceived";
                case 12:
                    return "onRadioDataSystemEnabled";
                case 13:
                    return "onRadioDataSystemDisabled";
                case 14:
                    return "onAlternateFrequencyStarted";
                case 15:
                    return "onAlternateFrequencyReceived";
                case 16:
                    return "onVolumeLocked";
                case 17:
                    return "onRecordingFinished";
                case 18:
                    return "onProgrammeIdentificationExtendedCountryCodesReceived";
                default:
                    return null;
            }
        }

        @Override // android.os.Binder
        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            long[] _arg0;
            long[] _arg02;
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioEnabled();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    onRadioDisabled(_arg03);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg04 = data.readLong();
                    onChannelFound(_arg04);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    onScanStarted();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0_length = data.readInt();
                    if (_arg0_length < 0) {
                        _arg0 = null;
                    } else {
                        _arg0 = new long[_arg0_length];
                    }
                    onScanStopped(_arg0);
                    reply.writeNoException();
                    reply.writeLongArray(_arg0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0_length2 = data.readInt();
                    if (_arg0_length2 < 0) {
                        _arg02 = null;
                    } else {
                        _arg02 = new long[_arg0_length2];
                    }
                    onScanFinished(_arg02);
                    reply.writeNoException();
                    reply.writeLongArray(_arg02);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg05 = data.readLong();
                    onTuned(_arg05);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    onHeadsetConnected();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    onHeadsetDisconnected();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg06 = data.readLong();
                    String _arg1 = data.readString();
                    String _arg2 = data.readString();
                    onRadioDataSystemReceived(_arg06, _arg1, _arg2);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    int _arg12 = data.readInt();
                    int _arg22 = data.readInt();
                    int _arg3 = data.readInt();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    onRadioTextPlusReceived(_arg07, _arg12, _arg22, _arg3, _arg4, _arg5);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioDataSystemEnabled();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioDataSystemDisabled();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    onAlternateFrequencyStarted();
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg08 = data.readLong();
                    onAlternateFrequencyReceived(_arg08);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    onVolumeLocked();
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    onRecordingFinished();
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    int _arg13 = data.readInt();
                    onProgrammeIdentificationExtendedCountryCodesReceived(_arg09, _arg13);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static class Proxy implements IFMEventListener {
            public static IFMEventListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRadioEnabled();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioDisabled(int reasonCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(reasonCode);
                    boolean _status = this.mRemote.transact(2, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRadioDisabled(reasonCode);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onChannelFound(long freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(freq);
                    boolean _status = this.mRemote.transact(3, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onChannelFound(freq);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onScanStarted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(4, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onScanStarted();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onScanStopped(long[] freqArray) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (freqArray == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(freqArray.length);
                    }
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onScanStopped(freqArray);
                        return;
                    }
                    _reply.readException();
                    _reply.readLongArray(freqArray);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onScanFinished(long[] freqArray) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (freqArray == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(freqArray.length);
                    }
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onScanFinished(freqArray);
                        return;
                    }
                    _reply.readException();
                    _reply.readLongArray(freqArray);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onTuned(long freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(freq);
                    boolean _status = this.mRemote.transact(7, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onTuned(freq);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onHeadsetConnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(8, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onHeadsetConnected();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onHeadsetDisconnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(9, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onHeadsetDisconnected();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioDataSystemReceived(long freq, String channelName, String radioText) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(freq);
                    _data.writeString(channelName);
                    _data.writeString(radioText);
                    boolean _status = this.mRemote.transact(10, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRadioDataSystemReceived(freq, channelName, radioText);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioTextPlusReceived(int contentType1, int startPos1, int additionalLen1, int contentType2, int startPos2, int additionalLen2) throws RemoteException {
                Throwable th;
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    _data.writeInt(contentType1);
                    try {
                        _data.writeInt(startPos1);
                        try {
                            _data.writeInt(additionalLen1);
                            try {
                                _data.writeInt(contentType2);
                            } catch (Throwable th3) {
                                th = th3;
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            _data.recycle();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(startPos2);
                        try {
                            _data.writeInt(additionalLen2);
                            try {
                                boolean _status = this.mRemote.transact(11, _data, null, 1);
                                if (!_status && Stub.getDefaultImpl() != null) {
                                    Stub.getDefaultImpl().onRadioTextPlusReceived(contentType1, startPos1, additionalLen1, contentType2, startPos2, additionalLen2);
                                    _data.recycle();
                                    return;
                                }
                                _data.recycle();
                            } catch (Throwable th6) {
                                th = th6;
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    _data.recycle();
                    throw new RemoteException("onRadioTextPlusReceived", th, true, true);
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioDataSystemEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(12, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRadioDataSystemEnabled();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRadioDataSystemDisabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(13, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRadioDataSystemDisabled();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onAlternateFrequencyStarted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(14, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAlternateFrequencyStarted();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onAlternateFrequencyReceived(long freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(freq);
                    boolean _status = this.mRemote.transact(15, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAlternateFrequencyReceived(freq);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onVolumeLocked() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(16, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVolumeLocked();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onRecordingFinished() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(17, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordingFinished();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.samsung.android.media.fmradio.internal.IFMEventListener
            public void onProgrammeIdentificationExtendedCountryCodesReceived(int pi, int ecc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pi);
                    _data.writeInt(ecc);
                    boolean _status = this.mRemote.transact(18, _data, null, 1);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onProgrammeIdentificationExtendedCountryCodesReceived(pi, ecc);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFMEventListener impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IFMEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}