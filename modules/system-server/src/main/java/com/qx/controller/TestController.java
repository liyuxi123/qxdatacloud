package com.qx.controller;
import com.hankcs.hanlp.seg.common.Term;
import com.qx.HanlpTestService;
import com.qx.service.FeignService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;



/**
 * Author: liYuXi
 * Date: 11/26/24
 * Time: 9:41 AM
 * Package:com.qx.controller
 * Project:qxdatacloud
 * 功能：
 */
@RestController
@RefreshScope //支持nacos的动态刷新
public class TestController
{
 @Value("${config.info}")
 private String info;
 @GetMapping("/config/info")
 public String getConfigInfo()
 {
  return info +"--test";
 }


 @Resource
 private FeignService feignService;
 @GetMapping("/openfeign/info")
 public String getOpenfeignInfo(){
  feignService.getOpenfeignInfo();
  return feignService.getOpenfeignInfo();
 }


 @GetMapping("/common/hanlp")
 public Object getHanlp(){
  String text = "你咳嗽好脊柱四肢，欢迎使用HanLP汉语处理包爱滋病毒抗体！";

  // 使用默认分词
  List<Term> defaultSeg = HanlpTestService.segmentWithDefault(text);
  System.out.println("默认分词结果: " + defaultSeg);

  // 使用自定义词性分词
  List<Term> customSeg = HanlpTestService.segmentWithCustomNature(text, "你咳嗽", "keshou");
  System.out.println("动态增加词性分词结果: " + customSeg);

  // 移除自定义词性后重新分词
  List<Term> afterRemoveSeg = HanlpTestService.segmentAfterRemovingCustomNature(text, "你咳嗽");
  System.out.println("移除自定义词性分词结果: " + afterRemoveSeg);
  LinkedHashMap<String, Object > HanlpResponse  =new LinkedHashMap<>();
  HanlpResponse.put("分词句子",text);
  HanlpResponse.put("动态设置词性","你咳嗽/keshou");
  HanlpResponse.put("默认分词结果",defaultSeg.toString());
  HanlpResponse.put("动态设置词性分词结果",customSeg.toString());
  HanlpResponse.put("移除自定义词性分词结果",afterRemoveSeg.toString());

  return HanlpResponse;
 }



 @GetMapping("/Hardware/info")
 public Object getHardwareInfo (){
  return null;

 }

}
