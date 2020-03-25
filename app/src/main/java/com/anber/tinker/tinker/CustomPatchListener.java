package com.anber.tinker.tinker;

import android.content.Context;

import com.anber.tinker.util.Utils;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author: vision
 * @function: 1.较验patch文件是否合法  2.启动Service去安装patch文件
 * @date: 17/5/11
 */
public class CustomPatchListener extends DefaultPatchListener {

    private String currentMD5;

    public void setCurrentMD5(String md5Value) {

        this.currentMD5 = md5Value;
    }

    public CustomPatchListener(Context context) {
        super(context);
    }

    @Override
    protected int patchCheck(String path,String patchMd5) {
        //此处可以对下载的apk文件进行校验
//        if (!Utils.isFileMD5Matched(path, currentMD5)) {
//
//            return ShareConstants.ERROR_PATCH_DISABLE;
//        }


        return super.patchCheck(path,patchMd5);
    }
}
