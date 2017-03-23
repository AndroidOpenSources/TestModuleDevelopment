package com.help.reward.shop.base;


import android.os.Build;

import com.help.reward.shop.base.PathResolver;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

/**
 * Created by richsjeson on 17/3/23.
 */

public class RobolectricTestRunner extends RobolectricGradleTestRunner {

    private static final int TARGET_SDK_VERSION = Build.VERSION_CODES.LOLLIPOP;

    private static final int MIN_SDK_VERSION = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;

    public RobolectricTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
    @Override
    protected AndroidManifest getAppManifest(Config config) {

        final String manifestPath = PathResolver.resolveAndroidManifestPath();
        final String resourcesPath = PathResolver.resolveResPath();
        final String assetsPath = PathResolver.resolveAssetsPath();

        AndroidManifest manifest = new AndroidManifest(
                Fs.fileFromPath(manifestPath),
                Fs.fileFromPath(resourcesPath),
                Fs.fileFromPath(assetsPath)) {
            @Override
            public int getTargetSdkVersion() {
                return TARGET_SDK_VERSION;
            }

            @Override
            public int getMinSdkVersion() {
                return MIN_SDK_VERSION;
            }
        };

        return manifest;
    }



}
