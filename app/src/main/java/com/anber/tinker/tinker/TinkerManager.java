package com.anber.tinker.tinker;

import android.content.Context;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;


/**
 * Created by renzhiqiang on 17/4/27.
 *
 * @functon 对Tinker的所有api做一层封装
 */
public class TinkerManager {

    private static boolean isInstalled = false;

    private static ApplicationLike mAppLike;
    private static CustomPatchListener mPatchListener;


    /**
     * 完成Tinker的初始化
     *
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }
        mPatchListener = new CustomPatchListener(getApplicationContext());

        LoadReporter loadReporter = new DefaultLoadReporter(getApplicationContext());
        PatchReporter patchReporter = new DefaultPatchReporter(getApplicationContext());

        AbstractPatch upgradePatchProcessor = new UpgradePatch();
        TinkerInstaller.install(applicationLike,
                loadReporter,
                patchReporter,
                mPatchListener,
                CustomResultService.class,
                upgradePatchProcessor); //完成Tinker初始化

        isInstalled = true;
    }

    //完成Patch文件的加载
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    //通过ApplicationLike获取Context
    private static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
