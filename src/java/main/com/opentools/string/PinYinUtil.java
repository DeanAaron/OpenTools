package com.opentools.string;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Aaron on 2016/7/20.
 */
public class PinYinUtil {

    public static String toPinYinUpperCase(String src) throws Exception {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //全部大写
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        //不携带音标
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
        try {
            String s = PinyinHelper.toHanYuPinyinString(src, format, "", true);
            return s;
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            throw new Exception("无法转换拼音");
        }
    }

    private PinYinUtil(){}
}