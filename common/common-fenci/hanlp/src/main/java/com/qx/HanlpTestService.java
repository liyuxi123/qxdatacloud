package com.qx;



import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.utility.LexiconUtility;

import java.util.List;

/**
 * Author: liYuXi
 * Date: 12/3/24
 * Time: 11:05 AM
 * Package: com.qx
 * Project: qxdatacloud
 * 功能：动态增删词性测试工具类，供其他服务调用
 */
public class HanlpTestService {

    /**
     * 使用默认分词
     *
     * @param text 输入文本
     * @return 分词结果
     */
    public static List<Term> segmentWithDefault(String text) {
        return HanLP.segment(text);
    }

    /**
     * 动态增加自定义词性进行分词
     *
     * @param text     输入文本
     * @param term     自定义词
     * @param nature   自定义词性
     * @return 分词结果
     */
    public static List<Term> segmentWithCustomNature(String text, String term, String nature) {
        // 动态增加词性
        Segment segment = HanLP.newSegment().enableCustomDictionaryForcing(true);
        Nature customNature = Nature.create(nature);
        LexiconUtility.setAttribute(term, customNature);

        return segment.seg(text);
    }

    /**
     * 动态移除自定义词性后重新分词
     *
     * @param text 输入文本
     * @param term 自定义词
     * @return 分词结果
     */
    public static List<Term> segmentAfterRemovingCustomNature(String text, String term) {
        // 移除词性
        CustomDictionary.remove(term);
        Segment segment = HanLP.newSegment().enableCustomDictionaryForcing(true);
        return segment.seg(text);
    }

    public static void main(String[] args) {
        String text = "你咳嗽好脊柱四肢，欢迎使用HanLP汉语处理包爱滋病毒抗体！";

        // 默认分词
        List<Term> defaultSeg = segmentWithDefault(text);
        System.out.println("默认分词结果: " + defaultSeg);

        // 增加自定义词性
        List<Term> customSeg = segmentWithCustomNature(text, "你咳嗽", "keshou");
        System.out.println("动态增加词性分词结果: " + customSeg);

        // 移除自定义词性
        List<Term> afterRemoveSeg = segmentAfterRemovingCustomNature(text, "你咳嗽");
        System.out.println("移除自定义词性分词结果: " + afterRemoveSeg);
    }
}