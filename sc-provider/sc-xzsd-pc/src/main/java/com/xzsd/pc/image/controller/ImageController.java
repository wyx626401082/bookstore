package com.xzsd.pc.image.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.image.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 图片上传
 * @author WangZebin
 * @date 2020-04-16
 */
@RestController
@RequestMapping("/image")
public class ImageController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ImageController.class);

    @Resource
    ImageService imageService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     * @author WangZebin
     * @date 2020-04-16
     */
    @PostMapping("/uploadImage")
    public AppResponse uploadImage(MultipartFile imageFile) {
        try{
            AppResponse appResponse = imageService.uploadImage(imageFile);
            return appResponse;
        } catch (Exception e) {
            logger.error("图片上传失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
