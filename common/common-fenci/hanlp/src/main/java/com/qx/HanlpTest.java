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
 * Package:com.qx
 * Project:qxdatacloud
 * 功能：动态增删词性测试
 */


public class HanlpTest {

    public static void main(String[] args) {
        String text="你咳嗽好脊柱四肢，欢迎使用HanLP汉语处理包爱滋病毒抗体！";
        //使用默认词性
        List<Term> segment1 = HanLP.segment(text);
        System.out.println("默认自定义词性："+segment1);
        //动态增加词性
        Segment segment = HanLP.newSegment().enableCustomDictionaryForcing(true).enableNameRecognize(false).enableTranslatedNameRecognize(false);
        Nature pcNature = Nature.create("keshou");
        LexiconUtility.setAttribute("你咳嗽", pcNature);
        List<Term> seg1 = segment.seg(text);
        System.out.println("动态增加词性"+seg1);
//       取消词性
        CustomDictionary.remove("你咳嗽");
        List<Term> seg = segment.seg(text);
        System.out.println("取消词性"+seg);

    }

}