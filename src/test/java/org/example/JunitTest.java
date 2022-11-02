package org.example;

import org.example.test.service.Word;
import org.example.test.service.WordImpl;
import org.example.util.DynamicProxyUtil;
import org.junit.Test;

import java.util.List;

public class JunitTest {

    private static Word word;
    /**
     * 测试junit环境
     */
    @Test
    public void test(){
        String content = "京东的刘强东在肯德基吃啃得起";

        System.out.println("动态代理执行测试start...");
        word = createDynamicProxy();
        List<String> keyWordList = word.findKeyWord(content);
        System.out.println("动态代理执行测试end...");
    }

    /**
     * 添加单词到单词薄
     * @return
     */
    private static Word createWord() {
        Word wordTmp = new WordImpl();
        wordTmp.addWord("啃得起");
        wordTmp.addWord("京东");
        wordTmp.addWord("拼多多");
        wordTmp.addWord("马云");
        return wordTmp;
    }

    private static Word createDynamicProxy() {
        Word word = createWord();
        return DynamicProxyUtil.getProxy(Word.class, word);
    }

}
