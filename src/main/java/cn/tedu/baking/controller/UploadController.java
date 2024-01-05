package cn.tedu.baking.controller;

import cn.tedu.baking.response.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v1/")
public class UploadController {
    private String dirPath = "D:/file";

    @PostMapping("/upload")
    public JsonResult upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffix;
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("/yyyy/MM/dd/");
        String datePath = simpleDateFormat.format(new Date());
        File dirFile = new File(dirPath + datePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        file.transferTo(new File(dirPath + datePath + fileName));
        return JsonResult.ok(datePath + fileName);
    }

    @PostMapping("remove")
    public JsonResult remove (String url){
        new File(dirPath +url).delete();
        return JsonResult.ok();
    }

}
