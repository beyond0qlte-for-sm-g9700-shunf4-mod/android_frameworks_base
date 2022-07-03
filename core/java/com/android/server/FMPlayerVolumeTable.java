package com.android.server;

import android.os.SystemProperties;
import com.samsung.android.feature.SemFloatingFeature;

/* loaded from: classes4.dex */
public class FMPlayerVolumeTable {
    private static String mDefaultVolumeTable = "0,2,3,4,5,7,10,14,18,25,34,45,61,82,111,150";
    private static int[] mVolumeTable;
    private String VolumePropertyname = "service.brcm.fm.volumetable";

    public FMPlayerVolumeTable() {
        String testVol = getPropertyVolumeTable();
        if ("".equals(testVol)) {
            String volumeFromFeature = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_FMRADIO_CONFIG_BROADCOM_VOLUME_TABLE");
            if (!"0".equals(volumeFromFeature)) {
                writeVolumeTable(volumeFromFeature, false);
                return;
            } else {
                writeVolumeTable(mDefaultVolumeTable, false);
                return;
            }
        }
        writeVolumeTable(testVol, true);
    }

    private String getPropertyVolumeTable() {
        String VolumeTable = SystemProperties.get(this.VolumePropertyname);
        return VolumeTable;
    }

    private void writeVolumeTable(String table, boolean hasProperty) {
        if (!hasProperty) {
            SystemProperties.set(this.VolumePropertyname, table);
        }
        String[] volume_table = table.split(",");
        if (volume_table.length != 16) {
            return;
        }
        mVolumeTable = new int[16];
        for (int i = 0; i < 16; i++) {
            mVolumeTable[i] = Integer.parseInt(volume_table[i], 10);
        }
    }

    public int readVolume(int vol) {
        int[] iArr = mVolumeTable;
        if (iArr == null) {
            return 0;
        }
        return iArr[vol];
    }
}