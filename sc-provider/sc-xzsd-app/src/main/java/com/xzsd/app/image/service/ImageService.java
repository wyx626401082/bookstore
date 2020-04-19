package com.xzsd.app.image.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.utils.QCloudCosUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * app图片上传实现类
 * @author WangZeBin
 * @date 2020-04-19
 */
@Service
public class ImageService {
    @Resource
    private QCloudCosUtils qCloudCosUtils;

    /**
     * 上传图片（MultipartFile类文件）
     * @param imageFile
     * @return
     * @author WangZebin
     * @date 2020-04-19
     */
    public AppResponse uploadImage(MultipartFile imageFile) {
        if(null == imageFile | "".equals(imageFile) ){
            return AppResponse.bizError("传入参数为空，请重试！");
        }
        String url = qCloudCosUtils.upload(imageFile);
        if("".equals(url) | null == url){
            return AppResponse.bizError("上传失败，请重试！");
        }
        return AppResponse.success("上传成功",url);
    }

    public AppResponse uploadImage(File imageFile) {
        if(null == imageFile | "".equals(imageFile) ){
            return AppResponse.bizError("传入参数为空，请重试！");
        }
        String url = qCloudCosUtils.upload(imageFile);
        if("".equals(url) | null == url){
            return AppResponse.bizError("上传失败，请重试！");
        }
        return AppResponse.success("上传成功",url);
    }
}
